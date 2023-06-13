package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Order;
import model.OrderContainer;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class OrderListMenu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7144013266706949031L;
	private final JPanel contentPanel = new JPanel();
	private JList<Order> list;

	/**
	 * Create the dialog.
	 */
	public OrderListMenu() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				list = new JList<>();
				scrollPane.setViewportView(list);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGoBack = new JButton("Gå Tilbage");
				btnGoBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						goBackClicked();
					}
				});
				btnGoBack.setActionCommand("Annuller");
				buttonPane.add(btnGoBack);
			}
		}
		init();
	}
	
	private void init() {        
	    list.setCellRenderer(new OrderListCellRenderer());
	    DefaultListModel<Order> dlm = new DefaultListModel<>();
	    List<Order> allOrders = OrderContainer.getInstance().getAllOrders();
	    for (Order order : allOrders) {
	        dlm.addElement(order);
	    }
	    list.setModel(dlm);
	}

	private void goBackClicked() {
		super.setVisible(false);
		super.dispose();
	}

}
