package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.Random;
import java.util.Scanner;

import compasso.estagio.gabriel.projeto2.conexao.CadastroBanco;

public class Cadastro {

	private static Scanner read = new Scanner(System.in);

	public static void cadastrarCliente() {

		String nome, cpf, turno;

		System.out.println("\nInforme o nome:");
		nome = read.nextLine();
		System.out.println("Informe o cpf:");
		cpf = read.nextLine();
		ValidadorCPF.Validador(cpf);
		System.out.println("Qual o turno que gostaria de participar:\nM - Matituno\nV - Vespertino\nN - Noturno");
		turno = setTurno(read.nextLine());
		CadastroBanco.cadastrarCliente(geradorMatricula(), nome, cpf, turno);
		TelaInicial.telaInicial();
	}

	private static int geradorMatricula() {
		Random aleatorio = new Random();
		int matricula = aleatorio.nextInt();
		if (matricula < 0) {
			matricula *= (-1);
		}
		return matricula;
	}

	public static String setTurno(String turno) {
		switch (turno) {
		case "V", "v":
			return turno = "Vespertino";
		case "M", "m":
			return turno = "Matutino";
		case "N", "n":
			return turno = "Noturno";
		default:
			System.out.println("");
			return turno = null;
		}
	}
}
