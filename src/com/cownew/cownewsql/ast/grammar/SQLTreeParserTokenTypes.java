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

public interface SQLTreeParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int NUM_FLOAT = 4;
	int NUM_INT = 5;
	int NUM_REAL = 6;
	int BOOLEAN = 7;
	int CONSTANT = 8;
	int STATEMENTS = 9;
	int CREATE = 10;
	int DROP = 11;
	int ADD = 12;
	int ALTER = 13;
	int TABLE = 14;
	int INDEX = 15;
	int DEFAULT = 16;
	int PRIMARY = 17;
	int FOREIGN = 18;
	int KEY = 19;
	int REFERENCES = 20;
	int UNIQUE = 21;
	int COLUMN = 22;
	int SHOW = 23;
	int NOTNULL = 24;
	int INDEX_NAME = 25;
	int TYPE_INT = 26;
	int TYPE_VARCHAR = 27;
	int TYPE_NVARCHAR = 28;
	int TYPE_CHAR = 29;
	int TYPE_NCHAR = 30;
	int TYPE_DECIMAL = 31;
	int TYPE_DATETIME = 32;
	int TYPE_BLOB = 33;
	int TYPE_CLOB = 34;
	int TYPE_NCLOB = 35;
	int COLUMN_DEF = 36;
	int SINGLE_PRIMARY_KEY = 37;
	int COMBO_PRIMARY_KEY = 38;
	int FOREIGN_KEY = 39;
	int UNIQUE_DEF = 40;
	int CREATE_INDEX = 41;
	int CREATE_TABLE = 42;
	int DROP_TABLE = 43;
	int DROP_INDEX = 44;
	int SHOW_TABLES = 45;
	int SHOW_TABLECOLUMNS = 46;
	int SHOW_FUNCTIONS = 47;
	int SHOW_FUNCTIONCOLUMNS = 48;
	int ALTERTABLE_ADD_COLUMNS = 49;
	int SELECT = 50;
	int DELETE = 51;
	int INSERT = 52;
	int UPDATE = 53;
	int AS = 54;
	int ALL = 55;
	int AND = 56;
	int ASC = 57;
	int AVG = 58;
	int ANY = 59;
	int BY = 60;
	int CROSS = 61;
	int COUNT = 62;
	int DISTINCT = 63;
	int DESC = 64;
	int EXISTS = 65;
	int FROM = 66;
	int FALSE = 67;
	int GROUP = 68;
	int HAVING = 69;
	int IS = 70;
	int INTO = 71;
	int INNER = 72;
	int JOIN = 73;
	int MAX = 74;
	int MIN = 75;
	int NOT = 76;
	int NULL = 77;
	int ON = 78;
	int OUTER = 79;
	int OR = 80;
	int ORDER = 81;
	int ORDER_BY_ELEMENT = 82;
	int ORDER_TYPE = 83;
	int RIGHT = 84;
	int LEFT = 85;
	int LIMIT = 86;
	int ROWNUM = 87;
	int SET = 88;
	int SOME = 89;
	int SUM = 90;
	int TRUE = 91;
	int TOP = 92;
	int UNION = 93;
	int VALUES = 94;
	int WHERE = 95;
	int IN_LIST = 96;
	int ALIAS_NAME = 97;
	int AGGREGATE_TYPE = 98;
	int ALL_COLUMNS = 99;
	int TABLE_ELEMENT = 100;
	int TABLE_NAME = 101;
	int COLUMN_ELEMENTS = 102;
	int COLUMN_ELEMENT = 103;
	int COLUMN_NAME = 104;
	int VALUE_ELEMENTS = 105;
	int TOP_ELEMENT = 106;
	int SET_CLAUSE = 107;
	int WHERE_CLAUSE = 108;
	int FROM_CLAUSE = 109;
	int GROUP_BY_CLAUSE = 110;
	int HAVING_CLAUSE = 111;
	int ORDER_BY_CLAUSE = 112;
	int LIMIT_OPTIONAL = 113;
	int ROWNUM_OPTIONAL = 114;
	int SEARCH_CONDITION = 115;
	int IN = 116;
	int NOT_IN = 117;
	int BETWEEN = 118;
	int NOT_BETWEEN = 119;
	int LIKE = 120;
	int NOT_LIKE = 121;
	int IS_NOT = 122;
	int UNARY_MINUS = 123;
	int UNARY_PLUS = 124;
	int FUNCTION = 125;
	int FUNCTION_PARAMETERS = 126;
	int JOIN_TABLE = 127;
	int DEFULT_JOIN = 128;
	int INNER_JOIN = 129;
	int CROSS_JOIN = 130;
	int LEFT_JOIN = 131;
	int RIGHT_JOIN = 132;
	int SEMI = 133;
	int LB = 134;
	int COMMA = 135;
	int RB = 136;
	int EQUAL = 137;
	int DOT = 138;
	int ID = 139;
	int STAR = 140;
	int LESS = 141;
	int GREATER = 142;
	int LE_EQ = 143;
	int GR_EQ = 144;
	int NOT_EQ = 145;
	int PLUS = 146;
	int SUB = 147;
	int Q_MARK = 148;
	int DIV = 149;
	int MOD = 150;
	int CONCAT = 151;
	int CONST_STRING = 152;
	int N_CONST_STRING = 153;
	int NUM_HEX = 154;
	int DATE = 155;
	int LITERAL_int = 156;
	int LITERAL_integer = 157;
	int LITERAL_tinyint = 158;
	int LITERAL_smallint = 159;
	int LITERAL_bit = 160;
	int LITERAL_boolean = 161;
	int LITERAL_varchar = 162;
	int LITERAL_decimal = 163;
	int LITERAL_numeric = 164;
	int LITERAL_real = 165;
	int LITERAL_float = 166;
	int LITERAL_double = 167;
	int LITERAL_datetime = 168;
	int LITERAL_date = 169;
	int LITERAL_timestamp = 170;
	int LITERAL_time = 171;
	int LITERAL_blob = 172;
	int LITERAL_tinyblob = 173;
	int LITERAL_longblob = 174;
	int LITERAL_binary = 175;
	int LITERAL_varbinary = 176;
	int LITERAL_longvarbinary = 177;
	int LITERAL_image = 178;
	int LITERAL_clob = 179;
	int LITERAL_tinytext = 180;
	int LITERAL_longtext = 181;
	int LITERAL_text = 182;
	int LITERAL_longvarchar = 183;
	int LITERAL_char = 184;
	int LITERAL_nchar = 185;
	int LITERAL_nvarchar = 186;
	int LITERAL_nclob = 187;
	int LITERAL_tables = 188;
	int LITERAL_tablecolumns = 189;
	int LITERAL_functions = 190;
	int LITERAL_functioncolumns = 191;
	int NUMBER = 192;
	int QUOTE = 193;
	int BLANK = 194;
	int WS = 195;
	int M_COMM = 196;
	int S_COMM = 197;
}
