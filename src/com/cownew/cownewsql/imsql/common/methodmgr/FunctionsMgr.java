/*
 * com.cownew.cownewsql.imsql.jdbc.FunctionsMgr.java
 * Created on 2007-10-23 ÏÂÎç11:24:02 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql.common.methodmgr;

import java.util.ArrayList;
import java.util.List;

public class FunctionsMgr
{
	private static final FunctionsMgr instance = new FunctionsMgr();

	public static FunctionsMgr getInstance()
	{
		return instance;
	}

	private List<FunctionInfo> funcList;

	private FunctionsMgr()
	{
		funcList = new ArrayList<FunctionInfo>();
		addABS();
		addACOS();
		addASIN();
		addASIN();
		addTAN();
		addATN2();
		addCEILING();
		addCOS();
		addCOT();
		addDEGREE();
		addEXP();
		addFLOOR();
		addMOD();
		addLOG();
		addLOG10();
		addPI();
		addPOWER();
		addRADIANS();
		addRAND();
		addROUND();
		addSIGN();
		addSIN();
		addSQRT();
		addCONVERT();
		addCURDATE();
		addCURTIME();
		addDATEADD();
		addDATEDIFF();
		addDAYNAME();
		addDATENAME();
		addDAYOFMONTH();
		addDAYOFWEEK();
		addDAYOFYEAR();
		addHOUR();
		addMINUTE();
		addMONTH();
		addMONTHNAME();
		addNOW();
		addQUARTER();
		addSECOND();
		addWEEK();
		addYEAR();
		addTODATE();
		addMONTHSBETWEEN();
		addDAYSBETWEEN();
		addADDMONTHS();
		addADDYEARS();
		addADDDAYS();
		addADDHOURS();
		addADDMINUTES();
		addADDSECONDS();
		addASCII();
		addCHR();
		addCHARINDEX();
		addCONCAT();
		addLEFTSTR();
		addLENGTH();
		addLCASE();
		addLTRIM();
		addREPLACE();
		addRIGHTSTR();
		addRTRIM();
		addSOUNDEX();
		addSUBSTRING();
		addTRIM();
		addUCASE();
		addTOCHAR();
		addISNULL();
		addNULLIF();
		addTONUMBER();
		addTOINT();
		addCOUNT();
		addSUM();
		addMAX();
		addMIN();
		addAVG();
	}

	public List<FunctionInfo> getFunctions()
	{
		return funcList;
	}

	private static final String getString(String key)
	{
		return Messages.getString(key);
	}

	private void put(FunctionInfo funcInfo)
	{
		funcList.add(funcInfo);
	}

	private void addABS()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("ABS");
		funcInfo.setRemarks(getString("ABS.Remarks"));
		funcInfo.setSpecificName("ABS");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("value");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("ABS.param.value.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addACOS()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("ACOS");
		funcInfo.setRemarks(getString("ACOS.Remarks"));
		funcInfo.setSpecificName("ACOS");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("value");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("ACOS.param.value.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addADDDAYS()
	{
		// ADDDAYS ADD_DAYS
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ADDDAYS", "ADD_DAYS" });
		funcInfo.setRemarks(getString("ADDDAYS.Remarks"));
		funcInfo.setSpecificName("ADDDAYS");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("datetime");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ADDDAYS.param.datetime.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("days");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ADDDAYS.param.days.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addADDHOURS()
	{
		// ADDHOURS ADD_HOURS
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ADDHOURS", "ADD_HOURS" });
		funcInfo.setRemarks(getString("ADDHOURS.Remarks"));
		funcInfo.setSpecificName("ADDHOURS");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("datetime");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ADDHOURS.param.datetime.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("hours");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ADDHOURS.param.hours.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addADDMINUTES()
	{
		// ADDMINUTES ADD_MINUTES
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ADDMINUTES", "ADD_MINUTES" });
		funcInfo.setRemarks(getString("ADDMINUTES.Remarks"));
		funcInfo.setSpecificName("ADDMINUTES");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("datetime");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ADDMINUTES.param.datetime.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("minutes");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ADDMINUTES.param.minutes.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addADDMONTHS()
	{
		// ADDMONTHS ADD_MONTHS
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ADDMONTHS", "ADD_MONTHS" });
		funcInfo.setRemarks(getString("ADDMONTHS.Remarks"));
		funcInfo.setSpecificName("ADDMONTHS");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("datetime");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ADDMONTHS.param.datetime.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("months");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ADDMONTHS.param.months.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addADDSECONDS()
	{
		// ADDSECONDS ADD_SECONDS
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ADDSECONDS", "ADD_SECONDS" });
		funcInfo.setRemarks(getString("ADDSECONDS.Remarks"));
		funcInfo.setSpecificName("ADDSECONDS");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("datetime");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ADDSECONDS.param.datetime.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("seconds");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ADDSECONDS.param.seconds.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addADDYEARS()
	{
		// ADDYEARS ADD_YEARS
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ADDYEARS", "ADD_YEARS" });
		funcInfo.setRemarks(getString("ADDYEARS.Remarks"));
		funcInfo.setSpecificName("ADDYEARS");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("datetime");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ADDYEARS.param.datetime.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("years");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ADDYEARS.param.years.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addASCII()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("ASCII");
		funcInfo.setRemarks(getString("ASCII.Remarks"));
		funcInfo.setSpecificName("ASCII");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("value");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("ASCII.param.value.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addASIN()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("ASIN");
		funcInfo.setRemarks(getString("ASIN.Remarks"));
		funcInfo.setSpecificName("ASIN");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("value");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("ASIN.param.value.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addATN2()
	{
		// ATN2 ATAN2
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ATN2", "ATAN2" });
		funcInfo.setRemarks(getString("ATN2.Remarks"));
		funcInfo.setSpecificName("ATN2");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("x");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ATN2.param.x.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("y");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ATN2.param.y.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addAVG()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("AVG");
		funcInfo.setRemarks(getString("AVG.Remarks"));
		funcInfo.setSpecificName("AVG");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("AVG.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addCEILING()
	{
		// CEILING CEIL
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "CEILING", "CEIL" });
		funcInfo.setRemarks(getString("CEILING.Remarks"));
		funcInfo.setSpecificName("CEILING");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("x");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("CEILING.param.x.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addCHARINDEX()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("CHARINDEX");
		funcInfo.setRemarks(getString("CHARINDEX.Remarks"));
		funcInfo.setSpecificName("CHARINDEX");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("CHARINDEX.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("substr");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("CHARINDEX.param.substr.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addCHR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("CHR");
		funcInfo.setRemarks(getString("CHR.Remarks"));
		funcInfo.setSpecificName("CHR");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("CHR.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addCONCAT()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("CONCAT");
		funcInfo.setRemarks(getString("CONCAT.Remarks"));
		funcInfo.setSpecificName("CONCAT");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str1");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("CONCAT.param.str1.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("str2");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("CONCAT.param.str2.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addCONVERT()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("CONVERT");
		funcInfo.setRemarks(getString("CONVERT.Remarks"));
		funcInfo.setSpecificName("CONVERT");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("type");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("CONVERT.param.type.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("CONVERT.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addCOS()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("COS");
		funcInfo.setRemarks(getString("COS.Remarks"));
		funcInfo.setSpecificName("COS");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("COS.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addCOT()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("COT");
		funcInfo.setRemarks(getString("COT.Remarks"));
		funcInfo.setSpecificName("COT");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("COT.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addCOUNT()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("COUNT");
		funcInfo.setRemarks(getString("COUNT.Remarks"));
		funcInfo.setSpecificName("COUNT");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("COUNT.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addCURDATE()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("CURDATE");
		funcInfo.setRemarks(getString("CURDATE.Remarks"));
		funcInfo.setSpecificName("CURDATE");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		put(funcInfo);
	}

	private void addCURTIME()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("CURTIME");
		funcInfo.setRemarks(getString("CURTIME.Remarks"));
		funcInfo.setSpecificName("CURTIME");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		put(funcInfo);
	}

	private void addDATEADD()
	{
		addDATEADD2param();
		addDATEADD3param();
	}

	private void addDATEADD2param()
	{
		// DATEADD DATE_ADD
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "DATEADD", "DATE_ADD" });
		funcInfo.setRemarks(getString("DATEADD2param.Remarks"));
		funcInfo.setSpecificName("DATEADD2param");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("date");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DATEADD2param.param.date.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("DATEADD2param.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addDATEADD3param()
	{
		// DATEADD DATE_ADD
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "DATEADD", "DATE_ADD" });
		funcInfo.setRemarks(getString("DATEADD3param.Remarks"));
		funcInfo.setSpecificName("DATEADD3param");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("date");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DATEADD3param.param.date.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("DATEADD3param.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		FunctionParameterInfo paramInfo3 = new FunctionParameterInfo();
		paramInfo3.setName("type");
		paramInfo3.setNullable(false);
		paramInfo3.setRemarks(getString("DATEADD3param.param.type.Remarks"));
		funcInfo.getParameterList().add(paramInfo3);

		put(funcInfo);
	}

	private void addDATEDIFF()
	{

		addDATEDIFF2param();
		addDATEDIFF3param();
	}

	private void addDATEDIFF2param()
	{
		// DATEDIFF DATE_DIFF
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "DATEDIFF", "DATE_DIFF" });
		funcInfo.setRemarks(getString("DATEDIFF2param.Remarks"));
		funcInfo.setSpecificName("DATEDIFF2param");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr1");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DATEDIFF2param.param.expr1.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr2");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("DATEDIFF2param.param.expr2.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addDATEDIFF3param()
	{
		// DATEDIFF DATE_DIFF
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "DATEDIFF", "DATE_DIFF" });
		funcInfo.setRemarks(getString("DATEDIFF3param.Remarks"));
		funcInfo.setSpecificName("DATEDIFF3param");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("type");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DATEDIFF3param.param.type.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr1");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("DATEDIFF3param.param.expr1.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		FunctionParameterInfo paramInfo3 = new FunctionParameterInfo();
		paramInfo3.setName("expr2");
		paramInfo3.setNullable(false);
		paramInfo3.setRemarks(getString("DATEDIFF3param.param.expr2.Remarks"));
		funcInfo.getParameterList().add(paramInfo3);

		put(funcInfo);
	}

	private void addDATENAME()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("DATENAME");
		funcInfo.setRemarks(getString("DATENAME.Remarks"));
		funcInfo.setSpecificName("DATENAME");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("type");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DATENAME.param.type.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("date");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("DATENAME.param.date.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addDAYNAME()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("DAYNAME");
		funcInfo.setRemarks(getString("DAYNAME.Remarks"));
		funcInfo.setSpecificName("DAYNAME");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DAYNAME.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addDAYOFMONTH()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("DAYOFMONTH");
		funcInfo.setRemarks(getString("DAYOFMONTH.Remarks"));
		funcInfo.setSpecificName("DAYOFMONTH");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DAYOFMONTH.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addDAYOFWEEK()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("DAYOFWEEK");
		funcInfo.setRemarks(getString("DAYOFWEEK.Remarks"));
		funcInfo.setSpecificName("DAYOFWEEK");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DAYOFWEEK.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addDAYOFYEAR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("DAYOFYEAR");
		funcInfo.setRemarks(getString("DAYOFYEAR.Remarks"));
		funcInfo.setSpecificName("DAYOFYEAR");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DAYOFYEAR.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addDAYSBETWEEN()
	{
		// DAYSBETWEEN DAYS_BETWEEN
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "DAYSBETWEEN", "DAYS_BETWEEN" });
		funcInfo.setRemarks(getString("DAYSBETWEEN.Remarks"));
		funcInfo.setSpecificName("DAYSBETWEEN");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr1");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DAYSBETWEEN.param.expr1.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr2");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("DAYSBETWEEN.param.expr2.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addDEGREE()
	{
		// DEGREE DEGREES
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "DEGREE", "DEGREES" });
		funcInfo.setRemarks(getString("DEGREE.Remarks"));
		funcInfo.setSpecificName("DEGREE");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("DEGREE.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addEXP()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("EXP");
		funcInfo.setRemarks(getString("EXP.Remarks"));
		funcInfo.setSpecificName("EXP");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("EXP.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addFLOOR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("FLOOR");
		funcInfo.setRemarks(getString("FLOOR.Remarks"));
		funcInfo.setSpecificName("FLOOR");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("FLOOR.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addHOUR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("HOUR");
		funcInfo.setRemarks(getString("HOUR.Remarks"));
		funcInfo.setSpecificName("HOUR");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("HOUR.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addISNULL()
	{
		// ISNULL NVL
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "ISNULL", "NVL" });
		funcInfo.setRemarks(getString("ISNULL.Remarks"));
		funcInfo.setSpecificName("ISNULL");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("check_expression");
		paramInfo1.setNullable(false);
		paramInfo1
				.setRemarks(getString("ISNULL.param.check_expression.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("replacement_value");
		paramInfo2.setNullable(false);
		paramInfo2
				.setRemarks(getString("ISNULL.param.replacement_value.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addNULLIF()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("NULLIF");
		funcInfo.setRemarks(getString("NULLIF.Remarks"));
		funcInfo.setSpecificName("NULLIF");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expression1");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("NULLIF.param.expression1.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expression2");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("NULLIF.param.expression2.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addLCASE()
	{
		// LCASE LOWER
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "LCASE", "LOWER" });
		funcInfo.setRemarks(getString("LCASE.Remarks"));
		funcInfo.setSpecificName("LCASE");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("LCASE.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addUCASE()
	{
		// UCASE UPPER
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "UCASE", "UPPER" });
		funcInfo.setRemarks(getString("UCASE.Remarks"));
		funcInfo.setSpecificName("UCASE");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("UCASE.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addLEFTSTR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("LEFTSTR");
		funcInfo.setRemarks(getString("LEFTSTR.Remarks"));
		funcInfo.setSpecificName("LEFTSTR");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("LEFTSTR.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("len");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("LEFTSTR.param.len.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addLENGTH()
	{
		// LENGTH LEN
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "LENGTH", "LEN" });
		funcInfo.setRemarks(getString("LENGTH.Remarks"));
		funcInfo.setSpecificName("LENGTH");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("LENGTH.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addLOG()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("LOG");
		funcInfo.setRemarks(getString("LOG.Remarks"));
		funcInfo.setSpecificName("LOG");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("LOG.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addLOG10()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("LOG10");
		funcInfo.setRemarks(getString("LOG10.Remarks"));
		funcInfo.setSpecificName("LOG10");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("LOG10.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addLTRIM()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("LTRIM");
		funcInfo.setRemarks(getString("LTRIM.Remarks"));
		funcInfo.setSpecificName("LTRIM");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("LTRIM.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addRTRIM()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("RTRIM");
		funcInfo.setRemarks(getString("RTRIM.Remarks"));
		funcInfo.setSpecificName("RTRIM");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("RTRIM.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addTRIM()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("TRIM");
		funcInfo.setRemarks(getString("TRIM.Remarks"));
		funcInfo.setSpecificName("TRIM");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("TRIM.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addMAX()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("MAX");
		funcInfo.setRemarks(getString("MAX.Remarks"));
		funcInfo.setSpecificName("MAX");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MAX.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addMIN()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("MIN");
		funcInfo.setRemarks(getString("MIN.Remarks"));
		funcInfo.setSpecificName("MIN");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MIN.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addSUM()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("SUM");
		funcInfo.setRemarks(getString("SUM.Remarks"));
		funcInfo.setSpecificName("SUM");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SUM.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addMINUTE()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("MINUTE");
		funcInfo.setRemarks(getString("MINUTE.Remarks"));
		funcInfo.setSpecificName("MINUTE");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MINUTE.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addMONTH()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("MONTH");
		funcInfo.setRemarks(getString("MONTH.Remarks"));
		funcInfo.setSpecificName("MONTH");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MONTH.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addWEEK()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("WEEK");
		funcInfo.setRemarks(getString("WEEK.Remarks"));
		funcInfo.setSpecificName("WEEK");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("WEEK.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addYEAR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("YEAR");
		funcInfo.setRemarks(getString("YEAR.Remarks"));
		funcInfo.setSpecificName("YEAR");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("YEAR.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addQUARTER()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("QUARTER");
		funcInfo.setRemarks(getString("QUARTER.Remarks"));
		funcInfo.setSpecificName("QUARTER");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("QUARTER.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addSECOND()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("SECOND");
		funcInfo.setRemarks(getString("SECOND.Remarks"));
		funcInfo.setSpecificName("SECOND");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SECOND.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addMONTHNAME()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("MONTHNAME");
		funcInfo.setRemarks(getString("MONTHNAME.Remarks"));
		funcInfo.setSpecificName("MONTHNAME");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MONTHNAME.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addMONTHSBETWEEN()
	{
		// MONTHSBETWEEN MONTHS_BETWEEN
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "MONTHSBETWEEN", "MONTHS_BETWEEN" });
		funcInfo.setRemarks(getString("MONTHSBETWEEN.Remarks"));
		funcInfo.setSpecificName("MONTHSBETWEEN");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr1");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MONTHSBETWEEN.param.expr1.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr2");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("MONTHSBETWEEN.param.expr2.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addNOW()
	{
		// NOW GETDATE TODAY
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("NOW");
		funcInfo.setRemarks(getString("NOW.Remarks"));
		funcInfo.setSpecificName("NOW");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		put(funcInfo);
	}

	private void addMOD()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("MOD");
		funcInfo.setRemarks(getString("MOD.Remarks"));
		funcInfo.setSpecificName("MOD");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("n");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("MOD.param.n.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("m");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("MOD.param.m.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addPI()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("PI");
		funcInfo.setRemarks(getString("PI.Remarks"));
		funcInfo.setSpecificName("PI");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		put(funcInfo);
	}

	private void addPOWER()
	{
		// POWER POW
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "POWER", "POW" });
		funcInfo.setRemarks(getString("POWER.Remarks"));
		funcInfo.setSpecificName("POWER");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("x");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("POWER.param.x.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("y");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("POWER.param.y.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addRADIANS()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("RADIANS");
		funcInfo.setRemarks(getString("RADIANS.Remarks"));
		funcInfo.setSpecificName("RADIANS");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("RADIANS.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addRAND()
	{
		addRAND0Param();
		addRAND1Param();
	}

	private void addRAND0Param()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("RAND");
		funcInfo.setRemarks(getString("RAND0Param.Remarks"));
		funcInfo.setSpecificName("RAND0Param");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		put(funcInfo);
	}

	private void addRAND1Param()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("RAND");
		funcInfo.setRemarks(getString("RAND1Param.Remarks"));
		funcInfo.setSpecificName("RAND1Param");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("RAND1Param.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addREPLACE()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("REPLACE");
		funcInfo.setRemarks(getString("REPLACE.Remarks"));
		funcInfo.setSpecificName("REPLACE");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr1");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("REPLACE.param.expr1.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("expr2");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("REPLACE.param.expr2.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		FunctionParameterInfo paramInfo3 = new FunctionParameterInfo();
		paramInfo3.setName("expr3");
		paramInfo3.setNullable(false);
		paramInfo3.setRemarks(getString("REPLACE.param.expr3.Remarks"));
		funcInfo.getParameterList().add(paramInfo3);

		put(funcInfo);
	}

	private void addRIGHTSTR()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("RIGHTSTR");
		funcInfo.setRemarks(getString("RIGHTSTR.Remarks"));
		funcInfo.setSpecificName("RIGHTSTR");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("RIGHTSTR.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("len");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("RIGHTSTR.param.len.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addROUND()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("ROUND");
		funcInfo.setRemarks(getString("ROUND.Remarks"));
		funcInfo.setSpecificName("ROUND");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("X");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("ROUND.param.X.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("D");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("ROUND.param.D.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		put(funcInfo);
	}

	private void addSIGN()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("SIGN");
		funcInfo.setRemarks(getString("SIGN.Remarks"));
		funcInfo.setSpecificName("SIGN");
		funcInfo.setType(FunctionTypeEnum.SYSTEM);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SIGN.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addSIN()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("SIN");
		funcInfo.setRemarks(getString("SIN.Remarks"));
		funcInfo.setSpecificName("SIN");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SIN.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addSOUNDEX()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("SOUNDEX");
		funcInfo.setRemarks(getString("SOUNDEX.Remarks"));
		funcInfo.setSpecificName("SOUNDEX");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SOUNDEX.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addSQRT()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("SQRT");
		funcInfo.setRemarks(getString("SQRT.Remarks"));
		funcInfo.setSpecificName("SQRT");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("expr");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SQRT.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		put(funcInfo);
	}

	private void addSUBSTRING()
	{
		// SUBSTRING SUBSTR
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "SUBSTRING", "SUBSTR" });
		funcInfo.setRemarks(getString("SUBSTRING.Remarks"));
		funcInfo.setSpecificName("SUBSTRING");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo1 = new FunctionParameterInfo();
		paramInfo1.setName("str");
		paramInfo1.setNullable(false);
		paramInfo1.setRemarks(getString("SUBSTRING.param.str.Remarks"));
		funcInfo.getParameterList().add(paramInfo1);

		FunctionParameterInfo paramInfo2 = new FunctionParameterInfo();
		paramInfo2.setName("startindex");
		paramInfo2.setNullable(false);
		paramInfo2.setRemarks(getString("SUBSTRING.param.startindex.Remarks"));
		funcInfo.getParameterList().add(paramInfo2);

		FunctionParameterInfo paramInfo3 = new FunctionParameterInfo();
		paramInfo3.setName("len");
		paramInfo3.setNullable(false);
		paramInfo3.setRemarks(getString("SUBSTRING.param.len.Remarks"));
		funcInfo.getParameterList().add(paramInfo3);

		put(funcInfo);
	}

	private void addTAN()
	{
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setName("TAN");
		funcInfo.setRemarks(getString("TAN.Remarks"));
		funcInfo.setSpecificName("TAN");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("TAN.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addTOCHAR()
	{
		// TOCHAR TO_CHAR
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "TOCHAR", "TO_CHAR" });
		funcInfo.setRemarks(getString("TOCHAR.Remarks"));
		funcInfo.setSpecificName("TOCHAR");
		funcInfo.setType(FunctionTypeEnum.STRING);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("TOCHAR.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);

		put(funcInfo);
	}

	private void addTODATE()
	{
		// TODATE TO_DATE
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "TODATE", "TO_DATE" });
		funcInfo.setRemarks(getString("TODATE.Remarks"));
		funcInfo.setSpecificName("TODATE");
		funcInfo.setType(FunctionTypeEnum.DATETIME);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("TODATE.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);
	}

	private void addTONUMBER()
	{
		// TONUMBER TO_NUMBER
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "TONUMBER", "TO_NUMBER" });
		funcInfo.setRemarks(getString("TONUMBER.Remarks"));
		funcInfo.setSpecificName("TONUMBER");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("TONUMBER.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);
	}

	private void addTOINT()
	{
		// TOINT TO_INT
		FunctionInfo funcInfo = new FunctionInfo();
		funcInfo.setNames(new String[] { "TOINT", "TO_INT" });
		funcInfo.setRemarks(getString("TOINT.Remarks"));
		funcInfo.setSpecificName("TOINT");
		funcInfo.setType(FunctionTypeEnum.NUMBRIC);

		FunctionParameterInfo paramInfo = new FunctionParameterInfo();
		paramInfo.setName("expr");
		paramInfo.setNullable(false);
		paramInfo.setRemarks(getString("TOINT.param.expr.Remarks"));
		funcInfo.getParameterList().add(paramInfo);
	}

}
