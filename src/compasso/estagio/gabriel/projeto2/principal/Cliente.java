package compasso.estagio.gabriel.projeto2.principal;

import java.util.Random;

public class Cliente {

	private int matricula;
	private String nome;
	private String cpf;
	private String turnoDeTreino;
	
	public Cliente(String nome, String cpf, String turnoDeTreino) {
		Random aleatorio = new Random();
		matricula = aleatorio.nextInt();
		if(matricula<0) {
			matricula*=(-1);
		}
		this.nome = nome;
		this.cpf = cpf;
		this.turnoDeTreino = turnoDeTreino;
	}

	public int getMatricula() {
		return matricula;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTurnoDeTreino() {
		return turnoDeTreino;
	}

}
