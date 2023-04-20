package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.ConnectionFactory;
import model.DAO.ReservasDAO;
import model.entities.Reservas;

public class ReservasController {
	
	private ReservasDAO reservasDAO;
	
	
	public ReservasController() throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.reservasDAO = new ReservasDAO(connection);
	}
	
	public void salvar(Reservas reserva) {
		this.reservasDAO.insert(reserva);
	}
	
	public List<Reservas> find() throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		return (List<Reservas>) this.reservasDAO.find();
	}
	
	public void update(Reservas reserva) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.reservasDAO.update(reserva);
	}
	
	public void delete(Reservas reserva) throws SQLException, IOException {
		Connection connection = new ConnectionFactory().getConecction();
		this.reservasDAO.delete(reserva);
	}
}
