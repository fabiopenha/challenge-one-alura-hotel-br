package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException, IOException {
//		final String url = "jdbc:mysql://localhost:3306/hotel_alura";
//		final String user = "root";
//		final String password = "root";
//		
//		Connection conexao = DriverManager.getConnection(url, user, password);
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conexao = connectionFactory.getConecction();
		
		System.out.println("Conexao efetuada com sucesso morô");
		conexao.close();
	}
}
