package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;
import dao.UserDAO;

@Path("/users")
public class UserService {
	
	@Context
	ServletContext ctx;
	
	public UserService() {
		
	}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("userDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("userDAO", new UserDAO(contextPath));
		}
	}
	
	@GET
	@Path("/allUsers") // Svi korisnici
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getAllUser() {	
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		return userDao.findAll();	
	}
	
	@GET
	@Path("/usersByHost")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUsersByHost() {	// Implementirati
		//UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		return null;
	}
	
	/*@GET
	@Path("/login")
	public Response login(@QueryParam("username") String username, @QueryParam("password") String password,
			@Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(username, password);
		System.out.println("Username:" + username + ", Password:" + password);
		if (loggedUser == null) {
			System.out.println("NIJE ULOGOVAN");
			return Response.status(400).entity("Invalid username and/or password").build();
		}
		System.out.println("ULOGOVAN");
		request.getSession().setAttribute("user", loggedUser); 
		return Response.status(200).build();
	}*/
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(User user, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(user.getUsername(), user.getPassword());
		System.out.println("Username:" + user.getUsername() + ", Password:" + user.getPassword());
		if (loggedUser == null) {
			System.out.println("NE POSTOJI USER SA TIM USERNAME/PASSWORD!");
			return Response.status(400).entity("Invalid username and/or password").build();
		}
		System.out.println("POSTOJI USER!");
		request.getSession().setAttribute("user", loggedUser); 
		return Response.status(200).build();
	}
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(User user) throws IOException {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(user.getUsername(), user.getPassword());
		System.out.println("Username:" + user.getUsername() + ", Password:" + user.getPassword());
		if (loggedUser != null) {
			System.out.println("VEC POSTOJI");
			return Response.status(400).entity("User already exists").build();
		}
				
		BufferedWriter writer = null;

		try {
			
			writer = new BufferedWriter(new FileWriter("C:\\Users\\Hacer\\Desktop\\WEB PROJEKAT\\WebApplicationForApartments\\WebContent\\resources\\users.json", true));
			writer.newLine();			
			ObjectMapper mapper = new ObjectMapper();
			String userString = mapper.writeValueAsString(user);
			writer.write(userString);			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				}
				catch (Exception e) { }
			}
		}
				
		System.out.println("REGISTROVAN");
		userDao.addUser(user);
		return Response.status(200).build();
	}	
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void logout(@Context HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	@GET
	@Path("/currentUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User login(@Context HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
}
