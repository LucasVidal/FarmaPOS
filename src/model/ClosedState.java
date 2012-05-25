package model;

import java.awt.Color;

public class ClosedState extends AbstractTableState{

	@Override
	public Color getColor() {
		throw new RuntimeException ("This table should not be shown!");
	}

	
}
