package controller;

import model.Table;

public class TableBuilder {
	private Table table;
	
	public TableBuilder()
	{
		super();
		this.table=new Table();
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
		return table;
	}
}
