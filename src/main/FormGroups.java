package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormGroups extends JDialog {

	private JPanel frm_groups;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormGroups frame = new FormGroups(TestProfil.getTestProfil());
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormGroups(Profil p, User u) {
		setTitle("Gruppen verwalten");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 386, 512);
		frm_groups = new JPanel();
		frm_groups.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_groups);
		frm_groups.setLayout(null);
		System.out.println(p.getProfGroups().toString());
		
		JList lst_groups = new JList(p.getProfGroups().toArray());
		
		lst_groups.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lst_groups.setBounds(12, 13, 344, 394);
		frm_groups.add(lst_groups);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selected = (String) lst_groups.getSelectedValue();
				System.out.println(Converter.getStringBack(selected));
				u.setUserGroup("Hallo");

			}
		});
		btn_ok.setBounds(260, 420, 96, 32);
		frm_groups.add(btn_ok);
	}
}
