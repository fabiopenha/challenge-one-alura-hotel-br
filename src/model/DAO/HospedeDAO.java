package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
