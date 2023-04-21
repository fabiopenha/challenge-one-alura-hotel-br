package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.ConnectionFactory;
import model.DAO.HospedeDAO;
import model.DAO.ReservasDAO;
import model.DAO.UsuarioDAO;
import model.entities.Hospede;
import model.entities.Reservas;
import model.entities.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.usuarioDAO = new UsuarioDAO(connection);
	}
	
	public void salvar(Usuario usuario) {
		this.usuarioDAO.insert(usuario);
	}
	
	public List<Hospede> find(String search) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		return (List<Hospede>) this.usuarioDAO.find(search);
	}
	
	public String findSenhaByLogin(String usuario) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		return this.usuarioDAO.findPassByLogin(usuario);
	}
	
	public void update(Usuario usuario) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.usuarioDAO.update(usuario);
	}
	
	public void delete(Usuario usuario) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.usuarioDAO.delete(usuario);
	}
}
