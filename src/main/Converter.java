package main;

import java.util.ArrayList;

public class Converter 
{
	//Ausgeben eines Strings vor dem Komma
	public static String getStringFront(String returnString)
	{
		//Einlesen der Kommastelle
		int indexNr = returnString.indexOf(',');
		//Schneiden in Abh�ngigkeit vom Komma
		if(indexNr>-1)
			returnString=returnString.substring(0, indexNr);
		//R�ckgabe des Strings		
		return returnString;
	}
	
	//Ausgeben eines String nach dem Komma
	public static String getStringBack(String returnString)
	{
		return returnString.substring(returnString.indexOf(',')+1);
	}
	
	
	
	//Formatieren von Profil- und Nutzerdaten zu einer ArrayList f�r CSV
	public static ArrayList<String> formatUser(Profil activeProfile)
	{
		//Variablen initalisieren
		ArrayList<String> 	dateiInhalt = new ArrayList<>();
		String				zeile		= "";
		int					counter		= 0;
		
		//Erste Zeile
		dateiInhalt.add("#TYPE Microsoft.ActiveDirectory.Management.ADUser");
		
		//Zweite Zeile, Attribute des Profils
		for(String attr: activeProfile.getProfGenInfo())
		{
			//Anzeigename abschneiden
			attr=getStringBack(attr);
			//Anf�hrungszeichen+Komma hinzuf�gen
			zeile+=("\""+attr+"\""+",");
		}
		//TODO: Eintr�ge f�r Gruppen und OU erstellen
		zeile+=("\"PrimaryGroup\",\"Path\"");
		//Zeile schreiben
		dateiInhalt.add(zeile);
		
		//Folgende Zeilen f�r User Eintr�ge
		//TODO: User Eintr�ge erstellen
		for(User nutzer: activeProfile.getALUSER())
		{
			//Zeile leeren
			zeile="";
			//Attribute auslesen
			for(String attr: nutzer.getUserGenInfo())
			{
				zeile+=("\""+attr+"\",");
			}
			//Guppe und OU anf�gen
			zeile+=(nutzer.getUserGroup()+","+nutzer.getUserOU());
			//Zeile schreiben
			dateiInhalt.add(zeile);
		}
		
		
		return dateiInhalt;
	}

}
