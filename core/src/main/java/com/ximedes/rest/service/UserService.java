package com.ximedes.rest.service;

import com.ximedes.rest.model.User;
import com.ximedes.rest.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired UserMapper userMapper;

	public User getUser(int id) {
		return userMapper.getUser(id);
	}

	public User saveUser(User user) {
		userMapper.saveUser(user.getName(), user.getEmail());
		System.out.println("Saved user");
		return user;
	}
}
