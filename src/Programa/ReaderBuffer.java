package Programa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderBuffer {

	public static void main(String[] args) {
		String filePath = "E:\\JavaTemp\\BuffRead.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("IO Exception");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}