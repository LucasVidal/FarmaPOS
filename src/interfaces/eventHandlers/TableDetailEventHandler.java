package interfaces.eventHandlers;

import interfaces.components.TableButton;

import java.awt.event.ActionEvent;

import common.Log;
import common.NotificationManager;

import exceptions.CouldNotOpenTableException;

public class TableDetailEventHandler extends AbstractEventHandler {

	private static TableDetailEventHandler INSTANCE;

	@Override
	public void actionPerformed(ActionEvent e) {
		/*try {
			((TableButton) e.getSource()).openTable();
		} catch (CouldNotOpenTableException ex) {
			Log.error(ex);
			NotificationManager.showError(ex);
		}*/
		Log.error(new RuntimeException("Still nothing to do"));
	}

	public static TableDetailEventHandler getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableDetailEventHandler();
		return INSTANCE;
	}
}
