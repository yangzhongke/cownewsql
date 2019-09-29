package com.cownew.cownewsql.ast.node.item;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;

/**
 * sql部件的基类
 * @author 杨中科
 *
 */
public abstract  class SqlItemBaseAST extends SQLBaseAST
{
	public SqlItemBaseAST(){
		super();
	}
	public SqlItemBaseAST(String text){
		super(text);
	}
	public SqlItemBaseAST(AST ast){
		super(ast);
	}
	public SqlItemBaseAST(String text,int type){
		super(text,type);
	}

}
