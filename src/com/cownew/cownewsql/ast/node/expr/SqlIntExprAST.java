package com.cownew.cownewsql.ast.node.expr;


import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

import antlr.collections.AST;


public class SqlIntExprAST extends SqlConstBaseExprAST
{
	private static final long serialVersionUID = 764108127076964918L;

	public SqlIntExprAST(String textValue)
	{
		super(textValue);
		this.setType(TokenTypes.NUM_INT);
	}
	public SqlIntExprAST(AST ast){
		super(ast);
	}
}
