package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.Hospede;
import model.entities.Reservas;

public class HospedeDAO {
	private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Hospede hospede) {
		try {
			
			String sql = "INSERT INTO  hospedes (Nome, Sobrenome,DataNascimento, Nacionalidade, Telefone, Id_Reserva) VALUES(?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, hospede.getNome());
				pstmt.setString(2, hospede.getSobrenome());
				pstmt.setDate(3, hospede.getDataNascimento());
				pstmt.setString(4, hospede.getNacionalidade());
				pstmt.setString(5, hospede.getTelefone());
				pstmt.setLong(6, hospede.getReservaId());
				
				pstmt.executeUpdate();
				pstmt.close();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospede> find(String search) throws SQLException {
		List<Hospede> reservas = new ArrayList<Hospede>();
		
		List<Hospede> hospedes = new ArrayList<>();
	    String sql = "SELECT Id, Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, Id_Reserva "
	    		+ "FROM hotel_alura.hospedes WHERE Sobrenome LIKE '%"+search+"%' OR Id_Reserva LIKE '%"+search+"%';";
	     
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.execute();
			
			try(ResultSet rst = pstmt.getResultSet()) {
				while(rst.next()) {
					Hospede reserva = 
							new Hospede(rst.getLong(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6),rst.getLong(7) );
					
					reservas.add(reserva);
				}
			}
			pstmt.close();
		}
		return reservas;
	}
	
	
	public void update(Hospede hospede) throws SQLException {
		String sql = "UPDATE hospedes SET Id = ?, Nome = ?, Sobrenome = ?, DataNascimento = ?, Nacionalidade = ?, Telefone = ?, Id_Reserva = ? WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, hospede.getId());
				pstmt.setString(2, hospede.getNome());
				pstmt.setString(3, hospede.getSobrenome());
				pstmt.setDate(4, hospede.getDataNascimento());
				pstmt.setString(5, hospede.getNacionalidade());
				pstmt.setString(6, hospede.getTelefone());
				pstmt.setLong(7, hospede.getReservaId());
				pstmt.setLong(8, hospede.getId());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void delete(Hospede hospede) throws SQLException {
		String sql = "DELETE FROM hospedes WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, hospede.getId());
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
