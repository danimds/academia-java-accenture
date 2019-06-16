package time5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import time5.entidades.Produto;

public class ProdutoDAO implements InterfaceCrudDAO<Produto> {

	private ConexaoJDBC conexaoJDBC;

	public ProdutoDAO() {
		this.conexaoJDBC = new ConexaoJDBC();
	}

	public void insert(Produto obj) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			// String sql = "INSERT INTO tb_produto (nomeProduto, preco, tipo, descricao) VALUES (idProduto.nextval,?,?,?,?)";
			// Deve inserir a coluna idProduto tambem no insert into
			String sql = "INSERT INTO tb_produto (idProduto, nomeProduto, preco, tipo, descricao) VALUES (idProduto.nextval,?,?,?,?)";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setString(1, obj.getNomeProduto());
			prepareStatement.setDouble(2, obj.getPreco());
			prepareStatement.setString(3, obj.getTipo());
			prepareStatement.setString(4, obj.getDescricao());

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

	public void update(Produto obj) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			// String sql = "UPDATE tb_produto SET nomeProduto = ?, preco = ?, tipo = ?, descricao = ? WHERE id = ?";
			// o nome correto da coluna é idProduto no where
			String sql = "UPDATE tb_produto SET nomeProduto = ?, preco = ?, tipo = ?, descricao = ? WHERE idProduto = ?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setString(1, obj.getNomeProduto());
			prepareStatement.setDouble(2, obj.getPreco());
			prepareStatement.setString(3, obj.getTipo());
			prepareStatement.setString(4, obj.getDescricao());
			prepareStatement.setInt(5, obj.getIdProduto());

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
			// String sql = "DELETE FROM tb_produto WHERE idProduto = " + id + "";
			String sql = "DELETE FROM tb_produto WHERE idProduto = ?"; // não precisa colocar o id já que usamos ? para o prepared
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

	public List<Produto> recupera() {
		// List<Produto> retorno = null; // dessa forma ele vai retornar null caso não encontrar nenhum produto no banco
		List<Produto> retorno = new ArrayList<Produto>(); // caso não recuperar nenhum produto da base, retornar uma lista vazia
		ResultSet resultSet = null;
		try {
			resultSet = this.query(null);
			if (resultSet.first()) {
				// retorno = new ArrayList<Produto>();
				do {
					Produto produto = new Produto();
					produto.setIdProduto(resultSet.getInt("idProduto"));
					produto.setNomeProduto(resultSet.getString("nomeProduto"));
					produto.setPreco(resultSet.getDouble("preco"));
					produto.setTipo(resultSet.getString("tipo"));
					produto.setDescricao(resultSet.getString("descricao"));
					retorno.add(produto);
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

	public Produto recupera(int id) {
		Produto produto = null;
		ResultSet resultSet = null;
		try {
			// resultSet = this.query(" WHERE id = " + id);
			resultSet = this.query(" WHERE idProduto = " + id); // o nome correto da coluna é idProduto

			if (resultSet.first()) {
				produto = new Produto();
				produto.setIdProduto(resultSet.getInt("idProduto"));
				produto.setNomeProduto(resultSet.getString("nomeProduto"));
				produto.setPreco(resultSet.getDouble("preco"));
				produto.setTipo(resultSet.getString("tipo"));
				produto.setDescricao(resultSet.getString("descricao"));
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

		return produto;
	}

	private ResultSet query(String filtro) {

		ResultSet resultSet = null;

		try {
			Connection conexao = this.conexaoJDBC.getConexao();
			String sql = "SELECT idProduto, nomeProduto, preco, tipo, descricao FROM tb_produto";
			Statement statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			if (filtro != null) {
				sql += filtro;
			}

			sql += " ORDER BY idProduto";

			resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultSet;
	}
}
