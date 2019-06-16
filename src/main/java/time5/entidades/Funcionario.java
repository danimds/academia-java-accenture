package time5.entidades;

import java.sql.Date;

public class Funcionario extends Pessoa {

	private String cargo;
	private double salario;
	private Date dataNascimento;
	private Endereco endereco;

	public Funcionario() {
	}

	public Funcionario(int id, String nome, String cpf, String telefone, String cargo,
			double salario,Date dataNascimento, Endereco endereco) {
		super(id, nome, cpf, telefone);
		this.cargo = cargo;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
