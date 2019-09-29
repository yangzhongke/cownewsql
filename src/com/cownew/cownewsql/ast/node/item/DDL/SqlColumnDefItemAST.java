package com.cownew.cownewsql.ast.node.item.DDL;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.DDL.SqlDataTypeExprAST;
import com.cownew.cownewsql.ast.node.item.SqlItemBaseAST;

public class SqlColumnDefItemAST extends SqlItemBaseAST
{
	public SqlColumnDefItemAST(AST ast)
	{
		super(ast);
	}

	public boolean isAllowNull()
	{
		SQLBaseAST n = getChildASTByType(TokenTypes.NOTNULL);
		return n==null;
	}

	public SqlDataTypeExprAST getDataType()
	{
		return (SqlDataTypeExprAST) getChildASTByOrder(2);
	}

	public String getName()
	{
		return getChildASTByOrder(1).getText();
	}
	
	public SqlExprAST getDefaultExpr()
	{
		List list = getChildListByClass(SqlExprAST.class);
		if(list.size()<=0)
		{
			return null;
		}
		if(list.size()>1)
		{
			throw new IllegalArgumentException("find more than one SqlExprAST");
		}
		return (SqlExprAST) list.get(0);
	}

}
