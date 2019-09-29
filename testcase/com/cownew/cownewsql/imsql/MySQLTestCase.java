/*
 * com.cownew.cownewsql.imsql.MSSQLServerTestCase.java
 * Created on 2007-9-14 ÏÂÎç05:03:26 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql;


public class MySQLTestCase extends DBTestCase
{

	protected void doSetUp()
	{
		jdbcDriver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://192.168.88.128:3306/demo";
		userid = "yzk";
		password = "123456";
		dbType = "MYSQL";
	}

}
