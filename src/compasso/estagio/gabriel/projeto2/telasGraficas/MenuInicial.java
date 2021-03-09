package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import compasso.estagio.gabriel.projeto2.conexao.ConexaoBanco;

public class MenuInicial extends JFrame {

	private JPanel contentPane;


	public MenuInicial() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setTitle("Menu Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" O que deseja fazer?");
		lblNewLabel.setBounds(187, 11, 316, 34);
		contentPane.add(lblNewLabel);
		
		JButton cadastro = new JButton("Cadastrar Cliente");
		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastro();
				dispose();
			}
		});
		cadastro.setBounds(51, 74, 155, 23);
		contentPane.add(cadastro);
		
		JButton buscar = new JButton("Buscar Cliente");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConsulta();
				dispose();
			}
		});
		buscar.setBounds(291, 74, 155, 23);
		contentPane.add(buscar);
		
		JButton excluir = new JButton("Excluir Cadastro");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaDelete();
				dispose();
			}
		});
		excluir.setBounds(51, 120, 155, 23);
		contentPane.add(excluir);
		
		JButton atualizar = new JButton("Atualizar Cadastro");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAlterar();
				dispose();
			}
		});
		atualizar.setBounds(291, 120, 155, 23);
		contentPane.add(atualizar);
		
		JButton listar = new JButton("Consultar Lista de Clientes");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLista();
				dispose();
			}
		});
		listar.setBounds(145, 168, 190, 23);
		contentPane.add(listar);
		
		JButton sair = new JButton("SAIR");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ConexaoBanco.desconectar(ConexaoBanco.getConnection());
			}
		});
		sair.setBounds(195, 226, 89, 23);
		contentPane.add(sair);
	}

}
