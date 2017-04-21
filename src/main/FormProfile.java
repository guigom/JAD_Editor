package main;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Klasse für die Profilauswahl-Form
 */
public class FormProfile extends JFrame {

	ArrayList<String> profile_alldata;
	JTextArea txt_desc = new JTextArea();
	Profil profile_cache;
	private JPanel frm_profile;

	/**
	 * Startet das Programm
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
	 * Konstruktor für die Profil-Form
	 * @throws IOException Falls kein Profilordner vorhanden ist.
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
			} catch (Exception e) {}
			
		}
		JComboBox cbo_profiles = new JComboBox(path_profiles_manipulate.toArray());
		cbo_profiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComboBox selectedChoice = (JComboBox) e.getSource();
				 try {
					profile_alldata = Reader.readFile(path_profiles.get(cbo_profiles.getSelectedIndex()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				 txt_desc.setText(profile_alldata.get(1));
			}
		});
		cbo_profiles.setBounds(12, 16, 482, 32);
		frm_profile.add(cbo_profiles);
		
		//OK Button zum erzeugen des Profil-Objekts
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				try {
					profile_cache = new Profil(path_profiles.get(cbo_profiles.getSelectedIndex()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//Erzeugt die Main-Form mit dem angelegten Profil-Objekt
							FormMain frame = new FormMain(profile_cache);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btn_ok.setBounds(366, 305, 128, 32);
		frm_profile.add(btn_ok);
		profile_alldata = Reader.readFile(path_profiles.get(cbo_profiles.getSelectedIndex()));
		txt_desc.setText(profile_alldata.get(1));
		txt_desc.setBackground(UIManager.getColor("Label.background"));
		txt_desc.setBounds(12, 61, 342, 276);
		frm_profile.add(txt_desc);
		
	}
}
