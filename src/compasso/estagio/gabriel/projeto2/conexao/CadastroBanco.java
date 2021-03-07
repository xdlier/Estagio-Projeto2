package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import compasso.estagio.gabriel.projeto2.funcionalidades.Cadastro;

public class CadastroBanco{
	
	public static void cadastrarCliente(int matricula, String nome, String cpf, String turno) {

		String SQL = "INSERT INTO cliente(matricula,nome,CPF,TurnoDeTreino) VALUES(?,?,?,?)";

		try {

			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.setInt(1, matricula);
			ps.setString(2, nome);
			ps.setString(3, cpf);
			ps.setString(4, turno);
			ps.execute();
			ps.close();
			System.out.println("\nCadastro realizado com sucesso.");
			System.out.println("Sua matricula é: " + matricula + "\n");

		} catch (SQLException e) {
			if (e.getMessage().equals("Duplicate entry '13' for key 'cliente.CPF_UNIQUE'")) {
				System.out.println("CPF já cadastrado, tente novamente.\n");
				Cadastro.cadastrarCliente();
			}
			System.out.println("Erro ao adicionar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}

}
