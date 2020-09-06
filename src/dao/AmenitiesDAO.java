package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Amenities;

public class AmenitiesDAO {

	private ArrayList<Amenities> amenities = new ArrayList<>();	
	
	public AmenitiesDAO() {		
			
	}
	
	public AmenitiesDAO(String contextPath) {		
		loadAmenities(contextPath);	
	}
	
	public Collection<Amenities> findAll() {
		return amenities;
	}
	
	public Amenities addAmenities(Amenities a) {
		amenities.add(a);
		return a;
	}
	
	public void deleteAmenities(Amenities a) {
		for (Amenities am : amenities) 
			if(am.equals(a)) // Izmeni !!!!!!!!!!!!!
				amenities.remove(am);	
	}
	
	private void loadAmenities(String contextPath) {
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    File file = new File(contextPath + "files\\amenities.json");

		    List<Amenities> amenitiesList = Arrays.asList(mapper.readValue(file, Amenities[].class)); 		   
		    
		    for(Amenities a : amenitiesList)
		    	amenities.add(a);		    

		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
	}
	
}
