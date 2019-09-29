package com.cownew.cownewsql.ast.node.item.DDL;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.item.SqlItemBaseAST;

abstract public class SqlConstraintItemAST extends SqlItemBaseAST
{
	public SqlConstraintItemAST(AST ast)
	{
		super(ast);
	}

}
