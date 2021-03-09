package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import compasso.estagio.gabriel.projeto2.conexao.ListarBanco;
import compasso.estagio.gabriel.projeto2.funcionalidades.Cliente;

public class TelaLista extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	

	public TelaLista() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setTitle("Lista de Clientes");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabela = new JTable();
		tabela.setCellSelectionEnabled(true);
		tabela.setColumnSelectionAllowed(true);
		tabela.setBounds(21, 11, 541, 257);
		getContentPane().add(tabela);
		
		JLabel lblNewLabel = new JLabel("Lista de clientes");
		lblNewLabel.setBounds(238, 21, 112, 21);
		contentPane.add(lblNewLabel);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial();
				dispose();
			}
		});
		voltar.setBounds(238, 427, 89, 23);
		contentPane.add(voltar);
		Listar();
	
	}

	public void Listar() {

		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.addColumn("Nome"); 
		modelo.addColumn("Turno");
		modelo.addColumn("Matricula");
		modelo.setNumRows(0);
		modelo.addRow(new Object[] {"Nome:", "Turno de treino:", "Matrícula:"});

		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(25);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(25);

		
		for (Cliente cliente : ListarBanco.ListarClientes()) {
			modelo.addRow(new Object[] {cliente.getNome(), cliente.getTurno(), cliente.getMatricula()});
		}
	}
}
