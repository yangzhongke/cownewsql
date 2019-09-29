package com.cownew.cownewsql.ast.node.expr.DDL;

import antlr.collections.AST;

public class SqlNCharTypeDefExprAST extends SqlDataTypeExprAST
{

	public int getLength()
	{
		String t = getChildASTByOrder(1).getText();
		return Integer.parseInt(t);
	}

	public SqlNCharTypeDefExprAST(AST ast)
	{
		super(ast);
	}

}
