package beans;

import java.util.ArrayList;

public class Guest extends User {
	ArrayList<Apartment> rentedApartments; 
	ArrayList<Reservation> reservations; 

	public Guest() {
		
	}
	
	public Guest(String username, String password, String name, String surname, Boolean gender, Role role) {
		super(username, password, name, surname, gender, role);
	}

	public Guest(String username, String password, String name, String surname, Boolean gender, Role role,
			ArrayList<Apartment> rentedApartments, ArrayList<Reservation> reservations) {
		super(username, password, name, surname, gender, role);
		this.rentedApartments = rentedApartments;
		this.reservations = reservations;
	}

	public ArrayList<Apartment> getRentedApartments() {
		return rentedApartments;
	}

	public void setRentedApartments(ArrayList<Apartment> rentedApartments) {
		this.rentedApartments = rentedApartments;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}	
	
}
