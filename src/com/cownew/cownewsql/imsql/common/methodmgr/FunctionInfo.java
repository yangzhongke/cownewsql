/*
 * com.cownew.cownewsql.imsql.jdbc.FunctionInfo.java
 * Created on 2007-10-24 …œŒÁ12:23:48 by —Ó÷–ø∆
 */

package com.cownew.cownewsql.imsql.common.methodmgr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FunctionInfo implements Serializable
{
	private String[] names;

	// com.cownew.cownewsql.imsql.common.methodmgr.FunctionTypeEnum
	private FunctionTypeEnum type;

	// the name which uniquely identifies this function within its schema. This
	// is a user specified, or DBMS generated, name that may be different then
	// the FUNCTION_NAME for example with overload functions
	private String specificName;

	private String remarks;

	private List<FunctionParameterInfo> parameterList;

	public FunctionInfo()
	{
		super();
		parameterList = new ArrayList<FunctionParameterInfo>();
	}

	public String[] getNames()
	{
		return names;
	}

	public void setNames(String[] names)
	{
		this.names = names;
	}

	public void setName(String name)
	{
		this.names = new String[] { name };
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public String getSpecificName()
	{
		return specificName;
	}

	public void setSpecificName(String specificName)
	{
		this.specificName = specificName;
	}

	public FunctionTypeEnum getType()
	{
		return type;
	}

	public void setType(FunctionTypeEnum type)
	{
		this.type = type;
	}

	public List<FunctionParameterInfo> getParameterList()
	{
		return parameterList;
	}

}
