package Controller;

import java.util.*;
import Database.CheckReservations;
import Database.GetSingleReservation;
import Model.ReservationModel;


public class ReservController {
	private ReservationModel reservationModel;
	
	public void generateReservation(String checkin,  String checkout, double price, String paymethod, long resNumber) {
		this.reservationModel =  new ReservationModel(checkin, checkout, price, paymethod, resNumber);
		this.reservationModel.generateReservation();
		
		
	}
	
	
	public ArrayList<String> getSingleReservation(String SingleReserv) {
		this.reservationModel = new ReservationModel(SingleReserv);
		return this.reservationModel.getSingleReservation();
	}
	
	
	public HashMap<String, ArrayList<String>> reservHashMap() {
		this.reservationModel = new ReservationModel();
		return this.reservationModel.reservHashMap();
	}
	
	
	
	public boolean reservationUpdated(String checkin, String checkout, String price, String paymethod, String resNumber) {
		this.reservationModel =  new ReservationModel(checkin, checkout, Double.parseDouble(price), paymethod, Long.parseLong(resNumber));
		return this.reservationModel.dataUpdated();
	}
	
	
	
	public boolean reservationDeletion(String resNumber) {
		this.reservationModel =  new ReservationModel(Long.parseLong(resNumber));
		return this.reservationModel.dataDeletion();
	}
	
	
}
