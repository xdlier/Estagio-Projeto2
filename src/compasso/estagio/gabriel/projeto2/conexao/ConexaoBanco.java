package compasso.estagio.gabriel.projeto2.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBanco {

	private static Connection con;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/academia";
	private static String user = "root";
	private static String password = "arzon123";

	public static void conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco de dados\nErro: " + e.getMessage());
			con = null;
		}
	}

	public static void desconectar(Connection con) {
		try {
			if (con != null) {
				con.close();
				JOptionPane.showMessageDialog(null, "Desconexão realizada com sucesso");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possivel desconectar do banco de dados\nErro: " + e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
