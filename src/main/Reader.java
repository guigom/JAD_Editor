package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader 
{

	//Profile aus dem Ordner auslesen
		public static ArrayList<String> getProfiles()
		{
			File f = new File(".\\prof");
			System.out.println("tostring" + f.toString());
			ArrayList<String> al = new ArrayList<String>();
			String comp;
			for(File file: f.listFiles())
			{	
				comp = file.getPath();
				if(comp.substring(comp.length()-5).equalsIgnoreCase(".prof"))
				{
				
					al.add(comp);
				}
				System.out.println(comp.substring(comp.length()-5));
			}
			//System.out.println(al.toString());
			return al;
		}
		
		
		
		
		//Auslesen einer Datei mit �bergebenen Pfad
		public static ArrayList<String> readFile(String path) throws IOException
		{
			//Filereader, Buffer und String-Liste initialisieren
			FileReader 			einlesen 	= new FileReader(path);
			BufferedReader 		buff		= new BufferedReader(einlesen);
			ArrayList<String> 	dateiInhalt	= new ArrayList<>();
		
			//Schleife, die Inhalt einliest, bis ein null vorkommt
			for(String zeile="";(zeile=buff.readLine())!=null;)
				dateiInhalt.add(zeile);			
			
			return dateiInhalt;
		}
	
}
