package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.InputMismatchException;
import java.util.Scanner;

import compasso.estagio.gabriel.projeto2.conexao.ClienteBanco;
import compasso.estagio.gabriel.projeto2.principal.Cliente;

public class Cadastro {

	private static Scanner read = new Scanner(System.in);

	public static void cadastrarCliente() {

		String nome, cpf, turno;

		System.out.println("\nInforme o nome:");
		nome = read.nextLine();
		System.out.println("Informe o cpf:");
		cpf = read.nextLine();
		System.out.println("Informe o turno:");
		turno = read.nextLine();
		ClienteBanco.cadastrador(new Cliente(nome, cpf, turno));
		TelaInicial.telaInicial();

	}

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
