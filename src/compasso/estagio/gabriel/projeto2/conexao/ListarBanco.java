package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import compasso.estagio.gabriel.projeto2.funcionalidades.Cliente;

public class ListarBanco {

	public static List<Cliente> ListarClientes() {
		try {
			List<Cliente> clientes = new ArrayList<>();
			String SQL = "SELECT * FROM cliente GROUP BY TurnoDeTreino, nome ORDER BY TurnoDeTreino, nome";
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				clientes.add(new Cliente(rs.getString("nome"), rs.getString("TurnoDeTreino"), rs.getInt("matricula")));
			}
			ps.close();
			JOptionPane.showMessageDialog(null, "Lista de alunos concluida com sucesso");
			return clientes;

		} catch (SQLException e) {
			System.out.println("Erro ao recuperar\nErro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro geral" + e.getMessage());
		}
		return null;
	}

}
