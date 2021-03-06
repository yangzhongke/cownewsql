# cownewsql
CownewSQL is a SQL dialect translator, which supports SQL Server, Oracle, DB2 and MySQL. 

It can translate standard SQL into dialect.

Example Code:

```
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.DialectManager;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class Main {

	public static void main(String[] args) throws TranslateException {
		String sql1 = "select top 10 * from T_Users where DateDiff('Day',GetDate(),GetDate())=1";
		ISQLTranslator translatorOracle = DialectManager.createTranslator("Oracle");
		ISQLTranslator translatorSQLServer = DialectManager.createTranslator("SQLServer");
		ISQLTranslator translatorMySQL = DialectManager.createTranslator("MySQL");
		System.out.println(translatorOracle.translateSQL(sql1)[0]);
		System.out.println(translatorSQLServer.translateSQL(sql1)[0]);
		System.out.println(translatorMySQL.translateSQL(sql1)[0]);
	}
}
```
The output is:
```
SELECT * FROM T_Users WHERE ROUND( TRUNC( CAST(SYSDATE AS DATE), 'DD') - TRUNC( CAST(SYSDATE AS DATE), 'DD')) = 1 AND ROWNUM <= 10 
SELECT  TOP 10 * FROM T_Users WHERE DATEDIFF(Day, GETDATE(), GETDATE()) = 1

SELECT * FROM T_Users WHERE DATEDIFF(NOW(), NOW()) = 1 LIMIT 0, 10 

```
Download the [Jar Files](https://raw.githubusercontent.com/yangzhongke/cownewsql/master/dist/cownewsql-2.1.zip)

This project employs ANTLR to compile the grammar definition files sqlparser.g and sqltreeparser.g (under the folder com\cownew\cownewsql\ast\grammar) into SQLTreeParser.java, SQLLexer.java and other files.
So this project depends on antlr and antlr studio, which is an Eclipse plugin.
Please install [antlr studio](https://www.antlr.org/tools.html) plugin on your Eclipse.
