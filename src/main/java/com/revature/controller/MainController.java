package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex(Model m){
		return "index";
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String getProfile(Model m){
		return "profile";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String getUpload(Model m){
		return "uploadPage";
	}
}
