package time5.servicos;


import java.util.Date;
import java.util.List;

import time5.dao.FuncionadoDAO;
import time5.dao.InterfaceCrudDAO;
import time5.entidades.Endereco;
import time5.entidades.Funcionario;
import time5.entidades.Produto;

public class FuncionarioServico {
	
	private InterfaceCrudDAO<Funcionario> dao;

	
	public FuncionarioServico() {
		this.dao = new FuncionadoDAO();
	}
	
	public void cadastrarFuncionario(String nome, String cpf, String telefone, String cargo,
			double salario, String data, Endereco endereco) {
		Funcionario p = new Funcionario();
		p.setNome(nome);
		p.setCpf(cpf);
		p.setTelefone(telefone);
		p.setCargo(cargo);
		p.setSalario(salario);
		p.setDataNascimento(data);
		p.setEndereco(endereco);
		dao.insert(p);
	}
     
	public void atualizarFuncionario(int id, String nome, String cpf, String telefone, String cargo,
			double salario,String dataNascimento, Endereco endereco) {
		Funcionario p = new Funcionario();
		p.setId(id);
		p.setNome(nome);
		p.setCpf(cpf);
		p.setTelefone(telefone);
		p.setCargo(cargo);
		p.setSalario(salario);
		p.setDataNascimento(dataNascimento);
		p.setEndereco(endereco);
		dao.update(p);
	}
	
	public void deletarFuncionario(int id) {
		dao.delete(id);
	}
	
	public List<Funcionario> listarFuncionarios() {
		return dao.recupera();
	}
	
	public Funcionario recuperarFuncionario(int id) {
		return dao.recupera(id);
	}

}
