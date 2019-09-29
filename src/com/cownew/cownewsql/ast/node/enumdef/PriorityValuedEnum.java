/*
 * com.cownew.cownewsql.ast.node.enumdef.PriorityValuedEnum.java
 * Created on 2007-9-3 ÏÂÎç06:23:25 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.ast.node.enumdef;


public abstract class PriorityValuedEnum extends ValueUniqueEnum
{
	private static final long serialVersionUID = 1L;

	private final int priority;

	protected PriorityValuedEnum(int value, int priority)
	{
		super(value);
		this.priority = priority;
	}

	public int getPriority()
	{
		return priority;
	}

}
