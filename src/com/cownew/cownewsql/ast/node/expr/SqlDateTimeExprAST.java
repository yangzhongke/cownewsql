package com.cownew.cownewsql.ast.node.expr;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TokenTypes;

//日期常量式,{'2005-02-02'},{'2005-02-02 11:20:20.128'}
public class SqlDateTimeExprAST extends SqlConstBaseExprAST
{
	private static final long serialVersionUID = -3457391915211512391L;

	public SqlDateTimeExprAST(String textValue)
	{
		super(textValue);
		this.setType(TokenTypes.DATE);
	}

	public SqlDateTimeExprAST(AST ast)
	{
		super(ast);
	}

	public boolean hasTimePart()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		String txt = getText();
		sdf.parse(txt, pos);
		if (pos.getIndex() == 0)
		{
			return false;
		} else
		{
			return true;
		}
	}

	public Date getDate() throws ParseException
	{
		SimpleDateFormat sdf = null;
		if (hasTimePart())
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.parse(getText());
	}

	public String getText()
	{
		String s = super.getText();
		// convert "{'2008-08-08'}" to "2008-08-08"
		return s.substring(2, s.length() - 2);
	}
}
