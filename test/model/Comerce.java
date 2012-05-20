package model;

import java.util.ArrayList;
import java.util.List;

/** Hope it does not becomes a god object! */
public class Comerce {
	private static List<Room> rooms;
	
	public static List<Room> getRooms()
	{
		if (rooms == null)
			Comerce.setRooms(new ArrayList<Room>());
		
		return rooms;
	}

	private static void setRooms(List<Room> rooms) {
		Comerce.rooms=rooms;
	}
	
	public static void addRoom(Room r)
	{
		Comerce.rooms.add(r);
	}
}
