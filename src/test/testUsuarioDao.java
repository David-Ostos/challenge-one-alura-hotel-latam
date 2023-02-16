package test;

import java.util.ArrayList;
import java.util.List;

import Controller.UsuarioController;
import Factory.ConnectionFactory;
import Model.Usuarios;

public class testUsuarioDao {
	
	private static UsuarioController usuarioController;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		 
		List<Usuarios> usuario = new ArrayList<>();
		try {
			var user = usuarioController.verificacion();
			user.forEach(usuarios -> {
				System.out.println(usuarios.getUsuario().toString());
			});
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
