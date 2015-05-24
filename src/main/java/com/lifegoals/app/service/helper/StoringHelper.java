package com.lifegoals.app.service.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StoringHelper {

	/* this method will write our object to the file */
	public static void writeFile(String filename, Object object) {
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(object);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* this method will read the file object */
	public static <T> T readObjectFromFile(String filename) {
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Object obj = ois.readObject();
			ois.close();
			return (T) obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
			try {
				File file = new File(filename);
				file.delete();
			} catch (Exception ex) {

			}
		}
		return null;

	}

}
