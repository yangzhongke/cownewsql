package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

//select fid from t1�е�fid ��Ϊ��ʶ��Identifier
//*Ҳ������SqlIdentifierExprAST������select a.*,select count(*) from t1
public class SqlIdentifierExprAST extends SqlExprAST
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -728887634197415127L;

	//name�Ǳ�ʶ��
	//private String name;
	public SqlIdentifierExprAST(){
		super();
	}
	public SqlIdentifierExprAST(String textValue)
	{
		super(textValue);
	}
	public SqlIdentifierExprAST(AST ast){
		super(ast);
	}

	public String getName()
	{
		return this.getText();
	}

	public void setName(String name)
	{
		this.setText(name);
	}	
}
