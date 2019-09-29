package com.cownew.cownewsql.ast.node.stmt.DDL;

import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;

import antlr.collections.AST;


public class SqlDropIndexStmtAST extends SqlStmtBaseAST 
{
    public SqlDropIndexStmtAST(AST ast){
    	super(ast);
    }
	public void setIndexName(String indexName)
	{
		getChildASTByOrder(2).setText(indexName);
	}

	public String getIndexName()
	{
		return getChildASTByOrder(2).getText();
	}
	
	public void setTableName(String tableName)
	{
		getFirstChild().setText(tableName);
	}

	public String getTableName()
	{
		return getFirstChild().getText();
	}
	
}
