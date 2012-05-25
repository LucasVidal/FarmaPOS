package model;

import java.util.ArrayList;
import java.util.List;

/** Hope it does not becomes a god object! */
public class Commerce {
	
	private static Commerce INSTANCE;
	
	private List<Room> rooms;
	private List<Provider> providers;
	private List<Table> todaysTables;
	
	public Commerce()
	{
		this.rooms=new ArrayList<Room>();
		this.providers=new ArrayList<Provider>();
		this.todaysTables=new ArrayList<Table>();
	}
	
	public static Commerce getInstance()
	{
		if (INSTANCE==null)
			INSTANCE=new Commerce();
		
		return INSTANCE;
	}
	
	public List<Room> getRooms()
	{
		return rooms;
	}
	
	public void addRoom(Room r)
	{
		INSTANCE.getRooms().add(r);
	}

	public static Commerce getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(Commerce iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	public void addProvider(Provider p)
	{
		this.getProviders().add(p);
	}
	
	public List<Provider> getProviders() {
		return providers;
	}
	
	public List<Table> getTodayMovements() {
		return todaysTables;
	}

	public void addTable(Table table) {
		this.todaysTables.add(table);
	}
}
