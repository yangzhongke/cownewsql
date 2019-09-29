/*
 * com.cownew.cownewsql.imsql.MSSQLServerTestCase.java
 * Created on 2007-9-14 ÏÂÎç05:03:26 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql;


public class MSSQLServerTestCase extends DBTestCase
{

	protected void doSetUp()
	{
		jdbcDriver = "net.sourceforge.jtds.jdbc.Driver";
		url = "jdbc:jtds:sqlserver://192.168.88.128/demo";
		userid = "sa";
		password = "123456";
		dbType = "MSSQLServer";
	}

}
