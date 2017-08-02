package com.revature.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/")
	public String userIndex(Model m){
		return "static/user.html";
	}

	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String getPersonInfo(Model m){
		return "static/user.html";
	}
}
