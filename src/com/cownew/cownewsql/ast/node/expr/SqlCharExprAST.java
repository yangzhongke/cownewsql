package com.cownew.cownewsql.ast.node.expr;


import antlr.collections.AST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

//×Ö·û´®,char,varcharµÈµÈ
public class SqlCharExprAST extends SqlConstBaseExprAST 
{
	private static final long serialVersionUID = -8408821879315584535L;

	public SqlCharExprAST(String textValue)
	{
		super(textValue);
		this.setType(TokenTypes.CONST_STRING);
	}
    public SqlCharExprAST(AST ast){
    	super(ast);
    }
    
    public String getText()
    {
    	String s = super.getText();
    	//convert "'abc'" to "abc"
    	return s.substring(1,s.length()-1);
    }
}
