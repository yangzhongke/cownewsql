package com.cownew.cownewsql.ast.node.stmt;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
/**
 * sql语句的基类
 * @author 杨中科
 *
 */
abstract public class SqlStmtBaseAST extends SQLBaseAST
{
	public SqlStmtBaseAST(){
		super();
	}
	public SqlStmtBaseAST(String text){
		super(text);
	}
	public SqlStmtBaseAST(String text,int type){
		super(text,type);
	}
	public SqlStmtBaseAST(AST ast){
		super(ast);
	}
}
