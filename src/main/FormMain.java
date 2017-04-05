package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 */
	public FormMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\harry\\workspace\\JAD_Editor\\img\\logo.png"));
		setTitle("JAD Editor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 768);
		frm_main = new JPanel();
		frm_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frm_main);
		frm_main.setLayout(null);
		
		tbl_main = new JTable();
		tbl_main.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tbl_main.setBounds(16, 16, 786, 704);
		frm_main.add(tbl_main);
		
		JButton btn_add = new JButton("Eintrag hinzuf\u00FCgen");
		btn_add.setIcon(new ImageIcon("C:\\Users\\harry\\workspace\\JAD_Editor\\img\\Plus-32.png"));
		btn_add.setBounds(816, 16, 192, 40);
		frm_main.add(btn_add);
		
		JButton btn_del = new JButton("Eintrag entfernen");
		btn_del.setIcon(new ImageIcon("C:\\Users\\harry\\workspace\\JAD_Editor\\img\\Minus-32.png"));
		btn_del.setBounds(816, 72, 192, 40);
		frm_main.add(btn_del);
		
		JButton btn_export = new JButton("Export");
		btn_export.setIcon(new ImageIcon("C:\\Users\\harry\\workspace\\JAD_Editor\\img\\Share 3-32.png"));
		btn_export.setBounds(814, 680, 192, 40);
		frm_main.add(btn_export);
		
		JButton btn_about = new JButton("About");
		btn_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAbout form = new FormAbout();
				form.setVisible(true);
			}
		});
		btn_about.setIcon(new ImageIcon("C:\\Users\\harry\\workspace\\JAD_Editor\\img\\Info-32.png"));
		btn_about.setBounds(814, 624, 192, 40);
		frm_main.add(btn_about);
	}
}
