package interfaces.views;

import java.awt.Dimension;

import model.Table;

public class WindowManager {
	
	public static int MAX_X = 1280;
	public static int MAX_Y = 800;
	public static Dimension MAX_WINDOW_DIMENSION = new Dimension(MAX_X,MAX_Y);
	public static Dimension TABLE_DETAIL_WINDOW_DIMENSION = new Dimension(MAX_X,MAX_Y);

	private static WindowManager INSTANCE;

	public static WindowManager getInstance() {
		if (INSTANCE ==null)
			INSTANCE = new WindowManager();
		return INSTANCE;
	}

	public void createTableDetailsView(final Table tableReference) {
		@SuppressWarnings("unused")
		TableDetailWindow tableDetailWindow = new TableDetailWindow(tableReference);
	}
	
}
