package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.Scanner;

public class TelaInicial {

	private static Scanner read = new Scanner(System.in);

	public static void telaInicial() {

		System.out.println("Que atividade gostaria de realizar:\nA) Cadastrar cliente\n"
				+ "B) Consultar cliente\nC) Consultar lista de clientes\nD) Excluir Cliente"
				+ "\nE)Sair do sistema");
		String escolha = read.nextLine();

		switch (escolha.toLowerCase()) {

		case "a":
			Cadastro.cadastrarCliente();
			break;

		case "b":
			Consulta.consultarCliente();
			break;

		case "c":
			Consulta.consultarListaClientes();
			break;

		case "d":
			Cadastro.excluirCliente();
			break;
			
		case "e":
			break;

		default:
			System.out.println("Opcao invalida");
			telaInicial();
			break;

		}
	}
}
