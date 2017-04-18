package main;

import java.io.IOException;
import java.util.ArrayList;

public class TestConverter {

	public static void main(String[] args) 
	{
		try 
		{
			Profil P1 				= new Profil(".//prof//Profil1.prof");
			ArrayList<String> A1 	= new ArrayList<>();
			A1.add("Mustermann");
			A1.add("Max");
			A1.add("MMustermann");
			A1.add("Test-Eintrag");
			
			User U1					= new User(A1,"CN=Domänen-Benutzer,CN=Users,DC=bib,DC=loc","OU=Abteilung 1,OU=Firma,DC=bib,DC=loc");
			
			P1.addALUser(U1);
			
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
