package com.cownew.cownewsql.ast.node.expr;

import java.util.List;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;
import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;
import com.cownew.cownewsql.ast.node.item.SqlOrderByItemAST;
import com.cownew.cownewsql.ast.node.item.SqlQueryColumnItemAST;
import com.cownew.cownewsql.ast.node.item.SqlTableSourceBaseAST;

//表示子查询类型结果集，比如select * from t1,或者insert into t1(fid) select fid from t2 中的select fid from t2
/**
 * Replace the #SELECT in the file "sqlparser.g"
 * 
 * @author KingChou
 * 
 */
public class SqlQueryExprAST extends SqlResultSetBaseExprAST
{
	// 列集合，
	// private List<SqlQueryColumnItemAST> selectList;

	// private List<SqlTableSourceBaseAST> tableSourceList;

	// 是否Distinct
	// private boolean isDistinct;

	// where语句中的条件可以看作多个带括号的嵌套表达式，
	// and 看成和'+','*'一样的二元操作符，操作符对应的数据类型就是布尔类型
	// 比如: id=2 and (name=2 or name =3)
	// 当id=2,name = 3的时候，其实就是
	// true and(false or true)
	// 和1 +(1+2)一个道理
	// 这样就不用对where语句做特殊处理了
	// private SqlBinaryOpExprAST whereClause;

	// private QueryTopInfo top;

	// 因为groupby后边的字段可以不是一个简单字段，而可以是一个普通表达式
	// 比如select len(orderid) from orders group by len(orderid)
	// 所以这里List的版型不能是SqlIdentifyExprAST
	// private List<SqlExprAST> groupBy;

	// private SqlExprAST having;

	// private List<SqlOrderByItemAST> orderBy;

	private static final long serialVersionUID = 1726441202465878849L;

	public SqlQueryExprAST(AST ast)
	{
		super(ast);
	}

	// COLUMN_ELEMENTS
	public List<SqlQueryColumnItemAST> getSelectList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.COLUMN_ELEMENTS);
	}

	// COLUMN_ELEMENTS
	public void setSelectList(List<SqlQueryColumnItemAST> list)
	{
		this.setLv2ASTList(TreeLableTokenTypesEnum.COLUMN_ELEMENTS, list);
	}

	// FROM_CLAUSE
	public List<SqlTableSourceBaseAST> getTableSourceList()
	{
		List<SqlTableSourceBaseAST> allTable = this
				.getLv2ASTList(TreeLableTokenTypesEnum.FROM_CLAUSE);
		return allTable;
	}

	// FROM_CLAUSE
	public void setTableSourceList(List<SqlTableSourceBaseAST> list)
	{
		this.setLv2ASTList(TreeLableTokenTypesEnum.FROM_CLAUSE, list);

	}

	// WHERE_CLAUSE
	public SqlExprAST getWhereClause()
	{
		return (SqlExprAST) this
				.getLv2AST(TreeLableTokenTypesEnum.WHERE_CLAUSE);

	}

	// WHERE_CLAUSE
	public void setWhereClause(SqlExprAST whereClause)
	{
		this.setLv2AST(TreeLableTokenTypesEnum.WHERE_CLAUSE, whereClause);
	}

	// Group by clause
	public List<SqlExprAST> getGroupByList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.GROUP_BY_CLAUSE);
	}

	// Group by clause
	public void setGroupByList(List<SqlExprAST> groupBy)
	{
		this.setLv2ASTList(TreeLableTokenTypesEnum.GROUP_BY_CLAUSE, groupBy);
	}

	// order by clause
	public List<SqlOrderByItemAST> getOrderByList()
	{
		return this.getLv2ASTList(TreeLableTokenTypesEnum.ORDER_BY_CLAUSE);
	}

	// order by clause
	public void setOrderByList(List<SqlOrderByItemAST> orderBy)
	{
		this.setLv2ASTList(TreeLableTokenTypesEnum.ORDER_BY_CLAUSE, orderBy);
	}

	// Top element
	public void setTop(QueryTopInfo top)
	{
		SQLBaseAST topElement = this.getChildASTByType(TokenTypes.TOP_ELEMENT);
		if (topElement != null)
			this.replaceChildASTByType(top, TokenTypes.TOP_ELEMENT);
		else
			this.addChild(top);
	}

	// Top element
	public QueryTopInfo getTop()
	{
		return (QueryTopInfo) this.getChildASTByType(TokenTypes.TOP_ELEMENT);
	}

	public void setHaving(SqlExprAST having)
	{
		this.setLv2AST(TreeLableTokenTypesEnum.HAVING_CLAUSE, having);

	}

	public SqlExprAST getHaving()
	{
		return (SqlExprAST) this
				.getLv2AST(TreeLableTokenTypesEnum.HAVING_CLAUSE);

	}

	public boolean isDistinct()
	{
		SQLBaseAST ast = this.getLv2AST(TreeLableTokenTypesEnum.AGGREGATE_TYPE);
		if (ast == null)
			return false;
		else
		{
			if (ast.getType() == TokenTypes.DISTINCT)
				return true;
			else
				return false;
		}
	}

	public void setUnionSqlQueryExprAST(SqlQueryExprAST union)
	{
		this.setLv2AST(TreeLableTokenTypesEnum.UNION, union);
	}
	
	public boolean isUnionAll()
	{
		SQLBaseAST ast = getChildASTByType(TokenTypes.UNION);
		if(ast==null)
		{
			return false;
		}
		SQLBaseAST allAST = ast.getChildASTByType(TokenTypes.ALL);
		return allAST!=null;		
	}

	public SqlQueryExprAST getUnionSqlQueryExprAST()
	{
		SQLBaseAST ast = getChildASTByType(TokenTypes.UNION);
		if(ast==null)
		{
			return null;
		}
		SQLBaseAST queryAST = ast.getChildListByClass(SqlQueryExprAST.class).get(0);
		return (SqlQueryExprAST) queryAST;
	}
}
