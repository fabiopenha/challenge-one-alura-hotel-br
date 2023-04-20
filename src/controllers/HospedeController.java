package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.ConnectionFactory;
import model.Hospede;
import model.DAO.HospedeDAO;
import model.DAO.ReservasDAO;
import model.entities.Reservas;

public class HospedeController {
	
	private HospedeDAO hospedeDAO;
	
	public HospedeController() throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.hospedeDAO = new HospedeDAO(connection);
	}
	
	public void salvar(Hospede hospede) {
		this.hospedeDAO.insert(hospede);
	}
	
	public List<Hospede> find(String search) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		return (List<Hospede>) this.hospedeDAO.find(search);
	}
	
	public void update(Hospede hospede) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.hospedeDAO.update(hospede);
	}
	
	public void delete(Hospede hospede) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.hospedeDAO.delete(hospede);
	}
}
