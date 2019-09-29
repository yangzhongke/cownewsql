/*
 * com.cownew.cownewsql.ast.SQLParser.java
 * Created on 2007-9-7 ÏÂÎç01:42:05 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.ast;

import java.io.StringReader;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;

import com.cownew.cownewsql.ast.grammar.SQLLexer;
import com.cownew.cownewsql.ast.grammar.SQLParser;
import com.cownew.cownewsql.ast.grammar.SQLTreeParser;
import com.cownew.cownewsql.ast.node.SQLBaseAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStatementsAST;

public class SQLAstBuilder
{

	public static SqlStatementsAST getStatementsAST(String stdSQL)
			throws RecognitionException, TokenStreamException
	{
		SQLLexer lexer = new SQLLexer(new StringReader(stdSQL));
		SQLParser parser = new SQLParser(lexer);
		parser.getASTFactory().setASTNodeClass(SQLBaseAST.class);
		SqlStatementsAST stmtsAST = null;

		parser.startRule();

		AST ast = parser.getAST();

		// if in debug mode of AntlrStudio,a lot of time will be cost here!
		SQLTreeParser walker = new SQLTreeParser();

		walker.getASTFactory().setASTNodeClass(SQLBaseAST.class);
		walker.startRule(ast);
		stmtsAST = (SqlStatementsAST) walker.getAST();

		return stmtsAST;
	}

}
