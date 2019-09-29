package com.cownew.cownewsql.ast.node.item;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.OrderByTypeEnum;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;

/**
 * Replace #ORDER_BY_ELEMENT in file "sqlparser.g" Caution!!set the expr
 * first,and then set the ordertype next.Otherwise it will be something wrong.
 * 
 * @author KingChou
 * 
 */
public class SqlOrderByItemAST extends SqlItemBaseAST
{
	// private SqlExprAST expr;
	// private OrderByTypeEnum orderType;

	public SqlOrderByItemAST()
	{
		super();
	}

	public SqlOrderByItemAST(String text)
	{
		super(text);
	}

	public SqlOrderByItemAST(String text, int type)
	{
		super(text, type);
	}

	public SqlOrderByItemAST(AST ast)
	{
		super(ast);
	}

	public SqlOrderByItemAST(SqlExprAST expr, OrderByTypeEnum orderType)
	{
		super();
		this.setExpr(expr);
		this.setOrderType(orderType);
	}

	public SqlExprAST getExpr()
	{
		return (SqlExprAST) this.getChildASTByOrder(1);
	}

	public void setExpr(SqlExprAST condition)
	{
		SQLBaseAST ast = this.getChildASTByOrder(1);
		if (ast == null)
		{
			this.addChild(condition);
		} else
		{
			this.replaceChildASTByOrder(condition, 1);
		}
	}

	public OrderByTypeEnum getOrderType()
	{
		SQLBaseAST orderType = this.getChildASTByOrder(2);
		if (orderType != null)
		{
			int type = orderType.getType();
			return OrderByTypeEnum.getEnum(type);
		} else
			return OrderByTypeEnum.DEFAULT;
	}

	public void setOrderType(OrderByTypeEnum newOrderType)
	{
		SQLBaseAST orderType = this.getChildASTByOrder(2);
		if (orderType == null)
		{
			orderType = new SQLBaseAST(newOrderType.toString(), newOrderType
					.getValue());
			this.addChild(orderType);
		}
	}
}
