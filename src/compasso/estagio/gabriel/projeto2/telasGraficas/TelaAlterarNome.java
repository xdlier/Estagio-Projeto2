package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import compasso.estagio.gabriel.projeto2.conexao.AlterarClienteBanco;

public class TelaAlterarNome extends JFrame {

	private JPanel contentPane;
	private JTextField novo;

	
	
	public TelaAlterarNome(int matricula) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo nome:");
		lblNewLabel.setBounds(21, 27, 88, 24);
		contentPane.add(lblNewLabel);
		
		novo = new JTextField();
		novo.setBounds(94, 29, 162, 20);
		contentPane.add(novo);
		novo.setColumns(10);
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarClienteBanco.alterarNomeCliente(matricula, novo.getText());
				dispose();
			}
		});
		alterar.setBounds(49, 80, 89, 23);
		contentPane.add(alterar);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		voltar.setBounds(148, 80, 89, 23);
		contentPane.add(voltar);
	}

}
