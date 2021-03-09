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

import compasso.estagio.gabriel.projeto2.conexao.ConexaoBanco;
import compasso.estagio.gabriel.projeto2.conexao.ConsultaBanco;
import compasso.estagio.gabriel.projeto2.funcionalidades.Matricula;

public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;


	public TelaConsulta() {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setTitle("Tela de Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Por favor, informe a matr\u00EDcula do cliente desejado");
		lblNewLabel.setBounds(68, 11, 427, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_1.setBounds(103, 59, 84, 24);
		contentPane.add(lblNewLabel_1);

		matricula = new JTextField();
		matricula.setBounds(173, 61, 99, 20);
		contentPane.add(matricula);
		matricula.setColumns(10);

		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (matricula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Matrícula em branco, digite a matrícula corretamente");
				} else {
					ConsultaBanco.BuscarCliente(Matricula.getMatricula(matricula));
				}
			}
		});
		buscar.setBounds(115, 127, 89, 23);
		contentPane.add(buscar);

		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial();
				dispose();
			}
		});
		voltar.setBounds(242, 127, 89, 23);
		contentPane.add(voltar);
	}
	
	


}
