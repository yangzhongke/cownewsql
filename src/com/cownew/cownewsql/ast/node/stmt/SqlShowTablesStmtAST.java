package com.cownew.cownewsql.ast.node.stmt;

import antlr.collections.AST;

public class SqlShowTablesStmtAST extends SqlShowStmtBaseAST
{
	public SqlShowTablesStmtAST(AST ast)
	{
		super(ast);
	}

	public String getSchema()
	{
		AST fc = getFirstChild();
		if (fc == null)
		{
			return null;
		}
		return fc.getText();
	}
}
