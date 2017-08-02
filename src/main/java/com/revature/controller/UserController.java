package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
