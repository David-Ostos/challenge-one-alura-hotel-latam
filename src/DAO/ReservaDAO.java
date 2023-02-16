package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Reserva;

public class ReservaDAO {

	private Connection connection;

	public ReservaDAO(Connection connection) {
		
		this.connection = connection;
				
	}
	
	public void guardar(Reserva reserva) {
		
		String sql = "INSERT INTO RESERVAS (FechaEntrada,FechaSalida,Valor,FormaPago)"
				+ "VALUES (?,?,?,?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, 
				Statement.RETURN_GENERATED_KEYS)) { 
			pstm.setDate(1, reserva.getFechaE());
			pstm.setDate(2, reserva.getFechaS());
			pstm.setString(3, reserva.getValor());
			pstm.setString(4, reserva.getFormaPago());
			
			pstm.executeUpdate();
			
			try(ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
			
		}
	}
	public List<Reserva> buscar(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT id, FechaEntrada ,FechaSalida,Valor,FormaPago FROM RESERVAS";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				try(ResultSet resultSet = pstm.executeQuery()){
						   while (resultSet.next()) {
		                        reservas.add(new Reserva(
		                                resultSet.getInt("id"),
		                                resultSet.getDate("FechaEntrada"),
		                                resultSet.getDate("FechaSalida"),
		                                resultSet.getString("Valor"),
		                                resultSet.getString("FormaPago")));                          
					}
				}
				
			}catch (SQLException e) {
			
				throw new RuntimeException(e);
			
			}
		}catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		return reservas;
				
	}

	public List<Reserva> listarReserva() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		String sql = " SELECT `id`,`FechaEntrada`,`FechaSalida`,`Valor`,"
				+ "`FormaPago`FROM `RESERVAS`";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			transformResultSEnHuesped(reservas, pstm);
			
		}catch (SQLException e) {
		
			throw new RuntimeException(e);
			
		}
		
		return reservas;
	}
	
		public List<Reserva> listarReservaId(String id) {
			List<Reserva> reservas = new ArrayList<Reserva>();
			
			String sql = " SELECT `id`,`FechaEntrada`,`FechaSalida`,`Valor`,"
					+ "`FormaPago`FROM `RESERVAS` WHERE id = ? ";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				
				pstm.setString(1, id);
				pstm.execute();
				
				transformResultSEnHuesped(reservas, pstm);
				
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		return reservas;
	}
		
		
	public void transformResultSEnHuesped(List<Reserva> reservas,
			PreparedStatement pstm) {
		try(ResultSet rst = pstm.getResultSet()){
			while (rst.next()) {
				Reserva reserva = new Reserva(rst.getInt(1),
						rst.getDate(2),rst.getDate(3),rst.getString(4),
						rst.getString(5));
				
				reservas.add(reserva);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		
		String sql = "UPDATE RESERVAS SET FechaEntrada = ? ,FechaSalida = ? , Valor = ? , FormaPago = ? WHERE id = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			
			stm.setDate(1, fechaE);
			stm.setDate(2, fechaS);
			stm.setString(3, valor);
			stm.setString(4, formaPago);
			stm.setInt(5, id);
			
			stm.execute();
		} catch (SQLException e) {

			throw new RuntimeException(e);
			
		}
		
	}


	
}


























