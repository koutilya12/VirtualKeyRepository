package com.lockers.lockedme.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lockers.lockedme.domain.VirtualFile;
import com.lockers.lockedme.service.VirtualFileInterface;

public class VirtualFileService implements VirtualFileInterface {

	private List<VirtualFile> files = new ArrayList<>();
	private static final String actualPath = System.getProperty("user.dir") + "/GeneratedFiles";

	public VirtualFileService() {
		loadFiles();
	}

	private void loadFiles() {
		File directory = new File(actualPath);
		if (directory.exists() && directory.isDirectory()) {
			String fileNames[] = directory.list();
			for (int i = 0; i < fileNames.length; i++) {
				VirtualFile file = new VirtualFile();
				file.setName(fileNames[i]);
				//readFile(file);
				files.add(file);
			}
		} else {
			directory.mkdir();
		}
	}
  public void readFile(VirtualFile file) {
		try {
			FileReader fr = new FileReader(actualPath + "/" + file.getName());
			//StringBuilder sb = new StringBuilder();
			int i;
			while ((i = fr.read()) != -1) {
				 System.out.print((char) i);
				//sb.append((char)i);
			}
			//file.setFileText(sb.toString());
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error reading the file");
		}

	}

	@Override
	public boolean insertFile(VirtualFile vfile) {
		try {
			// System.out.println(System.getProperty("user.dir"));
			OutputStream file = new FileOutputStream(actualPath + "/" + vfile.getName());
			file.write(vfile.getFileText().getBytes());
			vfile.setFileText(null);
			file.flush();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error creating the file");
			return false;
		}
		files.add(vfile);
		return true;
	}

	@Override
	public VirtualFile getFile(String fileName) {
		for (VirtualFile file : files) {
			if (file.getName().equals(fileName)) {
				return file;
			}
		}
		return null;
	}

	@Override
	public boolean removeFile(String fileName) {
		VirtualFile file = getFile(fileName);
		if (file != null) {
			File fr = new File(actualPath + "/" + fileName);
			if (fr.delete()) {
				files.remove(file);
				System.out.println("File deleted successfully");
				return true;
			} else {
				System.out.println("Failed to delete the file");
				return false;
			}
		}
		return false;
	}

	@Override
	public List<VirtualFile> getFiles() {
		sortFiles();
		return files;
	}

	private void sortFiles() {
		Collections.sort(files, new Comparator<VirtualFile>() {

			@Override
			public int compare(VirtualFile o1, VirtualFile o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
	}

}
