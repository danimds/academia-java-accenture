package gui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import time5.entidades.Produto;
import time5.servicos.ProdutoServico;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class ProdutoListTela extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JTable table;

	private ProdutoServico produtoServico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoListTela frame = new ProdutoListTela();
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
	public ProdutoListTela() {
		this.produtoServico = new ProdutoServico();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(250, 128, 114));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
				
				setVisible(false);
			}
		});
		panel.add(btnVoltar);

		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.setForeground(new Color(255, 255, 255));
		btnNovoProduto.setBackground(new Color(250, 128, 114));
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoCadastroTela produtoCadastroTela = new ProdutoCadastroTela();
				produtoCadastroTela.setVisible(true);
				
				setVisible(false);
			}
		});
		panel.add(btnNovoProduto);

		JButton btnEditarProduto = new JButton("Editar Produto");
		btnEditarProduto.setForeground(new Color(255, 255, 255));
		btnEditarProduto.setBackground(new Color(250, 128, 114));
		btnEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (Integer) modelo.getValueAt(table.getSelectedRow(), 0);
				
				ProdutoEditarTela editarTela = new ProdutoEditarTela();
				editarTela.inicializar(id);
				editarTela.setVisible(true);
				
				setVisible(false);
			}
		});
		panel.add(btnEditarProduto);

		JButton btnExcluirProduto = new JButton("Excluir Produto");
		btnExcluirProduto.setForeground(new Color(255, 255, 255));
		btnExcluirProduto.setBackground(new Color(250, 128, 114));
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (Integer) modelo.getValueAt(table.getSelectedRow(), 0);
				produtoServico.deletarProduto(id);
				atualizarTabela();
			}
		});
		panel.add(btnExcluirProduto);

		JLabel lblListagemDeProdutos = new JLabel("Listagem de Produtos");
		lblListagemDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblListagemDeProdutos, BorderLayout.NORTH);

		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Preço");
		modelo.addColumn("Tipo");
		modelo.addColumn("Descrição");

		atualizarTabela();

		table = new JTable(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane barraRolagem = new JScrollPane(table);
		contentPane.add(barraRolagem, BorderLayout.CENTER);

	}
	
	private void atualizarTabela() {
		modelo.setRowCount(0);	// reseta a tabela
		
		List<Produto> produtoList = this.produtoServico.listarProdutos();

		for (Produto produto : produtoList) {
			modelo.addRow(new Object[] { produto.getIdProduto(), produto.getNomeProduto(), produto.getPreco(),
					produto.getTipo(), produto.getDescricao() });
		}
	}

}
