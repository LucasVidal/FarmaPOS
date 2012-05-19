package model;

import java.util.List;

import log.ActionLog;


public class Table {

	private String name;
	private Room room;
	private ItemOnTable content;
	private AbstractTableState state;
	private	Measures location;
	private List<ActionLog> actionsLog;
	
	public Measures getLocation() {
		return location;
	}

	public void setLocation(Measures location) {
		this.location = location;
	}

	public AbstractTableState getState() {
		return state;
	}

	public void setState(AbstractTableState state) {
		this.state = state;
	}

	public ItemOnTable getContent() {
		return content;
	}

	public void setContent(ItemOnTable content) {
		this.content = content;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<ActionLog> getActionsLog() {
		return actionsLog;
	}

	public void setActionsLog(List<ActionLog> actionsLog) {
		this.actionsLog = actionsLog;
	}


}
