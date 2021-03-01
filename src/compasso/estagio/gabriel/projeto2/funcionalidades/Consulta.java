package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import compasso.estagio.gabriel.projeto2.conexao.ClienteBanco;
import compasso.estagio.gabriel.projeto2.principal.Cliente;

public class Consulta {

	private static Scanner read = new Scanner(System.in);

	public static void consultarListaClientes() {

		ArrayList<Cliente> clientes = ClienteBanco.ListaCliente();
		System.out.println("\nOs clientes cadastrados são:");
		if (clientes.isEmpty()) {
			System.out.println("\nNão tem clientes cadastrados!\n");
			TelaInicial.telaInicial();
		}
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println("----------------------------\nNome: " + clientes.get(i).getNome()
					+ "\nTurno de treino: " + clientes.get(i).getTurnoDeTreino() + "\n----------------------------\n");
		}
		TelaInicial.telaInicial();
	}

	public static void consultarCliente() {

		try {
			System.out.println("\nInforme a matrícula:");
			int matricula = read.nextInt();
			Cliente cliente = ClienteBanco.BuscaCliente(matricula);
			System.out.println(
					"\nO resultado da sua consulta é:\n----------------------------\nNome: " + cliente.getNome()
							+ "\nTurno de treino: " + cliente.getTurnoDeTreino() + "\n----------------------------\n");
			TelaInicial.telaInicial();
		} catch (NullPointerException e) {
			System.out.println("Nenhuma matrícula encontrada, tente novamente.\n");
			TelaInicial.telaInicial();
		} catch (InputMismatchException e) {
			read.nextLine();
			System.out.println("Por favor, utilize apenas números!\n");
			consultarCliente();
		}

	}
}
