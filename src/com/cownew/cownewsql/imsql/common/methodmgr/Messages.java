/*
 * com.Messages.java
 * Created on 2007-10-24 ����02:29:53 by ���п�
 */

package com.cownew.cownewsql.imsql.common.methodmgr;

import java.util.ResourceBundle;

public class Messages
{
	private static final String BUNDLE_NAME = "com.cownew.cownewsql.imsql.common.methodmgr.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages()
	{
		super();
	}

	public static String getString(String key)
	{
		return RESOURCE_BUNDLE.getString(key);
	}
}
