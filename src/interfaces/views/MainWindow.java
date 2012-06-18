package interfaces.views;

import interfaces.eventHandlers.AbstractEventHandler;
import interfaces.eventHandlers.MainWindowEventHandler;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;

import model.Commerce;
import model.Measures;
import model.Room;
import model.Table;

public class MainWindow extends AbstractWindow{

	private static final long serialVersionUID = -8429391328345693577L;
	
	private AbstractEventHandler handler; 

	public MainWindow() {
		this.handler = MainWindowEventHandler.getInstance();
		this.handler.setFrame(this);
		
		setTitle("FarmaPOS");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
		this.loadTables();
	}

	public void loadTables() {
		for (Room r : Commerce.getInstance().getRooms())
			for (Table t : r.getTables())
				this.addTable(t);
	}

	private void addTable(Table t) {
		Measures l = this.scaleMeasures(t.getLocation());
		JButton b = new JButton(t.getName());
		b.setBounds(l.getX(),l.getY(),l.getWidth(),l.getHeight());
		
		this.getContentPane().add(b,BorderLayout.NORTH);
		b.setActionCommand(t.getId()); //The button should be bounded to the table in a JButton subclass instead of using this string.
		b.addActionListener(this.handler);
	}
	
	public Measures scaleMeasures(Measures m)
	{
		return new Measures(m.getX()*X_FACTOR,m.getY()*Y_FACTOR,m.getWidth()*X_FACTOR,m.getHeight()*Y_FACTOR);
	}
}