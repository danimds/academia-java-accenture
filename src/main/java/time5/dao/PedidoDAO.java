package time5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import time5.entidades.Pedido;
import time5.entidades.Pedido.PedidoStatus;

public class PedidoDAO implements InterfaceCrudDAO<Pedido> {

	private ConexaoJDBC conexaoJDBC;

	public PedidoDAO() {
		this.conexaoJDBC = new ConexaoJDBC();
	}

	public void insert(Pedido obj) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			String sql = "INSERT INTO tb_pedido (idPedido, numeroMesa, status, observacao) VALUES (idPedido.nextval, ?, ?, ?)";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setInt(1, obj.getNumeroMesa());
			prepareStatement.setString(2, obj.getStatus().name());
			prepareStatement.setString(3, obj.getObservacao());

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

	public void update(Pedido obj) {
		Connection conexao = null;
		try {
			conexao = this.conexaoJDBC.getConexao();
			String sql = "UPDATE tb_pedido SET numeroMesa = ?, status = ?, observacao = ? WHERE idPedido = ?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);

			prepareStatement.setInt(1, obj.getNumeroMesa());
			prepareStatement.setString(2, obj.getStatus().name());
			prepareStatement.setString(3, obj.getObservacao());
			prepareStatement.setInt(4, obj.getIdPedido());

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
			String sql = "DELETE FROM tb_pedido WHERE idPedido =  ?";
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

	public List<Pedido> recupera() {
		List<Pedido> retorno = new ArrayList<Pedido>();
		ResultSet resultSet = null;
		try {
			resultSet = this.query(null);
			if (resultSet.first()) {
				do {
					Pedido pedido = new Pedido();
					pedido.setIdPedido(resultSet.getInt("idPedido"));
					pedido.setNumeroMesa(resultSet.getInt("numeroMesa"));
					pedido.setStatus(PedidoStatus.valueOf(resultSet.getString("status")));
					pedido.setObservacao(resultSet.getString("observacao"));
					retorno.add(pedido);
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

	public Pedido recupera(int id) {
		Pedido pedido = null;
		ResultSet resultSet = null;
		try {
			resultSet = this.query(" WHERE idPedido = " + id);

			if (resultSet.first()) {
				pedido = new Pedido();
				pedido.setIdPedido(resultSet.getInt("idPedido"));
				pedido.setNumeroMesa(resultSet.getInt("numeroMesa"));
				pedido.setStatus(PedidoStatus.valueOf(resultSet.getString("status")));
				pedido.setObservacao(resultSet.getString("observacao"));

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

		return pedido;
	}

	private ResultSet query(String filtro) {
		ResultSet resultSet = null;

		try {
			Connection conexao = this.conexaoJDBC.getConexao();
			String sql = "SELECT idPedido, numeroMesa, status, observacao FROM tb_pedido";
			Statement statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			if (filtro != null) {
				sql += filtro;
			}

			sql += " ORDER BY idPedido";

			return resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultSet;
	}
}
