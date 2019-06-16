package time5.servicos;

import java.util.List;

import time5.dao.InterfaceCrudDAO;
import time5.dao.PedidoDAO;
import time5.entidades.Pedido;

public class PedidoServico {

	private InterfaceCrudDAO<Pedido> dao;

	public PedidoServico() {
		this.dao = new PedidoDAO();
	}

	public void cadastrarPedido(int idPedido, int numeroMesa, String observacao) {
		Pedido p = new Pedido();
		p.setIdPedido(idPedido);
		p.setNumeroMesa(numeroMesa);
		p.setObservacao(observacao);
		dao.insert(p);
	}

	public List<Pedido> listarPedido() {
		return dao.recupera();
	}

	public void atualizarPedido(int idPedido, int numeroMesa, String observacao) {
		Pedido p = new Pedido();
		p.setIdPedido(idPedido);
		p.setNumeroMesa(numeroMesa);
		p.setObservacao(observacao);
		dao.update(p);
	}

	public void deletarPedido(int id) {
		dao.delete(id);
	}
	
}
