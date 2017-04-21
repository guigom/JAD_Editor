package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Klasse für das About-Fenster.
 */
public class FormAbout extends JFrame {

	public JPanel contentPane;

	/**
	 * Konstruktor für die About-Form.
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
		
		/**
		 * Button zum shcließen der About-Form
		 */
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btn_ok.setBounds(398, 306, 96, 32);
		contentPane.add(btn_ok);
		
		/**
		 * JLabel mit den Entwicklern
		 */
		JTextArea txt_1 = new JTextArea();
		txt_1.setBackground(UIManager.getColor("Label.background"));
		txt_1.setEditable(false);
		txt_1.setText("JAD Editor\r\nby\r\nJohannes Jakuscheit\t\t\tGuido Go\u00DFmann\r\nChristian Greifenberg\t\t\tHarald Heske");
		txt_1.setBounds(12, 13, 482, 95);
		contentPane.add(txt_1);
		
		/**
		 * JLabel mit Text für weitere Informationen
		 */
		JTextArea txt_2 = new JTextArea();
		txt_2.setText("Icons by\r\nhttp://www.icon8.com");
		txt_2.setEditable(false);
		txt_2.setBackground(SystemColor.menu);
		txt_2.setBounds(12, 122, 482, 95);
		contentPane.add(txt_2);
	}
}
