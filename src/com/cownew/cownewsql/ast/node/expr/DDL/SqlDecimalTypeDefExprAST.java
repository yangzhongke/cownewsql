package com.cownew.cownewsql.ast.node.expr.DDL;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;

public class SqlDecimalTypeDefExprAST extends SqlDataTypeExprAST
{
	public static final int NOTDEFINE = -1;

	public int getLength()
	{
		AST ast = getChildASTByOrder(1);
		if (ast != null)
		{
			String t = ast.getText();
			return Integer.parseInt(t);
		}
		return NOTDEFINE;
	}

	public int getPrecision()
	{
		SQLBaseAST pAST = getChildASTByOrder(2);
		if (pAST != null)
		{
			return Integer.parseInt(pAST.getText());
		}
		return NOTDEFINE;
	}

	public SqlDecimalTypeDefExprAST(AST ast)
	{
		super(ast);
	}

}
