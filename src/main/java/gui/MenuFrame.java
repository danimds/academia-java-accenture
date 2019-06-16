package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	public MenuFrame(){
		super("Sistema Restaurante");
		
		JMenu fileMenu = new JMenu("Pedido");
		fileMenu.setMnemonic('S');
		
		JMenuItem aboutItem = new JMenuItem("Cadastrar");
		aboutItem.setMnemonic('C');
		fileMenu.add(aboutItem);
		aboutItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event){
						/*JOptionPane.showMessageDialog(MenuFrame.this,"A tela de cadastro deve ser chamada aqui","About",
						JOptionPane.PLAIN_MESSAGE);*/
						
								TelaPedido pedido = new TelaPedido();
								pedido.setVisible(true);
								
					}
				}
				);//tela branca até aqui

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('X');
		fileMenu.add(exitItem);
		exitItem.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						System.exit(0);
					}
				}
				);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
		
		JMenu funcMenu = new JMenu("Funcionario");
		funcMenu.setMnemonic('F');
		
		JMenuItem aboutItemF = new JMenuItem("Cadastrar");
		aboutItemF.setMnemonic('U');
		funcMenu.add(aboutItemF);
		aboutItemF.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event){
						JPanel painel = new JPanel();
						painel.setLayout(new GridLayout(3,1,0,5));
						//JOptionPane.showMessageDialog(MenuFrame.this,"A tela de cadastro deve ser chamada","About",
						//JOptionPane.PLAIN_MESSAGE);
						
						TelaFuncionario telafunc = new TelaFuncionario();
						telafunc.setVisible(true);
					}
				}
				);
		
		//setJMenuBar(bar);
		bar.add(funcMenu);
		
	
		
		JMenu clienteMenu = new JMenu("Produto");
		clienteMenu.setMnemonic('L');
		

		JMenuItem aboutItemI = new JMenuItem("Cadastrar");
		aboutItemI.setMnemonic('U');
		clienteMenu.add(aboutItemI);
		aboutItemI.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event){
						JPanel painel = new JPanel();
						painel.setLayout(new GridLayout(3,1,0,5));
						//JOptionPane.showMessageDialog(MenuFrame.this,"A tela de cadastro deve ser chamada","About",
						//JOptionPane.PLAIN_MESSAGE);
						TelaProduto tc = new TelaProduto();
						tc.setVisible(true);
					}
				}
				);
		
	//	setJMenuBar();
		 bar.add(clienteMenu);
		
	
	}
	
}
