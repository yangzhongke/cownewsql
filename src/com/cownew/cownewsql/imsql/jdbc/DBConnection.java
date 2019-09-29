/*
 * com.cownew.cownewsql.imsql.jdbc.DBConnection.java
 * Created on 2007-10-16 下午03:39:45 by 杨中科
 */

package com.cownew.cownewsql.imsql.jdbc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class DBConnection implements Connection
{
	private ISQLTranslator sqlTranslator;

	private Connection targetConn;
	
	private DBDatabaseMetaData dbMetaData;
	
	private String url;

	private static final String DIALECT_PREFIX = "/*Dialect*/";

	public DBConnection(ISQLTranslator sqlTranslator, Connection targetConn, String url)
			throws SQLException
	{
		super();
		this.sqlTranslator = sqlTranslator;
		this.targetConn = targetConn;
		this.url = url;
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public Connection getTargetConnection()
	{
		return targetConn;
	}

	String translateSQL(String sql) throws SQLException
	{
		if (sql.startsWith(DIALECT_PREFIX))
		{
			return sql.substring(DIALECT_PREFIX.length());
		}
		try
		{
			return sqlTranslator.translateSQL(sql)[0];
		} catch (TranslateException ex)
		{
			throw new SQLException(ex);
		}
	}

	public void clearWarnings() throws SQLException
	{
		targetConn.clearWarnings();
	}

	public void close() throws SQLException
	{
		targetConn.close();
	}

	public void commit() throws SQLException
	{
		targetConn.commit();
	}

	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException
	{
		return targetConn.createArrayOf(typeName, elements);
	}

	public Blob createBlob() throws SQLException
	{
		return targetConn.createBlob();
	}

	public Clob createClob() throws SQLException
	{
		return targetConn.createClob();
	}

	public NClob createNClob() throws SQLException
	{
		return targetConn.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException
	{
		return targetConn.createSQLXML();
	}

	public Statement createStatement() throws SQLException
	{
		Statement stmt = targetConn.createStatement();
		return new DBStatement(this, stmt);
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException
	{
		Statement stmt = targetConn.createStatement(resultSetType,
				resultSetConcurrency);
		return new DBStatement(this, stmt);
	}

	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException
	{
		Statement stmt = targetConn.createStatement(resultSetType,
				resultSetConcurrency, resultSetHoldability);
		return new DBStatement(this, stmt);
	}

	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException
	{
		return targetConn.createStruct(typeName, attributes);
	}

	public boolean getAutoCommit() throws SQLException
	{
		return targetConn.getAutoCommit();
	}

	public String getCatalog() throws SQLException
	{
		return targetConn.getCatalog();
	}

	public Properties getClientInfo() throws SQLException
	{
		return targetConn.getClientInfo();
	}

	public String getClientInfo(String name) throws SQLException
	{
		return targetConn.getClientInfo(name);
	}

	public int getHoldability() throws SQLException
	{
		return targetConn.getHoldability();
	}

	public synchronized DatabaseMetaData getMetaData() throws SQLException
	{
		if(dbMetaData==null)
		{
			dbMetaData = new DBDatabaseMetaData(this);
		}
		return dbMetaData;
	}

	public int getTransactionIsolation() throws SQLException
	{
		return targetConn.getTransactionIsolation();
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException
	{
		return targetConn.getTypeMap();
	}

	public SQLWarning getWarnings() throws SQLException
	{
		return targetConn.getWarnings();
	}

	public boolean isClosed() throws SQLException
	{
		return targetConn.isClosed();
	}

	public boolean isReadOnly() throws SQLException
	{
		return targetConn.isReadOnly();
	}

	public boolean isValid(int timeout) throws SQLException
	{
		return targetConn.isValid(timeout);
	}

	public String nativeSQL(String sql) throws SQLException
	{
		return targetConn.nativeSQL(sql);
	}

	public CallableStatement prepareCall(String sql) throws SQLException
	{
		// 存储过程调用不翻译
		CallableStatement stmt = targetConn.prepareCall(sql);
		return new DBCallableStatement(this, stmt);
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException
	{
		// 存储过程调用不翻译
		CallableStatement stmt = targetConn.prepareCall(sql, resultSetType,
				resultSetConcurrency);
		return new DBCallableStatement(this, stmt);
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException
	{
		// 存储过程调用不翻译
		CallableStatement stmt = targetConn.prepareCall(sql, resultSetType,
				resultSetConcurrency, resultSetHoldability);
		return new DBCallableStatement(this, stmt);
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException
	{
		PreparedStatement stmt = targetConn.prepareStatement(translateSQL(sql));
		return new DBPreparedStatement(this, stmt);
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException
	{
		PreparedStatement stmt = targetConn.prepareStatement(translateSQL(sql),
				autoGeneratedKeys);
		return new DBPreparedStatement(this, stmt);
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException
	{
		PreparedStatement stmt = targetConn.prepareStatement(translateSQL(sql),
				columnIndexes);
		return new DBPreparedStatement(this, stmt);
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException
	{
		PreparedStatement stmt = targetConn.prepareStatement(translateSQL(sql),
				columnNames);
		return new DBPreparedStatement(this, stmt);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException
	{
		PreparedStatement stmt = targetConn.prepareStatement(translateSQL(sql),
				resultSetType, resultSetConcurrency);
		return new DBPreparedStatement(this, stmt);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException
	{
		PreparedStatement stmt = targetConn.prepareStatement(translateSQL(sql),
				resultSetType, resultSetConcurrency, resultSetHoldability);
		return new DBPreparedStatement(this, stmt);
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException
	{
		targetConn.releaseSavepoint(savepoint);
	}

	public void rollback() throws SQLException
	{
		targetConn.rollback();
	}

	public void rollback(Savepoint savepoint) throws SQLException
	{
		targetConn.rollback(savepoint);
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException
	{
		targetConn.setAutoCommit(autoCommit);
	}

	public void setCatalog(String catalog) throws SQLException
	{
		targetConn.setCatalog(catalog);
	}

	public void setClientInfo(Properties properties)
			throws SQLClientInfoException
	{
		targetConn.setClientInfo(properties);
	}

	public void setClientInfo(String name, String value)
			throws SQLClientInfoException
	{
		targetConn.setClientInfo(name, value);
	}

	public void setHoldability(int holdability) throws SQLException
	{
		targetConn.setHoldability(holdability);
	}

	public void setReadOnly(boolean readOnly) throws SQLException
	{
		targetConn.setReadOnly(readOnly);
	}

	public Savepoint setSavepoint() throws SQLException
	{
		return targetConn.setSavepoint();
	}

	public Savepoint setSavepoint(String name) throws SQLException
	{
		return targetConn.setSavepoint(name);
	}

	public void setTransactionIsolation(int level) throws SQLException
	{
		targetConn.setTransactionIsolation(level);
	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException
	{
		targetConn.setTypeMap(map);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException
	{
		return targetConn.isWrapperFor(iface);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		return targetConn.unwrap(iface);
	}

}
