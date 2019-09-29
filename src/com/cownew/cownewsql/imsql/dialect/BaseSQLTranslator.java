package com.cownew.cownewsql.imsql.dialect;

import java.sql.DatabaseMetaData;
import java.util.Arrays;
import java.util.List;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import com.cownew.cownewsql.ast.SQLAstBuilder;
import com.cownew.cownewsql.ast.node.enumdef.BinaryOprtTypeEnum;
import com.cownew.cownewsql.ast.node.enumdef.JoinTypeEnum;
import com.cownew.cownewsql.ast.node.enumdef.OrderByTypeEnum;
import com.cownew.cownewsql.ast.node.enumdef.TriOprtTypeEnum;
import com.cownew.cownewsql.ast.node.enumdef.UnaryOprtTypeEnum;
import com.cownew.cownewsql.ast.node.expr.SqlBetweenExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlBinaryOpExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlCharExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlDateTimeExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlDoubleExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlHexExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlIdentifierExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlInExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlIntExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlIsExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlLikeExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlListExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlNCharExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlNullExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlQueryExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlQuestionMarkExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlUnaryOpExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlDataTypeExprAST;
import com.cownew.cownewsql.ast.node.item.IJoinedable;
import com.cownew.cownewsql.ast.node.item.SqlJoinTableItemAST;
import com.cownew.cownewsql.ast.node.item.SqlOrderByItemAST;
import com.cownew.cownewsql.ast.node.item.SqlQueryColumnItemAST;
import com.cownew.cownewsql.ast.node.item.SqlShowItemAST;
import com.cownew.cownewsql.ast.node.item.SqlSubQueryTableItemAST;
import com.cownew.cownewsql.ast.node.item.SqlTableItemAST;
import com.cownew.cownewsql.ast.node.item.SqlTableSourceBaseAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlColumnDefItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlConstraintItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableComboPrimaryKeyItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableForeignKeyItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableSinglePrimaryKeyItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableUniqueItemAST;
import com.cownew.cownewsql.ast.node.stmt.SqlDeleteStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlInsertBodyAST;
import com.cownew.cownewsql.ast.node.stmt.SqlSelectStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowFunctionColumnsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowFunctionsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowStmtBaseAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowTableColumnsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowTablesStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStatementsAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;
import com.cownew.cownewsql.ast.node.stmt.SqlUpdateBodyAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlAlterTableAddColumnStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlCreateIndexStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlCreateTableStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlDropIndexStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlDropTableStmtAST;
import com.cownew.cownewsql.imsql.IMethodTranslator;
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;
import com.cownew.cownewsql.imsql.common.methodmgr.FunctionInfo;
import com.cownew.cownewsql.imsql.common.methodmgr.FunctionParameterInfo;
import com.cownew.cownewsql.imsql.common.methodmgr.FunctionsMgr;

//SQL翻译中()只夹在必要的sql中
abstract public class BaseSQLTranslator implements ISQLTranslator
{
	protected int upperLayerPriority = -1;

	public String[] translateSQL(String stdSQL) throws TranslateException
	{
		SqlStatementsAST statementsAST;
		try
		{
			statementsAST = SQLAstBuilder.getStatementsAST(stdSQL);
		} catch (RecognitionException ex)
		{
			throw new TranslateException(ex);
		} catch (TokenStreamException ex)
		{
			throw new TranslateException(ex);
		}
		List<SqlStmtBaseAST> stmtList = statementsAST.getChildASTList();
		String[] retSQLs = new String[stmtList.size()];
		for (int i = 0, n = stmtList.size(); i < n; i++)
		{
			SqlStmtBaseAST stmtAST = stmtList.get(i);
			retSQLs[i] = translateStmt(stmtAST);
		}
		return retSQLs;
	}

	public final String translateStmt(SqlStmtBaseAST stmt)
			throws TranslateException
	{
		if (stmt instanceof SqlSelectStmtAST)
		{
			return translateStmt((SqlSelectStmtAST) stmt);
		} else if (stmt instanceof SqlInsertBodyAST)
		{
			return translateStmt((SqlInsertBodyAST) stmt);
		} else if (stmt instanceof SqlDeleteStmtAST)
		{
			return translateStmt((SqlDeleteStmtAST) stmt);
		} else if (stmt instanceof SqlUpdateBodyAST)
		{
			return translateStmt((SqlUpdateBodyAST) stmt);
		} else if (stmt instanceof SqlCreateTableStmtAST)
		{
			return translateStmt((SqlCreateTableStmtAST) stmt);
		} else if (stmt instanceof SqlCreateIndexStmtAST)
		{
			return translateStmt((SqlCreateIndexStmtAST) stmt);
		} else if (stmt instanceof SqlDropIndexStmtAST)
		{
			return translateStmt((SqlDropIndexStmtAST) stmt);
		} else if (stmt instanceof SqlDropTableStmtAST)
		{
			return translateStmt((SqlDropTableStmtAST) stmt);
		} else if (stmt instanceof SqlShowStmtBaseAST)
		{
			return translateShowStmt((SqlShowStmtBaseAST) stmt);
		} else if (stmt instanceof SqlShowStmtBaseAST)
		{
			return translateShowStmt((SqlShowStmtBaseAST) stmt);
		} else if (stmt instanceof SqlAlterTableAddColumnStmtAST)
		{
			return translateStmt((SqlAlterTableAddColumnStmtAST) stmt);
		} else
		{
			throw new TranslateException("unkown SqlStmtBaseAST type");
		}
	}

