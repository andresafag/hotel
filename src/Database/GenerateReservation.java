package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import Model.ReservationModel;


public class GenerateReservation{
		
	public void generateReservation(Date checkin,  Date checkout, double price, String paymethod, long resNumber){
			Connection conn =  new mySqlConn().connectDB();
			try (conn){
				conn.setAutoCommit(false);
				PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO reservas (idReserv,checkInDate,checkOutDate, price, paymentMethod, numerodereserva) values (null,?,?,?,?,?)");
				preparedStmt.setDate(1, checkin);
				preparedStmt.setDate(2, checkout);
				preparedStmt.setDouble(3, price);
				preparedStmt.setString(4, paymethod);
				preparedStmt.setLong(5, resNumber);
				try (preparedStmt){
					if (preparedStmt.executeUpdate() > 0) {
						conn.commit();
						System.out.println(preparedStmt.executeUpdate());
					}
				} catch (Exception e) {
					// TODO: handle exception
					conn.rollback();
				}
				
			} catch (Exception e) {
				throw new RuntimeException();
				
			}

		
	}
		
	
}


