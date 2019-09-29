package com.cownew.cownewsql.imsql.dialect.method;

import java.util.List;

import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class MSSQLMethodTranslator extends BaseMethodTranslator
{

	public MSSQLMethodTranslator(ISQLTranslator sqlTranslator)
	{
		super(sqlTranslator);
	}

	@Override
	protected String translateMOD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append(translateExpr(exprAST.getParameters().get(0))).append(" % ")
				.append(translateExpr(exprAST.getParameters().get(1)));
		return sb.toString();
	}

	@Override
	protected String translateCONVERT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		List<SqlExprAST> parameters = exprAST.getParameters();

		StringBuffer buffer = new StringBuffer();
		String typeName = parameters.get(0).getText().toLowerCase();
		typeName = typeName.toUpperCase();
		if (typeName.equals("CHAR") || typeName.equals("VARCHAR")
				|| typeName.equals("DATETIME") || typeName.equals("DECIMAL")
				|| typeName.equals("INT"))
		{
			buffer.append("CONVERT(" + typeName.toUpperCase() + ", ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		}
		if (typeName.equals("NUMBER"))
		{
			buffer.append("CONVERT(NUMERIC, ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		}
		throw new TranslateException("this function is not implement yet");
	}

	@Override
	protected String translateCURDATE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "CONVERT(DATETIME, CONVERT(VARCHAR(50) ,GETDATE( ), 101))";
	}

	@Override
	protected String translateCURTIME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "CONVERT(VARCHAR(50) ,GETDATE( ), 108)";
	}

	@Override
	protected String translateDATEADD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append("DATEADD(SS, ");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		}
		if (parameters.size() == 3)
		{
			buffer.append("DATEADD(");
			// buffer.append(translateExpr(parameters.get(0)));
			buffer.append(parameters.get(0).getText());
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(2)));
			buffer.append(")");
			return buffer.toString();
		}

		throw new TranslateException("DATEADD must have 2 or 3 paraemeters");
	}

	@Override
	protected String translateDATEDIFF(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append("DATEDIFF(SS, ");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		}
		if (parameters.size() == 3)
		{
			buffer.append("DATEDIFF(");
			//datediff(dd,....) not datediff('dd',....)
			// buffer.append(translateExpr(parameters.get(0)));
			buffer.append(parameters.get(0).getText());
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(2)));
			buffer.append(")");
			return buffer.toString();
		}

		throw new TranslateException("DATEDIFF must have 2 or 3 paraemeters");
	}

	@Override
	protected String translateDAYNAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("DATENAME(DW, ");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(")");
		return buffer.toString();
	}

	@Override
	protected String translateDAYOFMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(DAY, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateDAYOFWEEK(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(DW, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateDAYOFYEAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(DY, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateNOW(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "GETDATE()";
	}

	@Override
	protected String translateHOUR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(HH, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateMINUTE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(MI, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(MM, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateMONTHNAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATENAME(MM, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateQUARTER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(QQ, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateSECOND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(SS, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateWEEK(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEPART(WK, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateYEAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("YEAR( ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateTO_DATE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("CONVERT(DATETIME,");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateMONTHS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEDIFF(MM,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateDAYS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEDIFF(DD,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_MONTHS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEADD(month,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_YEARS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEADD(year,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_DAYS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEADD(day,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_HOURS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEADD(hour,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_MINUTES(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEADD(minute,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_SECONDS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEADD(second,");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(1)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateASCII(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "ASCII");
	}

	@Override
	protected String translateCHAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "CHAR");
	}

	@Override
	protected String translateCHARINDEX(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "CHARINDEX");
	}

	@Override
	protected String translateCONCAT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append("+");
		sb.append(translateExpr(parameters.get(1)));
		return sb.toString();
	}

	@Override
	protected String translateLENGTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "LEN");
	}

	@Override
	protected String translateLCASE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "LOWER");
	}

	@Override
	protected String translateSUBSTRING(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 3);
		return translateDefault(exprAST.getParameters(), "SUBSTRING");
	}

	@Override
	protected String translateTRIM(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("LTRIM(RTRIM(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append("))");
		return sb.toString();
	}

	@Override
	protected String translateUCASE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "UPPER");
	}

	@Override
	protected String translateTOCHAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("CONVERT(VARCHAR, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateTO_NUMBER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("CONVERT(FLOAT, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateTO_INT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("CAST(CONVERT(FLOAT, ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(") AS INT)");
		return sb.toString();
	}

	@Override
	protected String translateRADIANS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "RADIANS");
	}

	@Override
	protected String translateDEGREE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "DEGREES");
	}

	@Override
	protected String translateATN2(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "ATN2");
	}

	protected String translateNULLIF(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "NULLIF");
	}
	protected String translateCEILING(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(), "CEILING");
	}
	
	protected String translateLEFTSTR(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		return translateDefault(exprAST.getParameters(), "LEFT");
	}
	
	protected String translateRIGHTSTR(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		return translateDefault(exprAST.getParameters(), "RIGHT");
	}
}
