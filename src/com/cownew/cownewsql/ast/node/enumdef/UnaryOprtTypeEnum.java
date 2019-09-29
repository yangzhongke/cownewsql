package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.EnumUtils;

/**
 * 一元运算符
 * 
 * @author 杨中科
 * 
 */
public class UnaryOprtTypeEnum extends PriorityValuedEnum
{

	protected UnaryOprtTypeEnum(int value, int priority)
	{
		super(value, priority);
	}

	public static final UnaryOprtTypeEnum NOT = new UnaryOprtTypeEnum(
			TokenTypes.NOT, 6);

	public static final UnaryOprtTypeEnum EXISTS = new UnaryOprtTypeEnum(
			TokenTypes.EXISTS, 8);

	public static final UnaryOprtTypeEnum ALL = new UnaryOprtTypeEnum(
			TokenTypes.ALL, 8);

	public static final UnaryOprtTypeEnum SOME = new UnaryOprtTypeEnum(
			TokenTypes.SOME, 8);

	public static final UnaryOprtTypeEnum ANY = new UnaryOprtTypeEnum(
			TokenTypes.ANY, 8);

	public static UnaryOprtTypeEnum getEnum(int value)
	{
		return (UnaryOprtTypeEnum) EnumUtils.getEnum(UnaryOprtTypeEnum.class,
				value);
	}
}
