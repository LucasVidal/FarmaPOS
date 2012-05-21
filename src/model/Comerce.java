package model;

import java.util.ArrayList;
import java.util.List;

/** Hope it does not becomes a god object! */
public class Comerce {
	private static List<Room> rooms;
	private static List<Provider> providers;
	
	public static List<Room> getRooms()
	{
		if (rooms == null)
			rooms= new ArrayList<Room>();
		
		return rooms;
	}
	
	public static void addRoom(Room r)
	{
		Comerce.getRooms().add(r);
	}

	public static void addProvider(Provider p)
	{
		Comerce.getProviders().add(p);
	}
	
	public static List<Provider> getProviders() {
		if (providers ==null)
			providers = new ArrayList<Provider>();
		
		return providers;
	}
}
