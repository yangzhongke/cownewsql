package com.cownew.cownewsql.imsql.dialect.method;

import java.util.List;

import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;
import com.cownew.cownewsql.imsql.ISQLTranslator;
import com.cownew.cownewsql.imsql.common.TranslateException;

public class MYSQLMethodTranslator extends BaseMethodTranslator
{

	public MYSQLMethodTranslator(ISQLTranslator sqlTranslator)
	{
		super(sqlTranslator);
	}

	@Override
	protected String translateMOD(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("MOD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)))
		  .append(" , ")
		  .append(translateExpr(parameters.get(1)));
		sb.append(")");
		return sb.toString();
	}
	

	@Override
	protected String translateCONVERT(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST,2);
		List<SqlExprAST> parameters = exprAST.getParameters();		
		StringBuffer buffer = new StringBuffer();
		String typeName = parameters.get(0).getText();
		typeName = typeName.toUpperCase();
		if (typeName.equals("CHAR")
				|| typeName.equals("VARCHAR"))
		{
			buffer.append("CONVERT(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(",CHAR)");
			return buffer.toString();
		}
		if (typeName.equals("DATETIME"))
		{
			buffer.append("CONVERT(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(",DATETIME)");
			return buffer.toString();
		}
		if (typeName.equals("DECIMAL")||typeName.equals("NUMBER"))
		{
			buffer.append("CONVERT(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(",DECIMAL)");
			return buffer.toString();
		}
		if (typeName.equals("INTEGER")
				|| typeName.equals("INT"))
		{
			buffer.append("CONVERT(");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(",SIGNED INTEGER)");
			return buffer.toString();
		}
		throw new TranslateException("this function is not implement yet");
	}
	
