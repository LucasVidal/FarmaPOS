package interfaces.eventHandlers;

import interfaces.views.WindowManager;

import java.awt.event.ActionEvent;

public class MainWindowEventHandler extends AbstractEventHandler {

	private static MainWindowEventHandler INSTANCE;

	public static MainWindowEventHandler getInstance() {
		if (INSTANCE == null)
			INSTANCE = new MainWindowEventHandler();
		return INSTANCE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowManager.getInstance().createTableDetailsView(e.getActionCommand());
	}
}
