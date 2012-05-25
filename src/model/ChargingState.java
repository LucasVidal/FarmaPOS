package model;

import java.awt.Color;

public class ChargingState extends AbstractTableState{

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public AbstractTableState closeTable()
	{
		return new ClosedState();
	}
	
}
