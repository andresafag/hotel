package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyUsers {
	
	 public boolean verifyUsers(String usr, String psw){
		 boolean doesExist = false;
			Connection conn =  new mySqlConn().connectDB();
			try (conn){
				try(PreparedStatement statement = conn.prepareStatement("SELECT username FROM employees where username=? AND password=?");) {
					statement.setString(1, usr);
					statement.setString(2, psw);
					try (ResultSet rs = statement.executeQuery();){
						doesExist =  rs.next();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		
			
		 return doesExist;
			
	}
	
	
	


}
