package com.revature.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<Video> addVideo(@RequestParam("file") File file, @RequestParam("userID") int id, @RequestParam("vidName") String vidName, @RequestParam("tag") String tag){
		System.out.println("adding video ");
		if (!file.isFile()) {
			return ResponseEntity.ok(VS.saveVideo(file, id, vidName, tag));
		}else {
			return null;
		}
		
	}
	@RequestMapping(value="/count", method=RequestMethod.POST)
	public ResponseEntity<Void> incrementCount(@RequestParam("id") int id) {
		VS.incrementCount(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/like", method=RequestMethod.POST)
	public ResponseEntity<Void> incrementLike(@RequestParam("id") int id) {
		VS.incrementLike(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET)
	public @ResponseBody List<Video> getByName(@PathVariable("name") String name){
		return VS.getVideosByName(name);
	}
	
	@RequestMapping(value="/tag/{tag}", method=RequestMethod.GET)
	public @ResponseBody List<Video> getByTag(@PathVariable("tag") String tag){
		return VS.getVideosByTag(tag);
	}
}
