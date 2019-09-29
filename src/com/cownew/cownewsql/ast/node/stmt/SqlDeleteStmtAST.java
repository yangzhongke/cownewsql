package com.cownew.cownewsql.ast.node.stmt;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;


//delete ���Ľڵ�
public class SqlDeleteStmtAST extends SqlStmtBaseAST 
{
	//Ҫɾ���ı���
    //private String tableName;
    
    //where����е��������Կ�����������ŵ�Ƕ�ױ��ʽ��
    //and ���ɺ�'+','*'һ���Ķ�Ԫ����������������Ӧ���������;��ǲ�������
    //����: id=2 and (name=2 or name =3)
    //��id=2,name = 3��ʱ����ʵ����
    //true and(false or true)
    //��1 +(1+2)һ������
    //�����Ͳ��ö�where��������⴦����
    //private SqlBinaryOpExprAST whereClause;
    
    public SqlDeleteStmtAST() {
	  super();
    }
    
    public SqlDeleteStmtAST(String text)
	{
		super(text);
		
	}
    public SqlDeleteStmtAST(AST ast){
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


	public void setWhereClause(SqlExprAST whereClause)
	{
		this.setLv2AST(TreeLableTokenTypesEnum.WHERE_CLAUSE,whereClause);
	}

	public SqlExprAST getWhereClause()
	{
		return (SqlExprAST)this.getLv2AST(TreeLableTokenTypesEnum.WHERE_CLAUSE);
	}
	
}
