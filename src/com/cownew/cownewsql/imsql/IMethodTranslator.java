package com.cownew.cownewsql.imsql;

import com.cownew.cownewsql.imsql.common.TranslateException;
import com.cownew.cownewsql.ast.node.expr.SqlMethodExprAST;

public interface IMethodTranslator
{
	public String translate(SqlMethodExprAST exprAST) throws TranslateException;
	public ISQLTranslator getSqlTranslator();
}
