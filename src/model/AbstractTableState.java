package model;

import java.awt.Color;

import exceptions.*;

public abstract class AbstractTableState {

	public abstract Color getColor();
	
	public static AbstractTableState getDefaultState() {
		return new FreeState();
	}

	public AbstractTableState openTable() throws CouldNotOpenTableException{
		throw new CouldNotOpenTableException();
	}
	public AbstractTableState closeTable() throws TableIsNotChargingException {
		throw new TableIsNotChargingException();
	}
	
	public boolean isOpen()
	{
		return false;
	}

	public AbstractTableState chargeTable() throws CouldNotChargeException {
		throw new CouldNotChargeException();
	}

	
}