package compasso.estagio.gabriel.projeto2.principal;

import compasso.estagio.gabriel.projeto2.conexao.ConexaoBanco;
import compasso.estagio.gabriel.projeto2.funcionalidades.TelaInicial;

public class Projeto2 {

	public static void main(String[] args) {

		ConexaoBanco.conectar();
		TelaInicial.telaInicial();
		ConexaoBanco.desconectar(ConexaoBanco.getConnection());
		
	}

}
