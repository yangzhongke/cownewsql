package com.cownew.cownewsql.ast.node.item;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.stmt.SqlShowStmtBaseAST;

public class SqlShowItemAST extends SqlTableSourceBaseAST
{
	private SqlShowStmtBaseAST showStmtAST;

	public SqlShowItemAST(AST showStmtAST,AST ast)
	{
		super(ast);
		this.showStmtAST = (SqlShowStmtBaseAST) showStmtAST;
	}

	public SqlShowStmtBaseAST getShowStmtAST()
	{
		return showStmtAST;
	}

	public String getAlias()
	{
		SQLBaseAST alias = this.getChildASTByType(TokenTypes.ALIAS_NAME);
		if (alias != null)
			return alias.getText();
		else
			return null;
	}
}
