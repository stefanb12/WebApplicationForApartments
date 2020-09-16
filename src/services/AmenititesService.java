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

import beans.Amenities;
import dao.AmenitiesDAO;

@Path("/amenities")
public class AmenititesService {
	
	@Context
	ServletContext ctx;
	//public String path;
	
	public AmenititesService() {
		
	}
	
	@PostConstruct
	public void init() { 
		if (ctx.getAttribute("amenitiesDAO") == null) {
			String contextPath = ctx.getRealPath("");
			//path = contextPath;
			ctx.setAttribute("amenitiesDAO", new AmenitiesDAO(contextPath));
		}
	}
	
	@GET
	@Path("/") // Sva oprema za apartmane
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Amenities> getAllAmenities() {	
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		return amenitiesDAO.findAll();	
	}
	
	@POST
	@Path("/addAmenities")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Amenities addAmenities(Amenities amenities) {
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		return amenitiesDAO.addAmenities(amenities);
	}
	
	@POST
	@Path("/deleteAmenities")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAmenities(Amenities amenities) {	
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		amenitiesDAO.deleteAmenities(amenities);
	}	
	
	@POST
	@Path("/updateAmenities")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAmenities(Amenities amenities) {	
		AmenitiesDAO amenitiesDAO = (AmenitiesDAO) ctx.getAttribute("amenitiesDAO");
		amenitiesDAO.udpateAmenities(amenities);
	}
}
