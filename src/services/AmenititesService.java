package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Amenities;
import dao.AmenitiesDAO;

@Path("/amenities")
public class AmenititesService {
	
	@Context
	ServletContext ctx;
	
	public AmenititesService() {
		
	}
	
	@PostConstruct
	public void init() { 
		if (ctx.getAttribute("amenitiesDAO") == null) { 
			ctx.setAttribute("amenitiesDAO", new AmenitiesDAO());
		}
	}
	
	@GET
	@Path("/") // Svi korisnici
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Amenities> getAllAmenities() {	
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		return amenitiesDAO.findAll();	
	}
	
	// Dodati dodavanje, brisanje i izmenu
}
