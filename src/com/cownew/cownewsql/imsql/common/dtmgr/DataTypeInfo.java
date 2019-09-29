/*
 * com.cownew.cownewsql.imsql.common.dtmgr.DataTypeInfo.java
 * Created on 2007-10-26 ÏÂÎç06:30:20 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql.common.dtmgr;

import java.io.Serializable;

public class DataTypeInfo implements Serializable
{
	private String[] names;

	private int dataType;

	private String createParams;

	private short nullable;

	private boolean caseSensitive;

	private short searchable;

	private boolean unsigned;

	public boolean isCaseSensitive()
	{
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive)
	{
		this.caseSensitive = caseSensitive;
	}

	public String getCreateParams()
	{
		return createParams;
	}

	public void setCreateParams(String createParams)
	{
		this.createParams = createParams;
	}

	public int getDataType()
	{
		return dataType;
	}

	public void setDataType(int dataType)
	{
		this.dataType = dataType;
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

	public short getNullable()
	{
		return nullable;
	}

	public void setNullable(short nullable)
	{
		this.nullable = nullable;
	}

	public short getSearchable()
	{
		return searchable;
	}

	public void setSearchable(short searchable)
	{
		this.searchable = searchable;
	}

	public boolean isUnsigned()
	{
		return unsigned;
	}

	public void setUnsigned(boolean unsigned)
	{
		this.unsigned = unsigned;
	}

}
