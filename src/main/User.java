package main;

import java.util.ArrayList;

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
	
	
	//Konstruktor mit allen Parametern
	User(ArrayList<String> aLUser, String group, String oUnit)
	{
		this.userGenInfo 	= aLUser;
		this.userGroup		= group;
		this.userOU			= oUnit;
	}
	
	//Überladener Konstruktor nur mit GenInfo
	User(ArrayList<String> aLUser)
	{
		this.userGenInfo 	= aLUser;
		this.userGroup		= "";
		this.userOU			= "";
	}
	
}

