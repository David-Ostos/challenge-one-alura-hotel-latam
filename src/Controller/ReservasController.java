package Controller;

import java.sql.Connection;

import DAO.ReservaDAO;
import Factory.ConnectionFactory;
import Model.Reserva;

public class ReservasController {
	
	private ReservaDAO reservaDao;
	
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConnexion();
		this.reservaDao = new ReservaDAO(connection);
	}
	
	public void guardar(Reserva reserva) {
		this.reservaDao.guardar(reserva);
	}

}
