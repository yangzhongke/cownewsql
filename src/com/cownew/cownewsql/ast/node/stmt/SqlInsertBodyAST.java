package com.cownew.cownewsql.ast.node.stmt;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlIdentifierExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlQueryExprAST;
/**
 * Insert 语句
 * @author 杨中科
 *
 */
public class SqlInsertBodyAST extends SqlStmtBaseAST
{
	//into 后边的表名
	//private String tableName;

	//列名，比如insert into T1(fid,fname)....中的(fid,fname)
	//private List<SqlIdentifierExprAST> columnList;

	//值,比如insert into T1(fid,fname) values(2,60)中的(2,60)
	//private List<SqlExprAST> valueList;

	//子查询，比如insert into T1(fid,fname) select fid,fname from t2
	//中的 select fid,fname from t2
	//private SqlQueryExprAST subQuery;

	public SqlInsertBodyAST()
	{
		super();
	}
	public SqlInsertBodyAST(String text){
		super(text);
	}
	public SqlInsertBodyAST(String text,int type){
		super(text,type);
	}
	public SqlInsertBodyAST(AST ast){
		super(ast);
	}
	public void setTableName(String tableName)
	{
		SQLBaseAST ast=this.getChildASTByType(TokenTypes.TABLE_NAME);
		if(ast==null){
			ast=new SQLBaseAST("TABLE_NAME",TokenTypes.TABLE_NAME);
			this.addChild(ast);
		}
		ast.setText(tableName);
	}

	public String getTableName()
	{
		SQLBaseAST ast=this.getChildASTByType(TokenTypes.TABLE_NAME);
		if(ast!=null)return ast.getText();
		else return null;
	}

	public List<SqlIdentifierExprAST> getColumnList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.COLUMN_ELEMENTS);
	}
	public void setColumnList(List<SqlIdentifierExprAST>list){
		this.setLv2ASTList(TreeLableTokenTypesEnum.COLUMN_ELEMENTS,list);
	}

	public List<SqlExprAST> getValueList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.VALUE_ELEMENTS);
	}
	public void setValueList(List<SqlExprAST>list){
		this.setLv2ASTList(TreeLableTokenTypesEnum.VALUE_ELEMENTS,list);
	}
	
	public void setSubQuery(SqlQueryExprAST subQuery)
	{
		this.setChildASTByType(subQuery,TokenTypes.SELECT);
	}

	public SqlQueryExprAST getSubQuery()
	{
		return (SqlQueryExprAST)this.getChildASTByType(TokenTypes.SELECT);
	}
	
	
}
