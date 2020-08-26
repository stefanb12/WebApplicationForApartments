package beans;

import java.util.Date;

public class Reservation {
	Apartment apartment; // Apartman koji je rezervisan
	Date startDate; // Pocetni datum rezervacije
	int numberOfNights;
	Double totalPrice;
	String message; // Poruka pri rezervaciji
	Guest guest;
	StatusOfReservation statusOfReservation;
	
	public Reservation() {
		
	}

	public Reservation(Apartment apartment, Date startDate, int numberOfNights, Double totalPrice, String message,
			Guest guest, StatusOfReservation statusOfReservation) {
		super();
		this.apartment = apartment;
		this.startDate = startDate;
		this.numberOfNights = numberOfNights;
		this.totalPrice = totalPrice;
		this.message = message;
		this.guest = guest;
		this.statusOfReservation = statusOfReservation;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public StatusOfReservation getStatusOfReservation() {
		return statusOfReservation;
	}

	public void setStatusOfReservation(StatusOfReservation statusOfReservation) {
		this.statusOfReservation = statusOfReservation;
	}	
	
}
