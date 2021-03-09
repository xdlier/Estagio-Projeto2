package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.Button;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import compasso.estagio.gabriel.projeto2.conexao.ConsultaBanco;
import compasso.estagio.gabriel.projeto2.funcionalidades.Matricula;

public class TelaAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;
	private String escolha;

	public TelaAlterar() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		setTitle("Tela de Altera\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton proximo = new JButton("Pr\u00F3ximo");
		proximo.setBounds(119, 208, 89, 23);
		proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (matricula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Matrícula em branco, digite a matrícula corretamente");
				} else if (Matricula.getMatricula(matricula) == 0) {
					JOptionPane.showMessageDialog(null, "Matrícula incorreta, tente novamente");
				} else if (ConsultaBanco.BuscarCliente(Matricula.getMatricula(matricula))) {
					if (escolha == "Nome") {
						new TelaAlterarNome(Matricula.getMatricula(matricula));
					} else if (escolha == "Turno de treino") {
						new TelaAlterarTurno(Matricula.getMatricula(matricula));
					} else {
						JOptionPane.showMessageDialog(null, "Por favor escolha uma opção para atualização");
					}
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(proximo);

		JLabel lblNewLabel = new JLabel("Para atualizar o cadastro, por favor, preencha os campos abaixo:");
		lblNewLabel.setBounds(67, 11, 333, 33);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_1.setBounds(130, 54, 78, 23);
		contentPane.add(lblNewLabel_1);

		matricula = new JTextField();
		matricula.setBounds(187, 55, 130, 20);
		contentPane.add(matricula);
		matricula.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("O que gostaria de alterar?");
		lblNewLabel_2.setBounds(155, 104, 198, 20);
		contentPane.add(lblNewLabel_2);

		Choice choice = new Choice();
		choice.add("Escolha...");
		choice.add("Nome");
		choice.add("Turno de treino");
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				escolha = choice.getSelectedItem();
			}
		});
		choice.setBounds(155, 143, 124, 20);
		contentPane.add(choice);

		Button voltar = new Button("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial();
				dispose();
			}
		});
		voltar.setBounds(240, 208, 89, 22);
		contentPane.add(voltar);
	}

}
