package com.ximedes.rest.service;

import com.ximedes.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

	private static Map<Integer, User> users = new HashMap<>();

	public User getUser(int id) {
		return users.get(id);
	}

	public User saveUser(User user) {
		users.put(users.size(), user);
		System.out.println("Saved user");
		return user;
	}
}