	public String translateStmt(SqlUpdateBodyAST bodyAST)
			throws TranslateException
	{
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append(bodyAST.getTableName());
		if (bodyAST.getAliasName() != null)
		{
			// In oracle,Table's alias can't start with AS,
			// "T_1 t1" is right,"T_1 as t1" is wrong
			sql.append(" ").append(bodyAST.getAliasName());
		}
		sql.append(" SET ");
		List<SqlBinaryOpExprAST> updateList = bodyAST.getUpdateList();
		for (int i = 0, n = updateList.size(); i < n; i++)
		{
			if (i > 0)
			{
				sql.append(", ");
			}
			sql.append(translateExpr(updateList.get(i)));
		}
		List<SqlTableSourceBaseAST> fromClauseList = bodyAST
				.getTableSourceList();
		if (fromClauseList != null)
		{
			for (SqlTableSourceBaseAST fromClause : fromClauseList)
			{
				// SqlTableSourceBaseAST fromClause = bodyAST.getTableSource();
				if (fromClause != null)
				{
					sql.append(" FROM ");
					if (fromClause instanceof SqlJoinTableItemAST)
					{
						throw new TranslateException(
								"JoinTable not allow here!");
					} else if (fromClause instanceof SqlSubQueryTableItemAST)
					{
						sql
								.append(translateSubQueryTableItem((SqlSubQueryTableItemAST) fromClause));
					} else if (fromClause instanceof SqlTableItemAST)
					{
						sql
								.append(translateTableItem((SqlTableItemAST) fromClause));
					} else if (fromClause instanceof SqlShowItemAST)
					{
						SqlShowItemAST showStmt = (SqlShowItemAST) fromClause;
						SqlShowStmtBaseAST showStmtAST = showStmt
								.getShowStmtAST();
						sql.append("(").append(translateShowStmt(showStmtAST))
								.append(")");
						if (showStmt.getAlias() != null)
						{
							sql.append(" ").append(showStmt.getAlias());
						}
					}
				}
			}
		}
		SqlExprAST whereClause = bodyAST.getWhereClause();
		if (whereClause != null)
		{
			sql.append(" WHERE ");
			sql.append(translateExpr(whereClause));
		}
		return sql.toString();
	}

	private String translateShowStmt(SqlShowStmtBaseAST stmt)
			throws TranslateException
	{
		if (stmt instanceof SqlShowTablesStmtAST)
		{
			return translateStmt((SqlShowTablesStmtAST) stmt);
		} else if (stmt instanceof SqlShowTableColumnsStmtAST)
		{
			return translateStmt((SqlShowTableColumnsStmtAST) stmt);
		} else if (stmt instanceof SqlShowFunctionsStmtAST)
		{
			return translateStmt((SqlShowFunctionsStmtAST) stmt);
		} else if (stmt instanceof SqlShowFunctionColumnsStmtAST)
		{
			return translateStmt((SqlShowFunctionColumnsStmtAST) stmt);
		}
		throw new IllegalArgumentException("unkown show statmement:"
				+ stmt.getClass());
	}

	public String translateStmt(SqlDeleteStmtAST stmtAST)
			throws TranslateException
	{
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE ");
		String tableName = stmtAST.getTableName();
		if (tableName != null && tableName.length() != 0)
		{
			sql.append("FROM ");
			sql.append(tableName);
		}
		SqlExprAST whereClause = stmtAST.getWhereClause();
		if (whereClause != null)
		{
			sql.append(" WHERE ");
			sql.append(translateExpr(whereClause));
		}
		return sql.toString();
	}

