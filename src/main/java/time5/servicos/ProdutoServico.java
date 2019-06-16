package time5.servicos;

import java.util.List;

import time5.dao.InterfaceCrudDAO;
import time5.dao.ProdutoDAO;
import time5.entidades.Produto;

public class ProdutoServico {

	private InterfaceCrudDAO<Produto> dao;

	public ProdutoServico() {
		this.dao = new ProdutoDAO();
	}

	public void cadastrarProduto(String nome, double preco, String tipo, String descricao) {
		Produto p = new Produto();
		p.setNomeProduto(nome);
		p.setPreco(preco);
		p.setTipo(tipo);
		p.setDescricao(descricao);
		dao.insert(p);
	}

	public List<Produto> listarProdutos() {
		return dao.recupera();
	}

	public void atualizarProduto(int id, String nome, double preco, String tipo, String observacao) {
		Produto p = new Produto();
		p.setIdProduto(id);
		p.setNomeProduto(nome);
		p.setPreco(preco);
		p.setTipo(tipo);
		p.setDescricao(observacao);
		dao.update(p);
	}

	public void deletarProduto(int id) {
		dao.delete(id);
	}
	
	public Produto recuperar(int id) {
		return dao.recupera(id);
	}

}
