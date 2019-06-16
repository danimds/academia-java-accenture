package time5.entidades;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private double preco;
	private String tipo;
	private String descricao;

	public Produto() {
	}

	public Produto(int idProduto, String nomeProduto, double preco, String tipo, String descricao) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
