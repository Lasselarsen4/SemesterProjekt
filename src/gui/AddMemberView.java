package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import model.*;

public class AddMemberView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9090744555411366304L;
	private final JPanel contentPanel = new JPanel();
	private Member selectedM;
	private JList<Member> list;
	private OrderController oc;

	/**
	 * Create the dialog.
	 * 
	 * @param o
	 */
	public AddMemberView(Order o, OrderController oc) {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.EAST);
			{
				list = new JList<Member>();
				scrollPane.setViewportView(list);
				setupList();
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSelect = new JButton("Select");
				btnSelect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectPressed();
					}
				});
				btnSelect.setActionCommand("OK");
				buttonPane.add(btnSelect);
				getRootPane().setDefaultButton(btnSelect);
			}
			{
				JButton btnCancel = new JButton("Annuller");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelPressed();
					}
				});
				btnCancel.setActionCommand("Annuller");
				buttonPane.add(btnCancel);
			}

		}
		init(o, oc);
	}

	private void init(Order o, OrderController oc) {
		this.oc = oc;
	}

	private void setupList() {
	    list.setCellRenderer(new MemberListCellRenderer());
	    DefaultListModel<Member> dlm = new DefaultListModel<>();
	    List<Member> allMembers = MemberContainer.getInstance().getAllMembers();
	    for (Member member : allMembers) {
	        dlm.addElement(member);
	    }
	    list.setModel(dlm);
	}

	private void cancelPressed() {
		super.dispose();
	}

	private void selectPressed() {
		selectedM = (Member) list.getSelectedValue();
		if (selectedM != null) {
			oc.addMember(selectedM.getEmail());
			cancelPressed();
		} else {
			JOptionPane.showMessageDialog(this, "Ingen kunde valgt");
		}
	}

	public Member getSelectedMember() {
		return selectedM;
	}

}
