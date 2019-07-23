package Programa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterBuffer {

	public static void main(String[] args) {
		String[] linhas = new String[] { "Bom Dia", "Boa Tarde", "Boa Noite" };
		String caminho = "E:\\JavaTemp\\Escrita.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
			for(String x : linhas) {
				bw.write(x);
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}

}
