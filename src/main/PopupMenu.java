package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenu
{
	// Kontextmen�
	// TODO: 
	// Das ganze Menu kontextabh�ngig auslagern in
	// eine eigene Klasse. 
	JPopupMenu context	= new JPopupMenu("Context");
	//	add
	
	JMenuItem		cCopy		= new JMenuItem("Copy");
	this.add(cCopy);
	cCopy.addActionListener( e-> {
		System.out.printf("�ffne FormAdd %s%n", e.getActionCommand() );
		// TODO: wen rufe ich hier auf?
		//tbl_main.getSelectedColumns(); 
	});
	
	// f�ge das Kontextmen� der Tabelle hinzu.
	tbl_main.add(context);
	
	// das MouseEvent informiert den Controller, das 
	// es gedr�ckt wurde
	// 
	class MyMouseAdapter extends MouseAdapter {
		/**
		 * wenn der Popup Trigger gedr�ckt wird <br>
		 * dann untersuche das Feld, und �ffne dort das Men�
		 */
		public void mouseReleased(MouseEvent e){
			if ( e.isPopupTrigger())
				context.show( e.getComponent(), e.getX(), e.getY() );
		}
		public void mousePressed(MouseEvent e){
//			if ( e.getButton()==MouseEvent.BUTTON1 ){
//				System.out.printf("MouseEvent: %h %s%n", e.getSource(),
//						((JTable)e.getSource()).getTableHeader());
//			}
//			if ( e.getButton()==MouseEvent.BUTTON3 ){
//				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
//				Transferable trans = cb.getContents(null);
//				System.out.printf("Clipboard beinhaltet einen String: %b %n",
//						trans.isDataFlavorSupported(DataFlavor.stringFlavor) );
			}
	} // MouseAdapter
	MyMouseAdapter ma = new MyMouseAdapter(); 
	tbl_main.addMouseListener(ma);
//	setComponentPopupMenu(context);
}
}
