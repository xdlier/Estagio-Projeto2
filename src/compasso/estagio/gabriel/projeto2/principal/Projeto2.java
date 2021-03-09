package compasso.estagio.gabriel.projeto2.principal;

import compasso.estagio.gabriel.projeto2.conexao.ConexaoBanco;
import compasso.estagio.gabriel.projeto2.telasGraficas.TelaInicial;

public class Projeto2 {

	public static void main(String[] args) {
		ConexaoBanco.conectar();
		new TelaInicial();
	}

}
