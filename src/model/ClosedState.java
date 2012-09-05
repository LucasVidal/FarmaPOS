package model;

import java.awt.Color;

import javax.swing.Icon;

public class ClosedState extends AbstractTableState{

	@Override
	public Color getColor() {
		throw new RuntimeException ("This table should not be shown!");
	}

	@Override
	public Icon getIcon() {
		throw new RuntimeException ("This table should not be shown!");
	}

	
	
}
