package com.cownew.cownewsql.ast.node.item;

import java.util.List;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

import antlr.collections.AST;



/**
 * ����Դ�Ļ��࣬��ʾ�ľ���from����ߵĶ�������Ϊfrom��߿�����Table1 as t,
 * Ҳ�������Ӳ�ѯ��������join��䣬���Զ���һ������,���๩SqlQueryExprAST��
 * @author ���п�
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
