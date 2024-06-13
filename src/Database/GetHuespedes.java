package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GetHuespedes {
	
	public HashMap<String, ArrayList<String>> getHuespedes (String host) {
	
				HashMap<String, ArrayList<String>>  guestsItemsMap = new HashMap<>();
				   ArrayList<String> idUser =  new ArrayList<>();
			       ArrayList<String> numeroReserva =  new ArrayList<>();
			       ArrayList<String> name=  new ArrayList<>();
			       ArrayList<String>  lastName =  new ArrayList<>();
			       ArrayList<String> birthDate =  new ArrayList<>();
			       ArrayList<String> nacionality =  new ArrayList<>();
			       ArrayList<String> phoneNumber =  new ArrayList<>();
			       Connection conn =  new mySqlConn().connectDB();
				   
			       try (conn){
					conn.setAutoCommit(false);
					
						try(PreparedStatement pstmt = conn.prepareStatement("SELECT huespedes.idUser, huespedes.name,  huespedes.lastName, huespedes.birthDate,  huespedes.nacionality, huespedes.phoneNumber, reservas.numerodereserva  FROM huespedes INNER JOIN reservas on huespedes.idUser = reservas.idReserv WHERE name=?");) {
							pstmt.setString(1, host);
							try (ResultSet resultSet =  pstmt.executeQuery();){
								while (resultSet.next()) {
									idUser.add(resultSet.getString("idUser"));
									numeroReserva.add(resultSet.getString("numerodereserva"));
									name.add(resultSet.getString("name"));
									lastName.add(resultSet.getString("lastName"));
									birthDate.add(resultSet.getString("birthDate"));
									nacionality.add(resultSet.getString("nacionality"));
									phoneNumber.add(resultSet.getString("phoneNumber"));
						
								}
								
								guestsItemsMap.put("idUser",idUser);
								guestsItemsMap.put("numeroReserva",numeroReserva);
								guestsItemsMap.put("name", name);
								guestsItemsMap.put("lastName", lastName);
								guestsItemsMap.put("birthDate", birthDate);
								guestsItemsMap.put("nacionality", nacionality);
								guestsItemsMap.put("phoneNumber", phoneNumber);
							} catch (Exception e) {
								throw new RuntimeException();
							}
						} catch (Exception e) {
							throw new RuntimeException();
						}
			
					 
					
					} catch (SQLException ex) {
						throw new RuntimeException();
					}
				
				return guestsItemsMap;
			}
			
		
	public HashMap<String, ArrayList<String>> getHuespedes(String hostName, String hostLastName) {
		System.out.println("invocado");
		HashMap<String, ArrayList<String>>  guestsItemsMap = new HashMap<>();
		   ArrayList<String> idUser =  new ArrayList<>();
	       ArrayList<String> numeroReserva =  new ArrayList<>();
	       ArrayList<String> name=  new ArrayList<>();
	       ArrayList<String>  lastName =  new ArrayList<>();
	       ArrayList<String> birthDate =  new ArrayList<>();
	       ArrayList<String> nacionality =  new ArrayList<>();
	       ArrayList<String> phoneNumber =  new ArrayList<>();
	       Connection conn =  new mySqlConn().connectDB();
		   
	       try (conn){
			conn.setAutoCommit(false);
			
				try(PreparedStatement pstmt = conn.prepareStatement("SELECT huespedes.idUser, huespedes.name,  huespedes.lastName, huespedes.birthDate,  huespedes.nacionality, huespedes.phoneNumber, reservas.numerodereserva  FROM huespedes INNER JOIN reservas on huespedes.idUser = reservas.idReserv WHERE name=? AND lastName=?");) {
					pstmt.setString(1, hostName);
					pstmt.setString(2, hostLastName);
					try (ResultSet resultSet =  pstmt.executeQuery();){
						while (resultSet.next()) {
							idUser.add(resultSet.getString("idUser"));
							numeroReserva.add(resultSet.getString("numerodereserva"));
							name.add(resultSet.getString("name"));
							lastName.add(resultSet.getString("lastName"));
							birthDate.add(resultSet.getString("birthDate"));
							nacionality.add(resultSet.getString("nacionality"));
							phoneNumber.add(resultSet.getString("phoneNumber"));
				
						}
						
						guestsItemsMap.put("idUser",idUser);
						guestsItemsMap.put("numeroReserva",numeroReserva);
						guestsItemsMap.put("name", name);
						guestsItemsMap.put("lastName", lastName);
						guestsItemsMap.put("birthDate", birthDate);
						guestsItemsMap.put("nacionality", nacionality);
						guestsItemsMap.put("phoneNumber", phoneNumber);
					} catch (Exception e) {
						throw new RuntimeException();
					}
				} catch (Exception e) {
					throw new RuntimeException();
				}
	
			 
			
			} catch (SQLException ex) {
				throw new RuntimeException();
			}
		
		return guestsItemsMap;
	}
		
		
		
	}

