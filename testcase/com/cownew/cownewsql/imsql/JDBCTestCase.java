/*
 * com.cownew.cownewsql.imsql.JDBCTestCase.java
 * Created on 2007-10-16 ÏÂÎç09:42:25 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

public class JDBCTestCase extends TestCase
{
	private Connection conn;
	protected void setUp() throws Exception
	{
		super.setUp();
		Class.forName("com.cownew.cownewsql.imsql.jdbc.DBDriver");
		conn = DriverManager
				.getConnection(
						"jdbc:cownewsql:oracle:oracle.jdbc.OracleDriver:jdbc:oracle:thin:@192.168.88.128:1521:XE",
						"sys as sysdba", "123456");
	}
	
	protected void tearDown() throws Exception
	{
		conn.close();
		super.tearDown();
	}
	
	public void testPrepareQuery() throws Exception
	{
		PreparedStatement ps = conn.prepareStatement("SELECT top 1 * FROM ISBPUM_USR_LIST");
		ResultSet rs = ps.executeQuery();
		showResult(rs);	
	}
	
	public void testPrepareQuery2() throws Exception
	{
		PreparedStatement ps = conn.prepareStatement("SELECT now()");
		ResultSet rs = ps.executeQuery();
		showResult(rs);	
	}
	
	public void testPrepareQuery3() throws Exception
	{
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ISBPUM_USR_LIST where userid=?");
		ps.setString(1, "abc");
		ResultSet rs = ps.executeQuery();
		showResult(rs);	
	}
	
	public void testStmt() throws Exception
	{
		Statement stmt = conn.createStatement();
		stmt.execute("update ISBPUM_USR_LIST set remark=to_char(now())");
	}

	private void showResult(ResultSet rs) throws SQLException
	{
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next())
		{
			for(int i=0,n=rsmd.getColumnCount();i<n;i++)
			{
				System.out.print(rs.getObject(i+1)+"         ");
			}		
			System.out.println();
		}
	}
}
