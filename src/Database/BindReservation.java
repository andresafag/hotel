package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BindReservation {
	
	
	 public boolean bindreservation(String nombre, String apellido, Date fecha, String nacionalidad, long telefono, long reserva) {
		 boolean successMessage = false;
		 Connection conn =  new mySqlConn().connectDB();
		 ResultSet  resultSet = null;
		 
		 try (conn){
			 conn.setAutoCommit(false);
			 Statement statement = conn.createStatement();
			 resultSet = statement.executeQuery("SELECT idUser FROM huespedes WHERE name='"+nombre+"' and lastName='"+apellido+"'");
			 // If it exists we  look for the reservation number and then bind the old cx{s id to the reservation id
			 if (resultSet.next() == true) {
				 System.out.println("existe el usuario entonces se extrae el id y se bindea con la reserva" + resultSet.getString("idUser"));
				 PreparedStatement pstmt = conn.prepareStatement("UPDATE reservas SET  idReserv = ? WHERE numerodereserva = ?");
				 pstmt.setInt(1, Integer.parseInt(resultSet.getString("idUser"))); 
				 pstmt.setLong(2, reserva);
				 successMessage = pstmt.executeUpdate() > 0 ?  true : false;
				 resultSet.close();
				 conn.commit();
				 
			}  else if(resultSet.next() == false) {
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO huespedes (name,lastName, birthDate, nacionality,phoneNumber)  VALUES  (?, ?, ?, ?, ?)");
				 pstmt.setString(1, nombre);
				 pstmt.setString(2, apellido);
				 pstmt.setDate(3, fecha);
				 pstmt.setString(4, nacionalidad);
				 pstmt.setLong(5, telefono);
				 pstmt.executeUpdate();
				 resultSet = statement.executeQuery("select idUser from huespedes where name='"+nombre+"'");
				 while (resultSet.next()) {
					 System.out.println(resultSet.getString(1));
					 PreparedStatement pstmt2 = conn.prepareStatement("update reservas set idReserv = ? where numerodereserva = ?");
					 pstmt2.setInt(1, Integer.parseInt(resultSet.getString(1))); 
					 pstmt2.setLong(2, reserva);
					 successMessage = pstmt2.executeUpdate() > 0 ?  true :false ;
				}
				 resultSet.close();
				 conn.commit();
				 
			} else {
				conn.rollback();
			}
		 } catch (Exception e) {
			// TODO: handle exception
			 throw new RuntimeException();
		} 
			 
		 return successMessage;
	 }
	 
	 
	 }


