/*
 * com.cownew.cownewsql.imsql.MSSQLServerTestCase.java
 * Created on 2007-9-14 ÏÂÎç05:03:26 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql;


public class DB2UDBTestCase extends DBTestCase
{

	protected void doSetUp()
	{
		jdbcDriver = "COM.ibm.db2.jdbc.net.DB2Driver";
		url = "jdbc:db2://192.168.88.128:6789/XE";
		userid = "yzk";
		password = "123456";
		dbType = "DB2UDB";
	}

}
