package main;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * Die Klasse für den JFrame welches das Formular zum hinzufügen
 * von neuen Einträgen ermöglicht.
 */
public class FormAdd extends JDialog {
	
	private String group_cache;
	
	private User user_cache;
	//Getter
	public User getUser() {return user_cache;}

	private int selectedCbo;
	
	private JPanel frm_add;

/**
 * Konstruktor für die Add-Form
 * @param p Das nötige Profil-Objekt für die Attribute
 */
	public FormAdd(Profil p) {
		//Modal machen (In VorderGrund halten)
		this.setModal(true);
		
		this.group_cache = Converter.getStringBack(p.getProfGroups().get(0));
		
		setResizable(false);
		setTitle("Eintrag hinzuf\u00FCgen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 512);
		frm_add = new JPanel();
		frm_add.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_add);
		frm_add.setLayout(null);
		
		//Erzeugen der JComboBox zur Auswahl der OUs.
		JComboBox cbo_ou = new JComboBox(p.getProfOU().toArray());
		cbo_ou.setBounds(14, 384, 256, 32);
		//cbo_ou.addItem(item);
		cbo_ou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComboBox selectedChoice = (JComboBox) e.getSource();
				 selectedCbo = selectedChoice.getSelectedIndex();
				 //test.setText(path_profiles.get(selectedChoice.getSelectedIndex()));
			}
		});
		frm_add.add(cbo_ou);
		
		//Ereugen des Buttons für die Gruppenauswahl.
		JButton btn_grp = new JButton("Gruppen...");
		btn_grp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormGroups frame = new FormGroups(p);
							frame.setVisible(true);
							while(frame.isVisible());
							group_cache = frame.getGroup();
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btn_grp.setBounds(286, 384, 192, 32);
		frm_add.add(btn_grp);
		
		//Anlegen von dem OK-Button

		JButton btn_add = new JButton("OK");
		btn_add.setBounds(286, 432, 192, 32);
		frm_add.add(btn_add);
		
		
		JPanel pnl_add = new JPanel();
		pnl_add.setLayout(new GridLayout(0,2,10,10));

		JLabel[] addLabel = new JLabel[p.getProfGenInfo().size()];
		JTextField[] addText = new JTextField[p.getProfGenInfo().size()];
		
		//Durchläuft alle JTextFields für die Informationen der Attribute
		for (int i =0;i<p.getProfGenInfo().size();i++)
		{
			String zwischen = p.getProfGenInfo().get(i);
			addLabel[i] = new JLabel(zwischen.substring(0, zwischen.indexOf(',')));
			pnl_add.add(addLabel[i]);
			
			addText[i] = new JTextField();
			pnl_add.add(addText[i]);
			addText[i].setColumns(1);
		}
		
		//Erzeugt eine JScrollPane zur Flexibilität
		JScrollPane scp_add = new JScrollPane(pnl_add);
		scp_add.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scp_add.setBounds(12, 13, 466, 358);
		frm_add.add(scp_add);
		
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				boolean attr_full = true;
				ArrayList<String> aL = new ArrayList<>();
				ArrayList<String> missing = new ArrayList<>();
				
				for (int i = 0;i<addText.length;i++)
				{
					aL.add(addText[i].getText());
					//Prüft ob ein JTextField leer ist
					if (addText[i].getText().equalsIgnoreCase(""))
					{
						missing.add(Converter.getStringFront(p.getProfGenInfo().get(i)));
						attr_full = false;
					}
				}
				//Falls ein JTextFIeld leer ist, wird eine Fehlermeldung generiert
				if (!attr_full)
				{
					String missAttr = "";
					for (String x:missing)
					{
						missAttr = missAttr + x + "\n";
					}
				      int reply = JOptionPane.showConfirmDialog(null,
				    		  "Folgende Attribute wurden nicht eingegeben:\n\n"
				    		  + missAttr
				    		  + "\n\nTrotzdem fortfahren?"
				    		  , "Warnung", 
				               JOptionPane.YES_NO_OPTION);
				      if (reply == JOptionPane.YES_OPTION) {
				         attr_full=true;
				      }
				}
				
				if (attr_full)
				{
					user_cache = new User(aL,group_cache,Converter.getStringBack(p.getProfOU().get(selectedCbo)));
					setVisible(false);
				}
			}
		});
		
		
	}
}
