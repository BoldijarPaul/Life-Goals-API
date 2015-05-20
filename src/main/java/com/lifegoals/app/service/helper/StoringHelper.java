package com.lifegoals.app.service.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class StoringHelper {

	public static void writeFile(String filename, String content) {
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.print(content);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String readFile(String pathname) {

		try {
			File file = new File(pathname);
			StringBuilder fileContents = new StringBuilder((int) file.length());
			Scanner scanner = new Scanner(file);
			String lineSeparator = System.getProperty("line.separator");

			try {
				while (scanner.hasNextLine()) {
					fileContents.append(scanner.nextLine() + lineSeparator);
				}
				return fileContents.toString();
			} finally {
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
