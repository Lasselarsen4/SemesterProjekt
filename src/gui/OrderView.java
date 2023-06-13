package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1696450764789703759L;
	private JPanel contentPane;
	private OrderController oc;

	/**
	 * Create the frame.
	 * @param oc 
	 */
	public OrderView(OrderController oc) {
		setTitle("Ordre Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewOrder = new JButton("Ny Ordre");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newOrderClicked();
			}
		});
		GridBagConstraints gbc_btnNewOrder = new GridBagConstraints();
		gbc_btnNewOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewOrder.gridx = 1;
		gbc_btnNewOrder.gridy = 1;
		contentPane.add(btnNewOrder, gbc_btnNewOrder);
		
		JButton btnViewOrders = new JButton("Se ordrer");
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOrdersClicked();
			}
		});
		GridBagConstraints gbc_btnViewOrders = new GridBagConstraints();
		gbc_btnViewOrders.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewOrders.gridx = 1;
		gbc_btnViewOrders.gridy = 2;
		contentPane.add(btnViewOrders, gbc_btnViewOrders);
		
		JButton btnGoBack = new JButton("Gå Tilbage");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackPressed();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.gridx = 1;
		gbc_btnGoBack.gridy = 3;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		init();
	}

	private void init() {
		oc = new OrderController();
	}

	private void newOrderClicked() {
		Order o = oc.createOrder();
		NewOrderView nOM = new NewOrderView(o,oc);
		nOM.setVisible(true);
		
	}

	private void goBackPressed() {
		super.dispose();
	}

	private void viewOrdersClicked() {
		OrderListMenu olm = new OrderListMenu();
		olm.setVisible(true);		
	}

}
