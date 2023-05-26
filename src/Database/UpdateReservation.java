package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class UpdateReservation {
	
	public boolean  UpdateReservation(long reservNumber, Date checkIn, Date checkOut, double price, String payMethod) {
		
		boolean  passed = false;
		Connection conn =  new mySqlConn().connectDB();
		ResultSet  resultSet = null;
		try (conn){
			conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery("select numerodereserva from reservas where numerodereserva='"+reservNumber+"'");
				try (PreparedStatement pstmt = conn.prepareStatement("UPDATE reservas SET checkInDate=? , checkOutDate =?, price=?, paymentMethod= ? where numerodereserva = ?");){
					if (resultSet.next() == true) {
						 pstmt.setDate(1, checkIn); 
						 pstmt.setDate(2, checkOut);
						 pstmt.setDouble(3, price);
						 pstmt.setString(4, payMethod);
						 pstmt.setLong(5, reservNumber);
						 passed = pstmt.executeUpdate() > 0 ? true : false;
						 if (passed) {
							 conn.commit();
						} else {
							conn.rollback();
						}
						
						 
						} 
						resultSet.close();
				} catch (Exception e) {
					throw new RuntimeException();
				}

	        
		} catch (SQLException ex) {
			throw new RuntimeException();
		}
		
		
		return passed;
	}
	
	
}
