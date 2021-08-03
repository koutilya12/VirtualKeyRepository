package com.lockers.lockedme.domain;

import java.io.File;

public class VirtualFile {
	private String name;
	private String fileText;
	private File file;
	
	public String getName() {  
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileText() {
		return fileText;
	}
	public void setFileText(String fileText) {
		this.fileText = fileText;
	}
	

}
