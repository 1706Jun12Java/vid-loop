package com.revature.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody String addVideo(@RequestParam("file") File file, @RequestParam("userID") int id){
		System.out.println("adding video ");
		if (!file.isFile()) {
			VS.saveVideo(file, id);
			return "ok";
		}else {
			return "empty file";
		}
		
	}
}
