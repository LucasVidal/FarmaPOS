package controller;

import java.util.ArrayList;

import log.ActionLog;
import model.AbstractTableState;
import model.Commerce;
import model.ItemOnTable;
import model.Measures;
import model.Table;

public class TableBuilder {
	private Table table;
	
	public TableBuilder()
	{
		super();
		Table t = new Table();
		t.setName("");
		t.setRoom(null);
		t.setContent(new ArrayList<ItemOnTable>());
		t.setState(AbstractTableState.getDefaultState());
		t.setLocation(Measures.getDefaultLocation());
		t.setActionsLog(new ArrayList<ActionLog>());
		
		this.table=t;
	}
	
	public TableBuilder withName(String name)
	{
		this.table.setName(name);
		return this;
	}
	/**
	 * Builds the table and registers it into the commerce collection*/
	public Table build()
	{
		Commerce.getInstance().addTable(table);
		return table;
	}
}
