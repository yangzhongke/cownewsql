header {
	package com.cownew.cownewsql.ast.grammar;
	import com.cownew.cownewsql.ast.node.*;
	import com.cownew.cownewsql.ast.node.enumdef.*;
	import com.cownew.cownewsql.ast.node.expr.*;
	import com.cownew.cownewsql.ast.node.item.*;
	import com.cownew.cownewsql.ast.node.stmt.*;
}


/**
 * CowNew SQLParser Grammar
 * 
 * @author King Chou (kingchou.pro@gmail.com)
 */
class SQLParser extends Parser;
options{
	buildAST=true;
	k=3;
}

tokens{
	
	NUM_FLOAT;
	NUM_INT;
	NUM_REAL;
	BOOLEAN;
	
	CONSTANT;
	
	STATEMENTS;
	
	//ddl by yangzk
	CREATE = "create";
	DROP = "drop";
	ADD = "add";
	ALTER = "alter";
	TABLE = "table";
	INDEX="index";
	DEFAULT = "default";
	PRIMARY = "primary";
	FOREIGN = "foreign";
	KEY = "key";
	REFERENCES = "references";
	UNIQUE = "unique";
	COLUMN = "column";
	
	SHOW="show";
	
	NOTNULL;	
	INDEX_NAME;	
	
	TYPE_INT;
	TYPE_VARCHAR;
	TYPE_NVARCHAR;
	TYPE_CHAR;
	TYPE_NCHAR;
	TYPE_DECIMAL;
	TYPE_DATETIME;
	TYPE_BLOB;
	TYPE_CLOB;
	TYPE_NCLOB;
	
	COLUMN_DEF;
	SINGLE_PRIMARY_KEY;
	COMBO_PRIMARY_KEY;
	
	FOREIGN_KEY;
	UNIQUE_DEF;
	CREATE_INDEX;
	CREATE_TABLE;
	DROP_TABLE;
	DROP_INDEX;
	
	SHOW_TABLES;
	SHOW_TABLECOLUMNS;
	SHOW_FUNCTIONS;
	SHOW_FUNCTIONCOLUMNS;
	
	ALTERTABLE_ADD_COLUMNS;
	
	
	//statement
	SELECT="select";
	DELETE="delete";
	INSERT="insert";
	UPDATE="update";
	
	AS="as";
	ALL="all";
	AND="and";
	ASC="asc";
	AVG="avg";
	ANY="any";
	BY="by";
	CROSS="cross";
	COUNT="count";
	DISTINCT="distinct";
	DESC="desc";
	EXISTS="exists";
	FROM="from";
	FALSE="false";
	GROUP="group";
	HAVING="having";
	IS="is";
	INTO="into";
	INNER="inner";
	JOIN="join";
	MAX="max";
	MIN="min";
	NOT="not";
	NULL="null";
	ON="on";
	OUTER="outer";
	OR="or";
	ORDER="order";
	ORDER_BY_ELEMENT;
	ORDER_TYPE;
	RIGHT="right";
	LEFT="left";
	LIMIT="limit";
	ROWNUM="rownum";
	SET="set";
	SOME="some";
	SUM="sum";
	TRUE="true";
	TOP="top";
	
	UNION="union";
	VALUES="values";
	WHERE="where";
	IN_LIST;

	
	 
	//element--tree marks
	ALIAS_NAME;
	AGGREGATE_TYPE;
	
	ALL_COLUMNS; 
	 
	TABLE_ELEMENT;
	TABLE_NAME;
	COLUMN_ELEMENTS;
	COLUMN_ELEMENT;
	COLUMN_NAME;
	VALUE_ELEMENTS;
	TOP_ELEMENT;
	//clause--tree marks
	SET_CLAUSE;
	WHERE_CLAUSE;
	FROM_CLAUSE;
	GROUP_BY_CLAUSE;
	HAVING_CLAUSE;
	ORDER_BY_CLAUSE;
	//optional--tree marks
	LIMIT_OPTIONAL;
	ROWNUM_OPTIONAL;
	 
	//search condition
	SEARCH_CONDITION;
	IN="in";//in
	NOT_IN;//not in
	BETWEEN="between";//between
	NOT_BETWEEN;//not between
	LIKE="like";//like
	NOT_LIKE;//not like
	IS_NOT;//is not 
	UNARY_MINUS;//unary -
	UNARY_PLUS;//unary +
	//function
	FUNCTION;
	FUNCTION_PARAMETERS;
	//join type
	JOIN_TABLE;
	
	DEFULT_JOIN;
	INNER_JOIN;
	CROSS_JOIN;
	LEFT_JOIN;
	RIGHT_JOIN;
}

