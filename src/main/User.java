package main;

import java.util.ArrayList;

/**
 * User-Klasse f�r das Profil
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
	 * Konstruktor f�r das User-Objekt.
	 * @param aLUser ArrayList<String> f�r die Attribute der User.
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
	 * �berladener Konstruktor
	 * @param aLUser ArrayList<String> mit den Attributen.
	 */
	User(ArrayList<String> aLUser)
	{
		this.userGenInfo 	= aLUser;
		this.userGroup		= "";
		this.userOU			= "";
	}
	
}

