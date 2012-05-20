package model;

import java.awt.Color;

import exceptions.CouldNotOpenTableException;

public abstract class AbstractTableState {

	public abstract Color getColor();
	protected static AbstractTableState INSTANCE;	

	
	public static AbstractTableState getDefaultState() {
		return new FreeState();
	}

	public AbstractTableState openTable() throws CouldNotOpenTableException{
		throw new CouldNotOpenTableException();
	}
	
	public boolean isOpen()
	{
		return false;
	}
	
}