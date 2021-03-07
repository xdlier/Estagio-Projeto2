package compasso.estagio.gabriel.projeto2.funcionalidades;

public class ValidadorCPF {

	public static void Validador(String cpf) {

		int valida1 = 0;
		int valida2 = 0;

		try {
			for (int i = 0; i < 9; i++) {
				valida1 += (cpf.charAt(i) - 48) * (i + 1);
			}
			for (int i = 0; i < 10; i++) {
				valida2 += (cpf.charAt(i) - 48) * (i);
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Por favor informe o CPF completo");
			Cadastro.cadastrarCliente();
		}

		valida1 %= 11;
		valida2 %= 11;

		if (valida1 == 10) {
			valida1 = 0;
		}
		if (valida2 == 10) {
			valida2 = 0;
		}

		if (valida1 == cpf.charAt(9) - 48 && valida2 == cpf.charAt(10) - 48)
			return;
		System.out.println("CPF inválido, tente novamente!\n");
		Cadastro.cadastrarCliente();
	}
}
