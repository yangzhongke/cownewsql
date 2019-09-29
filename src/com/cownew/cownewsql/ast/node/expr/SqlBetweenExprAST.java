package com.cownew.cownewsql.ast.node.expr;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;


import antlr.collections.AST;
//f1 between 1 and 2,f2 between getDate() and {'2005-05-05'}
public class SqlBetweenExprAST extends SqlTriOpExprAST
{
	private static final long serialVersionUID = 552441512655328488L;

	//�ǲ���not between 1 and 2
    //private boolean isNot = false;
    //���Ƚϵı��ʽ
    //private SqlExprAST compareValueExpr;
    //and ��ߵı��ʽ
    //private SqlExprAST beginExpr;
    //and �ұߵı��ʽ
    //private SqlExprAST endExpr;   

    public SqlBetweenExprAST(AST ast){
    	super(ast);
    }
    public boolean isNot()
	{
		if(this.getType()==TokenTypes.NOT_BETWEEN)
		return true;
		else return false;
	}
	
	public void setNot(boolean isNot)
	{
		if(isNot){
			this.setType(TokenTypes.NOT_BETWEEN);
		}
		else this.setType(TokenTypes.BETWEEN);
		
	}
}
