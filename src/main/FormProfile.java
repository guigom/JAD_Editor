package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 385);
		frm_profile = new JPanel();
		frm_profile.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_profile);
		frm_profile.setLayout(null);
		
		//Profile holen, in Zwischenspeicher manipulieren und mit Combobox aufrufen
		ArrayList<String> path_profiles = Reader.getProfiles();
		ArrayList<String> path_profiles_manipulate = path_profiles;
		for(int i=0; i<path_profiles_manipulate.size();i++ )
		{
			
			try {
				path_profiles_manipulate.set(i, path_profiles_manipulate.get(i).substring(7, path_profiles_manipulate.get(i).length()-5));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
		JComboBox cbo_profiles = new JComboBox(path_profiles_manipulate.toArray());
		cbo_profiles.setBounds(12, 16, 482, 32);
		frm_profile.add(cbo_profiles);
		
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		/////////////
				setVisible(false);
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormMain frame = new FormMain();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		//////////////
			}
		});
		btn_ok.setBounds(366, 305, 128, 32);
		frm_profile.add(btn_ok);
		
		JTextArea txt_desc = new JTextArea();
		txt_desc.setText("Description");
		txt_desc.setBackground(UIManager.getColor("Label.background"));
		txt_desc.setBounds(12, 61, 342, 276);
		frm_profile.add(txt_desc);
	}
}
