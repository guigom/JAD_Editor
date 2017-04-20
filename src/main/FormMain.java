package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JScrollPane;


public class FormMain extends JFrame {

	private JPanel frm_main;
	private JTable tbl_main;
	private JScrollPane scp_main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain(new Profil(".\\prof\\Profil1.prof"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//profil
	private Profil activeProfile;
	
	
	
	
	/**
	 * Create the frame.
	 * Bearbeitet 7.04, alle Buttons "rufen etwas auf". 
	 * 
	 */
	public FormMain(Profil selectedProfile) {
		//profil übernehmen
		this.activeProfile=selectedProfile;
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/logo.png"));
		setTitle("JAD Editor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 768);
		frm_main = new JPanel();
		frm_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_main);
		frm_main.setLayout(null);
		
		
		// Button add: 
		// ruft FormAdd.java auf 
		JButton btn_add = new JButton("Eintrag hinzuf\u00FCgen");
		btn_add.setIcon(new ImageIcon("./img/Plus-32.png"));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAdd form = new FormAdd(activeProfile);
				
				form.setVisible(true);
				while(form.isVisible());
				activeProfile.addALUser(form.getUser());
				//ArrayList<String> col_cache = new ArrayList<String>(form.getUser().getUserGenInfo());
				//col_cache.add(form.getUser().getUserOU());
				//col_cache.add(form.getUser().getUserGroup());
				//tbl_main.getModel().insertRow(tbl_main.getRowCount(),col_cache.toArray());
				//tbl_main.add(col_cache.toArray());
				alter_table();
				form.dispose();
				System.out.println(activeProfile.getALUSER().get(0).getUserGenInfo().toString());
				System.out.print(activeProfile.getALUSER().get(0).getUserGroup());
				System.out.print(activeProfile.getALUSER().get(0).getUserOU());
			}
		});
		btn_add.setBounds(816, 16, 192, 40);
		frm_main.add(btn_add);
		
		// Button enfernen: 
		// ruft erstamal (!) FormAdd.java auf.  
		// 
		JButton btn_del = new JButton("Eintrag entfernen");
		btn_del.setIcon(new ImageIcon("./img/Minus-32.png"));
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = tbl_main.getSelectedRow();
				System.out.println(rowIndex);
				activeProfile.removeALUser(activeProfile.getALUSER().get(rowIndex));
				alter_table();
			}
		});
		btn_del.setBounds(816, 72, 192, 40);
		frm_main.add(btn_del);
		
		JButton btn_export = new JButton("Export");
		btn_export.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SelectFile.saveFile(Converter.formatUser(activeProfile));
			}
		});
		btn_export.setIcon(new ImageIcon("./img/Share 3-32.png"));
		btn_export.setBounds(814, 680, 192, 40);
		frm_main.add(btn_export);
		
		// About - Fenster
		JButton btn_about = new JButton("About");
		btn_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAbout form = new FormAbout();
				form.setVisible(true);
				//tbl_main = new JTable(TestTableContent.getTestStringArray(),TestArrayTableHeader.getTestStringHeaderArray());
			}
		});
		btn_about.setIcon(new ImageIcon("./img/Info-32.png"));
		btn_about.setBounds(814, 624, 192, 40);
		frm_main.add(btn_about);
		
		scp_main = new JScrollPane();
		scp_main.setBounds(12, 16, 780, 704);
		frm_main.add(scp_main);
		
		//Zusammensetzen des Headers für die JTable
		ArrayList<String> col_names = new ArrayList<String>(activeProfile.getProfGenInfo());
		col_names.add("Gruppe");	//fixe Werte
		col_names.add("OU");		
		
		//Leeres 2 Dimensionales Array zur 1. Darstellung
		Object [] [] row_data = new Object[1][activeProfile.getProfGenInfo().size()+2];
		
		
		//JTable erstellen
		tbl_main = new JTable(row_data, col_names.toArray());
		tbl_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		scp_main.setViewportView(tbl_main);
	}
	
	public void alter_table()
	{
		System.out.println("testtesttest" + activeProfile.getALUSER().size());
		//activeProfile.getALUSER().size();
		ArrayList<String> row_cache;
		Object [] [] row_data = new Object[activeProfile.getALUSER().size()][activeProfile.getProfGenInfo().size()+2];
		for(int i =0; i<activeProfile.getALUSER().size(); i++)
		{
			row_cache = new ArrayList<String>(activeProfile.getALUSER().get(i).getUserGenInfo());
			row_cache.add(activeProfile.getALUSER().get(i).getUserGroup());
			row_cache.add(activeProfile.getALUSER().get(i).getUserOU());
			row_data [i]= row_cache.toArray(); 
		}
		System.out.println(row_data[0][0]);
		ArrayList<String> col_names = new ArrayList<String>(activeProfile.getProfGenInfo());
		col_names.add("Gruppe");	//fixe Werte
		col_names.add("OU");		
		
		tbl_main = new JTable(row_data, col_names.toArray());
		scp_main.setViewportView(tbl_main);
		System.out.println("Tabelleninhalt: " + tbl_main.getModel().getValueAt(0, 0));

	}
}
