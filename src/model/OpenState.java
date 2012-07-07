package model;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

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
	
	@Override
	public Icon getIcon() {
		return new ImageIcon(FreeState.class.getResource("/images/open_table_state.png"));
	}

}
