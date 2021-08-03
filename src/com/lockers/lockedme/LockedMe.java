package com.lockers.lockedme;

import java.util.List;
import java.util.Scanner;

import com.lockers.lockedme.domain.VirtualFile;
 import com.lockers.lockedme.service.impl.VirtualFileService;

public class LockedMe {
	private static final String welcomeTxt = "Welcome to LockedMe Application";

	private static final String displayFilesOptionTxt = "Press 1 for displaying all files in ascending order";
	private static final String userSpecificOperationsTxt = "Press 2 for User specific operations";
	private static final String closeOptionTxt = "Press 3 to close the Application";

	private static final String addFileOptionTxt = "Press 1 for adding a file";
	private static final String delFileOptionTxt = "Press 2 for deleting a file";
	private static final String searchFileOptionTxt = "Press 3 for searching a file";
	private static final String navigateToMainTxt = "Press 4 for going back";

	private static VirtualFileService vfs = new VirtualFileService();

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(welcomeTxt);
		displayMainMenu();
	}

	private static void displayMainMenu() {
		int ch = 0;
		do {
			System.out.println(displayFilesOptionTxt + "\n" + userSpecificOperationsTxt + "\n" + closeOptionTxt);

			ch = scanner.nextInt();

			switch (ch) {
			case 1:
				printFiles();
				break;
			case 2:
				displayUserMenu();
				break;
			}

		} while (ch != 3);
	}

	private static void displayUserMenu() {
		int ch = 0;
		do {
			System.out.println(
					addFileOptionTxt + "\n" + delFileOptionTxt + "\n" + searchFileOptionTxt + "\n" + navigateToMainTxt);

			ch = getInteger(scanner.next());

			switch (ch) {
			case 1:
				addFile();
				break;
			case 2:
				deleteFile();
				break;
			case 3:
				searchFile();
				break;

			}
		} while (ch != 4);

	}

	private static int getInteger(String choice) {
		int ch = 0;
		try {
			ch = Integer.parseInt(choice);
		} catch (Exception e) {
			System.out.println("Please enter valid integer");
		}
		return ch;
	}

	private static void searchFile() {
		String name = getValidFileName();
		VirtualFile file = vfs.getFile(name);
		if (file == null) {
			System.out.println("No file found for this given name");
		} else {
		  vfs.readFile(file);
		  System.out.println();
		}
	}

	private static String getValidFileName() {
		String name = null;
		do {
			System.out.println("Please enter valid File name");
			name = scanner.next();
		} while (name == null || name.isEmpty());
		return name  + ".txt";
	}

	private static void deleteFile() {
		String name = getValidFileName();
		VirtualFile file = vfs.getFile(name);
		if(file == null) {
			System.out.println("No file found for the given name");
		} else {
			System.out.println(vfs.removeFile(name));
		}

	}

	private static void addFile() {
		String fileName = getValidFileName();
		if(vfs.getFile(fileName) != null) {
			System.out.println("File name existing ");
			return; 
		}
		System.out.println("Enter the content of the file & press enter and type -qn  to quit");
		StringBuilder fileContent = new StringBuilder();
		while (!scanner.hasNext("-qn")) {
			fileContent.append(scanner.nextLine());
		}
		scanner.next();
		VirtualFile file = new VirtualFile();
		file.setName(fileName);
		file.setFileText(fileContent.toString());
		if (vfs.insertFile(file)) {
			System.out.println("File Inserted successfully");
		} else {
			System.out.println("File Insertion failed");
		}

	}

	private static void printFiles() {
		List<VirtualFile> files = vfs.getFiles();
		System.out.println("Printing the names of "+files.size()+" files");
		for (VirtualFile file : files) {
			System.out.println(file.getName());
		}

	}

}
