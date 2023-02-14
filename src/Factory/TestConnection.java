package Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();	
		final Connection connection = connectionFactory.recuperarConnexion();
		
		
		
		try(connection){
			System.out.println("porbando conexion");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			System.out.println("conexion cerrada");
		}
				
			
	}
}
