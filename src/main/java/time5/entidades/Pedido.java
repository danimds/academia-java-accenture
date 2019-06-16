package time5.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	public enum PedidoStatus {
		ANDAMENTO, FINALIZADO
	}

	private int idPedido;
	private int numeroMesa;
	private List<Produto> listProduto;
	private PedidoStatus status;
	private String observacao;

	public Pedido() {
		this.status = PedidoStatus.ANDAMENTO;
		this.listProduto = new ArrayList<Produto>();
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
