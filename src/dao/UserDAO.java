package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import beans.User;

public class UserDAO {
	
	private Map<String, User> users = new HashMap<>();	
	
	public UserDAO() {		
		users.put("pera", new User("pera", "pera1", "pera", "peric", true, beans.Role.GUEST));
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
	
}
