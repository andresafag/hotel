package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDeletion {
	public boolean dataDeletion(long reservNumber) {
		boolean  deleted = false;
		ResultSet  resultSet = null;
		Connection conn =  new mySqlConn().connectDB();

	       try (conn){
				 conn.setAutoCommit(false);
				 Statement statement = conn.createStatement();
				 resultSet = statement.executeQuery("SELECT  numerodereserva FROM reservas WHERE numerodereserva='"+reservNumber+"'");
				 
				 if (resultSet.next() == true) {
					 
					 PreparedStatement pstmt = conn.prepareStatement("DELETE FROM reservas WHERE numerodereserva=?");
					 pstmt.setLong(1, reservNumber); 
					 deleted = pstmt.executeUpdate() > 0 ?  true : false;
					 conn.commit();
				} 
				 resultSet.close();
		         statement.close();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		 
		
		
		return deleted;
	}
	
	}

