package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import controller.TableBuilder;

import model.*;

public class Main {

	public static void main(String[] args) {
		initializeSaloon();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow mainWindow = new MainWindow();
				mainWindow.loadTables();
			}
		});
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
