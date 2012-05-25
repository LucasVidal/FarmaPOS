package model;

import java.awt.Color;

public class OpenState extends AbstractTableState{

	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	
	@Override
	public boolean isOpen()
	{
		return true;
	}
	
	@Override
	public AbstractTableState chargeTable()
	{
		return new ChargingState();
	}
}
