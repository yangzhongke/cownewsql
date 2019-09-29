/*
 * com.cownew.cownewsql.imsql.jdbc.DBCallableStatement.java
 * Created on 2007-10-16 ÏÂÎç05:55:08 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class DBCallableStatement extends DBPreparedStatement implements
		CallableStatement
{
	private CallableStatement statement;

	public DBCallableStatement(DBConnection conn, CallableStatement statement)
	{
		super(conn, statement);
		this.statement = statement;
	}

	public Array getArray(int parameterIndex) throws SQLException
	{
		return statement.getArray(parameterIndex);
	}

	public Array getArray(String parameterName) throws SQLException
	{
		return statement.getArray(parameterName);
	}

	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException
	{
		return statement.getBigDecimal(parameterIndex);
	}

	public BigDecimal getBigDecimal(String parameterName) throws SQLException
	{
		return statement.getBigDecimal(parameterName);
	}

	public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException
	{
		return statement.getBigDecimal(parameterIndex, scale);
	}

	public Blob getBlob(int parameterIndex) throws SQLException
	{
		return statement.getBlob(parameterIndex);
	}

	public Blob getBlob(String parameterName) throws SQLException
	{
		return statement.getBlob(parameterName);
	}

	public boolean getBoolean(int parameterIndex) throws SQLException
	{
		return statement.getBoolean(parameterIndex);
	}

	public boolean getBoolean(String parameterName) throws SQLException
	{
		return statement.getBoolean(parameterName);
	}

	public byte getByte(int parameterIndex) throws SQLException
	{
		return statement.getByte(parameterIndex);
	}

	public byte getByte(String parameterName) throws SQLException
	{
		return statement.getByte(parameterName);
	}

	public byte[] getBytes(int parameterIndex) throws SQLException
	{
		return statement.getBytes(parameterIndex);
	}

	public byte[] getBytes(String parameterName) throws SQLException
	{
		return statement.getBytes(parameterName);
	}

	public Reader getCharacterStream(int parameterIndex) throws SQLException
	{
		return statement.getCharacterStream(parameterIndex);
	}

	public Reader getCharacterStream(String parameterName) throws SQLException
	{
		return statement.getCharacterStream(parameterName);
	}

	public Clob getClob(int parameterIndex) throws SQLException
	{
		return statement.getClob(parameterIndex);
	}

	public Clob getClob(String parameterName) throws SQLException
	{
		return statement.getClob(parameterName);
	}

	public Date getDate(int parameterIndex) throws SQLException
	{
		return statement.getDate(parameterIndex);
	}

	public Date getDate(String parameterName) throws SQLException
	{
		return statement.getDate(parameterName);
	}

	public Date getDate(int parameterIndex, Calendar cal) throws SQLException
	{
		return statement.getDate(parameterIndex, cal);
	}

	public Date getDate(String parameterName, Calendar cal) throws SQLException
	{
		return statement.getDate(parameterName, cal);
	}

	public double getDouble(int parameterIndex) throws SQLException
	{
		return statement.getDouble(parameterIndex);
	}

	public double getDouble(String parameterName) throws SQLException
	{
		return statement.getDouble(parameterName);
	}

	public float getFloat(int parameterIndex) throws SQLException
	{
		return statement.getFloat(parameterIndex);
	}

	public float getFloat(String parameterName) throws SQLException
	{
		return statement.getFloat(parameterName);
	}

	public int getInt(int parameterIndex) throws SQLException
	{
		return statement.getInt(parameterIndex);
	}

	public int getInt(String parameterName) throws SQLException
	{
		return statement.getInt(parameterName);
	}

	public long getLong(int parameterIndex) throws SQLException
	{
		return statement.getLong(parameterIndex);
	}

	public long getLong(String parameterName) throws SQLException
	{
		return statement.getLong(parameterName);
	}

	public Reader getNCharacterStream(int parameterIndex) throws SQLException
	{
		return statement.getNCharacterStream(parameterIndex);
	}

	public Reader getNCharacterStream(String parameterName) throws SQLException
	{
		return statement.getNCharacterStream(parameterName);
	}

	public NClob getNClob(int parameterIndex) throws SQLException
	{
		return statement.getNClob(parameterIndex);
	}

	public NClob getNClob(String parameterName) throws SQLException
	{
		return statement.getNClob(parameterName);
	}

	public String getNString(int parameterIndex) throws SQLException
	{
		return statement.getNString(parameterIndex);
	}

	public String getNString(String parameterName) throws SQLException
	{
		return statement.getNString(parameterName);
	}

	public Object getObject(int parameterIndex) throws SQLException
	{
		return statement.getObject(parameterIndex);
	}

	public Object getObject(String parameterName) throws SQLException
	{
		return statement.getObject(parameterName);
	}

	public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException
	{
		return statement.getObject(arg0, arg1);
	}

	public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException
	{
		return statement.getObject(arg0, arg1);
	}

	public Ref getRef(int parameterIndex) throws SQLException
	{
		return statement.getRef(parameterIndex);
	}

	public Ref getRef(String parameterName) throws SQLException
	{
		return statement.getRef(parameterName);
	}

	public RowId getRowId(int parameterIndex) throws SQLException
	{
		return statement.getRowId(parameterIndex);
	}

	public RowId getRowId(String parameterName) throws SQLException
	{
		return statement.getRowId(parameterName);
	}

	public SQLXML getSQLXML(int parameterIndex) throws SQLException
	{
		return statement.getSQLXML(parameterIndex);
	}

	public SQLXML getSQLXML(String parameterName) throws SQLException
	{
		return statement.getSQLXML(parameterName);
	}

	public short getShort(int parameterIndex) throws SQLException
	{
		return statement.getShort(parameterIndex);
	}

	public short getShort(String parameterName) throws SQLException
	{
		return statement.getShort(parameterName);
	}

	public String getString(int parameterIndex) throws SQLException
	{
		return statement.getString(parameterIndex);
	}

	public String getString(String parameterName) throws SQLException
	{
		return statement.getString(parameterName);
	}

	public Time getTime(int parameterIndex) throws SQLException
	{
		return statement.getTime(parameterIndex);
	}

	public Time getTime(String parameterName) throws SQLException
	{
		return statement.getTime(parameterName);
	}

	public Time getTime(int parameterIndex, Calendar cal) throws SQLException
	{
		return statement.getTime(parameterIndex, cal);
	}

	public Time getTime(String parameterName, Calendar cal) throws SQLException
	{
		return statement.getTime(parameterName, cal);
	}

	public Timestamp getTimestamp(int parameterIndex) throws SQLException
	{
		return statement.getTimestamp(parameterIndex);
	}

	public Timestamp getTimestamp(String parameterName) throws SQLException
	{
		return statement.getTimestamp(parameterName);
	}

	public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException
	{
		return statement.getTimestamp(parameterIndex, cal);
	}

	public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException
	{
		return statement.getTimestamp(parameterName, cal);
	}

	public URL getURL(int parameterIndex) throws SQLException
	{
		return statement.getURL(parameterIndex);
	}

	public URL getURL(String parameterName) throws SQLException
	{
		return statement.getURL(parameterName);
	}

	public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException
	{
		statement.registerOutParameter(parameterIndex, sqlType);
	}

	public void registerOutParameter(String parameterName, int sqlType) throws SQLException
	{
		statement.registerOutParameter(parameterName, sqlType);
	}

	public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException
	{
		statement.registerOutParameter(parameterIndex, sqlType, scale);
	}

	public void registerOutParameter(int parameterIndex, int sqlType, String typeName) throws SQLException
	{
		statement.registerOutParameter(parameterIndex, sqlType, typeName);
	}

	public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException
	{
		statement.registerOutParameter(parameterName, sqlType, scale);
	}

	public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException
	{
		statement.registerOutParameter(parameterName, sqlType, typeName);
	}

	public void setAsciiStream(String parameterName, InputStream x) throws SQLException
	{
		statement.setAsciiStream(parameterName, x);
	}

	public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException
	{
		statement.setAsciiStream(parameterName, x, length);
	}

	public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException
	{
		statement.setAsciiStream(parameterName, x, length);
	}

	public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException
	{
		statement.setBigDecimal(parameterName, x);
	}

	public void setBinaryStream(String parameterName, InputStream x) throws SQLException
	{
		statement.setBinaryStream(parameterName, x);
	}

	public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException
	{
		statement.setBinaryStream(parameterName, x, length);
	}

	public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException
	{
		statement.setBinaryStream(parameterName, x, length);
	}

	public void setBlob(String parameterName, Blob x) throws SQLException
	{
		statement.setBlob(parameterName, x);
	}

	public void setBlob(String parameterName, InputStream inputStream) throws SQLException
	{
		statement.setBlob(parameterName, inputStream);
	}

	public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException
	{
		statement.setBlob(parameterName, inputStream, length);
	}

	public void setBoolean(String parameterName, boolean x) throws SQLException
	{
		statement.setBoolean(parameterName, x);
	}

	public void setByte(String parameterName, byte x) throws SQLException
	{
		statement.setByte(parameterName, x);
	}

	public void setBytes(String parameterName, byte[] x) throws SQLException
	{
		statement.setBytes(parameterName, x);
	}

	public void setCharacterStream(String parameterName, Reader reader) throws SQLException
	{
		statement.setCharacterStream(parameterName, reader);
	}

	public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException
	{
		statement.setCharacterStream(parameterName, reader, length);
	}

	public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException
	{
		statement.setCharacterStream(parameterName, reader, length);
	}

	public void setClob(String parameterName, Clob x) throws SQLException
	{
		statement.setClob(parameterName, x);
	}

	public void setClob(String parameterName, Reader reader) throws SQLException
	{
		statement.setClob(parameterName, reader);
	}

	public void setClob(String parameterName, Reader reader, long length) throws SQLException
	{
		statement.setClob(parameterName, reader, length);
	}

	public void setDate(String parameterName, Date x) throws SQLException
	{
		statement.setDate(parameterName, x);
	}

	public void setDate(String parameterName, Date x, Calendar cal) throws SQLException
	{
		statement.setDate(parameterName, x, cal);
	}

	public void setDouble(String parameterName, double x) throws SQLException
	{
		statement.setDouble(parameterName, x);
	}

	public void setFloat(String parameterName, float x) throws SQLException
	{
		statement.setFloat(parameterName, x);
	}

	public void setInt(String parameterName, int x) throws SQLException
	{
		statement.setInt(parameterName, x);
	}

	public void setLong(String parameterName, long x) throws SQLException
	{
		statement.setLong(parameterName, x);
	}

	public void setNCharacterStream(String parameterName, Reader value) throws SQLException
	{
		statement.setNCharacterStream(parameterName, value);
	}

	public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException
	{
		statement.setNCharacterStream(parameterName, value, length);
	}

	public void setNClob(String parameterName, NClob value) throws SQLException
	{
		statement.setNClob(parameterName, value);
	}

	public void setNClob(String parameterName, Reader reader) throws SQLException
	{
		statement.setNClob(parameterName, reader);
	}

	public void setNClob(String parameterName, Reader reader, long length) throws SQLException
	{
		statement.setNClob(parameterName, reader, length);
	}

	public void setNString(String parameterName, String value) throws SQLException
	{
		statement.setNString(parameterName, value);
	}

	public void setNull(String parameterName, int sqlType) throws SQLException
	{
		statement.setNull(parameterName, sqlType);
	}

	public void setNull(String parameterName, int sqlType, String typeName) throws SQLException
	{
		statement.setNull(parameterName, sqlType, typeName);
	}

	public void setObject(String parameterName, Object x) throws SQLException
	{
		statement.setObject(parameterName, x);
	}

	public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException
	{
		statement.setObject(parameterName, x, targetSqlType);
	}

	public void setObject(String parameterName, Object x, int targetSqlType, int scale) throws SQLException
	{
		statement.setObject(parameterName, x, targetSqlType, scale);
	}

	public void setRowId(String parameterName, RowId x) throws SQLException
	{
		statement.setRowId(parameterName, x);
	}

	public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException
	{
		statement.setSQLXML(parameterName, xmlObject);
	}

	public void setShort(String parameterName, short x) throws SQLException
	{
		statement.setShort(parameterName, x);
	}

	public void setString(String parameterName, String x) throws SQLException
	{
		statement.setString(parameterName, x);
	}

	public void setTime(String parameterName, Time x) throws SQLException
	{
		statement.setTime(parameterName, x);
	}

	public void setTime(String parameterName, Time x, Calendar cal) throws SQLException
	{
		statement.setTime(parameterName, x, cal);
	}

	public void setTimestamp(String parameterName, Timestamp x) throws SQLException
	{
		statement.setTimestamp(parameterName, x);
	}

	public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException
	{
		statement.setTimestamp(parameterName, x,cal);
	}

	public void setURL(String parameterName, URL val) throws SQLException
	{
		statement.setURL(parameterName, val);
	}

	public boolean wasNull() throws SQLException
	{
		return statement.wasNull();
	}

}
