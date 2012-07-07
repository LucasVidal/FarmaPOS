package interfaces.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.FreeState;

public final class TableButtonFactory {
	
	/**
	 * @wbp.factory
	 */
	public static TableButton createTableButton(String name, ActionListener listener) {
		TableButton tb = new TableButton();
		tb.setText(name);
		tb.setTableId(name);
		
		tb.setBackground(new FreeState().getColor());
		tb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tb.setIcon(new FreeState().getIcon());
		tb.setHorizontalTextPosition(JButton.CENTER);
		tb.setVerticalTextPosition(JButton.CENTER);
		
		tb.addActionListener(listener);
		//tableButton.set
		return tb;
	}
	
}