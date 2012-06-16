package interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicButtonUI;

import model.Commerce;
import model.Measures;
import model.Room;
import model.Table;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -8429391328345693577L;
	private static final Integer X_FACTOR = 15;
	private static final Integer Y_FACTOR = 15;

	public MainWindow() {
		setTitle("FarmaPOS");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
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
	}
	
	public Measures scaleMeasures(Measures m)
	{
		return new Measures(m.getX()*X_FACTOR,m.getY()*Y_FACTOR,m.getWidth()*X_FACTOR,m.getHeight()*Y_FACTOR);
	}
}