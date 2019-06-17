package gui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("Sistema de Restaurante - Time 5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Produtos");
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoListTela listTela = new ProdutoListTela();
				listTela.setVisible(true);
				
				setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pedidos");
		btnNewButton_1.setBackground(new Color(255, 248, 220));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Funcion\u00E1rios");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioListTela funcionarioListTela = new FuncionarioListTela();
				funcionarioListTela.setVisible(true);
				
				setVisible(false);
			}
		});
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.setBackground(new Color(240, 128, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnNewButton_3);
	}

}
