package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

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

	public List<Reserva> listarReserva() {
		return  this.reservaDao.listarReserva(); 
		
	}

	public List<Reserva> listarReservaId(String id) {
		return  this.reservaDao.listarReservaId(id); 
	}

	public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.reservaDao.Actualizar(fechaE,fechaS,valor,formaPago,id);
		
	}

}
