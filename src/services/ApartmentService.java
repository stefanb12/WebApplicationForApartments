package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Apartment;
import beans.Host;
import dao.ApartmentDAO;

@Path("/apartments")
public class ApartmentService {
	
	@Context
	ServletContext ctx;
	//private String path;
	
	public ApartmentService() {
		
	}
	
	@PostConstruct
	public void init() { 
		if (ctx.getAttribute("apartmentDAO") == null) {
			String contextPath = ctx.getRealPath("");
			//path = contextPath;
			ctx.setAttribute("apartmentDAO", new ApartmentDAO(contextPath));
		}		
	}
	
	@GET
	@Path("/") // Svi apartmani
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Apartment> getAllApartments() {	
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.findAllActiveApartments();	
	}
	
	@GET
	@Path("/activeApartments")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Apartment> getActiveApartments() {	
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.findAllActiveApartments();	
	}
	
	@GET
	@Path("/activeApartmentsByHost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Apartment> getActiveApartments(Host host) {
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.findAllApartments(host);	
	}	
	
	@GET
	@Path("/inactiveApartmentsByHost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Apartment> getInactiveApartments(Host host) {	
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.findAllInactiveApartments(host);	
	}		
	
	@POST
	@Path("/addApartment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Apartment addApartment(Apartment apartment) {
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.addApartment(apartment);
	}
	
	@POST
	@Path("/deleteApartment")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteApartment(Apartment apartment) {	
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		apartmentDAO.deleteApartment(apartment);
	}

	// Dodaj izmene apartmana
}
