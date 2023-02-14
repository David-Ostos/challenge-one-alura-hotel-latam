package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {


	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooled = new ComboPooledDataSource();
		comboPooled.setJdbcUrl("jdbc:mysql://localhost:3306/ALURA_HOTEL");
		comboPooled.setUser("root");
		comboPooled.setPassword("tupassword");		
		
		this.dataSource = comboPooled;
	}
	public Connection recuperarConnexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
