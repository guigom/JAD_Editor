package main;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Johannes Jakuscheit
 *
 */
public class Profil
{
	//Deklarierung der Variablen
	private ArrayList<String> 	profGenInfo = new ArrayList<>();
	private ArrayList<String> 	profGroups 	= new ArrayList<>();
	private ArrayList<String> 	profOU 		= new ArrayList<>();
	private ArrayList<User> 	aLUser 		= new ArrayList<>();
	
	//getter
	public ArrayList<String> 	getProfGenInfo(){return this.profGenInfo;}
	public ArrayList<String> 	getProfGroups()	{return this.profGroups;}
	public ArrayList<String> 	getProfOU()		{return this.profOU;}
	public ArrayList<User> 		getALUSER()		{return this.aLUser;}
	
	//User Liste verändern
	public void addALUser		(User newUser)	{this.aLUser.add(newUser);}
	public void removeALUser	(User delUser)	{this.aLUser.remove(delUser);}
	
	//Konstruktor
	Profil(String path) throws IOException
	{
		//Profildatei zwischenspeichern
		ArrayList<String> 	profInhalt 	= Reader.readFile(path);
		int 				lineCount	= 0;
		
		//Vorspringen bis "_attr"
		for(String x: profInhalt)
		{
			if(x.equalsIgnoreCase("_attr"))break;
			lineCount++;
		}
		
		//GenInfo befüllen bis "_ou"
		while(!profInhalt.get(++lineCount).equalsIgnoreCase("_ou"))
		{
			this.profGenInfo.add(profInhalt.get(lineCount));
		}
		
		//OU befüllen bis "_groups"
		while(!profInhalt.get(++lineCount).equalsIgnoreCase("_groups"))
		{
			this.profOU.add(profInhalt.get(lineCount));
		}
		
		//Groups befüllen bis ENDE
		while(++lineCount<profInhalt.size())
		{
			this.profGroups.add(profInhalt.get(lineCount));
		}
		
	}
}
