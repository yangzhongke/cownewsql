package com.cownew.cownewsql.imsql.dialect.method;

import java.util.ArrayList;
import java.util.List;

import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class DB2UDBMethodTranslator extends BaseMethodTranslator
{

	public DB2UDBMethodTranslator(ISQLTranslator sqlTranslator)
	{
		super(sqlTranslator);
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
		if (typeName.equals("DATETIME"))
		{
			buffer.append("TIMESTAMP(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		}
		if (typeName.equals("VARCHAR")||typeName.equals("CHAR"))
		{
			buffer.append("LTRIM(RTRIM(CHAR(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")))");
			return buffer.toString();
		}		
		if (typeName.equals("NUMBER")||typeName.equals("DOUBLE")||typeName.equals("DECIMAL"))
		{
			buffer.append("DOUBLE(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(")");
			return buffer.toString();
		}
		if (typeName.equals("INT")||typeName.equals("INTEGER"))
		{
			buffer.append("FLOOR(DOUBLE(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append("))");
			return buffer.toString();
		}
		throw new TranslateException("this function is not implement yet");
	}

	@Override
	protected String translateCURDATE(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "CURRENT DATE";
	}

	@Override
	protected String translateCURTIME(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "CURRENT TIME";
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
			sb.append("YEAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("MONTH".equals(datepart) || "MM".equals(datepart)
				|| "M".equals(datepart))
		{
			sb.append("MONTH(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("QUARTER".equals(datepart) || "QQ".equals(datepart)
				|| "Q".equals(datepart))
		{
			sb.append("QUARTER(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("DAYOFYEAR".equals(datepart) || "DY".equals(datepart)
				|| "Y".equals(datepart))
		{
			sb.append("DAYOFYEAR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("DAY".equals(datepart) || "DD".equals(datepart)
				|| "D".equals(datepart))
		{
			sb.append("DAY(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("WEEK".equals(datepart) || "WK".equals(datepart)
				|| "WW".equals(datepart))
		{
			sb.append("WEEK(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("WEEKDAY".equals(datepart) || "DW".equals(datepart))
		{
			sb.append("DAYOFWEEK(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("HOUR".equals(datepart) || "HH".equals(datepart))
		{
			sb.append("HOUR(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("MINUTE".equals(datepart) || "MI".equals(datepart)
				|| "N".equals(datepart))
		{
			sb.append("MINUTE(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("SECOND".equals(datepart) || "SS".equals(datepart)
				|| "S".equals(datepart))
		{
			sb.append("SECOND(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else if ("MILLISECOND".equals(datepart) || "MS".equals(datepart))
		{
			sb.append("MICROSECOND(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
		} else
		{
			throw new TranslateException("unkown type :" + datepart);
		}
		return sb.toString();
	}

	@Override
	protected String translateDATEADD(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append("+");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(" SECOND");
			return buffer.toString();
		}
		if (parameters.size() == 3)
		{
			String type = parameters.get(0).getText().toUpperCase();
			if(type.equals("YEAR")||type.equals("YY")||type.equals("YYYY"))
			{
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append("+");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" YEAR");
			}
			else if(type.equals("MONTH")||type.equals("MM")||type.equals("M"))
			{
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append("+");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" MONTH");
			}
			else if(type.equals("DAY")||type.equals("DD")||type.equals("D"))
			{
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append("+");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" DAY");
			}
			else if(type.equals("HOUR")||type.equals("HH")||type.equals("H"))
			{
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append("+");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" HOUR");
			}
			else if(type.equals("MINUTE")||type.equals("MI")||type.equals("N"))
			{
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append("+");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" MINUTE");
			}
			else if(type.equals("SECOND")||type.equals("SS")||type.equals("S"))
			{
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append("+");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(" SECOND");
			}
			else
			{
				throw new TranslateException("unkown type :"+type);
			}
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
			buffer.append("((DAYS (");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(") - DAYS (");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(")) * 24 * 60 * 60)");

			return buffer.toString();
		}
		if (parameters.size() == 3)
		{
			String diffType = parameters.get(0).getText();
			if(diffType.equalsIgnoreCase("YYYY")||diffType.equalsIgnoreCase("YEAR")
					||diffType.equalsIgnoreCase("Y"))
			{
				buffer.append("(YEAR(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - YEAR(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append("))");
			}
			else if(diffType.equalsIgnoreCase("MONTH")||diffType.equalsIgnoreCase("MM")
					||diffType.equalsIgnoreCase("M"))
			{
				buffer.append("((YEAR(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - YEAR(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")) * 12 + MONTH(");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - MONTH(");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append("))");
			}
			else if(diffType.equalsIgnoreCase("Week")||diffType.equalsIgnoreCase("wk")
					||diffType.equalsIgnoreCase("ww"))
			{
				buffer.append("(DAYS (");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - DAYS (");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")/7)");
			}
			else if(diffType.equalsIgnoreCase("Day")||diffType.equalsIgnoreCase("dd")
					||diffType.equalsIgnoreCase("d"))
			{
				buffer.append("(DAYS (");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - DAYS (");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append("))");
			}			
			else if(diffType.equalsIgnoreCase("Hour")||diffType.equalsIgnoreCase("hh"))
			{
				buffer.append("((DAYS (");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - DAYS (");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")) * 24)");
			}
			else if(diffType.equalsIgnoreCase("minute")||diffType.equalsIgnoreCase("mi")
					||diffType.equalsIgnoreCase("n"))
			{
				buffer.append("((DAYS (");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - DAYS (");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")) * 24 * 60)");
			}
			else if(diffType.equalsIgnoreCase("second")||diffType.equalsIgnoreCase("ss")
					||diffType.equalsIgnoreCase("s"))
			{
				buffer.append("((DAYS (");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - DAYS (");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")) * 24 * 60 * 60)");
			}
			else if(diffType.equalsIgnoreCase("millisecond")||diffType.equalsIgnoreCase("ms"))
			{
				buffer.append("((DAYS (");
				buffer.append(translateExpr(parameters.get(2)));
				buffer.append(") - DAYS (");
				buffer.append(translateExpr(parameters.get(1)));
				buffer.append(")) * 24 * 60 * 60*1000)");
			}
			else
			{
				throw new TranslateException("not support"+diffType);
			}
			return buffer.toString();
		}

		throw new TranslateException("DATEDIFF must have 2 or 3 paraemeters");
	}

	@Override
	protected String translateDAYOFMONTH(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(),"DAY");
	}
	
	protected String translateISNULL(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(),"COALESCE");
	}

	@Override
	protected String translateNOW(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "CURRENT TIMESTAMP";
	}

	@Override
	protected String translateMONTHS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		List<SqlExprAST> parameters = exprAST.getParameters();
		StringBuffer sb = new StringBuffer();
		sb.append("((YEAR(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(") - YEAR(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")) * 12 +");
		sb.append("MONTH(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(") - MONTH(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append("))");
		return sb.toString();
	}

	@Override
	protected String translateDAYS_BETWEEN(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		List<SqlExprAST> parameters = exprAST.getParameters();
		StringBuffer sb = new StringBuffer();
		sb.append("((YEAR(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(") - YEAR(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")) * 12*365 +");
		sb.append("MONTH(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(") - MONTH(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")*30");
		sb.append("+(DAY(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(")-DAY(");
		sb.append(translateExpr(parameters.get(1)));
		sb.append("))");
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateADD_MONTHS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append("(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" MONTH)");
		return sb.toString();
	}

	@Override
	protected String translateADD_YEARS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append("(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" YEAR)");
		return sb.toString();
	}

	@Override
	protected String translateADD_DAYS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append("(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" DAY)");
		return sb.toString();
	}

	@Override
	protected String translateADD_HOURS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append("(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" HOUR)");
		return sb.toString();
	}

	@Override
	protected String translateADD_MINUTES(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append("(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" MINUTE)");
		return sb.toString();
	}

	@Override
	protected String translateADD_SECONDS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append("(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append(" + ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" SECOND)");
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
		StringBuffer sb = new StringBuffer();
		sb.append("CHR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected String translateCHARINDEX(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		
		//DB2中Locate的第一个参数为待检索的字串，第二个为主字符串，与其他的正好相反
		//所以这里要颠倒它们的位置
		List<SqlExprAST> newParamList = new ArrayList<SqlExprAST>();
		List<SqlExprAST> oldParamList = exprAST.getParameters();
		newParamList.add(oldParamList.get(1));
		newParamList.add(oldParamList.get(0));
		
		return translateDefault(newParamList, "LOCATE");
	}

	@Override
	protected String translateCONCAT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(),"CONCAT");
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
		return translateDefault(exprAST.getParameters(), "LCASE");
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
		return translateDefault(exprAST.getParameters(), "UCASE");
	}

	@Override
	protected String translateTOCHAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		buffer.append("LTRIM(RTRIM(CHAR(");
		buffer.append(translateExpr(parameters.get(0)));
		buffer.append(")))");
		return buffer.toString();
	}
	
	protected String translateTO_DATE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"DATE");
	}

	@Override
	protected String translateTO_NUMBER(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		return translateDefault(exprAST.getParameters(),"DOUBLE");
	}

	@Override
	protected String translateTO_INT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		List<SqlExprAST> parameters = exprAST.getParameters();
		StringBuffer sb = new StringBuffer();
		sb.append("FLOOR(DOUBLE(");
		sb.append(translateExpr(parameters.get(0)));
		sb.append("))");
		return sb.toString();
	}

	@Override
	protected String translateRADIANS(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		String v = translateExpr(exprAST.getParameters().get(0));
		return "(" + v + "*acos(-1)/180)";
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
	protected String translateATN2(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 2);
		return translateDefault(exprAST.getParameters(), "ATAN2");
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
	
	protected String translatePI(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 0);
		return "acos(-1)";
	}
	
	protected String translateRAND(SqlMethodExprAST exprAST) throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();

		if (exprAST.getParameters().size() == 0)
		{
			buffer.append("(select SYSFUN.rand() from SYSIBM.SYSDUMMY1)");
			return buffer.toString();
		}
		if (exprAST.getParameters().size() == 1)
		{
			String v = translateExpr(exprAST.getParameters().get(0));
			buffer.append("(select SYSFUN.rand()*").append(v).append(
					" from SYSIBM.SYSDUMMY1)");
			return buffer.toString();
		}
		throw new TranslateException(" 0 or 1 parameters allowed");
	}
}
