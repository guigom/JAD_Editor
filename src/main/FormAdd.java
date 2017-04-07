package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormAdd extends JFrame {

	private JPanel frm_add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAdd frame = new FormAdd();
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
	public FormAdd() {
		setResizable(false);
		setTitle("Eintrag hinzuf\u00FCgen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 156);
		frm_add = new JPanel();
		frm_add.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_add);
		frm_add.setLayout(null);
		
		JComboBox cbo_ou = new JComboBox();
		cbo_ou.setBounds(16, 16, 256, 32);
		frm_add.add(cbo_ou);
		
		JButton btn_grp = new JButton("Gruppen...");
		btn_grp.setBounds(288, 16, 192, 32);
		frm_add.add(btn_grp);
		
		JButton btn_add = new JButton("OK");
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btn_add.setBounds(288, 64, 192, 32);
		frm_add.add(btn_add);
	}
}
