package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

/**
 * ��ʾ����������б��ͽ�������Ӳ�ѯ�ͽ��������
 * ���ڽ����������sql��䣨update,insert�Ȳ�ͬ�������ǲ������Ե���һ����������䣬Ҳ����
 * ����һ�����ʽ������select((select 1)+(select 2)),��˰��������һ��exprast������ 
 * @author ���п�
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
