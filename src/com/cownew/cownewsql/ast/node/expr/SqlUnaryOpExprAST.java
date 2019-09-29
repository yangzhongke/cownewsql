package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.UnaryOprtTypeEnum;

/**
 * һԪ��������࣬����not,exist�ȣ�
 * 
 * @author ���п�
 * 
 */
public class SqlUnaryOpExprAST extends SqlExprAST
{
	private static final long serialVersionUID = -879889573274073454L;

	// private SqlExprAST expr;
	// private UnaryOprtTypeEnum operator;
	public SqlUnaryOpExprAST()
	{
		super();
	}

	public SqlUnaryOpExprAST(String text)
	{
		super(text);
	}

	public SqlUnaryOpExprAST(AST ast)
	{
		super(ast);
	}

	public SqlExprAST getExpr()
	{
		return (SqlExprAST) this.getChildASTByOrder(1);
	}

	public void setExpr(SqlExprAST expr)
	{
		this.replaceChildASTByOrder(expr, 1);
	}

	public UnaryOprtTypeEnum getOperator()
	{
		return UnaryOprtTypeEnum.getEnum(getType());
	}

	public void setOperator(UnaryOprtTypeEnum operator)
	{
		this.setType(operator.getValue());
	}

}
