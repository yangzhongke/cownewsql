package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;


//±Ì ænull
public class SqlNullExprAST extends SqlConstBaseExprAST
{
	private static final long serialVersionUID = 1791563017684161093L;
	public SqlNullExprAST(){
		super("null");
		this.setType(TokenTypes.NULL);
	}
	public SqlNullExprAST(AST ast){
		super(ast);
	}
	
}