	public String translateStmt(SqlInsertBodyAST bodyAST)
			throws TranslateException
	{
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append(bodyAST.getTableName());
		List<SqlIdentifierExprAST> columnList = bodyAST.getColumnList();
		if (columnList != null && columnList.size() > 0)
		{
			sql.append(" (");
			for (int i = 0, n = columnList.size(); i < n; i++)
			{
				if (i > 0)
				{
					sql.append(", ");
				}
				Object colItem = columnList.get(i);
				if (colItem instanceof SqlIdentifierExprAST)
				{
					SqlIdentifierExprAST identExpr = (SqlIdentifierExprAST) colItem;
					sql.append(translateExpr(identExpr));
				} else
					throw new TranslateException("Not support.");
			}
			sql.append(")");
		}
		if (bodyAST.getValueList() != null
				&& bodyAST.getValueList().size() != 0)
		{
			sql.append(" VALUES (");
			for (int i = 0, n = bodyAST.getValueList().size(); i < n; i++)
			{
				if (i > 0)
				{
					sql.append(", ");
				}
				SqlExprAST valueExpr = bodyAST.getValueList().get(i);
				sql.append(translateExpr(valueExpr));
			}
			sql.append(")");
		} else
		{
			sql.append(" ");
			SqlQueryExprAST subQuery = bodyAST.getSubQuery();
			sql.append(translateExpr(subQuery));
		}

		return sql.toString();
	}

	public String translateStmt(SqlSelectStmtAST stmtAST)
			throws TranslateException
	{
		return translateExpr(stmtAST.getSubQuery());
	}

	public String translateStmt(SqlCreateTableStmtAST stmtAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE TABLE ");
		sb.append(stmtAST.getTableName());
		sb.append(" (");
		List<SqlColumnDefItemAST> colDefList = stmtAST.getFieldDefList();
		for (int i = 0, n = colDefList.size(); i < n; i++)
		{
			if (i > 0)
			{
				sb.append(",");
			}
			SqlColumnDefItemAST colDef = colDefList.get(i);
			sb.append(translateColumnItemDef(colDef));
		}

		List<SqlConstraintItemAST> conList = stmtAST.getConstraintList();
		for (int i = 0, n = conList.size(); i < n; i++)
		{
			sb.append(",");
			sb.append(translateColDefConstraint(conList.get(i)));
		}
		sb.append(")");
		return sb.toString();
	}

	private String translateColumnItemDef(SqlColumnDefItemAST colDef)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		String colName = colDef.getName();
		SqlDataTypeExprAST dataType = colDef.getDataType();
		sb.append(colName).append(" ").append(translateDataType(dataType));

