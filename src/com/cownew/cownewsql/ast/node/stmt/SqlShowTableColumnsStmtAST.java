package com.cownew.cownewsql.ast.node.stmt;

import antlr.collections.AST;

public class SqlShowTableColumnsStmtAST extends SqlShowStmtBaseAST
{
	public SqlShowTableColumnsStmtAST(AST ast)
	{
		super(ast);
	}

	public String getTableName()
	{
		AST fc = getFirstChild();
		if (fc == null)
		{
			return null;
		}
		return fc.getText();
	}
}
