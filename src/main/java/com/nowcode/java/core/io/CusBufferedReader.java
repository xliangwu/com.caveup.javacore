package com.nowcode.java.core.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CusBufferedReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
			writer.write("First line");
			writer.newLine();
			writer.write("Seond\rline");
			writer.newLine();
			writer.write("Third\nline");
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			StrictBufferedReader reader = new StrictBufferedReader(new FileReader(new File("data.txt")));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
