package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import compasso.estagio.gabriel.projeto2.funcionalidades.Alteracoes;
import compasso.estagio.gabriel.projeto2.funcionalidades.Consulta;

public class ConsultaBanco {

	public static void BuscarCliente(int matricula, int i) {
		try {

			String SQL = "SELECT * FROM cliente WHERE matricula = " + matricula;
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			System.out.println("\nO resultado da sua consulta é:\n----------------------------\nNome: "
					+ rs.getString("nome") + "\nTurno de treino: " + rs.getString("TurnoDeTreino")
					+ "\n----------------------------\n");
			ps.close();

		} catch (SQLException e) {
			if (e.getMessage().equals("Illegal operation on empty result set.")) {
				System.out.println("Nenhuma matricula encontrada, tente novamente!");
				if(i>0) {
					Alteracoes.alterarCadastro();
				}
				Consulta.consultarCliente();
			}
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}
	
}
