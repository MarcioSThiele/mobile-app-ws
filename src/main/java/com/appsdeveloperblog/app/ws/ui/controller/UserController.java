package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	//getting request with page and limit 
	@GetMapping
	public String getUser( @RequestParam ( value="page", defaultValue="1") int page, 
						   @RequestParam ( value="limit", defaultValue="50") int limit,
						   @RequestParam ( value="sort", defaultValue="desc", required=false) String sort){
		
		return "get user was called with params page = " + page + " limit = " + limit + " sort = " + sort;
	}
	
	//getting request with some specific user id
	@GetMapping(path="/{userId}")
	public UserRest getUser(@PathVariable String userId) {
		
		UserRest user = new UserRest();
		
		user.setFirstName("Marcio");
		user.setLastName("Thiele");
		user.setEmail("marcio.sthiele@gmail.com");
		user.setUserId("" + userId);
		
		return user;
	}
	
	
	//POST
	@PostMapping
	public String createUser() {
		return "create user was called...";
	}
	
	//PUT
	@PutMapping
	public String updateUser() {
		return "update user was called...";
	}
	
	//DELETE
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called...";
	}
	
}
	