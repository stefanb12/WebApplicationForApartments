package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Reservation;
import dao.ReservationDAO;

@Path("/reservations")
public class ReservationService {
	
	@Context
	ServletContext ctx;
	
	public ReservationService() {
		
	}
	
	@PostConstruct
	public void init() { 
		if (ctx.getAttribute("reservationDAO") == null) { 
			ctx.setAttribute("reservationDAO", new ReservationDAO());
		}
	}
	
	@GET
	@Path("/") // Svi korisnici
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reservation> getAllReservations() {	
		ReservationDAO ReservationDAO = (ReservationDAO) ctx.getAttribute("reservationDAO");
		return ReservationDAO.findAll();	
	}
	
}
