package beans;

import java.util.ArrayList;

public class Host extends User {
	ArrayList<Apartment> appartmentsForRent; 
	
	public Host() {
		
	}

	public Host(String username, String password, String name, String surname, Boolean gender, Role role) {
		super(username, password, name, surname, gender, role);
	}
	
	public Host(String username, String password, String name, String surname, Boolean gender, Role role,
			ArrayList<Apartment> appartmentsForRent) {
		super(username, password, name, surname, gender, role);
		this.appartmentsForRent = appartmentsForRent;
	}

	public ArrayList<Apartment> getAppartmentsForRent() {
		return appartmentsForRent;
	}

	public void setAppartmentsForRent(ArrayList<Apartment> appartmentsForRent) {
		this.appartmentsForRent = appartmentsForRent;
	}

}
