package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.CouldNotOpenTableException;

import log.ActionLog;


public class Table {

	private String name;
	private Room room;
	private ArrayList<ItemOnTable> content;
	private AbstractTableState state;
	private	Measures location;
	private List<ActionLog> actionsLog;

	public Table(String name, Room room) {
		super();
		this.name = name;
		this.room = room;
		this.content=new ArrayList<ItemOnTable>();
		this.state=AbstractTableState.getDefaultState();
		this.location=Measures.getDefaultLocation();
		this.actionsLog=new ArrayList<ActionLog>();
	}
	
	
	public void openTable() throws CouldNotOpenTableException 
	{
		
	}
	
	public Table(String name)
	{
		this(name,null);
	}

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

	public List<ItemOnTable> getContent() {
		return content;
	}
	
	public void addItem(Item i, Double q)
	{
		this.content.add(new ItemOnTable(i,q,i.getPrice()));
	}


	public void changeRoom(Room r)
	{
		this.room.removeTable(this);
		this.room=r;
	}
	
	public String getName() {
		return name;
	}

	public List<ActionLog> getActionsLog() {
		return actionsLog;
	}

	public void setActionsLog(List<ActionLog> actionsLog) {
		this.actionsLog = actionsLog;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room r) {
		this.room=r;
	}


	public void open() throws CouldNotOpenTableException {
		this.setState(this.state.openTable());
	}


	public boolean isOpen() {
		return this.state.isOpen();
	}


	public void close(PayMethod payMethod) {
		
		Cash.getInstance().registerSell(this.getAmount(), payMethod);
		this.state=new FreeState();
	}


	private Double getAmount() {
		Double amount=0.0;
		for (ItemOnTable i : this.content)
			amount+=i.getPrice();
		return amount;
	}


}
