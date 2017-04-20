package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import main.PopupMenu.MyMouseAdapter;

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
					FormMain frame = new FormMain(new Profil(".\\prof\\Profil2.prof"));
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
				FormAdd form = new FormAdd(activeProfile);
				
				form.setVisible(true);
				while(form.isVisible());
				activeProfile.addALUser(form.getUser());
				form.dispose();
				System.out.println(activeProfile.getALUSER().get(0).getUserGenInfo().toString());
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
			}
		});
		btn_about.setIcon(new ImageIcon("./img/Info-32.png"));
		btn_about.setBounds(814, 624, 192, 40);
		frm_main.add(btn_about);
		
		JScrollPane scp_main = new JScrollPane();
		scp_main.setBounds(12, 16, 780, 704);
		frm_main.add(scp_main);
		
// <<<<<<< HEAD
		tbl_main = new JTable(TestTableContent.getTestStringArray(),
				TestArrayTableHeader.getTestStringHeaderArray());
//=======
		//Zusammensetzen des Headers für die JTable
		ArrayList<String> col_names = new ArrayList<String>(activeProfile.getProfGenInfo());
		col_names.add("Gruppe");	//fixe Werte
		col_names.add("OU");		
		
		//Leeres 2 Dimensionales Array zur 1. Darstellung
		Object [] [] row_data = new Object[1][activeProfile.getProfGenInfo().size()+2];
		
		//JTable erstellen
		tbl_main = new JTable(row_data, col_names.toArray());
		tbl_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
//>>>>>>> refs/remotes/origin/develop_model
		scp_main.setViewportView(tbl_main);
		
/** Kontextmenü
// TODO:  Das ganze Menu kontextabhängig auslagern in
// eine eigene Klasse. 

// was kommt rein? 
// Copy 
// Paste */


// erzeuge Kontextmenü 		
		JPopupMenu context	= new JPopupMenu("Context");
		
// erzeuge Menüeintrag
		// hat keinen verbundenen Listener
		context.add( new JMenuItem("Erster Eintrag ") );
		context.addSeparator();
// erzeuge Menüeintrag
		JMenuItem	cCopy	= new JMenuItem("Copy");
		context.add(cCopy);
// 
		
		cCopy.addActionListener( e-> {
			System.out.printf("Ausgabe cCopy %s%n", e.getActionCommand() );
			// TODO: wen rufe ich hier auf?
			//tbl_main.getSelectedColumns(); 
		});
// erzeuge weitere, zufällige Menüeinträge 
	    for ( String s : ("das sind dummy einräge," +
                "zweiter Eintrag," +
                "dritter eintrag, vierter Eintrag").split(",") )
		{
//		 context.add( new AbstractAction(s) {
//		   @Override public void actionPerformed( ActionEvent e ) {
////		     tbl_main.addRowSelectionInterval(1, 3) ;
//			 System.out.println( tbl_main.getColumnName(tbl_main.getSelectedColumn()) );  
//		     System.out.println("FormMain.FormMain(...).new AbstractAction() {...}.actionPerformed()");
					//.append( e.getActionCommand() + "\n" );
//		   }
//		 } );
		}
		// füge das Kontextmenü der Tabelle hinzu.
//		tbl_main.add(context);
//		scp_main.add(context);
		
		// das MouseEvent informiert den Controller, dass 
		// es gedrückt wurde: isPopupTrigger()
		// 
		class MyMouseAdapter extends MouseAdapter {
			/**
			 * wenn der Popup Trigger gedrückt wird <br>
			 * dann untersuche das Feld, und öffne dort das Menü
			 */
			public void mouseReleased(MouseEvent e){
				if ( e.isPopupTrigger())
					context.show( e.getComponent(), e.getX(), e.getY() );
			}
			public void mousePressed(MouseEvent e){
				if ( e.getButton()==MouseEvent.BUTTON1 ){
//					System.out.printf("MouseEvent: %h %s%n", e.getSource(),	((JTable)e.getSource()).getTableHeader());
					 System.out.println( tbl_main.getColumnName(tbl_main.getSelectedColumn()) );
				     System.out.println("FormMain.FormMain(...).new AbstractAction() {...}.actionPerformed()");
				}
//				if ( e.getButton()==MouseEvent.BUTTON3 ){
//					Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
//					Transferable trans = cb.getContents(null);
//					System.out.printf("Clipboard beinhaltet einen String: %b %n",
//							trans.isDataFlavorSupported(DataFlavor.stringFlavor) );
				}
		} // MouseAdapter
		MyMouseAdapter ma = new MyMouseAdapter(); 
		tbl_main.addMouseListener(ma);
		scp_main.addMouseListener(ma);
//		setComponentPopupMenu(context);

	} // FormMain()
}// FormMain
