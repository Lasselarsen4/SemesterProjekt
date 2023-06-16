package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import model.*;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class NewOrderView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7698719206652962845L;
	private final JPanel contentPanel = new JPanel();
	private Order o;
	private List<OrderLine> orderLines;
	private JList<OrderLine> listProducts;
	private DefaultListModel<OrderLine> dLM;
	private Member member;
	private JLabel lblMember;
	private OrderController oc;

	/**
	 * Create the dialog.
	 * 
	 * @param o
	 */
	public NewOrderView(Order o, OrderController oc) {
		setTitle("Ny ordre");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JButton btnAddProduct = new JButton("Tilføj Produkt");
			btnAddProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addProductClicked();
				}
			});
			{
			}
			GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
			gbc_btnAddProduct.insets = new Insets(0, 0, 5, 5);
			gbc_btnAddProduct.gridx = 1;
			gbc_btnAddProduct.gridy = 2;
			contentPanel.add(btnAddProduct, gbc_btnAddProduct);
		}
		{
			JButton btnAddMember = new JButton("Tilføj Kunde");
			btnAddMember.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addMemberPressed();
				}
			});
			GridBagConstraints gbc_btnAddMember = new GridBagConstraints();
			gbc_btnAddMember.insets = new Insets(0, 0, 5, 5);
			gbc_btnAddMember.gridx = 1;
			gbc_btnAddMember.gridy = 3;
			contentPanel.add(btnAddMember, gbc_btnAddMember);
		}
		{
			lblMember = new JLabel("Kunde: Ingen");
			GridBagConstraints gbc_lblMember = new GridBagConstraints();
			gbc_lblMember.insets = new Insets(0, 0, 0, 5);
			gbc_lblMember.gridx = 1;
			gbc_lblMember.gridy = 4;
			contentPanel.add(lblMember, gbc_lblMember);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfirm = new JButton("Bekræft");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmPressed();
					}
				});
				btnConfirm.setActionCommand("OK");
				buttonPane.add(btnConfirm);
				getRootPane().setDefaultButton(btnConfirm);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelPressed();
					}
				});
				cancelButton.setActionCommand("Annuller");
				buttonPane.add(cancelButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				listProducts = new JList<OrderLine>();
				scrollPane.setViewportView(listProducts);
			}
		}
		init(o, oc);
	}

	private void confirmPressed() {
		oc.finishOrder();
		JOptionPane.showMessageDialog(this, "Ordre oprettet!");
		super.dispose();
	}

	private void addMemberPressed() {
		AddMemberView aMv = new AddMemberView(o, oc);
		aMv.setVisible(true);
		member = aMv.getSelectedMember();
		lblMember.setText("Kunde: " + member.getName());
	}

	private void cancelPressed() {
		super.dispose();
	}

	private void init(Order o, OrderController oc) {
	    this.o = o;
	    this.oc = oc;
	    dLM = new DefaultListModel<>();
	    orderLines = new ArrayList<>();
	    listProducts.setCellRenderer(new OrderLineListCellRenderer());
	    updateList();
	}

	private void addProductClicked() {
		AddProductView aPv = new AddProductView(null, oc, o);
		aPv.setNewOrderView(this);
		aPv.setVisible(true);

	}

	private void updateList() {
		dLM.clear();
	    for (OrderLine orderLine : orderLines) {
	        dLM.addElement(orderLine);
	    }
	    listProducts.setModel(dLM);
	}

	public void notifyMe() {
		updateList();
	}
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
		updateList();
	}
}
