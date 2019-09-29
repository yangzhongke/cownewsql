package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

//unicode字符，比如N'aaa',N'中国'
public class SqlNCharExprAST extends SqlConstBaseExprAST
{
	private static final long serialVersionUID = 999458155981616795L;

	public SqlNCharExprAST(String textValue)
	{
		super(textValue);
		this.setType(TokenTypes.CONST_STRING);
	}
	public SqlNCharExprAST(AST ast){
		super(ast);
	}
	
	public String getText()
    {
    	String s = super.getText();
    	//convert "n'abc'" to "abc"
    	return s.substring(2,s.length()-1);
    }
}
