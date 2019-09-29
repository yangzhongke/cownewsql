package com.cownew.cownewsql.ast.node.expr;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;

/**
 * ��ʾsql�еĺ���������now(),PI(),datediff()�ȵ�
 * 
 * @author ���п�
 * 
 */
public class SqlMethodExprAST extends SqlExprAST
{
	private static final long serialVersionUID = -1690124594642825573L;

	public SqlMethodExprAST()
	{
		super();
	}

	public SqlMethodExprAST(AST ast)
	{
		super(ast);
	}

	public String getMethodName()
	{
		SQLBaseAST ast = this.getChildASTByOrder(1);
		if (ast != null)
			return ast.getText();
		else
			return null;
	}

	public List<SqlExprAST> getParameters()
	{
		return (List<SqlExprAST>) this
				.getLv2ASTList(TreeLableTokenTypesEnum.FUNCTION_PARAMETERS);
	}
}
