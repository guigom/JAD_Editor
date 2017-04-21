package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

/**
 * Klasse für die Gruppenauswahl-Form
 */
public class FormGroups extends JDialog {

	private JPanel frm_groups;

	private String groupChoose;
	
	//Getter
	public String	getGroup(){return this.groupChoose;}
	
	/**
	 * Konstruktor für das Gruppenauswahlfenster
	 * @param p Das aktuelle Profil für die Gruppeninformationen
	 */
	public FormGroups(Profil p) {
		//Modal machen (In VorderGrund halten)
		this.setModal(true);
		this.groupChoose = Converter.getStringBack(p.getProfGroups().get(0));
		
		
		
		setTitle("Gruppen verwalten");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 386, 512);
		frm_groups = new JPanel();
		frm_groups.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_groups);
		frm_groups.setLayout(null);
		//Erzeugen der JList-Komponente in der die zu auswählenden Gruppen stehen
		JList lst_groups = new JList(p.getProfGroups().toArray());
		lst_groups.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lst_groups.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lst_groups.setBounds(12, 13, 344, 394);
		frm_groups.add(lst_groups);
		
		//Button zum BEstätigen der ausgewählten Gruppe
		JButton btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Gruppe wird ausgewählt
				String selected = (String) lst_groups.getSelectedValue();
				groupChoose = Converter.getStringBack(selected);
				setVisible(false);
			}
		});
		btn_ok.setBounds(260, 420, 96, 32);
		frm_groups.add(btn_ok);
	}
}
