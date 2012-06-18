package interfaces.views;

import interfaces.eventHandlers.*;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;

public class TableDetailWindow extends AbstractWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbstractEventHandler handler;
	
	public TableDetailWindow() {
		this.handler = TableDetailWindowEventHandler.getInstance();
		this.handler.setFrame(this);
		
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
		
		JButton b = new JButton("Volver");
		b.setBounds(100,100,100,100);
	
		this.getContentPane().add(b,BorderLayout.PAGE_START);
		b.addActionListener(this.handler);
	}

	public TableDetailWindow(String tableReference) {
		this();
		this.setTitle("Table details for: "+tableReference);
	}


}
