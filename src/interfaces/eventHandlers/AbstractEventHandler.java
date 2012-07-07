package interfaces.eventHandlers;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public abstract class AbstractEventHandler  implements ActionListener {

	@Deprecated
	protected JFrame frame;
	
	@Deprecated
	public JFrame getFrame() {
		return frame;
	}


	@Deprecated
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
