package com.cownew.cownewsql.ast.node.item.DDL;

import antlr.collections.AST;

public class SqlTableSinglePrimaryKeyItemAST extends SqlConstraintItemAST
{
	public SqlTableSinglePrimaryKeyItemAST(AST ast)
	{
		super(ast);
	}

	public String getColumnName()
	{
		return getFirstChild().getText();
	}

}
