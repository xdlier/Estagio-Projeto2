package compasso.estagio.gabriel.projeto2.telasGraficas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	public TelaInicial() {
		
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
		setBounds(100, 100, 451, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seja bem vindo a academia da Compasso UOL, vamos come\u00E7ar?");
		lblNewLabel.setBounds(34, 11, 444, 85);
		contentPane.add(lblNewLabel);
		
		JButton iniciar = new JButton("Iniciar");
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuInicial();
				dispose();
			}
		});
		iniciar.setBounds(166, 91, 89, 23);
		contentPane.add(iniciar);
	}

}
