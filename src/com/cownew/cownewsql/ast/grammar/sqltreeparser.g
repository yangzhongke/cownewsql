header 
{
	package com.cownew.cownewsql.ast.grammar;
	import com.cownew.cownewsql.ast.node.*;
	import com.cownew.cownewsql.ast.node.enumdef.*;
	import com.cownew.cownewsql.ast.node.expr.*;
	import com.cownew.cownewsql.ast.node.item.*;
	import com.cownew.cownewsql.ast.node.stmt.*;
	import com.cownew.cownewsql.ast.node.stmt.DDL.*;
	import com.cownew.cownewsql.ast.node.expr.DDL.*;
	import com.cownew.cownewsql.ast.node.item.DDL.*;
}
class SQLTreeParser extends TreeParser;
options{
	importVocab=SQLParser;
	buildAST=true;
}
{
	boolean isSubQuery=false;
}

startRule
	:#(STATEMENTS (statement)*){##=new SqlStatementsAST(##);}
	;

statement
	:{isSubQuery=false;}selectStmt|{isSubQuery=true;}update|{isSubQuery=true;}insert|{isSubQuery=true;}delete
	|{isSubQuery=true;}createTableStatement|{isSubQuery=true;}createIndexStatement
	|{isSubQuery=true;}dropTableStatement|{isSubQuery=true;}dropIndexStatement|{isSubQuery=true;}showStatement
	|{isSubQuery=true;}alterTableStatement
	;
//
//insert statement
//
insert
	:#(INSERT table_name (column_elements)? (value_elements|select)){##=new SqlInsertBodyAST(##);}
	;
column_elements
	:#(COLUMN_ELEMENTS (expr)+)
	;
value_elements
	:#(VALUE_ELEMENTS (expr)+)
	;
//
//update statement
//
update
	:#(UPDATE table_name set_clause (from_clause)?(where_clause)?){##=new SqlUpdateBodyAST(##);}
	//:#(UPDATE table_element set_clause (from_clause)?(where_clause)?){##=new SqlUpdateBodyAST(##);}
	;
set_clause
	:#(SET_CLAUSE (expr)+)
	;


//
//delete statement
//
delete
	:#(DELETE TABLE_NAME (where_clause)?){##=new SqlDeleteStmtAST(##);}
	;
