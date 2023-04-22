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
import model.entities.Hospede;
import model.entities.Reservas;
import model.entities.Usuario;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Usuario usuario) {
		try {
			
			String sql = "INSERT INTO  usuarios (login, senha) VALUES(?, ?)";
			
			try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, usuario.getLogin());
				pstmt.setString(2, usuario.getSenha());
				
				pstmt.executeUpdate();
				pstmt.close();
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuário existente!","Erro", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospede> find(String search) throws SQLException {
		List<Hospede> reservas = new ArrayList<Hospede>();
		
		List<Hospede> usuarios = new ArrayList<>();
	    String sql = "SELECT Id, Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, Id_Reserva "
	    		+ "FROM hotel_alura.usuarios WHERE Sobrenome LIKE '%"+search+"%' OR Id_Reserva LIKE '%"+search+"%';";
	     
		
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
	
	public String findPassByLogin(String usuario) throws SQLException {
		String sql = "SELECT senha FROM usuarios WHERE login = ?";
		String senha=null;
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			try {
				pstmt.setString(1, usuario);
				
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        senha = rst.getString("senha");
			    }
				pstmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return senha;
	}
	
	public String getUserId(String usuario) throws SQLException {
		String sql = "SELECT senha FROM usuarios WHERE login = ?";
		String senha=null;
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			try {
				pstmt.setString(1, usuario);
				
				ResultSet rst = pstmt.executeQuery();
				if (rst.next()) {
			        senha = rst.getString("senha");
			    }
				pstmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return senha;
	}
	
	
	public void update(Usuario usuario) throws SQLException {
		String sql = "UPDATE usuarios SET login = ?, senha = ? WHERE login = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setString(1, usuario.getLogin());
				pstmt.setString(2, usuario.getSenha());
				pstmt.setString(3, usuario.getCurrentLogin());
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void delete(Usuario usuario) throws SQLException {
		String sql = "DELETE FROM usuarios WHERE Id = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			try {
				pstmt.setLong(1, usuario.getId());
				 
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
