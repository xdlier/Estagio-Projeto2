package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.InputMismatchException;
import java.util.Scanner;

import compasso.estagio.gabriel.projeto2.conexao.ClienteBanco;

public class Deletar {
	
	private static Scanner read = new Scanner(System.in);
	
	public static void excluirCliente() {

		try {
			System.out.println("\nInforme a matrícula:");
			int matricula = read.nextInt();
			read.nextLine();
			ClienteBanco.excluirCliente(matricula);
			TelaInicial.telaInicial();
		} catch (InputMismatchException e) {
			read.nextLine();
			System.out.println("Por favor, utilize apenas números!\n");
			excluirCliente();
		}

	}
}
