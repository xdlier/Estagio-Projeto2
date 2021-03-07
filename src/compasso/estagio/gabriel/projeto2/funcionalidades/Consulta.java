package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.InputMismatchException;
import java.util.Scanner;

import compasso.estagio.gabriel.projeto2.conexao.ConsultaBanco;
import compasso.estagio.gabriel.projeto2.conexao.ListarBanco;

public class Consulta {

	private static Scanner read = new Scanner(System.in);

	public static void consultarListaClientes() {

		ListarBanco.ListarClientes();
		TelaInicial.telaInicial();
	}

	public static void consultarCliente() {

		try {
			System.out.println("\nInforme a matrícula:");
			int matricula = read.nextInt();
			read.nextLine();
			ConsultaBanco.BuscarCliente(matricula, 0);
			TelaInicial.telaInicial();
		} catch (InputMismatchException e) {
			read.nextLine();
			System.out.println("Por favor, utilize apenas números!\n");
			consultarCliente();
		}

	}
}
