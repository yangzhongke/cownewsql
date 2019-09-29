package com.cownew.cownewsql.ast.node.stmt.DDL;

import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;

import antlr.collections.AST;


public class SqlDropTableStmtAST extends SqlStmtBaseAST 
{
    public SqlDropTableStmtAST(AST ast){
    	super(ast);
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
