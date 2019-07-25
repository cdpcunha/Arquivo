package Programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Entidades.entidade.*;

public class ExercicioPessoal {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		List<Pessoa> listaPessoa = new ArrayList<>();
		String pathArqEntrada = "E:\\JavaTemp\\ExercicioPessoal\\Entrada.txt";
		File arqEntrada = new File(pathArqEntrada);
		String pathArqSaida = "E:\\JavaTemp\\ExercicioPessoal\\Saida.txt";
		File arqSaida = new File(pathArqSaida);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		populaListaImprime(sc, sdf, arqEntrada, listaPessoa);
		escreveRegistroSaida(sc, sdf, arqSaida, listaPessoa);

		menu(sc);
		int op = sc.nextInt();
		sc.nextLine();
		Date now = new Date();
		while (op != 0) {
			if (op == 1) {
				System.out.println("  Entre com os dados da Pessoa  ");
				System.out.print("Nome : ");
				String nome = sc.nextLine();
				System.out.print("Data de nascimento : (DD/MM/AAAA) ");
				Date dtNasc = sdf.parse(sc.nextLine());
				if (dtNasc.after(now)) {
					System.out.println("Data futura. Impossível inserir.");
					menu(sc);
					op = sc.nextInt();
					sc.nextLine();
				} else {
					System.out.print("Cidade de Naturalidade : ");
					String cidade = sc.nextLine();
					System.out.print("Estado de Nascença : ");
					String estado = sc.nextLine();
					Pessoa pessoa = new Pessoa(nome, dtNasc, cidade, estado);
					escreveRegistroEntrada(sdf, arqEntrada, pessoa);
					listaPessoa.add(pessoa);
					escreveRegistroSaida(sc, sdf, arqSaida, listaPessoa);
					menu(sc);
					op = sc.nextInt();
					sc.nextLine();
				}
			} else if (op == 2) {
				ImprimeLista(arqEntrada);
				menu(sc);
				op = sc.nextInt();
				sc.nextLine();
			} else if (op == 3) {
				System.out.println("Até a próxima !");
				break;
			} else {
				System.out.println("Opção Inválida. Terminando...");
				op = 0;
			}

		}
		sc.close();
	}

	public static void populaListaImprime(Scanner sc, SimpleDateFormat sdf, File in, List<Pessoa> listaPessoa) {
		try (BufferedReader br = new BufferedReader(new FileReader(in))) {
			String line = br.readLine();
			while (line != null) {
				String[] vetorLeitura = line.split(",");
				String nome = vetorLeitura[0];
				Date dtNasc = sdf.parse(vetorLeitura[1]);
				String cidade = vetorLeitura[2];
				String estado = vetorLeitura[3];
				listaPessoa.add(new Pessoa(nome, dtNasc, cidade, estado));
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (java.text.ParseException e) {
			System.out.println(e.getLocalizedMessage());
		}
		for (Pessoa x : listaPessoa) {
			System.out.println(x);
		}
	}

	public static void escreveRegistroEntrada(SimpleDateFormat sdf, File in, Pessoa p) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(in, true))) {
			bw.newLine();
			bw.write(p.getNome() + "," + sdf.format(p.getDtNasc()) + "," + p.getCidadeNasc() + "," + p.getEstado());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void escreveRegistroSaida(Scanner sc, SimpleDateFormat sdf, File out, List<Pessoa> list) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
			for (Pessoa p : list) {
				bw.write(p.getNome() + ", " + p.calculaIdade() + " anos, natural de " + p.getCidadeNasc() + " / "
						+ p.getEstado());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void ImprimeLista(File in) {
		try (BufferedReader br = new BufferedReader(new FileReader(in))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void menu(Scanner sc) {
		System.out.println("\n--------------------------------------------------");
		System.out.println("\n Escolha entre as opções do Menu : ");
		System.out.println("1 - Adicionar novo Registro");
		System.out.println("2 - Reimprimir Registros");
		System.out.println("3 - Sair");
		System.out.println("--------------------------------------------------");
	}
}
