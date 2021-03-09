package compasso.estagio.gabriel.projeto2.funcionalidades;

public class Cliente {

	String nome, turno;
	int matricula;

	public Cliente(String nome, String turno, int matricula) {
		this.nome = nome;
		this.turno = turno;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getTurno() {
		return turno;
	}

	public int getMatricula() {
		return matricula;
	}

}
