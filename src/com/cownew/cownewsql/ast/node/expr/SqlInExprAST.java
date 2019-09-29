package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

public class SqlInExprAST extends SqlBinaryOpExprAST{

	private static final long serialVersionUID = 4048191719342425337L;


	public SqlInExprAST(AST ast) {
		super(ast);
	}

	public boolean isNot() {
		if(this.getType()==TokenTypes.NOT_IN)
			return true;
			else return false;
	}

	public void setNot(boolean isNot) {
		if(isNot){
			this.setType(TokenTypes.NOT_IN);
		}else{
			this.setType(TokenTypes.IN);
		}
	}

}
