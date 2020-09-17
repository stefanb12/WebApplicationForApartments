package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Apartment;
import beans.Host;
import beans.User;

public class ApartmentDAO {
	
	
	private Map<String, Apartment> apartments = new HashMap<>();
	
	public ApartmentDAO() {		
		
	}
	
	public ApartmentDAO(String contextPath) {		
		loadApartments(contextPath);
	}
	
	public Collection<Apartment> findAll() {
		return apartments.values();
	}
	
	public Collection<Apartment> findAllActiveApartments() {
		ArrayList<Apartment> activeApartments = new ArrayList<>();	
		for (Apartment apartment : apartments.values()) 
			if(apartment.getStatus())
				activeApartments.add(apartment);		
		return activeApartments;
	}
	
	public Collection<Apartment> findAllInactiveApartments(Host host) {
		ArrayList<Apartment> inactiveApartmentsByHost = new ArrayList<>();	
		for (Apartment apartment : apartments.values()) 
			if(apartment.getHost().getUsername().equals(host.getUsername()))
				if(!apartment.getStatus())
					inactiveApartmentsByHost.add(apartment);		
		return inactiveApartmentsByHost;
	}
	
	public Collection<Apartment> findAllApartments(User host) {
		ArrayList<Apartment> apartmetnsByHost = new ArrayList<>();
		
		ArrayList<Apartment> activeApartments = new ArrayList<>();	
		for (Apartment apartment : apartments.values()) 
			if(apartment.getStatus())
				activeApartments.add(apartment);
		
		for (Apartment apartment : activeApartments) {
			System.out.println("Host iz aktivni:" + apartment.getHost().getUsername());
			if(apartment.getHost().getUsername().equals(host.getUsername()))
				apartmetnsByHost.add(apartment);	
		}
		return apartmetnsByHost;
	}	
	
	public Collection<Apartment> findAllInActiveApartments(User host) {
		ArrayList<Apartment> apartmetnsByHost = new ArrayList<>();
		
		ArrayList<Apartment> inActiveApartments = new ArrayList<>();	
		for (Apartment apartment : apartments.values()) 
			if(!apartment.getStatus())
				inActiveApartments.add(apartment);
		
		for (Apartment apartment : inActiveApartments) 
			if(apartment.getHost().getUsername().equals(host.getUsername()))
				apartmetnsByHost.add(apartment);		
		return apartmetnsByHost;
	}	
	
	/*public Apartment addApartment(Apartment apartment) {
		
		apartments.add(apartment);
		return apartment;
	}*/
	
	public void deleteApartment(Apartment apartment) {
		for (Apartment a : apartments.values()) 
			if(a.equals(apartment)) // Izmeni !!!!!!!!!!!!!
				apartments.remove(a);	
	}
	
	private void loadApartments(String contextPath) {
		try {
		    /*ObjectMapper mapper = new ObjectMapper();
		    File file = new File(contextPath + "files\\apartments.json");
	
		    List<Apartment> apartmentsList = Arrays.asList(mapper.readValue(file, Apartment[].class)); 		   
		    
		    for(Apartment apartment : apartmentsList)
		    	apartments.add(apartment);*/
			
			
			ObjectMapper mapper = new ObjectMapper();
		    BufferedReader in = null;
			try {
			    File file = new File(contextPath + "files\\apartments.json");
			    in = new BufferedReader(new FileReader(file));
			    Map<String, Apartment> apartmentsMap = mapper.readValue(in, new TypeReference<Map<String, Apartment>>() {}); 		   
			    
			    apartments = apartmentsMap;
	
			} catch (Exception ex) {
			    ex.printStackTrace();		    
			}
	
		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
	}
	
	public Apartment saveApartment(String contextPath, Apartment apartment) {
		System.out.println("NOVI APARTMAN DAO");
		System.out.println("Cena: " + apartment.getPricePerNight());
		ObjectMapper mapper = new ObjectMapper();
	    String path = contextPath + "files\\apartments.json";
	    apartments.put(apartment.getLocation().getAddress().getAddress(), apartment);
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {		    		    
			mapper.writeValue(Paths.get(path).toFile(), apartments);
			System.out.println("Save: " + Paths.get(path).toFile());
		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
		return apartment;
	}
	
	public Apartment findApartmentByLocation(String address) {
		for (Apartment apartment : apartments.values()) 
			if(apartment.getLocation().getAddress().getAddress().equals(address))
				return apartment;
		
		return null;
	}
	
}
