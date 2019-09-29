package com.cownew.cownewsql.ast.node.item.DDL;

import antlr.collections.AST;

public class SqlTableForeignKeyItemAST extends SqlConstraintItemAST
{
	public SqlTableForeignKeyItemAST(AST ast)
	{
		super(ast);
	}

	public String getColumnName()
	{
		return getChildASTByOrder(1).getText();
	}
	
	public String getForeignTableName()
	{
		return getChildASTByOrder(2).getText();
	}
	
	public String getForeignColName()
	{
		return getChildASTByOrder(3).getText();
	}

}
