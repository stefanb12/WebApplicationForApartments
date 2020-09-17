package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Apartment;
import beans.Host;
import beans.User;
import dao.ApartmentDAO;

@Path("/apartments")
public class ApartmentService {
	
	@Context
	ServletContext ctx;
	public static String path;
	
	public ApartmentService() {
		
	}
	
	@PostConstruct
	public void init() { 
		if (ctx.getAttribute("apartmentDAO") == null) {
			String contextPath = ctx.getRealPath("");
			path = contextPath;
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
	public Collection<Apartment> getActiveApartments(@Context HttpServletRequest request) {
		User host = (User) request.getSession().getAttribute("user");
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.findAllApartments(host);	
	}	
	
	@GET
	@Path("/inactiveApartmentsByHost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Apartment> getInactiveApartments(@Context HttpServletRequest request) {	
		User host = (User) request.getSession().getAttribute("user");
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		return apartmentDAO.findAllInActiveApartments(host);	
	}			
	
	@POST
	@Path("/addApartment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Apartment addApartment(@Context HttpServletRequest request, Apartment apartment) {
		System.out.println("NOVI APARTMAN SERVICE");
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		User host = (User) request.getSession().getAttribute("user");
		apartment.setHost(host);
		Apartment existingApartment = apartmentDAO.findApartmentByLocation(apartment.getLocation().getAddress().getAddress());
		if(existingApartment == null) {
			System.out.println("Sacuvao");
			return apartmentDAO.saveApartment(path, apartment);
		}
		System.out.println("Nije sacuvao");
		return null;
	}
	
	@POST
	@Path("/deleteApartment")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteApartment(Apartment apartment) {	
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		apartmentDAO.deleteApartment(apartment);
	}
	
	@POST
	@Path("/doesApartmentExist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String doesApartmentExist(@Context HttpServletRequest request, Apartment apartment) {
		ApartmentDAO apartmentDAO = (ApartmentDAO) ctx.getAttribute("apartmentDAO");
		Apartment existingApartment = apartmentDAO.findApartmentByLocation(apartment.getLocation().getAddress().getAddress());
		if(existingApartment != null) {
			return "Apartman vec postoji!";
		}
		return "Uspesno ste kreirali novi apartman";
	}


}
