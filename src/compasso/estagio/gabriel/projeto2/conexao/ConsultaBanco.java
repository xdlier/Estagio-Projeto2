package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConsultaBanco {
	
	public static boolean BuscarCliente(int matricula){
		try {
			String SQL = "SELECT * FROM cliente WHERE matricula = " + matricula;
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			JOptionPane.showMessageDialog(null, "\nO resultado da sua consulta é:\n----------------------------\nNome: "
					+ rs.getString("nome") + "\nTurno de treino: " + rs.getString("TurnoDeTreino")
					+ "\n----------------------------\n");
			ps.close();
			return true;

		} catch (SQLException e) {
			if (e.getMessage().equals("Illegal operation on empty result set.")) {
				JOptionPane.showMessageDialog(null, "Nenhuma matricula encontrada, tente novamente!");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao recuperar\nErro: " + e.getMessage());
			}
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral\nErro: " + e.getMessage());
			return false;
		}		
	}
	
}
