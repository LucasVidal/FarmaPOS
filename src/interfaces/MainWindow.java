package interfaces;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -8429391328345693577L;

	public MainWindow() {
		setTitle("Simple example");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
	}

	public void loadTables() {
		//aca vienen a entrar todas las mesas 
		
	}

}