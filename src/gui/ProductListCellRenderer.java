package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.BasicProduct;
import model.Product;

public class ProductListCellRenderer implements ListCellRenderer<Product> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String res = value.getName() + " (Barcode: " + value.getBarCode() + ") ";
		if(value instanceof BasicProduct) {
			res += "(Loc: " + ((BasicProduct)value).getLocation() + ") ";
		}
		return new DefaultListCellRenderer().getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}
	

}
