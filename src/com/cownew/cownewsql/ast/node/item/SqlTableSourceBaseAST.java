package com.cownew.cownewsql.ast.node.item;

import java.util.List;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

import antlr.collections.AST;



/**
 * 表来源的基类，表示的就是from语句后边的东西，因为from后边可以是Table1 as t,
 * 也可以是子查询，可以是join语句，所以定义一个基类,此类供SqlQueryExprAST用
 * @author 杨中科
 *
 */
public abstract  class SqlTableSourceBaseAST extends SqlItemBaseAST implements IJoinedable
{
	public SqlTableSourceBaseAST(){
		super();
	}
	public SqlTableSourceBaseAST(String text){
		super(text);
	}
	public SqlTableSourceBaseAST(String text,int type){
		super(text,type);
	}
	public SqlTableSourceBaseAST(AST ast){
		super(ast);
	}
	//put all the join table items into a list.
	/**
	 * @deprecated
	 */
	public void putJoinTable(List<SqlTableSourceBaseAST> list){
		SqlTableSourceBaseAST join=this.getNextJoinedTable();
		if(join!=null){
			list.add(join);
			join.putJoinTable(list);
		}
	}
	
	//Impelement the JoinedableInterface
    public SqlJoinTableItemAST getNextJoinedTable() {
		
		return (SqlJoinTableItemAST)this.getChildASTByType(TokenTypes.JOIN_TABLE);
	}
	public void setNextJoinedTable(SqlJoinTableItemAST ast) {
		
		this.setChildASTByType(ast,TokenTypes.JOIN_TABLE);
	}
}
