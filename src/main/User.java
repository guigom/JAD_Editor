package main;

import java.util.ArrayList;

/**
 * User-Klasse für das Profil
 */
public class User 
{
	//Variablen
	private ArrayList<String> 	userGenInfo;
	private String				userGroup;
	private String				userOU;
	
	//Getter
	public ArrayList<String> 	getUserGenInfo() 	{return this.userGenInfo;}
	public String				getUserGroup()		{return this.userGroup;}
	public String				getUserOU()			{return this.userOU;}
	
	//Setter
	public void					setUserGroup(String userGroup)		{this.userGroup=userGroup;}
	public void					setUserOU(String userOU)			{this.userOU=userOU;}
	
	
	/**
	 * Konstruktor für das User-Objekt.
	 * @param aLUser ArrayList<String> für die Attribute der User.
	 * @param group String mit der Gruppe.
	 * @param oUnit String mit der OU.
	 */
	User(ArrayList<String> aLUser, String group, String oUnit)
	{
		this.userGenInfo 	= aLUser;
		this.userGroup		= group;
		this.userOU			= oUnit;
	}
	
	/**
	 * Überladener Konstruktor
	 * @param aLUser ArrayList<String> mit den Attributen.
	 */
	User(ArrayList<String> aLUser)
	{
		this.userGenInfo 	= aLUser;
		this.userGroup		= "";
		this.userOU			= "";
	}
	
}

