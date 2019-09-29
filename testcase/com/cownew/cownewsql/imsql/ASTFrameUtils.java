/*
 * com.cownew.cownewsql.imsql.ASTFrameUtils.java
 * Created on 2007-10-28 ÏÂÎç11:35:42 by ÑîÖÐ¿Æ
 */

package com.cownew.cownewsql.imsql;

import antlr.collections.AST;
import antlr.debug.misc.ASTFrame;

public class ASTFrameUtils
{
	public static void showAST(AST ast)
	{
		ASTFrame frame = new ASTFrame("",ast);
		frame.setVisible(true);
	}
}
