package interfaces.views;


import java.awt.EventQueue;

import db.retrievers.MenuRetriever;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initializeApp();
					SaloonFrame frame = new SaloonFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void initializeApp() {
		System.out.print("Initializing menu");
		MenuRetriever.getInstance().getMenu();
	}
}

