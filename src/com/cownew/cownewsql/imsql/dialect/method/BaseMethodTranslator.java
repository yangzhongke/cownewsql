package com.cownew.cownewsql.imsql.dialect.method;

import java.util.List;

import com.cownew.cownewsql.imsql.IMethodTranslator;
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;
import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;

public abstract class BaseMethodTranslator implements IMethodTranslator
{
	private ISQLTranslator sqlTranslator;

	public BaseMethodTranslator(ISQLTranslator sqlTranslator)
	{
		super();
		this.sqlTranslator = sqlTranslator;
	}

	protected void checkParamCount(SqlMethodExprAST exprAST, int expectedCount)
			throws TranslateException
	{
		if (exprAST.getParameters().size() != expectedCount)
		{
			throw new TranslateException("count of parameter must be"
					+ expectedCount);
		}
	}

	public ISQLTranslator getSqlTranslator()
	{
		return sqlTranslator;
	}

	public String translate(SqlMethodExprAST exprAST) throws TranslateException
	{
		String supName = exprAST.getMethodName().toUpperCase();
		if (supName.equals("ABS"))
		{
			return translateABS(exprAST);
		} else if (supName.equals("ACOS"))
		{
			return translateACOS(exprAST);
		} else if (supName.equals("ASIN"))
		{
			return translateASIN(exprAST);
		} else if (supName.equals("ATAN"))
		{
			return translateATAN(exprAST);
		} else if (supName.equals("TAN"))
		{
			return translateTAN(exprAST);
		} else if (supName.equals("ATN2") || supName.equals("ATAN2"))
		{
			return translateATN2(exprAST);
		} else if (supName.equals("CEILING") || supName.equals("CEIL"))
		{
			return translateCEILING(exprAST);
		} else if (supName.equals("COS"))
		{
			return translateCOS(exprAST);
		} else if (supName.equals("COT"))
		{
			return translateCOT(exprAST);
		} else if (supName.equals("DEGREE") || supName.equals("DEGREES"))
		{
			return translateDEGREE(exprAST);
		} else if (supName.equals("EXP"))
		{
			return translateEXP(exprAST);
		} else if (supName.equals("FLOOR"))
		{
			return translateFLOOR(exprAST);
		} else if (supName.equals("MOD"))
		{
			return translateMOD(exprAST);
		} else if (supName.equals("LOG"))
		{
			return translateLOG(exprAST);
		} else if (supName.equals("LOG10"))
		{
			return translateLOG10(exprAST);
		} else if (supName.equals("PI"))
		{
			return translatePI(exprAST);
		} else if (supName.equals("POWER") || supName.equals("POW"))
		{
			return translatePOWER(exprAST);
		} else if (supName.equals("RADIANS"))
		{
			return translateRADIANS(exprAST);
		} else if (supName.equals("RAND"))
		{
			return translateRAND(exprAST);
		} else if (supName.equals("ROUND"))
		{
			return translateROUND(exprAST);
		} else if (supName.equals("SIGN"))
		{
			return translateSIGN(exprAST);
		} else if (supName.equals("SIN"))
		{
			return translateSIN(exprAST);
		} else if (supName.equals("SQRT"))
		{
			return translateSQRT(exprAST);
		} else if (supName.equals("CONVERT"))
		{
			return translateCONVERT(exprAST);
		} else if (supName.equals("CURDATE"))
		{
			return translateCURDATE(exprAST);
		} else if (supName.equals("CURTIME"))
		{
			return translateCURTIME(exprAST);
		} else if (supName.equals("DATEADD") || supName.equals("DATE_ADD"))
		{
			return translateDATEADD(exprAST);
		} else if (supName.equals("DATEDIFF") || supName.equals("DATE_DIFF"))
		{
			return translateDATEDIFF(exprAST);
		} else if (supName.equals("DAYNAME"))
		{
			return translateDAYNAME(exprAST);
		} else if (supName.equals("DATENAME"))
		{
			return translateDATENAME(exprAST);
		} else if (supName.equals("DAYOFMONTH"))
		{
			return translateDAYOFMONTH(exprAST);
		} else if (supName.equals("DAYOFWEEK"))
		{
			return translateDAYOFWEEK(exprAST);
		} else if (supName.equals("DAYOFYEAR"))
		{
			return translateDAYOFYEAR(exprAST);
		} else if (supName.equals("HOUR"))
		{
			return translateHOUR(exprAST);
		} else if (supName.equals("MINUTE"))
		{
			return translateMINUTE(exprAST);
		} else if (supName.equals("MONTH"))
		{
			return translateMONTH(exprAST);
		} else if (supName.equals("MONTHNAME"))
		{
			return translateMONTHNAME(exprAST);
		} else if (supName.equals("NOW") || supName.equals("GETDATE")
				|| supName.equals("TODAY"))
		{
			return translateNOW(exprAST);
		} else if (supName.equals("QUARTER"))
		{
			return translateQUARTER(exprAST);
		} else if (supName.equals("SECOND"))
		{
			return translateSECOND(exprAST);
		} else if (supName.equals("WEEK"))
		{
			return translateWEEK(exprAST);
		} else if (supName.equals("YEAR"))
		{
			return translateYEAR(exprAST);
		} else if (supName.equals("TO_DATE") || supName.equals("TODATE"))
		{
			return translateTO_DATE(exprAST);
		} else if (supName.equals("MONTHS_BETWEEN")
				|| supName.equals("MONTHSBETWEEN"))
		{
			return translateMONTHS_BETWEEN(exprAST);
		} else if (supName.equals("DAYS_BETWEEN")
				|| supName.equals("DAYSBETWEEN"))
		{
			return translateDAYS_BETWEEN(exprAST);
		} else if (supName.equals("ADD_MONTHS") || supName.equals("ADDMONTHS"))
		{
			return translateADD_MONTHS(exprAST);
		} else if (supName.equals("ADD_YEARS") || supName.equals("ADDYEARS"))
		{
			return translateADD_YEARS(exprAST);
		} else if (supName.equals("ADD_DAYS") || supName.equals("ADDDAYS"))
		{
			return translateADD_DAYS(exprAST);
		} else if (supName.equals("ADD_HOURS") || supName.equals("ADDHOURS"))
		{
			return translateADD_HOURS(exprAST);
		} else if (supName.equals("ADD_MINUTES")
				|| supName.equals("ADDMINUTES"))
		{
			return translateADD_MINUTES(exprAST);
		} else if (supName.equals("ADD_SECONDS")
				|| supName.equals("ADDSECONDS"))
		{
			return translateADD_SECONDS(exprAST);
		} else if (supName.equals("ASCII"))
		{
			return translateASCII(exprAST);
		} else if (supName.equals("CHR"))
		{
			return translateCHAR(exprAST);
		} else if (supName.equals("CHARINDEX"))
		{
			return translateCHARINDEX(exprAST);
		} else if (supName.equals("CONCAT"))
		{
			return translateCONCAT(exprAST);
		} else if (supName.equals("LEFTSTR"))
		{
			return translateLEFTSTR(exprAST);
		} else if (supName.equals("LENGTH") || supName.equals("LEN"))
		{
			return translateLENGTH(exprAST);
		} else if (supName.equals("LCASE") || supName.equals("LOWER"))
		{
			return translateLCASE(exprAST);
		} else if (supName.equals("LTRIM"))
		{
			return translateLTRIM(exprAST);
		} else if (supName.equals("REPLACE"))
		{
			return translateREPLACE(exprAST);
		} else if (supName.equals("RIGHTSTR"))
		{
			return translateRIGHTSTR(exprAST);
		} else if (supName.equals("RTRIM"))
		{
			return translateRTRIM(exprAST);
		} else if (supName.equals("SOUNDEX"))
		{
			return translateSOUNDEX(exprAST);
		} else if (supName.equals("SUBSTRING") || supName.equals("SUBSTR"))
		{
			return translateSUBSTRING(exprAST);
		} else if (supName.equals("TRIM"))
		{
			return translateTRIM(exprAST);
		} else if (supName.equals("UCASE") || supName.equals("UPPER"))
		{
			return translateUCASE(exprAST);
		} else if (supName.equals("TOCHAR") || supName.equals("TO_CHAR"))
		{
			return translateTOCHAR(exprAST);
		} else if (supName.equals("ISNULL") || supName.equals("NVL"))
		{
			// isnull(a,b),if"a!=null" return a,else return b
			return translateISNULL(exprAST);
		} else if (supName.equals("NULLIF"))
		{
			// nullif(a,b),if"a==b" return nullvalue of type(a),else return a
			return translateNULLIF(exprAST);
		} else if (supName.equals("TO_NUMBER") || supName.equals("TONUMBER"))
		{
			return translateTO_NUMBER(exprAST);
		} else if (supName.equals("TO_INT") || supName.equals("TOINT"))
		{
			return translateTO_INT(exprAST);
		} else if (supName.equals("COUNT"))
		{
			return translateDefault(exprAST);
		} else if (supName.equals("SUM"))
		{
			return translateDefault(exprAST);
		} else if (supName.equals("MAX"))
		{
			return translateDefault(exprAST);
		} else if (supName.equals("MIN"))
		{
			return translateDefault(exprAST);
		} else if (supName.equals("AVG"))
		{
			return translateDefault(exprAST);
		}
		else if (supName.equals("COALESCE"))
		{
			return translateDefault(exprAST);
		}
		throw new TranslateException("unsupport fucntion:"
				+ exprAST.getMethodName());
	}

