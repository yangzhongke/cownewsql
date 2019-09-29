package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

/**
 * Replace #TOP_ELEMENT
 * 
 * @author KingChou
 * 
 */
public class QueryTopInfo extends SqlExprAST
{
	private static final long serialVersionUID = 7740882662378957651L;

	public QueryTopInfo(AST ast)
	{
		super(ast);
	}

	public int getValue()
	{
		AST ast = this.getFirstChild();
		return Integer.parseInt(ast.getText());
	}

}
