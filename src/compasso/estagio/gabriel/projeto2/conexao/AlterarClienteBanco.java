package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import compasso.estagio.gabriel.projeto2.funcionalidades.Alteracoes;

public class AlterarClienteBanco {
	
	public static void alterarNomeCliente(int matricula, String novo) {

		String SQL = "UPDATE cliente SET nome = ? WHERE matricula = " + matricula;

		try {

			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.setString(1, novo);
			ps.execute();
			ps.close();
			System.out.println("\nAlteração realizada com sucesso.");

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}
	
	public static void alterarTurnoCliente(int matricula, String novo) {

		String SQL = "UPDATE cliente SET TurnoDeTreino = ? WHERE matricula = " + matricula;

		try {

			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.setString(1, novo);
			ps.execute();
			ps.close();
			System.out.println("\nAlteração realizada com sucesso.");

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}

}
