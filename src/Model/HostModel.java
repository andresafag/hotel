package Model;



import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Database.BindReservation;
import Database.GetHuespedes;
import Database.HostReservDeletion;
import Database.UpdateHost;
import Database.VerifyUsers;
import views.MenuUsuario;



public class HostModel {
	private int idUser;
	private String name;
	private String lastName;
	private Date birthDate;
	private String nacionality;
	private long phoneNumber;
	private String userName;
	private String passwd;
	private long reservNumber;
	
		
	public HostModel(String userName, String passwd) {
		this.userName =  userName;
		this.passwd =  passwd;
		
	}
	
	public HostModel(String nombre, String apellido, Date fecha, String nacionalidad, String telefono, long reserva) {
		this.name =  nombre;
		this.lastName =  apellido;
		this.birthDate = fecha;
		this.nacionality = nacionalidad;
		this.phoneNumber = Long.parseLong(telefono);
		this.reservNumber =  reserva;
		
	}
	
	public HostModel(long reservNumber) {
		this.reservNumber =  reservNumber;
	
	}
	
	public HostModel(String name) {
		this.name =  name;
	
	}
	
	public HostModel(int hostId) {
		this.idUser =  hostId;
	
	}
	
	public HostModel(String hostId, String name, String lastName, String birthDate, String nacionality, String phone, String idReserv) {
		this.idUser = Integer.parseInt(hostId);
		this.name =  name;
		this.lastName = lastName;
		this.birthDate =  Date.valueOf(birthDate);
		this.nacionality =  nacionality;
		this.phoneNumber =  Long.parseLong(phone);
		this.reservNumber =  Long.parseLong(idReserv);
	}
	
	
	
	public boolean bindHostReserv() {
		BindReservation bind = new  BindReservation();
		return bind.bindreservation(this.name, this.lastName, this.birthDate, this.nacionality, this.phoneNumber, this.reservNumber);
	}
	
	
	public boolean allowUser() {
		return new VerifyUsers().verifyUsers(this.userName, this.passwd);
	}
	
	
	public HashMap<String, ArrayList<String>> hostsHashmap(){
		return new GetHuespedes().getHuespedes(this.name); 
	}

	public HashMap<String, ArrayList<String>> hostsHashmap2(String hostName, String hostLastName){
		return new GetHuespedes().getHuespedes(hostName,hostLastName); 
	}
	
	
	public boolean editHost() {
		UpdateHost updateHost = new UpdateHost();
		return updateHost.updateHost(this.idUser,this.name, this.lastName, this.birthDate,this.nacionality,this.phoneNumber, this.reservNumber);
	}
	
	
	public boolean hostDataDeletion() {
		return new HostReservDeletion().hostReservDeletion(this.reservNumber);
	}
	
	
	
}
