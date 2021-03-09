package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.\nSua matricula é:" + matricula);

		} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "CPF já cadastrado, tente novamente.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral\nErro: " + e.getMessage());
		}
	}

}
