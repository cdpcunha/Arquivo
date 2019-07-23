package Programa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProgramaTeste {

	public static void main(String[] args) {
		File file = new File("E:\\JavaTemp\\Hello.txt");

		Scanner f1 = null;
		try {
			f1 = new Scanner(file);
			while (f1.hasNextLine()) {
				System.out.println(f1.nextLine());
			}
		}
		catch(IOException e) {
			System.out.println("Erro de leitura do arquivo: " + e.getMessage());
		}
		finally {
			if(f1 != null){
				f1.close();
			}
				
		}
	}
}
