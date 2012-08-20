package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/** Hope it does not becomes a god object! */
public class Commerce {
	
	private static Commerce INSTANCE;

	private Cash currentCash;
	
	private List<Room> rooms;
	private List<Provider> providers;
	private List<Table> todaysTables;
	private List<Cash> cashes;
	
	public Commerce()
	{
		this.rooms=new ArrayList<Room>();
		this.providers=new ArrayList<Provider>();
		this.todaysTables=new ArrayList<Table>();
		this.cashes=new ArrayList<Cash>();
	}
	
	public static Commerce getInstance()
	{
		if (INSTANCE==null)
			INSTANCE=new Commerce();
		
		return INSTANCE;
	}
	

	public List<Cash> getCashes() {
		return cashes;
	}

	public List<Room> getRooms()
	{
		return rooms;
	}
	
	public void addRoom(Room r)
	{
		INSTANCE.getRooms().add(r);
	}

	public void addProvider(Provider p)
	{
		this.getProviders().add(p);
	}
	
	public List<Provider> getProviders() {
		return providers;
	}
	
	public List<Table> getTodaysTables() {
		return todaysTables;
	}

	public void addTable(Table table) {
		this.todaysTables.add(table);
	}

	public void resetDay() {
		this.todaysTables=new ArrayList<Table>();
	}

	public static Cash getCashForDay(Date date) {
		for (Cash c:Commerce.getInstance().getCashes())
			if (c.getDay().equalsDate(date))
				return c;
		return Cash.createCash(date);
	}

	public Cash getCurrentCash() {
		if (INSTANCE.currentCash ==null) 
			INSTANCE.currentCash = getCashForDay(new Date());
		
		return INSTANCE.currentCash; 
	}

	public List<Item> getMenu() {
		return new ArrayList<Item>(
			Arrays.asList(
				new Item("Milanesa de carne",10.0), 
				new Item("Quilmes",2.0), 
				new Item("Milanesa de pollo",11.0), 
				new Item("Jugo de naranja",4.0), 
				new Item("Coca",5.7)
			));
	}
}
