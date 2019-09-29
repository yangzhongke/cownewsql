/*
 * com.cownew.cownewsql.imsql.MSSQLServerTestCase.java
 * Created on 2007-9-14 ÏÂÎç05:03:26 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql;


public class OracleTestCase extends DBTestCase
{

	protected void doSetUp()
	{
		jdbcDriver = "oracle.jdbc.OracleDriver";
		url = "jdbc:oracle:thin:@192.168.88.128:1521:XE";
		userid = "sys as sysdba";
		password = "123456";
		dbType = "Oracle";
	}

}
