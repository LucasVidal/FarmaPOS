package interfaces.views;

import javax.swing.SwingUtilities;

public class WindowManager {

	private static WindowManager INSTANCE;

	public static WindowManager getInstance() {
		if (INSTANCE ==null)
			INSTANCE = new WindowManager();
		return INSTANCE;
	}

	public void createTableDetailsView(final String tableReference) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				TableDetailWindow tableDetailWindow = new TableDetailWindow(tableReference);
			}
		});
	}
	
}
