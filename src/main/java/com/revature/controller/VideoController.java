package com.revature.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.service.VideoService;
import com.revature.domain.Video;

@RestController
@RequestMapping("/video")
public class VideoController {

	@RequestMapping(value="/getVideos/",method=RequestMethod.GET)
	public ResponseEntity<List<Video>> getPersonInfo(){
//		List<Video> videos = VideoService.listVideos();
//		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
		return null;
	}
}
