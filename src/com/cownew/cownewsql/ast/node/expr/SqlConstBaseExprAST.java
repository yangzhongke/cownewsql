package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

//�������ʽ��1,false,{'2005-02-02'},2.33�ȵĻ���
public class SqlConstBaseExprAST extends SqlExprAST
{

	private static final long serialVersionUID = 3718358370915212722L;

	public SqlConstBaseExprAST(String textValue)
	{
		super(textValue);
		this.setType(TokenTypes.CONSTANT);
	}

	public SqlConstBaseExprAST(AST ast){
		super(ast);
	}
	
	public String getTextValue()
	{
		return this.getText();
	}
	

}
