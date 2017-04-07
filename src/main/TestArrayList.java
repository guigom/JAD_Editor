package main;

import java.util.ArrayList;

public class TestArrayList {
	/**
	 * 
	 * @return Gibt eine ArrayList mit User-Objekten zurück
	 */
	public static ArrayList<User> getArrayList()
	{
		ArrayList<User> array = new ArrayList<User>();
		for (int i=1;i<=100;i++)
		{
			ArrayList<String> arrayUser = new ArrayList<String>();
			arrayUser.add(String.format("Nachname%d",i));
			arrayUser.add(String.format("Vorname%d",i));
			arrayUser.add(String.format("SamAccountName%d",i));
			arrayUser.add(String.format("Beschreibung von %d",i));
			arrayUser.add(String.format("true"));
			User user = new User(arrayUser, "OU","Group");
			array.add(user);
			//System.out.printf("%s\n",array.get(i-1).getUserGenInfo().toString());
		}
		return array;
		
	}
}
