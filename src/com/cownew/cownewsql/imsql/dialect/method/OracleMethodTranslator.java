package com.cownew.cownewsql.imsql.dialect.method;

import java.util.List;

import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlIntExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class OracleMethodTranslator extends BaseMethodTranslator
{

	public OracleMethodTranslator(ISQLTranslator sqlTranslator)
	{
		super(sqlTranslator);
	}

	@Override
	protected String translateMOD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("MOD(");
		sb.append(translateExpr(exprAST.getParameters().get(0))).append(" , ")
				.append(translateExpr(exprAST.getParameters().get(1)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateCONVERT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		List<SqlExprAST> parameters = exprAST.getParameters();
		StringBuffer buffer = new StringBuffer();
		String typeName = parameters.get(0).getText();
		typeName = typeName.toUpperCase();
		if (typeName.equals("CHAR") || typeName.equals("VARCHAR"))
		{
			buffer.append("TO_CHAR(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		} else if (typeName.equals("DATETIME"))
		{
			buffer.append("TO_DATE(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(", 'YYYY-MM-DD HH24:MI:SS')");
			return buffer.toString();
		} else if (typeName.equals("INT") || typeName.equals("NUMBER")
				|| typeName.equals("INTEGER") || typeName.equals("DECIMAL"))
		{
			buffer.append("TO_NUMBER(");
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
		return "TO_DATE(TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 'YYYY-MM-DD')";
	}

	@Override
	protected String translateCURTIME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "TO_CHAR(SYSDATE,'HH24:MI:SS')";
	}

	@Override
	protected String translateDATEADD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append("(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(" + ");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append("/60/60/24)");
		} else if (parameters.size() == 3)
		{
			String type = parameters.get(0).getText().toUpperCase();
			if ("YEAR".equals(type) || "YY".equals(type) || "YYYY".equals(type))
			{
				buffer.append("add_months(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(", TRUNC(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(") * 12)");
			} else if ("MONTH".equals(type) || "MM".equals(type)
					|| "M".equals(type))
			{
				buffer.append("add_months(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(", TRUNC(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" * 3)");
			} else if ("DAY".equals(type) || "DD".equals(type)
					|| "D".equals(type))
			{
				buffer.append("(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" + TRUNC(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append("))");
			} else if ("HOUR".equals(type) || "HH".equals(type))
			{
				buffer.append("(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" + TRUNC(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(") / 24)");
			} else if ("MINUTE".equals(type) || "MI".equals(type)
					|| "N".equals(type))
			{
				buffer.append("(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" + TRUNC(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(") / 24 / 60)");
			} else if ("SECOND".equals(type) || "SS".equals(type)
					|| "S".equals(type))
			{
				buffer.append("(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" + TRUNC(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(") / 24 / 60 / 60)");
			} else
				throw new TranslateException("unkown type :" + type);
		}
		return buffer.toString();
	}

	@Override
	protected String translateDATEDIFF(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append("FLOOR((");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(" - ");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(") * 60 * 60 * 24)");
		} else if (parameters.size() == 3)
		{
			// don't use translateExpr,because it's result is "'minute'"
			String type = parameters.get(0).getText().toUpperCase();
			type = type.toUpperCase();
			if ("YEAR".equals(type) || "YY".equals(type) || "YYYY".equals(type))
			{
				buffer.append("ROUND(MONTHS_BETWEEN(TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'YYYY'), TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'YYYY'))/12)");
			} else if ("QUARTER".equals(type) || "QQ".equals(type)
					|| "Q".equals(type))
			{
				buffer.append("ROUND(MONTHS_BETWEEN(TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'YYYY'), TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'YYYY'))/4)");
			} else if ("MONTH".equals(type) || "MM".equals(type)
					|| "M".equals(type))
			{
				buffer.append("ROUND(MONTHS_BETWEEN(TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'MM'), TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'MM')))");
			} else if ("WEEK".equals(type) || "WK".equals(type)
					|| "W".equals(type))
			{
				buffer.append("ROUND( TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'DD') - TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'DD'))/7");
			} else if ("DAY".equals(type) || "DD".equals(type)
					|| "D".equals(type))
			{
				buffer.append("ROUND( TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'DD') - TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'DD'))");
			} else if ("HOUR".equals(type) || "HH".equals(type))
			{
				buffer.append("((TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'HH')  - TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'HH') ) * 24)");
			} else if ("MINUTE".equals(type) || "MI".equals(type)
					|| "N".equals(type))
			{
				buffer.append("(( TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'MI') - TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'MI')) * 24 * 60)");
			} else if ("SECOND".equals(type) || "SS".equals(type)
					|| "S".equals(type))
			{
				buffer.append("((TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'SS') - TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'SS')) * 24 * 60)");
			} else if ("MILLISECOND".equals(type) || "MS".equals(type))
			{
				buffer.append("((TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(" AS DATE), 'SS') - TRUNC( CAST(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" AS DATE), 'SS')) * 24 * 60)/1000");
			} else
			{
				throw new TranslateException("unkown type :" + type);
			}
		} else
		{
			throw new TranslateException(
					"DATEDIFF must have 2 or 3 paraemeters");
		}

		return buffer.toString();
	}

	@Override
	protected String translateDAYNAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("TO_CHAR(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(", 'DAY')");
		return buffer.toString();
	}

	@Override
	protected String translateDAYOFMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("TO_NUMBER(TO_CHAR(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(", 'DD'))");
		return buffer.toString();
	}

	@Override
	protected String translateDAYOFWEEK(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("TO_NUMBER(TO_CHAR(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(", 'D'))");
		return buffer.toString();
	}

	@Override
	protected String translateDAYOFYEAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("TO_NUMBER(TO_CHAR(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(", 'DDD'))");
		return buffer.toString();
	}

	@Override
	protected String translateNOW(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "SYSDATE";
	}

	@Override
	protected String translateHOUR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'HH24'))");
		return sb.toString();
	}

	@Override
	protected String translateMINUTE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'MI'))");
		return sb.toString();
	}

	@Override
	protected String translateMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'MM'))");
		return sb.toString();
	}

	@Override
	protected String translateMONTHNAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'MON')");
		return sb.toString();
	}

	@Override
	protected String translateQUARTER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'Q'))");
		return sb.toString();
	}

	@Override
	protected String translateSECOND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'SS'))");
		return sb.toString();
	}

	@Override
	protected String translateWEEK(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'WW'))");
		return sb.toString();
	}

	@Override
	protected String translateYEAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'YYYY'))");
		return sb.toString();
	}

	@Override
	protected String translateTO_DATE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TO_DATE(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(", 'YYYY-MM-DD')");
		return sb.toString();
	}

	@Override
	protected String translateMONTHS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("((TO_NUMBER(TO_CHAR(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", 'YYYY')) - TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(", 'YYYY'))) * 12 + TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", 'MM')) - TO_NUMBER(TO_CHAR(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(", 'MM')))");
		return sb.toString();
	}

	@Override
	protected String translateDAYS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("ROUND((TRUNC( CAST(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" AS DATE), 'DD') - TRUNC( CAST(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" AS DATE), 'DD')))");
		return sb.toString();
	}

	@Override
	protected String translateADD_MONTHS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "ADD_MONTHS");
	}

	@Override
	protected String translateADD_YEARS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("ADD_MONTHS(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(1)));
		sb.append("* 12)");
		return sb.toString();
	}

	@Override
	protected String translateADD_DAYS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_HOURS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append("/24)");
		return sb.toString();
	}

	@Override
	protected String translateADD_MINUTES(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append("/1440)");
		return sb.toString();
	}

	@Override
	protected String translateADD_SECONDS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append("/86400)");
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
		return translateDefault(exprAST.getParameters(), "CHR");
	}

	@Override
	protected String translateCHARINDEX(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "INSTR");
	}

	@Override
	protected String translateCONCAT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "CONCAT");
	}

	@Override
	protected String translateLENGTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "LENGTH");
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
		return translateDefault(exprAST.getParameters(), "SUBSTR");
	}

	@Override
	protected String translateTRIM(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("TRIM(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
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
		return translateDefault(exprAST.getParameters(), "TO_CHAR");
	}

	@Override
	protected String translateTO_NUMBER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "TO_NUMBER");
	}

	@Override
	protected String translateTO_INT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("FLOOR(TO_NUMBER(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append("))");
		return sb.toString();
	}

	@Override
	protected String translateATN2(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "ATAN2");
	}

	@Override
	protected String translateDEGREE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		String v = translateExpr(exprAST.getParameters().get(0));
		return "(" + v + "*180)/acos(-1)";
	}

	@Override
	protected String translateRADIANS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		String v = translateExpr(exprAST.getParameters().get(0));
		return "(" + v + "*acos(-1)/180)";
	}

	protected String translatePI(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "acos(-1)";
	}

	@Override
	protected String translateCEILING(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "CEIL");
	}

	@Override
	protected String translateLOG10(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		buffer.append("LOG(10,");
		buffer.append(translateExpr(parameters.get(0)));
		buffer.append(")");
		return buffer.toString();
	}

	protected String translateLOG(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(), "LN");
	}

	@Override
	protected String translateROUND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append("ROUND(");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(", ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		} else if (parameters.size() == 3)
		{
			SqlExprAST thirdExpr = parameters.get(2);
			if (!(thirdExpr instanceof SqlIntExprAST))
				throw new TranslateException("only int allowed");
			int val = Integer.parseInt(((SqlIntExprAST) thirdExpr)
					.getTextValue());
			if (val == 0)
			{
				buffer.append("ROUND(");
				buffer.append(translateExpr(parameters.get(0)));
				buffer.append(", ");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")");
			} else
			{
				buffer.append("TRUNC(");
				buffer.append(translateExpr(parameters.get(0)));
				buffer.append(", ");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")");
			}
			return buffer.toString();
		} else
			throw new TranslateException("only 2 or 3 parameters allowed!");
	}

	@Override
	protected String translateLEFTSTR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("SUBSTR(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		//SQL中子字符串都从1开始计数
		sb.append(", 1,");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateRIGHTSTR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		sb.append("SUBSTR(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", LENGTH(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")-");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" +1, ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateDATENAME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		String datepart = parameters.get(0).getText();
		datepart = datepart.toUpperCase();
		if ("YEAR".equals(datepart) || "YY".equals(datepart)
				|| "YYYY".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'YYYY')");
		} else if ("MONTH".equals(datepart) || "MM".equals(datepart)
				|| "M".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'MM')");
		} else if ("QUARTER".equals(datepart) || "QQ".equals(datepart)
				|| "Q".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'Q')");
		} else if ("DAYOFYEAR".equals(datepart) || "DY".equals(datepart)
				|| "Y".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'DDD')");
		} else if ("DAY".equals(datepart) || "DD".equals(datepart)
				|| "D".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'DD')");
		} else if ("WEEK".equals(datepart) || "WK".equals(datepart)
				|| "WW".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'IW')");
		} else if ("WEEKDAY".equals(datepart) || "DW".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'DAY')");
		} else if ("HOUR".equals(datepart) || "HH".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'HH24')");
		} else if ("MINUTE".equals(datepart) || "MI".equals(datepart)
				|| "N".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'MI')");
		} else if ("SECOND".equals(datepart) || "SS".equals(datepart)
				|| "S".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'SS')");
		} else if ("MILLISECOND".equals(datepart) || "MS".equals(datepart))
		{
			sb.append("TO_CHAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", 'SSxFF3')");
		} else
		{
			throw new TranslateException("unkown type :" + datepart);
		}
		return sb.toString();
	}

	@Override
	protected String translateISNULL(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "NVL");
	}

	protected String translateRAND(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();

		if (exprAST.getParameters().size() == 0)
		{
			buffer.append("(select   dbms_random.value   from   dual)");
			return buffer.toString();
		}
		if (exprAST.getParameters().size() == 1)
		{
			String v = translateExpr(exprAST.getParameters().get(0));
			buffer.append("(select   dbms_random.value*").append(v).append(
					"   from   dual)");
			return buffer.toString();
		}
		throw new TranslateException(" 0 or 1 parameters allowed");
	}

	protected String translateCOT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		String v = translateExpr(exprAST.getParameters().get(0));
		return "1/tan(" + v + ")";
	}
}
