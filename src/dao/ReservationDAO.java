package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Guest;
import beans.Reservation;
import beans.User;

public class ReservationDAO {
	
	private ArrayList<Reservation> reservations = new ArrayList<>();	
	
	public ReservationDAO() {		
		
	}
	
	public ReservationDAO(String contextPath) {		
		loadReservations(contextPath);
	}
	
	public Collection<Reservation> findAll() {
		return reservations;
	}
	
	public Collection<Reservation> findAllReservations(Guest guest) {				
		return guest.getReservations();
	}
	
	public Collection<Reservation> findAllReservationsByHost(User host) {
		ArrayList<Reservation> reservationsByHost = new ArrayList<>();	
		for (Reservation reservation : reservations) {
			if(reservation.getApartment().getHost().getUsername().equals(host.getUsername()))
				reservationsByHost.add(reservation);
		}
		return reservationsByHost;
	}
	
	private void loadReservations(String contextPath) {
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    File file = new File(contextPath + "files\\reservations.json");

		    List<Reservation> reservationsList = Arrays.asList(mapper.readValue(file, Reservation[].class)); 		   
		    
		    for(Reservation reservation : reservationsList)
		    	reservations.add(reservation);		    

		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
	}

}
