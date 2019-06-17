package gui2;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import time5.entidades.Funcionario;
import time5.entidades.Produto;
import time5.servicos.FuncionarioServico;
import time5.servicos.ProdutoServico;

public class FuncionarioListTela extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JTable table;

	private FuncionarioServico funcionarioServico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioListTela frame = new FuncionarioListTela();
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
	public FuncionarioListTela() {
		this.funcionarioServico = new FuncionarioServico();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 430);
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

		JButton btnNovoProduto = new JButton("Novo Funcion\u00E1rio");
		btnNovoProduto.setForeground(new Color(255, 255, 255));
		btnNovoProduto.setBackground(new Color(250, 128, 114));
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioCadastroTela funcionarioCadastroTela = new FuncionarioCadastroTela();
				funcionarioCadastroTela.setVisible(true);

				setVisible(false);
			}
		});
		panel.add(btnNovoProduto);

		JButton btnEditarProduto = new JButton("Editar Funcion\u00E1rio");
		btnEditarProduto.setForeground(new Color(255, 255, 255));
		btnEditarProduto.setBackground(new Color(250, 128, 114));
		btnEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (Integer) modelo.getValueAt(table.getSelectedRow(), 0);

				FuncionarioEditarTela editarTela = new FuncionarioEditarTela();
				editarTela.inicializar(id);
				editarTela.setVisible(true);

				setVisible(false);
			}
		});
		panel.add(btnEditarProduto);

		JButton btnExcluirFuncionario = new JButton("Excluir Funcionário");
		btnExcluirFuncionario.setForeground(new Color(255, 255, 255));
		btnExcluirFuncionario.setBackground(new Color(250, 128, 114));
		btnExcluirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (Integer) modelo.getValueAt(table.getSelectedRow(), 0);
				funcionarioServico.deletarFuncionario(id);
				atualizarTabela();
			}
		});
		panel.add(btnExcluirFuncionario);

		JLabel lblListagemDeProdutos = new JLabel("Listagem de Funcion\u00E1rios");
		lblListagemDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblListagemDeProdutos, BorderLayout.NORTH);

		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Telefone");
		modelo.addColumn("Cargo");
		modelo.addColumn("Salário");
		modelo.addColumn("D. Nasc.");
		modelo.addColumn("Rua");
		modelo.addColumn("Número");
		modelo.addColumn("CEP");
		modelo.addColumn("Bairro");
		modelo.addColumn("Cidade");
		modelo.addColumn("UF");

		atualizarTabela();

		table = new JTable(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane barraRolagem = new JScrollPane(table);
		contentPane.add(barraRolagem, BorderLayout.CENTER);

	}

	private void atualizarTabela() {
		modelo.setRowCount(0); // reseta a tabela

		List<Funcionario> funcionaroList = funcionarioServico.listarFuncionarios();

		for (Funcionario funcionario : funcionaroList) {
			modelo.addRow(new Object[] { funcionario.getId(), funcionario.getNome(), funcionario.getCpf(),
					funcionario.getTelefone(), funcionario.getCargo(), funcionario.getSalario(),
					funcionario.getDataNascimento(), funcionario.getEndereco().getRua(),
					funcionario.getEndereco().getNumero(), funcionario.getEndereco().getCep(),
					funcionario.getEndereco().getBairro(), funcionario.getEndereco().getCidade(),
					funcionario.getEndereco().getEstado(), });
		}
	}

}
