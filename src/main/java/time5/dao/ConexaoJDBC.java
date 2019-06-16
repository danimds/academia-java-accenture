package time5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

	public Connection getConexao() throws SQLException {
		String urlConexao = "jdbc:oracle:thin:@//localhost:1521/xe";
		String usuario = "system";
		String senha = "123";
		Connection conexao = DriverManager.getConnection(urlConexao, usuario, senha);
		return conexao;
	}

}
