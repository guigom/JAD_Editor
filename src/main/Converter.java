package main;

import java.util.ArrayList;
/**
 * Die Converter-Klasse unterst�tzt verschiedene statische Methoden
 * zum Konvertieren von Strings.
 */
public class Converter 
{
	//Ausgeben eines Strings vor dem Komma
	/**
	 * Methode zum teilen eines Strings mithilfe eines Kommas.
	 * Zur�ckgegeben wird nur der Teil vor dem Komma.
	 * @param returnString Ein String dessen Teil hinter dem Komma entfernt wird.
	 * @return Der vordere Teil vor dem Komma.
	 */
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
	//Vor dem Komma - ArrayList
	/**
	 * Entfernt den hinteren Teil von Strings die sich in einer ArrayList befinden.
	 * @param stringList Die ArrayList<String> die konvertiert werden soll.
	 * @return Die konvertierte ArrayList.
	 */
	public static ArrayList<String> getStringFront(ArrayList<String> stringList)
	{
		ArrayList<String> returnList = new ArrayList<>();
		for(String zeile: stringList)
		{
			returnList.add(getStringFront(zeile));
		}
		return returnList;
	}
	
	
	
	/**
	 * Methode zum teilen eines Strings mithilfe eines Kommas.
	 * Zur�ckgegeben wird nur der Teil hinter dem Komma.
	 * @param returnString Ein String dessen Teil vor dem Komma entfernt wird.
	 * @return Der hintere Teil vor dem Komma.
	 */
	public static String getStringBack(String returnString)
	{
		return returnString.substring(returnString.indexOf(',')+1);
	}


	/**
	 * Entfernt den vorderen Teil von Strings die sich in einer ArrayList befinden.
	 * @param stringList Die ArrayList<String> die konvertiert werden soll.
	 * @return Die konvertierte ArrayList.
	 */
	public static ArrayList<String> getStringBack(ArrayList<String> stringList)
	{
		ArrayList<String> returnList = new ArrayList<>();
		for(String zeile: stringList)
		{
			returnList.add(getStringBack(zeile));
		}
		return returnList;
	}
	
	/**
	 * Formatiert die Nutzer eines Profil-Objektes f�r die .csv-Exportierung.
	 * @param activeProfile Das zu konvertierende Profil-Objekt.
	 * @return eine ArrayList mit Strings, formatiert f�r die .csv-Datei
	 */
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