	@Override
	protected String translateCURDATE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,0);
		return "CURDATE()";
	}
	
	@Override
	protected String translateCURTIME(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,0);
		return "CONCAT('', CURTIME())";
	}
	
	@Override
	protected String translateDATEADD(SqlMethodExprAST exprAST) throws TranslateException
	{
		StringBuffer buffer = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			buffer.append("DATE_ADD(");
			buffer.append(translateExpr(parameters.get(0)));
			buffer.append(", INTERVAL ");
			buffer.append(translateExpr(parameters.get(1)));
			buffer.append(" SECOND)");
			return buffer.toString();
		}
		else if(parameters.size() == 3)
		{
			buffer.append("DATE_ADD(");
			buffer.append(translateExpr(parameters.get(2)));
			buffer.append(", INTERVAL ");
			buffer.append(translateExpr(parameters.get(1)));
			String type = parameters.get(0).getText().toUpperCase();
			if(type.equals("YEAR")||type.equals("YY")||type.equals("YYYY"))
			{
				buffer.append(" YEAR");
			}
			else if(type.equals("MONTH")||type.equals("MM")||type.equals("M"))
			{
				buffer.append(" MONTH");
			}
			else if(type.equals("DAY")||type.equals("DD")||type.equals("D"))
			{
				buffer.append(" DAY");
			}
			else if(type.equals("HOUR")||type.equals("HH")||type.equals("H"))
			{
				buffer.append(" HOUR");
			}
			else if(type.equals("MINUTE")||type.equals("MI")||type.equals("N"))
			{
				buffer.append(" MINUTE");
			}
			else if(type.equals("SECOND")||type.equals("SS")||type.equals("S"))
			{
				buffer.append(" SECOND");
			}
			else
			{
				throw new TranslateException("unkown type :"+type);
			}
			
			buffer.append(")");
			return buffer.toString();
		}
		throw new TranslateException("DATEADD must have 2 or 3 paraemeters");
	}
	
	@Override
	protected String translateDATEDIFF(SqlMethodExprAST exprAST) throws TranslateException
	{
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		if (parameters.size() == 2)
		{
			sb.append("DATEDIFF(");
			sb.append(translateExpr(parameters.get(0)));
			sb.append(", ");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")*24*60*60");
			return sb.toString();
		}
		if (parameters.size() == 3)
		{
			String diffType = parameters.get(0).getText();
			sb.append("DATEDIFF(");
			sb.append(translateExpr(parameters.get(2)));
			sb.append(", ");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(")");
			if(diffType.equalsIgnoreCase("Day")||diffType.equalsIgnoreCase("dd")
					||diffType.equalsIgnoreCase("d"))
			{
				//default diffType is day,so no need to add addtional expr
			}
			else if(diffType.equalsIgnoreCase("Week")||diffType.equalsIgnoreCase("wk")
					||diffType.equalsIgnoreCase("ww"))
			{
				sb.append("/7");
			}
			else if(diffType.equalsIgnoreCase("Hour")||diffType.equalsIgnoreCase("hh"))
			{
				sb.append("*24");
			}
			else if(diffType.equalsIgnoreCase("minute")||diffType.equalsIgnoreCase("mi")
					||diffType.equalsIgnoreCase("n"))
			{
				sb.append("*24*60");
			}
			else if(diffType.equalsIgnoreCase("second")||diffType.equalsIgnoreCase("ss")
					||diffType.equalsIgnoreCase("s"))
			{
				sb.append("*24*60*60");
			}
			else if(diffType.equalsIgnoreCase("millisecond")||diffType.equalsIgnoreCase("ms"))
			{
				sb.append("*24*60*60*1000");
			}
			else
			{
				throw new TranslateException("not support"+diffType);
			}
			return sb.toString();
		}	
		
		throw new TranslateException("DATEDIFF must have 2 or 3 paraemeters");
	}
	
	@Override
	protected String translateDAYNAME(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("DATE_FORMAT(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(",'%W')");
		return buffer.toString();
	}
	
	@Override
	protected String translateDAYOFMONTH(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("DATE_FORMAT(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(",'%d')");
		return buffer.toString();
	}
	
	@Override
	protected String translateDAYOFWEEK(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("DATE_FORMAT(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(",'%u')");
		return buffer.toString();
	}
	
	@Override
	protected String translateDAYOFYEAR(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer buffer = new StringBuffer();
		buffer.append("DATE_FORMAT(");
		buffer.append(translateExpr(exprAST.getParameters().get(0)));
		buffer.append(",'%j')");
		return buffer.toString();
	}
	
	@Override
	protected String translateNOW(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,0);
		return "NOW()";
	}
	
	@Override
	protected String translateHOUR(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("HOUR(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateMINUTE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("MINUTE(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateMONTH(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("MONTH(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateMONTHNAME(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("MONTHNAME(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateQUARTER(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("QUARTER(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateSECOND(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("SECOND(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateWEEK(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("WEEK(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateYEAR(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("YEAR( ");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateTO_DATE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateMONTHS_BETWEEN(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("((YEAR(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		String param0Str = translateExpr(parameters.get(0));
		sb.append(param0Str);
		sb.append(") - YEAR(");
		String param1Str = translateExpr(parameters.get(1));
		sb.append(param1Str);
		sb.append(")) * 12 + ");
		sb.append("MONTH(");
		sb.append(param0Str);
		sb.append(") - MONTH(");
		sb.append(param1Str);
		sb.append("))");
		return sb.toString();
	}
	
	@Override
	protected String translateDAYS_BETWEEN(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATEDIFF(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(",");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateADD_MONTHS(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATE_ADD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", INTERVAL ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" MONTH)");
		return sb.toString();
	}
	
	@Override
	protected String translateADD_YEARS(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATE_ADD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", INTERVAL ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" YEAR)");
		return sb.toString();
	}
	
	@Override
	protected String translateADD_DAYS(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATE_ADD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", INTERVAL ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" DAY)");
		return sb.toString();
	}
	
	@Override
	protected String translateADD_HOURS(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATE_ADD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", INTERVAL ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" HOUR)");
		return sb.toString();
	}
	
	@Override
	protected String translateADD_MINUTES(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		StringBuffer sb = new StringBuffer();
		sb.append("DATE_ADD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", INTERVAL ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" MINUTE)");
		return sb.toString();
	}
	
	@Override
	protected String translateADD_SECONDS(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);		
		StringBuffer sb = new StringBuffer();
		sb.append("DATE_ADD(");
		List<SqlExprAST> parameters = exprAST.getParameters();
		sb.append(translateExpr(parameters.get(0)));
		sb.append(", INTERVAL ");
		sb.append(translateExpr(parameters.get(1)));
		sb.append(" SECOND)");
		return sb.toString();
	}
	
	@Override
	protected String translateASCII(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"ASCII");
	}
	
	@Override
	protected String translateCHAR(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"CHAR");
	}
	
	@Override
	protected String translateCHARINDEX(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		return translateDefault(exprAST.getParameters(),"INSTR");
	}
	
	@Override
	protected String translateCONCAT(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		return translateDefault(exprAST.getParameters(),"CONCAT");
	}
	
	
	@Override
	protected String translateLENGTH(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"LENGTH");
	}
	
	@Override
	protected String translateLCASE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"LOWER");
	}
	
	
	@Override
	protected String translateSUBSTRING(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,3);
		return translateDefault(exprAST.getParameters(),"SUBSTRING");
	}
	
	@Override
	protected String translateTRIM(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);		
		StringBuffer sb = new StringBuffer();
		sb.append("TRIM(");
		sb.append(translateExpr(exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	protected String translateUCASE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);		
		return translateDefault(exprAST.getParameters(),"UPPER");
	}
	
	@Override
	protected String translateTOCHAR(SqlMethodExprAST exprAST)
			throws TranslateException
	{
		checkParamCount(exprAST, 1);
		StringBuffer sb = new StringBuffer();
		sb.append("CONCAT('', ");
		sb.append(translateExpr(
				exprAST.getParameters().get(0)));
		sb.append(")");
		return sb.toString();
	}
	
	
	@Override
	protected String translateTO_NUMBER(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("CONVERT(");
		sb.append(translateExpr(
				exprAST.getParameters().get(0)));
		sb.append(",DECIMAL)");
		return sb.toString();
	}
	
	@Override
	protected String translateTO_INT(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		StringBuffer sb = new StringBuffer();
		sb.append("FLOOR(CONVERT(");
		sb.append(translateExpr(
				exprAST.getParameters().get(0)));
		sb.append(",DECIMAL))");
		return sb.toString();
	}

	@Override
	protected String translateATN2(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		return translateDefault(exprAST.getParameters(),"ATAN2");
	}

	@Override
	protected String translateDEGREE(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"DEGREES");
	}

	@Override
	protected String translateRADIANS(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,1);
		return translateDefault(exprAST.getParameters(),"RADIANS");
	}
	
	protected String translateDATENAME(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST, 2);
		StringBuffer sb = new StringBuffer();
		List<SqlExprAST> parameters = exprAST.getParameters();
		String datepart = parameters.get(0).getText();
		datepart = datepart.toUpperCase();
		if ("YEAR".equals(datepart) || "YY".equals(datepart)
				|| "YYYY".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%Y')");
		} else if ("MONTH".equals(datepart) || "MM".equals(datepart)
				|| "M".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%M')");
		} else if ("QUARTER".equals(datepart) || "QQ".equals(datepart)
				|| "Q".equals(datepart))
		{
			sb.append("(DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%m') div 4)+1");
		} else if ("DAYOFYEAR".equals(datepart) || "DY".equals(datepart)
				|| "Y".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%j')");
		} else if ("DAY".equals(datepart) || "DD".equals(datepart)
				|| "D".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%d')");
		} else if ("WEEK".equals(datepart) || "WK".equals(datepart)
				|| "WW".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%u')");
		} else if ("WEEKDAY".equals(datepart) || "DW".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%W')");
		} else if ("HOUR".equals(datepart) || "HH".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%k')");
		} else if ("MINUTE".equals(datepart) || "MI".equals(datepart)
				|| "N".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%i')");
		} else if ("SECOND".equals(datepart) || "SS".equals(datepart)
				|| "S".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%s')");
		} else if ("MILLISECOND".equals(datepart) || "MS".equals(datepart))
		{
			sb.append("DATE_FORMAT(");
			sb.append(translateExpr(parameters.get(1)));
			sb.append(", '%f')");
		} else
		{
			throw new TranslateException("unkown type :" + datepart);
		}
		return sb.toString();		
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
	
	protected String translateISNULL(SqlMethodExprAST exprAST) throws TranslateException
	{
		checkParamCount(exprAST,2);
		return translateDefault(exprAST.getParameters(),"IFNULL");
	}
}
