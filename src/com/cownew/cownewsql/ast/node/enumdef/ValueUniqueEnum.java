/*
 * com.cownew.cownewsql.ast.node.enumdef.BaseEnum.java
 * Created on 2007-9-3 ����06:32:05 by ���п�
 */

package com.cownew.cownewsql.ast.node.enumdef;

import org.apache.commons.lang.enums.ValuedEnum;

public class ValueUniqueEnum extends ValuedEnum
{

	protected ValueUniqueEnum(int value)
	{
		//use value.toString as it's name
		super(Integer.toString(value), value);
	}

}
