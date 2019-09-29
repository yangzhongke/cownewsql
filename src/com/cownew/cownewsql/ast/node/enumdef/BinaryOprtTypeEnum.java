package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.EnumUtils;

/**
 * 二元操作符枚举
 * 
 * @author 杨中科
 * 
 */
// lowest -->
// ( 6) AND, NOT,OR
// ( 5) equality: ==, <>, !=, is
// ( 4) relational: <, <=, >, >=,
// LIKE, NOT LIKE, BETWEEN, NOT BETWEEN, IN, NOT IN
// ( 3) addition and subtraction: +(binary) -(binary)
// ( 2) multiplication: * / %, concatenate: ||
// highest --> ( 1) +(unary) -(unary)
// [] () (method call) . (dot -- identifier qualification)
// aggregate function
// () (explicit parenthesis)
public class BinaryOprtTypeEnum extends PriorityValuedEnum
{
	public static final BinaryOprtTypeEnum ADD = new BinaryOprtTypeEnum(
			TokenTypes.PLUS, 3);

	public static final BinaryOprtTypeEnum SUBSTRACT = new BinaryOprtTypeEnum(
			TokenTypes.SUB, 3);

	public static final BinaryOprtTypeEnum MULTI = new BinaryOprtTypeEnum(
			TokenTypes.STAR, 2);

	public static final BinaryOprtTypeEnum DIV = new BinaryOprtTypeEnum(
			TokenTypes.DIV, 2);

	public static final BinaryOprtTypeEnum MOD = new BinaryOprtTypeEnum(
			TokenTypes.MOD, 2);

	public static final BinaryOprtTypeEnum AND = new BinaryOprtTypeEnum(
			TokenTypes.AND, 6);

	public static final BinaryOprtTypeEnum OR = new BinaryOprtTypeEnum(
			TokenTypes.OR, 6);

	public static final BinaryOprtTypeEnum IS = new BinaryOprtTypeEnum(
			TokenTypes.IS, 5);

	public static final BinaryOprtTypeEnum EQUAL = new BinaryOprtTypeEnum(
			TokenTypes.EQUAL, 5);

	public static final BinaryOprtTypeEnum GREATER = new BinaryOprtTypeEnum(
			TokenTypes.GREATER, 4);

	public static final BinaryOprtTypeEnum GREATEROREQUAL = new BinaryOprtTypeEnum(
			TokenTypes.GR_EQ, 4);

	public static final BinaryOprtTypeEnum LESS = new BinaryOprtTypeEnum(
			TokenTypes.LESS, 4);

	public static final BinaryOprtTypeEnum LESSOREQUAL = new BinaryOprtTypeEnum(
			TokenTypes.LE_EQ, 4);

	public static final BinaryOprtTypeEnum NOTEQUAL = new BinaryOprtTypeEnum(
			TokenTypes.NOT_EQ, 4);

	public static final BinaryOprtTypeEnum LIKE = new BinaryOprtTypeEnum(
			TokenTypes.LIKE, 4);

	public static final BinaryOprtTypeEnum NOT_LIKE = new BinaryOprtTypeEnum(
			TokenTypes.NOT_LIKE, 4);

	public static final BinaryOprtTypeEnum CONCATSTRING = new BinaryOprtTypeEnum(
			TokenTypes.CONCAT, 2);

	public static final BinaryOprtTypeEnum IN = new BinaryOprtTypeEnum(
			TokenTypes.IN, 4);

	public static final BinaryOprtTypeEnum UNION = new BinaryOprtTypeEnum(
			TokenTypes.UNION, 8);

	public static final BinaryOprtTypeEnum NOT_IN = new BinaryOprtTypeEnum(
			TokenTypes.NOT_IN, 4);

	public static final BinaryOprtTypeEnum DOT = new BinaryOprtTypeEnum(
			TokenTypes.DOT, 1);

	BinaryOprtTypeEnum(int value, int priority)
	{
		super(value, priority);
	}

	public static BinaryOprtTypeEnum getEnum(int value)
	{
		return (BinaryOprtTypeEnum) EnumUtils.getEnum(BinaryOprtTypeEnum.class,
				value);
	}
}
