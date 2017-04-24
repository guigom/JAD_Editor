package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * SelectFile-Klasse für statische Methoden
 */
public class SelectFile {
	/**
	 * Methode zum Speichern der Datei.
	 * @param a : Die ArrayList<String> die in die Datei geschrieben wird.
	 */
	public static void saveFile(ArrayList<String> a)
	{
		//Erstellt ein CustomFileChooser mit der Dateiendung "csv".
		CustomFileChooser chooser = new CustomFileChooser("csv");
		chooser.showSaveDialog(null);
		//Versucht, die ArrayList in die ausgewählte Datei zu schreiben
		try {
			Writer.writeFile(chooser.getSelectedFile().getAbsolutePath(), a);
		}
		catch (NullPointerException e)
		{
			//Fehlermeldung
			JOptionPane.showMessageDialog(null, "Keine Datei ausgewählt. Es wird nichts exportiert.");
		}
	}
} 
