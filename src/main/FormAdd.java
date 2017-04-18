package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class FormAdd extends JFrame {

	private JPanel frm_add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAdd frame = new FormAdd(TestProfil.getTestProfil());
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
	public FormAdd(Profil p) {
		setResizable(false);
		setTitle("Eintrag hinzuf\u00FCgen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 512);
		frm_add = new JPanel();
		frm_add.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_add);
		frm_add.setLayout(null);
		
		JComboBox cbo_ou = new JComboBox();
		cbo_ou.setBounds(14, 384, 256, 32);
		frm_add.add(cbo_ou);
		
		JButton btn_grp = new JButton("Gruppen...");
		btn_grp.setBounds(286, 384, 192, 32);
		frm_add.add(btn_grp);
		
		JButton btn_add = new JButton("OK");
		btn_add.setBounds(286, 432, 192, 32);
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		frm_add.add(btn_add);
		
		JScrollPane scp_add = new JScrollPane();
		scp_add.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scp_add.setBounds(12, 13, 466, 358);
		frm_add.add(scp_add);
		
		JPanel panel = new JPanel();
		scp_add.setViewportView(panel);
		panel.setLayout(null);

		panel.setSize(300, (p.getProfGenInfo().size()*48)+32);
		
		JLabel[] addLabel = new JLabel[p.getProfGenInfo().size()];
		JTextField[] addText = new JTextField[p.getProfGenInfo().size()];
		
		for (int i =0;i<p.getProfGenInfo().size();i++)
		{
			
			addLabel[i] = new JLabel("New label");
			addLabel[i].setBounds(16, 16+(i*48), 128, 32);
			addLabel[i].setText("Test " + i);
			panel.add(addLabel[i]);
			
			addText[i] = new JTextField();
			addText[i].setBounds(160, 16+(i*48), 288, 32);
			panel.add(addText[i]);
			addText[i].setColumns(1);
		}
		
	}
}
