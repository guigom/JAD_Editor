package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;


public class FormMain extends JFrame {

	private JPanel frm_main;
	private JTable tbl_main;
	private JScrollPane scp_main;

	//profil
	private Profil activeProfile;
	
	
	
	
	/**
	 * Konstruktor für die Main-Form.
	 * Benötigt ein Profil-Objekt für die JTable-Komponente.
	 * @param selectedProfile Das Profil-Objekt aus der FormProfile.
	 */
	public FormMain(Profil selectedProfile) {
		
		//Profil übernehmen
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
		
		
		//Button zum aufrufen der FormAdd
		JButton btn_add = new JButton("Eintrag hinzuf\u00FCgen");
		btn_add.setIcon(new ImageIcon("./img/Plus-32.png"));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAdd form = new FormAdd(activeProfile);
				
				form.setVisible(true);
				while(form.isVisible());
				if(form.getUser()!=null)activeProfile.addALUser(form.getUser());
				alter_table();
				form.dispose();
			}
		});
		btn_add.setBounds(816, 16, 192, 40);
		frm_main.add(btn_add);
		 
		//Erzeugt den Entfernen-Button. Ermöglicht das Entfernen eines EIntrags im JTable
		JButton btn_del = new JButton("Eintrag entfernen");
		btn_del.setIcon(new ImageIcon("./img/Minus-32.png"));
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = tbl_main.getSelectedRow();
				activeProfile.removeALUser(activeProfile.getALUSER().get(rowIndex));
				alter_table();
			}
		});
		btn_del.setBounds(816, 72, 192, 40);
		frm_main.add(btn_del);
		
		//Button zum exportieren der .csv-Datei
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
		
		// Erzeugt das About-Fenster
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
		ArrayList<String> col_names = new ArrayList<String>(Converter.getStringFront(activeProfile.getProfGenInfo()));
		col_names.add("Gruppe");	//fixe Werte
		col_names.add("OU");		
		
		//Leeres 2 Dimensionales Array zur 1. Darstellung
		Object [] [] row_data = new Object[1][activeProfile.getProfGenInfo().size()+2];
		
		
		//JTable erstellen
		tbl_main = new JTable(row_data, col_names.toArray());
		tbl_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		scp_main.setViewportView(tbl_main);
	}
	/**
	 * Methode zum Abgleich des JTables mit der User-ArrayList des Profils
	 */
	public void alter_table()
	{
		ArrayList<String> row_cache;
		Object [] [] row_data;
		ArrayList<String> col_names;
		
		if(activeProfile.getALUSER().size()==0)
		{
		//Zusammensetzen des Headers für die JTable
				col_names = new ArrayList<String>(Converter.getStringFront(activeProfile.getProfGenInfo()));
				col_names.add("Gruppe");	//fixe Werte
				col_names.add("OU");		
				
				//Leeres 2 Dimensionales Array zur 1. Darstellung
				row_data = new Object[1][activeProfile.getProfGenInfo().size()+2];
				
				
				//JTable erstellen
				tbl_main = new JTable(row_data, col_names.toArray());
		
		}
		else
		{
			row_data = new Object[activeProfile.getALUSER().size()][activeProfile.getProfGenInfo().size()+2];
			for(int i =0; i<activeProfile.getALUSER().size(); i++)
			{
				row_cache = new ArrayList<String>(activeProfile.getALUSER().get(i).getUserGenInfo());
				row_cache.add(activeProfile.getALUSER().get(i).getUserGroup());
				row_cache.add(activeProfile.getALUSER().get(i).getUserOU());
				row_data [i]= row_cache.toArray(); 
			}
			col_names = new ArrayList<String>(activeProfile.getProfGenInfo());
			col_names.add("Gruppe");	//fixe Werte
			col_names.add("OU");		
		}	
		tbl_main = new JTable(row_data, col_names.toArray());
		scp_main.setViewportView(tbl_main);
	}
}
