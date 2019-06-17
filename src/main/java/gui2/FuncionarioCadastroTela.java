package gui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import time5.entidades.Endereco;
import time5.servicos.FuncionarioServico;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class FuncionarioCadastroTela extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldTelefone;
	private JTextField textFieldCargo;
	private JTextField textFieldSalario;
	private JTextField textFieldDatadeNascimento;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCEP;
	private JTextField textFieldCidade;
	private JTextField textFieldUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioCadastroTela frame = new FuncionarioCadastroTela();
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
	public FuncionarioCadastroTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(21, 26, 58, 14);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(86, 26, 96, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(86, 58, 96, 20);
		panel.add(textFieldCPF);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(21, 58, 58, 14);
		panel.add(lblCpf);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(86, 89, 96, 20);
		panel.add(textFieldTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(20, 89, 69, 14);
		panel.add(lblTelefone);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(86, 120, 96, 20);
		panel.add(textFieldCargo);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(20, 120, 59, 14);
		panel.add(lblCargo);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(86, 154, 96, 20);
		panel.add(textFieldSalario);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(21, 154, 58, 14);
		panel.add(lblSalrio);
		
		JLabel lblAniversrio = new JLabel("Data nasc");
		lblAniversrio.setBounds(21, 195, 58, 14);
		panel.add(lblAniversrio);
		
		textFieldDatadeNascimento = new JTextField();
		textFieldDatadeNascimento.setColumns(10);
		textFieldDatadeNascimento.setBounds(86, 195, 96, 20);
		panel.add(textFieldDatadeNascimento);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(255, 26, 73, 14);
		panel.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(310, 26, 96, 20);
		panel.add(textFieldRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(255, 58, 73, 14);
		panel.add(lblNmero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(310, 58, 96, 20);
		panel.add(textFieldNumero);
		
		JLabel lblCep = new JLabel("Bairro");
		lblCep.setBounds(255, 89, 73, 14);
		panel.add(lblCep);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(310, 89, 96, 20);
		panel.add(textFieldBairro);
		
		JLabel lblUf = new JLabel("CEP");
		lblUf.setBounds(255, 120, 73, 14);
		panel.add(lblUf);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(310, 120, 96, 20);
		panel.add(textFieldCEP);
		
		JLabel lblBairro = new JLabel("Cidade");
		lblBairro.setBounds(255, 154, 73, 14);
		panel.add(lblBairro);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(310, 154, 96, 20);
		panel.add(textFieldCidade);
		
		JLabel lblUf_1 = new JLabel("UF");
		lblUf_1.setBounds(255, 192, 73, 14);
		panel.add(lblUf_1);
		
		textFieldUF = new JTextField();
		textFieldUF.setColumns(10);
		textFieldUF.setBounds(310, 192, 96, 20);
		panel.add(textFieldUF);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioListTela funcionarioListTela = new FuncionarioListTela();
				funcionarioListTela.setVisible(true);
				
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salvar Funcion\u00E1rio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				String cpf= textFieldCPF.getText();
				String telefone = textFieldTelefone.getText();
				String cargo = textFieldCargo.getText();
				double salario = Double.parseDouble(textFieldSalario.getText());
				String data = textFieldDatadeNascimento.getText();
				Endereco endereco = new Endereco();
				endereco.setRua(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setCep(textFieldCEP.getText());
				endereco.setEstado(textFieldUF.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				
				FuncionarioServico funcionarioServico = new FuncionarioServico();
				funcionarioServico.cadastrarFuncionario(nome, cpf, telefone, cargo, salario, data, endereco);
				
				FuncionarioListTela funcionarioListTela = new FuncionarioListTela();
				funcionarioListTela.setVisible(true);
				
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(250, 128, 114));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Novo Funcion\u00E1rio");
		panel_2.add(lblNewLabel);
	}
}
