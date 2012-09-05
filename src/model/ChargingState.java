package model;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

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
	
	@Override
	public Icon getIcon() {
		return new ImageIcon(FreeState.class.getResource("/images/charging_table_state.png"));
	}

}
