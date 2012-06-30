package interfaces.views;

import javax.swing.JFrame;

public abstract class AbstractWindow extends JFrame {

	protected static final Integer X_FACTOR = 15;
	protected static final Integer Y_FACTOR = 15;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractWindow()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationByPlatform(true);

		setSize(WindowManager.MAX_WINDOW_DIMENSION);
		
		this.setResizable(false);
		this.setLayout(null);
	}
}
