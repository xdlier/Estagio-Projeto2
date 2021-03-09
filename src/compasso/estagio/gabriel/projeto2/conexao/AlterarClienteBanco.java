package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AlterarClienteBanco {
	
	public static void alterarNomeCliente(int matricula, String novo) {

		String SQL = "UPDATE cliente SET nome = ? WHERE matricula = " + matricula;
		
		try {

			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.setString(1, novo);
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral \nErro: " + e.getMessage());
		}
	}
	
	public static void alterarTurnoCliente(int matricula, String novo) {

		String SQL = "UPDATE cliente SET TurnoDeTreino = ? WHERE matricula = " + matricula;

		try {

			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ps.setString(1, novo);
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral \nErro: " + e.getMessage());
		}
	}

}
