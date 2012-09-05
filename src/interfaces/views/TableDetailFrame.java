package interfaces.views;

import interfaces.components.CustomJList;
import interfaces.eventHandlers.TableDetailEventHandler;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Commerce;
import model.Item;
import model.ItemOnTable;
import model.Table;

import common.Log;
import db.retrievers.MenuRetriever;

import exceptions.TableIsNotOpenException;

public class TableDetailFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 265717491964688265L;
	private JPanel contentPane;
	protected Table table;
	private JTree tree;
	private JPanel panel_item_control;
	private JSpinner quantitySpinner;
	private JButton btnAgregar;
	private JPanel panel_der;
	private JPanel panel_izq;
	private CustomJList<ItemOnTable> item_list;
	private JPanel panel_table_summary;
	private TableDetailEventHandler tableDetailEventHandler;

	/**
	 * Launch the frame
	 */
	public static void load(final Table t) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableDetailFrame frame = new TableDetailFrame(t);
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
	public TableDetailFrame(Table t) {
		this.table=t;
		this.tableDetailEventHandler=TableDetailEventHandler.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGola = new JLabel("Viene de mesa" + table.getName());
		lblGola.setHorizontalAlignment(SwingConstants.CENTER);
		lblGola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGola.setBounds(0, 0, 712, 19);
		contentPane.add(lblGola);
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 27, 712, 484);
		contentPane.add(panel_main);
		GridBagLayout gbl_panel_main = new GridBagLayout();
		gbl_panel_main.columnWidths = new int[] {450, 300};
		gbl_panel_main.columnWeights = new double[]{1.0, 0.0};
		gbl_panel_main.rowWeights = new double[]{0.0};
		panel_main.setLayout(gbl_panel_main);
		
		panel_izq = new JPanel();
		GridBagConstraints gbc_panel_izq = new GridBagConstraints();
		gbc_panel_izq.fill = GridBagConstraints.BOTH;
		gbc_panel_izq.insets = new Insets(0, 0, 5, 5);
		gbc_panel_izq.gridx = 0;
		gbc_panel_izq.gridy = 0;
		panel_main.add(panel_izq, gbc_panel_izq);
		GridBagLayout gbl_panel_izq = new GridBagLayout();
		gbl_panel_izq.columnWidths = new int[] {450, 0};
		gbl_panel_izq.rowHeights = new int[] {400, 30};
		gbl_panel_izq.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_izq.rowWeights = new double[]{0.0, 0.0};
		panel_izq.setLayout(gbl_panel_izq);
		
		tree = new JTree(MenuRetriever.getInstance().getMenuAsTreeModel());
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.insets = new Insets(0, 0, 5, 0);
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		
		panel_izq.add(tree, gbc_tree);
		
		panel_item_control = new JPanel();
		GridBagConstraints gbc_panel_item_control = new GridBagConstraints();
		gbc_panel_item_control.anchor = GridBagConstraints.BASELINE;
		gbc_panel_item_control.gridx = 0;
		gbc_panel_item_control.gridy = 1;
		panel_izq.add(panel_item_control, gbc_panel_item_control);
		
		quantitySpinner = new JSpinner();
		panel_item_control.add(quantitySpinner);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					TableDetailFrame.this.addElementsToTable();
				} catch (TableIsNotOpenException e1) {
					Log.error(e1);
				}
			}
		});
		
		panel_item_control.add(btnAgregar);
		
		panel_der = new JPanel();
		GridBagConstraints gbc_panel_der = new GridBagConstraints();
		gbc_panel_der.insets = new Insets(0, 0, 5, 0);
		gbc_panel_der.fill = GridBagConstraints.BOTH;
		gbc_panel_der.gridx = 1;
		gbc_panel_der.gridy = 0;
		panel_main.add(panel_der, gbc_panel_der);
		GridBagLayout gbl_panel_der = new GridBagLayout();
		gbl_panel_der.columnWidths = new int[] {300};
		gbl_panel_der.rowHeights = new int[] {100, 300};
		gbl_panel_der.columnWeights = new double[]{0.0};
		gbl_panel_der.rowWeights = new double[]{1.0, 1.0};
		panel_der.setLayout(gbl_panel_der);
		
		panel_table_summary = new JPanel();
		panel_table_summary.setLayout(null);
		GridBagConstraints gbc_panel_table_summary = new GridBagConstraints();
		gbc_panel_table_summary.insets = new Insets(0, 0, 5, 5);
		gbc_panel_table_summary.fill = GridBagConstraints.BOTH;
		gbc_panel_table_summary.gridx = 0;
		gbc_panel_table_summary.gridy = 0;
		panel_der.add(panel_table_summary, gbc_panel_table_summary);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setBounds(10, 11, 46, 14);
		panel_table_summary.add(lblItems);
		
		JLabel lblTotalMesa = new JLabel("Total mesa");
		lblTotalMesa.setBounds(10, 38, 70, 14);
		panel_table_summary.add(lblTotalMesa);
		
		JLabel lblAbiertaHace = new JLabel("Abierta hace:");
		lblAbiertaHace.setBounds(10, 63, 70, 14);
		panel_table_summary.add(lblAbiertaHace);
		
		item_list = new CustomJList<ItemOnTable>();
		item_list.initializeWithList(table.getContent());
		
		GridBagConstraints gbc_item_list = new GridBagConstraints();
		gbc_item_list.insets = new Insets(0, 0, 0, 5);
		gbc_item_list.fill = GridBagConstraints.BOTH;
		gbc_item_list.gridx = 0;
		gbc_item_list.gridy = 1;
		panel_der.add(item_list, gbc_item_list);
		
		
	}

	protected void addElementsToTable() throws TableIsNotOpenException {
		//((Double) this.quantitySpinner.getValue())
		Item i = Commerce.getInstance().getMenu().get(0);
		ItemOnTable iot= this.table.addItem(i,1.0);
		this.item_list.addElement(iot);
	}
	
}
