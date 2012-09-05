package model;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private String name;
	
	private List<Table> tables;


	public Room(String name, List<Table> tables) {
		super();
		this.name = name;
		this.tables = tables;
	}
	
	public Room(String name) {
		this(name,new ArrayList<Table>());
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public void removeTable(Table table) {
		this.tables.remove(table);
		
	}

	public void addTables(Table ... tables) {
		for (Table t:tables)
		{
			this.tables.add(t);
			t.setRoom(this);
		}
	}

	public String getName() {
		return name;
	}

	
}
