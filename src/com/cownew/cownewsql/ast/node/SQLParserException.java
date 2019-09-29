package com.cownew.cownewsql.ast.node;

public class SQLParserException extends Exception {
	String msg;

	public SQLParserException() {
		super();
	}

	public SQLParserException(String msg) {
		this.msg = msg;
	}
	public String toString(){
		return super.toString()+"\n"+msg;
	}
}
