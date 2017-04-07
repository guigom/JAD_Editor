package main;

import java.io.IOException;
import java.util.ArrayList;

public class TestReader 
{
	public static void main(String[] args) 
	{
		ArrayList<String> ordnerInhalt = Reader.getProfiles();
		ArrayList<String> readFile = new ArrayList<>();
		
		try 
		{
			for(String path: ordnerInhalt)
			{	
				readFile = Reader.readFile(path);
				for(String x: readFile)
				{
					System.out.println(x);
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
