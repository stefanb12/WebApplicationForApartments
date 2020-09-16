package services;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;
import dao.UserDAO;

@Path("/users")
public class UserService {
	
	@Context
	ServletContext ctx;
	public static String path;
	
	public UserService() {
		
	}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("userDAO") == null) {
			String contextPath = ctx.getRealPath("");
			path = contextPath;
			ctx.setAttribute("userDAO", new UserDAO(contextPath));
		}
	}
	
	@GET
	@Path("/") // Svi korisnici
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getAllUser() {	
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		return userDao.findAll();	
	}	
	
	@POST
	@Path("/register") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(User user) throws IOException {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(user.getUsername(), user.getPassword());

		if (loggedUser != null) {
			return Response.status(400).entity("User already exists").build();
		}

		//userDao.addUser(user);
		userDao.saveUser(path, user);				
		
		return Response.status(200).build();
	}
	
	@GET
	@Path("/login")
	public Response login(@QueryParam("username") String username, @QueryParam("password") String password, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(username, password);
		System.out.println("USERNAME:" + username + " PASSWORD:" + password);
		
		if (loggedUser == null) {
			System.out.println("NIJE ULOGOVAN");
			return Response.status(400).entity("Invalid username and/or password").build();
		}
		
		System.out.println("ULOGOVAN");
		request.getSession().setAttribute("user", loggedUser); 
		return Response.status(200).build();
	}	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(User user, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(user.getUsername(), user.getPassword());

		if (loggedUser == null) {
			return Response.status(400).entity("Invalid username and/or password").build();
		}
		
		request.getSession().setAttribute("user", loggedUser); 
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
	public User currentUser(@Context HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	@GET
	@Path("/isLogged")
	public Boolean isLogged(@QueryParam("username") String username, @QueryParam("password") String password, @Context HttpServletRequest request) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(username, password);
		if(loggedUser != null) {
			return true;
		}else {
			return false;
		}
	}
	
	@POST
	@Path("/updateAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateAccount(User user) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User updatedUser = userDao.getUser(user.getUsername());
		if(updatedUser != null) {
			userDao.deleteUser(user);
			updatedUser.setUsername(user.getUsername());
			updatedUser.setName(user.getName());
			updatedUser.setSurname(user.getSurname());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setGender(user.getGender());
			updatedUser.setRole(user.getRole());
			userDao.saveUser(path, updatedUser);
			return user;
		}else {
			return null;
		}
	}
	
	
	@POST
	@Path("/deleteUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(User user) {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		userDao.deleteUser(user);
	}
	
	@POST
	@Path("/doesUserExist") 
	@Consumes(MediaType.APPLICATION_JSON)
	public String doesUserExist(User user) throws IOException {
		UserDAO userDao = (UserDAO) ctx.getAttribute("userDAO");
		User loggedUser = userDao.find(user.getUsername(), user.getPassword());
		if (loggedUser != null) {
			return "Korisnik vec postoji";
		}
		return "Uspesno ste se registrovali";
	}
}
