package interfaces.eventHandlers;

import interfaces.components.TableButton;

import java.awt.event.ActionEvent;

import common.Log;
import common.NotificationManager;

import exceptions.CouldNotOpenTableException;

public class TableEventHandler extends AbstractEventHandler {

	private static TableEventHandler INSTANCE;

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			((TableButton) e.getSource()).openTable();
		} catch (CouldNotOpenTableException ex) {
			Log.error(ex);
			NotificationManager.showError(ex);
		}
	}

	public static TableEventHandler getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableEventHandler();
		return INSTANCE;
	}

}
