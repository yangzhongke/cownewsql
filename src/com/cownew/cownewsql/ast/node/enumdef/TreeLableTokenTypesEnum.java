package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.EnumUtils;
import org.apache.commons.lang.enums.ValuedEnum;

/**
 * 
 * There are two types tokens in the AST. One type of them is replaced by
 * special class,while the other type tokens have no sence and are only used for
 * lable. This TreeLableTokenTypesEnum contains the latter ones. Thus all the
 * tokens in this class are the nosence tokens which are not replaced with class
 * other than SQLBaseAST and which are only used for tree labels.
 * 
 * @author KingChou
 * 
 */
public class TreeLableTokenTypesEnum extends ValuedEnum
{

	

	protected TreeLableTokenTypesEnum(String name, int value)
	{
		super(name,value);
	}

	public static final TreeLableTokenTypesEnum SET_CLAUSE = new TreeLableTokenTypesEnum("SET_CLAUSE",
			TokenTypes.SET_CLAUSE);

	public static final TreeLableTokenTypesEnum FROM_CLAUSE = new TreeLableTokenTypesEnum("FROM_CLAUSE",
			TokenTypes.FROM_CLAUSE);

	public static final TreeLableTokenTypesEnum WHERE_CLAUSE = new TreeLableTokenTypesEnum("WHERE_CLAUSE",
			TokenTypes.WHERE_CLAUSE);

	public static final TreeLableTokenTypesEnum GROUP_BY_CLAUSE = new TreeLableTokenTypesEnum("GROUP_BY_CLAUSE",
			TokenTypes.GROUP_BY_CLAUSE);

	public static final TreeLableTokenTypesEnum HAVING_CLAUSE = new TreeLableTokenTypesEnum("HAVING_CLAUSE",
			TokenTypes.HAVING_CLAUSE);

	public static final TreeLableTokenTypesEnum ORDER_BY_CLAUSE = new TreeLableTokenTypesEnum("ORDER_BY_CLAUSE",
			TokenTypes.ORDER_BY_CLAUSE);

	public static final TreeLableTokenTypesEnum COLUMN_ELEMENTS = new TreeLableTokenTypesEnum("COLUMN_ELEMENTS",
			TokenTypes.COLUMN_ELEMENTS);

	public static final TreeLableTokenTypesEnum VALUE_ELEMENTS = new TreeLableTokenTypesEnum("VALUE_ELEMENTS",
			TokenTypes.VALUE_ELEMENTS);

	public static final TreeLableTokenTypesEnum AGGREGATE_TYPE = new TreeLableTokenTypesEnum("AGGREGATE_TYPE",
			TokenTypes.AGGREGATE_TYPE);

	public static final TreeLableTokenTypesEnum UNION = new TreeLableTokenTypesEnum("UNION",
			TokenTypes.UNION);

	public static final TreeLableTokenTypesEnum FUNCTION_PARAMETERS = new TreeLableTokenTypesEnum("FUNCTION_PARAMETERS",
			TokenTypes.FUNCTION_PARAMETERS);
	
	public static TreeLableTokenTypesEnum getEnum(int value)
	{
		return (TreeLableTokenTypesEnum) EnumUtils.getEnum(TreeLableTokenTypesEnum.class,
				value);
	}

}
