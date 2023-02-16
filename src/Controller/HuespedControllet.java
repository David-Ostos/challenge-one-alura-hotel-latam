package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.HuespedDAO;
import Factory.ConnectionFactory;
import Model.Huesped;

public class HuespedControllet {

	private Connection con;
	private HuespedDAO huespedDao; 
	
	public HuespedControllet() {
		
		Connection con = new ConnectionFactory().recuperarConnexion();
		this.huespedDao = new HuespedDAO(con);
		
	}
	
	public void guardar(Huesped huesped) {
		this.huespedDao.guardar(huesped);
	}
	
	public List<Huesped> listarHuespedes(){
		return this.huespedDao.listarHuespedes(); 
	}

	public List<Huesped> listarHuespedesId(String id) {
		return this.huespedDao.listarHuespedesId(id);
	}

	public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String tlf,
			Integer idReferencia, Integer id) {
		this.huespedDao.Actualizar(nombre,apellido,fechaN,nacionalidad,tlf,idReferencia,id);
		
	}

	
	
}
