// $ANTLR : "sqlparser.g" -> "SQLParser.java"$

	package com.cownew.cownewsql.ast.grammar;
	import com.cownew.cownewsql.ast.node.*;
	import com.cownew.cownewsql.ast.node.enumdef.*;
	import com.cownew.cownewsql.ast.node.expr.*;
	import com.cownew.cownewsql.ast.node.item.*;
	import com.cownew.cownewsql.ast.node.stmt.*;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.antlrStudio.ASLLKDebuggingParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

/**
 * CowNew SQLParser Grammar
 * 
 * @author King Chou (kingchou.pro@gmail.com)
 */
public class SQLParser extends antlr.antlrStudio.ASLLKDebuggingParser       implements SQLParserTokenTypes
 {

protected SQLParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public SQLParser(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected SQLParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public SQLParser(TokenStream lexer) {
  this(lexer,3);
}

public SQLParser(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void startRule() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("startRule");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST startRule_AST = null;
			
			try {      // for error handling
				{
				_loop179:
				do {
					if ((_tokenSet_0.member(LA(1)))) {
						bShouldFire=aboutToEnter(bShouldFire,"startRule",1,84);
						statement();
						astFactory.addASTChild(currentAST, returnAST);
						{
						switch ( LA(1)) {
						case SEMI:
						{
							bShouldFire=aboutToEnter(bShouldFire,"startRule",2,91);
							match(SEMI);
							break;
						}
						case EOF:
						case CREATE:
						case DROP:
						case ALTER:
						case SHOW:
						case SELECT:
						case DELETE:
						case INSERT:
						case UPDATE:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					else {
						break _loop179;
					}
					
				} while (true);
				}
				if ( inputState.guessing==0 ) {
					startRule_AST = (AST)currentAST.root;
					startRule_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STATEMENTS,"STATEMENTS")).add(startRule_AST));
					currentAST.root = startRule_AST;
					currentAST.child = startRule_AST!=null &&startRule_AST.getFirstChild()!=null ?
						startRule_AST.getFirstChild() : startRule_AST;
					currentAST.advanceChildToEnd();
				}
				startRule_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_1);
				} else {
				  throw ex;
				}
			}
			returnAST = startRule_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("statement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST statement_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case SELECT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"statement",1,160);
					selectStatement();
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case INSERT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"statement",2,168);
					insertStatement();
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case UPDATE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"statement",3,176);
					updateStatement();
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case DELETE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"statement",4,184);
					deleteStatement();
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case SHOW:
				{
					bShouldFire=aboutToEnter(bShouldFire,"statement",5,192);
					showStatement();
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				case ALTER:
				{
					bShouldFire=aboutToEnter(bShouldFire,"statement",6,200);
					alterTableStatement();
					astFactory.addASTChild(currentAST, returnAST);
					statement_AST = (AST)currentAST.root;
					break;
				}
				default:
					if ((LA(1)==CREATE) && (LA(2)==TABLE)) {
						bShouldFire=aboutToEnter(bShouldFire,"statement",7,208);
						createTableStatement();
						astFactory.addASTChild(currentAST, returnAST);
						statement_AST = (AST)currentAST.root;
					}
					else if ((LA(1)==CREATE) && (LA(2)==INDEX)) {
						bShouldFire=aboutToEnter(bShouldFire,"statement",8,214);
						createIndexStatement();
						astFactory.addASTChild(currentAST, returnAST);
						statement_AST = (AST)currentAST.root;
					}
					else if ((LA(1)==DROP) && (LA(2)==TABLE)) {
						bShouldFire=aboutToEnter(bShouldFire,"statement",9,220);
						dropTableStatement();
						astFactory.addASTChild(currentAST, returnAST);
						statement_AST = (AST)currentAST.root;
					}
					else if ((LA(1)==DROP) && (LA(2)==INDEX)) {
						bShouldFire=aboutToEnter(bShouldFire,"statement",10,226);
						dropIndexStatement();
						astFactory.addASTChild(currentAST, returnAST);
						statement_AST = (AST)currentAST.root;
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = statement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void selectStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("selectStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST selectStatement_AST = null;
			AST sl_AST = null;
			Token  u1 = null;
			AST u1_AST = null;
			Token  a1 = null;
			AST a1_AST = null;
			AST sr_AST = null;
			Token  u2 = null;
			AST u2_AST = null;
			Token  a2 = null;
			AST a2_AST = null;
			AST sr2_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"selectStatement",1,274);
				selectStatement_without_union();
				sl_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					selectStatement_AST = (AST)currentAST.root;
					selectStatement_AST=sl_AST;
					currentAST.root = selectStatement_AST;
					currentAST.child = selectStatement_AST!=null &&selectStatement_AST.getFirstChild()!=null ?
						selectStatement_AST.getFirstChild() : selectStatement_AST;
					currentAST.advanceChildToEnd();
				}
				{
				switch ( LA(1)) {
				case UNION:
				{
					{
					u1 = LT(1);
					u1_AST = astFactory.create(u1);
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement",2,292);
					match(UNION);
					{
					switch ( LA(1)) {
					case ALL:
					{
						a1 = LT(1);
						a1_AST = astFactory.create(a1);
						bShouldFire=aboutToEnter(bShouldFire,"selectStatement",3,300);
						match(ALL);
						break;
					}
					case SELECT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement",4,314);
					selectStatement_without_union();
					sr_AST = (AST)returnAST;
					}
					if ( inputState.guessing==0 ) {
						selectStatement_AST = (AST)currentAST.root;
						
									u1_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(UNION,"UNION")).add(a1_AST).add(sr_AST));
									selectStatement_AST.addChild(u1_AST);
									
								
					}
					{
					_loop215:
					do {
						if ((LA(1)==UNION)) {
							u2 = LT(1);
							u2_AST = astFactory.create(u2);
							bShouldFire=aboutToEnter(bShouldFire,"selectStatement",5,332);
							match(UNION);
							{
							switch ( LA(1)) {
							case ALL:
							{
								a2 = LT(1);
								a2_AST = astFactory.create(a2);
								bShouldFire=aboutToEnter(bShouldFire,"selectStatement",6,340);
								match(ALL);
								break;
							}
							case SELECT:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							bShouldFire=aboutToEnter(bShouldFire,"selectStatement",7,354);
							selectStatement_without_union();
							sr2_AST = (AST)returnAST;
							if ( inputState.guessing==0 ) {
								
											u2_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(UNION,"UNION")).add(a2_AST).add(sr2_AST));
											sr_AST.addChild(u2_AST);
											sr_AST=sr2_AST;
										
							}
						}
						else {
							break _loop215;
						}
						
					} while (true);
					}
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_3);
				} else {
				  throw ex;
				}
			}
			returnAST = selectStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void insertStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("insertStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST insertStatement_AST = null;
			Token  i = null;
			AST i_AST = null;
			AST n_AST = null;
			AST c_AST = null;
			AST v_AST = null;
			AST s_AST = null;
			
			try {      // for error handling
				i = LT(1);
				i_AST = astFactory.create(i);
				bShouldFire=aboutToEnter(bShouldFire,"insertStatement",1,429);
				match(INSERT);
				bShouldFire=aboutToEnter(bShouldFire,"insertStatement",2,431);
				match(INTO);
				bShouldFire=aboutToEnter(bShouldFire,"insertStatement",3,433);
				table_name();
				n_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case LB:
				{
					bShouldFire=aboutToEnter(bShouldFire,"insertStatement",4,440);
					column_elements();
					c_AST = (AST)returnAST;
					break;
				}
				case SELECT:
				case VALUES:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case VALUES:
				{
					bShouldFire=aboutToEnter(bShouldFire,"insertStatement",5,460);
					value_elements();
					v_AST = (AST)returnAST;
					break;
				}
				case SELECT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"insertStatement",6,467);
					selectStatement();
					s_AST = (AST)returnAST;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					insertStatement_AST = (AST)currentAST.root;
					
							insertStatement_AST=(AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(INSERT,"INSERT")).add(n_AST).add(c_AST).add(v_AST).add(s_AST));
						
					currentAST.root = insertStatement_AST;
					currentAST.child = insertStatement_AST!=null &&insertStatement_AST.getFirstChild()!=null ?
						insertStatement_AST.getFirstChild() : insertStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = insertStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void updateStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("updateStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST updateStatement_AST = null;
			Token  u = null;
			AST u_AST = null;
			AST t_AST = null;
			AST s_AST = null;
			AST f_AST = null;
			AST w_AST = null;
			
			try {      // for error handling
				u = LT(1);
				u_AST = astFactory.create(u);
				bShouldFire=aboutToEnter(bShouldFire,"updateStatement",1,524);
				match(UPDATE);
				bShouldFire=aboutToEnter(bShouldFire,"updateStatement",2,526);
				table_name();
				t_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"updateStatement",3,529);
				set_clause();
				s_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case FROM:
				{
					bShouldFire=aboutToEnter(bShouldFire,"updateStatement",4,536);
					from_clause();
					f_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case WHERE:
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case WHERE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"updateStatement",5,565);
					where_clause();
					w_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					updateStatement_AST = (AST)currentAST.root;
					
							updateStatement_AST=(AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(UPDATE,"UPDATE")).add(t_AST).add(s_AST).add(f_AST).add(w_AST));	
						
					currentAST.root = updateStatement_AST;
					currentAST.child = updateStatement_AST!=null &&updateStatement_AST.getFirstChild()!=null ?
						updateStatement_AST.getFirstChild() : updateStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = updateStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void deleteStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("deleteStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST deleteStatement_AST = null;
			Token  d = null;
			AST d_AST = null;
			AST t_AST = null;
			AST w_AST = null;
			
			try {      // for error handling
				d = LT(1);
				d_AST = astFactory.create(d);
				bShouldFire=aboutToEnter(bShouldFire,"deleteStatement",1,633);
				match(DELETE);
				{
				switch ( LA(1)) {
				case STAR:
				{
					bShouldFire=aboutToEnter(bShouldFire,"deleteStatement",2,639);
					match(STAR);
					break;
				}
				case FROM:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				bShouldFire=aboutToEnter(bShouldFire,"deleteStatement",3,653);
				match(FROM);
				bShouldFire=aboutToEnter(bShouldFire,"deleteStatement",4,655);
				table_name();
				t_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case WHERE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"deleteStatement",5,662);
					where_clause();
					w_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					deleteStatement_AST = (AST)currentAST.root;
					
							deleteStatement_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(DELETE,"DELETE")).add(t_AST).add(w_AST));
						
					currentAST.root = deleteStatement_AST;
					currentAST.child = deleteStatement_AST!=null &&deleteStatement_AST.getFirstChild()!=null ?
						deleteStatement_AST.getFirstChild() : deleteStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = deleteStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void createTableStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("createTableStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST createTableStatement_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",1,724);
				match(CREATE);
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",2,726);
				match(TABLE);
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",3,728);
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",4,731);
				match(LB);
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",5,733);
				tableitemdef();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop344:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",6,740);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",7,742);
						tableitemdef();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop344;
					}
					
				} while (true);
				}
				bShouldFire=aboutToEnter(bShouldFire,"createTableStatement",8,752);
				match(RB);
				if ( inputState.guessing==0 ) {
					createTableStatement_AST = (AST)currentAST.root;
					createTableStatement_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CREATE_TABLE,"CREATE_TABLE")).add(createTableStatement_AST));
					currentAST.root = createTableStatement_AST;
					currentAST.child = createTableStatement_AST!=null &&createTableStatement_AST.getFirstChild()!=null ?
						createTableStatement_AST.getFirstChild() : createTableStatement_AST;
					currentAST.advanceChildToEnd();
				}
				createTableStatement_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = createTableStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void createIndexStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("createIndexStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST createIndexStatement_AST = null;
			AST idxname_AST = null;
			AST tn_AST = null;
			AST ce_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",1,794);
				match(CREATE);
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",2,796);
				match(INDEX);
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",3,798);
				index_name();
				idxname_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",4,801);
				match(ON);
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",5,803);
				table_name();
				tn_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"createIndexStatement",6,806);
				column_elements();
				ce_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					createIndexStatement_AST = (AST)currentAST.root;
					createIndexStatement_AST=(AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(CREATE_INDEX,"CREATE_INDEX")).add(idxname_AST).add(tn_AST).add(ce_AST));
					currentAST.root = createIndexStatement_AST;
					currentAST.child = createIndexStatement_AST!=null &&createIndexStatement_AST.getFirstChild()!=null ?
						createIndexStatement_AST.getFirstChild() : createIndexStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = createIndexStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void dropTableStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("dropTableStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST dropTableStatement_AST = null;
			AST tn_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"dropTableStatement",1,846);
				match(DROP);
				bShouldFire=aboutToEnter(bShouldFire,"dropTableStatement",2,848);
				match(TABLE);
				bShouldFire=aboutToEnter(bShouldFire,"dropTableStatement",3,850);
				table_name();
				tn_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					dropTableStatement_AST = (AST)currentAST.root;
					dropTableStatement_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DROP_TABLE,"DROP_TABLE")).add(tn_AST));
					currentAST.root = dropTableStatement_AST;
					currentAST.child = dropTableStatement_AST!=null &&dropTableStatement_AST.getFirstChild()!=null ?
						dropTableStatement_AST.getFirstChild() : dropTableStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = dropTableStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void dropIndexStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("dropIndexStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST dropIndexStatement_AST = null;
			AST tn_AST = null;
			AST idxn_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",1,891);
				match(DROP);
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",2,893);
				match(INDEX);
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",3,895);
				table_name();
				tn_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",4,898);
				match(DOT);
				bShouldFire=aboutToEnter(bShouldFire,"dropIndexStatement",5,900);
				index_name();
				idxn_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					dropIndexStatement_AST = (AST)currentAST.root;
					dropIndexStatement_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(DROP_INDEX,"DROP_INDEX")).add(tn_AST).add(idxn_AST));
					currentAST.root = dropIndexStatement_AST;
					currentAST.child = dropIndexStatement_AST!=null &&dropIndexStatement_AST.getFirstChild()!=null ?
						dropIndexStatement_AST.getFirstChild() : dropIndexStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = dropIndexStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void showStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("showStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST showStatement_AST = null;
			Token  schema = null;
			AST schema_AST = null;
			AST tn_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"showStatement",1,942);
				match(SHOW);
				{
				switch ( LA(1)) {
				case LITERAL_tables:
				{
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",2,948);
					match(LITERAL_tables);
					{
					switch ( LA(1)) {
					case ID:
					{
						schema = LT(1);
						schema_AST = astFactory.create(schema);
						bShouldFire=aboutToEnter(bShouldFire,"showStatement",3,956);
						match(ID);
						break;
					}
					case EOF:
					case CREATE:
					case DROP:
					case ALTER:
					case SHOW:
					case SELECT:
					case DELETE:
					case INSERT:
					case UPDATE:
					case SEMI:
					case RB:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						showStatement_AST = (AST)currentAST.root;
						showStatement_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SHOW_TABLES,"SHOW_TABLES")).add(schema_AST));
						currentAST.root = showStatement_AST;
						currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
							showStatement_AST.getFirstChild() : showStatement_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_tablecolumns:
				{
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",4,992);
					match(LITERAL_tablecolumns);
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",5,994);
					table_name();
					tn_AST = (AST)returnAST;
					if ( inputState.guessing==0 ) {
						showStatement_AST = (AST)currentAST.root;
						showStatement_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SHOW_TABLECOLUMNS,"SHOW_TABLECOLUMNS")).add(tn_AST));
						currentAST.root = showStatement_AST;
						currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
							showStatement_AST.getFirstChild() : showStatement_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_functions:
				{
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",6,1009);
					match(LITERAL_functions);
					if ( inputState.guessing==0 ) {
						showStatement_AST = (AST)currentAST.root;
						showStatement_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(SHOW_FUNCTIONS,"SHOW_FUNCTIONS")));
						currentAST.root = showStatement_AST;
						currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
							showStatement_AST.getFirstChild() : showStatement_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_functioncolumns:
				{
					bShouldFire=aboutToEnter(bShouldFire,"showStatement",7,1023);
					match(LITERAL_functioncolumns);
					if ( inputState.guessing==0 ) {
						showStatement_AST = (AST)currentAST.root;
						showStatement_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(SHOW_FUNCTIONCOLUMNS,"SHOW_FUNCTIONCOLUMNS")));
						currentAST.root = showStatement_AST;
						currentAST.child = showStatement_AST!=null &&showStatement_AST.getFirstChild()!=null ?
							showStatement_AST.getFirstChild() : showStatement_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_3);
				} else {
				  throw ex;
				}
			}
			returnAST = showStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void alterTableStatement() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("alterTableStatement");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST alterTableStatement_AST = null;
			AST tn_AST = null;
			AST ace_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",1,1071);
				match(ALTER);
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",2,1073);
				match(TABLE);
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",3,1075);
				table_name();
				tn_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",4,1078);
				match(ADD);
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",5,1080);
				match(COLUMN);
				bShouldFire=aboutToEnter(bShouldFire,"alterTableStatement",6,1082);
				columndef();
				ace_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					alterTableStatement_AST = (AST)currentAST.root;
					alterTableStatement_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(ALTERTABLE_ADD_COLUMNS,"ALTERTABLE_ADD_COLUMNS")).add(tn_AST).add(ace_AST));
					currentAST.root = alterTableStatement_AST;
					currentAST.child = alterTableStatement_AST!=null &&alterTableStatement_AST.getFirstChild()!=null ?
						alterTableStatement_AST.getFirstChild() : alterTableStatement_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = alterTableStatement_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void table_name() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("table_name");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_name_AST = null;
			Token  t = null;
			AST t_AST = null;
			
			try {      // for error handling
				t = LT(1);
				t_AST = astFactory.create(t);
				astFactory.addASTChild(currentAST, t_AST);
				bShouldFire=aboutToEnter(bShouldFire,"table_name",1,1126);
				match(ID);
				if ( inputState.guessing==0 ) {
					t_AST.setType(TABLE_NAME);
				}
				table_name_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_4);
				} else {
				  throw ex;
				}
			}
			returnAST = table_name_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void column_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("column_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_elements_AST = null;
			AST c_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"column_elements",1,1161);
				column_elements2();
				c_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					column_elements_AST = (AST)currentAST.root;
					column_elements_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COLUMN_ELEMENTS,"COLUMN_ELEMENTS")).add(c_AST));
					currentAST.root = column_elements_AST;
					currentAST.child = column_elements_AST!=null &&column_elements_AST.getFirstChild()!=null ?
						column_elements_AST.getFirstChild() : column_elements_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_5);
				} else {
				  throw ex;
				}
			}
			returnAST = column_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void value_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("value_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST value_elements_AST = null;
			AST v_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"value_elements",1,1201);
				match(VALUES);
				bShouldFire=aboutToEnter(bShouldFire,"value_elements",2,1203);
				match(LB);
				bShouldFire=aboutToEnter(bShouldFire,"value_elements",3,1205);
				value_elements2();
				v_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"value_elements",4,1208);
				match(RB);
				if ( inputState.guessing==0 ) {
					value_elements_AST = (AST)currentAST.root;
					value_elements_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VALUE_ELEMENTS,"VALUE_ELEMENTS")).add(v_AST));
					currentAST.root = value_elements_AST;
					currentAST.child = value_elements_AST!=null &&value_elements_AST.getFirstChild()!=null ?
						value_elements_AST.getFirstChild() : value_elements_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_2);
				} else {
				  throw ex;
				}
			}
			returnAST = value_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void column_elements2() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("column_elements2");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_elements2_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"column_elements2",1,1246);
				match(LB);
				bShouldFire=aboutToEnter(bShouldFire,"column_elements2",2,1248);
				column_name();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop187:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"column_elements2",3,1255);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"column_elements2",4,1257);
						column_name();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop187;
					}
					
				} while (true);
				}
				bShouldFire=aboutToEnter(bShouldFire,"column_elements2",5,1267);
				match(RB);
				column_elements2_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_5);
				} else {
				  throw ex;
				}
			}
			returnAST = column_elements2_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void column_name() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("column_name");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_name_AST = null;
			Token  c = null;
			AST c_AST = null;
			
			try {      // for error handling
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.addASTChild(currentAST, c_AST);
				bShouldFire=aboutToEnter(bShouldFire,"column_name",1,1303);
				match(ID);
				if ( inputState.guessing==0 ) {
					c_AST.setType(COLUMN_NAME);
				}
				column_name_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_6);
				} else {
				  throw ex;
				}
			}
			returnAST = column_name_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void value_elements2() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("value_elements2");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST value_elements2_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"value_elements2",1,1337);
				value_element();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop191:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"value_elements2",2,1344);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"value_elements2",3,1346);
						value_element();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop191;
					}
					
				} while (true);
				}
				value_elements2_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_7);
				} else {
				  throw ex;
				}
			}
			returnAST = value_elements2_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void value_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("value_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST value_element_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"value_element",1,1385);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				value_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_8);
				} else {
				  throw ex;
				}
			}
			returnAST = value_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("expr");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST expr_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case AVG:
				case COUNT:
				case FALSE:
				case MAX:
				case MIN:
				case NULL:
				case SUM:
				case TRUE:
				case LB:
				case ID:
				case PLUS:
				case SUB:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"expr",1,1439);
					mul_div();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop305:
					do {
						if ((LA(1)==PLUS||LA(1)==SUB)) {
							{
							switch ( LA(1)) {
							case PLUS:
							{
								AST tmp34_AST = null;
								tmp34_AST = astFactory.create(LT(1));
								astFactory.makeASTRoot(currentAST, tmp34_AST);
								bShouldFire=aboutToEnter(bShouldFire,"expr",2,1453);
								match(PLUS);
								break;
							}
							case SUB:
							{
								AST tmp35_AST = null;
								tmp35_AST = astFactory.create(LT(1));
								astFactory.makeASTRoot(currentAST, tmp35_AST);
								bShouldFire=aboutToEnter(bShouldFire,"expr",3,1462);
								match(SUB);
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							bShouldFire=aboutToEnter(bShouldFire,"expr",4,1472);
							mul_div();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop305;
						}
						
					} while (true);
					}
					expr_AST = (AST)currentAST.root;
					break;
				}
				case EXISTS:
				case NOT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"expr",5,1488);
					exists();
					astFactory.addASTChild(currentAST, returnAST);
					expr_AST = (AST)currentAST.root;
					break;
				}
				case ALL:
				case ANY:
				case SOME:
				{
					bShouldFire=aboutToEnter(bShouldFire,"expr",6,1498);
					any_some_all();
					astFactory.addASTChild(currentAST, returnAST);
					expr_AST = (AST)currentAST.root;
					break;
				}
				case Q_MARK:
				{
					AST tmp36_AST = null;
					tmp36_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp36_AST);
					bShouldFire=aboutToEnter(bShouldFire,"expr",7,1509);
					match(Q_MARK);
					expr_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_9);
				} else {
				  throw ex;
				}
			}
			returnAST = expr_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void set_clause() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("set_clause");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST set_clause_AST = null;
			AST s_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"set_clause",1,1548);
				match(SET);
				bShouldFire=aboutToEnter(bShouldFire,"set_clause",2,1550);
				set_elements();
				s_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					set_clause_AST = (AST)currentAST.root;
					set_clause_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SET_CLAUSE,"SET_CLAUSE")).add(s_AST));
					currentAST.root = set_clause_AST;
					currentAST.child = set_clause_AST!=null &&set_clause_AST.getFirstChild()!=null ?
						set_clause_AST.getFirstChild() : set_clause_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_10);
				} else {
				  throw ex;
				}
			}
			returnAST = set_clause_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void from_clause() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("from_clause");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST from_clause_AST = null;
			AST t_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"from_clause",1,1590);
				match(FROM);
				bShouldFire=aboutToEnter(bShouldFire,"from_clause",2,1592);
				table_elements();
				t_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					from_clause_AST = (AST)currentAST.root;
					from_clause_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FROM_CLAUSE,"FROM_CLAUSE")).add(t_AST));
					currentAST.root = from_clause_AST;
					currentAST.child = from_clause_AST!=null &&from_clause_AST.getFirstChild()!=null ?
						from_clause_AST.getFirstChild() : from_clause_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_11);
				} else {
				  throw ex;
				}
			}
			returnAST = from_clause_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void where_clause() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("where_clause");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST where_clause_AST = null;
			AST s_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"where_clause",1,1632);
				match(WHERE);
				bShouldFire=aboutToEnter(bShouldFire,"where_clause",2,1634);
				search_condition2();
				s_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					where_clause_AST = (AST)currentAST.root;
					where_clause_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WHERE_CLAUSE,"WHERE_CLAUSE")).add(s_AST));
					currentAST.root = where_clause_AST;
					currentAST.child = where_clause_AST!=null &&where_clause_AST.getFirstChild()!=null ?
						where_clause_AST.getFirstChild() : where_clause_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_12);
				} else {
				  throw ex;
				}
			}
			returnAST = where_clause_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void set_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("set_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST set_elements_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"set_elements",1,1673);
				set_element();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop199:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"set_elements",2,1680);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"set_elements",3,1682);
						set_element();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop199;
					}
					
				} while (true);
				}
				set_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_10);
				} else {
				  throw ex;
				}
			}
			returnAST = set_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void set_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("set_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST set_element_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"set_element",1,1721);
				set_element_left();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp41_AST);
				bShouldFire=aboutToEnter(bShouldFire,"set_element",2,1727);
				match(EQUAL);
				bShouldFire=aboutToEnter(bShouldFire,"set_element",3,1729);
				set_element_right();
				astFactory.addASTChild(currentAST, returnAST);
				set_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_13);
				} else {
				  throw ex;
				}
			}
			returnAST = set_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void set_element_left() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("set_element_left");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST set_element_left_AST = null;
			AST l_AST = null;
			Token  r = null;
			AST r_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"set_element_left",1,1764);
				column_name();
				l_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case DOT:
				{
					AST tmp42_AST = null;
					tmp42_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp42_AST);
					bShouldFire=aboutToEnter(bShouldFire,"set_element_left",2,1775);
					match(DOT);
					r = LT(1);
					r_AST = astFactory.create(r);
					astFactory.addASTChild(currentAST, r_AST);
					bShouldFire=aboutToEnter(bShouldFire,"set_element_left",3,1780);
					match(ID);
					if ( inputState.guessing==0 ) {
						l_AST.setType(TABLE_NAME);r_AST.setType(COLUMN_NAME);
					}
					break;
				}
				case EQUAL:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				set_element_left_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_14);
				} else {
				  throw ex;
				}
			}
			returnAST = set_element_left_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void set_element_right() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("set_element_right");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST set_element_right_AST = null;
			
			try {      // for error handling
				boolean synPredMatched205 = false;
				if (((LA(1)==LB) && (LA(2)==SELECT) && (_tokenSet_15.member(LA(3))))) {
					int _m205 = mark();
					synPredMatched205 = true;
					inputState.guessing++;
					try {
						{
						bShouldFire=aboutToEnter(bShouldFire,"set_element_right",1,1833);
						match(LB);
						bShouldFire=aboutToEnter(bShouldFire,"set_element_right",2,1835);
						match(SELECT);
						}
					}
					catch (RecognitionException pe) {
						synPredMatched205 = false;
					}
					rewind(_m205);
inputState.guessing--;
				}
				if ( synPredMatched205 ) {
					bShouldFire=aboutToEnter(bShouldFire,"set_element_right",3,1846);
					match(LB);
					bShouldFire=aboutToEnter(bShouldFire,"set_element_right",4,1848);
					selectStatement();
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"set_element_right",5,1851);
					match(RB);
					set_element_right_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_17.member(LA(2))) && (_tokenSet_18.member(LA(3)))) {
					bShouldFire=aboutToEnter(bShouldFire,"set_element_right",6,1856);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					set_element_right_AST = (AST)currentAST.root;
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_13);
				} else {
				  throw ex;
				}
			}
			returnAST = set_element_right_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void selectStatement_without_union() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("selectStatement_without_union");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST selectStatement_without_union_AST = null;
			Token  se = null;
			AST se_AST = null;
			AST a_AST = null;
			AST t_AST = null;
			AST s_AST = null;
			AST f_AST = null;
			AST w_AST = null;
			AST g_AST = null;
			AST h_AST = null;
			AST o_AST = null;
			AST l_AST = null;
			AST r_AST = null;
			
			try {      // for error handling
				se = LT(1);
				se_AST = astFactory.create(se);
				bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",1,1907);
				match(SELECT);
				{
				switch ( LA(1)) {
				case DISTINCT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",2,1913);
					aggregate_type();
					a_AST = (AST)returnAST;
					break;
				}
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case ALL:
				case AVG:
				case ANY:
				case COUNT:
				case EXISTS:
				case FALSE:
				case MAX:
				case MIN:
				case NOT:
				case NULL:
				case SOME:
				case SUM:
				case TRUE:
				case TOP:
				case LB:
				case ID:
				case STAR:
				case PLUS:
				case SUB:
				case Q_MARK:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case TOP:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",3,1959);
					top_element();
					t_AST = (AST)returnAST;
					break;
				}
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case ALL:
				case AVG:
				case ANY:
				case COUNT:
				case EXISTS:
				case FALSE:
				case MAX:
				case MIN:
				case NOT:
				case NULL:
				case SOME:
				case SUM:
				case TRUE:
				case LB:
				case ID:
				case STAR:
				case PLUS:
				case SUB:
				case Q_MARK:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",4,2000);
				select_elements();
				s_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case FROM:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",5,2007);
					from_clause();
					f_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case GROUP:
				case HAVING:
				case ORDER:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case WHERE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",6,2043);
					where_clause();
					w_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case GROUP:
				case HAVING:
				case ORDER:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case GROUP:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",7,2078);
					group_by_clause();
					g_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case HAVING:
				case ORDER:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case HAVING:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",8,2112);
					having_clause();
					h_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case ORDER:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case ORDER:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",9,2145);
					order_by_clause();
					o_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case LIMIT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",10,2177);
					limit_optional();
					l_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case ROWNUM:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case ROWNUM:
				{
					bShouldFire=aboutToEnter(bShouldFire,"selectStatement_without_union",11,2208);
					rownum_optional();
					r_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					selectStatement_without_union_AST = (AST)currentAST.root;
					
							selectStatement_without_union_AST=(AST)astFactory.make( (new ASTArray(11)).add(astFactory.create(SELECT,"SELECT")).add(a_AST).add(t_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COLUMN_ELEMENTS,"COLUMN_ELEMENTS")).add(s_AST))).add(f_AST).add(w_AST).add(g_AST).add(h_AST).add(o_AST).add(l_AST).add(r_AST));
						
					currentAST.root = selectStatement_without_union_AST;
					currentAST.child = selectStatement_without_union_AST!=null &&selectStatement_without_union_AST.getFirstChild()!=null ?
						selectStatement_without_union_AST.getFirstChild() : selectStatement_without_union_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_19);
				} else {
				  throw ex;
				}
			}
			returnAST = selectStatement_without_union_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void aggregate_type() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("aggregate_type");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST aggregate_type_AST = null;
			Token  d = null;
			AST d_AST = null;
			
			try {      // for error handling
				{
				d = LT(1);
				d_AST = astFactory.create(d);
				bShouldFire=aboutToEnter(bShouldFire,"aggregate_type",1,2277);
				match(DISTINCT);
				}
				if ( inputState.guessing==0 ) {
					aggregate_type_AST = (AST)currentAST.root;
					
							aggregate_type_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(AGGREGATE_TYPE,"AGGREGATE_TYPE")).add(d_AST));
						
					currentAST.root = aggregate_type_AST;
					currentAST.child = aggregate_type_AST!=null &&aggregate_type_AST.getFirstChild()!=null ?
						aggregate_type_AST.getFirstChild() : aggregate_type_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_20);
				} else {
				  throw ex;
				}
			}
			returnAST = aggregate_type_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void top_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("top_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST top_element_AST = null;
			Token  i = null;
			AST i_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"top_element",1,2320);
				match(TOP);
				i = LT(1);
				i_AST = astFactory.create(i);
				bShouldFire=aboutToEnter(bShouldFire,"top_element",2,2324);
				match(NUM_INT);
				if ( inputState.guessing==0 ) {
					top_element_AST = (AST)currentAST.root;
					top_element_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TOP_ELEMENT,"TOP_ELEMENT")).add(i_AST));
					currentAST.root = top_element_AST;
					currentAST.child = top_element_AST!=null &&top_element_AST.getFirstChild()!=null ?
						top_element_AST.getFirstChild() : top_element_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_21);
				} else {
				  throw ex;
				}
			}
			returnAST = top_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void select_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("select_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST select_elements_AST = null;
			Token  star = null;
			AST star_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case STAR:
				{
					{
					star = LT(1);
					star_AST = astFactory.create(star);
					astFactory.addASTChild(currentAST, star_AST);
					bShouldFire=aboutToEnter(bShouldFire,"select_elements",1,2371);
					match(STAR);
					if ( inputState.guessing==0 ) {
						select_elements_AST = (AST)currentAST.root;
						star_AST.setType(ALL_COLUMNS);select_elements_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COLUMN_ELEMENT,"COLUMN_ELEMENT")).add(star_AST));
						currentAST.root = select_elements_AST;
						currentAST.child = select_elements_AST!=null &&select_elements_AST.getFirstChild()!=null ?
							select_elements_AST.getFirstChild() : select_elements_AST;
						currentAST.advanceChildToEnd();
					}
					}
					select_elements_AST = (AST)currentAST.root;
					break;
				}
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case ALL:
				case AVG:
				case ANY:
				case COUNT:
				case EXISTS:
				case FALSE:
				case MAX:
				case MIN:
				case NOT:
				case NULL:
				case SOME:
				case SUM:
				case TRUE:
				case LB:
				case ID:
				case PLUS:
				case SUB:
				case Q_MARK:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"select_elements",2,2413);
					column_element();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop233:
					do {
						if ((LA(1)==COMMA)) {
							bShouldFire=aboutToEnter(bShouldFire,"select_elements",3,2420);
							match(COMMA);
							bShouldFire=aboutToEnter(bShouldFire,"select_elements",4,2422);
							column_element();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop233;
						}
						
					} while (true);
					}
					}
					select_elements_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_22);
				} else {
				  throw ex;
				}
			}
			returnAST = select_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void group_by_clause() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("group_by_clause");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST group_by_clause_AST = null;
			AST g_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"group_by_clause",1,2470);
				match(GROUP);
				bShouldFire=aboutToEnter(bShouldFire,"group_by_clause",2,2472);
				match(BY);
				bShouldFire=aboutToEnter(bShouldFire,"group_by_clause",3,2474);
				group_by_elements();
				g_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					group_by_clause_AST = (AST)currentAST.root;
					group_by_clause_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GROUP_BY_CLAUSE,"GROUP_BY_CLAUSE")).add(g_AST));
					currentAST.root = group_by_clause_AST;
					currentAST.child = group_by_clause_AST!=null &&group_by_clause_AST.getFirstChild()!=null ?
						group_by_clause_AST.getFirstChild() : group_by_clause_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_23);
				} else {
				  throw ex;
				}
			}
			returnAST = group_by_clause_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void having_clause() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("having_clause");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST having_clause_AST = null;
			AST s_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"having_clause",1,2514);
				match(HAVING);
				bShouldFire=aboutToEnter(bShouldFire,"having_clause",2,2516);
				search_condition2();
				s_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					having_clause_AST = (AST)currentAST.root;
					having_clause_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(HAVING_CLAUSE,"HAVING_CLAUSE")).add(s_AST));
					currentAST.root = having_clause_AST;
					currentAST.child = having_clause_AST!=null &&having_clause_AST.getFirstChild()!=null ?
						having_clause_AST.getFirstChild() : having_clause_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_24);
				} else {
				  throw ex;
				}
			}
			returnAST = having_clause_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void order_by_clause() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("order_by_clause");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST order_by_clause_AST = null;
			AST o_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"order_by_clause",1,2556);
				match(ORDER);
				bShouldFire=aboutToEnter(bShouldFire,"order_by_clause",2,2558);
				match(BY);
				bShouldFire=aboutToEnter(bShouldFire,"order_by_clause",3,2560);
				order_by_elements();
				o_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					order_by_clause_AST = (AST)currentAST.root;
					order_by_clause_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ORDER_BY_CLAUSE,"ORDER_BY_CLAUSE")).add(o_AST));
					currentAST.root = order_by_clause_AST;
					currentAST.child = order_by_clause_AST!=null &&order_by_clause_AST.getFirstChild()!=null ?
						order_by_clause_AST.getFirstChild() : order_by_clause_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_25);
				} else {
				  throw ex;
				}
			}
			returnAST = order_by_clause_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void limit_optional() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("limit_optional");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST limit_optional_AST = null;
			Token  l = null;
			AST l_AST = null;
			Token  r = null;
			AST r_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"limit_optional",1,2603);
				match(LIMIT);
				l = LT(1);
				l_AST = astFactory.create(l);
				bShouldFire=aboutToEnter(bShouldFire,"limit_optional",2,2607);
				match(NUM_INT);
				{
				switch ( LA(1)) {
				case COMMA:
				{
					bShouldFire=aboutToEnter(bShouldFire,"limit_optional",3,2613);
					match(COMMA);
					r = LT(1);
					r_AST = astFactory.create(r);
					bShouldFire=aboutToEnter(bShouldFire,"limit_optional",4,2617);
					match(NUM_INT);
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case ROWNUM:
				case UNION:
				case SEMI:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					limit_optional_AST = (AST)currentAST.root;
					limit_optional_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(LIMIT_OPTIONAL,"LIMIT_OPTIONAL")).add(l_AST).add(r_AST));
					currentAST.root = limit_optional_AST;
					currentAST.child = limit_optional_AST!=null &&limit_optional_AST.getFirstChild()!=null ?
						limit_optional_AST.getFirstChild() : limit_optional_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_26);
				} else {
				  throw ex;
				}
			}
			returnAST = limit_optional_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void rownum_optional() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("rownum_optional");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST rownum_optional_AST = null;
			Token  i = null;
			AST i_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"rownum_optional",1,2681);
				match(ROWNUM);
				bShouldFire=aboutToEnter(bShouldFire,"rownum_optional",2,2683);
				match(LESS);
				bShouldFire=aboutToEnter(bShouldFire,"rownum_optional",3,2685);
				match(EQUAL);
				i = LT(1);
				i_AST = astFactory.create(i);
				bShouldFire=aboutToEnter(bShouldFire,"rownum_optional",4,2689);
				match(NUM_INT);
				if ( inputState.guessing==0 ) {
					rownum_optional_AST = (AST)currentAST.root;
					rownum_optional_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ROWNUM_OPTIONAL,"ROWNUM_OPTIONAL")).add(i_AST));
					currentAST.root = rownum_optional_AST;
					currentAST.child = rownum_optional_AST!=null &&rownum_optional_AST.getFirstChild()!=null ?
						rownum_optional_AST.getFirstChild() : rownum_optional_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_19);
				} else {
				  throw ex;
				}
			}
			returnAST = rownum_optional_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void column_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("column_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST column_element_AST = null;
			AST el_AST = null;
			AST al_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"column_element",1,2729);
				expr();
				el_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case AS:
				case ID:
				{
					{
					switch ( LA(1)) {
					case AS:
					{
						bShouldFire=aboutToEnter(bShouldFire,"column_element",2,2741);
						match(AS);
						break;
					}
					case ID:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					bShouldFire=aboutToEnter(bShouldFire,"column_element",3,2755);
					alias_name();
					al_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case FROM:
				case GROUP:
				case HAVING:
				case ORDER:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					column_element_AST = (AST)currentAST.root;
					
							column_element_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(COLUMN_ELEMENT,"COLUMN_ELEMENT")).add(el_AST).add(al_AST));
						
					currentAST.root = column_element_AST;
					currentAST.child = column_element_AST!=null &&column_element_AST.getFirstChild()!=null ?
						column_element_AST.getFirstChild() : column_element_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_27);
				} else {
				  throw ex;
				}
			}
			returnAST = column_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void alias_name() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("alias_name");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST alias_name_AST = null;
			Token  a = null;
			AST a_AST = null;
			
			try {      // for error handling
				a = LT(1);
				a_AST = astFactory.create(a);
				astFactory.addASTChild(currentAST, a_AST);
				bShouldFire=aboutToEnter(bShouldFire,"alias_name",1,2832);
				match(ID);
				if ( inputState.guessing==0 ) {
					a_AST.setType(ALIAS_NAME);
				}
				alias_name_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_28);
				} else {
				  throw ex;
				}
			}
			returnAST = alias_name_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void table_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("table_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_elements_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"table_elements",1,2866);
				table_source();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop242:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"table_elements",2,2873);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"table_elements",3,2875);
						table_source();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop242;
					}
					
				} while (true);
				}
				table_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_11);
				} else {
				  throw ex;
				}
			}
			returnAST = table_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void table_source() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("table_source");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_source_AST = null;
			AST t_AST = null;
			AST j_AST = null;
			AST j2_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"table_source",1,2917);
				table_element();
				t_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					table_source_AST = (AST)currentAST.root;
					table_source_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TABLE_ELEMENT,"TABLE_ELEMENT")).add(t_AST));
					currentAST.root = table_source_AST;
					currentAST.child = table_source_AST!=null &&table_source_AST.getFirstChild()!=null ?
						table_source_AST.getFirstChild() : table_source_AST;
					currentAST.advanceChildToEnd();
				}
				{
				switch ( LA(1)) {
				case CROSS:
				case INNER:
				case JOIN:
				case RIGHT:
				case LEFT:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"table_source",2,2937);
					joined_table();
					j_AST = (AST)returnAST;
					if ( inputState.guessing==0 ) {
						table_source_AST = (AST)currentAST.root;
						table_source_AST.addChild(j_AST);
					}
					}
					{
					_loop247:
					do {
						if ((_tokenSet_29.member(LA(1)))) {
							bShouldFire=aboutToEnter(bShouldFire,"table_source",3,2949);
							joined_table();
							j2_AST = (AST)returnAST;
							if ( inputState.guessing==0 ) {
								j_AST.addChild(j2_AST);j_AST=j2_AST;
							}
						}
						else {
							break _loop247;
						}
						
					} while (true);
					}
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case GROUP:
				case HAVING:
				case ORDER:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_30);
				} else {
				  throw ex;
				}
			}
			returnAST = table_source_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void table_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("table_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST table_element_AST = null;
			
			try {      // for error handling
				{
				if ((LA(1)==ID)) {
					bShouldFire=aboutToEnter(bShouldFire,"table_element",1,3022);
					table_name();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((LA(1)==LB) && (LA(2)==SELECT)) {
					{
					bShouldFire=aboutToEnter(bShouldFire,"table_element",2,3028);
					match(LB);
					bShouldFire=aboutToEnter(bShouldFire,"table_element",3,3030);
					selectStatement();
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"table_element",4,3033);
					match(RB);
					}
				}
				else if ((LA(1)==LB) && (LA(2)==SHOW)) {
					{
					bShouldFire=aboutToEnter(bShouldFire,"table_element",5,3039);
					match(LB);
					bShouldFire=aboutToEnter(bShouldFire,"table_element",6,3041);
					showStatement();
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"table_element",7,3044);
					match(RB);
					}
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				{
				switch ( LA(1)) {
				case AS:
				case ID:
				{
					{
					switch ( LA(1)) {
					case AS:
					{
						bShouldFire=aboutToEnter(bShouldFire,"table_element",8,3062);
						match(AS);
						break;
					}
					case ID:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					bShouldFire=aboutToEnter(bShouldFire,"table_element",9,3076);
					alias_name();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case CROSS:
				case GROUP:
				case HAVING:
				case INNER:
				case JOIN:
				case ON:
				case ORDER:
				case RIGHT:
				case LEFT:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				table_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_31);
				} else {
				  throw ex;
				}
			}
			returnAST = table_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void joined_table() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("joined_table");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST joined_table_AST = null;
			AST j_AST = null;
			AST t_AST = null;
			AST s_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"joined_table",1,3147);
				joined_type();
				j_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"joined_table",2,3150);
				table_element();
				t_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case ON:
				{
					bShouldFire=aboutToEnter(bShouldFire,"joined_table",3,3157);
					match(ON);
					bShouldFire=aboutToEnter(bShouldFire,"joined_table",4,3159);
					search_condition();
					s_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case CROSS:
				case GROUP:
				case HAVING:
				case INNER:
				case JOIN:
				case ORDER:
				case RIGHT:
				case LEFT:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					joined_table_AST = (AST)currentAST.root;
					joined_table_AST=(AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(JOIN_TABLE,"JOIN_TABLE")).add(j_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TABLE_ELEMENT,"TABLE_ELEMENT")).add(t_AST))).add(s_AST));
					currentAST.root = joined_table_AST;
					currentAST.child = joined_table_AST!=null &&joined_table_AST.getFirstChild()!=null ?
						joined_table_AST.getFirstChild() : joined_table_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_32);
				} else {
				  throw ex;
				}
			}
			returnAST = joined_table_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void joined_type() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("joined_type");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST joined_type_AST = null;
			
			try {      // for error handling
				if ( inputState.guessing==0 ) {
					joined_type_AST = (AST)currentAST.root;
					joined_type_AST=astFactory.create(DEFULT_JOIN,"DEFULT_JOIN");
					currentAST.root = joined_type_AST;
					currentAST.child = joined_type_AST!=null &&joined_type_AST.getFirstChild()!=null ?
						joined_type_AST.getFirstChild() : joined_type_AST;
					currentAST.advanceChildToEnd();
				}
				{
				switch ( LA(1)) {
				case INNER:
				{
					AST tmp65_AST = null;
					tmp65_AST = astFactory.create(LT(1));
					bShouldFire=aboutToEnter(bShouldFire,"joined_type",1,3247);
					match(INNER);
					if ( inputState.guessing==0 ) {
						joined_type_AST = (AST)currentAST.root;
						joined_type_AST=astFactory.create(INNER_JOIN,"INNER_JOIN");
						currentAST.root = joined_type_AST;
						currentAST.child = joined_type_AST!=null &&joined_type_AST.getFirstChild()!=null ?
							joined_type_AST.getFirstChild() : joined_type_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case CROSS:
				{
					AST tmp66_AST = null;
					tmp66_AST = astFactory.create(LT(1));
					bShouldFire=aboutToEnter(bShouldFire,"joined_type",2,3263);
					match(CROSS);
					if ( inputState.guessing==0 ) {
						joined_type_AST = (AST)currentAST.root;
						joined_type_AST=astFactory.create(CROSS_JOIN,"CROSS_JOIN");
						currentAST.root = joined_type_AST;
						currentAST.child = joined_type_AST!=null &&joined_type_AST.getFirstChild()!=null ?
							joined_type_AST.getFirstChild() : joined_type_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case RIGHT:
				case LEFT:
				{
					{
					switch ( LA(1)) {
					case LEFT:
					{
						AST tmp67_AST = null;
						tmp67_AST = astFactory.create(LT(1));
						bShouldFire=aboutToEnter(bShouldFire,"joined_type",3,3284);
						match(LEFT);
						if ( inputState.guessing==0 ) {
							joined_type_AST = (AST)currentAST.root;
							joined_type_AST=astFactory.create(LEFT_JOIN,"LEFT_JOIN");
							currentAST.root = joined_type_AST;
							currentAST.child = joined_type_AST!=null &&joined_type_AST.getFirstChild()!=null ?
								joined_type_AST.getFirstChild() : joined_type_AST;
							currentAST.advanceChildToEnd();
						}
						break;
					}
					case RIGHT:
					{
						AST tmp68_AST = null;
						tmp68_AST = astFactory.create(LT(1));
						bShouldFire=aboutToEnter(bShouldFire,"joined_type",4,3300);
						match(RIGHT);
						if ( inputState.guessing==0 ) {
							joined_type_AST = (AST)currentAST.root;
							joined_type_AST=astFactory.create(RIGHT_JOIN,"RIGHT_JOIN");
							currentAST.root = joined_type_AST;
							currentAST.child = joined_type_AST!=null &&joined_type_AST.getFirstChild()!=null ?
								joined_type_AST.getFirstChild() : joined_type_AST;
							currentAST.advanceChildToEnd();
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case OUTER:
					{
						bShouldFire=aboutToEnter(bShouldFire,"joined_type",5,3322);
						match(OUTER);
						break;
					}
					case JOIN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case JOIN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				bShouldFire=aboutToEnter(bShouldFire,"joined_type",6,3348);
				match(JOIN);
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_33);
				} else {
				  throw ex;
				}
			}
			returnAST = joined_type_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void search_condition() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("search_condition");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST search_condition_AST = null;
			AST s_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"search_condition",1,3379);
				search_condition2();
				s_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					search_condition_AST = (AST)currentAST.root;
					search_condition_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SEARCH_CONDITION,"SEARCH_CONDITION")).add(s_AST));
					currentAST.root = search_condition_AST;
					currentAST.child = search_condition_AST!=null &&search_condition_AST.getFirstChild()!=null ?
						search_condition_AST.getFirstChild() : search_condition_AST;
					currentAST.advanceChildToEnd();
				}
				search_condition_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_32);
				} else {
				  throw ex;
				}
			}
			returnAST = search_condition_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void search_condition2() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("search_condition2");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST search_condition2_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"search_condition2",1,3420);
				equation();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop283:
				do {
					if ((LA(1)==AND||LA(1)==OR)) {
						{
						switch ( LA(1)) {
						case OR:
						{
							AST tmp71_AST = null;
							tmp71_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp71_AST);
							bShouldFire=aboutToEnter(bShouldFire,"search_condition2",2,3434);
							match(OR);
							break;
						}
						case AND:
						{
							AST tmp72_AST = null;
							tmp72_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp72_AST);
							bShouldFire=aboutToEnter(bShouldFire,"search_condition2",3,3443);
							match(AND);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						bShouldFire=aboutToEnter(bShouldFire,"search_condition2",4,3453);
						equation();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop283;
					}
					
				} while (true);
				}
				search_condition2_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_32);
				} else {
				  throw ex;
				}
			}
			returnAST = search_condition2_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void group_by_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("group_by_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST group_by_elements_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"group_by_elements",1,3492);
				group_by_element();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop265:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"group_by_elements",2,3499);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"group_by_elements",3,3501);
						group_by_element();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop265;
					}
					
				} while (true);
				}
				group_by_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_23);
				} else {
				  throw ex;
				}
			}
			returnAST = group_by_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void group_by_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("group_by_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST group_by_element_AST = null;
			AST e_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"group_by_element",1,3541);
				expr();
				e_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				group_by_element_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_34);
				} else {
				  throw ex;
				}
			}
			returnAST = group_by_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void order_by_elements() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("order_by_elements");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST order_by_elements_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"order_by_elements",1,3574);
				order_by_element();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop271:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"order_by_elements",2,3581);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"order_by_elements",3,3583);
						order_by_element();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop271;
					}
					
				} while (true);
				}
				order_by_elements_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_25);
				} else {
				  throw ex;
				}
			}
			returnAST = order_by_elements_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void order_by_element() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("order_by_element");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST order_by_element_AST = null;
			AST cl_AST = null;
			AST ol_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"order_by_element",1,3624);
				expr();
				cl_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					order_by_element_AST = (AST)currentAST.root;
					order_by_element_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ORDER_BY_ELEMENT,"ORDER_BY_ELEMENT")).add(cl_AST));
					currentAST.root = order_by_element_AST;
					currentAST.child = order_by_element_AST!=null &&order_by_element_AST.getFirstChild()!=null ?
						order_by_element_AST.getFirstChild() : order_by_element_AST;
					currentAST.advanceChildToEnd();
				}
				{
				switch ( LA(1)) {
				case ASC:
				case DESC:
				{
					bShouldFire=aboutToEnter(bShouldFire,"order_by_element",2,3640);
					order_type();
					ol_AST = (AST)returnAST;
					if ( inputState.guessing==0 ) {
						order_by_element_AST = (AST)currentAST.root;
						order_by_element_AST.addChild(ol_AST);
					}
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_35);
				} else {
				  throw ex;
				}
			}
			returnAST = order_by_element_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void order_type() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("order_type");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST order_type_AST = null;
			
			try {      // for error handling
				{
				switch ( LA(1)) {
				case ASC:
				{
					AST tmp75_AST = null;
					tmp75_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp75_AST);
					bShouldFire=aboutToEnter(bShouldFire,"order_type",1,3708);
					match(ASC);
					break;
				}
				case DESC:
				{
					AST tmp76_AST = null;
					tmp76_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp76_AST);
					bShouldFire=aboutToEnter(bShouldFire,"order_type",2,3717);
					match(DESC);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				order_type_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_35);
				} else {
				  throw ex;
				}
			}
			returnAST = order_type_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void equation() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("equation");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST equation_AST = null;
			AST ex_AST = null;
			Token  n = null;
			AST n_AST = null;
			Token  in = null;
			AST in_AST = null;
			Token  be = null;
			AST be_AST = null;
			Token  li = null;
			AST li_AST = null;
			Token  is = null;
			AST is_AST = null;
			Token  isnot = null;
			AST isnot_AST = null;
			Token  nu = null;
			AST nu_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"equation",1,3771);
				expr();
				ex_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case EQUAL:
				case LESS:
				case GREATER:
				case LE_EQ:
				case GR_EQ:
				case NOT_EQ:
				{
					{
					switch ( LA(1)) {
					case EQUAL:
					{
						AST tmp77_AST = null;
						tmp77_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp77_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",2,3791);
						match(EQUAL);
						break;
					}
					case GREATER:
					{
						AST tmp78_AST = null;
						tmp78_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp78_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",3,3800);
						match(GREATER);
						break;
					}
					case LESS:
					{
						AST tmp79_AST = null;
						tmp79_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp79_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",4,3809);
						match(LESS);
						break;
					}
					case LE_EQ:
					{
						AST tmp80_AST = null;
						tmp80_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp80_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",5,3818);
						match(LE_EQ);
						break;
					}
					case GR_EQ:
					{
						AST tmp81_AST = null;
						tmp81_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp81_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",6,3827);
						match(GR_EQ);
						break;
					}
					case NOT_EQ:
					{
						AST tmp82_AST = null;
						tmp82_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp82_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",7,3836);
						match(NOT_EQ);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					bShouldFire=aboutToEnter(bShouldFire,"equation",8,3846);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case NOT:
				case IN:
				case BETWEEN:
				case LIKE:
				{
					{
					switch ( LA(1)) {
					case NOT:
					{
						n = LT(1);
						n_AST = astFactory.create(n);
						bShouldFire=aboutToEnter(bShouldFire,"equation",9,3862);
						match(NOT);
						break;
					}
					case IN:
					case BETWEEN:
					case LIKE:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case IN:
					{
						in = LT(1);
						in_AST = astFactory.create(in);
						astFactory.makeASTRoot(currentAST, in_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",10,3885);
						match(IN);
						if ( inputState.guessing==0 ) {
							if(n_AST==null)	 in_AST.setType(IN); else in_AST.setType(NOT_IN);
						}
						bShouldFire=aboutToEnter(bShouldFire,"equation",11,3890);
						match(LB);
						{
						switch ( LA(1)) {
						case SELECT:
						{
							bShouldFire=aboutToEnter(bShouldFire,"equation",12,3896);
							selectStatement();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case NUM_FLOAT:
						case NUM_INT:
						case NUM_REAL:
						case DEFAULT:
						case ALL:
						case AVG:
						case ANY:
						case COUNT:
						case EXISTS:
						case FALSE:
						case MAX:
						case MIN:
						case NOT:
						case NULL:
						case SOME:
						case SUM:
						case TRUE:
						case LB:
						case ID:
						case PLUS:
						case SUB:
						case Q_MARK:
						case CONST_STRING:
						case N_CONST_STRING:
						case NUM_HEX:
						case DATE:
						{
							bShouldFire=aboutToEnter(bShouldFire,"equation",13,3928);
							in_list();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						bShouldFire=aboutToEnter(bShouldFire,"equation",14,3939);
						match(RB);
						break;
					}
					case BETWEEN:
					{
						be = LT(1);
						be_AST = astFactory.create(be);
						astFactory.makeASTRoot(currentAST, be_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",15,3948);
						match(BETWEEN);
						bShouldFire=aboutToEnter(bShouldFire,"equation",16,3950);
						expr();
						astFactory.addASTChild(currentAST, returnAST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",17,3953);
						match(AND);
						bShouldFire=aboutToEnter(bShouldFire,"equation",18,3955);
						expr();
						astFactory.addASTChild(currentAST, returnAST);
						if ( inputState.guessing==0 ) {
							if(n_AST==null)be_AST.setType(BETWEEN); else be_AST.setType(NOT_BETWEEN);
						}
						break;
					}
					case LIKE:
					{
						li = LT(1);
						li_AST = astFactory.create(li);
						astFactory.makeASTRoot(currentAST, li_AST);
						bShouldFire=aboutToEnter(bShouldFire,"equation",19,3968);
						match(LIKE);
						bShouldFire=aboutToEnter(bShouldFire,"equation",20,3970);
						expr();
						astFactory.addASTChild(currentAST, returnAST);
						if ( inputState.guessing==0 ) {
							if(n_AST==null)li_AST.setType(LIKE); else li_AST.setType(NOT_LIKE);
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case IS:
				{
					is = LT(1);
					is_AST = astFactory.create(is);
					astFactory.makeASTRoot(currentAST, is_AST);
					bShouldFire=aboutToEnter(bShouldFire,"equation",21,3991);
					match(IS);
					{
					switch ( LA(1)) {
					case NOT:
					{
						isnot = LT(1);
						isnot_AST = astFactory.create(isnot);
						bShouldFire=aboutToEnter(bShouldFire,"equation",22,3999);
						match(NOT);
						break;
					}
					case NULL:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					nu = LT(1);
					nu_AST = astFactory.create(nu);
					astFactory.addASTChild(currentAST, nu_AST);
					bShouldFire=aboutToEnter(bShouldFire,"equation",23,4016);
					match(NULL);
					if ( inputState.guessing==0 ) {
						if(isnot_AST==null) is_AST.setType(IS);else is_AST.setType(IS_NOT);
					}
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case AND:
				case CROSS:
				case GROUP:
				case HAVING:
				case INNER:
				case JOIN:
				case OR:
				case ORDER:
				case RIGHT:
				case LEFT:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				equation_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_36);
				} else {
				  throw ex;
				}
			}
			returnAST = equation_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void in_list() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("in_list");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST in_list_AST = null;
			AST i_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"in_list",1,4088);
				in_list2();
				i_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					in_list_AST = (AST)currentAST.root;
					in_list_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IN_LIST,"IN_LIST")).add(i_AST));
					currentAST.root = in_list_AST;
					currentAST.child = in_list_AST!=null &&in_list_AST.getFirstChild()!=null ?
						in_list_AST.getFirstChild() : in_list_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_7);
				} else {
				  throw ex;
				}
			}
			returnAST = in_list_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void in_list2() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("in_list2");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST in_list2_AST = null;
			
			try {      // for error handling
				{
				bShouldFire=aboutToEnter(bShouldFire,"in_list2",1,4128);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				}
				{
				_loop295:
				do {
					if ((LA(1)==COMMA)) {
						bShouldFire=aboutToEnter(bShouldFire,"in_list2",2,4136);
						match(COMMA);
						bShouldFire=aboutToEnter(bShouldFire,"in_list2",3,4138);
						expr();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop295;
					}
					
				} while (true);
				}
				in_list2_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_7);
				} else {
				  throw ex;
				}
			}
			returnAST = in_list2_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void exists() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("exists");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST exists_AST = null;
			
			try {      // for error handling
				{
				switch ( LA(1)) {
				case NOT:
				{
					AST tmp87_AST = null;
					tmp87_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp87_AST);
					bShouldFire=aboutToEnter(bShouldFire,"exists",1,4184);
					match(NOT);
					break;
				}
				case EXISTS:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				bShouldFire=aboutToEnter(bShouldFire,"exists",2,4199);
				exists_();
				astFactory.addASTChild(currentAST, returnAST);
				}
				exists_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_9);
				} else {
				  throw ex;
				}
			}
			returnAST = exists_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void exists_() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("exists_");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST exists__AST = null;
			
			try {      // for error handling
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp88_AST);
				bShouldFire=aboutToEnter(bShouldFire,"exists_",1,4235);
				match(EXISTS);
				bShouldFire=aboutToEnter(bShouldFire,"exists_",2,4237);
				match(LB);
				bShouldFire=aboutToEnter(bShouldFire,"exists_",3,4239);
				selectStatement();
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"exists_",4,4242);
				match(RB);
				exists__AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_9);
				} else {
				  throw ex;
				}
			}
			returnAST = exists__AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void any_some_all() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("any_some_all");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST any_some_all_AST = null;
			
			try {      // for error handling
				{
				switch ( LA(1)) {
				case ANY:
				{
					AST tmp91_AST = null;
					tmp91_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp91_AST);
					bShouldFire=aboutToEnter(bShouldFire,"any_some_all",1,4280);
					match(ANY);
					break;
				}
				case SOME:
				{
					AST tmp92_AST = null;
					tmp92_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp92_AST);
					bShouldFire=aboutToEnter(bShouldFire,"any_some_all",2,4289);
					match(SOME);
					break;
				}
				case ALL:
				{
					AST tmp93_AST = null;
					tmp93_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp93_AST);
					bShouldFire=aboutToEnter(bShouldFire,"any_some_all",3,4298);
					match(ALL);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				bShouldFire=aboutToEnter(bShouldFire,"any_some_all",4,4308);
				match(LB);
				bShouldFire=aboutToEnter(bShouldFire,"any_some_all",5,4310);
				selectStatement();
				astFactory.addASTChild(currentAST, returnAST);
				bShouldFire=aboutToEnter(bShouldFire,"any_some_all",6,4313);
				match(RB);
				any_some_all_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_9);
				} else {
				  throw ex;
				}
			}
			returnAST = any_some_all_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void mul_div() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("mul_div");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST mul_div_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"mul_div",1,4344);
				concat();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop309:
				do {
					if ((LA(1)==STAR||LA(1)==DIV||LA(1)==MOD)) {
						{
						switch ( LA(1)) {
						case STAR:
						{
							AST tmp96_AST = null;
							tmp96_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp96_AST);
							bShouldFire=aboutToEnter(bShouldFire,"mul_div",2,4358);
							match(STAR);
							break;
						}
						case DIV:
						{
							AST tmp97_AST = null;
							tmp97_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp97_AST);
							bShouldFire=aboutToEnter(bShouldFire,"mul_div",3,4367);
							match(DIV);
							break;
						}
						case MOD:
						{
							AST tmp98_AST = null;
							tmp98_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp98_AST);
							bShouldFire=aboutToEnter(bShouldFire,"mul_div",4,4376);
							match(MOD);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						bShouldFire=aboutToEnter(bShouldFire,"mul_div",5,4386);
						concat();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop309;
					}
					
				} while (true);
				}
				mul_div_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_37);
				} else {
				  throw ex;
				}
			}
			returnAST = mul_div_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void concat() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("concat");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST concat_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"concat",1,4425);
				dot();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop312:
				do {
					if ((LA(1)==CONCAT)) {
						AST tmp99_AST = null;
						tmp99_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp99_AST);
						bShouldFire=aboutToEnter(bShouldFire,"concat",2,4435);
						match(CONCAT);
						bShouldFire=aboutToEnter(bShouldFire,"concat",3,4437);
						dot();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						break _loop312;
					}
					
				} while (true);
				}
				concat_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_38);
				} else {
				  throw ex;
				}
			}
			returnAST = concat_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void dot() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("dot");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST dot_AST = null;
			AST l_AST = null;
			AST r_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"dot",1,4478);
				item();
				l_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case DOT:
				{
					AST tmp100_AST = null;
					tmp100_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp100_AST);
					bShouldFire=aboutToEnter(bShouldFire,"dot",2,4489);
					match(DOT);
					bShouldFire=aboutToEnter(bShouldFire,"dot",3,4491);
					item();
					r_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						l_AST.setType(TABLE_NAME);r_AST.setType(COLUMN_NAME);
					}
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case AS:
				case AND:
				case ASC:
				case CROSS:
				case DESC:
				case FROM:
				case GROUP:
				case HAVING:
				case IS:
				case INNER:
				case JOIN:
				case NOT:
				case OR:
				case ORDER:
				case RIGHT:
				case LEFT:
				case LIMIT:
				case ROWNUM:
				case UNION:
				case WHERE:
				case IN:
				case BETWEEN:
				case LIKE:
				case SEMI:
				case COMMA:
				case RB:
				case EQUAL:
				case ID:
				case STAR:
				case LESS:
				case GREATER:
				case LE_EQ:
				case GR_EQ:
				case NOT_EQ:
				case PLUS:
				case SUB:
				case DIV:
				case MOD:
				case CONCAT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				dot_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_39);
				} else {
				  throw ex;
				}
			}
			returnAST = dot_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void item() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("item");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST item_AST = null;
			Token  p = null;
			AST p_AST = null;
			Token  s = null;
			AST s_AST = null;
			AST c_AST = null;
			
			try {      // for error handling
				{
				switch ( LA(1)) {
				case PLUS:
				{
					p = LT(1);
					p_AST = astFactory.create(p);
					bShouldFire=aboutToEnter(bShouldFire,"item",1,4597);
					match(PLUS);
					break;
				}
				case SUB:
				{
					s = LT(1);
					s_AST = astFactory.create(s);
					bShouldFire=aboutToEnter(bShouldFire,"item",2,4605);
					match(SUB);
					break;
				}
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case AVG:
				case COUNT:
				case FALSE:
				case MAX:
				case MIN:
				case NULL:
				case SUM:
				case TRUE:
				case LB:
				case ID:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				if ((LA(1)==ID) && (_tokenSet_40.member(LA(2)))) {
					bShouldFire=aboutToEnter(bShouldFire,"item",3,4638);
					column_name();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_41.member(LA(1))) && (LA(2)==LB)) {
					bShouldFire=aboutToEnter(bShouldFire,"item",4,4643);
					function();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_42.member(LA(1)))) {
					bShouldFire=aboutToEnter(bShouldFire,"item",5,4648);
					constant();
					c_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						
								boolean isSub=false;
								
								if(s_AST!=null){
									isSub=true;
									if(c_AST.getType()==NUM_INT||c_AST.getType()==NUM_FLOAT||c_AST.getType()==NUM_REAL){
										if(isSub)c_AST.setText("-"+c_AST.getText());
									}
								}
								
					}
				}
				else if ((LA(1)==LB) && (_tokenSet_16.member(LA(2)))) {
					{
					bShouldFire=aboutToEnter(bShouldFire,"item",6,4667);
					match(LB);
					bShouldFire=aboutToEnter(bShouldFire,"item",7,4669);
					search_condition2();
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"item",8,4672);
					match(RB);
					}
				}
				else if ((LA(1)==LB) && (LA(2)==SELECT)) {
					{
					bShouldFire=aboutToEnter(bShouldFire,"item",9,4678);
					match(LB);
					bShouldFire=aboutToEnter(bShouldFire,"item",10,4680);
					selectStatement();
					astFactory.addASTChild(currentAST, returnAST);
					bShouldFire=aboutToEnter(bShouldFire,"item",11,4683);
					match(RB);
					}
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				item_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_40);
				} else {
				  throw ex;
				}
			}
			returnAST = item_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void function() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("function");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST function_AST = null;
			AST fn_AST = null;
			AST fp_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"function",1,4723);
				function_name();
				fn_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"function",2,4726);
				match(LB);
				{
				switch ( LA(1)) {
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case ALL:
				case AVG:
				case ANY:
				case COUNT:
				case EXISTS:
				case FALSE:
				case MAX:
				case MIN:
				case NOT:
				case NULL:
				case SOME:
				case SUM:
				case TRUE:
				case LB:
				case ID:
				case STAR:
				case PLUS:
				case SUB:
				case Q_MARK:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"function",3,4758);
					function_parameters();
					fp_AST = (AST)returnAST;
					break;
				}
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				bShouldFire=aboutToEnter(bShouldFire,"function",4,4773);
				match(RB);
				if ( inputState.guessing==0 ) {
					function_AST = (AST)currentAST.root;
					function_AST=(AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(FUNCTION,"FUNCTION")).add(fn_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_PARAMETERS,"FUNCTION_PARAMETERS")).add(fp_AST))));
					currentAST.root = function_AST;
					currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
						function_AST.getFirstChild() : function_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_40);
				} else {
				  throw ex;
				}
			}
			returnAST = function_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("constant");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST constant_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case CONST_STRING:
				{
					AST tmp107_AST = null;
					tmp107_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp107_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",1,4817);
					match(CONST_STRING);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case N_CONST_STRING:
				{
					AST tmp108_AST = null;
					tmp108_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp108_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",2,4827);
					match(N_CONST_STRING);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case NULL:
				{
					AST tmp109_AST = null;
					tmp109_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp109_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",3,4837);
					match(NULL);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case DEFAULT:
				{
					AST tmp110_AST = null;
					tmp110_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp110_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",4,4847);
					match(DEFAULT);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case NUM_INT:
				{
					AST tmp111_AST = null;
					tmp111_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp111_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",5,4857);
					match(NUM_INT);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case NUM_FLOAT:
				{
					AST tmp112_AST = null;
					tmp112_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp112_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",6,4867);
					match(NUM_FLOAT);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case NUM_REAL:
				{
					AST tmp113_AST = null;
					tmp113_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp113_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",7,4877);
					match(NUM_REAL);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case NUM_HEX:
				{
					AST tmp114_AST = null;
					tmp114_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp114_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",8,4887);
					match(NUM_HEX);
					constant_AST = (AST)currentAST.root;
					break;
				}
				case TRUE:
				{
					AST tmp115_AST = null;
					tmp115_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp115_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",9,4897);
					match(TRUE);
					if ( inputState.guessing==0 ) {
						constant_AST = (AST)currentAST.root;
						constant_AST.setType(BOOLEAN);
					}
					constant_AST = (AST)currentAST.root;
					break;
				}
				case FALSE:
				{
					AST tmp116_AST = null;
					tmp116_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp116_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",10,4911);
					match(FALSE);
					if ( inputState.guessing==0 ) {
						constant_AST = (AST)currentAST.root;
						constant_AST.setType(BOOLEAN);
					}
					constant_AST = (AST)currentAST.root;
					break;
				}
				case DATE:
				{
					AST tmp117_AST = null;
					tmp117_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp117_AST);
					bShouldFire=aboutToEnter(bShouldFire,"constant",11,4925);
					match(DATE);
					constant_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_40);
				} else {
				  throw ex;
				}
			}
			returnAST = constant_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void function_name() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("function_name");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST function_name_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case AVG:
				{
					AST tmp118_AST = null;
					tmp118_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp118_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",1,4969);
					match(AVG);
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case COUNT:
				{
					AST tmp119_AST = null;
					tmp119_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp119_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",2,4979);
					match(COUNT);
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case MAX:
				{
					AST tmp120_AST = null;
					tmp120_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp120_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",3,4989);
					match(MAX);
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case MIN:
				{
					AST tmp121_AST = null;
					tmp121_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp121_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",4,4999);
					match(MIN);
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case SUM:
				{
					AST tmp122_AST = null;
					tmp122_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp122_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",5,5009);
					match(SUM);
					function_name_AST = (AST)currentAST.root;
					break;
				}
				case ID:
				{
					AST tmp123_AST = null;
					tmp123_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp123_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_name",6,5019);
					match(ID);
					function_name_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_43);
				} else {
				  throw ex;
				}
			}
			returnAST = function_name_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void function_parameters() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("function_parameters");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST function_parameters_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case NUM_FLOAT:
				case NUM_INT:
				case NUM_REAL:
				case DEFAULT:
				case ALL:
				case AVG:
				case ANY:
				case COUNT:
				case EXISTS:
				case FALSE:
				case MAX:
				case MIN:
				case NOT:
				case NULL:
				case SOME:
				case SUM:
				case TRUE:
				case LB:
				case ID:
				case PLUS:
				case SUB:
				case Q_MARK:
				case CONST_STRING:
				case N_CONST_STRING:
				case NUM_HEX:
				case DATE:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"function_parameters",1,5086);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop325:
					do {
						if ((LA(1)==COMMA)) {
							bShouldFire=aboutToEnter(bShouldFire,"function_parameters",2,5093);
							match(COMMA);
							bShouldFire=aboutToEnter(bShouldFire,"function_parameters",3,5095);
							expr();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop325;
						}
						
					} while (true);
					}
					}
					function_parameters_AST = (AST)currentAST.root;
					break;
				}
				case STAR:
				{
					AST tmp125_AST = null;
					tmp125_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp125_AST);
					bShouldFire=aboutToEnter(bShouldFire,"function_parameters",4,5114);
					match(STAR);
					if ( inputState.guessing==0 ) {
						function_parameters_AST = (AST)currentAST.root;
						function_parameters_AST.setType(ALL_COLUMNS);
					}
					function_parameters_AST = (AST)currentAST.root;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_7);
				} else {
				  throw ex;
				}
			}
			returnAST = function_parameters_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void datatype() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("datatype");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST datatype_AST = null;
			Token  n = null;
			AST n_AST = null;
			Token  len = null;
			AST len_AST = null;
			Token  prec = null;
			AST prec_AST = null;
			Token  n2 = null;
			AST n2_AST = null;
			Token  n3 = null;
			AST n3_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case LITERAL_int:
				case LITERAL_integer:
				case LITERAL_tinyint:
				case LITERAL_smallint:
				case LITERAL_bit:
				case LITERAL_boolean:
				{
					{
					switch ( LA(1)) {
					case LITERAL_int:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",1,5178);
						match(LITERAL_int);
						break;
					}
					case LITERAL_integer:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",2,5184);
						match(LITERAL_integer);
						break;
					}
					case LITERAL_tinyint:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",3,5190);
						match(LITERAL_tinyint);
						break;
					}
					case LITERAL_smallint:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",4,5196);
						match(LITERAL_smallint);
						break;
					}
					case LITERAL_bit:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",5,5202);
						match(LITERAL_bit);
						break;
					}
					case LITERAL_boolean:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",6,5208);
						match(LITERAL_boolean);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(TYPE_INT,"TYPE_INT")));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_varchar:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"datatype",7,5231);
					match(LITERAL_varchar);
					}
					bShouldFire=aboutToEnter(bShouldFire,"datatype",8,5234);
					match(LB);
					n = LT(1);
					n_AST = astFactory.create(n);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",9,5238);
					match(NUM_INT);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",10,5240);
					match(RB);
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_VARCHAR,"TYPE_VARCHAR")).add(n_AST));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_decimal:
				case LITERAL_numeric:
				case LITERAL_real:
				case LITERAL_float:
				case LITERAL_double:
				{
					{
					switch ( LA(1)) {
					case LITERAL_decimal:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",11,5262);
						match(LITERAL_decimal);
						break;
					}
					case LITERAL_numeric:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",12,5268);
						match(LITERAL_numeric);
						break;
					}
					case LITERAL_real:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",13,5274);
						match(LITERAL_real);
						break;
					}
					case LITERAL_float:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",14,5280);
						match(LITERAL_float);
						break;
					}
					case LITERAL_double:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",15,5286);
						match(LITERAL_double);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case LB:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",16,5300);
						match(LB);
						len = LT(1);
						len_AST = astFactory.create(len);
						bShouldFire=aboutToEnter(bShouldFire,"datatype",17,5304);
						match(NUM_INT);
						{
						switch ( LA(1)) {
						case COMMA:
						{
							bShouldFire=aboutToEnter(bShouldFire,"datatype",18,5310);
							match(COMMA);
							prec = LT(1);
							prec_AST = astFactory.create(prec);
							bShouldFire=aboutToEnter(bShouldFire,"datatype",19,5314);
							match(NUM_INT);
							break;
						}
						case RB:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						bShouldFire=aboutToEnter(bShouldFire,"datatype",20,5328);
						match(RB);
						break;
					}
					case EOF:
					case CREATE:
					case DROP:
					case ALTER:
					case DEFAULT:
					case SHOW:
					case SELECT:
					case DELETE:
					case INSERT:
					case UPDATE:
					case NOT:
					case SEMI:
					case COMMA:
					case RB:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(TYPE_DECIMAL,"TYPE_DECIMAL")).add(len_AST).add(prec_AST));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_datetime:
				case LITERAL_date:
				case LITERAL_timestamp:
				case LITERAL_time:
				{
					{
					switch ( LA(1)) {
					case LITERAL_datetime:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",21,5374);
						match(LITERAL_datetime);
						break;
					}
					case LITERAL_date:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",22,5380);
						match(LITERAL_date);
						break;
					}
					case LITERAL_timestamp:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",23,5386);
						match(LITERAL_timestamp);
						break;
					}
					case LITERAL_time:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",24,5392);
						match(LITERAL_time);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(TYPE_DATETIME,"TYPE_DATETIME")));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_blob:
				case LITERAL_tinyblob:
				case LITERAL_longblob:
				case LITERAL_binary:
				case LITERAL_varbinary:
				case LITERAL_longvarbinary:
				case LITERAL_image:
				{
					{
					switch ( LA(1)) {
					case LITERAL_blob:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",25,5424);
						match(LITERAL_blob);
						break;
					}
					case LITERAL_tinyblob:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",26,5430);
						match(LITERAL_tinyblob);
						break;
					}
					case LITERAL_longblob:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",27,5436);
						match(LITERAL_longblob);
						break;
					}
					case LITERAL_binary:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",28,5442);
						match(LITERAL_binary);
						break;
					}
					case LITERAL_varbinary:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",29,5448);
						match(LITERAL_varbinary);
						break;
					}
					case LITERAL_longvarbinary:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",30,5454);
						match(LITERAL_longvarbinary);
						break;
					}
					case LITERAL_image:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",31,5460);
						match(LITERAL_image);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(TYPE_BLOB,"TYPE_BLOB")));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_clob:
				case LITERAL_tinytext:
				case LITERAL_longtext:
				case LITERAL_text:
				case LITERAL_longvarchar:
				{
					{
					switch ( LA(1)) {
					case LITERAL_clob:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",32,5490);
						match(LITERAL_clob);
						break;
					}
					case LITERAL_tinytext:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",33,5496);
						match(LITERAL_tinytext);
						break;
					}
					case LITERAL_longtext:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",34,5502);
						match(LITERAL_longtext);
						break;
					}
					case LITERAL_text:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",35,5508);
						match(LITERAL_text);
						break;
					}
					case LITERAL_longvarchar:
					{
						bShouldFire=aboutToEnter(bShouldFire,"datatype",36,5514);
						match(LITERAL_longvarchar);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(TYPE_CLOB,"TYPE_CLOB")));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_char:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"datatype",37,5537);
					match(LITERAL_char);
					}
					bShouldFire=aboutToEnter(bShouldFire,"datatype",38,5540);
					match(LB);
					n2 = LT(1);
					n2_AST = astFactory.create(n2);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",39,5544);
					match(NUM_INT);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",40,5546);
					match(RB);
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_CHAR,"TYPE_CHAR")).add(n2_AST));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_nchar:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"datatype",41,5561);
					match(LITERAL_nchar);
					}
					bShouldFire=aboutToEnter(bShouldFire,"datatype",42,5564);
					match(LB);
					n3 = LT(1);
					n3_AST = astFactory.create(n3);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",43,5568);
					match(NUM_INT);
					bShouldFire=aboutToEnter(bShouldFire,"datatype",44,5570);
					match(RB);
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_NCHAR,"TYPE_NCHAR")).add(n3_AST));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_nvarchar:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"datatype",45,5585);
					match(LITERAL_nvarchar);
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(TYPE_NVARCHAR,"TYPE_NVARCHAR")));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_nclob:
				{
					{
					bShouldFire=aboutToEnter(bShouldFire,"datatype",46,5601);
					match(LITERAL_nclob);
					}
					if ( inputState.guessing==0 ) {
						datatype_AST = (AST)currentAST.root;
						datatype_AST = (AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(TYPE_NCLOB,"TYPE_NCLOB")));
						currentAST.root = datatype_AST;
						currentAST.child = datatype_AST!=null &&datatype_AST.getFirstChild()!=null ?
							datatype_AST.getFirstChild() : datatype_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_44);
				} else {
				  throw ex;
				}
			}
			returnAST = datatype_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void index_name() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("index_name");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST index_name_AST = null;
			Token  t = null;
			AST t_AST = null;
			
			try {      // for error handling
				t = LT(1);
				t_AST = astFactory.create(t);
				astFactory.addASTChild(currentAST, t_AST);
				bShouldFire=aboutToEnter(bShouldFire,"index_name",1,5652);
				match(ID);
				if ( inputState.guessing==0 ) {
					t_AST.setType(INDEX_NAME);
				}
				index_name_AST = (AST)currentAST.root;
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_45);
				} else {
				  throw ex;
				}
			}
			returnAST = index_name_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void tableitemdef() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("tableitemdef");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST tableitemdef_AST = null;
			AST cdef_AST = null;
			AST pkcn_AST = null;
			AST pkce_AST = null;
			AST fkcn_AST = null;
			AST fktn_AST = null;
			AST fkrcn_AST = null;
			AST ce_AST = null;
			
			try {      // for error handling
				switch ( LA(1)) {
				case ID:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",1,5696);
					columndef();
					cdef_AST = (AST)returnAST;
					if ( inputState.guessing==0 ) {
						tableitemdef_AST = (AST)currentAST.root;
						tableitemdef_AST=cdef_AST;
						currentAST.root = tableitemdef_AST;
						currentAST.child = tableitemdef_AST!=null &&tableitemdef_AST.getFirstChild()!=null ?
							tableitemdef_AST.getFirstChild() : tableitemdef_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case PRIMARY:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",2,5711);
					match(PRIMARY);
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",3,5713);
					match(KEY);
					{
					switch ( LA(1)) {
					case ID:
					{
						bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",4,5719);
						column_name();
						pkcn_AST = (AST)returnAST;
						if ( inputState.guessing==0 ) {
							tableitemdef_AST = (AST)currentAST.root;
							tableitemdef_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SINGLE_PRIMARY_KEY,"SINGLE_PRIMARY_KEY")).add(pkcn_AST));
							currentAST.root = tableitemdef_AST;
							currentAST.child = tableitemdef_AST!=null &&tableitemdef_AST.getFirstChild()!=null ?
								tableitemdef_AST.getFirstChild() : tableitemdef_AST;
							currentAST.advanceChildToEnd();
						}
						break;
					}
					case LB:
					{
						bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",5,5734);
						column_elements();
						pkce_AST = (AST)returnAST;
						if ( inputState.guessing==0 ) {
							tableitemdef_AST = (AST)currentAST.root;
							tableitemdef_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMBO_PRIMARY_KEY,"COMBO_PRIMARY_KEY")).add(pkce_AST));
							currentAST.root = tableitemdef_AST;
							currentAST.child = tableitemdef_AST!=null &&tableitemdef_AST.getFirstChild()!=null ?
								tableitemdef_AST.getFirstChild() : tableitemdef_AST;
							currentAST.advanceChildToEnd();
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case FOREIGN:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",6,5757);
					match(FOREIGN);
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",7,5759);
					match(KEY);
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",8,5761);
					column_name();
					fkcn_AST = (AST)returnAST;
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",9,5764);
					match(REFERENCES);
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",10,5766);
					table_name();
					fktn_AST = (AST)returnAST;
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",11,5769);
					match(LB);
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",12,5771);
					column_name();
					fkrcn_AST = (AST)returnAST;
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",13,5774);
					match(RB);
					if ( inputState.guessing==0 ) {
						tableitemdef_AST = (AST)currentAST.root;
						tableitemdef_AST=(AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(FOREIGN_KEY,"FOREIGN_KEY")).add(fkcn_AST).add(fktn_AST).add(fkrcn_AST));
						currentAST.root = tableitemdef_AST;
						currentAST.child = tableitemdef_AST!=null &&tableitemdef_AST.getFirstChild()!=null ?
							tableitemdef_AST.getFirstChild() : tableitemdef_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case UNIQUE:
				{
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",14,5788);
					match(UNIQUE);
					bShouldFire=aboutToEnter(bShouldFire,"tableitemdef",15,5790);
					column_elements();
					ce_AST = (AST)returnAST;
					if ( inputState.guessing==0 ) {
						tableitemdef_AST = (AST)currentAST.root;
						tableitemdef_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNIQUE_DEF,"UNIQUE_DEF")).add(ce_AST));
						currentAST.root = tableitemdef_AST;
						currentAST.child = tableitemdef_AST!=null &&tableitemdef_AST.getFirstChild()!=null ?
							tableitemdef_AST.getFirstChild() : tableitemdef_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_8);
				} else {
				  throw ex;
				}
			}
			returnAST = tableitemdef_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void notnull() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("notnull");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST notnull_AST = null;
			
			try {      // for error handling
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				bShouldFire=aboutToEnter(bShouldFire,"notnull",1,5838);
				match(NOT);
				AST tmp176_AST = null;
				tmp176_AST = astFactory.create(LT(1));
				bShouldFire=aboutToEnter(bShouldFire,"notnull",2,5842);
				match(NULL);
				if ( inputState.guessing==0 ) {
					notnull_AST = (AST)currentAST.root;
					notnull_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(NOTNULL,"NOTNULL")));
					currentAST.root = notnull_AST;
					currentAST.child = notnull_AST!=null &&notnull_AST.getFirstChild()!=null ?
						notnull_AST.getFirstChild() : notnull_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_46);
				} else {
				  throw ex;
				}
			}
			returnAST = notnull_AST;
		} finally { // debugging
			exitRule();
		}
	}
	
	public final void columndef() throws RecognitionException, TokenStreamException {
		
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		enterRule("columndef");
		try { // debugging
			returnAST = null;
			ASTPair currentAST = new ASTPair();
			AST columndef_AST = null;
			AST cn_AST = null;
			AST dt_AST = null;
			AST nn_AST = null;
			AST defexpr_AST = null;
			
			try {      // for error handling
				bShouldFire=aboutToEnter(bShouldFire,"columndef",1,5884);
				column_name();
				cn_AST = (AST)returnAST;
				bShouldFire=aboutToEnter(bShouldFire,"columndef",2,5887);
				datatype();
				dt_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case NOT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"columndef",3,5894);
					notnull();
					nn_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case DEFAULT:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case DEFAULT:
				{
					bShouldFire=aboutToEnter(bShouldFire,"columndef",4,5925);
					match(DEFAULT);
					bShouldFire=aboutToEnter(bShouldFire,"columndef",5,5927);
					expr();
					defexpr_AST = (AST)returnAST;
					break;
				}
				case EOF:
				case CREATE:
				case DROP:
				case ALTER:
				case SHOW:
				case SELECT:
				case DELETE:
				case INSERT:
				case UPDATE:
				case SEMI:
				case COMMA:
				case RB:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( inputState.guessing==0 ) {
					columndef_AST = (AST)currentAST.root;
					columndef_AST=(AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(COLUMN_DEF,"COLUMN_DEF")).add(cn_AST).add(dt_AST).add(nn_AST).add(defexpr_AST));
					currentAST.root = columndef_AST;
					currentAST.child = columndef_AST!=null &&columndef_AST.getFirstChild()!=null ?
						columndef_AST.getFirstChild() : columndef_AST;
					currentAST.advanceChildToEnd();
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_47);
				} else {
				  throw ex;
				}
			}
			returnAST = columndef_AST;
		} finally { // debugging
			exitRule();
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
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 16888498611039232L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 16888498611039234L, 0L, 32L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 16888498611039234L, 0L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 2340745906334219266L, 3790750512L, 3552L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 16888498611039234L, 1073741824L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 2556918688449047554L, 94575594875065205L, 1152921504354140064L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 0L, 0L, 256L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 0L, 0L, 384L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 2556918688447998978L, 94575594875065205L, 256928L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 16888498611039234L, 2147483652L, 32L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 16888498611039234L, 2697068592L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 16888498611039234L, 549584944L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 16888498611039234L, 2147483652L, 160L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 0L, 0L, 512L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { -3710966092953223056L, 503331850L, 253499456L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 5512405943901552752L, 234896394L, 253495360L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 5529294442512591986L, 2382380046L, 268180704L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { -3622020000304206734L, 94575594825661646L, -1152921504338411552L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 16888498611039234L, 536870912L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 5512405943901552752L, 503331850L, 253499456L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 5512405943901552752L, 234896394L, 253499456L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 16888498611039234L, 2697068596L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 16888498611039234L, 549584928L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 16888498611039234L, 549584896L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 16888498611039234L, 549453824L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = { 16888498611039234L, 545259520L, 288L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 16888498611039234L, 2697068596L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 2322731507824733186L, 2700231476L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 2305843009213693952L, 3146496L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 16888498611039234L, 2697068592L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 2322731507824733186L, 2700231472L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 2322731507824733186L, 2700215088L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 0L, 0L, 2112L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 16888498611039234L, 549584928L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 16888498611039234L, 549453824L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 2394789101862661122L, 2700280624L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 2556918688447998978L, 94575594875065205L, 1043360L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { 2556918688447998978L, 94575594875065205L, 7338912L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 2556918688447998978L, 94575594875065205L, 15727520L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = { 2556918688447998978L, 94575594875065205L, 15728544L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = { 4899916394579099648L, 67111936L, 2048L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { 65648L, 134225928L, 251658240L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = { 0L, 0L, 64L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 16888498611104770L, 4096L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = { 16888498611039234L, 16384L, 32L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = { 16888498611104770L, 0L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = { 16888498611039234L, 0L, 416L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	
	}
