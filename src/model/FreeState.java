package model;

import java.awt.Color;

public class FreeState extends AbstractTableState {

	@Override
	public Color getColor() {
		return Color.GREEN;
	}

	@Override
	public AbstractTableState openTable() {
		return new OpenState();
	}
}