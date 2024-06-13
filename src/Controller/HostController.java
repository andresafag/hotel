package Controller;
import Model.HostModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Database.GetHuespedes;
import Database.VerifyUsers;
import Model.ReservationModel;
import views.MenuUsuario;
import views.ReservasView;
import views.ReservasView;

public class HostController {
	private HostModel hostModel;
	
	
	public boolean allow(String usr, String psw) {
		this.hostModel =  new HostModel(usr, psw);
		return this.hostModel.allowUser();
	}

	
	public boolean bindHostReserv(String nombre, String apellido, Date fecha, String nacionalidad, String telefono, long reserva) {
		
		this.hostModel = new HostModel(nombre, apellido, fecha, nacionalidad, telefono, reserva);
		return this.hostModel.bindHostReserv();
	}
	
	
	public HashMap<String, ArrayList<String>> hostSearch(String host) {
		this.hostModel = new HostModel(host);
		return this.hostModel.hostsHashmap();
	}

	public HashMap<String, ArrayList<String>> hostSearch2(String hostName, String hostLastName) {
		return new GetHuespedes().getHuespedes(hostName,hostLastName);
	}
	
	public boolean hostEditing(String hostId, String name, String lastName, String birthDate, String nacionality, String phone, String idReserv) {
		this.hostModel = new HostModel(hostId, name, lastName,birthDate, nacionality, phone, idReserv);
		return hostModel.editHost();
	}
	
	
	public boolean hostReservdeletion(String reservNumber) {
		this.hostModel = new HostModel(Long.parseLong(reservNumber));
		return hostModel.hostDataDeletion();
	
	}
	


}
