package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
	
//	public List<Reservas> find() {
//		//this.reservasDAO.find(reserva);
//	}
}
