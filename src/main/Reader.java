package main;

import java.io.File;
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
		
		//Auslesen einer Datei mit übergebenen Pfad
		public static ArrayList<String> readFile(String path)
		{
			ArrayList<String> dateiInhalt = null;
			return dateiInhalt;
		}
	
}
