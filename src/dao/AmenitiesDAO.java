package dao;

import java.util.ArrayList;
import java.util.Collection;

import beans.Amenities;

public class AmenitiesDAO {

	private ArrayList<Amenities> amenities = new ArrayList<>();	
	
	public AmenitiesDAO() {		
		// Ucitaj sadrzaj apartmana	
	}
	
	public Collection<Amenities> findAll() {
		return amenities;
	}
}
