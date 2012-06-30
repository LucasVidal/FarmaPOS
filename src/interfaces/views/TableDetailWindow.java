package interfaces.views;

import interfaces.eventHandlers.AbstractEventHandler;
import interfaces.eventHandlers.TableDetailWindowEventHandler;

import java.awt.BorderLayout;
import java.lang.reflect.Array;

import javax.swing.JButton;
import javax.swing.JList;

import exceptions.CouldNotOpenTableException;
import exceptions.TableIsNotOpenException;

import model.Item;
import model.ItemOnTable;
import model.Table;

public class TableDetailWindow extends AbstractWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbstractEventHandler handler;
	private Table table;
	
	public TableDetailWindow() {
		this.handler = TableDetailWindowEventHandler.getInstance();
		this.handler.setFrame(this);
		this.setVisible(true);
		
		JButton b = new JButton("Volver");
		b.setBounds(100,100,100,100);
		b.addActionListener(this.handler);
	//	this.getContentPane().add(b,BorderLayout.PAGE_START);
		
	}

	public TableDetailWindow(Table tableReference) {
		this();
		if (tableReference!=null)
		{	
			this.table = tableReference;
			Item i = new Item("Milanesa",2.0);
			try {
				this.table.open();
				this.table.addItem(i, 4.0);
				this.table.addItem(i, 2.0);
			} catch (CouldNotOpenTableException e1) {
				e1.printStackTrace();
			} catch (TableIsNotOpenException e) {
				e.printStackTrace();
			}
					
			ItemOnTable [] items = this.table.getContent().toArray(new ItemOnTable[table.getContent().size()]);
			
			System.out.print("Hay "+items.length+" elementos");
			JList<ItemOnTable> entries = new JList<ItemOnTable>(items);
			
			this.getContentPane().add(entries, BorderLayout.PAGE_START);
		}
		this.setTitle("Table details for: "+tableReference.getName());
	}


}
