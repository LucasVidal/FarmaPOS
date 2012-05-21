package model;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import log.ActionLog;
import log.AddItemToTableActionLog;
import exceptions.*;


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
	
	public void addItem(Item i, Double q) throws TableIsNotOpenException
	{
		if (!this.isOpen())
			throw new TableIsNotOpenException();
		
		ItemOnTable iot = new ItemOnTable(i,q,i.getPrice());
		this.content.add(iot);
		
		i.notifyItemAdded(iot);
		
		this.registerItemAdded(this,iot);
	}


	private void registerItemAdded(Table table, ItemOnTable iot) {
		this.actionsLog.add(new AddItemToTableActionLog(table, iot));
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


	public Double getAmount() {
		Double amount=0.0;
		for (ItemOnTable i : this.content)
			amount+=i.getAmount();
		return amount;
	}


	public String getHistoryString() {
		StringBuilder sb = new StringBuilder("\n\n----"+this.name+" history: ");
		for (ActionLog al : this.actionsLog)
			sb.append("\n"+al.getDescription()+" - "+al.getDetail());
		
		sb.append("\n----");
		return sb.toString();
	}


}