	protected String translateABS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateACOS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateADD_DAYS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateADD_HOURS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateADD_MINUTES(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateADD_MONTHS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateADD_SECONDS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateADD_YEARS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateASCII(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateASIN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateATAN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected abstract String translateATN2(SqlMethodExprAST exprAST)
			throws TranslateException;

	protected String translateCEILING(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateCHAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateCHARINDEX(SqlMethodExprAST exprAST)
			throws TranslateException
	{

		return translateDefault(exprAST);
	}

	protected String translateCONCAT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateCONVERT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		// 特殊处理
		return translateDefault(exprAST);
	}

	protected String translateCOS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateCOT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "COT");
	}

	protected String translateCURDATE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return translateDefault(exprAST);
	}

	protected String translateCURTIME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return translateDefault(exprAST);
	}

	protected String translateDATEADD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		// 有可能为2、3
		return translateDefault(exprAST);
	}

	protected String translateDATEDIFF(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		// 有可能为2、3
		return translateDefault(exprAST);
	}

	protected String translateDATENAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateDAYNAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateDAYOFMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateDAYOFWEEK(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateDAYOFYEAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateDAYS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateDefault(List<SqlExprAST> paramList,
			String methodName) throws TranslateException
	{
		ISQLTranslator translator = getSqlTranslator();
		StringBuffer sb = new StringBuffer();
		sb.append(" ").append(methodName).append("(");
		for (int i = 0, n = paramList.size(); i < n; i++)
		{
			if (i > 0)
			{
				sb.append(",");
			}
			sb.append(translator.translateExpr(paramList.get(i)));
		}
		sb.append(") ");
		return sb.toString();
	}

	protected String translateDefault(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		return translateDefault(exprAST.getParameters(), exprAST
				.getMethodName());
	}

	protected abstract String translateDEGREE(SqlMethodExprAST exprAST)
			throws TranslateException;

	protected String translateEXP(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected final String translateExpr(SqlExprAST exprAST)
			throws TranslateException
	{
		return getSqlTranslator().translateExpr(exprAST);
	}

	protected String translateFLOOR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateHOUR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateISNULL(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "ISNULL");
	}

	protected String translateLCASE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateLEFTSTR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateLENGTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	// ln,log(e,?)
	protected String translateLOG(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateLOG10(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "LOG10");
	}

	protected String translateLTRIM(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateMINUTE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateMOD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateMONTHNAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateMONTHS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateNOW(SqlMethodExprAST exprAST)
			throws TranslateException
	{

		return translateDefault(exprAST);
	}

	protected String translateNULLIF(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translatePI(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return translateDefault(exprAST.getParameters(), "PI");
	}

	protected String translatePOWER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "POWER");
	}

	protected String translateQUARTER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected abstract String translateRADIANS(SqlMethodExprAST exprAST)
			throws TranslateException;

	protected String translateRAND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();

		if (exprAST.getParameters().size() == 0)
		{
			buffer.append("RAND()");
			return buffer.toString();
		}
		if (exprAST.getParameters().size() == 1)
		{
			buffer.append("RAND(");
			buffer.append(translateExpr(exprAST.getParameters().get(0)));
			buffer.append(")");
			return buffer.toString();
		}
		throw new TranslateException(" 0 or 1 parameters allowed");
	}

	protected String translateREPLACE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 3);
		return translateDefault(exprAST);
	}

	protected String translateRIGHTSTR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateROUND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST);
	}

	protected String translateRTRIM(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateSECOND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateSIGN(SqlMethodExprAST exprAST)
			throws TranslateException
	{

		return translateDefault(exprAST);
	}

	protected String translateSIN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateSOUNDEX(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateSQRT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateSUBSTRING(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 3);
		return translateDefault(exprAST);
	}

	protected String translateTAN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "TAN");
	}

	protected String translateTO_DATE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateTO_INT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateTO_NUMBER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateTOCHAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateTRIM(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateUCASE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateWEEK(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

	protected String translateYEAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST);
	}

}
