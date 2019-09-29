package com.cownew.cownewsql.ast.node.expr;

import com.cownew.cownewsql.ast.node.enumdef.BinaryOprtTypeEnum;

import antlr.collections.AST;
//fage/2,3+2,fage*fprice
//fid=2 and fnumber=3��fid in(select fid from t1)�ɿ�����Ԫ���ʽ
//select t1.* from T_t1 t1,�е�t1.*Ҳ���Ա�ʾ�ɶ�Ԫ���ʽ����t1Ϊ�������,
//* Ϊ�ұ��ʽ����.��Ϊ������
public class SqlBinaryOpExprAST extends SqlExprAST 
{
    //private SqlExprAST leftExpr;
    //private SqlExprAST rightExpr;
    //private BinaryOprtTypeEnum operator;
    

	private static final long serialVersionUID = 2800933201411236954L;

	public SqlBinaryOpExprAST(AST ast){
		super(ast);
	}
	
    public void setLeftExpr(SqlExprAST leftExpr)
	{
		//this.leftExpr = leftExpr;
    	this.setChildASTByOrder(leftExpr,1);
	}

	public void setRightExpr(SqlExprAST rightExpr)
	{
		//this.rightExpr = rightExpr;
		this.setChildASTByOrder(rightExpr,2);
	}

	public SqlExprAST getLeftExpr()
	{
		return (SqlExprAST)getFirstChild();
	}

	public BinaryOprtTypeEnum getOperator()
	{	
		return BinaryOprtTypeEnum.getEnum(getType());
	}

	public SqlExprAST getRightExpr()
	{
		
		return (SqlExprAST)this.getChildASTByOrder(2);
	}

	public void setOperator(BinaryOprtTypeEnum operator)
	{
		this.setType(operator.getValue());
	}
}
