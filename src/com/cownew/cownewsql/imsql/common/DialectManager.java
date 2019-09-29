package com.cownew.cownewsql.imsql.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.dialect.DB2UDBTranslator;
import com.cownew.cownewsql.imsql.dialect.MSSQLServerTranslator;
import com.cownew.cownewsql.imsql.dialect.MYSQLTranslator;
import com.cownew.cownewsql.imsql.dialect.Oracle9iTranslator;

public class DialectManager
{
	private static final Map<String, Class> translatorMap = new HashMap<String, Class>();

	public static void registerTranslator(String dbType, Class translatorClass)
	{
		if (!ISQLTranslator.class.isAssignableFrom(translatorClass))
		{
			throw new IllegalArgumentException(
					"Translator's Class must implement ISQLTranslator!");
		}
		translatorMap.put(dbType.toUpperCase(), translatorClass);
	}

	public static void unregisterTranslator(String dbType)
	{
		translatorMap.remove(dbType.toUpperCase());
	}

	public static String[] getRegisteredTranslator()
	{
		Set<String> keySet = translatorMap.keySet();
		return keySet.toArray(new String[keySet.size()]);
	}

	public static ISQLTranslator createTranslator(String dbType)
	{
		Class clz = translatorMap.get(dbType.toUpperCase());
		if (clz == null)
		{
			throw new IllegalArgumentException(
					"unkown dbType,the registerd dbType as follows:"
							+ translatorMap.keySet());
		}
		ISQLTranslator translator = null;
		try
		{
			translator = (ISQLTranslator) clz.newInstance();
		} catch (InstantiationException ex)
		{
			throw new RuntimeException(ex);
		} catch (IllegalAccessException ex)
		{
			throw new RuntimeException(ex);
		}
		return translator;
	}

	static
	{
		registerTranslator("mssql", MSSQLServerTranslator.class);
		registerTranslator("sqlserver", MSSQLServerTranslator.class);
		registerTranslator("mssqlserver", MSSQLServerTranslator.class);
		registerTranslator("mysql", MYSQLTranslator.class);
		registerTranslator("Oracle", Oracle9iTranslator.class);
		registerTranslator("db2", DB2UDBTranslator.class);
		registerTranslator("db2udb", DB2UDBTranslator.class);
	}
}
