package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class MainMenuView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8578291573695802716L;
	private JPanel contentPane;
	private OrderController oc;

	/**
	 * Create the frame.
	 */
	public MainMenuView() {
		setTitle("Hovedmenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton orderMenuBtn = new JButton("Ordre Menu");
		orderMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderMenuClicked();
			}
		});
		GridBagConstraints gbc_orderMenuBtn = new GridBagConstraints();
		gbc_orderMenuBtn.anchor = GridBagConstraints.WEST;
		gbc_orderMenuBtn.insets = new Insets(0, 0, 5, 5);
		gbc_orderMenuBtn.gridx = 1;
		gbc_orderMenuBtn.gridy = 1;
		contentPane.add(orderMenuBtn, gbc_orderMenuBtn);
		

		JButton memberBtn = new JButton("Kunder");
		GridBagConstraints gbc_memberBtn = new GridBagConstraints();
		gbc_memberBtn.anchor = GridBagConstraints.WEST;
		gbc_memberBtn.insets = new Insets(0, 0, 5, 5);
		gbc_memberBtn.gridx = 1;
		gbc_memberBtn.gridy = 3;
		contentPane.add(memberBtn, gbc_memberBtn);
		

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutClicked();
			}
		});
		GridBagConstraints gbc_logoutBtn = new GridBagConstraints();
		gbc_logoutBtn.insets = new Insets(0, 0, 0, 5);
		gbc_logoutBtn.anchor = GridBagConstraints.WEST;
		gbc_logoutBtn.gridx = 1;
		gbc_logoutBtn.gridy = 4;
		contentPane.add(logoutBtn, gbc_logoutBtn);
	}

	private void orderMenuClicked() {
		OrderView oV = new OrderView(oc);
		oV.setVisible(true);
		
	}
	private void logOutClicked() {
		System.exit(0);
	}

}
