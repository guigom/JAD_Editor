package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
import javax.swing.table.DefaultTableModel;

public class FormMain extends JFrame {

	private JPanel frm_main;
	private JTable tbl_main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 * Bearbeitet 7.04, alle Buttons "rufen etwas auf". 
	 * 
	 */
	public FormMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/logo.png"));
		setTitle("JAD Editor");
		setResizable(true);
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
				FormAdd form = null;
				try {
					form = new FormAdd(TestProfil.getTestProfil());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				form.setVisible(true);
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
				FormAdd form = null;
				try {
					form = new FormAdd(TestProfil.getTestProfil());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				form.setVisible(true);
			}
		});
		btn_del.setBounds(816, 72, 192, 40);
		frm_main.add(btn_del);
		
		JButton btn_export = new JButton("Export");
		btn_export.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<String> test = TestArrayString.getTestArray();
				SelectFile.saveFile(test);
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
			}
		});
		btn_about.setIcon(new ImageIcon("./img/Info-32.png"));
		btn_about.setBounds(814, 624, 192, 40);
		frm_main.add(btn_about);
		
		JScrollPane scp_main = new JScrollPane();
		scp_main.setBounds(12, 16, 780, 704);
		frm_main.add(scp_main);
		
		tbl_main = new JTable(TestTableContent.getTestStringArray(),TestArrayTableHeader.getTestStringHeaderArray());
		scp_main.setViewportView(tbl_main);
		
		// Kontextmenü
		JPopupMenu context	= new JPopupMenu("Context");
		JMenuItem		cCopy		= new JMenuItem("Copy");
		context.add(cCopy);
		cCopy.addActionListener( e-> {
			System.out.printf("öffne FormAdd %s%n", e.getActionCommand() );
			// TODO: wen rufe ich hier auf?
		});
		
		setComponentPopupMenu(context);
	}
}
