/*
 * com.cownew.cownewsql.imsql.TranslatorUI.java
 * Created on 2007-9-19 下午01:46:08 by 杨中科
 */

package com.cownew.cownewsql.imsql;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.SystemUtils;

import com.cownew.cownewsql.ast.SQLAstBuilder;
import com.cownew.cownewsql.ast.node.stmt.SqlStatementsAST;
import com.cownew.cownewsql.imsql.common.DialectManager;

public class TranslatorUI extends JFrame
{

	private static final String ORACLE = "Oracle";

	private static final String MYSQL = "MYSQL";

	private static final String MSSQLSERVER = "MSSQLServer";

	private static final String DB2 = "DB2";
	
	private static final String ALL = "ALL";

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JToolBar jJToolBarBar = null;

	private JSplitPane jSplitPane = null;

	private JButton btnTranslate = null;

	private JLabel jLabel = null;

	private JComboBox cmbTargetDBType = null;

	private JScrollPane jScrollPane = null;

	private JScrollPane jScrollPane1 = null;

	private JTextArea txtStdSQL = null;

	private JTextArea txtVenderSQL = null;

	/**
	 * This method initializes jJToolBarBar
	 * 
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJJToolBarBar()
	{
		if (jJToolBarBar == null)
		{
			jLabel = new JLabel();
			jLabel.setText("Dialect:");
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setPreferredSize(new Dimension(18, 30));
			jJToolBarBar.add(getBtnTranslate());
			jJToolBarBar.add(jLabel);
			jJToolBarBar.add(getCmbTargetDBType());
		}
		return jJToolBarBar;
	}

	/**
	 * This method initializes jSplitPane
	 * 
	 * @return javax.swing.JSplitPane
	 */
	private JSplitPane getJSplitPane()
	{
		if (jSplitPane == null)
		{
			jSplitPane = new JSplitPane();
			jSplitPane.setDividerLocation(400);
			jSplitPane.setRightComponent(getJScrollPane1());
			jSplitPane.setLeftComponent(getJScrollPane());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes btnTranslate
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnTranslate()
	{
		if (btnTranslate == null)
		{
			btnTranslate = new JButton();
			btnTranslate.setText("Translate");
			btnTranslate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					try
					{
						translate();
					} catch (Exception ex)
					{
						ex.printStackTrace();
						JOptionPane.showMessageDialog(TranslatorUI.this, ex
								.getMessage());
					}
				}
			});
		}
		return btnTranslate;
	}

	/**
	 * This method initializes cmbTargetDBType
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbTargetDBType()
	{
		if (cmbTargetDBType == null)
		{
			cmbTargetDBType = new JComboBox();

		}
		return cmbTargetDBType;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane()
	{
		if (jScrollPane == null)
		{
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTxtStdSQL());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane1()
	{
		if (jScrollPane1 == null)
		{
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTxtVenderSQL());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes txtStdSQL
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtStdSQL()
	{
		if (txtStdSQL == null)
		{
			txtStdSQL = new JTextArea();
			txtStdSQL.setLineWrap(true);
		}
		return txtStdSQL;
	}

	/**
	 * This method initializes txtVenderSQL
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtVenderSQL()
	{
		if (txtVenderSQL == null)
		{
			txtVenderSQL = new JTextArea();
			txtVenderSQL.setLineWrap(true);
		}
		return txtVenderSQL;
	}

	/**
	 * <DL>
	 * <DT><B> 标题. </B></DT>
	 * <p>
	 * <DD> 详细介绍 </DD>
	 * </DL>
	 * <p>
	 * 创建时间: 2007-9-19 下午01:46:08
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				TranslatorUI thisClass = new TranslatorUI();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public TranslatorUI()
	{
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		this.setSize(800, 600);
		this.setContentPane(getJContentPane());
		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {
				ALL,MYSQL,MSSQLSERVER, ORACLE, DB2 });
		cmbTargetDBType.setModel(model);

		StringBuffer sb = new StringBuffer();
		sb.append("create index idx2 on T_Person(FName,FAge);\n\n");
		sb
				.append("create table T_SaleInvoiceDetails(FId VARCHAR(20),FParentId varchar(20),FMaterialId varchar(20),FCount int default 0,FPrice decimal(10,2),primary key FId,FOREIGN KEY FParentId REFERENCES T_SaleInvoice(FId),FOREIGN KEY FMaterialId REFERENCES T_Material(FId));\n\n");

		sb
				.append("insert into T_SaleInvoice values('sv001','sv001','p001',{'2007-08-8'});\n\n");
		sb.append("update T_SaleInvoice set FDate=DateAdd(dd,-1,Now());\n\n");
		sb.append("select top 10 * from T_SaleInvoice;\n\n");

		sb
				.append("create Table T_StockFlow(FBillId varchar(20),FDetailId varchar(20),FDate date,FBillTypeName  varchar(20),FAmount decimal(10,2),primary key (FBillId,FDetailId));\n\n");
		sb
				.append("insert into T_StockFlow(FBillId,FDetailId,FDate,FBillTypeName,FAmount) "
						+ "select detail.FParentId,detail.FId,parent.FDate,'销售发票',detail.FCount*detail.FPrice from T_SaleInvoiceDetails detail left join T_SaleInvoice parent on parent.FId=detail.FParentId;\n\n");

		sb
				.append("select trim(person.FName),bill.FNumber from T_SaleInvoice as bill left join T_Person person on bill.FSalesPersonId=person.FId;\n\n");
		sb
				.append("select * from T_StockFlow where FBillId in('a','b') or FBillId in(select FBillId from T_StockFlow);\n\n");
		sb
				.append("delete from T_SaleInvoice where FId in(select top 5 FParentId from T_SaleInvoiceDetails);\n\n");
		sb.append("drop index T_Person.idx1;\n\n");
		sb
				.append("select CONVERT('VARCHAR',3),CONVERT('INT','3'),CURTIME(),DATEDIFF(NOW(),CURDATE()),DATEDIFF(minute,NOW(),CURDATE());\n\n");
		sb
				.append("select TO_DATE('2008-08-08'),MONTHS_BETWEEN(NOW(),{'2008-08-08'}),DAYS_BETWEEN(NOW(),{'2008-08-08'});\n\n");
		sb
				.append("select LEFTSTR('verycd',2),RIGHTSTR('cownew',3),LENGTH('cde'),LCASE('Cool!'),LTRIM('  aa  d ');\n\n");
		sb
				.append("select REPLACE('you and me and he','and','or'),RTRIM(' aa d '),SUBSTRING('whitehouse',1,4),TRIM(' abe da '),UCASE('abc'),TOCHAR(1),TO_CHAR(now());\n\n");
		txtStdSQL.setText(sb.toString());

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane()
	{
		if (jContentPane == null)
		{
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJJToolBarBar(), BorderLayout.NORTH);
			jContentPane.add(getJSplitPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	protected void translate() throws Exception
	{
		String stdSQL = txtStdSQL.getText();
		if (stdSQL == null || stdSQL.trim().length() <= 0)
		{
			return;
		}
		txtVenderSQL.setText("");
		
		Object dbType = cmbTargetDBType.getSelectedItem();
		if(dbType!=ALL)
		{
			ISQLTranslator tx = DialectManager.createTranslator(dbType.toString());
			String[] venderSQLs = tx.translateSQL(stdSQL);			
			for (int i = 0, n = venderSQLs.length; i < n; i++)
			{
				txtVenderSQL.append(venderSQLs[i]);
				txtVenderSQL.append(SystemUtils.LINE_SEPARATOR);
			}
		}
		else
		{
			//进行多数据库分析，相同结果的分到一组
			SqlStatementsAST stmts = SQLAstBuilder.getStatementsAST(stdSQL);
			if(stmts.getStatements().size()!=1)
			{
				JOptionPane.showMessageDialog(this, "多数据比较目前仅支持单句SQL！");
				return;
			}
			
			ISQLTranslator txMYSQL = DialectManager.createTranslator(MYSQL);
			ISQLTranslator txMSSQLServer = DialectManager.createTranslator(MSSQLSERVER);
			ISQLTranslator txOracle = DialectManager.createTranslator(ORACLE);
			ISQLTranslator txDB2 = DialectManager.createTranslator(DB2);
			String vsMYSQL = txMYSQL.translateSQL(stdSQL)[0].trim();
			String vsMSSQLServer = txMSSQLServer.translateSQL(stdSQL)[0].trim();
			String vsOracle = txOracle.translateSQL(stdSQL)[0].trim();
			String vsDB2 = txDB2.translateSQL(stdSQL)[0].trim();
			Map<String,String> map = new LinkedHashMap<String, String>();
			map.put(vsMYSQL, "MYSQL");
			if(map.containsKey(vsMSSQLServer))
			{
				String oldName = map.get(vsMSSQLServer);
				map.put(vsMSSQLServer, oldName+",MSSQLServer");
			}
			else
			{
				map.put(vsMSSQLServer, "MSSQLServer");
			}
			
			if(map.containsKey(vsOracle))
			{
				String oldName = map.get(vsOracle);
				map.put(vsOracle, oldName+",Oracle");
			}
			else
			{
				map.put(vsOracle, "Oracle");
			}
			
			if(map.containsKey(vsDB2))
			{
				String oldName = map.get(vsDB2);
				map.put(vsDB2, oldName+",DB2");
			}
			else
			{
				map.put(vsDB2, "DB2");
			}
			
			Set<String> keySet = map.keySet();
			for(String key : keySet)
			{
				String value = map.get(key);
				txtVenderSQL.append(value+":");
				txtVenderSQL.append(SystemUtils.LINE_SEPARATOR);
				txtVenderSQL.append(key);
				txtVenderSQL.append(SystemUtils.LINE_SEPARATOR);
			}
		}				
	}

} // @jve:decl-index=0:visual-constraint="10,10"
