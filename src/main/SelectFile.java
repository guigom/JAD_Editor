package main;

import java.io.File;
import java.util.ArrayList;

public class SelectFile {
	public static void saveFile(ArrayList<String> a)
	{
	CustomFileChooser chooser = new CustomFileChooser("csv");
	chooser.showSaveDialog(null);
	Writer.writeFile(chooser.getSelectedFile().getAbsolutePath(), a);
	}

}
