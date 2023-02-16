package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Usuarios;


public class UsuarioDAO {

	private Connection con;
	
	public UsuarioDAO(Connection con) {
		
		this.con = con;
	}
	
	public List<Usuarios> verificacion() {
		
		List<Usuarios> resultado = new ArrayList<>();
		
		String sql = "SELECT Usuario,Password from USUARIOS";
		try {
			
			try(PreparedStatement statement = con.prepareStatement(sql)){
				statement.execute();
				
				try(ResultSet resultSet = statement.getResultSet()){
					while (resultSet.next()) {
						resultado.add(new Usuarios(
								resultSet.getString("Usuario"),
								resultSet.getString("Password")));		
					}
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return resultado;
	}

	public static void main(String[] args) {
		
		
		
	}
}

