package model;

import java.util.ArrayList;
import java.util.List;

/** Hope it does not becomes a god object! */
public class Comerce {
	
	private static Comerce INSTANCE;
	
	private List<Room> rooms;
	private List<Provider> providers;
	private List<Table> todayMovements;
	
	public Comerce()
	{
		this.rooms=new ArrayList<Room>();
		this.providers=new ArrayList<Provider>();
		this.todayMovements=new ArrayList<Table>();
	}
	
	public static Comerce getInstance()
	{
		if (INSTANCE==null)
			INSTANCE=new Comerce();
		
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

	public static Comerce getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(Comerce iNSTANCE) {
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
		return todayMovements;
	}
}
