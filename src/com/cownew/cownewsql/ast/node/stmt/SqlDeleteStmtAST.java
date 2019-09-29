package com.cownew.cownewsql.ast.node.stmt;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;


//delete 语句的节点
public class SqlDeleteStmtAST extends SqlStmtBaseAST 
{
	//要删除的表名
    //private String tableName;
    
    //where语句中的条件可以看作多个带括号的嵌套表达式，
    //and 看成和'+','*'一样的二元操作符，操作符对应的数据类型就是布尔类型
    //比如: id=2 and (name=2 or name =3)
    //当id=2,name = 3的时候，其实就是
    //true and(false or true)
    //和1 +(1+2)一个道理
    //这样就不用对where语句做特殊处理了
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
