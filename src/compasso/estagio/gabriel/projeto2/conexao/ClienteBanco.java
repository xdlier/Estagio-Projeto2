package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import compasso.estagio.gabriel.projeto2.funcionalidades.Cadastro;
import compasso.estagio.gabriel.projeto2.principal.Cliente;

public class ClienteBanco {

	public static ArrayList<Cliente> ListaCliente() {
		try {

			String SQL = "SELECT * FROM cliente ORDER BY nome";
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();

			while (rs.next()) {
				clientes.add(new Cliente(rs.getString("nome"), rs.getString("CPF"), rs.getString("TurnoDeTreino")));
			}
			ps.close();
			return clientes;

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
		return null;
	}

	public static Cliente BuscaCliente(int matricula) {
		try {

			String SQL = "SELECT * FROM cliente WHERE matricula = " + matricula;
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			rs.first();
			Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("CPF"), rs.getString("TurnoDeTreino"));
			ps.close();
			return cliente;

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
		return null;
	}

	public static void cadastrador(Cliente cliente) {

		String SQL = "INSERT INTO cliente(matricula,nome,CPF,TurnoDeTreino) VALUES(?,?,?,?)";

		try {

			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.setInt(1, cliente.getMatricula());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getTurnoDeTreino());
			ps.execute();
			ps.close();
			System.out.println("\nCadastro realizado com sucesso.");
			System.out.println("Sua matricula é: " + cliente.getMatricula() + "\n");

		} catch (SQLException e) {
			if(e.getMessage().equals("Duplicate entry '13' for key 'cliente.CPF_UNIQUE'")) {
				System.out.println("CPF já cadastrado, tente novamente.");
				Cadastro.cadastrarCliente();
			}
			System.out.println("Erro ao adicionar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}
	

	public static void excluirCliente(int matricula) {
		try {

			String SQL = "DELETE FROM cliente WHERE matricula = " + matricula;
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.execute();
			ps.close();
			System.out.println("\nExclusão realizada com sucesso.\n");

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}

}
