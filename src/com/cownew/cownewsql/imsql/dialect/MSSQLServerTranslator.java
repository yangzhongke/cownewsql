package com.cownew.cownewsql.imsql.dialect;

import java.util.List;

import com.cownew.cownewsql.ast.node.enumdef.BinaryOprtTypeEnum;
import com.cownew.cownewsql.ast.node.expr.QueryTopInfo;
import com.cownew.cownewsql.ast.node.expr.SqlDateTimeExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
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
import com.cownew.cownewsql.imsql.dialect.method.MSSQLMethodTranslator;

public class MSSQLServerTranslator extends BaseSQLTranslator
{
	private IMethodTranslator methodTranslator;

	public MSSQLServerTranslator()
	{
		super();
		methodTranslator = new MSSQLMethodTranslator(this);
	}

	@Override
	protected String translateExpr(SqlDateTimeExprAST exprAST)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("'").append(exprAST.getTextValue()).append("'");
		return sb.toString();
	}

	@Override
	public IMethodTranslator getMethodTranslator()
	{
		return methodTranslator;
	}

	protected String translateBinOprt(BinaryOprtTypeEnum operator)
			throws TranslateException
	{
		if (operator == BinaryOprtTypeEnum.CONCATSTRING)
		{
			return "+";
		}
		return super.translateBinOprt(operator);
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

		QueryTopInfo top = subQuery.getTop();

		if (top != null)
		{
			sbSQL.append(" TOP ").append(top.getValue()).append(" ");
		}

		sbSQL.append(translateSelectList(subQuery.getSelectList()));

		List<SqlTableSourceBaseAST> tableSrcList = subQuery
				.getTableSourceList();

		// 如果tableSrcList.size()小于0，说明没有from语句
		if (tableSrcList != null && tableSrcList.size() > 0)
		{
			sbSQL.append(translateTableSourceList(tableSrcList));
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
			sb.append("NUMERIC");
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
			return "DATETIME";
		} else if (dataType instanceof SqlClobTypeDefExprAST)
		{
			return "TEXT";
		} else if (dataType instanceof SqlBlobTypeDefExprAST)
		{
			return "IMAGE";
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
			return "NVARCHAR(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNClobTypeDefExprAST)
		{
			return "NTEXT";
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
		String tName = stmtAST.getTableName();
		return "DROP INDEX " + tName + "." + idxname;
	}

	public String translateStmt(SqlShowTablesStmtAST stmtAST)
			throws TranslateException
	{
		String sc = stmtAST.getSchema();
		if (sc != null && sc.length() > 0)
		{
			return "SELECT name FROM " + sc + ".sysobjects where xtype='U'";
		}
		return "SELECT name FROM sysobjects where xtype='U'";
	}

	public String translateStmt(SqlShowTableColumnsStmtAST stmtAST)
			throws TranslateException
	{
		String tableName = stmtAST.getTableName();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT syscols.name as COLUMN_NAME,st.name as DATA_TYPE,syscomm.text as DATA_DEFAULT,syscols.isnullable as NULLABLE\n");
		sb.append("FROM syscolumns syscols\n");
		sb.append("left join systypes st on syscols.xusertype=st.xusertype\n");
		sb.append("left join syscomments syscomm on syscols.cdefault=syscomm.id\n");
		sb.append("where syscols.id=OBJECT_ID(N'").append(tableName).append("')\n");
		sb.append("order by syscols.id,syscols.colorder");
		return sb.toString();
	}
}
