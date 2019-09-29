package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

/**
 * 表示结果集，有列表型结果集与子查询型结果集两种
 * 由于结果集与其他sql语句（update,insert等不同），他们不仅可以当成一个单独的语句，也可以
 * 当成一个表达式，比如select((select 1)+(select 2)),因此把他定义成一个exprast的子类 
 * @author 杨中科
 *
 */
public abstract class SqlResultSetBaseExprAST extends SqlExprAST
{
	public SqlResultSetBaseExprAST(){
		super();
	}
	public SqlResultSetBaseExprAST(AST ast){
		super(ast);
	}
}
