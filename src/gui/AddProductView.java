package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order;
import model.OrderLine;
import model.Product;
import model.ProductContainer;

public class AddProductView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5400447261636431980L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtQuantity;
	private JList<Product> list;
	private DefaultListModel<Product> dlm;
	private Product selectedProduct;
	private OrderController oc;
	private NewOrderView newOrderView;

	/**
	 * Create the dialog.
	 */
	public AddProductView(Product p, OrderController oc, Order o) {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);

		list = new JList<Product>();
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 85, 0 };
		gbl_panel.rowHeights = new int[] { 21, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);


		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Mængde:");
		buttonPane.add(lblNewLabel);

		txtQuantity = new JTextField();
		buttonPane.add(txtQuantity);
		txtQuantity.setColumns(10);

		JButton btnOk = new JButton("Tilføj");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClicked();
			}
		});
		btnOk.setActionCommand("OK");
		buttonPane.add(btnOk);
		getRootPane().setDefaultButton(btnOk);

		JButton cancelButton = new JButton("Annuller");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelClicked();
			}
		});
		cancelButton.setActionCommand("Annuller");
		buttonPane.add(cancelButton);
		this.oc = oc;
		init(p, oc, o);
	}

	private void init(Product p, OrderController oc, Order o) {
	    list.setCellRenderer(new ProductListCellRenderer());
	    this.oc = oc;
	    updateProducts();
	}

	private void updateProducts() {
	    dlm = new DefaultListModel<>();
	    for (Product product : ProductContainer.getInstance().getAllProducts()) {
	        dlm.addElement(product);
	    }
	    list.setModel(dlm);
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	private void cancelClicked() {
		super.setVisible(false);
		super.dispose();
	}

	private void addClicked() {
		try {
			int quantity = Integer.parseInt(txtQuantity.getText());
			if (quantity != 0 && list.getSelectedValue() != null) {
				oc.addProduct(list.getSelectedValue().getBarCode(), quantity);
				newOrderView.addOrderLine(createOrderLine());
				cancelClicked();
			} else {
				JOptionPane.showMessageDialog(this, "Produkt er ikke valgt, eller mængde er 0");
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Mængde skal være et tal!");
		}
	}


	public void notifyMe() {
		updateProducts();
	}

	public void toNotifyNom(NewOrderView nov) {
	}
	public void setNewOrderView(NewOrderView newOrderView) {
		this.newOrderView = newOrderView;
	}
	private OrderLine createOrderLine() {
	    Product selectedProduct = list.getSelectedValue();
	    int quantity = Integer.parseInt(txtQuantity.getText());
	    OrderLine orderLine = new OrderLine(selectedProduct, quantity);
	    return orderLine;
	}


}

