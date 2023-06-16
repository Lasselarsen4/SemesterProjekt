package gui;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Order;

public class OrderListCellRenderer implements ListCellRenderer<Order> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Order> list, Order value, int index, boolean isSelected,
			boolean cellHasFocus) {
		String customerName = (value.getCustomer() != null) ? value.getCustomer().getName() : "N/A";
		String res = String.format("Ordre #%d - Kunde: %s - Pris: %s - Dato: %s", value.getOrderNumber(), customerName, value.getTotalCost(), value.getOrderDate());
		return new DefaultListCellRenderer().getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}

}
