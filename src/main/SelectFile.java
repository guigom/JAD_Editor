package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * SelectFile-Klasse f�r statische Methoden
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
		//Versucht, die ArrayList in die ausgew�hlte Datei zu schreiben
		try {
			Writer.writeFile(chooser.getSelectedFile().getAbsolutePath(), a);
		}
		catch (NullPointerException e)
		{
			//Fehlermeldung
			JOptionPane.showMessageDialog(null, "Keine Datei ausgew�hlt. Es wird nichts exportiert.");
		}
	}
} 
