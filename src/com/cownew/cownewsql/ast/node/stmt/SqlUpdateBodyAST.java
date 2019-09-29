package com.cownew.cownewsql.ast.node.stmt;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;
import com.cownew.cownewsql.ast.node.expr.SqlBinaryOpExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.item.SqlTableSourceBaseAST;

//update”Ôæ‰
public class SqlUpdateBodyAST extends SqlStmtBaseAST
{
	public SqlUpdateBodyAST(AST ast)
	{
		super(ast);
	}

	public String getTableName()
	{
		SQLBaseAST tableName = this.getChildASTByType(TokenTypes.TABLE_NAME);
		if (tableName != null)
			return tableName.getText();
		else
			return null;
	}

	public String getAliasName()
	{
		SQLBaseAST tableName = this.getChildASTByType(TokenTypes.ALIAS_NAME);
		if (tableName != null)
			return tableName.getText();
		else
			return null;
	}

	public List<SqlTableSourceBaseAST> getTableSourceList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.FROM_CLAUSE);
	}

	public SqlExprAST getWhereClause()
	{
		return (SqlExprAST) this
				.getLv2AST(TreeLableTokenTypesEnum.WHERE_CLAUSE);
	}

	public List<SqlBinaryOpExprAST> getUpdateList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.SET_CLAUSE);
	}

}
