package interfaces.eventHandlers;

import interfaces.components.TableButton;

import java.awt.event.ActionEvent;

public class TableEventHandler extends AbstractEventHandler {

	private static TableEventHandler INSTANCE;

	@Override
	public void actionPerformed(ActionEvent e) {
		((TableButton) e.getSource()).openTable();
	}

	public static TableEventHandler getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableEventHandler();
		return INSTANCE;
	}

}
