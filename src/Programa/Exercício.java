package Programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entidades.entidade.Produtos;

public class Exercício {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Produtos> listaProd = new ArrayList<>();

		String filePathIn = "E:\\JavaTemp\\ExercícioArquivo\\In.txt";
		File fileIn = new File(filePathIn);
		
		String filePathOut = "E:\\JavaTemp\\ExercícioArquivo\\Out.txt";
		File fileOut = new File(filePathOut);

		try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
			String item = br.readLine();
			while (item != null) {
				String[] vetorLeitura = item.split(",");
				String nomeProd = vetorLeitura[0];
				double precoProd = Double.parseDouble(vetorLeitura[1]);
				int qtdProd = Integer.parseInt(vetorLeitura[2]);
				listaProd.add(new Produtos(nomeProd, precoProd, qtdProd));

				item = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro : Exceção de I.O" + e.getLocalizedMessage());
		}
		for(Produtos x:listaProd) {
			System.out.println(x);
		}
		double aux = 0;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))){
			for (Produtos x : listaProd) {
				bw.write(x.getNome()+","+String.format("%.2f",x.totalEstoque()));
				bw.newLine();
				aux += x.totalEstoque();
			}
			bw.newLine();
			bw.write("Total no estoque = " + aux);
		}
		catch(IOException e) {
			System.out.println("Erro : Exceção de I.O" + e.getLocalizedMessage());
		}
		
		
		
		sc.close();
	}

}
