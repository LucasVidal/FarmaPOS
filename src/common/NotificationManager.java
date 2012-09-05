package common;

import javax.swing.JOptionPane;

public class NotificationManager {

	public static void showError(Exception e) {

		JOptionPane.showMessageDialog(null, e.getMessage(), "FarmaPOS", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
