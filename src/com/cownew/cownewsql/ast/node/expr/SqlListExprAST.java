package com.cownew.cownewsql.ast.node.expr;

import java.util.List;

import antlr.collections.AST;

/**
 * ��ʾһ���б���ʽ�Ľ������������where fid in(3,5,6)�е�(3,5,6)
 * @author ���п�
 *
 */
public class SqlListExprAST extends SqlResultSetBaseExprAST
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5879480515405761872L;
	//��ʾ���ϵ�Ԫ��
	//private List<SqlExprAST> list;

	public SqlListExprAST()
	{
		super();
		
	}
	public SqlListExprAST(AST ast){
		super(ast);
	}
	public List<SqlExprAST> getList()
	{
		return this.getChildASTList();
	}
	public void setList(List<SqlExprAST> list){
		this.setChildASTList(list);
	}

}
