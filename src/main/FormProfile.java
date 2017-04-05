package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

public class FormProfile extends JFrame {

	private JPanel frm_profile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProfile frame = new FormProfile();
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
	public FormProfile() {
		setResizable(false);
		setTitle("Select Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 385);
		frm_profile = new JPanel();
		frm_profile.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_profile);
		frm_profile.setLayout(null);
		
		JComboBox cbo_profiles = new JComboBox();
		cbo_profiles.setBounds(12, 16, 482, 32);
		frm_profile.add(cbo_profiles);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.setBounds(366, 305, 128, 32);
		frm_profile.add(btn_ok);
		
		JTextArea txt_desc = new JTextArea();
		txt_desc.setText("Description");
		txt_desc.setBackground(UIManager.getColor("Label.background"));
		txt_desc.setBounds(12, 61, 342, 276);
		frm_profile.add(txt_desc);
	}
}
