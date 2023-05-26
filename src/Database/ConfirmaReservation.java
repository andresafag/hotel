package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfirmaReservation {
	public  boolean confirmReservation(long numerodereserva) {
		 boolean binded =false ; 
	 	   try {  
	 		 Connection conn =  new mySqlConn().connectDB();
	 		 ResultSet rs = null;
			 PreparedStatement statement = conn.prepareStatement("SELECT * FROM reservas WHERE numerodereserva=?");
			 statement.setLong(1, numerodereserva);
			 rs = statement.executeQuery();
			 binded = rs.next();
			 
			 rs.close();
	 	     conn.close();
		} catch (SQLException ex) {
			throw new RuntimeException();
			}
		
		 
	 return binded;
 
	 
}
	 
}
