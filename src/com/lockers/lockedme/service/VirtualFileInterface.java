package com.lockers.lockedme.service;

import java.util.List;

import com.lockers.lockedme.domain.VirtualFile;

public interface VirtualFileInterface {
	
	/**
	 * It inserts files
	 * @param file
	 * @return true if successfully inserted.
	 */
	public boolean insertFile(VirtualFile file);

	/**
	 * It gets files from the List.
	 * @param fileName
	 * @return file
	 */
	public VirtualFile getFile(String fileName);

	/**
	 * It removes the file based on the file name.
	 * @param fileName
	 * @return true if removed
	 */
	public boolean removeFile(String fileName);
	
	/**
	 * It returns the list of files in ascending order.
	 * @return list of files.
	 */
	public List<VirtualFile> getFiles();

}
