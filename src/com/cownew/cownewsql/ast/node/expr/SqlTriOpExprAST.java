package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TriOprtTypeEnum;

//三元操作符表达式
public class SqlTriOpExprAST extends SqlExprAST
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4492325218751458710L;

	// 被比较表达式
	// private SqlExprAST compareExpr;
	// private SqlExprAST firstExpr;
	// private SqlExprAST secondExpr;
	// private TriOprtTypeEnum oprator;
	public SqlTriOpExprAST()
	{
		super();
	}

	public SqlTriOpExprAST(AST ast)
	{
		super(ast);
	}

	public SqlExprAST getCompareExpr()
	{
		return (SqlExprAST) this.getChildASTByOrder(1);
	}

	public void setCompareExpr(SqlExprAST compareExpr)
	{
		this.setChildASTByOrder(compareExpr, 1);
	}

	public SqlExprAST getFirstExpr()
	{
		return (SqlExprAST) this.getChildASTByOrder(2);
	}

	public void setFirstExpr(SqlExprAST firstExpr)
	{
		this.setChildASTByOrder(firstExpr, 2);
	}

	public TriOprtTypeEnum getOprator()
	{
		return TriOprtTypeEnum.getEnum(getType());
	}

	public void setOprator(TriOprtTypeEnum operator)
	{
		this.setType(operator.getValue());
	}

	public SqlExprAST getSecondExpr()
	{
		return (SqlExprAST) this.getChildASTByOrder(3);
	}

	public void setSecondExpr(SqlExprAST secondExpr)
	{
		this.setChildASTByOrder(secondExpr, 3);
	}
}
