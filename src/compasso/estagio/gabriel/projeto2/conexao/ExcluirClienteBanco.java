package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ExcluirClienteBanco {

	public static void excluirCliente(int matricula) {
		try {
			if (ConsultaBanco.BuscarCliente(matricula)) {
				String SQL = "DELETE FROM cliente WHERE matricula = " + matricula;
				PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso.");
			}
		} catch (SQLException e) {
			if (e.getMessage().equals("Illegal operation on empty result set.")) {
				JOptionPane.showMessageDialog(null, "Tente novamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao deletar\nErro: " + e.getMessage());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral\nErro: " + e.getMessage());
		}
	}

}
