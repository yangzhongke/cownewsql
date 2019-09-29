package com.cownew.cownewsql.ast.node.expr;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

public class SqlIsExprAST extends SqlBinaryOpExprAST{

	private static final long serialVersionUID = 6675549548527254680L;

	public SqlIsExprAST(AST ast) {
		super(ast);
	}

	public boolean isNot() {
		if(this.getType()==TokenTypes.IS_NOT)
			return true;
			else return false;
	}

	public void setNot(boolean isNot) {
		if(isNot){
			this.setType(TokenTypes.IS_NOT);
		}else{
			this.setType(TokenTypes.IS);
		}
	}

}
