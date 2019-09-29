package com.cownew.cownewsql.ast.node.item;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.expr.SqlQueryExprAST;
//�Ӳ�ѯ,����select fid from(select fid,name from t1)�е�select fid,name from t1
/**
 * Replace the #TABLE_ELEMENT in the file "sqlparser.g"
 * @author KingChou
 *
 */
public class SqlSubQueryTableItemAST extends SqlTableSourceBaseAST
    
{
	//������ָ���Ӳ�ѯ���
    //private SqlQueryExprAST subQuery;
    
    //����
    //private String alias; 
   
    
    public SqlSubQueryTableItemAST(){
    	super();
    }
    public SqlSubQueryTableItemAST(String text){
    	super(text);
    }
    public SqlSubQueryTableItemAST(String text,int type){
    	super(text,type);
    }
    public SqlSubQueryTableItemAST(AST ast){
    	super(ast);
    }

    //subQuery repalce #SELECT
	public void setSubQuery(SqlQueryExprAST subQuery)
	{
		this.setChildASTByOrder(subQuery,1);
	}
    
    
	public SqlQueryExprAST getSubQuery()
	{
		return (SqlQueryExprAST)this.getChildASTByType(TokenTypes.SELECT);
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
