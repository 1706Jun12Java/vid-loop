package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.domain.Video;
import com.revature.service.VideoService;

@CrossOrigin
@RestController
@RequestMapping("/video")
public class VideoController {
	@Autowired
	VideoService VS;

	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<Video> getVideos(){
		return VS.getVideos();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Video> getBatByName(@PathVariable("id") int id){
		return ResponseEntity.ok(VS.getVideoById(id));
	}
	
}
