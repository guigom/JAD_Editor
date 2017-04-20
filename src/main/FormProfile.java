package main;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class FormProfile extends JFrame {

	ArrayList<String> profile_alldata;
	JTextArea txt_desc = new JTextArea();
	Profil profile_cache;
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
	 * @throws IOException 
	 */
	public FormProfile() throws IOException {
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
		ArrayList<String> path_profiles_manipulate = new ArrayList<>();
		path_profiles_manipulate.addAll(0, path_profiles);
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
		cbo_profiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComboBox selectedChoice = (JComboBox) e.getSource();
				 System.out.println(selectedChoice.getSelectedIndex());
				 System.out.println(path_profiles.get(selectedChoice.getSelectedIndex()));
				 //test.setText(path_profiles.get(selectedChoice.getSelectedIndex()));
				 try {
					profile_alldata = Reader.readFile(path_profiles.get(cbo_profiles.getSelectedIndex()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 txt_desc.setText(profile_alldata.get(1));
			}
		});
		cbo_profiles.setBounds(12, 16, 482, 32);
		//test System.out.println(cbo_profiles.getSelectedIndex());
		//     System.out.println(path_profiles.get(cbo_profiles.getSelectedIndex()));
		frm_profile.add(cbo_profiles);
		
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		/////////////
				setVisible(false);
				dispose();
				try {
					profile_cache = new Profil(path_profiles.get(cbo_profiles.getSelectedIndex()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormMain frame = new FormMain(profile_cache);
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
		
		//gelesene Datei (1. Durchlauf)
		profile_alldata = Reader.readFile(path_profiles.get(cbo_profiles.getSelectedIndex()));
		
		//JTextArea txt_desc = new JTextArea();
		txt_desc.setText(profile_alldata.get(1));
		txt_desc.setBackground(UIManager.getColor("Label.background"));
		txt_desc.setBounds(12, 61, 342, 276);
		frm_profile.add(txt_desc);
		
	}
}
