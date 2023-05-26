package Database;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import io.github.cdimascio.dotenv.Dotenv;

public class mySqlConn{  
	private DataSource datasource;
	private Dotenv dotenv;
	
	public mySqlConn() {
		dotenv = Dotenv.load();
		ComboPooledDataSource Pool = new ComboPooledDataSource();
		Pool.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura?");
		Pool.setUser(dotenv.get("USER"));
		Pool.setPassword(dotenv.get("PASSWORD"));
		Pool.setMaxPoolSize(10);
		this.datasource = Pool;
	}
	

	public Connection connectDB() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		} 
		
	}

	
	
}

	 






















