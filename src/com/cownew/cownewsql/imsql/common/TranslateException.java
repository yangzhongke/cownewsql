package com.cownew.cownewsql.imsql.common;

public class TranslateException extends Exception
{
	private static final long serialVersionUID = 1L;

	public TranslateException()
	{
		super();
	}

	public TranslateException(String message)
	{
		super(message);
	}

	public TranslateException(String message, Throwable e)
	{
		super(message, e);
	}

	public TranslateException(Throwable e)
	{
		super(e);
	}
}
