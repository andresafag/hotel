package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HostReservDeletion {
	
	public boolean hostReservDeletion(long reservNumber){
		   boolean deleted =  false;
	     
			Connection conn =  new mySqlConn().connectDB();
			
			try (conn){
				conn.setAutoCommit(false);
				try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM reservas WHERE numerodereserva=?");){
					pstmt.setLong(1, reservNumber);
					deleted = pstmt.executeUpdate() > 0 ? true :  false;
					if (deleted == true) {
						conn.commit();
					}
				} catch (Exception e) {
					conn.rollback();
				}
			} catch (Exception e) {
				throw new RuntimeException();
			} 
		
		return deleted;
	}
}
