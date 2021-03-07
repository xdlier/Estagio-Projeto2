package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.Scanner;

import compasso.estagio.gabriel.projeto2.conexao.AlterarClienteBanco;
import compasso.estagio.gabriel.projeto2.conexao.ConsultaBanco;

public class Alteracoes {

	private static Scanner read = new Scanner(System.in);

	public static void alterarCadastro() {
		System.out.println("\nInforme a matrícula:");
		int matricula = read.nextInt();
		read.nextLine();
		ConsultaBanco.BuscarCliente(matricula, 1);
		System.out.println("O Que deseja alterar?\n1-Nome\n2-Turno de treino");
		String escolha = escolha(read.nextLine());
		String novo;
		if (escolha.equals("nome")) {
			System.out.println("Digite o novo nome:");
			novo = read.nextLine();
			AlterarClienteBanco.alterarNomeCliente(matricula, novo);
		} else {
			System.out.println("Qual o turno que gostaria de participar:\nM - Matituno\nV - Vespertino\nN - Noturno");
			novo = Cadastro.setTurno(read.nextLine());
			AlterarClienteBanco.alterarTurnoCliente(matricula, novo);
		}
		
		ConsultaBanco.BuscarCliente(matricula, 1);
		TelaInicial.telaInicial();
	}

	private static String escolha(String escolha) {
		switch (escolha) {
		case "1":
			return "nome";
		case "2":
			return "TurnoDeTreino";
		default:
			System.out.println("Escolha incorreta, tente novamente!");
			alterarCadastro();
			return null;
		}
	}
}
