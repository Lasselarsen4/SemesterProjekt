package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.*;

public class MemberListCellRenderer implements ListCellRenderer<Member> {


	@Override
	public Component getListCellRendererComponent(JList<? extends Member> list, Member value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String res = value.getName() + " : " + value.getEmail();
		return new DefaultListCellRenderer().getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}
	

}
