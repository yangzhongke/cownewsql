package com.cownew.cownewsql.ast.node.stmt;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;

public class SqlStatementsAST extends SQLBaseAST
{
	// ∂‡ÃıSQL”Ôæ‰
	public SqlStatementsAST(AST ast)
	{
		super(ast);
	}

	public List<SqlStmtBaseAST> getStatements()
	{
		List list = getChildASTList();
		return list;
	}

	public void addStatement(SqlStmtBaseAST stmt)
	{
		addChild(stmt);
	}

}
