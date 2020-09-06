package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Guest;
import beans.Host;
import beans.Reservation;
import dao.ReservationDAO;

@Path("/reservations")
public class ReservationService {
	
	@Context
	ServletContext ctx;
	//private String path;
	
	public ReservationService() {
		
	}
	
	@PostConstruct
	public void init() { 		
		if (ctx.getAttribute("reservationDAO") == null) {
			String contextPath = ctx.getRealPath("");
			//path = contextPath;
			ctx.setAttribute("reservationDAO", new ReservationDAO(contextPath));
		}
	}
	
	@GET
	@Path("/") // Sve rezervacije
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reservation> getAllReservations() {	
		ReservationDAO reservationDAO = (ReservationDAO) ctx.getAttribute("reservationDAO");
		return reservationDAO.findAll();	
	}
	
	@GET
	@Path("/reservationsByGuest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Reservation> getAllReservations(Guest guest) {
		ReservationDAO reservationDAO = (ReservationDAO) ctx.getAttribute("reservationDAO");
		return reservationDAO.findAllReservations(guest);	
	}
	
	@GET
	@Path("/reservationsByHost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Reservation> getAllReservations(Host host) { // Implementirati
		//ReservationDAO reservationDAO = (ReservationDAO) ctx.getAttribute("reservationDAO");
		return null;	
	}
	
	// Dodati izmenu statusa rezervacije
}
