package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
				pstmt.close();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reservas> find() throws SQLException {
		List<Reservas> reservas = new ArrayList<Reservas>();
		
		String sql = "SELECT Id, DataEntrada, DataSaida, Valor, FormaPagamento FROM reservas";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.execute();
			
			try(ResultSet rst = pstmt.getResultSet()) {
				while(rst.next()) {
					Reservas reserva = 
							new Reservas(rst.getLong(1),rst.getDate(2) , rst.getDate(3), rst.getString(4), rst.getString(5));
					
					reservas.add(reserva);
				}
			}
			pstmt.close();
		}
		return reservas;
	}
	
	public void update(Reservas reserva) throws SQLException {
		String sql = "UPDATE reservas SET Id = ?, DataEntrada = ?, DataSaida = ?, Valor = ?, FormaPagamento = ? WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, reserva.getId());
				pstmt.setDate(2, reserva.getDiaChegada());
				pstmt.setDate(3, reserva.getDiaSaida());
				pstmt.setString(4, reserva.getValor());
				pstmt.setString(5, reserva.getFormaPagamento());
				pstmt.setLong(6, reserva.getId());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void delete(Reservas reserva) throws SQLException {
		String sql = "DELETE FROM reservas WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, reserva.getId());
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Não é permitido deletar a reserva de um hóspede existente!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}
	}
	
	public void deleteById(Long id) throws SQLException {
		String sql = "DELETE FROM reservas WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, id);
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Não é permitido deletar a reserva de um hóspede existente!","Erro", JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}
	}
	
}
