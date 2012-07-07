package model;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FreeState extends AbstractTableState {

	public static String ICON_FILE = "/res/images/free_table_state.png";
	
	@Override
	public Color getColor() {
		return Color.GREEN;
	}

	@Override
	public AbstractTableState openTable() {
		return new OpenState();
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(FreeState.class.getResource("/images/free_table_state.png"));
	}
}