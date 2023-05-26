package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UpdateHost {

	public boolean updateHost (int hostId, String name, String lastName, Date birthDate, String nacionality, long phone, long reservNumber) {
		   boolean updated =  false;
		
	       try {
			@SuppressWarnings("unused")
			Connection conn =  new mySqlConn().connectDB();
			conn.setAutoCommit(false);
				try (PreparedStatement pstmt = conn.prepareStatement("UPDATE huespedes SET name=?, lastName=?, birthDate=?, nacionality=?, phoneNumber=? WHERE idUser=?");){
					pstmt.setString(1, name);
					pstmt.setString(2, lastName);
					pstmt.setDate(3, birthDate);
					pstmt.setString(4, nacionality);
					pstmt.setLong(5, phone);
					pstmt.setInt(6, hostId);
					updated = pstmt.executeUpdate() > 0 ? true : false;
					if (updated) {
						conn.commit();
					} else {
						conn.rollback();
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			} catch (SQLException ex) {
				throw new RuntimeException();
			}
		
		return updated;
	}
}
