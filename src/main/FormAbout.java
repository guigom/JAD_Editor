package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FormAbout extends JFrame {

	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAbout frame = new FormAbout();
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
	public FormAbout() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("About JAD Editor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btn_ok.setBounds(398, 306, 96, 32);
		contentPane.add(btn_ok);
		
		JTextArea txt_1 = new JTextArea();
		txt_1.setBackground(UIManager.getColor("Label.background"));
		txt_1.setEditable(false);
		txt_1.setText("JAD Editor\r\nby\r\nJohannes Jakuscheit\t\t\tGuido Go\u00DFmann\r\nChristian Greifenberg\t\t\tHarald Heske");
		txt_1.setBounds(12, 13, 482, 95);
		contentPane.add(txt_1);
		
		JTextArea txt_2 = new JTextArea();
		txt_2.setText("Icons by\r\nhttp://www.icon8.com");
		txt_2.setEditable(false);
		txt_2.setBackground(SystemColor.menu);
		txt_2.setBounds(12, 122, 482, 95);
		contentPane.add(txt_2);
	}
}
