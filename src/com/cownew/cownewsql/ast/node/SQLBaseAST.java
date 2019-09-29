package com.cownew.cownewsql.ast.node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import antlr.CommonAST;
import antlr.collections.AST;

import com.cownew.cownewsql.ast.node.enumdef.TreeLableTokenTypesEnum;

public class SQLBaseAST extends CommonAST
{

	public SQLBaseAST(String text)
	{
		super();
		this.setText(text);
	}

	public SQLBaseAST(String text, int type)
	{
		super();
		this.setText(text);
		this.setType(type);
	}

	public SQLBaseAST()
	{
		super();
	}

	public SQLBaseAST(AST ast)
	{
		this.copyAST(ast);
	}

	protected void setFirstChildAndNextSibling(AST ast)
	{
		this.setFirstChild(ast.getFirstChild());
		this.setNextSibling(ast.getNextSibling());
	};

	/**
	 * Copy the text,type,firstchild and sibling of a given ast to the current
	 * ast
	 * 
	 * @param ast
	 *            The source AST
	 */
	protected void copyAST(AST ast)
	{
		this.setText(ast.getText());
		this.setType(ast.getType());
		this.setFirstChildAndNextSibling(ast);
	}

	/**
	 * 
	 * <DL><DT><B>
	 * 标题.
	 * </B></DT><p><DD>
	 * index start with 1,not 0
	 * </DD></DL><p>
	 * 创建时间: 2007-9-6 下午05:48:15
	 * @param num
	 * @return
	 */
	public SQLBaseAST getChildASTByOrder(int num)
	{
		if(num<=0)
		{
			throw new IllegalArgumentException("num must >=1");
		}
		SQLBaseAST ast = (SQLBaseAST) this.getFirstChild();
		if(ast==null)
		{
			return null;
		}
		for(int i=0;i<num-1;i++)
		{
			if(ast==null)
			{
				return null;
			}
			ast = (SQLBaseAST) ast.getNextSibling();
		}
		return ast;
	}

	/**
	 * @param text
	 *            The text of the sibling AST
	 * @return The selected sibling AST or null if it can't be found
	 */
	protected SQLBaseAST getSiblingASTByType(String text)
	{
		SQLBaseAST ast = this;
		while ((ast = (SQLBaseAST) ast.getNextSibling()) != null)
		{
			if (ast.getText().equals(text))
				return ast;
		}
		return null;
	}

	/**
	 * @param type
	 *            The type of the sibling AST
	 * @return The selected sibling AST or null if it can't be found
	 */
	protected SQLBaseAST getSiblingASTByType(int type)
	{
		SQLBaseAST ast = this;
		while ((ast = (SQLBaseAST) ast.getNextSibling()) != null)
		{
			if (ast.getType() == type)
				return ast;
		}
		return null;
	}

	/**
	 * @param name
	 *            The text of the Child AST
	 * @return The selected Child AST or null if the root doesn't contain.
	 */
	protected SQLBaseAST getChildASTByType(String text)
	{
		SQLBaseAST child = (SQLBaseAST) this.getFirstChild();
		if (child != null)
		{// the root has some children.
			if (child.getText().equals(text))
				return child;
			else
			{
				return child.getSiblingASTByType(text);
			}

		} else
			return null;
	} //

	/**
	 * @param type
	 *            The type of the ChildAST
	 * @return The selected Child AST or null if the root doesn't contain.
	 */
	public SQLBaseAST getChildASTByType(int type)
	{
		SQLBaseAST child = (SQLBaseAST) this.getFirstChild();
		if (child != null)
		{// the root has some children.
			if (child.getType() == type)
				return child;
			else
			{
				return child.getSiblingASTByType(type);
			}
		} else
			return null;
	} //

	public List<SQLBaseAST> getChildListByClass(Class baseClass)
	{
		List<SQLBaseAST> list = getChildASTList();
		List<SQLBaseAST> retList = new ArrayList<SQLBaseAST>();
		for(int i=0,n=list.size();i<n;i++)
		{
			SQLBaseAST ast = list.get(i);
			if(baseClass.isInstance(ast))
			{
				retList.add(ast);
			}
		}
		return retList;
	}
	/**
	 * @param newAST
	 *            The new AST
	 * @param type
	 *            The type of the AST according to class TokenTypes
	 * @param startWith
	 *            The beginning number of the children in the new AST.It starts
	 *            with 1.
	 * @return The number of the replaced child AST.
	 */
	protected int replaceChildASTByType(SQLBaseAST newAST, int type, int start)
	{
		int i = 1;
		SQLBaseAST ast = (SQLBaseAST) this.getFirstChild();
		if (ast != null)
		{
			if (ast.getType() == type && i >= start)
			{
				this.replaceChildASTByOrder(newAST, i);
				return i;
			} else
			{
				while ((ast = (SQLBaseAST) ast.getNextSibling()) != null)
				{
					i++;
					if (ast.getType() == type && i >= start)
					{
						this.replaceChildASTByOrder(newAST, i);
						return i;
					}
				}
				return -1;
			}
		} else
			return -1;

	}

