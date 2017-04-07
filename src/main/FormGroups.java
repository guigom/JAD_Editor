package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.AbstractListModel;

public class FormGroups extends JFrame {

	private JPanel frm_groups;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormGroups frame = new FormGroups();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormGroups() {
		setTitle("Gruppen verwalten");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 386, 512);
		frm_groups = new JPanel();
		frm_groups.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_groups);
		frm_groups.setLayout(null);
		
		JList lst_groups = new JList();
		lst_groups.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lst_groups.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lst_groups.setBounds(12, 13, 344, 394);
		frm_groups.add(lst_groups);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setBounds(260, 420, 96, 32);
		frm_groups.add(btn_ok);
	}
}
