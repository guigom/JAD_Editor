package main;

import java.util.ArrayList;

public class Converter 
{
	
	//Formatieren von Profil- und Nutzerdaten zu einer ArrayList für CSV
	public static ArrayList<String> formatUser(Profil activeProfile)
	{
		//Variablen initalisieren
		ArrayList<String> 	dateiInhalt = new ArrayList<>();
		String				zeile		= "";
		int					counter		= 0;
		
		//Erste Zeile
		dateiInhalt.add("#TYPE Microsoft.ActiveDirectory.Management.ADUser");
		
		//Zweite Zeile, Attribute des Profils
		//TODO: Anzeigenamen abschneiden
		for(String attr: activeProfile.getProfGenInfo())
		{
			zeile+=("\""+attr+"\"");
			if(++counter!=activeProfile.getProfGenInfo().size())
				zeile+=",";
		}
		//TODO: Einträge für Gruppen und OU erstellen
		dateiInhalt.add(zeile);
		zeile="";
		
		//Folgende Zeilen für User Einträge
		//TODO: User Einträge erstellen
		
		
		return dateiInhalt;
	}

}
