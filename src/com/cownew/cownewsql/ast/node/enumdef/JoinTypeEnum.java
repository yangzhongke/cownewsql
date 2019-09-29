package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.EnumUtils;

/**
 * Join√∂æŸ
 * 
 * @author —Ó÷–ø∆
 * 
 */
public class JoinTypeEnum extends ValueUniqueEnum
{
	protected JoinTypeEnum(int value)
	{
		super(value);
	}

	public static final JoinTypeEnum INNERJOIN = new JoinTypeEnum(
			TokenTypes.INNER_JOIN);

	public static final JoinTypeEnum LEFTJOIN = new JoinTypeEnum(
			TokenTypes.LEFT_JOIN);

	public static final JoinTypeEnum RIGHTJOIN = new JoinTypeEnum(
			TokenTypes.RIGHT_JOIN);

	public static final JoinTypeEnum CROSSJOIN = new JoinTypeEnum(
			TokenTypes.CROSS_JOIN);

	public static final JoinTypeEnum DEFULTJOIN = new JoinTypeEnum(
			TokenTypes.DEFULT_JOIN);

	public static JoinTypeEnum getEnum(int value)
	{
		return (JoinTypeEnum) EnumUtils.getEnum(JoinTypeEnum.class, value);
	}
}
