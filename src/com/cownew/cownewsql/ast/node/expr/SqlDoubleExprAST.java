package com.cownew.cownewsql.ast.node.expr;


import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

import antlr.collections.AST;

//double类型常量，2.2,2.2E-5
public class SqlDoubleExprAST extends SqlConstBaseExprAST 
{

	private static final long serialVersionUID = 983174804829520877L;

	public SqlDoubleExprAST(String textValue)
	{
		super(textValue);
		this.setType(TokenTypes.NUM_FLOAT);
	}
	public SqlDoubleExprAST(AST ast){
		super(ast);
	}
    
}
