package interfaces.eventHandlers;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public abstract class AbstractEventHandler  implements ActionListener {

	protected JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
