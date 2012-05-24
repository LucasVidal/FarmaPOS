package log;

import model.ItemOnTable;
import model.Table;

public class RemoveItemFromTableActionLog extends ActionLog {

	public static final String LEVEL = "REGULAR_WARNING_OPERATION"; 
	public static final String DESCRIPTION = "Item removed from table";
	private ItemOnTable itemOnTable;
	private Table table;
	
	public RemoveItemFromTableActionLog(Table table, ItemOnTable iot) {
		super(DESCRIPTION, LEVEL);
		
		this.table=table;
		this.itemOnTable=iot;
	}

	
	@Override
	public String getDetail()
	{
		return "Se quitó el item "+itemOnTable.getQuantity()+" "+itemOnTable.getItem().getName()+" ($"+itemOnTable.getAmount()+") de la mesa "+table.getName()+" ";
	}

	
	
}
