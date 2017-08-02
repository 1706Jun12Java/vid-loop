package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.service.VideoService;
import com.revature.domain.Video;

@RestController
@RequestMapping("/video")
public class VideoController {
	@Autowired
	VideoService VS;

	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<Video> getPersonInfo(){
		return VS.getVideos();
	}
}