package main;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SelectFile {
	public static void saveFile(ArrayList<String> a)
	{
	CustomFileChooser chooser = new CustomFileChooser("csv");
	chooser.showSaveDialog(null);
	try {
	Writer.writeFile(chooser.getSelectedFile().getAbsolutePath(), a);
	}
	catch (NullPointerException e)
	{
		JOptionPane.showMessageDialog(null, "Keine Datei ausgewählt. Es wird nichts exportiert.");
	}
	}

}
