package main;

import java.util.ArrayList;

public class TestArrayString {
	/**
	 * 
	 * @return Gibt eine String-ArrayList zurück
	 */
	public static ArrayList<String> getTestArray()
	{
		ArrayList<String> array = new ArrayList<>();
		for (int i = 1; i<=100;i++)
		{
			array.add(String.format("Vorname%d,Nachname%d,SamName%d", i,i,i));
		}
		return array;
	}
}
