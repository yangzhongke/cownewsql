package com.cownew.cownewsql.imsql.dialect;

import com.cownew.cownewsql.ast.node.expr.SqlDateTimeExprAST;
import com.cownew.cownewsql.imsql.IMethodTranslator;
import com.cownew.cownewsql.imsql.dialect.method.OracleMethodTranslator;

public abstract class OracleTranslator extends BaseSQLTranslator
{
	private IMethodTranslator methodTranslator;

	public OracleTranslator()
	{
		super();
		methodTranslator = new OracleMethodTranslator(this);
	}

	@Override
	protected String translateExpr(SqlDateTimeExprAST exprAST)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("TO_DATE('");
		sb.append(exprAST.getTextValue());
		sb.append("', 'YYYY-MM-DD HH24:MI:SS')");
		return sb.toString();
	}

	@Override
	public IMethodTranslator getMethodTranslator()
	{
		return methodTranslator;
	}

}
