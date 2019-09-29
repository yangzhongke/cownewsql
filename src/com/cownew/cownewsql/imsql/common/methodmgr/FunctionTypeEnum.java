/*
 * com.cownew.cownewsql.imsql.common.methodmgr.FunctionTypes.java
 * Created on 2007-10-24 …œŒÁ11:49:23 by —Ó÷–ø∆
 */

package com.cownew.cownewsql.imsql.common.methodmgr;

import java.io.Serializable;

public class FunctionTypeEnum extends org.apache.commons.lang.enums.Enum
		implements Serializable
{
	public static final FunctionTypeEnum SYSTEM = new FunctionTypeEnum("SYSTEM");

	public static final FunctionTypeEnum NUMBRIC = new FunctionTypeEnum(
			"NUMBRIC");

	public static final FunctionTypeEnum DATETIME = new FunctionTypeEnum(
			"DATETIME");

	public static final FunctionTypeEnum STRING = new FunctionTypeEnum("STRING");

	public static final FunctionTypeEnum OTHERS = new FunctionTypeEnum("OTHERS");

	private FunctionTypeEnum(String name)
	{
		super(name);
	}
}
