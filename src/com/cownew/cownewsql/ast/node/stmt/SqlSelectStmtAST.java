package com.cownew.cownewsql.ast.node.stmt;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.expr.SqlQueryExprAST;
/**
 * select���
 * @author ���п�
 *
 */
public class SqlSelectStmtAST extends SqlStmtBaseAST
{
	public SqlSelectStmtAST(){
		super();
	}
	public SqlSelectStmtAST(String text){
		super(text);
	}
	public SqlSelectStmtAST(String text,int type){
		super(text,type);
	}
	public SqlSelectStmtAST(AST ast){
		super(ast);
	}
    //������ָ���Ӳ�ѯ���
    private SqlQueryExprAST subQuery;

	public SqlQueryExprAST getSubQuery()
	{
		return subQuery;
	}

	public void setSubQuery(SqlQueryExprAST subQuery)
	{
		this.subQuery = subQuery;
	}
    
	
}