		if (!colDef.isAllowNull())
		{
			sb.append(" NOT NULL ");
		}
		SqlExprAST defaultExpr = colDef.getDefaultExpr();
		if (defaultExpr != null)
		{
			sb.append(" DEFAULT ").append(translateExpr(defaultExpr));
		}
		return sb.toString();
	}

	protected abstract String translateDataType(SqlDataTypeExprAST dataType);

	protected String translateColDefConstraint(
			SqlConstraintItemAST constraintItem)
	{
		if (constraintItem instanceof SqlTableSinglePrimaryKeyItemAST)
		{
			SqlTableSinglePrimaryKeyItemAST ast = (SqlTableSinglePrimaryKeyItemAST) constraintItem;
			return "PRIMARY KEY (" + ast.getColumnName() + ")";
		} else if (constraintItem instanceof SqlTableComboPrimaryKeyItemAST)
		{
			StringBuffer sb = new StringBuffer();
			SqlTableComboPrimaryKeyItemAST ast = (SqlTableComboPrimaryKeyItemAST) constraintItem;
			String[] cols = ast.getColumns();
			// in MSSQL,"PRIMARY KEY FId" is invalid,"PRIMARY KEY (FId)" is
			// valid
			sb.append("PRIMARY KEY (");
			sb.append(TranslatorUtils.toCommaSeperateList(cols));
			sb.append(")");
			return sb.toString();
		} else if (constraintItem instanceof SqlTableForeignKeyItemAST)
		{
			SqlTableForeignKeyItemAST ast = (SqlTableForeignKeyItemAST) constraintItem;
			StringBuffer sb = new StringBuffer();
			// in MSSQL,"FOREIGN KEY FId" is invalid,"FOREIGN KEY (FId)" is
			// valid
			sb.append("FOREIGN KEY (").append(ast.getColumnName());
			sb.append(") REFERENCES ").append(ast.getForeignTableName());
			sb.append("(").append(ast.getForeignColName()).append(")");
			return sb.toString();
		} else if (constraintItem instanceof SqlTableUniqueItemAST)
		{
			SqlTableUniqueItemAST ast = (SqlTableUniqueItemAST) constraintItem;
			StringBuffer sb = new StringBuffer();
			String[] cols = ast.getColumns();
			sb.append("UNIQUE (");
			sb.append(TranslatorUtils.toCommaSeperateList(cols));
			return sb.toString();
		} else
		{
			throw new IllegalArgumentException("unknown constraintItem:"
					+ constraintItem.getClass());
		}
	}

	public String translateStmt(SqlCreateIndexStmtAST stmtAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("CREATE INDEX ").append(stmtAST.getIndexName());
		sb.append(" ON ").append(stmtAST.getTableName());
		sb.append("(");
		String[] cols = stmtAST.getColumns();
		for (int i = 0, n = cols.length; i < n; i++)
		{
			if (i > 0)
			{
				sb.append(",");
			}
			sb.append(cols[i]);
		}
		sb.append(")");
		return sb.toString();
	}

	public String translateStmt(SqlDropTableStmtAST stmtAST)
			throws TranslateException
	{
		String name = stmtAST.getTableName();
		return "DROP TABLE " + name;
	}

	public String translateStmt(SqlShowFunctionsStmtAST stmtAST)
			throws TranslateException
	{
		FunctionsMgr funcMgr = FunctionsMgr.getInstance();
		List<FunctionInfo> list = funcMgr.getFunctions();
		StringBuffer sb = new StringBuffer();

		boolean isFirstSQL = true;
		for (int i = 0, n = list.size(); i < n; i++)
		{
			FunctionInfo funcInfo = list.get(i);

			String[] names = funcInfo.getNames();

			StringBuffer sbRemarks = new StringBuffer();
			sbRemarks.append(funcInfo.getRemarks()).append(".Alias:").append(
					Arrays.toString(names)).append(".");
			if (isFirstSQL == false)
			{
				sb.append("UNION ALL\n");
			}
			sb.append("select '' FUNCTION_CAT,'' FUNCTION_SCHEM,");
			sb.append("'").append(names[0]).append("' FUNCTION_NAME,");

			sb.append("'").append(sbRemarks).append("' REMARKS,");
			sb.append(DatabaseMetaData.functionNoTable).append(
					" FUNCTION_TYPE,");
			sb.append("'").append(funcInfo.getSpecificName()).append(
					"' SPECIFIC_NAME,");
			sb.append("'").append(funcInfo.getType().getName()).append(
					"' TYPE\n");
			isFirstSQL = false;
		}
		String[] sqls = translateSQL(sb.toString());
		return sqls[0];
	}

	public String translateStmt(SqlAlterTableAddColumnStmtAST stmtAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("ALTER TABLE ").append(stmtAST.getTableName());
		sb.append(" ADD ");
		sb.append(translateColumnItemDef(stmtAST.getColumnDef()));
		return sb.toString();
	}

	public String translateStmt(SqlShowFunctionColumnsStmtAST stmtAST)
			throws TranslateException
	{
		FunctionsMgr funcMgr = FunctionsMgr.getInstance();
		List<FunctionInfo> list = funcMgr.getFunctions();
		StringBuffer sb = new StringBuffer();

		sb
				.append(
						"select '' FUNCTION_CAT,'' FUNCTION_SCHEM,t.fn FUNCTION_NAME,")
				.append("t.cn COLUMN_NAME,t.ct COLUMN_TYPE,-1 DATA_TYPE,")
				.append(
						"'UNKOWN' TYPE_NAME,-1 pk_PRECISION,-1 LENGTH ,'' SCALE,-1 RADIX,")
				.append("t.na NULLABLE,t.rems REMARKS,'' CHAR_OCTET_LENGTH,")
				.append(
						"0 ORDINAL_POSITION,t.isna IS_NULLABLE,t.sn SPECIFIC_NAME\n")
				.append(" from (");
		boolean isFirstSQL = true;
		for (int i = 0, n = list.size(); i < n; i++)
		{
			FunctionInfo funcInfo = list.get(i);
			fillShowFunctionColumn(sb, funcInfo, isFirstSQL);
			isFirstSQL = false;
		}
		sb.append(") t");
		String[] sqls = translateSQL(sb.toString());
		return sqls[0];
	}

	private void fillShowFunctionColumn(StringBuffer sb, FunctionInfo funcInfo,
			boolean isFirstSQL)
	{
		String funcName = funcInfo.getNames()[0];

		List<FunctionParameterInfo> paramList = funcInfo.getParameterList();
		for (int i = 0, n = paramList.size(); i < n; i++)
		{
			if (isFirstSQL == false)
			{
				sb.append("UNION ALL\n");
			}
			FunctionParameterInfo paramInfo = paramList.get(i);
			sb.append("select ");
			sb.append("'").append(funcName).append("' fn,");
			sb.append("'").append(paramInfo.getName()).append("' cn,");
			sb.append(DatabaseMetaData.functionColumnIn).append(" ct,");
			int nullable = paramInfo.isNullable() ? DatabaseMetaData.functionNullable
					: DatabaseMetaData.functionNullableUnknown;
			sb.append(nullable).append(" na,");
			String paramRemarks = paramInfo.getRemarks();
			sb.append("'").append(paramRemarks).append("' rems,");
			String strNullable = paramInfo.isNullable() ? "YES" : "NO";
			sb.append("'").append(strNullable).append("' isna,");
			sb.append("'").append(funcInfo.getSpecificName()).append("' sn\n");
			isFirstSQL = false;
		}
	}

	protected abstract String translateExpr(SqlQueryExprAST subQuery)
			throws TranslateException;

	protected String translateSelectList(List<SqlQueryColumnItemAST> selectList)
			throws TranslateException
	{
		if (selectList == null)
		{
			return "";
		}
		StringBuffer sbSQL = new StringBuffer();
		for (int i = 0, n = selectList.size(); i < n; i++)
		{
			if (i > 0)
			{
				sbSQL.append(",");
			}
			SqlQueryColumnItemAST selctColItem = selectList.get(i);
			SqlExprAST colExpr = selctColItem.getExpr();

			// ( SELECT (SELECT * FROM T) AS X,(SELECT * FROM T2) AS Y FROM DUAL
			if (colExpr instanceof SqlQueryExprAST)
			{
				sbSQL.append("(").append(translateExpr(colExpr)).append(")");
			} else
			{
				sbSQL.append(translateExpr(colExpr));
			}

			String alias = selctColItem.getAlias();
			if (alias != null && alias.trim().length() > 0)
			{
				sbSQL.append(" AS ").append(alias);
			}
		}
		return sbSQL.toString();
	}

	protected String translateOrderByList(List<SqlOrderByItemAST> orderByList)
			throws TranslateException
	{
		if (orderByList == null)
		{
			return "";
		}
		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append(" ORDER BY ");
		for (int i = 0, n = orderByList.size(); i < n; i++)
		{
			if (i > 0)
			{
				sbSQL.append(",");
			}
			SqlOrderByItemAST orderByItem = orderByList.get(i);
			sbSQL.append(translateExpr(orderByItem.getExpr()));
			OrderByTypeEnum orderType = orderByItem.getOrderType();
			if (orderType.equals(OrderByTypeEnum.ASC))
			{
				sbSQL.append(" ASC");
			} else if (orderType.equals(OrderByTypeEnum.DESC))
			{
				sbSQL.append(" DESC");
			}
		}
		return sbSQL.toString();
	}

	protected String translateHaving(SqlExprAST havingClause)
			throws TranslateException
	{
		if (havingClause == null)
		{
			return "";
		}
		StringBuffer sbSQL = new StringBuffer();
		if (havingClause != null)
		{
			sbSQL.append(" HAVING ");
			sbSQL.append(translateExpr(havingClause));
		}
		return sbSQL.toString();
	}

	protected String translateGroupByList(List<SqlExprAST> groupByList)
			throws TranslateException
	{
		if (groupByList == null)
		{
			return "";
		}
		StringBuffer sbSQL = new StringBuffer();
		if (groupByList != null)
		{
			sbSQL.append(" GROUP BY ");
			for (int i = 0, n = groupByList.size(); i < n; i++)
			{
				if (i > 0)
				{
					sbSQL.append(",");
				}
				sbSQL.append(translateExpr(groupByList.get(i)));
			}
		}
		return sbSQL.toString();
	}

	protected String translateTableSourceList(
			List<SqlTableSourceBaseAST> tableSrcList) throws TranslateException
	{
		if (tableSrcList == null)
		{
			return "";
		}

		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append(" FROM ");

		int counter = 0;
		// SqlTableSource计数器，从第二个非SqlJoinTableItemAST开始的SqlTableSourceBaseAST
		// 前都有一个",",比如select * from T_t1,T_T2,(select * from T3)
		for (int i = 0, n = tableSrcList.size(); i < n; i++)
		{
			SqlTableSourceBaseAST tableSource = tableSrcList.get(i);
			if (counter > 0)
			{
				sbSQL.append(",");
			} else
			{
				counter++;
			}
			if (tableSource instanceof SqlSubQueryTableItemAST)
			{
				sbSQL
						.append(translateSubQueryTableItem((SqlSubQueryTableItemAST) tableSource));
			} else if (tableSource instanceof SqlTableItemAST)
			{
				sbSQL.append(translateTableItem((SqlTableItemAST) tableSource));
			} else if (tableSource instanceof SqlShowItemAST)
			{
				SqlShowItemAST showStmt = (SqlShowItemAST) tableSource;
				sbSQL.append("(").append(
						translateShowStmt(showStmt.getShowStmtAST())).append(
						")");
				if (showStmt.getAlias() != null)
				{
					sbSQL.append(" ").append(showStmt.getAlias());
				}
			}

		}
		return sbSQL.toString();
	}

	protected String translateTableItem(SqlTableItemAST itemAST)
			throws TranslateException
	{
		// In oracle,Table's alias can't start with AS,
		// "T_1 t1" is right,"T_1 as t1" is wrong
		StringBuffer sb = new StringBuffer();
		sb.append(itemAST.getTable());
		String alias = itemAST.getAlias();
		if (alias != null && alias.trim().length() > 0)
		{
			sb.append(" ").append(alias);
		}
		sb.append(this.translateJoinedable(itemAST));

		return sb.toString();
	}

	protected String translateSubQueryTableItem(SqlSubQueryTableItemAST itemAST)
			throws TranslateException
	{
		String alias = itemAST.getAlias();
		boolean hasAlias = false;
		if (alias != null && alias.trim().length() > 0)
		{
			hasAlias = true;
		}
		StringBuffer sb = new StringBuffer();

		// select f1,f2 from (select * from t) tt;
		// =>SELECT f1,f2 FROM (( SELECT * FROM t) AS tt )
		if (hasAlias)
		{
			sb.append("(");
		}
		sb.append(" " + translateExpr(itemAST.getSubQuery()));
		if (hasAlias)
		{
			sb.append(") ").append(alias);
		}
		sb.append(" ");
		sb.append(this.translateJoinedable(itemAST));
		return sb.toString();

	}

	protected String translateJoinTableItem(SqlJoinTableItemAST itemAST)
			throws TranslateException
	{
		// TODO:not support full join now,
		// SELECT table1.*, table2.*
		// FROM table1 full JOIN table2
		// ON table1.id = table2.id
		//
		// can be simulated as follow:
		// SELECT table1.*, table2.*
		// FROM table1 LEFT JOIN table2
		// ON table1.id = table2.id
		// UNION ALL
		// SELECT table1.*, table2.*
		// FROM table1 RIGHT JOIN table2
		// ON table1.id = table2.id
		// WHERE table1.id IS NULL
		StringBuffer sb = new StringBuffer();
		JoinTypeEnum joinType = itemAST.getJoinType();
		if (joinType.equals(JoinTypeEnum.CROSSJOIN))
		{
			sb.append(" CROSS JOIN ");
		} else if (joinType.equals(JoinTypeEnum.INNERJOIN))
		{
			sb.append(" INNER JOIN ");
		} else if (joinType.equals(JoinTypeEnum.LEFTJOIN))
		{
			sb.append(" LEFT JOIN ");
		} else if (joinType.equals(JoinTypeEnum.RIGHTJOIN))
		{
			sb.append(" RIGHT JOIN ");
		} else if (joinType.equals(JoinTypeEnum.DEFULTJOIN))
		{
			sb.append(" JOIN ");
		} else
		{
			throw new TranslateException("unkown JoinTypeEnum type!");
		}

		SqlTableSourceBaseAST left = itemAST.getTargetTableSource();

		if (left instanceof SqlJoinTableItemAST)
		{
			sb.append("").append(
					translateJoinTableItem((SqlJoinTableItemAST) left));
		} else if (left instanceof SqlSubQueryTableItemAST)
		{
			sb.append("").append(
					translateSubQueryTableItem((SqlSubQueryTableItemAST) left));
		} else if (left instanceof SqlTableItemAST)
		{
			sb.append("").append(translateTableItem((SqlTableItemAST) left));
		}

		SqlExprAST conditionAST = itemAST.getCondition();
		if (conditionAST != null)
		{
			sb.append(" ON ");
			// cross join 语句是可以没有ON条件的,比如
			// select lastname from lastname CROSS JOIN firstanme
			sb.append(translateExpr(conditionAST));
		}

		sb.append(translateJoinedable(itemAST));
		return sb.toString();

	}

	protected String translateJoinedable(IJoinedable ast)
			throws TranslateException
	{
		SqlJoinTableItemAST next = ast.getNextJoinedTable();
		StringBuffer sb = new StringBuffer();
		if (next != null)
			sb.append(this.translateJoinTableItem(next));
		return sb.toString();
	}

	public String translateExpr(SqlExprAST expr) throws TranslateException
	{

		if (expr instanceof SqlBetweenExprAST)
		{
			return translateExpr((SqlBetweenExprAST) expr);
		} else if (expr instanceof SqlLikeExprAST)
		{
			return translateExpr((SqlLikeExprAST) expr);
		} else if (expr instanceof SqlInExprAST)
		{
			return translateExpr((SqlInExprAST) expr);
		} else if (expr instanceof SqlIsExprAST)
		{
			return translateExpr((SqlIsExprAST) expr);

		} else if (expr instanceof SqlBinaryOpExprAST)
		{
			return translateExpr((SqlBinaryOpExprAST) expr);
		} else if (expr instanceof SqlCharExprAST)
		{
			return translateExpr((SqlCharExprAST) expr);
		} else if (expr instanceof SqlDateTimeExprAST)
		{
			return translateExpr((SqlDateTimeExprAST) expr);
		} else if (expr instanceof SqlDoubleExprAST)
		{
			return translateExpr((SqlDoubleExprAST) expr);
		} else if (expr instanceof SqlHexExprAST)
		{
			return translateExpr((SqlHexExprAST) expr);
		} else if (expr instanceof SqlIdentifierExprAST)
		{
			return translateExpr((SqlIdentifierExprAST) expr);
		} else if (expr instanceof SqlIntExprAST)
		{
			return translateExpr((SqlIntExprAST) expr);
		} else if (expr instanceof SqlListExprAST)
		{
			return translateExpr((SqlListExprAST) expr);
		} else if (expr instanceof SqlMethodExprAST)
		{
			return translateExpr((SqlMethodExprAST) expr);
		} else if (expr instanceof SqlNCharExprAST)
		{
			return translateExpr((SqlNCharExprAST) expr);
		} else if (expr instanceof SqlNullExprAST)
		{
			return translateExpr((SqlNullExprAST) expr);
		} else if (expr instanceof SqlQueryExprAST)
		{
			return translateExpr((SqlQueryExprAST) expr);
		} else if (expr instanceof SqlUnaryOpExprAST)
		{
			return translateExpr((SqlUnaryOpExprAST) expr);
		} else if (expr instanceof SqlQuestionMarkExprAST)
		{
			return "?";
		} else if (expr == null)
		{
			return "NULL";

		} else
		{
			throw new TranslateException("unkown SqlExprAST type:"
					+ expr.getClass());
		}
	}

	protected String translateExpr(SqlLikeExprAST ast)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		return sb.append(translateExpr(ast.getLeftExpr())).append(
				ast.isNot() ? " NOT LIKE " : " LIKE ").append(
				translateExpr(ast.getRightExpr())).toString();
	}

	protected String translateExpr(SqlInExprAST ast) throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		SqlExprAST rightExpr = ast.getRightExpr();
		String leftSQL = translateExpr(ast.getLeftExpr());
		String rightSQL = translateExpr(rightExpr);
		sb.append(leftSQL).append(ast.isNot() ? " NOT IN " : " IN ");
		if (rightExpr instanceof SqlQueryExprAST)
		{
			sb.append("(").append(rightSQL).append(")");
		} else
		{
			sb.append(rightSQL);
		}

		return sb.toString();
	}

	protected String translateExpr(SqlIsExprAST ast) throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		return sb.append(translateExpr(ast.getLeftExpr())).append(
				ast.isNot() ? " IS NOT " : " IS ").append(
				translateExpr(ast.getRightExpr())).toString();
	}

	protected String translateExpr(SqlUnaryOpExprAST exprAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		UnaryOprtTypeEnum oprt = exprAST.getOperator();
		if (oprt.equals(UnaryOprtTypeEnum.ALL))
		{
			sb.append(" ALL(").append(translateExpr(exprAST.getExpr())).append(
					")");
		} else if (oprt.equals(UnaryOprtTypeEnum.ANY))
		{
			sb.append(" ANY(").append(translateExpr(exprAST.getExpr())).append(
					")");
		} else if (oprt.equals(UnaryOprtTypeEnum.EXISTS))
		{
			sb.append(" EXISTS(").append(translateExpr(exprAST.getExpr()))
					.append(")");
		} else if (oprt.equals(UnaryOprtTypeEnum.NOT))
		{
			sb.append(" NOT(").append(translateExpr(exprAST.getExpr())).append(
					")");
		} else if (oprt.equals(UnaryOprtTypeEnum.SOME))
		{
			sb.append(" SOME(").append(translateExpr(exprAST.getExpr()))
					.append(")");
		} else
		{
			throw new TranslateException("unkown UnaryOprtTypeEnum type");
		}
		return sb.toString();

	}

	protected String translateExpr(SqlNullExprAST exprAST)
	{
		return " NULL ";
	}

	protected String translateExpr(SqlNCharExprAST exprAST)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(" N").append("'").append(exprAST.getTextValue()).append("'");
		return sb.toString();
	}

	protected String translateExpr(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		return getMethodTranslator().translate(exprAST);
	}

	protected String translateExpr(SqlListExprAST exprAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		sb.append(" (");
		List<SqlExprAST> list = exprAST.getList();
		for (int i = 0, n = list.size(); i < n; i++)
		{
			if (i > 0)
			{
				sb.append(",");
			}
			sb.append(translateExpr(list.get(i)));
		}
		sb.append(") ");
		return sb.toString();
	}

	protected String translateExpr(SqlIntExprAST exprAST)
	{
		String txt = exprAST.getTextValue();
		if (txt.startsWith("-"))
		{
			txt = "(" + txt + ")";
		}
		return txt;
	}

	protected String translateExpr(SqlIdentifierExprAST exprAST)
	{
		return exprAST.getName();
	}

	protected String translateExpr(SqlDoubleExprAST exprAST)
	{
		String txt = exprAST.getTextValue();
		if (txt.startsWith("-"))
		{
			txt = "(" + txt + ")";
		}
		return txt;
	}

	protected String translateExpr(SqlHexExprAST exprAST)
	{
		return exprAST.getTextValue();
	}

	protected abstract String translateExpr(SqlDateTimeExprAST exprAST);

	protected String translateExpr(SqlCharExprAST exprAST)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("'").append(exprAST.getTextValue()).append("'");
		return sb.toString();
	}

	protected boolean addP(int priority)
	{
		boolean isAddP = (priority > this.upperLayerPriority);

		this.upperLayerPriority = priority;
		return isAddP;
	}

	protected boolean addP(BinaryOprtTypeEnum u)
	{
		return addP(u.getPriority());
	}

	protected boolean addP(UnaryOprtTypeEnum u)
	{
		return addP(u.getPriority());
	}

	protected boolean addP(TriOprtTypeEnum u)
	{
		return addP(u.getPriority());
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
		boolean isAddP = this.addP(operator);

		if (isAddP)
			sql.append("(");
		SqlExprAST leftExpr = exprAST.getLeftExpr();
		String left = translateExpr(leftExpr);

		if (leftExpr instanceof SqlQueryExprAST)
		{
			left = "(" + left + ")";
		}
		sql.append(left);

		sql.append(translateBinOprt(operator));
		this.upperLayerPriority = operator.getPriority();
		SqlExprAST rightExpr = exprAST.getRightExpr();
		String right = translateExpr(rightExpr);
		if (rightExpr instanceof SqlQueryExprAST)
		{
			right = "(" + right + ")";
		}
		sql.append(right);

		// add the RP
		if (isAddP)
			sql.append(")");
		if (isStart)
			this.upperLayerPriority = -1;
		return sql.toString();
	}

	protected String translateBinOprt(BinaryOprtTypeEnum operator)
			throws TranslateException
	{
		if (operator.equals(BinaryOprtTypeEnum.ADD))
		{
			return " + ";
		} else if (operator.equals(BinaryOprtTypeEnum.AND))
		{
			return " AND ";
		} else if (operator.equals(BinaryOprtTypeEnum.CONCATSTRING))
		{
			return "||";
		} else if (operator.equals(BinaryOprtTypeEnum.DIV))
		{
			return " / ";
		} else if (operator.equals(BinaryOprtTypeEnum.DOT))
		{
			return ".";
		} else if (operator.equals(BinaryOprtTypeEnum.EQUAL))
		{
			return " = ";
		} else if (operator.equals(BinaryOprtTypeEnum.GREATER))
		{
			return " > ";
		} else if (operator.equals(BinaryOprtTypeEnum.GREATEROREQUAL))
		{
			return " >= ";
		} else if (operator.equals(BinaryOprtTypeEnum.LESS))
		{
			return " < ";
		} else if (operator.equals(BinaryOprtTypeEnum.LESSOREQUAL))
		{
			return " <= ";
		} else if (operator.equals(BinaryOprtTypeEnum.MOD))
		{
			return " % ";
		} else if (operator.equals(BinaryOprtTypeEnum.MULTI))
		{
			return " * ";
		} else if (operator.equals(BinaryOprtTypeEnum.NOTEQUAL))
		{
			return " <> ";
		} else if (operator.equals(BinaryOprtTypeEnum.OR))
		{
			return " or ";
		} else if (operator.equals(BinaryOprtTypeEnum.SUBSTRACT))
		{
			return " - ";
		} else if (operator.equals(BinaryOprtTypeEnum.UNION))
		{
			return " UNION ";
		} else
		{
			throw new TranslateException("unkown BinaryOprtTypeEnum" + operator);
		}
	}

	protected String translateExpr(SqlBetweenExprAST exprAST)
			throws TranslateException
	{
		StringBuffer sb = new StringBuffer();

		sb.append("(").append(translateExpr(exprAST.getCompareExpr())).append(
				exprAST.isNot() == true ? " NOT BETWEEN " : " BETWEEN ")
				.append(translateExpr(exprAST.getFirstExpr())).append(" AND ")
				.append(translateExpr(exprAST.getSecondExpr())).append(")");

		return sb.toString();
	}

	public abstract IMethodTranslator getMethodTranslator();
}
