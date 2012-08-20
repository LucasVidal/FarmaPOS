package interfaces.views;

import interfaces.components.TableButton;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.retrievers.RoomLayoutRetriever;

public class SaloonFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4620446598669105630L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SaloonFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalon = new JLabel("Salon");
		lblSalon.setBounds(0, 0, 0, 0);
		lblSalon.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSalon.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSalon);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tabbedPane.setBounds(5, 11, 1061, 751);
		contentPane.add(tabbedPane);
		JPanel panelSillones = new JPanel();
		JPanel panelFumancheros = new JPanel();
		JPanel panelVereda = new JPanel();
		JPanel panelSaloon = new JPanel();
		
		
		tabbedPane.addTab("Salon", null, panelSaloon, null);
		tabbedPane.addTab("Sillones", null, panelSillones, null);
		tabbedPane.addTab("Fumancheros", null, panelFumancheros, null);
		tabbedPane.addTab("Vereda", null, panelVereda, null);

		
		/* SALON */
		panelSaloon.setLayout(null);
		
		for (TableButton tb: RoomLayoutRetriever.getInstance().getTablesForRoom(1))
			panelSaloon.add(tb);
		
		/* SILLONES */
		/* FUMANCHEROS */
		/* VEREDA */	
	}
}
