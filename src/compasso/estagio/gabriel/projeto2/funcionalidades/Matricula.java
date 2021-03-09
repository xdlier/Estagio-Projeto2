package compasso.estagio.gabriel.projeto2.funcionalidades;

import java.util.Random;

import javax.swing.JTextField;

public class Matricula {

	public static int geradorMatricula() {
		Random aleatorio = new Random();
		int matricula = aleatorio.nextInt(999999);
		if (matricula < 0) {
			matricula *= (-1);
		}
		if (matricula <= 999999 || matricula > 99999) {
			return matricula;
		} else {
			return geradorMatricula();
		}
	}

	public static int getMatricula(JTextField matricula) {
		try {
			return ((matricula.getText().charAt(0) - 48) * 100000) + ((matricula.getText().charAt(1) - 48) * 10000)
					+ ((matricula.getText().charAt(2) - 48) * 1000) + ((matricula.getText().charAt(3) - 48) * 100)
					+ ((matricula.getText().charAt(4) - 48) * 10) + ((matricula.getText().charAt(5) - 48) * 1);
		} catch (Exception e) {
			return 0;
		}

	}
}
