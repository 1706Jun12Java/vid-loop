package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.revature.domain.User;
import com.revature.domain.Video;
import com.revature.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserService us;

	
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public ResponseEntity<User> getUserById(@RequestParam("username") String username, @RequestParam("password") String password){
		return ResponseEntity.ok(us.getUser(username,password));
	}
}
	