package com.cownew.cownewsql.imsql.dialect;

import java.util.List;

import com.cownew.cownewsql.ast.node.enumdef.UnaryOprtTypeEnum;
import com.cownew.cownewsql.ast.node.expr.QueryTopInfo;
import com.cownew.cownewsql.ast.node.expr.SqlDateTimeExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlInExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlQueryExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlUnaryOpExprAST;
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
import com.cownew.cownewsql.imsql.dialect.method.MYSQLMethodTranslator;

public class MYSQLTranslator extends BaseSQLTranslator
{
	private IMethodTranslator methodTranslator;

	public MYSQLTranslator()
	{
		super();
		methodTranslator = new MYSQLMethodTranslator(this);
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

		if (top != null)
		{
			sbSQL.append(" LIMIT 0, ").append(top.getValue()).append(" ");
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
			return "DATETIME";
		} else if (dataType instanceof SqlClobTypeDefExprAST)
		{
			return "LONGTEXT";
		} else if (dataType instanceof SqlBlobTypeDefExprAST)
		{
			return "LONGBLOB";
		} else if (dataType instanceof SqlCharTypeDefExprAST)
		{
			SqlCharTypeDefExprAST ast = (SqlCharTypeDefExprAST) dataType;
			return "CHAR(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNCharTypeDefExprAST)
		{
			SqlNCharTypeDefExprAST ast = (SqlNCharTypeDefExprAST) dataType;
			return "CHAR(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNVarcharTypeDefExprAST)
		{
			SqlNVarcharTypeDefExprAST ast = (SqlNVarcharTypeDefExprAST) dataType;
			return "TEXT(" + ast.getLength() + ")";
		} else if (dataType instanceof SqlNClobTypeDefExprAST)
		{
			return "LONGTEXT";
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
		return "DROP INDEX " + idxname + " ON " + tName;
	}

	protected String translateExpr(SqlInExprAST ast) throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		SqlExprAST rightExpr = ast.getRightExpr();
		String leftSQL = translateExpr(ast.getLeftExpr());

		sb.append(leftSQL).append(ast.isNot() ? " NOT IN " : " IN ");
		if (rightExpr instanceof SqlQueryExprAST)
		{
			String rightSQL = translateMySQLSubQuery((SqlQueryExprAST) rightExpr);
			sb.append("(").append(rightSQL).append(")");
		} else
		{
			String rightSQL = translateExpr(rightExpr);
			sb.append(rightSQL);
		}

		return sb.toString();
	}

	protected String translateExpr(SqlUnaryOpExprAST exprAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		UnaryOprtTypeEnum oprt = exprAST.getOperator();
		SqlExprAST expr = exprAST.getExpr();
		if ((expr instanceof SqlQueryExprAST) == false)
		{
			return super.translateExpr(exprAST);
		}
		SqlQueryExprAST queryExpr = (SqlQueryExprAST) expr;
		if (oprt.equals(UnaryOprtTypeEnum.ALL))
		{
			sb.append(" ALL(").append(translateMySQLSubQuery(queryExpr))
					.append(")");
		} else if (oprt.equals(UnaryOprtTypeEnum.ANY))
		{
			sb.append(" ANY(").append(translateMySQLSubQuery(queryExpr))
					.append(")");
		} else if (oprt.equals(UnaryOprtTypeEnum.SOME))
		{
			sb.append(" SOME(").append(translateMySQLSubQuery(queryExpr))
					.append(")");
		} else
		{
			return super.translateExpr(exprAST);
		}
		return sb.toString();
	}

	/**
	 * MySQL doesn't yet support 'LIMIT & IN/ALL/ANY/SOME subquery' eg."select *
	 * from t where fid in(select fid from t2 limit 0,5)" is wrong, because
	 * "This version of MySQL doesn't yet support 'LIMIT & IN/ALL/ANY/SOME
	 * subquery'", but it can simulated by "select * from t where fid in(select *
	 * from (select fid from t2 limit 0,5) t_222)", the alias "t_222" of
	 * subquery even can use the name of exists table/view
	 */
	private String translateMySQLSubQuery(SqlQueryExprAST subQuery)
			throws TranslateException
	{
		QueryTopInfo top = subQuery.getTop();
		if (top == null)
		{
			return translateExpr(subQuery);
		}

		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select * from(").append(translateExpr(subQuery)).append(
				") t_temp_sub");
		return sbSql.toString();
	}

	public String translateStmt(SqlShowTablesStmtAST stmtAST)
			throws TranslateException
	{
		String sc = stmtAST.getSchema();
		String sql = "SHOW TABLES";
		if (sc != null && sc.length() > 0)
		{
			sql += " from " + sc;
		}
		return sql;
	}

	public String translateStmt(SqlShowTableColumnsStmtAST stmtAST)
			throws TranslateException
	{
		String tableName = stmtAST.getTableName();
		return "describe "+tableName;
	}
}
