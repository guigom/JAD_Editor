package main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Writer 
{
	
	//Schreiben eines Inhalts in eine Datei
	public static void writeFile(String path, ArrayList<String> content)
	{
		JFileChooser chooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter(".prof-Datei", "prof");
		chooser.setFileFilter(filter);
		chooser.showOpenDialog(null);

		Path file = Paths.get(String.format("%s", chooser.getSelectedFile()));
		try {
			Files.write(file, TestArrayString.getTestArray(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
