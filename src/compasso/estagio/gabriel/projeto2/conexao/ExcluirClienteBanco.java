package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirClienteBanco {

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
