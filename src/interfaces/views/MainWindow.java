package interfaces.views;


import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Commerce;
import model.Measures;
import model.Room;
import controller.TableBuilder;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void initializeSaloon()
	{
		Room r = new Room ("Salon 1");
		
		
		r.addTables(new TableBuilder().withRoom(r).withName("Mesa 1").withLocation(new Measures(10,10,10,10)).build(),
					new TableBuilder().withRoom(r).withName("Mesa 2").withLocation(new Measures(22,10,10,10)).build(),
					new TableBuilder().withRoom(r).withName("Mesa 3").withLocation(new Measures(34,10,10,10)).build(),
					new TableBuilder().withRoom(r).withName("Mesa 4").withLocation(new Measures(10,22,10,10)).build(),
					new TableBuilder().withRoom(r).withName("Mesa 5").withLocation(new Measures(22,22,10,10)).build(),
					new TableBuilder().withRoom(r).withName("Mesa 6").withLocation(new Measures(34,22,10,10)).build());
		
		Commerce.getInstance().addRoom(r);
		
	}
	
}

