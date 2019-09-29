// $ANTLR : "sqlparser.g" -> "SQLLexer.java"$

	package com.cownew.cownewsql.ast.grammar;
	import com.cownew.cownewsql.ast.node.*;
	import com.cownew.cownewsql.ast.node.enumdef.*;
	import com.cownew.cownewsql.ast.node.expr.*;
	import com.cownew.cownewsql.ast.node.item.*;
	import com.cownew.cownewsql.ast.node.stmt.*;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.antlrStudio.ASDebugCharScanner;
import antlr.InputBuffer;
import antlr.antlrStudio.DebuggingByteBuffer;
import antlr.antlrStudio.DebuggingCharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.antlrStudio.DebugLexerSharedInputState;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class SQLLexer extends antlr.antlrStudio.ASDebugCharScanner implements SQLParserTokenTypes, TokenStream
 {
public SQLLexer(InputStream in) {
	this(new DebuggingByteBuffer(in));
}
public SQLLexer(Reader in) {
	this(new antlr.antlrStudio.DebuggingCharBuffer(in));
}
public SQLLexer(InputBuffer ib) {
	this(new antlr.antlrStudio.DebugLexerSharedInputState(ib));
}
public SQLLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = false;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("blob", this), new Integer(172));
	literals.put(new ANTLRHashString("rownum", this), new Integer(87));
	literals.put(new ANTLRHashString("tinytext", this), new Integer(180));
	literals.put(new ANTLRHashString("smallint", this), new Integer(159));
	literals.put(new ANTLRHashString("between", this), new Integer(118));
	literals.put(new ANTLRHashString("time", this), new Integer(171));
	literals.put(new ANTLRHashString("tinyint", this), new Integer(158));
	literals.put(new ANTLRHashString("delete", this), new Integer(51));
	literals.put(new ANTLRHashString("timestamp", this), new Integer(170));
	literals.put(new ANTLRHashString("limit", this), new Integer(86));
	literals.put(new ANTLRHashString("insert", this), new Integer(52));
	literals.put(new ANTLRHashString("distinct", this), new Integer(63));
	literals.put(new ANTLRHashString("binary", this), new Integer(175));
	literals.put(new ANTLRHashString("where", this), new Integer(95));
	literals.put(new ANTLRHashString("alter", this), new Integer(13));
	literals.put(new ANTLRHashString("varbinary", this), new Integer(176));
	literals.put(new ANTLRHashString("integer", this), new Integer(157));
	literals.put(new ANTLRHashString("decimal", this), new Integer(163));
	literals.put(new ANTLRHashString("select", this), new Integer(50));
	literals.put(new ANTLRHashString("and", this), new Integer(56));
	literals.put(new ANTLRHashString("outer", this), new Integer(79));
	literals.put(new ANTLRHashString("float", this), new Integer(166));
	literals.put(new ANTLRHashString("not", this), new Integer(76));
	literals.put(new ANTLRHashString("numeric", this), new Integer(164));
	literals.put(new ANTLRHashString("date", this), new Integer(169));
	literals.put(new ANTLRHashString("longblob", this), new Integer(174));
	literals.put(new ANTLRHashString("key", this), new Integer(19));
	literals.put(new ANTLRHashString("from", this), new Integer(66));
	literals.put(new ANTLRHashString("null", this), new Integer(77));
	literals.put(new ANTLRHashString("real", this), new Integer(165));
	literals.put(new ANTLRHashString("count", this), new Integer(62));
	literals.put(new ANTLRHashString("add", this), new Integer(12));
	literals.put(new ANTLRHashString("like", this), new Integer(120));
	literals.put(new ANTLRHashString("inner", this), new Integer(72));
	literals.put(new ANTLRHashString("text", this), new Integer(182));
	literals.put(new ANTLRHashString("set", this), new Integer(88));
	literals.put(new ANTLRHashString("foreign", this), new Integer(18));
	literals.put(new ANTLRHashString("join", this), new Integer(73));
	literals.put(new ANTLRHashString("nchar", this), new Integer(185));
	literals.put(new ANTLRHashString("is", this), new Integer(70));
	literals.put(new ANTLRHashString("nclob", this), new Integer(187));
	literals.put(new ANTLRHashString("or", this), new Integer(80));
	literals.put(new ANTLRHashString("any", this), new Integer(59));
	literals.put(new ANTLRHashString("create", this), new Integer(10));
	literals.put(new ANTLRHashString("double", this), new Integer(167));
	literals.put(new ANTLRHashString("min", this), new Integer(75));
	literals.put(new ANTLRHashString("as", this), new Integer(54));
	literals.put(new ANTLRHashString("by", this), new Integer(60));
	literals.put(new ANTLRHashString("tables", this), new Integer(188));
	literals.put(new ANTLRHashString("all", this), new Integer(55));
	literals.put(new ANTLRHashString("union", this), new Integer(93));
	literals.put(new ANTLRHashString("drop", this), new Integer(11));
	literals.put(new ANTLRHashString("order", this), new Integer(81));
	literals.put(new ANTLRHashString("primary", this), new Integer(17));
	literals.put(new ANTLRHashString("some", this), new Integer(89));
	literals.put(new ANTLRHashString("longtext", this), new Integer(181));
	literals.put(new ANTLRHashString("show", this), new Integer(23));
	literals.put(new ANTLRHashString("functions", this), new Integer(190));
	literals.put(new ANTLRHashString("values", this), new Integer(94));
	literals.put(new ANTLRHashString("int", this), new Integer(156));
	literals.put(new ANTLRHashString("tinyblob", this), new Integer(173));
	literals.put(new ANTLRHashString("boolean", this), new Integer(161));
	literals.put(new ANTLRHashString("cross", this), new Integer(61));
	literals.put(new ANTLRHashString("char", this), new Integer(184));
	literals.put(new ANTLRHashString("varchar", this), new Integer(162));
	literals.put(new ANTLRHashString("bit", this), new Integer(160));
	literals.put(new ANTLRHashString("functioncolumns", this), new Integer(191));
	literals.put(new ANTLRHashString("index", this), new Integer(15));
	literals.put(new ANTLRHashString("default", this), new Integer(16));
	literals.put(new ANTLRHashString("clob", this), new Integer(179));
	literals.put(new ANTLRHashString("false", this), new Integer(67));
	literals.put(new ANTLRHashString("exists", this), new Integer(65));
	literals.put(new ANTLRHashString("table", this), new Integer(14));
	literals.put(new ANTLRHashString("asc", this), new Integer(57));
	literals.put(new ANTLRHashString("left", this), new Integer(85));
	literals.put(new ANTLRHashString("desc", this), new Integer(64));
	literals.put(new ANTLRHashString("nvarchar", this), new Integer(186));
	literals.put(new ANTLRHashString("longvarbinary", this), new Integer(177));
	literals.put(new ANTLRHashString("max", this), new Integer(74));
	literals.put(new ANTLRHashString("sum", this), new Integer(90));
	literals.put(new ANTLRHashString("datetime", this), new Integer(168));
	literals.put(new ANTLRHashString("on", this), new Integer(78));
	literals.put(new ANTLRHashString("image", this), new Integer(178));
	literals.put(new ANTLRHashString("longvarchar", this), new Integer(183));
	literals.put(new ANTLRHashString("top", this), new Integer(92));
	literals.put(new ANTLRHashString("into", this), new Integer(71));
	literals.put(new ANTLRHashString("right", this), new Integer(84));
	literals.put(new ANTLRHashString("in", this), new Integer(116));
	literals.put(new ANTLRHashString("avg", this), new Integer(58));
	literals.put(new ANTLRHashString("update", this), new Integer(53));
	literals.put(new ANTLRHashString("true", this), new Integer(91));
	literals.put(new ANTLRHashString("group", this), new Integer(68));
	literals.put(new ANTLRHashString("having", this), new Integer(69));
	literals.put(new ANTLRHashString("column", this), new Integer(22));
	literals.put(new ANTLRHashString("tablecolumns", this), new Integer(189));
	literals.put(new ANTLRHashString("unique", this), new Integer(21));
	literals.put(new ANTLRHashString("references", this), new Integer(20));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '=':
				{
					mEQUAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mCONCAT(true);
					theRetToken=_returnToken;
					break;
				}
				case '.':
				{
					mDOT(true);
					theRetToken=_returnToken;
					break;
				}
				case '+':
				{
					mPLUS(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mCONST_STRING(true);
					theRetToken=_returnToken;
					break;
				}
				case '{':
				{
					mDATE(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mLB(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mRB(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':
				{
					mSTAR(true);
					theRetToken=_returnToken;
					break;
				}
				case '%':
				{
					mMOD(true);
					theRetToken=_returnToken;
					break;
				}
				case '?':
				{
					mQ_MARK(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case ' ':
				{
					mBLANK(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='>') && (LA(2)=='=')) {
						mGR_EQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='=') && (true)) {
						mLE_EQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!'||LA(1)=='<') && (LA(2)=='='||LA(2)=='>') && (true)) {
						mNOT_EQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='0') && (LA(2)=='x')) {
						mNUM_HEX(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='n') && (LA(2)=='\'')) {
						mN_CONST_STRING(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='*')) {
						mM_COMM(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-'||LA(1)=='/') && (LA(2)=='-'||LA(2)=='/')) {
						mS_COMM(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (true)) {
						mGREATER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (true)) {
						mLESS(true);
						theRetToken=_returnToken;
					}
					else if (((LA(1) >= '0' && LA(1) <= '9')) && (true)) {
						mNUMBER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (true)) {
						mSUB(true);
						theRetToken=_returnToken;
					}
					else if (((LA(1) >= 'a' && LA(1) <= 'z')) && (true)) {
						mID(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (true)) {
						mDIV(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mEQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"EQUAL",1,340);
			match('=');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mGREATER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATER;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"GREATER",1,361);
			match('>');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mLESS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESS;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"LESS",1,382);
			match('<');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mGR_EQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GR_EQ;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"GR_EQ",1,403);
			match(">=");
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mLE_EQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LE_EQ;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"LE_EQ",1,424);
			match("<=");
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mNOT_EQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EQ;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			switch ( LA(1)) {
			case '!':
			{
				bShouldFire=aboutToEnter(bShouldFire,"NOT_EQ",1,448);
				match("!=");
				break;
			}
			case '<':
			{
				bShouldFire=aboutToEnter(bShouldFire,"NOT_EQ",2,454);
				match("<>");
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mCONCAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CONCAT;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"CONCAT",1,482);
			match("||");
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mNUMBER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUMBER;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			_ttype = NUM_INT;
			
			{
			bShouldFire=aboutToEnter(bShouldFire,"NUMBER",1,505);
			matchRange('0','9');
			{
			_loop368:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					bShouldFire=aboutToEnter(bShouldFire,"NUMBER",2,511);
					matchRange('0','9');
				}
				else {
					break _loop368;
				}
				
			} while (true);
			}
			}
			{
			if ((LA(1)=='.')) {
				bShouldFire=aboutToEnter(bShouldFire,"NUMBER",3,523);
				mDOT(false);
				{
				int _cnt371=0;
				_loop371:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						bShouldFire=aboutToEnter(bShouldFire,"NUMBER",4,530);
						matchRange('0','9');
					}
					else {
						if ( _cnt371>=1 ) { break _loop371; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt371++;
				} while (true);
				}
				_ttype = NUM_FLOAT;
			}
			else {
			}
			
			}
			{
			if ((LA(1)=='e')) {
				bShouldFire=aboutToEnter(bShouldFire,"NUMBER",5,548);
				match('e');
				{
				switch ( LA(1)) {
				case '+':
				{
					bShouldFire=aboutToEnter(bShouldFire,"NUMBER",6,554);
					mPLUS(false);
					break;
				}
				case '-':
				{
					bShouldFire=aboutToEnter(bShouldFire,"NUMBER",7,560);
					mSUB(false);
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				int _cnt375=0;
				_loop375:
				do {
					if (((LA(1) >= '0' && LA(1) <= '9'))) {
						bShouldFire=aboutToEnter(bShouldFire,"NUMBER",8,581);
						matchRange('0','9');
					}
					else {
						if ( _cnt375>=1 ) { break _loop375; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
					}
					
					_cnt375++;
				} while (true);
				}
				_ttype = NUM_REAL;
			}
			else {
			}
			
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"DOT",1,616);
			match('.');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"PLUS",1,637);
			match('+');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mSUB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SUB;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"SUB",1,658);
			match('-');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mNUM_HEX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUM_HEX;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"NUM_HEX",1,679);
			match("0x");
			{
			_loop378:
			do {
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					bShouldFire=aboutToEnter(bShouldFire,"NUM_HEX",2,689);
					matchRange('0','9');
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':
				{
					bShouldFire=aboutToEnter(bShouldFire,"NUM_HEX",3,696);
					matchRange('a','f');
					break;
				}
				default:
				{
					break _loop378;
				}
				}
			} while (true);
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mCONST_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CONST_STRING;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"CONST_STRING",1,726);
			mQUOTE(false);
			{
			_loop382:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					{
					match(_tokenSet_0);
					}
				}
				else {
					break _loop382;
				}
				
			} while (true);
			}
			bShouldFire=aboutToEnter(bShouldFire,"CONST_STRING",2,742);
			mQUOTE(false);
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	protected final void mQUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUOTE;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"QUOTE",1,763);
			match('\'');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mDATE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DATE;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"DATE",1,784);
			match("{");
			bShouldFire=aboutToEnter(bShouldFire,"DATE",2,786);
			mCONST_STRING(false);
			bShouldFire=aboutToEnter(bShouldFire,"DATE",3,788);
			match("}");
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mN_CONST_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = N_CONST_STRING;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"N_CONST_STRING",1,809);
			match("n");
			bShouldFire=aboutToEnter(bShouldFire,"N_CONST_STRING",2,811);
			mCONST_STRING(false);
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			{
			bShouldFire=aboutToEnter(bShouldFire,"ID",1,833);
			matchRange('a','z');
			}
			{
			_loop389:
			do {
				switch ( LA(1)) {
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					bShouldFire=aboutToEnter(bShouldFire,"ID",2,848);
					matchRange('a','z');
					break;
				}
				case '_':
				{
					bShouldFire=aboutToEnter(bShouldFire,"ID",3,854);
					match('_');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					bShouldFire=aboutToEnter(bShouldFire,"ID",4,862);
					matchRange('0','9');
					break;
				}
				default:
				{
					break _loop389;
				}
				}
			} while (true);
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"COMMA",1,892);
			match(',');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mLB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LB;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"LB",1,913);
			match('(');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mRB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RB;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"RB",1,934);
			match(')');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"STAR",1,955);
			match('*');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mDIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIV;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"DIV",1,976);
			match('/');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mMOD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MOD;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"MOD",1,997);
			match('%');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mQ_MARK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Q_MARK;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"Q_MARK",1,1018);
			match('?');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"SEMI",1,1039);
			match(';');
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mBLANK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANK;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"BLANK",1,1060);
			match(' ');
			_ttype = Token.SKIP;
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			{
			switch ( LA(1)) {
			case '\t':
			{
				bShouldFire=aboutToEnter(bShouldFire,"WS",1,1086);
				match('\t');
				break;
			}
			case '\r':
			{
				bShouldFire=aboutToEnter(bShouldFire,"WS",2,1092);
				match('\r');
				bShouldFire=aboutToEnter(bShouldFire,"WS",3,1094);
				match('\n');
				newline();
				break;
			}
			case '\n':
			{
				bShouldFire=aboutToEnter(bShouldFire,"WS",4,1101);
				match('\n');
				newline();
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			_ttype = Token.SKIP;
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mM_COMM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = M_COMM;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			bShouldFire=aboutToEnter(bShouldFire,"M_COMM",1,1132);
			match("/*");
			{
			_loop407:
			do {
				// nongreedy exit test
				if ((LA(1)=='*') && (LA(2)=='/') && (true)) break _loop407;
				if ((LA(1)=='\r') && (LA(2)=='\n') && ((LA(3) >= '\u0000' && LA(3) <= '\uffff'))) {
					bShouldFire=aboutToEnter(bShouldFire,"M_COMM",2,1140);
					match('\r');
					bShouldFire=aboutToEnter(bShouldFire,"M_COMM",3,1142);
					match('\n');
					newline();
				}
				else if ((LA(1)=='\r') && ((LA(2) >= '\u0000' && LA(2) <= '\uffff')) && ((LA(3) >= '\u0000' && LA(3) <= '\uffff'))) {
					bShouldFire=aboutToEnter(bShouldFire,"M_COMM",4,1147);
					match('\r');
					newline();
				}
				else if ((_tokenSet_1.member(LA(1))) && ((LA(2) >= '\u0000' && LA(2) <= '\uffff')) && ((LA(3) >= '\u0000' && LA(3) <= '\uffff'))) {
					{
					match(_tokenSet_1);
					}
				}
				else if ((LA(1)=='\n')) {
					bShouldFire=aboutToEnter(bShouldFire,"M_COMM",5,1157);
					match('\n');
					newline();
				}
				else {
					break _loop407;
				}
				
			} while (true);
			}
			bShouldFire=aboutToEnter(bShouldFire,"M_COMM",6,1167);
			match("*/");
			_ttype = Token.SKIP;
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	public final void mS_COMM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = S_COMM;
		int _saveIndex;
		boolean bShouldFire=false;
		if(_as_beginStep==true){
		_as_beginStep=false;  bShouldFire=true;
		}
		try { // debugging
			
			{
			switch ( LA(1)) {
			case '/':
			{
				bShouldFire=aboutToEnter(bShouldFire,"S_COMM",1,1193);
				match("//");
				break;
			}
			case '-':
			{
				bShouldFire=aboutToEnter(bShouldFire,"S_COMM",2,1199);
				match("--");
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			{
			_loop412:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					{
					match(_tokenSet_1);
					}
				}
				else {
					break _loop412;
				}
				
			} while (true);
			}
			{
			if ((LA(1)=='\n'||LA(1)=='\r')) {
				{
				switch ( LA(1)) {
				case '\n':
				{
					bShouldFire=aboutToEnter(bShouldFire,"S_COMM",3,1229);
					match('\n');
					break;
				}
				case '\r':
				{
					bShouldFire=aboutToEnter(bShouldFire,"S_COMM",4,1235);
					match('\r');
					{
					if ((LA(1)=='\n')) {
						bShouldFire=aboutToEnter(bShouldFire,"S_COMM",5,1239);
						match('\n');
					}
					else {
					}
					
					}
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				newline();
			}
			else {
			}
			
			}
			_ttype = Token.SKIP;
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		} finally { // debugging
		}
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[2048];
		data[0]=-549755813889L;
		for (int i = 1; i<=1023; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[2048];
		data[0]=-9217L;
		for (int i = 1; i<=1023; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
