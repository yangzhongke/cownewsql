package com.cownew.cownewsql.ast.node.item;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;

/**
 * select ��ѯ������еı���������select fid as myid....
 * Replace the #COLUMN_ELEMENT in the "sqlparser.g" file.
 * @author ���п�
 * 
 */
public class SqlQueryColumnItemAST extends SqlItemBaseAST {
	// �У�ע��SqlExprAST�п�����SqlAllColumnExprAST��SqlIdentityferExprAST�ȵ�
	//private SqlExprAST expr;

	// ����������now() as mydate,fid as fid,(select * from t1) as myt
	//private String alias;

	public SqlQueryColumnItemAST() {
		super();
	}
	public SqlQueryColumnItemAST(String text) {
		super(text);
	}

	public SqlQueryColumnItemAST(AST ast) {
		super(ast);
	}

	public SqlQueryColumnItemAST(SqlExprAST expr, String alias) {
		super();
		this.setExpr(expr);
		this.setAlias(alias);
		
	}

	public SqlExprAST getExpr() {
		return (SqlExprAST)this.getChildASTByOrder(1);
	}
	public void setExpr(SqlExprAST ast){
		this.replaceChildASTByOrder(ast,1);
	}

	public String getAlias() {
		SQLBaseAST alias=this.getChildASTByType(TokenTypes.ALIAS_NAME);
		if(alias!=null)
		return alias.getText();
		else return null;
	}
	public void setAlias(String aliasName){
		SQLBaseAST alias=this.getChildASTByType(TokenTypes.ALIAS_NAME);
		if(alias!=null)alias.setText(aliasName);
		else {
			alias=new SQLBaseAST(aliasName,TokenTypes.ALIAS_NAME);
			this.addChild(alias);
		}
	}
}
