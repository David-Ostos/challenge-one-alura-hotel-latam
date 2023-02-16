package Controller;

import java.sql.Connection;
import java.util.List;

import DAO.UsuarioDAO;
import Factory.ConnectionFactory;
import Model.Usuarios;

public class UsuarioController {

	private UsuarioDAO usuarioDao;
	
	public UsuarioController() {
		Connection connection = new ConnectionFactory().recuperarConnexion();
		try {
			this.usuarioDao = new UsuarioDAO(connection);
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public List<Usuarios> verificacion() {
		System.out.println(verificacion());
		return usuarioDao.verificacion();
	}
	
}

