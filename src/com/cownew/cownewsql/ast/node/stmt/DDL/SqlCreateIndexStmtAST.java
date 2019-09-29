package com.cownew.cownewsql.ast.node.stmt.DDL;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;
import com.cownew.cownewsql.ast.node.expr.SqlIdentifierExprAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;

public class SqlCreateIndexStmtAST extends SqlStmtBaseAST
{

	public SqlCreateIndexStmtAST(AST ast)
	{
		super(ast);
	}

	public String getIndexName()
	{
		return getFirstChild().getText();
	}

	public String getTableName()
	{
		return getChildASTByOrder(2).getText();
	}

	public String[] getColumns()
	{
		List<SqlIdentifierExprAST> list = getLv2ASTList(TreeLableTokenTypesEnum.COLUMN_ELEMENTS);
		String[] strs = new String[list.size()];
		for(int i=0,n=strs.length;i<n;i++)
		{
			SqlIdentifierExprAST idAST = list.get(i);
			strs[i] = idAST.getText();
		}
		return strs;
	}
}
