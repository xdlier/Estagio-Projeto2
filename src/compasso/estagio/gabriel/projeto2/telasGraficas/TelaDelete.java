package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import compasso.estagio.gabriel.projeto2.conexao.ExcluirClienteBanco;
import compasso.estagio.gabriel.projeto2.funcionalidades.Matricula;

public class TelaDelete extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;

	public TelaDelete() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		setTitle("Tela de Delete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Por favor, informe a matr\u00EDcula do cliente que deseja deletar.");
		lblNewLabel.setBounds(58, 11, 400, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_1.setBounds(99, 52, 81, 20);
		contentPane.add(lblNewLabel_1);

		matricula = new JTextField();
		matricula.setBounds(169, 52, 122, 20);
		contentPane.add(matricula);
		matricula.setColumns(10);

		JButton delete = new JButton("Deletar");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (matricula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Matrícula em branco, digite a matrícula corretamente");
				} else {
					ExcluirClienteBanco.excluirCliente(Matricula.getMatricula(matricula));
				}
			}
		});
		delete.setBounds(129, 88, 89, 23);
		contentPane.add(delete);

		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial();
				dispose();
			}
		});
		voltar.setBounds(234, 88, 89, 23);
		contentPane.add(voltar);
	}

}
