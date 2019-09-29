/*
 * com.cownew.cownewsql.imsql.dialect.CodeGenUtils.java
 * Created on 2007-9-6 下午02:37:52 by 杨中科
 */

package com.cownew.cownewsql.imsql.dialect;

import java.util.List;

public class TranslatorUtils
{
	/**
	 * 
	 * <DL>
	 * <DT><B> 标题. </B></DT>
	 * <p>
	 * <DD> convert array: ["aa","bb"] to String: "aa","bb" </DD>
	 * </DL>
	 * <p>
	 * 创建时间: 2007-9-6 下午02:39:40
	 * 
	 * @param values
	 * @return
	 */
	public static String toCommaSeperateList(String[] values)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0, n = values.length; i < n; i++)
		{
			if (i > 0)
			{
				sb.append(",");
			}
			sb.append(values[i]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * <DL>
	 * <DT><B> 标题. </B></DT>
	 * <p>
	 * <DD> convert List: ["aa","bb"] to String: "aa","bb" </DD>
	 * </DL>
	 * <p>
	 * 创建时间: 2007-9-6 下午02:39:40
	 * 
	 * @param values
	 * @return
	 */
	public static String toCommaSeperateList(List values)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0, n = values.size(); i < n; i++)
		{
			if (i > 0)
			{
				sb.append(",");
			}
			sb.append(values.get(i).toString());
		}
		return sb.toString();
	}
}
