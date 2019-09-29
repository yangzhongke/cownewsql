/*
 * com.cownew.cownewsql.imsql.MSSqlServerTestCase.java
 * Created on 2007-9-14 下午04:58:05 by 杨中科
 */

package com.cownew.cownewsql.imsql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.cownew.cownewsql.imsql.common.DialectManager;
import com.cownew.cownewsql.imsql.jdbc.DBConnection;

import junit.framework.TestCase;

public abstract class DBTestCase extends TestCase
{
	protected Connection conn;

	protected String url;

	protected String userid;

	protected String password;

	protected String jdbcDriver;

	protected String dbType;

	protected void setUp() throws Exception
	{
		super.setUp();
		doSetUp();
		Class.forName(jdbcDriver);
		conn = DriverManager.getConnection(url, userid, password);
	}

	protected abstract void doSetUp();

	protected void execute(String sql) throws Exception
	{
		execute(sql, new Object[0]);
	}

	protected void execute(String sql, Object[] params) throws Exception
	{
		ISQLTranslator tx = DialectManager.createTranslator(dbType);
		String[] venderSQLs = tx.translateSQL(sql);
		if (venderSQLs.length > 1)
		{
			throw new IllegalArgumentException("too many lines!");
		}
		String venderSQL = venderSQLs[0];
		System.out.println(dbType + ":" + venderSQL);
		venderSQL = venderSQL.trim();
		PreparedStatement ps = conn.prepareStatement(venderSQL);
		for (int i = 0, n = params.length; i < n; i++)
		{
			ps.setObject(i + 1, params[i]);
		}
		try
		{
			if (ps.execute() == false)
			{
				return;
			}
			ResultSet rs = ps.getResultSet();
			System.out.println("Query Result AS Follows:");
			showResultSet(rs);
			System.out.println("************************************");
			rs.close();
		} finally
		{
			ps.close();
		}

	}

	private void showResultSet(ResultSet rs) throws SQLException
	{
		ResultSetMetaData md = rs.getMetaData();
		for (int i = 0, n = md.getColumnCount(); i < n; i++)
		{
			System.out.print(md.getColumnName(i + 1));
			System.out.print("|");
		}
		System.out.println();

		while (rs.next())
		{
			StringBuffer sb = new StringBuffer();
			for (int i = 0, n = md.getColumnCount(); i < n; i++)
			{
				sb.append(rs.getObject(i + 1)).append("|");
			}
			System.out.println(sb);
		}
	}

	private void showResultSetThenClose(ResultSet rs) throws SQLException
	{
		showResultSet(rs);
		rs.close();
	}

	protected void tearDown() throws Exception
	{
		conn.close();
		super.tearDown();
	}

	public void testShowStmt() throws Exception
	{
		execute("show tables DEMO");
		execute("show tables");
		execute("show functions");
		execute("show functioncolumns");
		execute("show tablecolumns t_1");
		execute("select * from(show functions) as t");
	}

	public void testDataBaseMetaData() throws Exception
	{
		ISQLTranslator tx = DialectManager.createTranslator(dbType);
		String newURL = "jdbc:cownewsql:" + dbType + ":" + jdbcDriver + url;
		DBConnection dbConn = new DBConnection(tx, conn, newURL);
		DatabaseMetaData md = dbConn.getMetaData();

		System.out.println("数据库类型:" + dbType);

		System.out.println("CatalogSeparator:" + md.getCatalogSeparator());
		System.out.println("CatalogTerm:" + md.getCatalogTerm());
		System.out.println("Catalogs:");
		showResultSetThenClose(md.getCatalogs());

		System.out.println("FunctionColumns:");
		showResultSetThenClose(md.getFunctionColumns(null, null, "%", "%"));

		System.out.println("Functions:");
		showResultSetThenClose(md.getFunctions(null, null, "%"));
		showResultSetThenClose(md.getFunctions(null, "demo", "%"));

		System.out.println("Procedures:");
		showResultSetThenClose(md.getProcedures(null, null, "%"));

		System.out.println("Schemas:");
		showResultSetThenClose(md.getSchemas());

		System.out.println("TypeInfos:");
		showResultSetThenClose(md.getTypeInfo());

		System.out.println("URL:" + md.getURL() + ";USERNAME:"
				+ md.getUserName());
		System.out.println("*****************************************");
	}

