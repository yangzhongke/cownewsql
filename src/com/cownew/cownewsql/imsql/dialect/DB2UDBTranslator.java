package com.cownew.cownewsql.imsql.dialect;

import java.util.List;

import com.cownew.cownewsql.ast.node.enumdef.BinaryOprtTypeEnum;
import com.cownew.cownewsql.ast.node.expr.QueryTopInfo;
import com.cownew.cownewsql.ast.node.expr.SqlBinaryOpExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlDateTimeExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlHexExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlQueryExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlBlobTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlCharTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlClobTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlDataTypeExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlDateTimeTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlDecimalTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlIntTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlNCharTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlNClobTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlNVarcharTypeDefExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlVarcharTypeDefExprAST;
import com.cownew.cownewsql.ast.node.item.SqlTableSourceBaseAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowTableColumnsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowTablesStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlDropIndexStmtAST;
import com.cownew.cownewsql.imsql.IMethodTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;
import com.cownew.cownewsql.imsql.dialect.method.DB2UDBMethodTranslator;

public class DB2UDBTranslator extends BaseSQLTranslator
{
	private IMethodTranslator methodTranslator;

	public DB2UDBTranslator()
	{
		super();
		methodTranslator = new DB2UDBMethodTranslator(this);
	}

	@Override
	protected String translateExpr(SqlDateTimeExprAST exprAST)
	{
		StringBuffer sb = new StringBuffer();
		String text = exprAST.getTextValue();
		if (exprAST.hasTimePart() == false)
		{
			text = text + " 00:00:00";
		}
		sb.append("'").append(text).append("'");
		return sb.toString();
	}

	protected String translateExpr(SqlHexExprAST exprAST)
	{
		String value = exprAST.getTextValue();
		// 去掉开始的0x
		value = value.substring(2);
		StringBuffer sb = new StringBuffer();
		// int(X'2B')
		sb.append("ASCII(X'");

		// int(X'3')or int(X'333') is invalid,
		// but int(X'03')or int(X'0333') is valid
		if (value.length() % 2 == 1)
		{
			sb.append("0");
		}
		sb.append(value).append("')");
		return sb.toString();
	}

	@Override
	public IMethodTranslator getMethodTranslator()
	{
		return methodTranslator;
	}

	protected String translateExpr(SqlBinaryOpExprAST exprAST)
			throws TranslateException
	{
		StringBuffer sql = new StringBuffer();

		BinaryOprtTypeEnum operator = exprAST.getOperator();
		// add the LP
		boolean isStart;
		if (this.upperLayerPriority == -1)
		{
			isStart = true;
			this.upperLayerPriority = operator.getPriority();
		} else
			isStart = false;

		SqlExprAST leftExpr = exprAST.getLeftExpr();
		String left = translateExpr(leftExpr);
		if (leftExpr instanceof SqlQueryExprAST)
		{
			left = "(" + left + ")";
		}

		SqlExprAST rightExpr = exprAST.getRightExpr();
		String right = translateExpr(rightExpr);
		if (rightExpr instanceof SqlQueryExprAST)
		{
			right = "(" + right + ")";
		}

		boolean isAddP = this.addP(operator);
		if (isAddP)
			sql.append("(");

		if (operator == BinaryOprtTypeEnum.CONCATSTRING)
		{
			sql.append("CONCAT(");
			sql.append(left);
			sql.append(",");
			sql.append(right);
			sql.append(")");
		} else
		{
			sql.append(left);
			sql.append(translateBinOprt(operator));
			sql.append(right);
		}

		this.upperLayerPriority = operator.getPriority();
		// add the RP
		if (isAddP)
			sql.append(")");
		if (isStart)
			this.upperLayerPriority = -1;
		return sql.toString();
	}

