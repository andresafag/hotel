package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CheckReservations {
	

	public HashMap<String, ArrayList<String>>  CheckReservations() {
		// TODO Auto-generated constructor stub
		HashMap<String, ArrayList<String>>  rawMap = new HashMap<>();
	       ArrayList<String> reservas =  new ArrayList<>();
	       ArrayList<String> checkin=  new ArrayList<>();
	       ArrayList<String>  checkout =  new ArrayList<>();
	       ArrayList<String> price =  new ArrayList<>();
	       ArrayList<String> paymentMethod =  new ArrayList<>();
	       
	       
			Connection conn =  new mySqlConn().connectDB();
			try (conn){
				conn.setAutoCommit(false);
				Statement statement = conn.createStatement();
				ResultSet  resultSet = statement.executeQuery("SELECT * FROM reservas");
				
				while (resultSet.next()) {
					reservas.add(resultSet.getString("numerodereserva"));
					checkin.add(resultSet.getString("checkInDate"));
					checkout.add(resultSet.getString("checkOutDate"));
					price.add(resultSet.getString("price"));
					paymentMethod.add(resultSet.getString("paymentMethod"));
				}
				rawMap.put("numero",reservas);
				rawMap.put("checkin", checkin);
				rawMap.put("checkout", checkout);
				rawMap.put("valor", price);
				rawMap.put("pago", paymentMethod);
				conn.commit();
				resultSet.close();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		return rawMap;
	}

	
}
