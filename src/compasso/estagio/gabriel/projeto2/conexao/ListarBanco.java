package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarBanco {
	
	public static void ListarClientes() {
		try {

			String SQL = "SELECT * FROM cliente GROUP BY TurnoDeTreino, nome ORDER BY TurnoDeTreino, nome";
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("----------------------------\nNome: " + rs.getString("nome") + "\nTurno de treino: "
						+ rs.getString("TurnoDeTreino") + "\n----------------------------\n");
			}
			ps.close();

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
	}

}
