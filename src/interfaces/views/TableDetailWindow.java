package interfaces.views;

import interfaces.eventHandlers.AbstractEventHandler;
import interfaces.eventHandlers.TableEventHandler;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import model.Item;
import model.ItemOnTable;
import model.Table;
import exceptions.CouldNotOpenTableException;
import exceptions.TableIsNotOpenException;

public class TableDetailWindow extends AbstractWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbstractEventHandler handler;
	private Table table;
	private JList<String> entries;
	
	public TableDetailWindow() {
		this.handler = TableEventHandler.getInstance();
		this.handler.setFrame(this);
		this.setVisible(true);
		
		JButton b = new JButton("Volver");
		b.setBounds(100,100,100,100);
		b.addActionListener(this.handler);
		
		JLabel a = new JLabel("TEST");
		this.getContentPane().add(a);
		this.getContentPane().add(b);
//		this.getContentPane().add(this.entries);
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
			//JList<ItemOnTable> entries = new JList<ItemOnTable>(items);
			DefaultListModel<String> model = new DefaultListModel<String>();
			model.addElement("uno");
			model.addElement("dos");
			model.addElement("tres");
			this.entries = new JList<String> (model);
		}
		this.setTitle("Table details for: "+tableReference.getName());
	}


}
