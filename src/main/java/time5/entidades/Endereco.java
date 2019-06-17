package time5.entidades;

public class Endereco {

	private String rua;
	private String numero;
	private String cep;
	private String estado;
	private String complemento;
	private String bairro;
	private String cidade;
	private String pontoReferencia;

	public Endereco() {
	}

	public Endereco(String rua, String numero, String cep, String estado, String complemento,
			String bairro, String cidade, String pontoReferencia) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.estado = estado;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.pontoReferencia = pontoReferencia;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
}
