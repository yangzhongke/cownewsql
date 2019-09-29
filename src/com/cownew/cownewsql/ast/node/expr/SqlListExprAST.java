package com.cownew.cownewsql.ast.node.expr;

import java.util.List;

import antlr.collections.AST;

/**
 * 表示一个列表形式的结果集，，比如where fid in(3,5,6)中的(3,5,6)
 * @author 杨中科
 *
 */
public class SqlListExprAST extends SqlResultSetBaseExprAST
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5879480515405761872L;
	//表示集合的元素
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
