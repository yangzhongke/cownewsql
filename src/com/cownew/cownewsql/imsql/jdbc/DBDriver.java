/*
 * com.cownew.cownewsql.imsql.jdbc.DBDriver.java
 * Created on 2007-10-16 ÏÂÎç03:41:05 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.DialectManager;

public class DBDriver implements Driver
{
	private static final String URL_PREFIX = "jdbc:cownewsql:";

	public boolean acceptsURL(String url) throws SQLException
	{
		return url.startsWith(URL_PREFIX);
	}

	public Connection connect(String url, Properties info) throws SQLException
	{
    	if(!acceptsURL(url))
    	{
    		//return null instead of raise exception
    		return null;
    	}
		String regExpr = "^"+URL_PREFIX + "(.+?):(.+?):(.+?)$";
		// jdbc:cownewsql:oracle:oracle.jdbc.OracleDriver:jdbc:oracle:thin:@192.168.88.128:1521:XE
		Pattern pattern = Pattern.compile(regExpr);
		Matcher matcher = pattern.matcher(url);
		matcher.matches();
		//matcher.group();
		
		String dbType = matcher.group(1);
		String targetJdbcDriver = matcher.group(2);
		String targetURL = matcher.group(3);
		try
		{
			Class.forName(targetJdbcDriver);
		} catch (ClassNotFoundException ex)
		{
			throw new SQLException(ex);
		}

		Connection targetConn = DriverManager.getConnection(targetURL, info);
		ISQLTranslator sqlTranslator = DialectManager.createTranslator(dbType);
		return new DBConnection(sqlTranslator, targetConn,url);
	}

	public int getMajorVersion()
	{
		return 2;
	}

	public int getMinorVersion()
	{
		return 1;
	}

	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
			throws SQLException
	{
		return new DriverPropertyInfo[0];
	}

	public boolean jdbcCompliant()
	{
		return false;
	}

	static
	{
		try
		{
			DriverManager.registerDriver(new DBDriver());
		} catch (SQLException ex)
		{
			throw new RuntimeException(ex);
		}
	}

}
