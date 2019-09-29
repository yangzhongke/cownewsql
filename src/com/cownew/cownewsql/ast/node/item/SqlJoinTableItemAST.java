package com.cownew.cownewsql.ast.node.item;


import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.JoinTypeEnum;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;

/**
 * join，这里把join看作一个节点targetTableSource
 * 比如select t1.fname from t1 left join t2 on t1.fid=t2.ffid
 * 中t2是targetTableSource， t1.fid=t2.ffid是condition
 * 因为targetTableSource不仅仅可以是一个简单的表，还可以是子查询和join查询，所以用SqlTableSourceBaseAST
 * 
 * Replace the #JOIN_TABLE in the file "sqlparser.g"
 * @author 杨中科
 *
 */
public class SqlJoinTableItemAST extends SqlTableSourceBaseAST
    
{	
    //private SqlTableSourceBaseAST targetTableSource;
    
    //连接条件
    //private SqlExprAST condition;
    
    //连接类型
    //private JoinTypeEnum joinType;
    public SqlJoinTableItemAST(){
    	super();
    }
    public SqlJoinTableItemAST(String text){
    	super(text);
    }
    public SqlJoinTableItemAST(String text,int type){
    	super(text,type);
    }
    public SqlJoinTableItemAST(AST ast){
    	super(ast);
    }
    public SqlJoinTableItemAST(SqlTableSourceBaseAST targetTableSource, JoinTypeEnum joinType,
				SqlExprAST condition) {
	this.setTargetTableSource(targetTableSource);
	this.setCondition(condition);
	this.setJoinType(joinType);
	//this.joinType = joinType;
    }


	public SqlTableSourceBaseAST getTargetTableSource()
	{
		return (SqlTableSourceBaseAST)this.getChildASTByType(TokenTypes.TABLE_ELEMENT);
	}
	public void setTargetTableSource(SqlTableSourceBaseAST ast){
		
		this.setChildASTByType(ast,TokenTypes.TABLE_ELEMENT);
	}
	
	public void setCondition(SqlExprAST condition)
	{
		SQLBaseAST ast=(SQLBaseAST)this.getChildASTByType(TokenTypes.SEARCH_CONDITION);
		if(ast!=null)ast.addChild(condition);
		else{
			ast=new SQLBaseAST("SEARCH_CONDITION",TokenTypes.SEARCH_CONDITION);
			ast.addChild(condition);
		}
		
	}

	public SqlExprAST getCondition()
	{
		SQLBaseAST ast=(SQLBaseAST)this.getChildASTByType(TokenTypes.SEARCH_CONDITION);
		if(ast!=null)
		return (SqlExprAST)ast.getFirstChild();
		else return null;
	}

	public JoinTypeEnum getJoinType()
	{
		int type = getChildASTByOrder(1).getType();
		return JoinTypeEnum.getEnum(type);
	}
	public void setJoinType(JoinTypeEnum type){
		this.getChildASTByOrder(1).setType(type.getValue());
	}
}
