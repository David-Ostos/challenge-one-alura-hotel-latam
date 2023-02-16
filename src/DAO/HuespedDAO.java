package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Huesped;

public class HuespedDAO {
	
	private Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huesped huesped) {
		
		try {
		
			String sql = "INSERT INTO HUESPEDES (Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono, idReserva) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			try( PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS )){
				
				pstm.setString(1, huesped.getNombre());
				pstm.setString(2, huesped.getApellido());
				pstm.setDate(3, huesped.getFechaNacimineto());
				pstm.setString(4, huesped.getNacionalidad());
				pstm.setString(5, huesped.getTelefono());
				pstm.setInt(6, huesped.getIdReserva());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()) {
					while(rst.next()) {
						huesped.setId(rst.getInt(1));
					}
					
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huesped> listarHuespedes() {
		
		List<Huesped> huespedes = new ArrayList<Huesped>();
		
		String sql = "SELECT id,Nombre, Apellido, FechaNacimiento, "
				+ "Nacionalidad, Telefono,idReserva FROM HUESPEDES" ;
		
		try(PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.execute();
			
			transformResultSEnHuesped(huespedes, pstm);
			
		}catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return huespedes;
	}



	public List<Huesped> listarHuespedesId(String id) {
		
		List<Huesped> huespedes = new ArrayList<Huesped>();
		
		String sql = "SELECT id,Nombre, Apellido, FechaNacimiento, "
				+ "Nacionalidad, Telefono,idReserva FROM HUESPEDES "
				+ "WHERE idReserva = ? OR Apellido = ? " ;
		
		try(PreparedStatement pstm = con.prepareStatement(sql)){
			pstm.setString(1, id);
			pstm.setString(2,id);
			pstm.execute();
			
			transformResultSEnHuesped(huespedes, pstm);
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return huespedes;
	}	
	
	
	public void transformResultSEnHuesped(List<Huesped> reservas,
			PreparedStatement pstm) {
		try(ResultSet rst = pstm.getResultSet()){
			while (rst.next()) {
				Huesped huesped = new Huesped(rst.getInt(1),
						rst.getString(2),rst.getString(3),rst.getDate(4),
						rst.getString(5),rst.getString(6),rst.getInt(7));
				
				reservas.add(huesped);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String tlf,
			Integer idReferencia, Integer id) {

		String sql = "UPDATE HUESPEDES SET Nombre = ?, Apellido = ?, FechaNacimiento =?,Nacionalidad =?, Telefono = ? , idReserva = ? where id = ?";
		
		try(PreparedStatement stm = con.prepareStatement(sql)) {
			
			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setDate(3, fechaN);
			stm.setString(4, nacionalidad);
			stm.setString(5, tlf);
			stm.setInt(6, idReferencia);
			stm.setInt(7, id);
			
			stm.execute();
			
			
		} catch (SQLException e) {

			throw new RuntimeException(e);
			
		}
		
	}
	
}




