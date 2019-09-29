package com.cownew.cownewsql.ast.node.stmt.DDL;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.item.DDL.SqlColumnDefItemAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;

public class SqlAlterTableAddColumnStmtAST extends SqlStmtBaseAST
{
	public SqlAlterTableAddColumnStmtAST(AST ast)
	{
		super(ast);
	}

	public String getTableName()
	{
		return getChildASTByOrder(1).getText();
	}

	public SqlColumnDefItemAST getColumnDef()
	{
		return (SqlColumnDefItemAST) getChildASTByOrder(2);
	}
}
