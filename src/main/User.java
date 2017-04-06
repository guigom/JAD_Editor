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
	
	//Konstruktor
	User(ArrayList<String> aLUser, String group, String oUnit)
	{
		this.userGenInfo 	= aLUser;
		this.userGroup		= group;
		this.userOU			= oUnit;
	}
	
}

