package time5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import time5.entidades.Endereco;
import time5.entidades.Funcionario;

public class FuncionadoDAO implements InterfaceCrudDAO<Funcionario> {

	private ConexaoJDBC conexaoJDBC;

	public FuncionadoDAO() {
		this.conexaoJDBC = new ConexaoJDBC();
	}

	public void insert(Funcionario obj) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			String sql = "INSERT INTO tb_funcionario (id,nome,cpf,telefone,cargo,salario,dataNascimento,rua,numero,cep,estado,complemento,bairro,cidade,pontoReferencia) "
					+ "VALUES (idFuncionario.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setString(1, obj.getNome());
			prepareStatement.setString(2, obj.getCpf());
			prepareStatement.setString(3, obj.getTelefone());
			prepareStatement.setString(4, obj.getCargo());
			prepareStatement.setDouble(5, obj.getSalario());
			prepareStatement.setString(6, obj.getDataNascimento());
			prepareStatement.setString(7, obj.getEndereco().getRua());
			prepareStatement.setString(8, obj.getEndereco().getNumero());
			prepareStatement.setString(9, obj.getEndereco().getCep());
			prepareStatement.setString(10, obj.getEndereco().getEstado());
			prepareStatement.setString(11, obj.getEndereco().getComplemento());
			prepareStatement.setString(12, obj.getEndereco().getBairro());
			prepareStatement.setString(13, obj.getEndereco().getCidade());
			prepareStatement.setString(14, obj.getEndereco().getPontoReferencia());

			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Funcionario obj) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			String sql = "UPDATE tb_funcionario SET nome = ?, cpf = ?, telefone = ?, cargo = ?, salario = ?, dataNascimento = ? , "
					+ "rua= ?, numero= ?, cep= ?, estado= ?, complemento= ?, bairro= ?, cidade= ?, pontoReferencia = ? "
					+ "WHERE id = ?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setString(1, obj.getNome());
			prepareStatement.setString(2, obj.getCpf());
			prepareStatement.setString(3, obj.getTelefone());
			prepareStatement.setString(4, obj.getCargo());
			prepareStatement.setDouble(5, obj.getSalario());
			prepareStatement.setString(6, obj.getDataNascimento());
			prepareStatement.setString(7, obj.getEndereco().getRua());
			prepareStatement.setString(8, obj.getEndereco().getNumero());
			prepareStatement.setString(9, obj.getEndereco().getCep());
			prepareStatement.setString(10, obj.getEndereco().getEstado());
			prepareStatement.setString(11, obj.getEndereco().getComplemento());
			prepareStatement.setString(12, obj.getEndereco().getBairro());
			prepareStatement.setString(13, obj.getEndereco().getCidade());
			prepareStatement.setString(14, obj.getEndereco().getPontoReferencia());
			prepareStatement.setInt(15, obj.getId());

			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int id) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			String sql = "DELETE FROM tb_funcionario WHERE id = ?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setInt(1, id);

			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Funcionario> recupera() {
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		ResultSet resultSet = null;
		try {
			resultSet = this.query(null);
			if (resultSet.first()) {
				do {
					Funcionario funcionario = new Funcionario();
					funcionario.setId(resultSet.getInt("id"));
					funcionario.setNome(resultSet.getString("nome"));
					funcionario.setCpf(resultSet.getString("cpf"));
					funcionario.setTelefone(resultSet.getString("telefone"));
					funcionario.setCargo(resultSet.getString("cargo"));
					funcionario.setSalario(resultSet.getDouble("salario"));
					funcionario.setDataNascimento(resultSet.getString("dataNascimento"));

					Endereco endereco = new Endereco();
					endereco.setRua(resultSet.getString("rua"));
					endereco.setNumero(resultSet.getString("numero"));
					endereco.setCep(resultSet.getString("cep"));
					endereco.setEstado(resultSet.getString("estado"));
					endereco.setComplemento(resultSet.getString("complemento"));
					endereco.setBairro(resultSet.getString("bairro"));
					endereco.setCidade(resultSet.getString("cidade"));
					endereco.setPontoReferencia(resultSet.getString("pontoReferencia"));

					funcionario.setEndereco(endereco);

					retorno.add(funcionario);
				} while (resultSet.next());
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	public Funcionario recupera(int id) {
		Funcionario funcionario = null;
		ResultSet resultSet = null;
		try {
			resultSet = this.query(" WHERE id = " + id);

			if (resultSet.first()) {
				funcionario = new Funcionario();
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setTelefone(resultSet.getString("telefone"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setSalario(resultSet.getDouble("salario"));
				funcionario.setDataNascimento(resultSet.getString("dataNascimento"));

				Endereco endereco = new Endereco();
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getString("numero"));
				endereco.setCep(resultSet.getString("cep"));
				endereco.setEstado(resultSet.getString("estado"));
				endereco.setComplemento(resultSet.getString("complemento"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setPontoReferencia(resultSet.getString("pontoReferencia"));

				funcionario.setEndereco(endereco);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return funcionario;
	}

	private ResultSet query(String filtro) {
		ResultSet resultSet = null;

		try {
			Connection conexao = this.conexaoJDBC.getConexao();
			String sql = "SELECT id,nome,cpf,telefone,cargo,salario,dataNascimento,rua,numero,cep,estado,complemento,bairro,cidade,pontoReferencia FROM tb_funcionario";
			Statement statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			if (filtro != null) {
				sql += filtro;
			}

			sql += " ORDER BY id";

			return resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
