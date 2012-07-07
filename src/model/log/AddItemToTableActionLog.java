package model.log;

import model.ItemOnTable;
import model.Table;

public class AddItemToTableActionLog extends ActionLog {

	public static final String LEVEL = "REGULAR_OPERATION"; 
	public static final String DESCRIPTION = "Item added to table";
	private ItemOnTable itemOnTable;
	private Table table;
	
	public AddItemToTableActionLog(Table table, ItemOnTable iot) {
		super(DESCRIPTION, LEVEL);
		
		this.table=table;
		this.itemOnTable=iot;
	}
	
	@Override
	public String getDetail()
	{
		return "Se agregó "+itemOnTable.getQuantity()+" "+itemOnTable.getItem().getName()+" ($"+itemOnTable.getAmount()+") a la mesa "+table.getName()+" ";
	}

}
