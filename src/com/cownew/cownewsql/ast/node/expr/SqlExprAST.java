package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;

public abstract class SqlExprAST extends SQLBaseAST
{
	public SqlExprAST(AST ast){
		super(ast);
	}
	public SqlExprAST(){
		super();
	}
	public SqlExprAST(String text){
		super(text);
	}
	public SqlExprAST(String text,int type){
		super(text,type);
	}
}
