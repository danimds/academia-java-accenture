package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import time5.servicos.ProdutoServico;

public class TelaProduto {
	
	private final String strings[] = {"Supervisor", "Monitor", "Op de Telemarketing"};
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaProduto(){
		final JTextField idP = new JTextField(20);
		final JTextField nomeP = new JTextField(20);
		final JTextField precoP = new JTextField(12);
		final JTextField tipoP = new JTextField(12);
		final JTextField descricaoP = new JTextField(20);

		final JFrame janela = new JFrame ("Manter Produto");  
		janela.setSize(500,200);
		janela.setLocation(150, 150);

		final JButton botaoLimpa = new JButton("Cancelar"); 
		final JButton botaoAdiciona = new JButton("Adicionar");
		final JButton botaoFecha = new JButton("Fechar");
		final JButton botaoConsultar = new JButton("Consultar");
		final JButton botaoRemover = new JButton("Remover");
		final JButton botaoAlterar = new JButton("Alterar");
		comboBox = new JComboBox( strings );

		JLabel lidP = new JLabel("ID:"); 
		JLabel lnomeP = new JLabel("Nome:"); 
		JLabel lprecoP = new JLabel("Preço:"); 
		JLabel ltipoP = new JLabel("Tipo:"); 
		JLabel ldescricaoP = new JLabel("Descrição:");

		JPanel painel = new JPanel();

		painel.add(lidP);
		painel.add(idP);
		painel.add(lnomeP); 
		painel.add(nomeP);	
		painel.add(lprecoP);
		painel.add(precoP);
		painel.add(ldescricaoP);
		painel.add(descricaoP);
		painel.add(ltipoP);
		painel.add(tipoP); 
		
		painel.add(botaoAdiciona);
		painel.add(botaoConsultar);
		painel.add(botaoAlterar);
		painel.add(botaoRemover);
		painel.add(botaoLimpa);
		
		//painel.add(comboBox);
		painel.add(botaoFecha);

		janela.getContentPane().add(painel);  
		/* Quando o usuário clicar no botao, limpa o campo de texto */  
		botaoLimpa.addActionListener (new ActionListener() {  
		public void actionPerformed (ActionEvent e) {  
		nomeP.setText("");  
		precoP.setText("");
		tipoP.setText("");
		descricaoP.setText("");
			}});  
			/* Exibe a janela */  
			janela.setVisible(true); 
			janela.setModalExclusionType(null);
		botaoFecha.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						janela.setVisible(false);
					}
					
				}
				);	
		
		//Adiciona o objeto
		botaoAdiciona.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				int idProduto = Integer.parseInt(idP.getText());
				String nomeProduto = (String) nomeP.getText();	
				double precoProduto = Double.parseDouble(precoP.getText());
				String tipoProduto = (String) tipoP.getText();
				String descricaoProduto = (String) descricaoP.getText();
				
				ProdutoServico servico = new ProdutoServico();
				servico.cadastrarProduto(nomeProduto, precoProduto, tipoProduto, descricaoProduto);
				
			}});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
