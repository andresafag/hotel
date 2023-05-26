package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class GetSingleReservation {
	
	
	public ArrayList<String> GetSingleReservation(String valReserv) {
		ArrayList<String> resBusqReservas =  new ArrayList<>();
		Connection conn =  new mySqlConn().connectDB();
		
	       try (conn){
	    		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM reservas WHERE numerodereserva=?");){
	    			
	    			pstmt.setLong(1, Long.parseLong(valReserv)); 
	    			try (ResultSet resultSet = pstmt.executeQuery();){
	    				
	    				while (resultSet.next()) {
	    					resBusqReservas.add(resultSet.getString(6));
	    					resBusqReservas.add(resultSet.getString(2));
	    					resBusqReservas.add(resultSet.getString(3));
	    					resBusqReservas.add(resultSet.getString(4));
	    					resBusqReservas.add(resultSet.getString(5));
	    					resBusqReservas.add(resultSet.getString(1));
	    				}
					} catch (Exception e) {
						throw new RuntimeException();
					}
	    			
				} catch (Exception e) {
					throw new RuntimeException();
				}
				
			} catch (SQLException ex) {
				throw new RuntimeException();
			}
		
		return resBusqReservas;
	}
	
}
