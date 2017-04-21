package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Writer-Klasse zum schreiben in eine Datei
 */
public class Writer 
{
	
	/**
	 * Statische Methode zum schreiben in eine Datei.
	 * @param path Die zu schreibende Datei mit Pfad.
	 * @param c Die ArrayList<String> mit den zu schreibenden Inhalt.
	 */
	public static void writeFile(String path, ArrayList<String> c)
	{
		Path file = Paths.get(path);
		try {
			Files.write(file, c, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
