package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Apartment;
import beans.Host;

public class ApartmentDAO {
	
private ArrayList<Apartment> apartments = new ArrayList<>();	
	
	public ApartmentDAO() {		
		
	}

	public ApartmentDAO(String contextPath) {		
		loadApartments(contextPath);
	}
	
	public Collection<Apartment> findAll() {
		return apartments;
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
	
	public Apartment addApartment(Apartment apartment) {
		apartments.add(apartment);
		return apartment;
	}
	
	public void deleteApartment(Apartment apartment) {
		for (Apartment a : apartments) 
			if(a.equals(apartment)) // Izmeni !!!!!!!!!!!!!
				apartments.remove(a);	
	}
	
	private void loadApartments(String contextPath) {
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    File file = new File(contextPath + "files\\apartments.json");

		    List<Apartment> apartmentsList = Arrays.asList(mapper.readValue(file, Apartment[].class)); 		   
		    
		    for(Apartment apartment : apartmentsList)
		    	apartments.add(apartment);		    

		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
	}
	
}
