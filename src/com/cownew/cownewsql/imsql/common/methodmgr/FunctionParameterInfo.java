/*
 * com.cownew.cownewsql.imsql.common.methodmgr.FunctionParameterInfo.java
 * Created on 2007-10-24 …œŒÁ10:54:28 by —Ó÷–ø∆
 */

package com.cownew.cownewsql.imsql.common.methodmgr;

import java.io.Serializable;

public class FunctionParameterInfo implements Serializable
{
	private String name;

	private boolean nullable;

	private String remarks;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isNullable()
	{
		return nullable;
	}

	public void setNullable(boolean nullable)
	{
		this.nullable = nullable;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

}
