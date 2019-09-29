package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.EnumUtils;

public class TriOprtTypeEnum extends PriorityValuedEnum
{

	protected TriOprtTypeEnum(int value, int priority)
	{
		super(value, priority);
	}

	public static final TriOprtTypeEnum BETWEEN = new TriOprtTypeEnum(
			TokenTypes.BETWEEN, 4);

	public static final TriOprtTypeEnum NOT_BETWEEN = new TriOprtTypeEnum(
			TokenTypes.NOT_BETWEEN, 4);

	public static TriOprtTypeEnum getEnum(int value)
	{
		return (TriOprtTypeEnum) EnumUtils.getEnum(TriOprtTypeEnum.class,
				value);
	}
}
