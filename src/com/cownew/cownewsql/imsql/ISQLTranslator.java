package com.cownew.cownewsql.imsql;

import com.cownew.cownewsql.ast.node.expr.SqlExprAST;
import com.cownew.cownewsql.ast.node.stmt.SqlDeleteStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlInsertBodyAST;
import com.cownew.cownewsql.ast.node.stmt.SqlSelectStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowFunctionColumnsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowFunctionsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowTableColumnsStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlShowTablesStmtAST;
import com.cownew.cownewsql.ast.node.stmt.SqlStmtBaseAST;
import com.cownew.cownewsql.ast.node.stmt.SqlUpdateBodyAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlAlterTableAddColumnStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlCreateIndexStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlCreateTableStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlDropIndexStmtAST;
import com.cownew.cownewsql.ast.node.stmt.DDL.SqlDropTableStmtAST;
import com.cownew.cownewsql.imsql.common.TranslateException;

public interface ISQLTranslator
{
	public abstract String[] translateSQL(String stdSQL)
			throws TranslateException;

	public abstract String translateStmt(SqlStmtBaseAST stmt)
			throws TranslateException;

	public abstract String translateStmt(SqlUpdateBodyAST bodyAST)
			throws TranslateException;

	public abstract String translateStmt(SqlDeleteStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlInsertBodyAST bodyAST)
			throws TranslateException;

	public abstract String translateStmt(SqlSelectStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlCreateTableStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlCreateIndexStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlDropIndexStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlDropTableStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlShowFunctionsStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlShowTablesStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlShowTableColumnsStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlShowFunctionColumnsStmtAST stmtAST)
			throws TranslateException;

	public abstract String translateStmt(SqlAlterTableAddColumnStmtAST stmtAST)
			throws TranslateException;

	public String translateExpr(SqlExprAST expr) throws TranslateException;
}