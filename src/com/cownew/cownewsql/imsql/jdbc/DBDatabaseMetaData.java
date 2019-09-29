/*
 * com.cownew.cownewsql.imsql.jdbc.DBDatabaseMetaData.java
 * Created on 2007-10-23 下午02:17:27 by 杨中科
 */

package com.cownew.cownewsql.imsql.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cownew.cownewsql.imsql.common.dtmgr.DataTypeInfo;
import com.cownew.cownewsql.imsql.common.dtmgr.DataTypeMgr;
import com.cownew.cownewsql.imsql.common.methodmgr.FunctionTypeEnum;

public class DBDatabaseMetaData implements DatabaseMetaData
{
	private DatabaseMetaData targetDBMetaData;

	private DBConnection dbConnection;

	public DBDatabaseMetaData(DBConnection dbConnection) throws SQLException
	{
		super();
		this.dbConnection = dbConnection;
		this.targetDBMetaData = dbConnection.getTargetConnection()
				.getMetaData();
	}

	public boolean allProceduresAreCallable() throws SQLException
	{
		return false;
	}

	public boolean allTablesAreSelectable() throws SQLException
	{
		return targetDBMetaData.allTablesAreSelectable();
	}

	public boolean autoCommitFailureClosesAllResultSets() throws SQLException
	{
		return targetDBMetaData.autoCommitFailureClosesAllResultSets();
	}

	public boolean dataDefinitionCausesTransactionCommit() throws SQLException
	{
		return targetDBMetaData.dataDefinitionCausesTransactionCommit();
	}

	public boolean dataDefinitionIgnoredInTransactions() throws SQLException
	{
		return targetDBMetaData.dataDefinitionIgnoredInTransactions();
	}

	public boolean deletesAreDetected(int type) throws SQLException
	{
		return targetDBMetaData.deletesAreDetected(type);
	}

	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException
	{
		return targetDBMetaData.doesMaxRowSizeIncludeBlobs();
	}

