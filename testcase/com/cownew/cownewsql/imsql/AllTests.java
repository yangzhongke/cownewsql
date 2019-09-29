/*
 * com.cownew.cownewsql.imsql.AllTests.java
 * Created on 2007-9-19 …œŒÁ11:32:57 by —Ó÷–ø∆
 */

package com.cownew.cownewsql.imsql;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

	public static Test suite()
	{
		TestSuite suite = new TestSuite("Test for com.cownew.cownewsql.imsql");
		//$JUnit-BEGIN$
		suite.addTestSuite(MySQLTestCase.class);
		suite.addTestSuite(OracleTestCase.class);
		suite.addTestSuite(MSSQLServerTestCase.class);
		suite.addTestSuite(DB2UDBTestCase.class);
		//$JUnit-END$
		return suite;
	}

	public static void main(String[] args) throws Exception
	{
		DBTestCase otc = new OracleTestCase();
		otc.setUp();
		otc.tearDown();
	}
}
