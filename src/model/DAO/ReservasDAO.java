package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ConnectionFactory;
import model.entities.Reservas;

public class ReservasDAO {
	private Connection connection;
	
	public ReservasDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Reservas reserva) {
		try {
			
			String sql = "INSERT INTO  reservas (DataEntrada, DataSaida,Valor, FormaPagamento) VALUES(?, ?, ?, ?)";
			
			try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setDate(1, reserva.getDiaChegada());
				pstmt.setDate(2, reserva.getDiaSaida());
				pstmt.setString(3, reserva.getValor());
				pstmt.setString(4, reserva.getFormaPagamento());
				
				pstmt.executeUpdate();
				
				try (ResultSet rst = pstmt.getGeneratedKeys()) {
					while(rst.next()) {
						reserva.setId(rst.getLong(1));
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
