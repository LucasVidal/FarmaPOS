package interfaces.components;

import javax.swing.JButton;

import model.Table;
import db.daos.TableDAO;
import exceptions.CouldNotOpenTableException;

public class TableButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3765293741518315225L;

	private Table table;
	private String tableId;


	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	public Table getTable() {
		if (table==null)
			table = TableDAO.getInstance().getTable(this.getTableId());
		
		return table;
	}

	public void openTable()
	{
		try {
			this.getTable().open();
		} catch (CouldNotOpenTableException e) {
			e.printStackTrace();
		}
		
		this.setIcon(this.getTable().getState().getIcon());
	}
}
