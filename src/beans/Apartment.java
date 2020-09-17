package beans;

import java.util.ArrayList;
import java.util.Date;

public class Apartment {
	TypeOfApartment typeOfApartment;
	int numberOfRooms;
	int numberOfGuests;
	Location location;
	Date availableFrom;
	Date availableTo;
	ArrayList<Date> availabilityByDate; // Dostupnost po datumima
	User host; // Domacin
	ArrayList<Comment> comments;
	// Slike
	Double pricePerNight; // Cena po noci
	Date checkInTime;
	Date checkOutTime;
	Boolean status; // True = aktivan, False = neaktivan;
	ArrayList<Amenities> amenities;
	ArrayList<Reservation> reservations;
	
	public Apartment() {
		
	}

	public Apartment(TypeOfApartment typeOfApartment, int numberOfRooms, int numberOfGuests, Location location,
			Date availableFrom, Date availableTo, ArrayList<Date> availabilityByDate, User host, ArrayList<Comment> comments,
			Double pricePerNight, Date checkInTime, Date checkOutTime, Boolean status, ArrayList<Amenities> amenities,
			ArrayList<Reservation> reservations) {
		super();
		this.typeOfApartment = typeOfApartment;
		this.numberOfRooms = numberOfRooms;
		this.numberOfGuests = numberOfGuests;
		this.location = location;
		this.availableFrom = availableFrom;
		this.availableTo = availableTo;
		this.availabilityByDate = availabilityByDate;
		this.host = host;
		this.comments = comments;
		this.pricePerNight = pricePerNight;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.status = status;
		this.amenities = amenities;
		this.reservations = reservations;
	}

	public TypeOfApartment getTypeOfApartment() {
		return typeOfApartment;
	}

	public void setTypeOfApartment(TypeOfApartment typeOfApartment) {
		this.typeOfApartment = typeOfApartment;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}
	
	public Date getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(Date availableTo) {
		this.availableTo = availableTo;
	}

	public ArrayList<Date> getAvailabilityByDate() {
		return availabilityByDate;
	}

	public void setAvailabilityByDate(ArrayList<Date> availabilityByDate) {
		this.availabilityByDate = availabilityByDate;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public Double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ArrayList<Amenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(ArrayList<Amenities> amenities) {
		this.amenities = amenities;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

}
