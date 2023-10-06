package davis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Main {
	private JFrame frame;
	private static JTextField itemTextfield;
	private static JTextField costTextfield;
	private static JTextField qtyTextfield;
	private static JButton addButton;
	private static JTextArea salesListTextArea;
	private static JTextField totTextfield;
	private static SalesList salesList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initializeLayout();
		salesList = new SalesList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeLayout() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("SALES LIST");
		lblNewLabel.setBackground(new Color(205, 255, 248));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 16);
		frame.getContentPane().add(lblNewLabel);
		
// INPUT SALES ITEM ELEMENTS
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setBounds(64, 50, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		itemTextfield = new JTextField();
		itemTextfield.setBounds(164, 50, 200, 26);
		frame.getContentPane().add(itemTextfield);
		itemTextfield.setColumns(10);
		itemTextfield.setText("Enter Item Name");
		JLabel lblNewLabel_2 = new JLabel("Cost: $:");
		lblNewLabel_2.setBounds(64, 80, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		costTextfield = new JTextField();
		costTextfield.setBounds(164, 80, 200, 26);
		frame.getContentPane().add(costTextfield);
		costTextfield.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setBounds(64, 110, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		qtyTextfield = new JTextField();
		qtyTextfield.setBounds(164, 110, 200, 26);
		frame.getContentPane().add(qtyTextfield);
		qtyTextfield.setColumns(10);
		
// ADD SALES ITEM BUTTON
		
		addButton = new JButton("Add Item to the Sales List");
		addButton.setBounds(64, 180, 300, 29);
		frame.getContentPane().add(addButton);
		salesListTextArea = new JTextArea();
		salesListTextArea.setBounds(82, 263, 291, 142);
		frame.getContentPane().add(salesListTextArea);
		JLabel lblNewLabel_4 = new JLabel("Total Sales:");
		lblNewLabel_4.setBounds(64, 425, 135, 16);
		frame.getContentPane().add(lblNewLabel_4);
		totTextfield = new JTextField();
		totTextfield.setBounds(155, 425, 130, 26);
		frame.getContentPane().add(totTextfield);
		totTextfield.setColumns(10);
		
// TASK 6: ADD A LISTENER EVENT TO THE BUTTON
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
	}

	public static void addItem() {
		// TASK 1: COLLECT THE INPUT PROVIDED BY THE USER: ITEM, PRICE, QTY
		
		String itemName = itemTextfield.getText();
		Double itemPrice = Double.parseDouble(costTextfield.getText());
		Integer itemQty = Integer.parseInt(qtyTextfield.getText());
		
		// TASK 2: ADD A NEW "ITEM" TO THE SALES LIST
		
		salesList.addNewItem(new SalesItem(itemName, itemQty, itemPrice));
		
		// TASK 3: UPDATE THE SALESLIST OUTPUT
		
		salesListTextArea.setText(salesList.getSalesList());
		Double totalAmt = salesList.computeTotalAmount();
		totTextfield.setText(String.format("%.2f", totalAmt));
	}
}