	public ResultSet getAttributes(String catalog, String schemaPattern,
			String typeNamePattern, String attributeNamePattern)
			throws SQLException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select '' as TYPE_CAT,'' as TYPE_SCHEM,'' as TYPE_NAME,");
		sb.append("'' as ATTR_NAME,0 as DATA_TYPE,'' as ATTR_TYPE_NAME,");
		sb.append("0 as ATTR_SIZE,0 as DECIMAL_DIGITS,0 as NUM_PREC_RADIX,");
		sb
				.append("0 as NULLABLE,'' as REMARKS,'' as ATTR_DEF ,0 as SQL_DATA_TYPE,");
		sb
				.append("0 as SQL_DATETIME_SUB,0 as CHAR_OCTET_LENGTH ,0 as ORDINAL_POSITION,");
		sb.append("'' as IS_NULLABLE,'' as SCOPE_CATALOG,'' as SCOPE_SCHEMA,");
		sb.append("'' as SCOPE_TABLE,0 as SOURCE_DATA_TYPE \n");
		// empty resultset
		sb.append("where 1<>1");
		PreparedStatement ps = dbConnection.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		return new DBMetaDataResultSet(rs);
	}

	public ResultSet getBestRowIdentifier(String catalog, String schema,
			String table, int scope, boolean nullable) throws SQLException
	{
		return targetDBMetaData.getBestRowIdentifier(catalog, schema, table,
				scope, nullable);
	}

	public String getCatalogSeparator() throws SQLException
	{
		return targetDBMetaData.getCatalogSeparator();
	}

	public String getCatalogTerm() throws SQLException
	{
		return targetDBMetaData.getCatalogTerm();
	}

	public ResultSet getCatalogs() throws SQLException
	{
		return targetDBMetaData.getCatalogs();
	}

	public ResultSet getClientInfoProperties() throws SQLException
	{
		return targetDBMetaData.getClientInfoProperties();
	}

	public ResultSet getColumnPrivileges(String catalog, String schema,
			String table, String columnNamePattern) throws SQLException
	{
		return targetDBMetaData.getColumnPrivileges(catalog, schema, table,
				columnNamePattern);
	}

	public ResultSet getColumns(String catalog, String schemaPattern,
			String tableNamePattern, String columnNamePattern)
			throws SQLException
	{
		return targetDBMetaData.getColumns(catalog, schemaPattern,
				tableNamePattern, columnNamePattern);
	}

	public Connection getConnection() throws SQLException
	{
		return dbConnection;
	}

	public ResultSet getCrossReference(String parentCatalog,
			String parentSchema, String parentTable, String foreignCatalog,
			String foreignSchema, String foreignTable) throws SQLException
	{
		return targetDBMetaData.getCrossReference(parentCatalog, parentSchema,
				parentTable, foreignCatalog, foreignSchema, foreignTable);
	}

	public int getDatabaseMajorVersion() throws SQLException
	{
		return targetDBMetaData.getDatabaseMajorVersion();
	}

	public int getDatabaseMinorVersion() throws SQLException
	{
		return targetDBMetaData.getDatabaseMinorVersion();
	}

	public String getDatabaseProductName() throws SQLException
	{
		return targetDBMetaData.getDatabaseProductName();
	}

	public String getDatabaseProductVersion() throws SQLException
	{
		return targetDBMetaData.getDatabaseProductVersion();
	}

	public int getDefaultTransactionIsolation() throws SQLException
	{
		return targetDBMetaData.getDefaultTransactionIsolation();
	}

	public int getDriverMajorVersion()
	{
		return 1;
	}

	public int getDriverMinorVersion()
	{
		return 5;
	}

	public String getDriverName() throws SQLException
	{
		return "CowNewSQL JDBC Driver";
	}

	public String getDriverVersion() throws SQLException
	{
		return "1.5.0.0";
	}

	public ResultSet getExportedKeys(String catalog, String schema, String table)
			throws SQLException
	{
		return targetDBMetaData.getExportedKeys(catalog, schema, table);
	}

	public String getExtraNameCharacters() throws SQLException
	{
		// TODO:support # and $
		return "";
	}

	public ResultSet getFunctionColumns(String catalog, String schemaPattern,
			String functionNamePattern, String columnNamePattern)
			throws SQLException
	{
		List list = new ArrayList();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from(show functioncolumns) as t\n");
		sb.append("where t.FUNCTION_NAME like ? and t.COLUMN_NAME like? ");
		list.add(functionNamePattern);
		list.add(columnNamePattern);
		if (catalog != null && catalog.length() > 0)
		{
			sb.append("and t.FUNCTION_CAT like ?");
			list.add(catalog);
		}
		if (schemaPattern != null && schemaPattern.length() > 0)
		{
			sb.append("and t.FUNCTION_SCHEM like ?");
			list.add(schemaPattern);
		}
		PreparedStatement ps = dbConnection.prepareStatement(sb.toString());
		for (int i = 0, n = list.size(); i < n; i++)
		{
			ps.setObject(i + 1, list.get(i));
		}
		return new DBMetaDataResultSet(ps.executeQuery());
	}

	public ResultSet getFunctions(String catalog, String schemaPattern,
			String functionNamePattern) throws SQLException
	{
		List list = new ArrayList();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from(show functions)as t\n");
		sb.append("where t.FUNCTION_NAME like ?");
		list.add(functionNamePattern);
		if (catalog != null && catalog.length() > 0)
		{
			sb.append("and t.FUNCTION_CAT like ?");
			list.add(catalog);
		}
		if (schemaPattern != null && schemaPattern.length() > 0)
		{
			sb.append("and t.FUNCTION_SCHEM like ?");
			list.add(schemaPattern);
		}
		PreparedStatement ps = dbConnection.prepareStatement(sb.toString());
		for (int i = 0, n = list.size(); i < n; i++)
		{
			ps.setObject(i + 1, list.get(i));
		}
		return new DBMetaDataResultSet(ps.executeQuery());
	}

	public String getIdentifierQuoteString() throws SQLException
	{
		return " ";
	}

	public ResultSet getImportedKeys(String catalog, String schema, String table)
			throws SQLException
	{
		return targetDBMetaData.getImportedKeys(catalog, schema, table);
	}

	public ResultSet getIndexInfo(String catalog, String schema, String table,
			boolean unique, boolean approximate) throws SQLException
	{
		return targetDBMetaData.getIndexInfo(catalog, schema, table, unique,
				approximate);
	}

	public int getJDBCMajorVersion() throws SQLException
	{
		return 3;
	}

	public int getJDBCMinorVersion() throws SQLException
	{
		return 0;
	}

	public int getMaxBinaryLiteralLength() throws SQLException
	{
		return targetDBMetaData.getMaxBinaryLiteralLength();
	}

	public int getMaxCatalogNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxCatalogNameLength();
	}

	public int getMaxCharLiteralLength() throws SQLException
	{
		return targetDBMetaData.getMaxCharLiteralLength();
	}

	public int getMaxColumnNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxColumnNameLength();
	}

	public int getMaxColumnsInGroupBy() throws SQLException
	{
		return targetDBMetaData.getMaxColumnsInGroupBy();
	}

	public int getMaxColumnsInIndex() throws SQLException
	{
		return targetDBMetaData.getMaxColumnsInIndex();
	}

	public int getMaxColumnsInOrderBy() throws SQLException
	{
		return targetDBMetaData.getMaxColumnsInOrderBy();
	}

	public int getMaxColumnsInSelect() throws SQLException
	{
		return targetDBMetaData.getMaxColumnsInSelect();
	}

	public int getMaxColumnsInTable() throws SQLException
	{
		return targetDBMetaData.getMaxColumnsInTable();
	}

	public int getMaxConnections() throws SQLException
	{
		return targetDBMetaData.getMaxConnections();
	}

	public int getMaxCursorNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxCursorNameLength();
	}

	public int getMaxIndexLength() throws SQLException
	{
		return targetDBMetaData.getMaxIndexLength();
	}

	public int getMaxProcedureNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxProcedureNameLength();
	}

	public int getMaxRowSize() throws SQLException
	{
		return targetDBMetaData.getMaxRowSize();
	}

	public int getMaxSchemaNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxSchemaNameLength();
	}

	public int getMaxStatementLength() throws SQLException
	{
		return targetDBMetaData.getMaxStatementLength();
	}

	public int getMaxStatements() throws SQLException
	{
		return targetDBMetaData.getMaxStatements();
	}

	public int getMaxTableNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxTableNameLength();
	}

	public int getMaxTablesInSelect() throws SQLException
	{
		return targetDBMetaData.getMaxTablesInSelect();
	}

	public int getMaxUserNameLength() throws SQLException
	{
		return targetDBMetaData.getMaxUserNameLength();
	}

	public String getNumericFunctions() throws SQLException
	{
		return queryFunctions(FunctionTypeEnum.NUMBRIC);
	}

	public String getStringFunctions() throws SQLException
	{
		return queryFunctions(FunctionTypeEnum.STRING);
	}

	public String getSystemFunctions() throws SQLException
	{
		return queryFunctions(FunctionTypeEnum.SYSTEM);
	}

	public String getTimeDateFunctions() throws SQLException
	{
		return queryFunctions(FunctionTypeEnum.DATETIME);
	}

	private String queryFunctions(FunctionTypeEnum type) throws SQLException
	{
		StringBuffer sb = new StringBuffer(
				"select t.FUNCTION_NAME as FUNCTION_NAME from(show functions) as t\n");
		sb.append("where t.TYPE=?");
		StringBuffer sbResult = new StringBuffer();
		boolean isFirst = true;
		String funcType = type.getName();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			ps = dbConnection.prepareStatement(sb.toString());

			ps.setString(1, funcType);
			rs = ps.executeQuery();
			while (rs.next())
			{
				if (!isFirst)
				{
					sbResult.append(",");
				}
				sbResult.append(rs.getString(1));
				isFirst = false;
			}
		} finally
		{
			closePSRS(ps, rs);
		}

		return sbResult.toString();
	}

	private void closePSRS(PreparedStatement ps, ResultSet rs)
			throws SQLException
	{
		try
		{
			rs.close();
		} finally
		{
			ps.close();
		}
	}

	public ResultSet getPrimaryKeys(String catalog, String schema, String table)
			throws SQLException
	{
		return targetDBMetaData.getPrimaryKeys(catalog, schema, table);
	}

	public ResultSet getProcedureColumns(String catalog, String schemaPattern,
			String procedureNamePattern, String columnNamePattern)
			throws SQLException
	{
		return targetDBMetaData.getProcedureColumns(catalog, schemaPattern,
				procedureNamePattern, columnNamePattern);
	}

	public String getProcedureTerm() throws SQLException
	{
		return targetDBMetaData.getProcedureTerm();
	}

	public ResultSet getProcedures(String catalog, String schemaPattern,
			String procedureNamePattern) throws SQLException
	{
		return targetDBMetaData.getProcedures(catalog, schemaPattern,
				procedureNamePattern);
	}

	public int getResultSetHoldability() throws SQLException
	{
		return targetDBMetaData.getResultSetHoldability();
	}

	public RowIdLifetime getRowIdLifetime() throws SQLException
	{
		return targetDBMetaData.getRowIdLifetime();
	}

	public String getSQLKeywords() throws SQLException
	{
		return "DATETIME,DATE,TEXT,TOP,SHOW,ROWNUM,LIMIT,TINYINT,SMALLINT,BIT,BOOLEAN,DECIMAL,NUMERIC,REAL,FLOAT,DOUBLE,TINYBLOB,LONGBLOB,BINARY,VARBINARY,LONGVARBINARY,IMAGE,TINYTEXT,LONGTEXT,LONGVARCHAR,TABLES,FUNCTIONS,FUNCTIONCOLUMNS,PRECISION";
	}

	public int getSQLStateType() throws SQLException
	{
		return targetDBMetaData.getSQLStateType();
	}

	public String getSchemaTerm() throws SQLException
	{
		return targetDBMetaData.getSchemaTerm();
	}

	public ResultSet getSchemas() throws SQLException
	{
		return targetDBMetaData.getSchemas();
	}

	public ResultSet getSchemas(String catalog, String schemaPattern)
			throws SQLException
	{
		return targetDBMetaData.getSchemas(catalog, schemaPattern);
	}

	public String getSearchStringEscape() throws SQLException
	{
		// TODO:提供统一的支持
		return targetDBMetaData.getSearchStringEscape();
	}

	public ResultSet getSuperTables(String catalog, String schemaPattern,
			String tableNamePattern) throws SQLException
	{
		return targetDBMetaData.getSuperTables(catalog, schemaPattern,
				tableNamePattern);
	}

	public ResultSet getSuperTypes(String catalog, String schemaPattern,
			String typeNamePattern) throws SQLException
	{
		return targetDBMetaData.getSuperTypes(catalog, schemaPattern,
				typeNamePattern);
	}

	public ResultSet getTablePrivileges(String catalog, String schemaPattern,
			String tableNamePattern) throws SQLException
	{
		return targetDBMetaData.getTablePrivileges(catalog, schemaPattern,
				tableNamePattern);
	}

	public ResultSet getTableTypes() throws SQLException
	{
		return targetDBMetaData.getTableTypes();
	}

	public ResultSet getTables(String catalog, String schemaPattern,
			String tableNamePattern, String[] types) throws SQLException
	{
		return targetDBMetaData.getTables(catalog, schemaPattern,
				tableNamePattern, types);
	}

	public ResultSet getTypeInfo() throws SQLException
	{
		boolean isFirstSQL = true;
		StringBuffer sb = new StringBuffer();
		sb.append("select * from(\n");

		List<DataTypeInfo> dtList = DataTypeMgr.getInstance().getDataTypes();
		for (int i = 0, n = dtList.size(); i < n; i++)
		{
			DataTypeInfo dtInfo = dtList.get(i);
			fillGetTypeInfo(sb, dtInfo, isFirstSQL);
			isFirstSQL = false;
		}
		sb.append(") as t order by t.DATA_TYPE");
		PreparedStatement ps = dbConnection.prepareStatement(sb.toString());
		return new DBMetaDataResultSet(ps.executeQuery());
	}

	private void fillGetTypeInfo(StringBuffer sb, DataTypeInfo dtInfo,
			boolean isFirstSQL)
	{
		String[] names = dtInfo.getNames();
		for (int i = 0, n = names.length; i < n; i++)
		{
			String name = names[i];
			int dataType = dtInfo.getDataType();
			String createParams = dtInfo.getCreateParams();
			short nullable = dtInfo.getNullable();
			int caseSensitive = dtInfo.isCaseSensitive() ? 0 : 1;
			short searchable = dtInfo.getSearchable();
			int unsigned = dtInfo.isUnsigned() ? 0 : 1;

			if (isFirstSQL == false)
			{
				sb.append("\nUNION ALL\n");
			}
			sb.append("select '").append(name).append("' TYPE_NAME,")
				.append(dataType).append(" DATA_TYPE,32 pk_PRECISION,")
				.append("'' LITERAL_PREFIX,'' LITERAL_SUFFIX,")
				.append("'").append(createParams).append("' CREATE_PARAMS,")
				.append(nullable).append(" NULLABLE,")
				.append(caseSensitive).append(" CASE_SENSITIVE,")
				.append(searchable).append(" SEARCHABLE,")
				.append(unsigned).append(" UNSIGNED_ATTRIBUTE,")
				.append("-1 FIXED_PREC_SCALE,")
				.append("0 ISAUTO_INCREMENT,'' LOCAL_TYPE_NAME,-1 MINIMUM_SCALE,-1 MAXIMUM_SCALE,")
				.append("0 SQL_DATA_TYPE,0 SQL_DATETIME_SUB ,10 NUM_PREC_RADIX");
			isFirstSQL = false;
		}
	}

	public ResultSet getUDTs(String catalog, String schemaPattern,
			String typeNamePattern, int[] types) throws SQLException
	{
		return targetDBMetaData.getUDTs(catalog, schemaPattern,
				typeNamePattern, types);
	}

	public String getURL() throws SQLException
	{
		return dbConnection.getUrl();
	}

	public String getUserName() throws SQLException
	{
		return targetDBMetaData.getUserName();
	}

	public ResultSet getVersionColumns(String catalog, String schema,
			String table) throws SQLException
	{
		return targetDBMetaData.getVersionColumns(catalog, schema, table);
	}

	public boolean insertsAreDetected(int type) throws SQLException
	{
		return targetDBMetaData.insertsAreDetected(type);
	}

	public boolean isCatalogAtStart() throws SQLException
	{
		return targetDBMetaData.isCatalogAtStart();
	}

	public boolean isReadOnly() throws SQLException
	{
		return targetDBMetaData.isReadOnly();
	}

	public boolean locatorsUpdateCopy() throws SQLException
	{
		return targetDBMetaData.locatorsUpdateCopy();
	}

	public boolean nullPlusNonNullIsNull() throws SQLException
	{
		return targetDBMetaData.nullPlusNonNullIsNull();
	}

	public boolean nullsAreSortedAtEnd() throws SQLException
	{
		return targetDBMetaData.nullsAreSortedAtEnd();
	}

	public boolean nullsAreSortedAtStart() throws SQLException
	{
		return targetDBMetaData.nullsAreSortedAtStart();
	}

	public boolean nullsAreSortedHigh() throws SQLException
	{
		return targetDBMetaData.nullsAreSortedHigh();
	}

	public boolean nullsAreSortedLow() throws SQLException
	{
		return targetDBMetaData.nullsAreSortedLow();
	}

	public boolean othersDeletesAreVisible(int type) throws SQLException
	{
		return targetDBMetaData.othersDeletesAreVisible(type);
	}

	public boolean othersInsertsAreVisible(int type) throws SQLException
	{
		return targetDBMetaData.othersInsertsAreVisible(type);
	}

	public boolean othersUpdatesAreVisible(int type) throws SQLException
	{
		return targetDBMetaData.othersUpdatesAreVisible(type);
	}

	public boolean ownDeletesAreVisible(int type) throws SQLException
	{
		return targetDBMetaData.ownDeletesAreVisible(type);
	}

	public boolean ownInsertsAreVisible(int type) throws SQLException
	{
		return targetDBMetaData.ownInsertsAreVisible(type);
	}

	public boolean ownUpdatesAreVisible(int type) throws SQLException
	{
		return targetDBMetaData.ownUpdatesAreVisible(type);
	}

	public boolean storesLowerCaseIdentifiers() throws SQLException
	{
		return targetDBMetaData.storesLowerCaseIdentifiers();
	}

	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException
	{
		return targetDBMetaData.storesLowerCaseQuotedIdentifiers();
	}

	public boolean storesMixedCaseIdentifiers() throws SQLException
	{
		return targetDBMetaData.storesMixedCaseIdentifiers();
	}

	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException
	{
		return targetDBMetaData.storesMixedCaseQuotedIdentifiers();
	}

	public boolean storesUpperCaseIdentifiers() throws SQLException
	{
		return targetDBMetaData.storesUpperCaseIdentifiers();
	}

	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException
	{
		return targetDBMetaData.storesUpperCaseQuotedIdentifiers();
	}

	public boolean supportsANSI92EntryLevelSQL() throws SQLException
	{
		return false;
	}

	public boolean supportsANSI92FullSQL() throws SQLException
	{
		return false;
	}

	public boolean supportsANSI92IntermediateSQL() throws SQLException
	{
		return false;
	}

	public boolean supportsAlterTableWithAddColumn() throws SQLException
	{
		return true;
	}

	public boolean supportsAlterTableWithDropColumn() throws SQLException
	{
		return false;
	}

	public boolean supportsBatchUpdates() throws SQLException
	{
		return targetDBMetaData.supportsBatchUpdates();
	}

	public boolean supportsCatalogsInDataManipulation() throws SQLException
	{
		// TODO:支持表名前的前缀：sys.t_1
		return false;
	}

	public boolean supportsCatalogsInIndexDefinitions() throws SQLException
	{
		return false;
	}

	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException
	{
		return false;
	}

	public boolean supportsCatalogsInProcedureCalls() throws SQLException
	{
		return false;
	}

	public boolean supportsCatalogsInTableDefinitions() throws SQLException
	{
		// TODO:支持表名前的前缀：sys.t_1
		return false;
	}

	public boolean supportsColumnAliasing() throws SQLException
	{
		return true;
	}

	public boolean supportsConvert() throws SQLException
	{
		return true;
	}

	public boolean supportsConvert(int fromType, int toType)
			throws SQLException
	{
		// only know whether the toType is supported
		if (toType == Types.CHAR || toType == Types.VARCHAR
				|| toType == Types.DATE || toType == Types.TIME
				|| toType == Types.DECIMAL || toType == Types.NUMERIC
				|| toType == Types.INTEGER)
		{
			return targetDBMetaData.supportsConvert(fromType, toType);
		}
		return false;
	}

	public boolean supportsCoreSQLGrammar() throws SQLException
	{
		return false;
	}

	public boolean supportsCorrelatedSubqueries() throws SQLException
	{
		return true;
	}

	public boolean supportsDataDefinitionAndDataManipulationTransactions()
			throws SQLException
	{
		return targetDBMetaData
				.supportsDataDefinitionAndDataManipulationTransactions();
	}

	public boolean supportsDataManipulationTransactionsOnly()
			throws SQLException
	{
		return targetDBMetaData.supportsDataManipulationTransactionsOnly();
	}

	public boolean supportsDifferentTableCorrelationNames() throws SQLException
	{
		return true;
	}

	public boolean supportsExpressionsInOrderBy() throws SQLException
	{
		return targetDBMetaData.supportsExpressionsInOrderBy();
	}

	public boolean supportsExtendedSQLGrammar() throws SQLException
	{
		return false;
	}

	public boolean supportsFullOuterJoins() throws SQLException
	{
		return false;
	}

	public boolean supportsGetGeneratedKeys() throws SQLException
	{
		return targetDBMetaData.supportsGetGeneratedKeys();
	}

	public boolean supportsGroupBy() throws SQLException
	{
		return true;
	}

	public boolean supportsGroupByBeyondSelect() throws SQLException
	{
		return targetDBMetaData.supportsGroupByBeyondSelect();
	}

	public boolean supportsGroupByUnrelated() throws SQLException
	{
		return targetDBMetaData.supportsGroupByUnrelated();
	}

	public boolean supportsIntegrityEnhancementFacility() throws SQLException
	{
		return false;
	}

	public boolean supportsLikeEscapeClause() throws SQLException
	{
		// TODO:支持Like中的转义符
		return false;
	}

	public boolean supportsLimitedOuterJoins() throws SQLException
	{
		return true;
	}

	public boolean supportsMinimumSQLGrammar() throws SQLException
	{
		return false;
	}

	public boolean supportsMixedCaseIdentifiers() throws SQLException
	{
		return false;
	}

	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException
	{
		return false;
	}

	public boolean supportsMultipleOpenResults() throws SQLException
	{
		return targetDBMetaData.supportsMultipleOpenResults();
	}

	public boolean supportsMultipleResultSets() throws SQLException
	{
		return targetDBMetaData.supportsMultipleResultSets();
	}

	public boolean supportsMultipleTransactions() throws SQLException
	{
		return targetDBMetaData.supportsMultipleTransactions();
	}

	public boolean supportsNamedParameters() throws SQLException
	{
		return targetDBMetaData.supportsNamedParameters();
	}

	public boolean supportsNonNullableColumns() throws SQLException
	{
		return targetDBMetaData.supportsNonNullableColumns();
	}

	public boolean supportsOpenCursorsAcrossCommit() throws SQLException
	{
		return targetDBMetaData.supportsOpenCursorsAcrossCommit();
	}

	public boolean supportsOpenCursorsAcrossRollback() throws SQLException
	{
		return targetDBMetaData.supportsOpenCursorsAcrossRollback();
	}

	public boolean supportsOpenStatementsAcrossCommit() throws SQLException
	{
		return targetDBMetaData.supportsOpenStatementsAcrossCommit();
	}

	public boolean supportsOpenStatementsAcrossRollback() throws SQLException
	{
		return targetDBMetaData.supportsOpenStatementsAcrossRollback();
	}

	public boolean supportsOrderByUnrelated() throws SQLException
	{
		return targetDBMetaData.supportsOrderByUnrelated();
	}

	public boolean supportsOuterJoins() throws SQLException
	{
		return true;
	}

	public boolean supportsPositionedDelete() throws SQLException
	{
		return targetDBMetaData.supportsPositionedDelete();
	}

	public boolean supportsPositionedUpdate() throws SQLException
	{
		return targetDBMetaData.supportsPositionedUpdate();
	}

	public boolean supportsResultSetConcurrency(int type, int concurrency)
			throws SQLException
	{
		return targetDBMetaData.supportsResultSetConcurrency(type, concurrency);
	}

	public boolean supportsResultSetHoldability(int holdability)
			throws SQLException
	{
		return targetDBMetaData.supportsResultSetHoldability(holdability);
	}

	public boolean supportsResultSetType(int type) throws SQLException
	{
		return targetDBMetaData.supportsResultSetType(type);
	}

	public boolean supportsSavepoints() throws SQLException
	{
		return targetDBMetaData.supportsSavepoints();
	}

	public boolean supportsSchemasInDataManipulation() throws SQLException
	{
		// TODO:
		return false;
	}

	public boolean supportsSchemasInIndexDefinitions() throws SQLException
	{
		return false;
	}

	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException
	{
		return false;
	}

	public boolean supportsSchemasInProcedureCalls() throws SQLException
	{
		return false;
	}

	public boolean supportsSchemasInTableDefinitions() throws SQLException
	{
		//TODO:
		return false;
	}

	public boolean supportsSelectForUpdate() throws SQLException
	{
		return false;
	}

	public boolean supportsStatementPooling() throws SQLException
	{
		return targetDBMetaData.supportsStatementPooling();
	}

	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException
	{
		return targetDBMetaData.supportsStoredFunctionsUsingCallSyntax();
	}

	public boolean supportsStoredProcedures() throws SQLException
	{
		return false;
	}

	public boolean supportsSubqueriesInComparisons() throws SQLException
	{
		return true;
	}

	public boolean supportsSubqueriesInExists() throws SQLException
	{
		return true;
	}

	public boolean supportsSubqueriesInIns() throws SQLException
	{
		return true;
	}

	public boolean supportsSubqueriesInQuantifieds() throws SQLException
	{
		return true;
	}

	public boolean supportsTableCorrelationNames() throws SQLException
	{
		return false;
	}

	public boolean supportsTransactionIsolationLevel(int level)
			throws SQLException
	{
		return true;
	}

	public boolean supportsTransactions() throws SQLException
	{
		return targetDBMetaData.supportsTransactions();
	}

	public boolean supportsUnion() throws SQLException
	{
		return true;
	}

	public boolean supportsUnionAll() throws SQLException
	{
		return true;
	}

	public boolean updatesAreDetected(int type) throws SQLException
	{
		return targetDBMetaData.updatesAreDetected(type);
	}

	public boolean usesLocalFilePerTable() throws SQLException
	{
		return targetDBMetaData.usesLocalFilePerTable();
	}

	public boolean usesLocalFiles() throws SQLException
	{
		return targetDBMetaData.usesLocalFiles();
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException
	{
		return targetDBMetaData.isWrapperFor(iface);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		return targetDBMetaData.unwrap(iface);
	}

}
