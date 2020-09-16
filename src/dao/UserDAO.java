package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.User;

public class UserDAO {
	
	private Map<String, User> users = new HashMap<>();
	List<User> usersList;
	
	public UserDAO() {
		
	}
	
	public UserDAO(String contextPath) {		
		loadUsers(contextPath);
	}
		
	public User find(String username, String password) {
		if (!users.containsKey(username)) {
			return null;
		}
		User user = users.get(username);
		if (!user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}
	
	public User getUser(String username) {
		if(users.containsKey(username))
			return users.get(username);
		else
			return null;
	}
	
	public void deleteUser(User user) {
		users.remove(user.getUsername());
	}
	
	public Boolean isUsernameExist(String username) {
		return users.containsKey(username);		
	}
	
	public Collection<User> findAll() {
		return users.values();
	}
	
	public void addUser(User user) throws JsonGenerationException, JsonMappingException, IOException {
		users.put(user.getUsername(), user);
	}
		
	public User saveUser(String contextPath, User user) {
		ObjectMapper mapper = new ObjectMapper();
	    String path = contextPath + "files\\users.json";

	    users.put(user.getUsername(), user);
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {		    		    
			mapper.writeValue(Paths.get(path).toFile(), users);
			System.out.println("Save: " + Paths.get(path).toFile());
		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
		return user;
	}	
	
	private void loadUsers(String contextPath) {
		try {   
				
			ObjectMapper mapper = new ObjectMapper();
		    BufferedReader in = null;
			try {
			    File file = new File(contextPath + "files\\users.json");
			    in = new BufferedReader(new FileReader(file));
			    Map<String, User> usersMap = mapper.readValue(in, new TypeReference<Map<String, User>>() {}); 		   
			    
			    users = usersMap;

			} catch (Exception ex) {
			    ex.printStackTrace();		    
			}
			

		} catch (Exception ex) {
		    ex.printStackTrace();		    
		}
	}
	
}
