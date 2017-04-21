package main;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klasse die Teile der JFileCHooser-Klasse überschreibt
 */
public class CustomFileChooser extends JFileChooser {
	  private String extension;
	  
	  /**
	   * Konstruktor für den CustomFileChooser
	   * @param extension Die Dateierweiterung für den JFileChooser
	   */
	  public CustomFileChooser(String extension) {
	    super();
	    this.extension = extension;
	    addChoosableFileFilter(new FileNameExtensionFilter(
	      String.format("%1$s-Datei (*.%1$s)", extension), extension));
	    this.setAcceptAllFileFilterUsed(false);

	  }
	/**
	 * Überschreibt die getSelectedFile-Methode vom JFileChooser.
	 * @return Das ausgewählte FIle-Objekt.
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
	   * Überschreibt die approveSelection-Methode mit einem Custom-Dialog.
	   */
	  @Override public void approveSelection() {
	    if (getDialogType() == SAVE_DIALOG) {
	      File selectedFile = getSelectedFile();
	      if ((selectedFile != null) && selectedFile.exists()) {
	        int response = JOptionPane.showConfirmDialog(this,
	          "Die Datei " + selectedFile.getName() + 
	          " existiert bereits. Überschreiben?",
	          "Warnung", JOptionPane.YES_NO_OPTION,
	          JOptionPane.WARNING_MESSAGE);
	        if (response != JOptionPane.YES_OPTION)
	          return;
	      }
	    }

	    super.approveSelection();
	  }
	}