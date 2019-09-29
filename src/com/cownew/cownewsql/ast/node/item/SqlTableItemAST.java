package com.cownew.cownewsql.ast.node.item;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

/**
 * ��򵥵ı���Դ
 * select * from T1 as t
 * Replace the #TABLE_ELEMENT in the file "sqlparser.g"
 * @author ���п�
 *
 */
public class SqlTableItemAST extends SqlTableSourceBaseAST 
{
	//����
    //private String tableName;
    
    //����
    //private String alias;
    

	public SqlTableItemAST(){
    	super();
    }
    public SqlTableItemAST(String text){
    	super(text);
    }
    public SqlTableItemAST(String text,int type){
    	super(text,type);
    }
    public SqlTableItemAST(AST ast){
    	super(ast);
    }

	public String getTable()
	{
		SQLBaseAST ast=this.getChildASTByType(TokenTypes.TABLE_NAME);
		if(ast!=null)
		return ast.getText();
		else return null;
	}
	public void setTable(String name){
		this.getChildASTByType(TokenTypes.TABLE_NAME).setText(name);
	}
	public String getAlias()
	{
		SQLBaseAST alias=this.getChildASTByType(TokenTypes.ALIAS_NAME);
		if(alias!=null)
		return alias.getText();
		else return null;
	}

	public void setAlias(String aliasName)
	{
		SQLBaseAST alias=this.getChildASTByType(TokenTypes.ALIAS_NAME);
		if(alias!=null)
		alias.setText(aliasName);
		else {
			this.addChild(new SQLBaseAST(aliasName,TokenTypes.ALIAS_NAME));
		}
	}
	
	
	

}
