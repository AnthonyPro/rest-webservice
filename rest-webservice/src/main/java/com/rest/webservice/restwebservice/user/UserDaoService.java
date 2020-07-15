package com.rest.webservice.restwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component // of @Repository
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3; 
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Brandon", new Date()));
		users.add(new User(3, "Anthony", new Date()));
	}
	
	// public List<User> findAll() {
	// public User save(User user) {
	// public User findOne(int id) {
	
	
	// findAll() method
	public List<User> findAll(){
		return users; 
	}
	
	// saveOne() method and return user
	public User save (User user) {
		if (user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	// findOne() by id
	public User findOne(int id) {
		for (User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	// deleteById()
	public User deleteById (int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
				if (user.getId() == id) {
					iterator.remove();
					return user;
				}
		}
		return null;
	}
	
}
