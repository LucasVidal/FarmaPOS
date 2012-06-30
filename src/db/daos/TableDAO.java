package db.daos;

import model.Commerce;
import model.Room;
import model.Table;

public class TableDAO {

	private static TableDAO INSTANCE = null;
	
	public static TableDAO getInstance()
	{
		if (INSTANCE==null)
			INSTANCE = new TableDAO();
		
		return INSTANCE;
	}
	
	public Table getTable(String tableID) {
		for (Room r : Commerce.getInstance().getRooms())
			for (Table t : r.getTables())
				if (t.getId()==tableID) return t;
		return null;
	}

}