	protected String translateExpr(SqlQueryExprAST subQuery)
			throws TranslateException
	{
		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("SELECT ");
		if (subQuery.isDistinct())
		{
			sbSQL.append(" DISTINCT ");
		}

		sbSQL.append(translateSelectList(subQuery.getSelectList()));

		List<SqlTableSourceBaseAST> tableSrcList = subQuery
				.getTableSourceList();

		// 如果tableSrcList.size()小于0，说明没有from语句
		if (tableSrcList != null && tableSrcList.size() > 0)
		{
			sbSQL.append(translateTableSourceList(tableSrcList));
		} else
		{
			sbSQL.append(" FROM SYSIBM.SYSDUMMY1");
		}

		SqlExprAST whereClause = subQuery.getWhereClause();
		if (whereClause != null)
		{
			sbSQL.append(" WHERE ");
			sbSQL.append(translateExpr(whereClause));
		}

		sbSQL.append(translateGroupByList(subQuery.getGroupByList()));

		sbSQL.append(translateHaving(subQuery.getHaving()));

		sbSQL.append(translateOrderByList(subQuery.getOrderByList()));

		SqlQueryExprAST unionQuery = subQuery.getUnionSqlQueryExprAST();
		if (unionQuery != null)
		{
			if (subQuery.isUnionAll())
			{
				sbSQL.append(" UNION ALL ").append(translateExpr(unionQuery));
			} else
			{
				sbSQL.append(" UNION ").append(translateExpr(unionQuery));
			}

		}

		QueryTopInfo top = subQuery.getTop();

		if (top != null)
		{
			sbSQL.append(" FETCH FIRST ");
			sbSQL.append(top.getValue());
			sbSQL.append(" ROWS ONLY");
		}

		return sbSQL.toString();

	}

	protected String translateDataType(SqlDataTypeExprAST dataType)
	{
		if (dataType instanceof SqlVarcharTypeDefExprAST)
		{
			SqlVarcharTypeDefExprAST ast = (SqlVarcharTypeDefExprAST) dataType;
			return "VARCHAR(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlIntTypeDefExprAST)
		{
			return "INT";
		} else if (dataType instanceof SqlDecimalTypeDefExprAST)
		{
			SqlDecimalTypeDefExprAST ast = (SqlDecimalTypeDefExprAST) dataType;
			StringBuffer sb = new StringBuffer();
			sb.append("DECIMAL");
			if (ast.getLength() == SqlDecimalTypeDefExprAST.NOTDEFINE)
			{
				return sb.toString();
			}
			sb.append("(").append(ast.getLength());
			if (ast.getPrecision() == SqlDecimalTypeDefExprAST.NOTDEFINE)
			{
				sb.append(")");
				return sb.toString();
			}
			sb.append(",").append(ast.getPrecision()).append(")");
			return sb.toString();
		} else if (dataType instanceof SqlDateTimeTypeDefExprAST)
		{
			return "DATE";
		} else if (dataType instanceof SqlClobTypeDefExprAST)
		{
			return "CLOB";
		} else if (dataType instanceof SqlBlobTypeDefExprAST)
		{
			return "BLOB";
		} else if (dataType instanceof SqlCharTypeDefExprAST)
		{
			SqlCharTypeDefExprAST ast = (SqlCharTypeDefExprAST) dataType;
			return "CHAR(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNCharTypeDefExprAST)
		{
			SqlNCharTypeDefExprAST ast = (SqlNCharTypeDefExprAST) dataType;
			return "NCHAR(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNVarcharTypeDefExprAST)
		{
			SqlNVarcharTypeDefExprAST ast = (SqlNVarcharTypeDefExprAST) dataType;
			return "GRAPHIC(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNClobTypeDefExprAST)
		{
			return "CLOB";
		} else
		{
			throw new IllegalArgumentException("unknown datatype:"
					+ dataType.getClass());
		}
	}

	public String translateStmt(SqlDropIndexStmtAST stmtAST)
			throws TranslateException
	{
		String idxname = stmtAST.getIndexName();
		return "DROP INDEX " + idxname;
	}

	public String translateStmt(SqlShowTablesStmtAST stmtAST)
			throws TranslateException
	{
		String sc = stmtAST.getSchema();
		String sql = "SELECT TABNAME FROM syscat.tables where  TYPE='T'";
		if (sc != null && sc.length() > 0)
		{
			sql += " and TABSCHEMA='" + sc + "'";
		}
		return sql;
	}
	
	public String translateStmt(SqlShowTableColumnsStmtAST stmtAST)
	throws TranslateException
	{
		String tableName = stmtAST.getTableName().toUpperCase();
		StringBuffer sb = new StringBuffer();
		sb.append("select COLNAME as COLUMN_NAME, TYPENAME as DATA_TYPE,DEFAULT as DATA_DEFAULT,NULLS as NULLABLE\n");
		sb.append("from syscat.columns where TABNAME='").append(tableName).append("'");
		return sb.toString();
	}
}
