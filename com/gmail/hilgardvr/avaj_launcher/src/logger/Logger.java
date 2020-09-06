package com.gmail.hilgardvr.avaj_launcher.src.logger;

import java.io.*;
import java.nio.file.*;

public class Logger {
	public static Path file;

	public static void createFile(String text) {
		file = Paths.get(text);
		try {
			Files.delete(file);
		} catch (IOException ignore) {}

		try {
			Files.createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(String str) {
		try {
			String text = str + '\n';
			byte[] strToBytes = text.getBytes();
			Files.write(Logger.file, strToBytes, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
