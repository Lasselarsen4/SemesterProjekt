package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.OrderLine;

public class OrderLineListCellRenderer implements ListCellRenderer<OrderLine> {

	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLine> list, OrderLine value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String res = value.getProduct().getName() + " Quantity: " + value.getQuantity() + " Value: " + value.getPrice();
		return new DefaultListCellRenderer().getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}

}