package com.roonv;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.roonv.ConsoleProgressor;

public class FileManager {

	public void copyFile(String from, String to) {

		ConsoleProgressor console = new ConsoleProgressor();

		int line;
		try {
			FileInputStream inputStream = new FileInputStream(from);
			BufferedInputStream reader = new BufferedInputStream(inputStream);
			FileOutputStream outputStream = new FileOutputStream(new File(to + "copy1.txt"));
			BufferedOutputStream writer = new BufferedOutputStream(outputStream);
			int totalLines = (int) inputStream.getChannel().size();
			int i = 1;
			int percentage;
			while ((line = reader.read()) != -1) {
				writer.write(line);
				i++;
				percentage = (i * 100) / totalLines;
				console.showProgress(percentage);
			}
			inputStream.close();
			reader.close();
			outputStream.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new FileManager().copyFile("D:/Code/eclipse_workspace/console-progress/resources/TombRaider.log",
				"D:/Code/eclipse_workspace/console-progress/resources/");

	}

}
