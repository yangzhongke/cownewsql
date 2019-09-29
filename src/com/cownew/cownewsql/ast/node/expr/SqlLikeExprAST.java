package com.cownew.cownewsql.ast.node.expr;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

import antlr.collections.AST;

public class SqlLikeExprAST extends SqlBinaryOpExprAST
{

	private static final long serialVersionUID = -3346284726427223423L;

	public SqlLikeExprAST(AST ast)
	{
		super(ast);
	}

	public boolean isNot()
	{
		if (this.getType() == TokenTypes.NOT_LIKE)
			return true;
		else
			return false;
	}

	public void setNot(boolean isNot)
	{
		if (isNot)
		{
			this.setType(TokenTypes.NOT_LIKE);
		} else
		{
			this.setType(TokenTypes.LIKE);
		}
	}

}
