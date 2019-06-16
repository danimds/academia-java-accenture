package gui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import time5.entidades.Produto;
import time5.servicos.ProdutoServico;
import java.awt.Color;

public class ProdutoEditarTela extends JFrame {
	
	private int id;
	private JTextField textFieldNomeProduto;
	private JTextField textFieldPrecoProduto;
	private JTextField textFieldTipoProduto;
	private JTextField textFieldDescricaoProduto;
	private JPanel contentPane;
	private ProdutoServico servico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoEditarTela frame = new ProdutoEditarTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param i
	 */
	public ProdutoEditarTela() {
		this.servico = new ProdutoServico();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNovoProduto = new JLabel("Editar Produto");
		lblNovoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNovoProduto, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(76, 36, 83, 14);
		panel.add(lblNewLabel);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(185, 33, 96, 20);
		panel.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPreo.setBounds(76, 64, 83, 14);
		panel.add(lblPreo);

		textFieldPrecoProduto = new JTextField();
		textFieldPrecoProduto.setColumns(10);
		textFieldPrecoProduto.setBounds(185, 61, 96, 20);
		panel.add(textFieldPrecoProduto);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTipo.setBounds(76, 92, 83, 14);
		panel.add(lblTipo);

		textFieldTipoProduto = new JTextField();
		textFieldTipoProduto.setColumns(10);
		textFieldTipoProduto.setBounds(185, 89, 96, 20);
		panel.add(textFieldTipoProduto);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDescrio.setBounds(76, 120, 83, 14);
		panel.add(lblDescrio);

		textFieldDescricaoProduto = new JTextField();
		textFieldDescricaoProduto.setColumns(10);
		textFieldDescricaoProduto.setBounds(185, 117, 96, 20);
		panel.add(textFieldDescricaoProduto);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoListTela tela = new ProdutoListTela();
				tela.setVisible(true);
				
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar Produto");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(250, 128, 114));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNomeProduto.getText();
				double preco = Double.parseDouble(textFieldPrecoProduto.getText());
				String tipo = textFieldTipoProduto.getText();
				String descricao = textFieldDescricaoProduto.getText();
				servico.atualizarProduto(id, nome, preco, tipo, descricao);
				
				ProdutoListTela produtoListTela = new ProdutoListTela();
				produtoListTela.setVisible(true);
				
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_1);
	}

	public void inicializar(int id) {
		this.id = id;
		Produto produto = servico.recuperar(id);
		textFieldNomeProduto.setText(produto.getNomeProduto());
		textFieldPrecoProduto.setText(String.valueOf(produto.getPreco()));
		textFieldTipoProduto.setText(produto.getTipo());
		textFieldDescricaoProduto.setText(produto.getDescricao());		
	}


}
