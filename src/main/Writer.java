package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Writer 
{
	
	/**
	 * 
	 * @param path
	 * @param content
	 */
	public static void writeFile(String path, ArrayList<String> c)
	{
		Path file = Paths.get(path);
		try {
			Files.write(file, TestArrayString.getTestArray(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