	public void testALL() throws Exception
	{
		StringBuffer sb1 = new StringBuffer();
		sb1.append("//下面的语句是建表语句\n");
		sb1
				.append("create table T_Person(FId VARCHAR(20) not null,FName varchar(20),FAge int,primary key FId)");
		execute(sb1.toString());

		execute("create index idx1 on T_Person(FName)");
		execute("create index idx2 on T_Person(FName,FAge)");

		StringBuffer sb2 = new StringBuffer();
		sb2.append("/*下面的语句是各种语句:\n");
		sb2.append("比如Create、Update\n");
		sb2.append("和Insert*/");
		sb2.append("insert into T_Person values('p001','大明',20)");
		execute(sb2.toString());

		execute("insert into T_Person(FId,FName,FAge) values('p002','小红',22)");
		execute("create table T_Material(FId VARCHAR(20) not null,FName varchar(20),primary key FId)");
		execute("insert into T_Material values('m001','桌子')");
		execute("insert into T_Material values('m002','凳子')");

		execute("create table T_SaleInvoice(FId VARCHAR(20) not null,FNumber varchar(20),FSalesPersonId varchar(20),FDate date not null,primary key FId,FOREIGN KEY FSalesPersonId REFERENCES T_Person(FId))");
		execute("create table T_SaleInvoiceDetails(FId VARCHAR(20) not  null,FParentId varchar(20),FMaterialId varchar(20),FCount int default 0,FPrice decimal(10,2),primary key FId,FOREIGN KEY FParentId REFERENCES T_SaleInvoice(FId),FOREIGN KEY FMaterialId REFERENCES T_Material(FId))");

		execute("insert into T_SaleInvoice values('sv001','sv001','p001',{'2007-08-8'})");
		execute("insert into T_SaleInvoiceDetails	 values('svd001-001','sv001','m001',3,3.05)");
		execute("insert into T_SaleInvoiceDetails	 values('svd001-002','sv001','m002',5,1.10)");

		execute("insert into T_SaleInvoice	values('sv002','sv002','p002',now())");
		execute("insert into T_SaleInvoiceDetails values('svd002-001','sv002','m001',3,3.05)");
		execute("insert into T_SaleInvoiceDetails values('svd002-002','sv002','m002',2,1.00)");

		execute("update T_SaleInvoice set FDate=DateAdd(dd,-1,Now())");
		execute("update T_SaleInvoice set FDate=DateAdd('dd',-1,Now())");

		execute("select top 10 * from T_SaleInvoice");

		execute("create Table T_StockFlow(FBillId varchar(20) not null,FDetailId varchar(20) not null,FDate date,FBillTypeName varchar(20),FAmount decimal(10,2),primary key (FBillId,FDetailId))");
		execute("insert into T_StockFlow(FBillId,FDetailId,FDate,FBillTypeName,FAmount) "
				+ "select detail.FParentId,detail.FId,parent.FDate,'销售发票',detail.FCount*detail.FPrice from T_SaleInvoiceDetails detail left join T_SaleInvoice parent on parent.FId=detail.FParentId");

		execute("select trim(person.FName),bill.FNumber from T_SaleInvoice as bill left join T_Person person on bill.FSalesPersonId=person.FId");
		execute("select * from T_StockFlow where FBillId in('a','b') or FBillId in(select FBillId from T_StockFlow)");
		execute("select count(*) from T_SaleInvoiceDetails");
		execute("select sum(FCount),MAX(FPrice),MIN(FPrice),AVG(FPrice) from T_SaleInvoiceDetails");
		execute("select FMaterialId,count(FMaterialId) from T_SaleInvoiceDetails group by FMaterialId");
		execute("delete from T_SaleInvoiceDetails where FCount=?",
				new Object[] { Integer.valueOf(1) });
		execute("delete * from T_SaleInvoiceDetails where FCount<>0 or FPrice!=0");
		execute("delete from T_SaleInvoice where FId in(select top 5 FParentId	 from T_SaleInvoiceDetails)");
		execute("delete from T_SaleInvoice where FId in(select FParentId from	 T_SaleInvoiceDetails)");

		StringBuffer sb3 = new StringBuffer();
		sb3.append("--最后是删除\n");
		sb3.append("drop table T_StockFlow");
		execute(sb3.toString());

		execute("alter table T_Person add column f_myfield varchar(50)");
		execute("drop table T_SaleInvoiceDetails");
		execute("drop table T_SaleInvoice");
		execute("drop index T_Person.idx1");
		execute("drop table T_Person");
		execute("drop table T_Material");
		execute("select abs(-1),'select','varchar',n'中文','abs count select from',0x20,0x3333,0.88,3.25e-3");
		execute("select to_char(ceil(3333/10)),ACOS(1),ASIN(1),ATAN(0),ATN2(1,1),COS(0),COT(1),DEGREE(1),EXP(PI()),FLOOR(3.4),MOD(2,3),LOG(1),LOG10(2),POWER(2,3),RADIANS(100),RAND(),RAND(2.0),ROUND(3.1415926,3),SIGN(3),SIGN(-3),SIN(1),SQRT(2)");
		execute("select CONVERT('VARCHAR',3),CONVERT('INT','3'),CURTIME(),DATEDIFF(CURDATE(),CURDATE()),DATEDIFF(minute,CURDATE(),CURDATE())");
		execute("select DAYNAME(NOW()),DATENAME(month,NOW()),DAYOFMONTH(NOW()),DAYOFWEEK(NOW()),DAYOFYEAR(NOW())");
		execute("select HOUR(NOW()),MINUTE(NOW()),MONTH(NOW()),MONTHNAME(NOW()),QUARTER(NOW()),SECOND(NOW()),WEEK(NOW()),YEAR(NOW())");
		execute("select TO_DATE('2008-08-08'),MONTHS_BETWEEN(NOW(),{'2008-08-08'}),DAYS_BETWEEN(NOW(),{'2008-08-08'})");
		execute("select ADD_MONTHS(now(),3),ADDYEARS(now(),3),ADDDAYS(now(),3),ADDHOURS(now(),3),ADDMINUTES(now(),3),ADDSECONDS(now(),3)");
		execute("select ASCII('a'),CHR(70),CHR(ASCII('b')),CHARINDEX('vcd','cd'),CONCAT('a','c'),'b'||'d'");
		execute("select LEFTSTR('verycd',2),RIGHTSTR('cownew',3),LENGTH('cde'),LCASE('Cool!'),LTRIM('	 aa d ')");
		execute("select REPLACE('you and me and he','and','or'),RIGHTSTR('wwwsohu.com',4),RTRIM(' aa d '),SOUNDEX('cownew'),SUBSTRING('whitehouse',1,4),TRIM(' abe da	 '),UCASE('abc'),TOCHAR(1),TO_CHAR(now())");
		execute("select ISNULL('b','a'),NVL(2,1),NULLIF(3,2),NULLIF(2,3),TO_NUMBER('3.14'),TO_INT('3')");
	}
}
