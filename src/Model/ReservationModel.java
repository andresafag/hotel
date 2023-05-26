package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import Database.CheckReservations;
import Database.DataDeletion;
import Database.GenerateReservation;
import Database.GenerateReservation;
import Database.GetSingleReservation;
import Database.UpdateReservation;
import views.ReservasView;

public class ReservationModel {
	private int idReserv;
	private Date checkInDate;
	private Date checkOutDate;
	private double price;
	private String paymentMethod;
	private long reserNumber;
	private String strreserNumber;
	
	public ReservationModel() {	
	
	}
	
	
	public ReservationModel(String checkin,  String checkout, double price, String paymethod, long resNumber) {
		this.checkInDate = Date.valueOf(checkin);
		this.checkOutDate = Date.valueOf(checkout);
		this.paymentMethod = paymethod;
		this.price = price;
		this.reserNumber =  resNumber;
	}
	
	public ReservationModel(String str) {
		this.strreserNumber = str;
	}
	
	public ReservationModel(long reserNumber) {
		this.reserNumber =  reserNumber;
	}
	
	
	
	
	public void generateReservation() {
		GenerateReservation getreservation =  new GenerateReservation();
		getreservation.generateReservation(this.checkInDate, this.checkOutDate, this.price, this.paymentMethod, this.reserNumber);				
		
	}
	

	public ArrayList<String> getSingleReservation(){
		 GetSingleReservation single = new GetSingleReservation();
		return single.GetSingleReservation(this.strreserNumber);
	}

	
	public HashMap<String,  ArrayList<String>> reservHashMap() {
		CheckReservations chckRes = new CheckReservations();
		return chckRes.CheckReservations();
	}
	
	
	
	public boolean dataUpdated() {
		UpdateReservation updateReserv = new UpdateReservation();
		return updateReserv.UpdateReservation(this.reserNumber, this.checkInDate, this.checkOutDate, this.price, this.paymentMethod);
		
	}
	
	public boolean dataDeletion() {
		DataDeletion dataDeletion =  new DataDeletion();
		return dataDeletion.dataDeletion(this.reserNumber);
		
	}
	
}







