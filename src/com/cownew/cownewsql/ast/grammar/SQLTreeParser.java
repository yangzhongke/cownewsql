// $ANTLR : "sqltreeparser.g" -> "SQLTreeParser.java"$

	package com.cownew.cownewsql.ast.grammar;
	import com.cownew.cownewsql.ast.node.*;
	import com.cownew.cownewsql.ast.node.enumdef.*;
	import com.cownew.cownewsql.ast.node.expr.*;
	import com.cownew.cownewsql.ast.node.item.*;
	import com.cownew.cownewsql.ast.node.stmt.*;
	import com.cownew.cownewsql.ast.node.stmt.DDL.*;
	import com.cownew.cownewsql.ast.node.expr.DDL.*;
	import com.cownew.cownewsql.ast.node.item.DDL.*;

import antlr.antlrStudio.ASDebuggingTreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class SQLTreeParser extends antlr.antlrStudio.ASDebuggingTreeParser       implements SQLTreeParserTokenTypes
 {

	boolean isSubQuery=false;
public SQLTreeParser() {
	tokenNames = _tokenNames;
}

	public final void startRule(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST startRule_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST startRule_AST = null;
			
			try {      // for error handling
				AST __t2 = _t;
				AST tmp1_AST = null;
				AST tmp1_AST_in = null;
				tmp1_AST = astFactory.create((AST)_t);
				tmp1_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp1_AST);
				ASTPair __currentAST2 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"startRule",1,57);
				match(_t,STATEMENTS);
				_t = _t.getFirstChild();
				{
				_loop4:
				do {
					if (_t==null) _t=ASTNULL;
					if (((_t.getType() >= CREATE_INDEX && _t.getType() <= UPDATE))) {
						bShouldFire=aboutToEnter(bShouldFire,"startRule",2,65);
						statement(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop4;
					}
					
				} while (true);
				}
				currentAST = __currentAST2;
				_t = __t2;
				_t = _t.getNextSibling();
				startRule_AST = (AST)currentAST.root;
				startRule_AST=new SqlStatementsAST(startRule_AST);
				currentAST.root = startRule_AST;
				currentAST.child = startRule_AST!=null &&startRule_AST.getFirstChild()!=null ?
					startRule_AST.getFirstChild() : startRule_AST;
				currentAST.advanceChildToEnd();
				startRule_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = startRule_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void statement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST statement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST statement_AST = null;
			
			try {      // for error handling
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SELECT:
				{
					isSubQuery=false;
					bShouldFire=aboutToEnter(bShouldFire,"statement",1,115);
					selectStmt(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case UPDATE:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",2,125);
					update(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case INSERT:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",3,135);
					insert(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case DELETE:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",4,145);
					delete(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case CREATE_TABLE:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",5,155);
					createTableStatement(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case CREATE_INDEX:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",6,165);
					createIndexStatement(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case DROP_TABLE:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",7,175);
					dropTableStatement(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case DROP_INDEX:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",8,185);
					dropIndexStatement(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case SHOW_TABLES:
				case SHOW_TABLECOLUMNS:
				case SHOW_FUNCTIONS:
				case SHOW_FUNCTIONCOLUMNS:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",9,198);
					showStatement(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case ALTERTABLE_ADD_COLUMNS:
				{
					isSubQuery=true;
					bShouldFire=aboutToEnter(bShouldFire,"statement",10,208);
					alterTableStatement(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = statement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void selectStmt(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST selectStmt_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST selectStmt_AST = null;
			AST s_AST = null;
			AST s = null;
			
			try {      // for error handling
				s = _t==ASTNULL ? null : (AST)_t;
				bShouldFire=aboutToEnter(bShouldFire,"selectStmt",1,247);
				select(_t);
				_t = _retTree;
				s_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				selectStmt_AST = (AST)currentAST.root;
				
								if(!isSubQuery)
								{
									SqlSelectStmtAST select=new SqlSelectStmtAST(s_AST);
									select.setSubQuery((SqlQueryExprAST)s_AST);
									selectStmt_AST=select;
									isSubQuery=!isSubQuery;
								}
							
				currentAST.root = selectStmt_AST;
				currentAST.child = selectStmt_AST!=null &&selectStmt_AST.getFirstChild()!=null ?
					selectStmt_AST.getFirstChild() : selectStmt_AST;
				currentAST.advanceChildToEnd();
				selectStmt_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = selectStmt_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void update(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST update_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST update_AST = null;
			
			try {      // for error handling
				AST __t19 = _t;
				AST tmp2_AST = null;
				AST tmp2_AST_in = null;
				tmp2_AST = astFactory.create((AST)_t);
				tmp2_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp2_AST);
				ASTPair __currentAST19 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"update",1,300);
				match(_t,UPDATE);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"update",2,303);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"update",3,307);
				set_clause(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case FROM_CLAUSE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"update",4,316);
					from_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case WHERE_CLAUSE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case WHERE_CLAUSE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"update",5,338);
					where_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST19;
				_t = __t19;
				_t = _t.getNextSibling();
				update_AST = (AST)currentAST.root;
				update_AST=new SqlUpdateBodyAST(update_AST);
				currentAST.root = update_AST;
				currentAST.child = update_AST!=null &&update_AST.getFirstChild()!=null ?
					update_AST.getFirstChild() : update_AST;
				currentAST.advanceChildToEnd();
				update_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = update_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void insert(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST insert_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST insert_AST = null;
			
			try {      // for error handling
				AST __t7 = _t;
				AST tmp3_AST = null;
				AST tmp3_AST_in = null;
				tmp3_AST = astFactory.create((AST)_t);
				tmp3_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp3_AST);
				ASTPair __currentAST7 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"insert",1,397);
				match(_t,INSERT);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"insert",2,400);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case COLUMN_ELEMENTS:
				{
					bShouldFire=aboutToEnter(bShouldFire,"insert",3,409);
					column_elements(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SELECT:
				case VALUE_ELEMENTS:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case VALUE_ELEMENTS:
				{
					bShouldFire=aboutToEnter(bShouldFire,"insert",4,431);
					value_elements(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SELECT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"insert",5,439);
					select(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST7;
				_t = __t7;
				_t = _t.getNextSibling();
				insert_AST = (AST)currentAST.root;
				insert_AST=new SqlInsertBodyAST(insert_AST);
				currentAST.root = insert_AST;
				currentAST.child = insert_AST!=null &&insert_AST.getFirstChild()!=null ?
					insert_AST.getFirstChild() : insert_AST;
				currentAST.advanceChildToEnd();
				insert_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = insert_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void delete(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST delete_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST delete_AST = null;
			
			try {      // for error handling
				AST __t27 = _t;
				AST tmp4_AST = null;
				AST tmp4_AST_in = null;
				tmp4_AST = astFactory.create((AST)_t);
				tmp4_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp4_AST);
				ASTPair __currentAST27 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"delete",1,494);
				match(_t,DELETE);
				_t = _t.getFirstChild();
				AST tmp5_AST = null;
				AST tmp5_AST_in = null;
				tmp5_AST = astFactory.create((AST)_t);
				tmp5_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp5_AST);
				bShouldFire=aboutToEnter(bShouldFire,"delete",2,502);
				match(_t,TABLE_NAME);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case WHERE_CLAUSE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"delete",3,510);
					where_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST27;
				_t = __t27;
				_t = _t.getNextSibling();
				delete_AST = (AST)currentAST.root;
				delete_AST=new SqlDeleteStmtAST(delete_AST);
				currentAST.root = delete_AST;
				currentAST.child = delete_AST!=null &&delete_AST.getFirstChild()!=null ?
					delete_AST.getFirstChild() : delete_AST;
				currentAST.advanceChildToEnd();
				delete_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = delete_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void createTableStatement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST createTableStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST createTableStatement_AST = null;
			
			try {      // for error handling
				AST __t149 = _t;
				AST tmp6_AST = null;
				AST tmp6_AST_in = null;
				tmp6_AST = astFactory.create((AST)_t);
				tmp6_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp6_AST);
				ASTPair __currentAST149 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",1,569);
				match(_t,CREATE_TABLE);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",2,572);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				int _cnt151=0;
				_loop151:
				do {
					if (_t==null) _t=ASTNULL;
					if (((_t.getType() >= COLUMN_DEF && _t.getType() <= UNIQUE_DEF))) {
						bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",3,582);
						tableitemdef(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt151>=1 ) { break _loop151; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt151++;
				} while (true);
				}
				currentAST = __currentAST149;
				_t = __t149;
				_t = _t.getNextSibling();
				createTableStatement_AST = (AST)currentAST.root;
				createTableStatement_AST=new SqlCreateTableStmtAST(createTableStatement_AST);
				currentAST.root = createTableStatement_AST;
				currentAST.child = createTableStatement_AST!=null &&createTableStatement_AST.getFirstChild()!=null ?
					createTableStatement_AST.getFirstChild() : createTableStatement_AST;
				currentAST.advanceChildToEnd();
				createTableStatement_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = createTableStatement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void createIndexStatement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST createIndexStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST createIndexStatement_AST = null;
			
			try {      // for error handling
				AST __t165 = _t;
				AST tmp7_AST = null;
				AST tmp7_AST_in = null;
				tmp7_AST = astFactory.create((AST)_t);
				tmp7_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp7_AST);
				ASTPair __currentAST165 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",1,637);
				match(_t,CREATE_INDEX);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",2,640);
				index_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",3,644);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",4,648);
				column_elements(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST165;
				_t = __t165;
				_t = _t.getNextSibling();
				createIndexStatement_AST = (AST)currentAST.root;
				createIndexStatement_AST=new SqlCreateIndexStmtAST(createIndexStatement_AST);
				currentAST.root = createIndexStatement_AST;
				currentAST.child = createIndexStatement_AST!=null &&createIndexStatement_AST.getFirstChild()!=null ?
					createIndexStatement_AST.getFirstChild() : createIndexStatement_AST;
				currentAST.advanceChildToEnd();
				createIndexStatement_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = createIndexStatement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void dropTableStatement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST dropTableStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST dropTableStatement_AST = null;
			
			try {      // for error handling
				AST __t167 = _t;
				AST tmp8_AST = null;
				AST tmp8_AST_in = null;
				tmp8_AST = astFactory.create((AST)_t);
				tmp8_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp8_AST);
				ASTPair __currentAST167 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"dropTableStatement",1,695);
				match(_t,DROP_TABLE);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"dropTableStatement",2,698);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST167;
				_t = __t167;
				_t = _t.getNextSibling();
				dropTableStatement_AST = (AST)currentAST.root;
				dropTableStatement_AST=new SqlDropTableStmtAST(dropTableStatement_AST);
				currentAST.root = dropTableStatement_AST;
				currentAST.child = dropTableStatement_AST!=null &&dropTableStatement_AST.getFirstChild()!=null ?
					dropTableStatement_AST.getFirstChild() : dropTableStatement_AST;
				currentAST.advanceChildToEnd();
				dropTableStatement_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = dropTableStatement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void dropIndexStatement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST dropIndexStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST dropIndexStatement_AST = null;
			
			try {      // for error handling
				AST __t169 = _t;
				AST tmp9_AST = null;
				AST tmp9_AST_in = null;
				tmp9_AST = astFactory.create((AST)_t);
				tmp9_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp9_AST);
				ASTPair __currentAST169 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",1,745);
				match(_t,DROP_INDEX);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",2,748);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",3,752);
				index_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST169;
				_t = __t169;
				_t = _t.getNextSibling();
				dropIndexStatement_AST = (AST)currentAST.root;
				dropIndexStatement_AST=new SqlDropIndexStmtAST(dropIndexStatement_AST);
				currentAST.root = dropIndexStatement_AST;
				currentAST.child = dropIndexStatement_AST!=null &&dropIndexStatement_AST.getFirstChild()!=null ?
					dropIndexStatement_AST.getFirstChild() : dropIndexStatement_AST;
				currentAST.advanceChildToEnd();
				dropIndexStatement_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = dropIndexStatement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void showStatement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST showStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST showStatement_AST = null;
			
			try {      // for error handling
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SHOW_TABLES:
				{
					AST __t173 = _t;
					AST tmp10_AST = null;
					AST tmp10_AST_in = null;
					tmp10_AST = astFactory.create((AST)_t);
					tmp10_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp10_AST);
					ASTPair __currentAST173 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",1,803);
					match(_t,SHOW_TABLES);
					_t = _t.getFirstChild();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case ID:
					{
						AST tmp11_AST = null;
						AST tmp11_AST_in = null;
						tmp11_AST = astFactory.create((AST)_t);
						tmp11_AST_in = (AST)_t;
						astFactory.addASTChild(currentAST, tmp11_AST);
						bShouldFire=aboutToEnter(bShouldFire,"showStatement",2,816);
						match(_t,ID);
						_t = _t.getNextSibling();
						break;
					}
					case 3:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					currentAST = __currentAST173;
					_t = __t173;
					_t = _t.getNextSibling();
					showStatement_AST = (AST)currentAST.root;
					showStatement_AST=new SqlShowTablesStmtAST(showStatement_AST);
					currentAST.root = showStatement_AST;
					currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
						showStatement_AST.getFirstChild() : showStatement_AST;
					currentAST.advanceChildToEnd();
					showStatement_AST = (AST)currentAST.root;
					break;
				}
				case SHOW_TABLECOLUMNS:
				{
					AST __t175 = _t;
					AST tmp12_AST = null;
					AST tmp12_AST_in = null;
					tmp12_AST = astFactory.create((AST)_t);
					tmp12_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp12_AST);
					ASTPair __currentAST175 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",3,854);
					match(_t,SHOW_TABLECOLUMNS);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",4,857);
					table_name(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST175;
					_t = __t175;
					_t = _t.getNextSibling();
					showStatement_AST = (AST)currentAST.root;
					showStatement_AST=new SqlShowTableColumnsStmtAST(showStatement_AST);
					currentAST.root = showStatement_AST;
					currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
						showStatement_AST.getFirstChild() : showStatement_AST;
					currentAST.advanceChildToEnd();
					showStatement_AST = (AST)currentAST.root;
					break;
				}
				case SHOW_FUNCTIONS:
				{
					AST tmp13_AST = null;
					AST tmp13_AST_in = null;
					tmp13_AST = astFactory.create((AST)_t);
					tmp13_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp13_AST);
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",5,880);
					match(_t,SHOW_FUNCTIONS);
					_t = _t.getNextSibling();
					showStatement_AST = (AST)currentAST.root;
					showStatement_AST=new SqlShowFunctionsStmtAST(showStatement_AST);
					currentAST.root = showStatement_AST;
					currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
						showStatement_AST.getFirstChild() : showStatement_AST;
					currentAST.advanceChildToEnd();
					showStatement_AST = (AST)currentAST.root;
					break;
				}
				case SHOW_FUNCTIONCOLUMNS:
				{
					AST tmp14_AST = null;
					AST tmp14_AST_in = null;
					tmp14_AST = astFactory.create((AST)_t);
					tmp14_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp14_AST);
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",6,899);
					match(_t,SHOW_FUNCTIONCOLUMNS);
					_t = _t.getNextSibling();
					showStatement_AST = (AST)currentAST.root;
					showStatement_AST=new SqlShowFunctionColumnsStmtAST(showStatement_AST);
					currentAST.root = showStatement_AST;
					currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
						showStatement_AST.getFirstChild() : showStatement_AST;
					currentAST.advanceChildToEnd();
					showStatement_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = showStatement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void alterTableStatement(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST alterTableStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST alterTableStatement_AST = null;
			
			try {      // for error handling
				AST __t171 = _t;
				AST tmp15_AST = null;
				AST tmp15_AST_in = null;
				tmp15_AST = astFactory.create((AST)_t);
				tmp15_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp15_AST);
				ASTPair __currentAST171 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",1,949);
				match(_t,ALTERTABLE_ADD_COLUMNS);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",2,952);
				table_name(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",3,956);
				column_def(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST171;
				_t = __t171;
				_t = _t.getNextSibling();
				alterTableStatement_AST = (AST)currentAST.root;
				alterTableStatement_AST=new SqlAlterTableAddColumnStmtAST(alterTableStatement_AST);
				currentAST.root = alterTableStatement_AST;
				currentAST.child = alterTableStatement_AST!=null &&alterTableStatement_AST.getFirstChild()!=null ?
					alterTableStatement_AST.getFirstChild() : alterTableStatement_AST;
				currentAST.advanceChildToEnd();
				alterTableStatement_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = alterTableStatement_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void table_name(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST table_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_name_AST = null;
			
			try {      // for error handling
				AST tmp16_AST = null;
				AST tmp16_AST_in = null;
				tmp16_AST = astFactory.create((AST)_t);
				tmp16_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp16_AST);
				bShouldFire=aboutToEnter(bShouldFire,"table_name",1,999);
				match(_t,TABLE_NAME);
				_t = _t.getNextSibling();
				table_name_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = table_name_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void column_elements(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST column_elements_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_elements_AST = null;
			
			try {      // for error handling
				AST __t11 = _t;
				AST tmp17_AST = null;
				AST tmp17_AST_in = null;
				tmp17_AST = astFactory.create((AST)_t);
				tmp17_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp17_AST);
				ASTPair __currentAST11 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"column_elements",1,1036);
				match(_t,COLUMN_ELEMENTS);
				_t = _t.getFirstChild();
				{
				int _cnt13=0;
				_loop13:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						bShouldFire=aboutToEnter(bShouldFire,"column_elements",2,1045);
						expr(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt13>=1 ) { break _loop13; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt13++;
				} while (true);
				}
				currentAST = __currentAST11;
				_t = __t11;
				_t = _t.getNextSibling();
				column_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = column_elements_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void value_elements(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST value_elements_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST value_elements_AST = null;
			
			try {      // for error handling
				AST __t15 = _t;
				AST tmp18_AST = null;
				AST tmp18_AST_in = null;
				tmp18_AST = astFactory.create((AST)_t);
				tmp18_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp18_AST);
				ASTPair __currentAST15 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"value_elements",1,1094);
				match(_t,VALUE_ELEMENTS);
				_t = _t.getFirstChild();
				{
				int _cnt17=0;
				_loop17:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						bShouldFire=aboutToEnter(bShouldFire,"value_elements",2,1103);
						expr(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt17>=1 ) { break _loop17; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt17++;
				} while (true);
				}
				currentAST = __currentAST15;
				_t = __t15;
				_t = _t.getNextSibling();
				value_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = value_elements_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void select(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST select_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST select_AST = null;
			AST s = null;
			AST s_AST = null;
			AST a_AST = null;
			AST a = null;
			AST t_AST = null;
			AST t = null;
			AST se_AST = null;
			AST se = null;
			AST f_AST = null;
			AST f = null;
			AST w_AST = null;
			AST w = null;
			AST g_AST = null;
			AST g = null;
			AST h_AST = null;
			AST h = null;
			AST l_AST = null;
			AST l = null;
			AST r_AST = null;
			AST r = null;
			
			try {      // for error handling
				AST __t31 = _t;
				s = _t==ASTNULL ? null :(AST)_t;
				AST s_AST_in = null;
				s_AST = astFactory.create(s);
				astFactory.addASTChild(currentAST, s_AST);
				ASTPair __currentAST31 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"select",1,1171);
				match(_t,SELECT);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case AGGREGATE_TYPE:
				{
					a = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",2,1180);
					aggregate_type(_t);
					_t = _retTree;
					a_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COLUMN_ELEMENTS:
				case TOP_ELEMENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TOP_ELEMENT:
				{
					t = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",3,1204);
					top_element(_t);
					_t = _retTree;
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case COLUMN_ELEMENTS:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				se = _t==ASTNULL ? null : (AST)_t;
				bShouldFire=aboutToEnter(bShouldFire,"select",4,1222);
				select_elements(_t);
				_t = _retTree;
				se_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case FROM_CLAUSE:
				{
					f = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",5,1233);
					from_clause(_t);
					_t = _retTree;
					f_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				case WHERE_CLAUSE:
				case GROUP_BY_CLAUSE:
				case HAVING_CLAUSE:
				case ORDER_BY_CLAUSE:
				case LIMIT_OPTIONAL:
				case ROWNUM_OPTIONAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case WHERE_CLAUSE:
				{
					w = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",6,1263);
					where_clause(_t);
					_t = _retTree;
					w_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				case GROUP_BY_CLAUSE:
				case HAVING_CLAUSE:
				case ORDER_BY_CLAUSE:
				case LIMIT_OPTIONAL:
				case ROWNUM_OPTIONAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case GROUP_BY_CLAUSE:
				{
					g = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",7,1292);
					group_by_clause(_t);
					_t = _retTree;
					g_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				case HAVING_CLAUSE:
				case ORDER_BY_CLAUSE:
				case LIMIT_OPTIONAL:
				case ROWNUM_OPTIONAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case HAVING_CLAUSE:
				{
					h = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",8,1320);
					having_clause(_t);
					_t = _retTree;
					h_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				case ORDER_BY_CLAUSE:
				case LIMIT_OPTIONAL:
				case ROWNUM_OPTIONAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ORDER_BY_CLAUSE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"select",9,1346);
					order_by_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				case LIMIT_OPTIONAL:
				case ROWNUM_OPTIONAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LIMIT_OPTIONAL:
				{
					l = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",10,1371);
					limit_optional(_t);
					_t = _retTree;
					l_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				case ROWNUM_OPTIONAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ROWNUM_OPTIONAL:
				{
					r = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"select",11,1396);
					rownum_optional(_t);
					_t = _retTree;
					r_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case UNION:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case UNION:
				{
					bShouldFire=aboutToEnter(bShouldFire,"select",12,1419);
					union_clause(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST31;
				_t = __t31;
				_t = _t.getNextSibling();
				select_AST = (AST)currentAST.root;
				
							select_AST=new SqlQueryExprAST(select_AST);
					
				currentAST.root = select_AST;
				currentAST.child = select_AST!=null &&select_AST.getFirstChild()!=null ?
					select_AST.getFirstChild() : select_AST;
				currentAST.advanceChildToEnd();
				select_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = select_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void expr(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST expr_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST expr_AST = null;
			AST f_AST = null;
			AST f = null;
			
			try {      // for error handling
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case OR:
				{
					AST __t101 = _t;
					AST tmp19_AST = null;
					AST tmp19_AST_in = null;
					tmp19_AST = astFactory.create((AST)_t);
					tmp19_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp19_AST);
					ASTPair __currentAST101 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",1,1486);
					match(_t,OR);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",2,1489);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",3,1493);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST101;
					_t = __t101;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					
							
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case AND:
				{
					AST __t102 = _t;
					AST tmp20_AST = null;
					AST tmp20_AST_in = null;
					tmp20_AST = astFactory.create((AST)_t);
					tmp20_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp20_AST);
					ASTPair __currentAST102 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",4,1523);
					match(_t,AND);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",5,1526);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",6,1530);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST102;
					_t = __t102;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//2
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
							
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case EQUAL:
				{
					AST __t103 = _t;
					AST tmp21_AST = null;
					AST tmp21_AST_in = null;
					tmp21_AST = astFactory.create((AST)_t);
					tmp21_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp21_AST);
					ASTPair __currentAST103 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",7,1559);
					match(_t,EQUAL);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",8,1562);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",9,1566);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST103;
					_t = __t103;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//3
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
							
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case GREATER:
				{
					AST __t104 = _t;
					AST tmp22_AST = null;
					AST tmp22_AST_in = null;
					tmp22_AST = astFactory.create((AST)_t);
					tmp22_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp22_AST);
					ASTPair __currentAST104 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",10,1595);
					match(_t,GREATER);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",11,1598);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",12,1602);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST104;
					_t = __t104;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//4
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
							
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case LESS:
				{
					AST __t105 = _t;
					AST tmp23_AST = null;
					AST tmp23_AST_in = null;
					tmp23_AST = astFactory.create((AST)_t);
					tmp23_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp23_AST);
					ASTPair __currentAST105 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",13,1631);
					match(_t,LESS);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",14,1634);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",15,1638);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST105;
					_t = __t105;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//5
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case GR_EQ:
				{
					AST __t106 = _t;
					AST tmp24_AST = null;
					AST tmp24_AST_in = null;
					tmp24_AST = astFactory.create((AST)_t);
					tmp24_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp24_AST);
					ASTPair __currentAST106 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",16,1667);
					match(_t,GR_EQ);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",17,1670);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",18,1674);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST106;
					_t = __t106;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//6
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case LE_EQ:
				{
					AST __t107 = _t;
					AST tmp25_AST = null;
					AST tmp25_AST_in = null;
					tmp25_AST = astFactory.create((AST)_t);
					tmp25_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp25_AST);
					ASTPair __currentAST107 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",19,1703);
					match(_t,LE_EQ);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",20,1706);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",21,1710);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST107;
					_t = __t107;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//7
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NOT_EQ:
				{
					AST __t108 = _t;
					AST tmp26_AST = null;
					AST tmp26_AST_in = null;
					tmp26_AST = astFactory.create((AST)_t);
					tmp26_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp26_AST);
					ASTPair __currentAST108 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",22,1739);
					match(_t,NOT_EQ);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",23,1742);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",24,1746);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST108;
					_t = __t108;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//8
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NOT_IN:
				{
					AST __t109 = _t;
					AST tmp27_AST = null;
					AST tmp27_AST_in = null;
					tmp27_AST = astFactory.create((AST)_t);
					tmp27_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp27_AST);
					ASTPair __currentAST109 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",25,1775);
					match(_t,NOT_IN);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",26,1778);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",27,1782);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST109;
					_t = __t109;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//9
							expr_AST=new SqlInExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case IN:
				{
					AST __t110 = _t;
					AST tmp28_AST = null;
					AST tmp28_AST_in = null;
					tmp28_AST = astFactory.create((AST)_t);
					tmp28_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp28_AST);
					ASTPair __currentAST110 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",28,1811);
					match(_t,IN);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",29,1814);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",30,1818);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST110;
					_t = __t110;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//10
							expr_AST=new SqlInExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case BETWEEN:
				{
					AST __t111 = _t;
					AST tmp29_AST = null;
					AST tmp29_AST_in = null;
					tmp29_AST = astFactory.create((AST)_t);
					tmp29_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp29_AST);
					ASTPair __currentAST111 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",31,1847);
					match(_t,BETWEEN);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",32,1850);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",33,1854);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",34,1858);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST111;
					_t = __t111;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//11
							expr_AST=new SqlBetweenExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NOT_BETWEEN:
				{
					AST __t112 = _t;
					AST tmp30_AST = null;
					AST tmp30_AST_in = null;
					tmp30_AST = astFactory.create((AST)_t);
					tmp30_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp30_AST);
					ASTPair __currentAST112 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",35,1887);
					match(_t,NOT_BETWEEN);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",36,1890);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",37,1894);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",38,1898);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST112;
					_t = __t112;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//12
							expr_AST=new SqlBetweenExprAST(expr_AST);//
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case LIKE:
				{
					AST __t113 = _t;
					AST tmp31_AST = null;
					AST tmp31_AST_in = null;
					tmp31_AST = astFactory.create((AST)_t);
					tmp31_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp31_AST);
					ASTPair __currentAST113 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",39,1927);
					match(_t,LIKE);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",40,1930);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",41,1934);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST113;
					_t = __t113;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//13
							expr_AST=new SqlLikeExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NOT_LIKE:
				{
					AST __t114 = _t;
					AST tmp32_AST = null;
					AST tmp32_AST_in = null;
					tmp32_AST = astFactory.create((AST)_t);
					tmp32_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp32_AST);
					ASTPair __currentAST114 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",42,1963);
					match(_t,NOT_LIKE);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",43,1966);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",44,1970);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST114;
					_t = __t114;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//14
							
							expr_AST=new SqlLikeExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case IS:
				{
					AST __t115 = _t;
					AST tmp33_AST = null;
					AST tmp33_AST_in = null;
					tmp33_AST = astFactory.create((AST)_t);
					tmp33_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp33_AST);
					ASTPair __currentAST115 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",45,2000);
					match(_t,IS);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",46,2003);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",47,2007);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST115;
					_t = __t115;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//15
							expr_AST=new SqlIsExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case IS_NOT:
				{
					AST __t116 = _t;
					AST tmp34_AST = null;
					AST tmp34_AST_in = null;
					tmp34_AST = astFactory.create((AST)_t);
					tmp34_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp34_AST);
					ASTPair __currentAST116 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",48,2036);
					match(_t,IS_NOT);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",49,2039);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",50,2043);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST116;
					_t = __t116;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					
							
							expr_AST=new SqlIsExprAST(expr_AST);
							
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NOT:
				{
					AST __t117 = _t;
					AST tmp35_AST = null;
					AST tmp35_AST_in = null;
					tmp35_AST = astFactory.create((AST)_t);
					tmp35_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp35_AST);
					ASTPair __currentAST117 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",51,2073);
					match(_t,NOT);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",52,2076);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST117;
					_t = __t117;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//16
							expr_AST=new SqlUnaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case PLUS:
				{
					AST __t118 = _t;
					AST tmp36_AST = null;
					AST tmp36_AST_in = null;
					tmp36_AST = astFactory.create((AST)_t);
					tmp36_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp36_AST);
					ASTPair __currentAST118 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",53,2105);
					match(_t,PLUS);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",54,2108);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",55,2112);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST118;
					_t = __t118;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//17
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case SUB:
				{
					AST __t119 = _t;
					AST tmp37_AST = null;
					AST tmp37_AST_in = null;
					tmp37_AST = astFactory.create((AST)_t);
					tmp37_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp37_AST);
					ASTPair __currentAST119 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",56,2141);
					match(_t,SUB);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",57,2144);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",58,2148);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST119;
					_t = __t119;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//18
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case STAR:
				{
					AST __t120 = _t;
					AST tmp38_AST = null;
					AST tmp38_AST_in = null;
					tmp38_AST = astFactory.create((AST)_t);
					tmp38_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp38_AST);
					ASTPair __currentAST120 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",59,2177);
					match(_t,STAR);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",60,2180);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",61,2184);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST120;
					_t = __t120;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//19
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case DIV:
				{
					AST __t121 = _t;
					AST tmp39_AST = null;
					AST tmp39_AST_in = null;
					tmp39_AST = astFactory.create((AST)_t);
					tmp39_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp39_AST);
					ASTPair __currentAST121 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",62,2213);
					match(_t,DIV);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",63,2216);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",64,2220);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST121;
					_t = __t121;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//20
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case MOD:
				{
					AST __t122 = _t;
					AST tmp40_AST = null;
					AST tmp40_AST_in = null;
					tmp40_AST = astFactory.create((AST)_t);
					tmp40_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp40_AST);
					ASTPair __currentAST122 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",65,2249);
					match(_t,MOD);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",66,2252);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",67,2256);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST122;
					_t = __t122;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//21
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case CONCAT:
				{
					AST __t123 = _t;
					AST tmp41_AST = null;
					AST tmp41_AST_in = null;
					tmp41_AST = astFactory.create((AST)_t);
					tmp41_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp41_AST);
					ASTPair __currentAST123 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",68,2285);
					match(_t,CONCAT);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",69,2288);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",70,2292);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST123;
					_t = __t123;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//22
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case DOT:
				{
					AST __t124 = _t;
					AST tmp42_AST = null;
					AST tmp42_AST_in = null;
					tmp42_AST = astFactory.create((AST)_t);
					tmp42_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp42_AST);
					ASTPair __currentAST124 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",71,2321);
					match(_t,DOT);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",72,2324);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",73,2328);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST124;
					_t = __t124;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//23
							expr_AST=new SqlBinaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case ANY:
				{
					AST __t125 = _t;
					AST tmp43_AST = null;
					AST tmp43_AST_in = null;
					tmp43_AST = astFactory.create((AST)_t);
					tmp43_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp43_AST);
					ASTPair __currentAST125 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",74,2357);
					match(_t,ANY);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",75,2360);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST125;
					_t = __t125;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//24
							expr_AST=new SqlUnaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case SOME:
				{
					AST __t126 = _t;
					AST tmp44_AST = null;
					AST tmp44_AST_in = null;
					tmp44_AST = astFactory.create((AST)_t);
					tmp44_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp44_AST);
					ASTPair __currentAST126 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",76,2389);
					match(_t,SOME);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",77,2392);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST126;
					_t = __t126;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//25
							expr_AST=new SqlUnaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case ALL:
				{
					AST __t127 = _t;
					AST tmp45_AST = null;
					AST tmp45_AST_in = null;
					tmp45_AST = astFactory.create((AST)_t);
					tmp45_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp45_AST);
					ASTPair __currentAST127 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",78,2421);
					match(_t,ALL);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",79,2424);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST127;
					_t = __t127;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//25
							expr_AST=new SqlUnaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case EXISTS:
				{
					AST __t128 = _t;
					AST tmp46_AST = null;
					AST tmp46_AST_in = null;
					tmp46_AST = astFactory.create((AST)_t);
					tmp46_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp46_AST);
					ASTPair __currentAST128 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",80,2453);
					match(_t,EXISTS);
					_t = _t.getFirstChild();
					bShouldFire=aboutToEnter(bShouldFire,"expr",81,2456);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					currentAST = __currentAST128;
					_t = __t128;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//26
							expr_AST=new SqlUnaryOpExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case FUNCTION:
				{
					AST __t129 = _t;
					AST tmp47_AST = null;
					AST tmp47_AST_in = null;
					tmp47_AST = astFactory.create((AST)_t);
					tmp47_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp47_AST);
					ASTPair __currentAST129 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",82,2485);
					match(_t,FUNCTION);
					_t = _t.getFirstChild();
					f = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"expr",83,2489);
					function_name(_t);
					_t = _retTree;
					f_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					{
					bShouldFire=aboutToEnter(bShouldFire,"expr",84,2495);
					function_parameters(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					}
					currentAST = __currentAST129;
					_t = __t129;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//27
							expr_AST=new SqlMethodExprAST(expr_AST);
						
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case TABLE_NAME:
				{
					AST tmp48_AST = null;
					AST tmp48_AST_in = null;
					tmp48_AST = astFactory.create((AST)_t);
					tmp48_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp48_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",85,2521);
					match(_t,TABLE_NAME);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlIdentifierExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case COLUMN_NAME:
				{
					AST tmp49_AST = null;
					AST tmp49_AST_in = null;
					tmp49_AST = astFactory.create((AST)_t);
					tmp49_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp49_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",86,2540);
					match(_t,COLUMN_NAME);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlIdentifierExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case CONST_STRING:
				{
					AST tmp50_AST = null;
					AST tmp50_AST_in = null;
					tmp50_AST = astFactory.create((AST)_t);
					tmp50_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp50_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",87,2559);
					match(_t,CONST_STRING);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlCharExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NULL:
				{
					AST tmp51_AST = null;
					AST tmp51_AST_in = null;
					tmp51_AST = astFactory.create((AST)_t);
					tmp51_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp51_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",88,2578);
					match(_t,NULL);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlNullExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case DEFAULT:
				{
					AST tmp52_AST = null;
					AST tmp52_AST_in = null;
					tmp52_AST = astFactory.create((AST)_t);
					tmp52_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp52_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",89,2597);
					match(_t,DEFAULT);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlIdentifierExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NUM_INT:
				{
					AST tmp53_AST = null;
					AST tmp53_AST_in = null;
					tmp53_AST = astFactory.create((AST)_t);
					tmp53_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp53_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",90,2616);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlIntExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NUM_FLOAT:
				{
					AST tmp54_AST = null;
					AST tmp54_AST_in = null;
					tmp54_AST = astFactory.create((AST)_t);
					tmp54_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp54_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",91,2635);
					match(_t,NUM_FLOAT);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlDoubleExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NUM_REAL:
				{
					AST tmp55_AST = null;
					AST tmp55_AST_in = null;
					tmp55_AST = astFactory.create((AST)_t);
					tmp55_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp55_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",92,2654);
					match(_t,NUM_REAL);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlDoubleExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case NUM_HEX:
				{
					AST tmp56_AST = null;
					AST tmp56_AST_in = null;
					tmp56_AST = astFactory.create((AST)_t);
					tmp56_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp56_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",93,2673);
					match(_t,NUM_HEX);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlHexExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case BOOLEAN:
				{
					AST tmp57_AST = null;
					AST tmp57_AST_in = null;
					tmp57_AST = astFactory.create((AST)_t);
					tmp57_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp57_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",94,2692);
					match(_t,BOOLEAN);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlIdentifierExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case DATE:
				{
					AST tmp58_AST = null;
					AST tmp58_AST_in = null;
					tmp58_AST = astFactory.create((AST)_t);
					tmp58_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp58_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",95,2711);
					match(_t,DATE);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlDateTimeExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case N_CONST_STRING:
				{
					AST tmp59_AST = null;
					AST tmp59_AST_in = null;
					tmp59_AST = astFactory.create((AST)_t);
					tmp59_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp59_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",96,2730);
					match(_t,N_CONST_STRING);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlNCharExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case SELECT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"expr",97,2744);
					select(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlQueryExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case IN_LIST:
				{
					AST __t131 = _t;
					AST tmp60_AST = null;
					AST tmp60_AST_in = null;
					tmp60_AST = astFactory.create((AST)_t);
					tmp60_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp60_AST);
					ASTPair __currentAST131 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"expr",98,2768);
					match(_t,IN_LIST);
					_t = _t.getFirstChild();
					{
					int _cnt133=0;
					_loop133:
					do {
						if (_t==null) _t=ASTNULL;
						if ((_tokenSet_0.member(_t.getType()))) {
							bShouldFire=aboutToEnter(bShouldFire,"expr",99,2777);
							expr(_t);
							_t = _retTree;
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							if ( _cnt133>=1 ) { break _loop133; } else {throw new NoViableAltException(_t);}
						}
						
						_cnt133++;
					} while (true);
					}
					currentAST = __currentAST131;
					_t = __t131;
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					//41
							expr_AST=new SqlListExprAST(expr_AST);
							
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case ALL_COLUMNS:
				{
					AST tmp61_AST = null;
					AST tmp61_AST_in = null;
					tmp61_AST = astFactory.create((AST)_t);
					tmp61_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp61_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",100,2810);
					match(_t,ALL_COLUMNS);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlIdentifierExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				case Q_MARK:
				{
					AST tmp62_AST = null;
					AST tmp62_AST_in = null;
					tmp62_AST = astFactory.create((AST)_t);
					tmp62_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp62_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",101,2829);
					match(_t,Q_MARK);
					_t = _t.getNextSibling();
					expr_AST = (AST)currentAST.root;
					expr_AST=new SqlQuestionMarkExprAST(expr_AST);
					currentAST.root = expr_AST;
					currentAST.child = expr_AST!=null &&expr_AST.getFirstChild()!=null ?
						expr_AST.getFirstChild() : expr_AST;
					currentAST.advanceChildToEnd();
					expr_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = expr_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void set_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST set_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST set_clause_AST = null;
			
			try {      // for error handling
				AST __t23 = _t;
				AST tmp63_AST = null;
				AST tmp63_AST_in = null;
				tmp63_AST = astFactory.create((AST)_t);
				tmp63_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp63_AST);
				ASTPair __currentAST23 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"set_clause",1,2879);
				match(_t,SET_CLAUSE);
				_t = _t.getFirstChild();
				{
				int _cnt25=0;
				_loop25:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						bShouldFire=aboutToEnter(bShouldFire,"set_clause",2,2888);
						expr(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt25>=1 ) { break _loop25; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt25++;
				} while (true);
				}
				currentAST = __currentAST23;
				_t = __t23;
				_t = _t.getNextSibling();
				set_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = set_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void from_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST from_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST from_clause_AST = null;
			
			try {      // for error handling
				AST __t58 = _t;
				AST tmp64_AST = null;
				AST tmp64_AST_in = null;
				tmp64_AST = astFactory.create((AST)_t);
				tmp64_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp64_AST);
				ASTPair __currentAST58 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"from_clause",1,2937);
				match(_t,FROM_CLAUSE);
				_t = _t.getFirstChild();
				{
				int _cnt60=0;
				_loop60:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==TABLE_ELEMENT)) {
						bShouldFire=aboutToEnter(bShouldFire,"from_clause",2,2946);
						table_element(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt60>=1 ) { break _loop60; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt60++;
				} while (true);
				}
				currentAST = __currentAST58;
				_t = __t58;
				_t = _t.getNextSibling();
				from_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = from_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void where_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST where_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST where_clause_AST = null;
			
			try {      // for error handling
				AST __t78 = _t;
				AST tmp65_AST = null;
				AST tmp65_AST_in = null;
				tmp65_AST = astFactory.create((AST)_t);
				tmp65_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp65_AST);
				ASTPair __currentAST78 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"where_clause",1,2995);
				match(_t,WHERE_CLAUSE);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"where_clause",2,2998);
				search_condition2(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST78;
				_t = __t78;
				_t = _t.getNextSibling();
				where_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = where_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void aggregate_type(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST aggregate_type_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST aggregate_type_AST = null;
			AST d = null;
			AST d_AST = null;
			AST a = null;
			AST a_AST = null;
			
			try {      // for error handling
				AST __t46 = _t;
				AST tmp66_AST = null;
				AST tmp66_AST_in = null;
				tmp66_AST = astFactory.create((AST)_t);
				tmp66_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp66_AST);
				ASTPair __currentAST46 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"aggregate_type",1,3043);
				match(_t,AGGREGATE_TYPE);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case DISTINCT:
				{
					d = (AST)_t;
					AST d_AST_in = null;
					d_AST = astFactory.create(d);
					astFactory.addASTChild(currentAST, d_AST);
					bShouldFire=aboutToEnter(bShouldFire,"aggregate_type",2,3055);
					match(_t,DISTINCT);
					_t = _t.getNextSibling();
					break;
				}
				case ALL:
				{
					a = (AST)_t;
					AST a_AST_in = null;
					a_AST = astFactory.create(a);
					astFactory.addASTChild(currentAST, a_AST);
					bShouldFire=aboutToEnter(bShouldFire,"aggregate_type",3,3066);
					match(_t,ALL);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST46;
				_t = __t46;
				_t = _t.getNextSibling();
				aggregate_type_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = aggregate_type_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void top_element(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST top_element_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST top_element_AST = null;
			AST i = null;
			AST i_AST = null;
			
			try {      // for error handling
				AST __t49 = _t;
				AST tmp67_AST = null;
				AST tmp67_AST_in = null;
				tmp67_AST = astFactory.create((AST)_t);
				tmp67_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp67_AST);
				ASTPair __currentAST49 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"top_element",1,3116);
				match(_t,TOP_ELEMENT);
				_t = _t.getFirstChild();
				i = (AST)_t;
				AST i_AST_in = null;
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				bShouldFire=aboutToEnter(bShouldFire,"top_element",2,3123);
				match(_t,NUM_INT);
				_t = _t.getNextSibling();
				currentAST = __currentAST49;
				_t = __t49;
				_t = _t.getNextSibling();
				top_element_AST = (AST)currentAST.root;
				top_element_AST=new QueryTopInfo(top_element_AST);
				currentAST.root = top_element_AST;
				currentAST.child = top_element_AST!=null &&top_element_AST.getFirstChild()!=null ?
					top_element_AST.getFirstChild() : top_element_AST;
				currentAST.advanceChildToEnd();
				top_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = top_element_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void select_elements(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST select_elements_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST select_elements_AST = null;
			
			try {      // for error handling
				AST __t51 = _t;
				AST tmp68_AST = null;
				AST tmp68_AST_in = null;
				tmp68_AST = astFactory.create((AST)_t);
				tmp68_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp68_AST);
				ASTPair __currentAST51 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"select_elements",1,3169);
				match(_t,COLUMN_ELEMENTS);
				_t = _t.getFirstChild();
				{
				int _cnt53=0;
				_loop53:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==COLUMN_ELEMENT)) {
						bShouldFire=aboutToEnter(bShouldFire,"select_elements",2,3178);
						column_element(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt53>=1 ) { break _loop53; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt53++;
				} while (true);
				}
				currentAST = __currentAST51;
				_t = __t51;
				_t = _t.getNextSibling();
				select_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = select_elements_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void group_by_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST group_by_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST group_by_clause_AST = null;
			
			try {      // for error handling
				AST __t80 = _t;
				AST tmp69_AST = null;
				AST tmp69_AST_in = null;
				tmp69_AST = astFactory.create((AST)_t);
				tmp69_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp69_AST);
				ASTPair __currentAST80 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"group_by_clause",1,3227);
				match(_t,GROUP_BY_CLAUSE);
				_t = _t.getFirstChild();
				{
				int _cnt82=0;
				_loop82:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						bShouldFire=aboutToEnter(bShouldFire,"group_by_clause",2,3236);
						expr(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt82>=1 ) { break _loop82; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt82++;
				} while (true);
				}
				currentAST = __currentAST80;
				_t = __t80;
				_t = _t.getNextSibling();
				group_by_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = group_by_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void having_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST having_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST having_clause_AST = null;
			
			try {      // for error handling
				AST __t84 = _t;
				AST tmp70_AST = null;
				AST tmp70_AST_in = null;
				tmp70_AST = astFactory.create((AST)_t);
				tmp70_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp70_AST);
				ASTPair __currentAST84 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"having_clause",1,3285);
				match(_t,HAVING_CLAUSE);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"having_clause",2,3288);
				search_condition2(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST84;
				_t = __t84;
				_t = _t.getNextSibling();
				having_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = having_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void order_by_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST order_by_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST order_by_clause_AST = null;
			
			try {      // for error handling
				AST __t86 = _t;
				AST tmp71_AST = null;
				AST tmp71_AST_in = null;
				tmp71_AST = astFactory.create((AST)_t);
				tmp71_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp71_AST);
				ASTPair __currentAST86 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"order_by_clause",1,3329);
				match(_t,ORDER_BY_CLAUSE);
				_t = _t.getFirstChild();
				{
				int _cnt88=0;
				_loop88:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ORDER_BY_ELEMENT)) {
						bShouldFire=aboutToEnter(bShouldFire,"order_by_clause",2,3338);
						order_by_element(_t);
						_t = _retTree;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt88>=1 ) { break _loop88; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt88++;
				} while (true);
				}
				currentAST = __currentAST86;
				_t = __t86;
				_t = _t.getNextSibling();
				order_by_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = order_by_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void limit_optional(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST limit_optional_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST limit_optional_AST = null;
			AST s = null;
			AST s_AST = null;
			AST e = null;
			AST e_AST = null;
			
			try {      // for error handling
				AST __t93 = _t;
				AST tmp72_AST = null;
				AST tmp72_AST_in = null;
				tmp72_AST = astFactory.create((AST)_t);
				tmp72_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp72_AST);
				ASTPair __currentAST93 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"limit_optional",1,3391);
				match(_t,LIMIT_OPTIONAL);
				_t = _t.getFirstChild();
				s = (AST)_t;
				AST s_AST_in = null;
				s_AST = astFactory.create(s);
				astFactory.addASTChild(currentAST, s_AST);
				bShouldFire=aboutToEnter(bShouldFire,"limit_optional",2,3398);
				match(_t,NUM_INT);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NUM_INT:
				{
					e = (AST)_t;
					AST e_AST_in = null;
					e_AST = astFactory.create(e);
					astFactory.addASTChild(currentAST, e_AST);
					bShouldFire=aboutToEnter(bShouldFire,"limit_optional",3,3410);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST93;
				_t = __t93;
				_t = _t.getNextSibling();
				limit_optional_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = limit_optional_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void rownum_optional(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST rownum_optional_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST rownum_optional_AST = null;
			AST i = null;
			AST i_AST = null;
			
			try {      // for error handling
				AST __t96 = _t;
				AST tmp73_AST = null;
				AST tmp73_AST_in = null;
				tmp73_AST = astFactory.create((AST)_t);
				tmp73_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp73_AST);
				ASTPair __currentAST96 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"rownum_optional",1,3464);
				match(_t,ROWNUM_OPTIONAL);
				_t = _t.getFirstChild();
				i = (AST)_t;
				AST i_AST_in = null;
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				bShouldFire=aboutToEnter(bShouldFire,"rownum_optional",2,3471);
				match(_t,NUM_INT);
				_t = _t.getNextSibling();
				currentAST = __currentAST96;
				_t = __t96;
				_t = _t.getNextSibling();
				rownum_optional_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = rownum_optional_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void union_clause(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST union_clause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST union_clause_AST = null;
			
			try {      // for error handling
				AST __t43 = _t;
				AST tmp74_AST = null;
				AST tmp74_AST_in = null;
				tmp74_AST = astFactory.create((AST)_t);
				tmp74_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp74_AST);
				ASTPair __currentAST43 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"union_clause",1,3511);
				match(_t,UNION);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ALL:
				{
					AST tmp75_AST = null;
					AST tmp75_AST_in = null;
					tmp75_AST = astFactory.create((AST)_t);
					tmp75_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp75_AST);
					bShouldFire=aboutToEnter(bShouldFire,"union_clause",2,3524);
					match(_t,ALL);
					_t = _t.getNextSibling();
					break;
				}
				case SELECT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				bShouldFire=aboutToEnter(bShouldFire,"union_clause",3,3539);
				select(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST43;
				_t = __t43;
				_t = _t.getNextSibling();
				union_clause_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = union_clause_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void column_element(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST column_element_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_element_AST = null;
			
			try {      // for error handling
				AST __t55 = _t;
				AST tmp76_AST = null;
				AST tmp76_AST_in = null;
				tmp76_AST = astFactory.create((AST)_t);
				tmp76_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp76_AST);
				ASTPair __currentAST55 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"column_element",1,3580);
				match(_t,COLUMN_ELEMENT);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"column_element",2,3583);
				expr(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ALIAS_NAME:
				{
					AST tmp77_AST = null;
					AST tmp77_AST_in = null;
					tmp77_AST = astFactory.create((AST)_t);
					tmp77_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp77_AST);
					bShouldFire=aboutToEnter(bShouldFire,"column_element",3,3597);
					match(_t,ALIAS_NAME);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST55;
				_t = __t55;
				_t = _t.getNextSibling();
				column_element_AST = (AST)currentAST.root;
				column_element_AST=new SqlQueryColumnItemAST(column_element_AST);
				currentAST.root = column_element_AST;
				currentAST.child = column_element_AST!=null &&column_element_AST.getFirstChild()!=null ?
					column_element_AST.getFirstChild() : column_element_AST;
				currentAST.advanceChildToEnd();
				column_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = column_element_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void table_element(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST table_element_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_element_AST = null;
			AST t_AST = null;
			AST t = null;
			AST s_AST = null;
			AST s = null;
			AST show_AST = null;
			AST show = null;
			AST j_AST = null;
			AST j = null;
			
			try {      // for error handling
				AST __t62 = _t;
				AST tmp78_AST = null;
				AST tmp78_AST_in = null;
				tmp78_AST = astFactory.create((AST)_t);
				tmp78_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp78_AST);
				ASTPair __currentAST62 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"table_element",1,3663);
				match(_t,TABLE_ELEMENT);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TABLE_NAME:
				{
					t = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"table_element",2,3672);
					table_name(_t);
					_t = _retTree;
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SELECT:
				{
					s = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"table_element",3,3682);
					select(_t);
					_t = _retTree;
					s_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SHOW_TABLES:
				case SHOW_TABLECOLUMNS:
				case SHOW_FUNCTIONS:
				case SHOW_FUNCTIONCOLUMNS:
				{
					show = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"table_element",4,3695);
					showStatement(_t);
					_t = _retTree;
					show_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ALIAS_NAME:
				{
					AST tmp79_AST = null;
					AST tmp79_AST_in = null;
					tmp79_AST = astFactory.create((AST)_t);
					tmp79_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp79_AST);
					bShouldFire=aboutToEnter(bShouldFire,"table_element",5,3718);
					match(_t,ALIAS_NAME);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				case JOIN_TABLE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case JOIN_TABLE:
				{
					j = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"table_element",6,3740);
					joined_table(_t);
					_t = _retTree;
					j_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST62;
				_t = __t62;
				_t = _t.getNextSibling();
				table_element_AST = (AST)currentAST.root;
				
						
						if(t_AST!=null)
							table_element_AST=new SqlTableItemAST(table_element_AST);
						else if(s!=null) 
							table_element_AST=new SqlSubQueryTableItemAST(table_element_AST);	
						else if(show!=null) 
							table_element_AST=new SqlShowItemAST(show_AST,table_element_AST);	
					
				currentAST.root = table_element_AST;
				currentAST.child = table_element_AST!=null &&table_element_AST.getFirstChild()!=null ?
					table_element_AST.getFirstChild() : table_element_AST;
				currentAST.advanceChildToEnd();
				table_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = table_element_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void joined_table(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST joined_table_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST joined_table_AST = null;
			
			try {      // for error handling
				AST __t67 = _t;
				AST tmp80_AST = null;
				AST tmp80_AST_in = null;
				tmp80_AST = astFactory.create((AST)_t);
				tmp80_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp80_AST);
				ASTPair __currentAST67 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"joined_table",1,3808);
				match(_t,JOIN_TABLE);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"joined_table",2,3811);
				join_type(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"joined_table",3,3815);
				table_element_in_joined_table(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SEARCH_CONDITION:
				{
					bShouldFire=aboutToEnter(bShouldFire,"joined_table",4,3824);
					search_condition(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				case JOIN_TABLE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case JOIN_TABLE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"joined_table",5,3846);
					joined_table(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST67;
				_t = __t67;
				_t = _t.getNextSibling();
				joined_table_AST = (AST)currentAST.root;
				joined_table_AST=new SqlJoinTableItemAST(joined_table_AST);
				currentAST.root = joined_table_AST;
				currentAST.child = joined_table_AST!=null &&joined_table_AST.getFirstChild()!=null ?
					joined_table_AST.getFirstChild() : joined_table_AST;
				currentAST.advanceChildToEnd();
				joined_table_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = joined_table_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void join_type(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST join_type_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST join_type_AST = null;
			
			try {      // for error handling
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case INNER_JOIN:
				{
					AST tmp81_AST = null;
					AST tmp81_AST_in = null;
					tmp81_AST = astFactory.create((AST)_t);
					tmp81_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp81_AST);
					bShouldFire=aboutToEnter(bShouldFire,"join_type",1,3906);
					match(_t,INNER_JOIN);
					_t = _t.getNextSibling();
					break;
				}
				case CROSS_JOIN:
				{
					AST tmp82_AST = null;
					AST tmp82_AST_in = null;
					tmp82_AST = astFactory.create((AST)_t);
					tmp82_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp82_AST);
					bShouldFire=aboutToEnter(bShouldFire,"join_type",2,3918);
					match(_t,CROSS_JOIN);
					_t = _t.getNextSibling();
					break;
				}
				case LEFT_JOIN:
				{
					AST tmp83_AST = null;
					AST tmp83_AST_in = null;
					tmp83_AST = astFactory.create((AST)_t);
					tmp83_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp83_AST);
					bShouldFire=aboutToEnter(bShouldFire,"join_type",3,3930);
					match(_t,LEFT_JOIN);
					_t = _t.getNextSibling();
					break;
				}
				case RIGHT_JOIN:
				{
					AST tmp84_AST = null;
					AST tmp84_AST_in = null;
					tmp84_AST = astFactory.create((AST)_t);
					tmp84_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp84_AST);
					bShouldFire=aboutToEnter(bShouldFire,"join_type",4,3942);
					match(_t,RIGHT_JOIN);
					_t = _t.getNextSibling();
					break;
				}
				case DEFULT_JOIN:
				{
					AST tmp85_AST = null;
					AST tmp85_AST_in = null;
					tmp85_AST = astFactory.create((AST)_t);
					tmp85_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp85_AST);
					bShouldFire=aboutToEnter(bShouldFire,"join_type",5,3954);
					match(_t,DEFULT_JOIN);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				join_type_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = join_type_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void table_element_in_joined_table(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST table_element_in_joined_table_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_element_in_joined_table_AST = null;
			AST t_AST = null;
			AST t = null;
			AST s_AST = null;
			AST s = null;
			
			try {      // for error handling
				AST __t71 = _t;
				AST tmp86_AST = null;
				AST tmp86_AST_in = null;
				tmp86_AST = astFactory.create((AST)_t);
				tmp86_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp86_AST);
				ASTPair __currentAST71 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"table_element_in_joined_table",1,4003);
				match(_t,TABLE_ELEMENT);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TABLE_NAME:
				{
					t = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"table_element_in_joined_table",2,4012);
					table_name(_t);
					_t = _retTree;
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SELECT:
				{
					s = _t==ASTNULL ? null : (AST)_t;
					bShouldFire=aboutToEnter(bShouldFire,"table_element_in_joined_table",3,4022);
					select(_t);
					_t = _retTree;
					s_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ALIAS_NAME:
				{
					AST tmp87_AST = null;
					AST tmp87_AST_in = null;
					tmp87_AST = astFactory.create((AST)_t);
					tmp87_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp87_AST);
					bShouldFire=aboutToEnter(bShouldFire,"table_element_in_joined_table",4,4045);
					match(_t,ALIAS_NAME);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST71;
				_t = __t71;
				_t = _t.getNextSibling();
				table_element_in_joined_table_AST = (AST)currentAST.root;
				
						if(t_AST!=null)
							table_element_in_joined_table_AST=new SqlTableItemAST(table_element_in_joined_table_AST);
						else 
							table_element_in_joined_table_AST=new SqlSubQueryTableItemAST(table_element_in_joined_table_AST);
					
				currentAST.root = table_element_in_joined_table_AST;
				currentAST.child = table_element_in_joined_table_AST!=null &&table_element_in_joined_table_AST.getFirstChild()!=null ?
					table_element_in_joined_table_AST.getFirstChild() : table_element_in_joined_table_AST;
				currentAST.advanceChildToEnd();
				table_element_in_joined_table_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = table_element_in_joined_table_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void search_condition(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST search_condition_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST search_condition_AST = null;
			
			try {      // for error handling
				AST __t98 = _t;
				AST tmp88_AST = null;
				AST tmp88_AST_in = null;
				tmp88_AST = astFactory.create((AST)_t);
				tmp88_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp88_AST);
				ASTPair __currentAST98 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"search_condition",1,4108);
				match(_t,SEARCH_CONDITION);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"search_condition",2,4111);
				search_condition2(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST98;
				_t = __t98;
				_t = _t.getNextSibling();
				search_condition_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = search_condition_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void search_condition2(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST search_condition2_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST search_condition2_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"search_condition2",1,4143);
				expr(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				search_condition2_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = search_condition2_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void order_by_element(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST order_by_element_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST order_by_element_AST = null;
			
			try {      // for error handling
				AST __t90 = _t;
				AST tmp89_AST = null;
				AST tmp89_AST_in = null;
				tmp89_AST = astFactory.create((AST)_t);
				tmp89_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp89_AST);
				ASTPair __currentAST90 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"order_by_element",1,4181);
				match(_t,ORDER_BY_ELEMENT);
				_t = _t.getFirstChild();
				bShouldFire=aboutToEnter(bShouldFire,"order_by_element",2,4184);
				expr(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ASC:
				{
					AST tmp90_AST = null;
					AST tmp90_AST_in = null;
					tmp90_AST = astFactory.create((AST)_t);
					tmp90_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp90_AST);
					bShouldFire=aboutToEnter(bShouldFire,"order_by_element",3,4198);
					match(_t,ASC);
					_t = _t.getNextSibling();
					break;
				}
				case DESC:
				{
					AST tmp91_AST = null;
					AST tmp91_AST_in = null;
					tmp91_AST = astFactory.create((AST)_t);
					tmp91_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp91_AST);
					bShouldFire=aboutToEnter(bShouldFire,"order_by_element",4,4210);
					match(_t,DESC);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST90;
				_t = __t90;
				_t = _t.getNextSibling();
				order_by_element_AST = (AST)currentAST.root;
				order_by_element_AST=new SqlOrderByItemAST(order_by_element_AST);
				currentAST.root = order_by_element_AST;
				currentAST.child = order_by_element_AST!=null &&order_by_element_AST.getFirstChild()!=null ?
					order_by_element_AST.getFirstChild() : order_by_element_AST;
				currentAST.advanceChildToEnd();
				order_by_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = order_by_element_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void function_name(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST function_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST function_name_AST = null;
			
			try {      // for error handling
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case AVG:
				{
					AST tmp92_AST = null;
					AST tmp92_AST_in = null;
					tmp92_AST = astFactory.create((AST)_t);
					tmp92_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp92_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",1,4268);
					match(_t,AVG);
					_t = _t.getNextSibling();
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case COUNT:
				{
					AST tmp93_AST = null;
					AST tmp93_AST_in = null;
					tmp93_AST = astFactory.create((AST)_t);
					tmp93_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp93_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",2,4281);
					match(_t,COUNT);
					_t = _t.getNextSibling();
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case MAX:
				{
					AST tmp94_AST = null;
					AST tmp94_AST_in = null;
					tmp94_AST = astFactory.create((AST)_t);
					tmp94_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp94_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",3,4294);
					match(_t,MAX);
					_t = _t.getNextSibling();
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case MIN:
				{
					AST tmp95_AST = null;
					AST tmp95_AST_in = null;
					tmp95_AST = astFactory.create((AST)_t);
					tmp95_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp95_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",4,4307);
					match(_t,MIN);
					_t = _t.getNextSibling();
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case SUM:
				{
					AST tmp96_AST = null;
					AST tmp96_AST_in = null;
					tmp96_AST = astFactory.create((AST)_t);
					tmp96_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp96_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",5,4320);
					match(_t,SUM);
					_t = _t.getNextSibling();
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case ID:
				{
					AST tmp97_AST = null;
					AST tmp97_AST_in = null;
					tmp97_AST = astFactory.create((AST)_t);
					tmp97_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp97_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",6,4333);
					match(_t,ID);
					_t = _t.getNextSibling();
					function_name_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = function_name_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void function_parameters(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST function_parameters_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST function_parameters_AST = null;
			AST e_AST = null;
			AST e = null;
			
			try {      // for error handling
				AST __t136 = _t;
				AST tmp98_AST = null;
				AST tmp98_AST_in = null;
				tmp98_AST = astFactory.create((AST)_t);
				tmp98_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp98_AST);
				ASTPair __currentAST136 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"function_parameters",1,4379);
				match(_t,FUNCTION_PARAMETERS);
				_t = _t.getFirstChild();
				{
				_loop138:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						e = _t==ASTNULL ? null : (AST)_t;
						bShouldFire=aboutToEnter(bShouldFire,"function_parameters",2,4388);
						expr(_t);
						_t = _retTree;
						e_AST = (AST)returnAST;
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop138;
					}
					
				} while (true);
				}
				currentAST = __currentAST136;
				_t = __t136;
				_t = _t.getNextSibling();
				function_parameters_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = function_parameters_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void index_name(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST index_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST index_name_AST = null;
			
			try {      // for error handling
				AST tmp99_AST = null;
				AST tmp99_AST_in = null;
				tmp99_AST = astFactory.create((AST)_t);
				tmp99_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp99_AST);
				bShouldFire=aboutToEnter(bShouldFire,"index_name",1,4433);
				match(_t,INDEX_NAME);
				_t = _t.getNextSibling();
				index_name_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = index_name_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void datatype(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST datatype_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST datatype_AST = null;
			
			try {      // for error handling
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TYPE_INT:
				{
					AST tmp100_AST = null;
					AST tmp100_AST_in = null;
					tmp100_AST = astFactory.create((AST)_t);
					tmp100_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp100_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",1,4470);
					match(_t,TYPE_INT);
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlIntTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_VARCHAR:
				{
					AST __t141 = _t;
					AST tmp101_AST = null;
					AST tmp101_AST_in = null;
					tmp101_AST = astFactory.create((AST)_t);
					tmp101_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp101_AST);
					ASTPair __currentAST141 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"datatype",2,4493);
					match(_t,TYPE_VARCHAR);
					_t = _t.getFirstChild();
					AST tmp102_AST = null;
					AST tmp102_AST_in = null;
					tmp102_AST = astFactory.create((AST)_t);
					tmp102_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp102_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",3,4501);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					currentAST = __currentAST141;
					_t = __t141;
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlVarcharTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_DECIMAL:
				{
					AST __t142 = _t;
					AST tmp103_AST = null;
					AST tmp103_AST_in = null;
					tmp103_AST = astFactory.create((AST)_t);
					tmp103_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp103_AST);
					ASTPair __currentAST142 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"datatype",4,4527);
					match(_t,TYPE_DECIMAL);
					_t = _t.getFirstChild();
					AST tmp104_AST = null;
					AST tmp104_AST_in = null;
					tmp104_AST = astFactory.create((AST)_t);
					tmp104_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp104_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",5,4535);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case NUM_INT:
					{
						AST tmp105_AST = null;
						AST tmp105_AST_in = null;
						tmp105_AST = astFactory.create((AST)_t);
						tmp105_AST_in = (AST)_t;
						astFactory.addASTChild(currentAST, tmp105_AST);
						bShouldFire=aboutToEnter(bShouldFire,"datatype",6,4548);
						match(_t,NUM_INT);
						_t = _t.getNextSibling();
						break;
					}
					case 3:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					currentAST = __currentAST142;
					_t = __t142;
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlDecimalTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_DATETIME:
				{
					AST tmp106_AST = null;
					AST tmp106_AST_in = null;
					tmp106_AST = astFactory.create((AST)_t);
					tmp106_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp106_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",7,4582);
					match(_t,TYPE_DATETIME);
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlDateTimeTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_BLOB:
				{
					AST tmp107_AST = null;
					AST tmp107_AST_in = null;
					tmp107_AST = astFactory.create((AST)_t);
					tmp107_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp107_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",8,4601);
					match(_t,TYPE_BLOB);
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlBlobTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_CLOB:
				{
					AST tmp108_AST = null;
					AST tmp108_AST_in = null;
					tmp108_AST = astFactory.create((AST)_t);
					tmp108_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp108_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",9,4620);
					match(_t,TYPE_CLOB);
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlClobTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_CHAR:
				{
					AST __t144 = _t;
					AST tmp109_AST = null;
					AST tmp109_AST_in = null;
					tmp109_AST = astFactory.create((AST)_t);
					tmp109_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp109_AST);
					ASTPair __currentAST144 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"datatype",10,4643);
					match(_t,TYPE_CHAR);
					_t = _t.getFirstChild();
					AST tmp110_AST = null;
					AST tmp110_AST_in = null;
					tmp110_AST = astFactory.create((AST)_t);
					tmp110_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp110_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",11,4651);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					currentAST = __currentAST144;
					_t = __t144;
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlCharTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_NCHAR:
				{
					AST __t145 = _t;
					AST tmp111_AST = null;
					AST tmp111_AST_in = null;
					tmp111_AST = astFactory.create((AST)_t);
					tmp111_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp111_AST);
					ASTPair __currentAST145 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"datatype",12,4677);
					match(_t,TYPE_NCHAR);
					_t = _t.getFirstChild();
					AST tmp112_AST = null;
					AST tmp112_AST_in = null;
					tmp112_AST = astFactory.create((AST)_t);
					tmp112_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp112_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",13,4685);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					currentAST = __currentAST145;
					_t = __t145;
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlNCharTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_NVARCHAR:
				{
					AST __t146 = _t;
					AST tmp113_AST = null;
					AST tmp113_AST_in = null;
					tmp113_AST = astFactory.create((AST)_t);
					tmp113_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp113_AST);
					ASTPair __currentAST146 = currentAST.copy();
					currentAST.root = currentAST.child;
					currentAST.child = null;
					bShouldFire=aboutToEnter(bShouldFire,"datatype",14,4711);
					match(_t,TYPE_NVARCHAR);
					_t = _t.getFirstChild();
					AST tmp114_AST = null;
					AST tmp114_AST_in = null;
					tmp114_AST = astFactory.create((AST)_t);
					tmp114_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp114_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",15,4719);
					match(_t,NUM_INT);
					_t = _t.getNextSibling();
					currentAST = __currentAST146;
					_t = __t146;
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlNVarcharTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				case TYPE_NCLOB:
				{
					AST tmp115_AST = null;
					AST tmp115_AST_in = null;
					tmp115_AST = astFactory.create((AST)_t);
					tmp115_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp115_AST);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",16,4741);
					match(_t,TYPE_NCLOB);
					_t = _t.getNextSibling();
					datatype_AST = (AST)currentAST.root;
					datatype_AST=new SqlNClobTypeDefExprAST(datatype_AST);
					currentAST.root = datatype_AST;
					currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
						datatype_AST.getFirstChild() : datatype_AST;
					currentAST.advanceChildToEnd();
					datatype_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = datatype_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void tableitemdef(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST tableitemdef_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST tableitemdef_AST = null;
			
			try {      // for error handling
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case COLUMN_DEF:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",1,4786);
					column_def(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					tableitemdef_AST = (AST)currentAST.root;
					break;
				}
				case SINGLE_PRIMARY_KEY:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",2,4795);
					single_primary_key(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					tableitemdef_AST = (AST)currentAST.root;
					break;
				}
				case COMBO_PRIMARY_KEY:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",3,4804);
					combo_primary_key(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					tableitemdef_AST = (AST)currentAST.root;
					break;
				}
				case FOREIGN_KEY:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",4,4813);
					foreign_key(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					tableitemdef_AST = (AST)currentAST.root;
					break;
				}
				case UNIQUE_DEF:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",5,4822);
					unique_def(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					tableitemdef_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = tableitemdef_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void column_def(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST column_def_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_def_AST = null;
			
			try {      // for error handling
				AST __t153 = _t;
				AST tmp116_AST = null;
				AST tmp116_AST_in = null;
				tmp116_AST = astFactory.create((AST)_t);
				tmp116_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp116_AST);
				ASTPair __currentAST153 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"column_def",1,4867);
				match(_t,COLUMN_DEF);
				_t = _t.getFirstChild();
				AST tmp117_AST = null;
				AST tmp117_AST_in = null;
				tmp117_AST = astFactory.create((AST)_t);
				tmp117_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp117_AST);
				bShouldFire=aboutToEnter(bShouldFire,"column_def",2,4875);
				match(_t,COLUMN_NAME);
				_t = _t.getNextSibling();
				bShouldFire=aboutToEnter(bShouldFire,"column_def",3,4878);
				datatype(_t);
				_t = _retTree;
				astFactory.addASTChild(currentAST, returnAST);
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NOTNULL:
				{
					AST tmp118_AST = null;
					AST tmp118_AST_in = null;
					tmp118_AST = astFactory.create((AST)_t);
					tmp118_AST_in = (AST)_t;
					astFactory.addASTChild(currentAST, tmp118_AST);
					bShouldFire=aboutToEnter(bShouldFire,"column_def",4,4892);
					match(_t,NOTNULL);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case BOOLEAN:
				case DEFAULT:
				case SELECT:
				case ALL:
				case AND:
				case ANY:
				case EXISTS:
				case IS:
				case NOT:
				case NULL:
				case OR:
				case SOME:
				case IN_LIST:
				case ALL_COLUMNS:
				case TABLE_NAME:
				case COLUMN_NAME:
				case IN:
				case NOT_IN:
				case BETWEEN:
				case NOT_BETWEEN:
				case LIKE:
				case NOT_LIKE:
				case IS_NOT:
				case FUNCTION:
				case EQUAL:
				case DOT:
				case STAR:
				case LESS:
				case GREATER:
				case LE_EQ:
				case GR_EQ:
				case NOT_EQ:
				case PLUS:
				case SUB:
				case Q_MARK:
				case DIV:
				case MOD:
				case CONCAT:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case BOOLEAN:
				case DEFAULT:
				case SELECT:
				case ALL:
				case AND:
				case ANY:
				case EXISTS:
				case IS:
				case NOT:
				case NULL:
				case OR:
				case SOME:
				case IN_LIST:
				case ALL_COLUMNS:
				case TABLE_NAME:
				case COLUMN_NAME:
				case IN:
				case NOT_IN:
				case BETWEEN:
				case NOT_BETWEEN:
				case LIKE:
				case NOT_LIKE:
				case IS_NOT:
				case FUNCTION:
				case EQUAL:
				case DOT:
				case STAR:
				case LESS:
				case GREATER:
				case LE_EQ:
				case GR_EQ:
				case NOT_EQ:
				case PLUS:
				case SUB:
				case Q_MARK:
				case DIV:
				case MOD:
				case CONCAT:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"column_def",5,5001);
					expr(_t);
					_t = _retTree;
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				currentAST = __currentAST153;
				_t = __t153;
				_t = _t.getNextSibling();
				column_def_AST = (AST)currentAST.root;
				column_def_AST=new SqlColumnDefItemAST(column_def_AST);
				currentAST.root = column_def_AST;
				currentAST.child = column_def_AST!=null &&column_def_AST.getFirstChild()!=null ?
					column_def_AST.getFirstChild() : column_def_AST;
				currentAST.advanceChildToEnd();
				column_def_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = column_def_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void single_primary_key(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST single_primary_key_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST single_primary_key_AST = null;
			
			try {      // for error handling
				AST __t157 = _t;
				AST tmp119_AST = null;
				AST tmp119_AST_in = null;
				tmp119_AST = astFactory.create((AST)_t);
				tmp119_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp119_AST);
				ASTPair __currentAST157 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"single_primary_key",1,5060);
				match(_t,SINGLE_PRIMARY_KEY);
				_t = _t.getFirstChild();
				AST tmp120_AST = null;
				AST tmp120_AST_in = null;
				tmp120_AST = astFactory.create((AST)_t);
				tmp120_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp120_AST);
				bShouldFire=aboutToEnter(bShouldFire,"single_primary_key",2,5068);
				match(_t,COLUMN_NAME);
				_t = _t.getNextSibling();
				currentAST = __currentAST157;
				_t = __t157;
				_t = _t.getNextSibling();
				single_primary_key_AST = (AST)currentAST.root;
				single_primary_key_AST=new SqlTableSinglePrimaryKeyItemAST(single_primary_key_AST);
				currentAST.root = single_primary_key_AST;
				currentAST.child = single_primary_key_AST!=null &&single_primary_key_AST.getFirstChild()!=null ?
					single_primary_key_AST.getFirstChild() : single_primary_key_AST;
				currentAST.advanceChildToEnd();
				single_primary_key_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = single_primary_key_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void combo_primary_key(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST combo_primary_key_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST combo_primary_key_AST = null;
			AST ce_AST = null;
			AST ce = null;
			
			try {      // for error handling
				AST __t159 = _t;
				AST tmp121_AST = null;
				AST tmp121_AST_in = null;
				tmp121_AST = astFactory.create((AST)_t);
				tmp121_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp121_AST);
				ASTPair __currentAST159 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"combo_primary_key",1,5116);
				match(_t,COMBO_PRIMARY_KEY);
				_t = _t.getFirstChild();
				ce = _t==ASTNULL ? null : (AST)_t;
				bShouldFire=aboutToEnter(bShouldFire,"combo_primary_key",2,5120);
				column_elements(_t);
				_t = _retTree;
				ce_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST159;
				_t = __t159;
				_t = _t.getNextSibling();
				combo_primary_key_AST = (AST)currentAST.root;
				combo_primary_key_AST=new SqlTableComboPrimaryKeyItemAST(ce_AST);
				currentAST.root = combo_primary_key_AST;
				currentAST.child = combo_primary_key_AST!=null &&combo_primary_key_AST.getFirstChild()!=null ?
					combo_primary_key_AST.getFirstChild() : combo_primary_key_AST;
				currentAST.advanceChildToEnd();
				combo_primary_key_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = combo_primary_key_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void foreign_key(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST foreign_key_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST foreign_key_AST = null;
			
			try {      // for error handling
				AST __t161 = _t;
				AST tmp122_AST = null;
				AST tmp122_AST_in = null;
				tmp122_AST = astFactory.create((AST)_t);
				tmp122_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp122_AST);
				ASTPair __currentAST161 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"foreign_key",1,5168);
				match(_t,FOREIGN_KEY);
				_t = _t.getFirstChild();
				AST tmp123_AST = null;
				AST tmp123_AST_in = null;
				tmp123_AST = astFactory.create((AST)_t);
				tmp123_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp123_AST);
				bShouldFire=aboutToEnter(bShouldFire,"foreign_key",2,5176);
				match(_t,COLUMN_NAME);
				_t = _t.getNextSibling();
				AST tmp124_AST = null;
				AST tmp124_AST_in = null;
				tmp124_AST = astFactory.create((AST)_t);
				tmp124_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp124_AST);
				bShouldFire=aboutToEnter(bShouldFire,"foreign_key",3,5184);
				match(_t,TABLE_NAME);
				_t = _t.getNextSibling();
				AST tmp125_AST = null;
				AST tmp125_AST_in = null;
				tmp125_AST = astFactory.create((AST)_t);
				tmp125_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp125_AST);
				bShouldFire=aboutToEnter(bShouldFire,"foreign_key",4,5192);
				match(_t,COLUMN_NAME);
				_t = _t.getNextSibling();
				currentAST = __currentAST161;
				_t = __t161;
				_t = _t.getNextSibling();
				foreign_key_AST = (AST)currentAST.root;
				foreign_key_AST=new SqlTableForeignKeyItemAST(foreign_key_AST);
				currentAST.root = foreign_key_AST;
				currentAST.child = foreign_key_AST!=null &&foreign_key_AST.getFirstChild()!=null ?
					foreign_key_AST.getFirstChild() : foreign_key_AST;
				currentAST.advanceChildToEnd();
				foreign_key_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = foreign_key_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	public final void unique_def(AST _t) throws RecognitionException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			AST unique_def_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST unique_def_AST = null;
			AST ce_AST = null;
			AST ce = null;
			
			try {      // for error handling
				AST __t163 = _t;
				AST tmp126_AST = null;
				AST tmp126_AST_in = null;
				tmp126_AST = astFactory.create((AST)_t);
				tmp126_AST_in = (AST)_t;
				astFactory.addASTChild(currentAST, tmp126_AST);
				ASTPair __currentAST163 = currentAST.copy();
				currentAST.root = currentAST.child;
				currentAST.child = null;
				bShouldFire=aboutToEnter(bShouldFire,"unique_def",1,5240);
				match(_t,UNIQUE_DEF);
				_t = _t.getFirstChild();
				ce = _t==ASTNULL ? null : (AST)_t;
				bShouldFire=aboutToEnter(bShouldFire,"unique_def",2,5244);
				column_elements(_t);
				_t = _retTree;
				ce_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				currentAST = __currentAST163;
				_t = __t163;
				_t = _t.getNextSibling();
				unique_def_AST = (AST)currentAST.root;
				unique_def_AST=new SqlTableUniqueItemAST(ce_AST);
				currentAST.root = unique_def_AST;
				currentAST.child = unique_def_AST!=null &&unique_def_AST.getFirstChild()!=null ?
					unique_def_AST.getFirstChild() : unique_def_AST;
				currentAST.advanceChildToEnd();
				unique_def_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			}
			returnAST = unique_def_AST;
			_retTree = _t;
		} finally { // debugging
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"NUM_FLOAT",
		"NUM_INT",
		"NUM_REAL",
		"BOOLEAN",
		"CONSTANT",
		"STATEMENTS",
		"\"create\"",
		"\"drop\"",
		"\"add\"",
		"\"alter\"",
		"\"table\"",
		"\"index\"",
		"\"default\"",
		"\"primary\"",
		"\"foreign\"",
		"\"key\"",
		"\"references\"",
		"\"unique\"",
		"\"column\"",
		"\"show\"",
		"NOTNULL",
		"INDEX_NAME",
		"TYPE_INT",
		"TYPE_VARCHAR",
		"TYPE_NVARCHAR",
		"TYPE_CHAR",
		"TYPE_NCHAR",
		"TYPE_DECIMAL",
		"TYPE_DATETIME",
		"TYPE_BLOB",
		"TYPE_CLOB",
		"TYPE_NCLOB",
		"COLUMN_DEF",
		"SINGLE_PRIMARY_KEY",
		"COMBO_PRIMARY_KEY",
		"FOREIGN_KEY",
		"UNIQUE_DEF",
		"CREATE_INDEX",
		"CREATE_TABLE",
		"DROP_TABLE",
		"DROP_INDEX",
		"SHOW_TABLES",
		"SHOW_TABLECOLUMNS",
		"SHOW_FUNCTIONS",
		"SHOW_FUNCTIONCOLUMNS",
		"ALTERTABLE_ADD_COLUMNS",
		"\"select\"",
		"\"delete\"",
		"\"insert\"",
		"\"update\"",
		"\"as\"",
		"\"all\"",
		"\"and\"",
		"\"asc\"",
		"\"avg\"",
		"\"any\"",
		"\"by\"",
		"\"cross\"",
		"\"count\"",
		"\"distinct\"",
		"\"desc\"",
		"\"exists\"",
		"\"from\"",
		"\"false\"",
		"\"group\"",
		"\"having\"",
		"\"is\"",
		"\"into\"",
		"\"inner\"",
		"\"join\"",
		"\"max\"",
		"\"min\"",
		"\"not\"",
		"\"null\"",
		"\"on\"",
		"\"outer\"",
		"\"or\"",
		"\"order\"",
		"ORDER_BY_ELEMENT",
		"ORDER_TYPE",
		"\"right\"",
		"\"left\"",
		"\"limit\"",
		"\"rownum\"",
		"\"set\"",
		"\"some\"",
		"\"sum\"",
		"\"true\"",
		"\"top\"",
		"\"union\"",
		"\"values\"",
		"\"where\"",
		"IN_LIST",
		"ALIAS_NAME",
		"AGGREGATE_TYPE",
		"ALL_COLUMNS",
		"TABLE_ELEMENT",
		"TABLE_NAME",
		"COLUMN_ELEMENTS",
		"COLUMN_ELEMENT",
		"COLUMN_NAME",
		"VALUE_ELEMENTS",
		"TOP_ELEMENT",
		"SET_CLAUSE",
		"WHERE_CLAUSE",
		"FROM_CLAUSE",
		"GROUP_BY_CLAUSE",
		"HAVING_CLAUSE",
		"ORDER_BY_CLAUSE",
		"LIMIT_OPTIONAL",
		"ROWNUM_OPTIONAL",
		"SEARCH_CONDITION",
		"\"in\"",
		"NOT_IN",
		"\"between\"",
		"NOT_BETWEEN",
		"\"like\"",
		"NOT_LIKE",
		"IS_NOT",
		"UNARY_MINUS",
		"UNARY_PLUS",
		"FUNCTION",
		"FUNCTION_PARAMETERS",
		"JOIN_TABLE",
		"DEFULT_JOIN",
		"INNER_JOIN",
		"CROSS_JOIN",
		"LEFT_JOIN",
		"RIGHT_JOIN",
		"SEMI",
		"LB",
		"COMMA",
		"RB",
		"EQUAL",
		"DOT",
		"ID",
		"STAR",
		"LESS",
		"GREATER",
		"LE_EQ",
		"GR_EQ",
		"NOT_EQ",
		"PLUS",
		"SUB",
		"Q_MARK",
		"DIV",
		"MOD",
		"CONCAT",
		"CONST_STRING",
		"N_CONST_STRING",
		"NUM_HEX",
		"DATE",
		"\"int\"",
		"\"integer\"",
		"\"tinyint\"",
		"\"smallint\"",
		"\"bit\"",
		"\"boolean\"",
		"\"varchar\"",
		"\"decimal\"",
		"\"numeric\"",
		"\"real\"",
		"\"float\"",
		"\"double\"",
		"\"datetime\"",
		"\"date\"",
		"\"timestamp\"",
		"\"time\"",
		"\"blob\"",
		"\"tinyblob\"",
		"\"longblob\"",
		"\"binary\"",
		"\"varbinary\"",
		"\"longvarbinary\"",
		"\"image\"",
		"\"clob\"",
		"\"tinytext\"",
		"\"longtext\"",
		"\"text\"",
		"\"longvarchar\"",
		"\"char\"",
		"\"nchar\"",
		"\"nvarchar\"",
		"\"nclob\"",
		"\"tables\"",
		"\"tablecolumns\"",
		"\"functions\"",
		"\"functioncolumns\"",
		"NUMBER",
		"QUOTE",
		"BLANK",
		"WS",
		"M_COMM",
		"S_COMM"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 685673043267223792L, 2877801437528666178L, 268432896L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	}
	
