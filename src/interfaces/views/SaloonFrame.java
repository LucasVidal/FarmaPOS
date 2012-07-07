package interfaces.views;

import interfaces.components.TableButton;
import interfaces.components.TableButtonFactory;
import interfaces.eventHandlers.TableEventHandler;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SaloonFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4620446598669105630L;
	private JPanel contentPane;
	private ActionListener tableEventHandler;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaloonFrame frame = new SaloonFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		this.tableEventHandler = TableEventHandler.getInstance();
		
		TableButton tableButton_1 = 	TableButtonFactory.createTableButton("1",this.tableEventHandler);
		TableButton tableButton_1A = 	TableButtonFactory.createTableButton("1A",this.tableEventHandler);
		TableButton tableButton_2 = 	TableButtonFactory.createTableButton("2",this.tableEventHandler);
		TableButton tableButton_3 = 	TableButtonFactory.createTableButton("3",this.tableEventHandler);
		TableButton tableButton_3A =	TableButtonFactory.createTableButton("3A",this.tableEventHandler);
		TableButton tableButton_4 = 	TableButtonFactory.createTableButton("4",this.tableEventHandler);
		TableButton tableButton_4A = 	TableButtonFactory.createTableButton("4A",this.tableEventHandler);
		TableButton tableButton_5 = 	TableButtonFactory.createTableButton("5",this.tableEventHandler);
		TableButton tableButton_5A = 	TableButtonFactory.createTableButton("5A",this.tableEventHandler);
		TableButton tableButton_6 = 	TableButtonFactory.createTableButton("6",this.tableEventHandler);
		TableButton tableButton_7 = 	TableButtonFactory.createTableButton("7",this.tableEventHandler);
		TableButton tableButton_9 = 	TableButtonFactory.createTableButton("9",this.tableEventHandler);
		TableButton tableButton_9A = 	TableButtonFactory.createTableButton("9A",this.tableEventHandler);
		TableButton tableButton_10 = 	TableButtonFactory.createTableButton("10",this.tableEventHandler);
		TableButton tableButton_10A = 	TableButtonFactory.createTableButton("10A",this.tableEventHandler);
		TableButton tableButton_11 = 	TableButtonFactory.createTableButton("11",this.tableEventHandler);
		TableButton tableButton_12 = 	TableButtonFactory.createTableButton("12",this.tableEventHandler);
		TableButton tableButton_12A = 	TableButtonFactory.createTableButton("12A",this.tableEventHandler);
		
		tableButton_1.setBounds(10, 164, 70, 70);
		tableButton_1A.setBounds(94, 164, 70, 70);
		tableButton_2.setBounds(10, 366, 70, 70);
		tableButton_3.setBounds(220, 557, 70, 70);
		tableButton_3A.setBounds(220, 482, 70, 70);
		tableButton_4.setBounds(343, 559, 70, 61);
		tableButton_4A.setBounds(343, 484, 70, 61);
		tableButton_5.setBounds(466, 555, 70, 68);
		tableButton_5A.setBounds(466, 482, 70, 70);
		tableButton_6.setBounds(586, 557, 70, 70);
		tableButton_7.setBounds(586, 283, 70, 70);
		tableButton_9.setBounds(466, 138, 70, 70);
		tableButton_9A.setBounds(466, 217, 70, 70);
		tableButton_10.setBounds(364, 138, 70, 70);
		tableButton_10A.setBounds(364, 215, 70, 70);
		tableButton_11.setBounds(220, 256, 70, 70);
		tableButton_12.setBounds(220, 181, 70, 70);
		tableButton_12A.setBounds(220, 106, 70, 70);
		
		panelSaloon.add(tableButton_1);
		panelSaloon.add(tableButton_1A);
		panelSaloon.add(tableButton_2);
		panelSaloon.add(tableButton_3);
		panelSaloon.add(tableButton_3A);
		panelSaloon.add(tableButton_4);
		panelSaloon.add(tableButton_4A);
		panelSaloon.add(tableButton_5);
		panelSaloon.add(tableButton_5A);
		panelSaloon.add(tableButton_6);
		panelSaloon.add(tableButton_7);
		panelSaloon.add(tableButton_9);
		panelSaloon.add(tableButton_9A);
		panelSaloon.add(tableButton_10);
		panelSaloon.add(tableButton_10A);
		panelSaloon.add(tableButton_11);
		panelSaloon.add(tableButton_12);
		panelSaloon.add(tableButton_12A);

		/* SILLONES */
		/* FUMANCHEROS */
		/* VEREDA */	
	}
}
