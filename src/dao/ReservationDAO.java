package dao;

import java.util.ArrayList;
import java.util.Collection;

import beans.Reservation;

public class ReservationDAO {
	
	private ArrayList<Reservation> reservations = new ArrayList<>(); // IZMENII
	
	public ReservationDAO() {		
		// Ucitaj rezervacije
	}
	
	public Collection<Reservation> findAll() {
		return reservations;
	}
	
}
