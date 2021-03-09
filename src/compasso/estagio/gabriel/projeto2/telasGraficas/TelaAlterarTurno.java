package compasso.estagio.gabriel.projeto2.telasGraficas;
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
import javax.swing.border.EmptyBorder;

import compasso.estagio.gabriel.projeto2.conexao.AlterarClienteBanco;

public class TelaAlterarTurno extends JFrame {

	private JPanel contentPane;
	private String turno;

	public TelaAlterarTurno(int matricula) {
		
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
		setBounds(100, 100, 317, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoTurno = new JLabel("Novo turno:");
		lblNovoTurno.setBounds(112, 18, 81, 24);
		contentPane.add(lblNovoTurno);
		
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
		choice.setBounds(74, 48, 136, 20);
		contentPane.add(choice);
		
		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarClienteBanco.alterarTurnoCliente(matricula, turno);
				dispose();
			}
		});
		alterar.setBounds(55, 109, 89, 23);
		contentPane.add(alterar);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		voltar.setBounds(157, 109, 89, 23);
		contentPane.add(voltar);
	}

}
