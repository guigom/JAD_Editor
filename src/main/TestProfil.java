package main;

//Guido TODO

import java.io.IOException;
import java.util.ArrayList;

public class TestProfil {

	public static void main(String[] args) 
	{
		try
		{
		Profil P1 = new Profil(".\\prof\\Profil1.prof");
		
		System.out.println("Attribute________________");
		for(String x: P1.getProfGenInfo())
			System.out.println(x);
		
		System.out.println("OUs______________________");
		for(String x: P1.getProfOU())
			System.out.println(x);
		
		System.out.println("Gruppe___________________");
		for(String x: P1.getProfGroups())
			System.out.println(x);
		
		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	
		
	}

}
