package main;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klasse die Teile der JFileCHooser-Klasse �berschreibt
 */
public class CustomFileChooser extends JFileChooser {
	  private String extension;
	  
	  /**
	   * Konstruktor f�r den CustomFileChooser
	   * @param extension Die Dateierweiterung f�r den JFileChooser
	   */
	  public CustomFileChooser(String extension) {
	    super();
	    this.extension = extension;
	    addChoosableFileFilter(new FileNameExtensionFilter(
	      String.format("%1$s-Datei (*.%1$s)", extension), extension));
	    this.setAcceptAllFileFilterUsed(false);

	  }
	/**
	 * �berschreibt die getSelectedFile-Methode vom JFileChooser.
	 * @return Das ausgew�hlte FIle-Objekt.
	 */
	  @Override public File getSelectedFile() {
	    File selectedFile = super.getSelectedFile();

	    if (selectedFile != null) {
	      String name = selectedFile.getName();
	      if (!name.contains("."))
	        selectedFile = new File(selectedFile.getParentFile(), 
	          name + '.' + extension);
	    }

	    return selectedFile;
	  }

	  /**
	   * �berschreibt die approveSelection-Methode mit einem Custom-Dialog.
	   */
	  @Override public void approveSelection() {
	    if (getDialogType() == SAVE_DIALOG) {
	      File selectedFile = getSelectedFile();
	      if ((selectedFile != null) && selectedFile.exists()) {
	        int response = JOptionPane.showConfirmDialog(this,
	          "Die Datei " + selectedFile.getName() + 
	          " existiert bereits. �berschreiben?",
	          "Warnung", JOptionPane.YES_NO_OPTION,
	          JOptionPane.WARNING_MESSAGE);
	        if (response != JOptionPane.YES_OPTION)
	          return;
	      }
	    }

	    super.approveSelection();
	  }
	}