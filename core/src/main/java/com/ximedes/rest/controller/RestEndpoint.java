package com.ximedes.rest.controller;

import com.ximedes.rest.model.User;
import com.ximedes.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestEndpoint {

	@Autowired UserService userService;

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable int userId) {
		System.out.println("Retreiving user");
		User user = userService.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> post(@RequestBody User user) {
		System.out.println("Saving user");
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

}
