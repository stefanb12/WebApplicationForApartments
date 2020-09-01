package dao;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

public class UserDAO {
	
	private Map<String, User> users = new HashMap<>();	
	
	public UserDAO(String contextPath) {		
		try {
		    ObjectMapper mapper = new ObjectMapper();
		    File file = new File(contextPath + "/users.json"); // ??????
			System.out.println(file.getCanonicalPath());
		    List<User> usersList = Arrays.asList(mapper.readValue(file, User[].class)); // ???
		    
		    // print 
		    usersList.forEach(System.out::println);
		    
		    for(User u : usersList)
		    	users.put(u.getUsername(), u);		    

		} catch (Exception ex) {
		    ex.printStackTrace();
		    
		}
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
	
	public Boolean isUsernameExist(String username) {
		return users.containsKey(username);		
	}
	
	public Collection<User> findAll() {
		return users.values();
	}
	
	public void addUser(User user) throws JsonGenerationException, JsonMappingException, IOException {
		users.put(user.getUsername(), user);
	}
		
		
	
}
