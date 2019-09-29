package com.cownew.cownewsql.ast.node.item.DDL;

import java.util.ArrayList;
import java.util.List;

import antlr.collections.AST;

public class SqlTableComboPrimaryKeyItemAST extends SqlConstraintItemAST
{

	public SqlTableComboPrimaryKeyItemAST(AST ast)
	{
		super(ast);
	}

	public String[] getColumns()
	{
		List astList = getChildASTList();
		List list = new ArrayList<String>();
		for(int i=0,n=astList.size();i<n;i++)
		{
			AST ast = (AST) astList.get(i);
			list.add(ast.getText());
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

}
