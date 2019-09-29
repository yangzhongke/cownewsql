package com.cownew.cownewsql.ast.node.expr.DDL;

import antlr.collections.AST;

public class SqlVarcharTypeDefExprAST extends SqlDataTypeExprAST
{

	public int getLength()
	{
		String t = getChildASTByOrder(1).getText();
		return Integer.parseInt(t);
	}

	public SqlVarcharTypeDefExprAST(AST ast)
	{
		super(ast);
	}

}
