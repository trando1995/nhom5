package entity;

import java.io.File;

import javax.swing.filechooser.FileFilter;
// TODO: Auto-generated Javadoc

/**
 * 
 * @author tranb_000
 *
 */
public class FileTypeFilter extends FileFilter {
	
	/** The extension. */
	private final String extension;
	
	/** The description. */
	private final String description;
	
	/**
	 * Instantiates a new file type filter.
	 *
	 * @param extension the extension
	 * @param description the description
	 */
	public FileTypeFilter(String extension, String description) {
		this.extension = extension;
		this.description = description;
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		else return file.getName().endsWith(extension);
	
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return description + String.format("(*%s)", extension);
	}
	
	
}