package dao;

import java.util.ArrayList;
import java.util.Collection;

import beans.Apartment;
import beans.Host;

public class ApartmentDAO {
	
private ArrayList<Apartment> apartments = new ArrayList<>();	
	
	public ApartmentDAO() {		
		// Ucitaj apartmane	
	}
	
	public Collection<Apartment> findAllActiveApartments() {
		ArrayList<Apartment> activeApartments = new ArrayList<>();	
		for (Apartment apartment : apartments) 
			if(apartment.getStatus())
				activeApartments.add(apartment);		
		return activeApartments;
	}
	
	public Collection<Apartment> findAllInactiveApartments(Host host) {
		ArrayList<Apartment> inactiveApartmentsByHost = new ArrayList<>();	
		for (Apartment apartment : apartments) 
			if(apartment.getHost().getUsername().equals(host.getUsername()))
				if(!apartment.getStatus())
					inactiveApartmentsByHost.add(apartment);		
		return inactiveApartmentsByHost;
	}
	
	public Collection<Apartment> findAllApartments(Host host) {
		ArrayList<Apartment> apartmetnsByHost = new ArrayList<>();	
		for (Apartment apartment : apartments) 
			if(apartment.getHost().getUsername().equals(host.getUsername()))
				apartmetnsByHost.add(apartment);		
		return apartmetnsByHost;
	}	
	
	public void deleteApartment(Apartment apartment) {
		for (Apartment a : apartments) 
			if(a.equals(apartment)) // Izmeni !!!!!!!!!!!!!
				apartments.remove(a);	
	}
	
	public Apartment addApartment(Apartment apartment) {
		apartments.add(apartment);
		return apartment;
	}
	
}
