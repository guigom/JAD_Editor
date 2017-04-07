package main;

import java.io.IOException;
import java.util.ArrayList;

public class TestConverter {

	public static void main(String[] args) 
	{
		try 
		{
			Profil P1 = new Profil(".//prof//Profil1.prof");
			for (String x: Converter.formatUser(P1))
			{
				System.out.println(x);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		

	}

}
