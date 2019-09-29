/*
 * com.cownew.cownewsql.imsql.common.dtmgr.DataTypeMgr.java
 * Created on 2007-10-27 ÏÂÎç04:39:37 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql.common.dtmgr;

import java.sql.DatabaseMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DataTypeMgr
{

	private static final DataTypeMgr instance = new DataTypeMgr();

	public static DataTypeMgr getInstance()
	{
		return instance;
	}

	private List<DataTypeInfo> dtList;

	public List<DataTypeInfo> getDataTypes()
	{
		return dtList;
	}

	private DataTypeMgr()
	{
		dtList = new ArrayList<DataTypeInfo>();
		addInt();
		addVarchar();
		addDecimal();
		addDateTime();
		addBlob();
		addClob();
		addChar();
		addNChar();
		addNClob();
	}

	private void addNClob()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("");
		dtInfo.setDataType(Types.NCLOB);
		dtInfo.setName("NClob");
		dtInfo.setNullable(DatabaseMetaData.attributeNullable);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredNone);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addNChar()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("(int_size)");
		dtInfo.setDataType(Types.NCHAR);
		dtInfo.setName("NCHAR");
		dtInfo.setNullable(DatabaseMetaData.attributeNullable);
		dtInfo.setSearchable((short) DatabaseMetaData.typeSearchable);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addChar()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("(int_size)");
		dtInfo.setDataType(Types.CHAR);
		dtInfo.setName("CHAR");
		dtInfo.setNullable(DatabaseMetaData.attributeNullable);
		dtInfo.setSearchable((short) DatabaseMetaData.typeSearchable);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addClob()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("");
		dtInfo.setDataType(Types.CLOB);
		dtInfo.setNames(new String[] { "CLOB", "TINYTEXT", "LONGTEXT", "TEXT",
				"LONGVARCHAR" });
		dtInfo.setNullable(DatabaseMetaData.attributeNullable);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredNone);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addBlob()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("");
		dtInfo.setDataType(Types.BLOB);
		dtInfo.setNames(new String[] { "BLOB", "TINYBLOB", "LONGBLOB",
				"BINARY", "VARBINARY", "LONGVARBINARY", "IMAGE" });
		dtInfo.setNullable(DatabaseMetaData.attributeNullable);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredNone);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addDateTime()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("");
		dtInfo.setDataType(Types.TIMESTAMP);
		dtInfo
				.setNames(new String[] { "datetime", "date", "timestamp",
						"time" });
		dtInfo.setNullable(DatabaseMetaData.attributeNullableUnknown);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredBasic);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addDecimal()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("(int_length,int_precision)");
		dtInfo.setDataType(Types.DECIMAL);
		dtInfo.setNames(new String[] { "decimal", "numeric", "real", "float",
				"double" });
		dtInfo.setNullable(DatabaseMetaData.attributeNullableUnknown);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredBasic);
		dtInfo.setUnsigned(false);
		dtList.add(dtInfo);
	}

	private void addVarchar()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("(int_length)");
		dtInfo.setDataType(Types.VARCHAR);
		dtInfo.setName("VARCHAR");
		dtInfo.setNullable(DatabaseMetaData.attributeNullableUnknown);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredChar);
		dtInfo.setUnsigned(true);
		dtList.add(dtInfo);
	}

	private void addInt()
	{
		DataTypeInfo dtInfo = new DataTypeInfo();
		dtInfo.setCaseSensitive(true);
		dtInfo.setCreateParams("");
		dtInfo.setDataType(Types.INTEGER);
		dtInfo.setNames(new String[] { "int", "integer", "tinyint", "smallint",
				"bit", "boolean" });
		dtInfo.setNullable(DatabaseMetaData.attributeNullableUnknown);
		dtInfo.setSearchable((short) DatabaseMetaData.typePredBasic);
		dtInfo.setUnsigned(false);
		dtList.add(dtInfo);
	}
}
