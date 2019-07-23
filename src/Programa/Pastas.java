package Programa;

import java.io.File;
import java.util.Scanner;

public class Pastas {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Entre com o caminho da pasta raiz : ");
	String path = sc.nextLine();
	File filePath = new File(path);
	File[] pastas = filePath.listFiles(File::isDirectory);
	
	System.out.println("-----Pastas-----");
	for(File x : pastas) {
		System.out.println(x);
	}
	File[] arquivos = filePath.listFiles(File::isFile);
	System.out.println("-----Arquivos-----");
	for(File y : arquivos) {
		System.out.println(y.getParent());
		System.out.println(y.getName());
	}
	boolean sucesso = new File(path + "\\Diretório").mkdir();
	System.out.println("Criado com sucesso ? "+ sucesso);
	sc.close();
	}
}
