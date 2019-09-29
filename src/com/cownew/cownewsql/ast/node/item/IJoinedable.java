package com.cownew.cownewsql.ast.node.item;

/**
 * @author KingChou
 *
 */
public interface IJoinedable {
	public SqlJoinTableItemAST getNextJoinedTable();
	public void setNextJoinedTable(SqlJoinTableItemAST ast);
}