	protected int searchChildAST(int type, int start)
	{
		int i = 1;
		SQLBaseAST ast = (SQLBaseAST) this.getFirstChild();
		if (ast != null)
		{// the root has children.
			if (ast.getType() == type && start == 1)
			{// check the first child.
				return 1;
			} else
			{
				while ((ast = (SQLBaseAST) ast.getNextSibling()) != null)
				{
					i++;
					if (ast.getType() == type && i >= start)
					{
						return i;
					}
				}
				return -1;
			}
		} else
			return -1;// the root hasn't child.
	}

	protected int searchChildAST(int type)
	{
		return this.searchChildAST(type, 1);
	}

	protected int replaceChildASTByType(SQLBaseAST newAST, int type)
	{
		return this.replaceChildASTByType(newAST, type, 1);
	}

	/**
	 * @param ast
	 *            The new AST
	 * @param num
	 *            The position of the old AST in the children of current AST.it
	 *            starts with 1.
	 */
	protected void replaceChildASTByOrder(SQLBaseAST newAST, int num)
	{
		SQLBaseAST oldAST = (SQLBaseAST) this.getFirstChild();
		if (oldAST != null)
		{// the root has some children.
			if (num > 1)
			{// not to replace the first child
				if (this.getNumberOfChildren() >= num)
				{
					SQLBaseAST prevOldAST = oldAST;
					for (int i = 1; i < num - 1; i++)
					{
						prevOldAST = (SQLBaseAST) prevOldAST.getNextSibling();
					}
					oldAST = (SQLBaseAST) prevOldAST.getNextSibling();
					prevOldAST.setNextSibling(newAST);
					newAST.setNextSibling(oldAST.getNextSibling());
				}
			} else
			{
				// num==1.to replace the first child
				if (num == 1)
				{
					this.setFirstChild(newAST);
					newAST.setFirstChildAndNextSibling(oldAST);
				}
			}
		} else
		{// the root hasn't any child.
			if (num == 1)
			{
				this.setFirstChild(newAST);
			}
		}

	}

	public List getChildASTList()
	{
		List<SQLBaseAST> list = new LinkedList<SQLBaseAST>();
		SQLBaseAST child = (SQLBaseAST) this.getFirstChild();
		if (child != null)
		{
			list.add(child);

			while ((child = (SQLBaseAST) child.getNextSibling()) != null)
			{
				list.add(child);
			}
			return list;
		} else
			return list;
	}

	protected void setChildASTList(List<?> list)
	{
		this.setFirstChild(null);
		for (Object i : list)
		{
			if (i instanceof SQLBaseAST)
				this.addChild((SQLBaseAST) i);
		}
	}

	protected List getLv2ASTList(int type)
	{
		SQLBaseAST elements = this.getChildASTByType(type);
		if (elements != null)
			return elements.getChildASTList();
		else
			return null;
	}

	protected List getLv2ASTList(TreeLableTokenTypesEnum type)
	{
		return this.getLv2ASTList(type.getValue());
	}

	protected void setLv2ASTList(TreeLableTokenTypesEnum type, List<?> list)
	{
		SQLBaseAST elements = this.getChildASTByType(type.getValue());
		if (elements == null)
		{
			elements = new SQLBaseAST(type.getName(), type.getValue());
			this.addChild(elements);
		}
		elements.setChildASTList(list);
	}

	protected SQLBaseAST getLv2AST(int type)
	{
		SQLBaseAST elements = this.getChildASTByType(type);
		if (elements != null)
			return (SQLBaseAST) elements.getFirstChild();
		else
			return null;
	}

	protected SQLBaseAST getLv2AST(TreeLableTokenTypesEnum type)
	{
		return this.getLv2AST(type.getValue());
	}

	protected void setLv2AST(TreeLableTokenTypesEnum type, SQLBaseAST ast)
	{
		SQLBaseAST elements = this.getChildASTByType(type.getValue());
		if (elements == null)
		{
			elements = new SQLBaseAST(type.getName(), type.getValue());
			this.addChild(elements);
		}
		elements.setFirstChild(ast);
	}

	protected void setChildASTByType(SQLBaseAST ast, int type, int start)
	{
		int i = this.searchChildAST(type, start);
		if (i == -1)
		{// can not find
			this.addChild(ast);
		} else
		{
			this.replaceChildASTByType(ast, type, i);
		}

	}

	protected void setChildASTByType(SQLBaseAST ast, int type)
	{
		this.setChildASTByType(ast, type, 1);
	}

	/**
	 * Caution:This method will add the other AST by itself when the position is
	 * greater than the number of the Child AST.
	 * 
	 * @param ast
	 *            The Child AST to be set
	 * @param num
	 *            The position under the current AST
	 */
	protected void setChildASTByOrder(SQLBaseAST ast, int num)
	{
		int n = this.getNumberOfChildren();
		if (n >= num)
		{
			this.replaceChildASTByOrder(ast, num);
		} else
		{
			for (; n < num - 1; n++)
			{
				this.addChild(new SQLBaseAST());
			}
			this.addChild(ast);
		}
	}

	public String toString()
	{
		return this.getText();

	}
}
