package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.EnumUtils;

/**
 * orderby
 * 
 * @author —Ó÷–ø∆
 * 
 */
public class OrderByTypeEnum extends ValueUniqueEnum
{
	protected OrderByTypeEnum(int value)
	{
		super(value);
	}

	public static final OrderByTypeEnum ASC = new OrderByTypeEnum(
			TokenTypes.ASC);

	public static final OrderByTypeEnum DESC = new OrderByTypeEnum(
			TokenTypes.DESC);

	public static final OrderByTypeEnum DEFAULT = new OrderByTypeEnum(
			TokenTypes.DEFAULT);

	public static OrderByTypeEnum getEnum(int value)
	{
		return (OrderByTypeEnum) EnumUtils.getEnum(OrderByTypeEnum.class,
				value);
	}
}
