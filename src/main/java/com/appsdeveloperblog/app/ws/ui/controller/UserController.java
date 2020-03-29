package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;


@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	Map<String, UserRest> users;
	
	//1
	//getting request with page and limit 
	//this get we are using parameters page, limit, sort 
	//this parameters will control the page, limit and sort about the result
	@GetMapping
	public String getUser( @RequestParam ( value="page", defaultValue="1") int page, 
						   @RequestParam ( value="limit", defaultValue="50") int limit,
						   @RequestParam ( value="sort", defaultValue="desc", required=false) String sort){
		
		return "get user was called with params page = " + page + " limit = " + limit + " sort = " + sort;
	}
	
	//2 
	//getting request with some specific user id
	//the parameter produces says that  response will be in xml or json
	@GetMapping(path="/{userId}", 
				produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		/*
		 * UserRest user = new UserRest();
		 * 
		 * user.setFirstName("Marcio"); user.setLastName("Thiele");
		 * user.setEmail("marcio.sthiele@gmail.com"); user.setPassword("" + userId);
		 */
		
		//check if exists de userId on the java memory, if exists return the userId object
		if (users.containsKey(userId)) {
			return new ResponseEntity<> (users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
	}
	
	//3
	//POST
	//the parameter consumes says that require xml or json body
	//the parameter produces says that  response will be in xml or json
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			     produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest>  createUser(@Valid @RequestBody UserDetailsRequestModel userDetail ) {
		
		UserRest user = new UserRest();
		
		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		user.setEmail(userDetail.getEmail());
		user.setPassword("" + userDetail.getPassword());
		
		String userId = UUID.randomUUID().toString();
		
		user.setUserId(userId);
		
		if (users == null) {
			users = new HashMap();
		}
		
		users.put(userId, user);
		
		return new ResponseEntity<UserRest> (user, HttpStatus.OK);
	
	}
	
	//4
	//
	//
	//
	//PUT
	@PutMapping
	public String updateUser() {
		return "update user was called...";
	}
	
	//5
	//
	//
	//
	//DELETE
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called...";
	}
	
}
	