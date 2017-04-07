package main;

import java.util.ArrayList;

public class Converter 
{
	
	//Formatieren von Profil- und Nutzerdaten zu einer ArrayList für CSV
	public static ArrayList<String> formatUser(Profil activeProfile)
	{
		//Variablen initalisieren
		ArrayList<String> dateiInhalt = new ArrayList<>();
		
		
		//Erste Zeile
		dateiInhalt.add("#CSV-Header");
		
		//Zweite Zeile, Attribute des Profils
		for(String attr: activeProfile.getProfGenInfo())
		{
			
		}
		
		
		
		
		
		
		return dateiInhalt;
	}

}
