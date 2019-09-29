package com.cownew.cownewsql.imsql.dialect;

import java.util.List;

import com.cownew.cownewsql.ast.node.expr.QueryTopInfo;
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
import com.cownew.cownewsql.imsql.common.TranslateException;

public class Oracle9iTranslator extends OracleTranslator
{

	public Oracle9iTranslator()
	{
		super();
	}

	@Override
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
			sbSQL.append(" FROM DUAL");
		}

		SqlExprAST whereClause = subQuery.getWhereClause();
		if (whereClause != null)
		{
			sbSQL.append(" WHERE ");
			sbSQL.append(translateExpr(whereClause));
		}

		QueryTopInfo top = subQuery.getTop();

		if (top != null)
		{
			if (whereClause == null)
			{
				sbSQL.append(" WHERE ROWNUM <= ");
			} else
			{
				sbSQL.append(" AND ROWNUM <= ");
			}
			sbSQL.append(top.getValue()).append(" ");
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
			return "VARCHAR2(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlIntTypeDefExprAST)
		{
			return "INT";
			//return "NUMBER (10)";
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
			return "DATE";
		} else if (dataType instanceof SqlClobTypeDefExprAST)
		{
			return "NCLOB";
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
			return "NVARCHAR2(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNClobTypeDefExprAST)
		{
			return "NCLOB";
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
		String sql = "select Object_Name from all_objects where Object_Type='TABLE'";
		if (sc != null && sc.length() > 0)
		{
			sql += " and OWNER='" + sc + "'";
		}
		return sql;
	}

	public String translateStmt(SqlShowTableColumnsStmtAST stmtAST)
			throws TranslateException
	{
		String tableName = stmtAST.getTableName().toUpperCase();
		StringBuffer sb = new StringBuffer();
		sb.append("select COLUMN_NAME,DATA_TYPE,DATA_DEFAULT,NULLABLE\n");
		sb.append("from all_tab_columns where TABLE_NAME ='").append(tableName)
				.append("'");
		return sb.toString();
	}
}
