package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import compasso.estagio.gabriel.projeto2.conexao.CadastroBanco;
import compasso.estagio.gabriel.projeto2.funcionalidades.Matricula;
import compasso.estagio.gabriel.projeto2.funcionalidades.ValidadorCPF;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private String turno;

	public TelaCadastro() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Para realizar o cadasto, preencha as seguintes informa\u00E7\u00F5es:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(61, 28, 336, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setBounds(10, 76, 57, 26);
		contentPane.add(lblNewLabel_1);

		nome = new JTextField();
		nome.setBounds(48, 79, 253, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CPF: ");
		lblNewLabel_2.setBounds(311, 76, 46, 26);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Qual turno de treino gostaria de se matricular?");
		lblNewLabel_3.setBounds(107, 110, 290, 45);
		contentPane.add(lblNewLabel_3);
		
		cpf = new JTextField();
		cpf.setBounds(338, 79, 86, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);

		Button cadastrar = new Button("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nome.getText().isEmpty() || cpf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Algum dos campos está vazio, por favor preencha completamente!");
				} else if(ValidadorCPF.Validador(cpf.getText())) {
					CadastroBanco.cadastrarCliente(Matricula.geradorMatricula(), nome.getText(), cpf.getText(), turno);
				}
			}
		});
		cadastrar.setBounds(138, 229, 70, 22);
		contentPane.add(cadastrar);

		Button voltar = new Button("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial();
				dispose();
			}
		});
		voltar.setBounds(229, 229, 70, 22);
		contentPane.add(voltar);

		Choice choice = new Choice();
		choice.add("Escolha...");
		choice.add("Matutino");
		choice.add("Vespertino");
		choice.add("Noturno");
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (choice.getSelectedItem() == "Escolha...") {
					JOptionPane.showMessageDialog(null, "Por favor escolha uma opção para turno de treino");
				} else {
					turno = choice.getSelectedItem();
				}
			}
		});
		choice.setBounds(162, 149, 125, 20);
		contentPane.add(choice);
	}

	

}