startRule
	//single SQL or multi SQL,separated by ';',the last ';'can be ignored.
	:(statement (SEMI!)?)*{##=#([STATEMENTS,"STATEMENTS"],##);};

statement
	:selectStatement|insertStatement|updateStatement|deleteStatement
	|createTableStatement|createIndexStatement|dropTableStatement
	|dropIndexStatement|showStatement|alterTableStatement
	;

insertStatement!
	:i:INSERT! INTO!  n:table_name (c:column_elements)? (v:value_elements|s:selectStatement)
	{
		##=#([INSERT,"INSERT"],#n,#c,#v,#s);
	};

column_elements!
	:c:column_elements2{##=#([COLUMN_ELEMENTS,"COLUMN_ELEMENTS"],#c);};
column_elements2
	:LB! column_name(COMMA! column_name)* RB!;

value_elements!
	:VALUES! LB! v:value_elements2 RB!{##=#([VALUE_ELEMENTS,"VALUE_ELEMENTS"],#v);};
value_elements2
	:value_element(COMMA! value_element)*;
value_element
//omit the NULL ,"value" and NULL.
	:expr;


//
//update statement
//
updateStatement!
	:u:UPDATE! t:table_name s:set_clause (f:from_clause)?(w:where_clause)?
	//:u:UPDATE! t:table_element s:set_clause (f:from_clause)?(w:where_clause)?
	{
		##=#([UPDATE,"UPDATE"],#t,#s,#f,#w);	
	}
	;
set_clause!
	:SET! s:set_elements {##=#([SET_CLAUSE,"SET_CLAUSE"],#s);}
	;
set_elements
	:set_element (COMMA! set_element)*
	;
set_element
	:set_element_left EQUAL^ set_element_right
	;
set_element_left
	:l:column_name(DOT^ r:ID{#l.setType(TABLE_NAME);#r.setType(COLUMN_NAME);})? //t2.columnname
	;
set_element_right
	:(LB SELECT)=>LB! selectStatement RB!|expr;

deleteStatement!
	:d:DELETE! (STAR!)? FROM!  t:table_name (w:where_clause)? 
	{
		##=#([DELETE,"DELETE"],#t,#w);
	};

selectStatement!
	:sl:selectStatement_without_union {##=#sl;}
	((u1:UNION (a1:ALL)? sr:selectStatement_without_union)
		{
			#u1=#([UNION,"UNION"],#a1,#sr);
			##.addChild(#u1);
			
		}
		(u2:UNION (a2:ALL)? sr2:selectStatement_without_union
		{
			#u2=#([UNION,"UNION"],#a2,#sr2);
			#sr.addChild(#u2);
			#sr=#sr2;
		}
		)*
	)?
	
	;

selectStatement_without_union!
	:se:SELECT! (a:aggregate_type)?(t:top_element)?  s:select_elements (f:from_clause)? (w:where_clause)? (g:group_by_clause)?   (h:having_clause)?  (o:order_by_clause)? (l:limit_optional)? (r:rownum_optional)?
	{
		##=#([SELECT,"SELECT"],#a,#t,#([COLUMN_ELEMENTS,"COLUMN_ELEMENTS"],#s),#f,#w,#g,#h,#o,#l,#r);
	}
	;


aggregate_type!
	:(d:DISTINCT)
	{
		##=#([AGGREGATE_TYPE,"AGGREGATE_TYPE"],#d);
	}
	;
top_element!
	:TOP! i:NUM_INT
	{##=#([TOP_ELEMENT,"TOP_ELEMENT"],#i);}
	;
select_elements
	:
	(star:STAR{#star.setType(ALL_COLUMNS);##=#([COLUMN_ELEMENT,"COLUMN_ELEMENT"],#star);})
	|(column_element(COMMA! column_element)*)
	;
column_element!
	:el:expr((AS!)? al:alias_name)? 
	{
		##=#([COLUMN_ELEMENT,"COLUMN_ELEMENT"],#el,#al);
	}
	;
column_name
	:c:ID
	{#c.setType(COLUMN_NAME);} 
	;


alias_name
	:a:ID{#a.setType(ALIAS_NAME);}
	;
//from clause
from_clause!
	:FROM! t:table_elements{##=#([FROM_CLAUSE,"FROM_CLAUSE"],#t);}
	
	;
table_elements
	:table_source(COMMA! table_source)*	
	;
table_source!
	:t:table_element {##=#([TABLE_ELEMENT,"TABLE_ELEMENT"],#t);}
	((j:joined_table{##.addChild(#j);})(j2:joined_table{#j.addChild(#j2);#j=#j2;})*)?
	;
joined_table!
	// "ON" clause can be ignored when "CROSS JOIN",eg:select lastname from lastname CROSS JOIN firstanme
	:j:joined_type t:table_element (ON! s:search_condition)?
	{##=#([JOIN_TABLE,"JOIN_TABLE"],#j,#([TABLE_ELEMENT,"TABLE_ELEMENT"],#t),#s);}
	;
joined_type!
	:{##=#[DEFULT_JOIN,"DEFULT_JOIN"];}//select * from t join t1 on t1.id=t2.id
	(
		//not support NATURAL JOIN
		INNER^{##=#[INNER_JOIN,"INNER_JOIN"];}
		|CROSS^{##=#[CROSS_JOIN,"CROSS_JOIN"];}
		|(
			LEFT^{##=#[LEFT_JOIN,"LEFT_JOIN"];}
			|RIGHT^{##=#[RIGHT_JOIN,"RIGHT_JOIN"];}
		 )(OUTER!)?//"left join" and "left outer join" is the same,"left inner join" is invalid
	)? JOIN!
	;
table_element
	:(table_name|(LB! selectStatement RB!)|(LB! showStatement RB!))((AS!)? alias_name)?
	;
table_name 
	:t:ID{#t.setType(TABLE_NAME);}
	;
//where clause
where_clause!
	:WHERE! s:search_condition2{##=#([WHERE_CLAUSE,"WHERE_CLAUSE"],#s);}
	;



//group by clause
group_by_clause!
	:GROUP! BY! g:group_by_elements {##=#([GROUP_BY_CLAUSE,"GROUP_BY_CLAUSE"],#g);}
	;
group_by_elements
	:group_by_element (COMMA! group_by_element)*
	;
group_by_element
	:e:expr//{##=#(#[COLUMN_ELEMENT],#e);}
	;

//having clause
having_clause!
	:HAVING! s:search_condition2{##=#([HAVING_CLAUSE,"HAVING_CLAUSE"],#s);}
	;

//order by clause
order_by_clause!
	:ORDER! BY! o:order_by_elements{##=#([ORDER_BY_CLAUSE,"ORDER_BY_CLAUSE"],#o);}
	;
order_by_elements
	:order_by_element (COMMA! order_by_element)*
	;
order_by_element!
	:cl:expr{##=#([ORDER_BY_ELEMENT,"ORDER_BY_ELEMENT"],#cl);} (ol:order_type{##.addChild(#ol);})?
	;
order_type
	:(ASC|DESC)
	;
//optional

limit_optional!
	:LIMIT! l:NUM_INT (COMMA! r:NUM_INT)?{##=#([LIMIT_OPTIONAL,"LIMIT_OPTIONAL"],#l,#r);}
	;
rownum_optional!
	:ROWNUM! LESS! EQUAL! i:NUM_INT {##=#([ROWNUM_OPTIONAL,"ROWNUM_OPTIONAL"],#i);}
	;

//search condition
search_condition
	:s:search_condition2
	{##=#([SEARCH_CONDITION,"SEARCH_CONDITION"],#s);}
	;
search_condition2
	:equation ((OR^|AND^)equation)*
	;
equation
	:ex:expr 
	((EQUAL^|GREATER^|LESS^|LE_EQ^|GR_EQ^|NOT_EQ^) expr//name="king" age>24
	| (n:NOT!)? (
			in:IN^{if(#n==null)	 #in.setType(IN); else #in.setType(NOT_IN); } 
			LB!(
				 selectStatement //name in (select ....)
				 |in_list//name in ("king","yang")
				)RB!
			|be:BETWEEN^ expr AND! expr{if(#n==null)#be.setType(BETWEEN); else #be.setType(NOT_BETWEEN);}//age between 20 and 24
			|li:LIKE^ expr{if(#n==null)#li.setType(LIKE); else #li.setType(NOT_LIKE);} //name like "king"
			)
	| is:IS^ (isnot:NOT!)? nu:NULL
	{if(#isnot==null) #is.setType(IS);else #is.setType(IS_NOT);}//name is null
	)?

	;
in_list!
	:i:in_list2{##=#([IN_LIST,"IN_LIST"],#i);}
	;
in_list2
	:(expr)(COMMA! expr)*
	;
exists
	:(NOT^)? (exists_)
	;
exists_
	:EXISTS^ LB! selectStatement RB!
	;
any_some_all
	:(ANY^|SOME^|ALL^)LB! selectStatement RB!
	;
//expression
expr//(22+33)*48+(SUM(column)+...)...
	:mul_div ((PLUS^|SUB^) mul_div)*
	|exists
	|any_some_all|Q_MARK
	;
mul_div
	:concat ((STAR^|DIV^|MOD^) concat)*
	;
concat
	:dot (CONCAT^ dot)* //"string"||"string"
	;
dot
	:l:item(DOT^ r:item{#l.setType(TABLE_NAME);#r.setType(COLUMN_NAME);})? //t2.columnname
	;
item
	:(p:PLUS!|s:SUB!)?
	(column_name
	|function
	|c:constant{
		boolean isSub=false;
		
		if(#s!=null){
			isSub=true;
			if(#c.getType()==NUM_INT||#c.getType()==NUM_FLOAT||#c.getType()==NUM_REAL){
				if(isSub)#c.setText("-"+#c.getText());
			}
		}
		}
	|(LB! search_condition2 RB!)
	|(LB! selectStatement  RB!)//select (select 1)+2,(select top 1 from t).id
	);

//function
function!
//SUM(column)..... not contain all functions
	:fn:function_name LB! (fp:function_parameters)? RB!
	{##=#([FUNCTION,"FUNCTION"],#fn,#([FUNCTION_PARAMETERS,"FUNCTION_PARAMETERS"],#fp));}
	;
function_parameters
	//count(*)
	:(expr (COMMA! expr)*)|STAR{##.setType(ALL_COLUMNS);}
	;

function_name//only define the sum function.
	:AVG|COUNT|MAX|MIN|SUM|ID
	;

constant
	:CONST_STRING
	|N_CONST_STRING
	|NULL
	|DEFAULT
	|NUM_INT
	|NUM_FLOAT
	|NUM_REAL
	|NUM_HEX
	|TRUE{##.setType(BOOLEAN);}|FALSE{##.setType(BOOLEAN);}
	|DATE
	;

//DDL
datatype!:
    //20 is NUM_INT or expr but NUMBER
    ("int"|"integer"|"tinyint"|"smallint"| "bit"| "boolean")
    { ## = #([TYPE_INT, "TYPE_INT"]); }
    
    |("varchar") LB! n:NUM_INT RB!
    { ## = #([TYPE_VARCHAR, "TYPE_VARCHAR"], #n); }
    
    | ("decimal"|"numeric"|"real"|"float"|"double")( LB! len:NUM_INT ( COMMA! prec:NUM_INT ) ? RB! ) ?
    { ## = #([TYPE_DECIMAL, "TYPE_DECIMAL"], #len,#prec); }
    
    | ("datetime"|"date"|"timestamp"|"time")
    { ## = #([TYPE_DATETIME, "TYPE_DATETIME"]); }
    
    | ("blob"|"tinyblob"|"longblob"|"binary"|"varbinary"|"longvarbinary"|"image")
    { ## = #([TYPE_BLOB, "TYPE_BLOB"]); }
    
    | ("clob"|"tinytext"|"longtext"|"text"|"longvarchar")
    { ## = #([TYPE_CLOB, "TYPE_CLOB"]); }
    
    |("char") LB! n2:NUM_INT RB!
    { ## = #([TYPE_CHAR, "TYPE_CHAR"], #n2); }
    
    |("nchar") LB! n3:NUM_INT RB!
    { ## = #([TYPE_NCHAR, "TYPE_NCHAR"], #n3); }
    
    |("nvarchar")
    { ## = #([TYPE_NVARCHAR, "TYPE_NVARCHAR"]); }
    
    |("nclob")
    { ## = #([TYPE_NCLOB, "TYPE_NCLOB"]); }
;

index_name
	:t:ID{#t.setType(INDEX_NAME);}
	;

createTableStatement
	:CREATE! TABLE! table_name LB! tableitemdef (COMMA! tableitemdef)* RB!
	{##=#([CREATE_TABLE,"CREATE_TABLE"],#createTableStatement);};


createIndexStatement!
	:CREATE! INDEX! idxname:index_name ON! tn:table_name ce:column_elements
	{##=#([CREATE_INDEX,"CREATE_INDEX"],#idxname,#tn,#ce);}
	;

notnull!
	:NOT NULL{##=#([NOTNULL,"NOTNULL"]);}
	;

columndef!
	:cn:column_name dt:datatype (nn:notnull)? ( DEFAULT! defexpr:expr ) ?
	{##=#([COLUMN_DEF,"COLUMN_DEF"],#cn,#dt,#nn,#defexpr);}
	;

tableitemdef!
	:cdef:columndef{##=#cdef;}
	|PRIMARY! KEY! (pkcn:column_name{##=#([SINGLE_PRIMARY_KEY,"SINGLE_PRIMARY_KEY"],#pkcn);}
					|pkce:column_elements{##=#([COMBO_PRIMARY_KEY,"COMBO_PRIMARY_KEY"],#pkce);}
					)	
	|FOREIGN! KEY! fkcn:column_name REFERENCES! fktn:table_name LB! fkrcn:column_name RB!
	{##=#([FOREIGN_KEY,"FOREIGN_KEY"],#fkcn,#fktn,#fkrcn);}
	|UNIQUE! ce:column_elements
	{##=#([UNIQUE_DEF,"UNIQUE_DEF"],#ce);}
	;

dropTableStatement!
	:DROP! TABLE! tn:table_name{##=#([DROP_TABLE,"DROP_TABLE"],#tn);};

dropIndexStatement!
	:DROP! INDEX! tn:table_name DOT! idxn:index_name{##=#([DROP_INDEX,"DROP_INDEX"],#tn,#idxn);};

alterTableStatement!
	:ALTER! TABLE! tn:table_name ADD! COLUMN! ace:columndef
	{##=#([ALTERTABLE_ADD_COLUMNS,"ALTERTABLE_ADD_COLUMNS"],#tn,#ace);}
	;

showStatement!
	:SHOW! 
	(
	"tables"! (schema:ID)? {##=#([SHOW_TABLES,"SHOW_TABLES"],#schema);}
	|"tablecolumns"! tn:table_name {##=#([SHOW_TABLECOLUMNS,"SHOW_TABLECOLUMNS"],#tn);}
	|"functions"!{##=#([SHOW_FUNCTIONS,"SHOW_FUNCTIONS"]);}
	|"functioncolumns"!{##=#([SHOW_FUNCTIONCOLUMNS,"SHOW_FUNCTIONCOLUMNS"]);}
	)
	;

class SQLLexer extends Lexer;
options{
	//allow any unicode char
	charVocabulary = '\0'..'\uffff';
	caseSensitive=false;
	caseSensitiveLiterals=false;
	k=3;
}

EQUAL:'=';

GREATER:'>';

LESS:'<';

GR_EQ:">=";

LE_EQ:"<=";

NOT_EQ:"!="|"<>";

CONCAT:"||";

//commom

NUMBER{$setType(NUM_INT);}:
		('0'..'9'('0'..'9')*)
		(DOT ('0'..'9')+ {$setType(NUM_FLOAT);})?
		('e'(PLUS|SUB)?('0'..'9')+{$setType(NUM_REAL);})?;


NUM_HEX:"0x"('0'..'9'|'a'..'f')*;

CONST_STRING:
	QUOTE (~('\''))* QUOTE
;

DATE:"{" CONST_STRING "}";

N_CONST_STRING:"n" CONST_STRING;

protected
QUOTE:'\'';

ID:('a'..'z')('a'..'z'|'_'|'0'..'9')*;

COMMA:',';

LB:'(';
RB:')';

PLUS:'+';
SUB:'-';
STAR:'*';
DIV:'/';
MOD:'%';
DOT:'.';

Q_MARK:'?';
SEMI : ';';
BLANK:' '{$setType(Token.SKIP);};
WS:( 	'\t'
		|   '\r' '\n' { newline(); }
		|   '\n'      { newline(); }		
		)
		{$setType(Token.SKIP);} 
	;
M_COMM
	: "/*" (options {
	greedy=false;
	generateAmbigWarnings=false;}
	:   '\r' '\n' {newline();}
	|   '\r'  {newline();}
	|   '\n'     {newline();}
	|   ~('\n'|'\r')
	)*
	"*/"
	{$setType(Token.SKIP);}
	;

S_COMM
	: ("//"|"--")
	(~('\n'|'\r'))* (('\n'|'\r'('\n')?){newline();})?
	{$setType(Token.SKIP);}
	;