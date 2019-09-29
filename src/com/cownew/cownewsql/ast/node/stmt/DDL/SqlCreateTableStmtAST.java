package com.cownew.cownewsql.ast.node.stmt.DDL;

import java.util.ArrayList;
import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.item.DDL.SqlConstraintItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlColumnDefItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableComboPrimaryKeyItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableForeignKeyItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableSinglePrimaryKeyItemAST;
import com.cownew.cownewsql.ast.node.item.DDL.SqlTableUniqueItemAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;

public class SqlCreateTableStmtAST extends SqlStmtBaseAST
{
	public SqlCreateTableStmtAST(AST ast)
	{
		super(ast);
	}

	public String getTableName()
	{
		return getChildASTByOrder(1).getText();
	}

	public void setTableName(String tableName)
	{
		getChildASTByOrder(1).setText(tableName);
	}

	public List<SqlColumnDefItemAST> getFieldDefList()
	{
		List list = getChildListByClass(SqlColumnDefItemAST.class);
		return list;
	}

	public List<SqlConstraintItemAST> getConstraintList()
	{
		List list = new ArrayList();
		list.addAll(getChildListByClass(SqlTableSinglePrimaryKeyItemAST.class));
		list.addAll(getChildListByClass(SqlTableComboPrimaryKeyItemAST.class));
		list.addAll(getChildListByClass(SqlTableForeignKeyItemAST.class));
		list.addAll(getChildListByClass(SqlTableUniqueItemAST.class));
		return list;
	}

}
