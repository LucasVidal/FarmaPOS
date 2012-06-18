package interfaces.eventHandlers;

import java.awt.event.ActionEvent;

public class TableDetailWindowEventHandler extends AbstractEventHandler {

	private static TableDetailWindowEventHandler INSTANCE;

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.dispose();
	}

	public static TableDetailWindowEventHandler getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableDetailWindowEventHandler();
		return INSTANCE;
	}

}