//
//select statement
//
selectStmt
	:s:select{
				if(!isSubQuery)
				{
					SqlSelectStmtAST select=new SqlSelectStmtAST(#s);
					select.setSubQuery((SqlQueryExprAST)#s);
					##=select;
					isSubQuery=!isSubQuery;
				}
			}
	;
//sub query
select
	:#(s:SELECT (a:aggregate_type)? (t:top_element)? se:select_elements (f:from_clause)? (w:where_clause)? (g:group_by_clause)? (h:having_clause)? (order_by_clause)? (l:limit_optional)? (r:rownum_optional)? (union_clause)?)
	{
			##=new SqlQueryExprAST(##);
	}
	;
union_clause
	:#(UNION (ALL)? select)
	;
//aggregate_type
aggregate_type 
	:#(AGGREGATE_TYPE (d:DISTINCT|a:ALL))
	;
//top_element
top_element
	:#(TOP_ELEMENT i:NUM_INT){##=new QueryTopInfo(##);}
	
	;

//select_elements
select_elements
	:#(COLUMN_ELEMENTS (column_element)+)
	
	
	;
column_element
	:#(COLUMN_ELEMENT expr (ALIAS_NAME)?){##=new SqlQueryColumnItemAST(##);}
	;


//from clause
from_clause
	:#(FROM_CLAUSE (table_element)+)
	;
table_element
	:#(TABLE_ELEMENT (t:table_name|s:select|show:showStatement) (ALIAS_NAME)? (j:joined_table)?){
		
		if(#t!=null)
			##=new SqlTableItemAST(##);
		else if(s!=null) 
			##=new SqlSubQueryTableItemAST(##);	
		else if(show!=null) 
			##=new SqlShowItemAST(#show,##);	
	}
	;
joined_table
	:#(JOIN_TABLE join_type table_element_in_joined_table  (search_condition)? (joined_table)?){##=new SqlJoinTableItemAST(##);}
	;
table_element_in_joined_table
	:#(TABLE_ELEMENT (t:table_name|s:select) (ALIAS_NAME)?)
	{
		if(#t!=null)
			##=new SqlTableItemAST(##);
		else 
			##=new SqlSubQueryTableItemAST(##);
	}
	;

table_name
	:TABLE_NAME
	;
join_type
	:(INNER_JOIN|CROSS_JOIN|LEFT_JOIN|RIGHT_JOIN|DEFULT_JOIN)
	;
//where_clause
where_clause
	:#(WHERE_CLAUSE search_condition2)
	;
//group bu clause
group_by_clause
	:#(GROUP_BY_CLAUSE (expr)+)
	;


//having clause
having_clause
	:#(HAVING_CLAUSE search_condition2)
	;
//order by clause
order_by_clause
	:#(ORDER_BY_CLAUSE (order_by_element)+)
	;
order_by_element
	:#(ORDER_BY_ELEMENT expr (ASC|DESC)?){##=new SqlOrderByItemAST(##);}
	;

limit_optional
	:#(LIMIT_OPTIONAL s:NUM_INT (e:NUM_INT)?)
	;
rownum_optional
	:#(ROWNUM_OPTIONAL i:NUM_INT)
	;

//search condition
search_condition
	:#(SEARCH_CONDITION search_condition2)
	;
search_condition2
	:expr
	;


expr:
	//level 1
	#(OR expr expr)//1
	{
		
		##=new SqlBinaryOpExprAST(##);
	}
	
	|#(AND expr expr){//2
		##=new SqlBinaryOpExprAST(##);
		}
		
	//level 2	
	|#(EQUAL expr expr){//3
		##=new SqlBinaryOpExprAST(##);
		}
	|#(GREATER expr expr){//4
		##=new SqlBinaryOpExprAST(##);
		}
	|#(LESS expr expr){//5
		##=new SqlBinaryOpExprAST(##);
	}
	|#(GR_EQ expr expr){//6
		##=new SqlBinaryOpExprAST(##);
	}
	|#(LE_EQ expr expr){//7
		##=new SqlBinaryOpExprAST(##);
	}
	|#(NOT_EQ expr expr){//8
		##=new SqlBinaryOpExprAST(##);
	}
	
	
	
	|#(NOT_IN expr expr){//9
		##=new SqlInExprAST(##);
	}
	|#(IN expr expr){//10
		##=new SqlInExprAST(##);
	}

	///////////////////////////////////////
	|#(BETWEEN expr expr expr){//11
		##=new SqlBetweenExprAST(##);
	}
	|#(NOT_BETWEEN expr expr expr){//12
		##=new SqlBetweenExprAST(##);//
	}
	/////////////////////////////////
	
	
	|#(LIKE expr expr){//13
		##=new SqlLikeExprAST(##);
	}
	|#(NOT_LIKE expr expr){//14
		
		##=new SqlLikeExprAST(##);
	}
	
	
	|#(IS expr expr){//15
		##=new SqlIsExprAST(##);
	}
	|#(IS_NOT expr expr){
		
		##=new SqlIsExprAST(##);
		}
	|#(NOT expr){//16
		##=new SqlUnaryOpExprAST(##);
	}
	
	//level 3
	|#(PLUS expr expr){//17
		##=new SqlBinaryOpExprAST(##);
	}
	|#(SUB expr expr){//18
		##=new SqlBinaryOpExprAST(##);
	}
	
	|#(STAR expr expr){//19
		##=new SqlBinaryOpExprAST(##);
	}
	|#(DIV expr expr){//20
		##=new SqlBinaryOpExprAST(##);
	}
	|#(MOD expr expr){//21
		##=new SqlBinaryOpExprAST(##);
	}
	
	
	|#(CONCAT expr expr){//22
		##=new SqlBinaryOpExprAST(##);
	}
	
	|#(DOT expr expr){//23
		##=new SqlBinaryOpExprAST(##);
	}
	
	//unary
	|#(ANY expr){//24
		##=new SqlUnaryOpExprAST(##);
	}
	|#(SOME expr){//25
		##=new SqlUnaryOpExprAST(##);
	}
	|#(ALL expr){//25
		##=new SqlUnaryOpExprAST(##);
	}
	|#(EXISTS expr){//26
		##=new SqlUnaryOpExprAST(##);
	}
	
	
	//function
	|#(FUNCTION f:function_name (function_parameters)){//27
		##=new SqlMethodExprAST(##);
	}
	|TABLE_NAME{##=new SqlIdentifierExprAST(##);}//28
	|COLUMN_NAME{##=new SqlIdentifierExprAST(##);}//29
	|CONST_STRING{##=new SqlCharExprAST(##);}//31
	|NULL{##=new SqlNullExprAST(##);}//32
	|DEFAULT{##=new SqlIdentifierExprAST(##);}//33
	|NUM_INT{##=new SqlIntExprAST(##);}//34
	|NUM_FLOAT{##=new SqlDoubleExprAST(##);}//35 want changing
	|NUM_REAL{##=new SqlDoubleExprAST(##);}//36 want changing
	|NUM_HEX{##=new SqlHexExprAST(##);}//37 want changing
	|BOOLEAN{##=new SqlIdentifierExprAST(##);}//38 want changing
	|DATE	{##=new SqlDateTimeExprAST(##);}//39 want changing
	|N_CONST_STRING{##=new SqlNCharExprAST(##);}
	|select{##=new SqlQueryExprAST(##);}//40
	|#(IN_LIST (expr)+){//41
		##=new SqlListExprAST(##);
		}
	|ALL_COLUMNS{##=new SqlIdentifierExprAST(##);}
	|Q_MARK{##=new SqlQuestionMarkExprAST(##);}
	;

function_name
	:AVG|COUNT|MAX|MIN|SUM|ID
	;



function_parameters
	:#(FUNCTION_PARAMETERS (e:expr)*)
	;


index_name
	:INDEX_NAME
	;

datatype:
	//#(TYPE_INT...|TYPE_VA...) is an invalid format
	TYPE_INT{##=new SqlIntTypeDefExprAST(##);}
	|#(TYPE_VARCHAR NUM_INT){##=new SqlVarcharTypeDefExprAST(##);}
	|#(TYPE_DECIMAL NUM_INT (NUM_INT)?){##=new SqlDecimalTypeDefExprAST(##);}
	|TYPE_DATETIME{##=new SqlDateTimeTypeDefExprAST(##);}
	|TYPE_BLOB{##=new SqlBlobTypeDefExprAST(##);}
	|TYPE_CLOB{##=new SqlClobTypeDefExprAST(##);}
	|#(TYPE_CHAR NUM_INT){##=new SqlCharTypeDefExprAST(##);}
	|#(TYPE_NCHAR NUM_INT){##=new SqlNCharTypeDefExprAST(##);}
	|#(TYPE_NVARCHAR NUM_INT){##=new SqlNVarcharTypeDefExprAST(##);}
	|TYPE_NCLOB{##=new SqlNClobTypeDefExprAST(##);}
	;

tableitemdef
	:column_def
	|single_primary_key
	|combo_primary_key
	|foreign_key
	|unique_def
	;

createTableStatement
	:#(CREATE_TABLE table_name (tableitemdef)+)
	{##=new SqlCreateTableStmtAST(##);};

column_def
	:#(COLUMN_DEF COLUMN_NAME datatype (NOTNULL)? (expr)?)
	{##=new SqlColumnDefItemAST(##);}
	;

single_primary_key
	:#(SINGLE_PRIMARY_KEY COLUMN_NAME) 
	{##=new SqlTableSinglePrimaryKeyItemAST(##);}
	;

combo_primary_key
	:#(COMBO_PRIMARY_KEY ce:column_elements)
	{##=new SqlTableComboPrimaryKeyItemAST(#ce);}
	;

foreign_key
	:#(FOREIGN_KEY COLUMN_NAME TABLE_NAME COLUMN_NAME)
	{##=new SqlTableForeignKeyItemAST(##);}
	;

unique_def
	:#(UNIQUE_DEF ce:column_elements)
	{##=new SqlTableUniqueItemAST(#ce);}
	;

createIndexStatement
	:#(CREATE_INDEX index_name table_name column_elements){##=new SqlCreateIndexStmtAST(##);}
	;

dropTableStatement
	//don't forget #(),it's stand for sqlparser's result tree
	:#(DROP_TABLE table_name){##=new SqlDropTableStmtAST(##);};

dropIndexStatement
	:#(DROP_INDEX table_name index_name){##=new SqlDropIndexStmtAST(##);};

alterTableStatement
	:#(ALTERTABLE_ADD_COLUMNS table_name column_def){##=new SqlAlterTableAddColumnStmtAST(##);}
	;

showStatement
	:#(SHOW_TABLES (ID)?){##=new SqlShowTablesStmtAST(##);}
	|#(SHOW_TABLECOLUMNS table_name){##=new SqlShowTableColumnsStmtAST(##);}	
	|SHOW_FUNCTIONS{##=new SqlShowFunctionsStmtAST(##);}
	|SHOW_FUNCTIONCOLUMNS{##=new SqlShowFunctionColumnsStmtAST(##);}
	;


