package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.VideoDaoImpl;
import com.revature.domain.Video;

public class VideoService {
	
	@Autowired
	VideoDaoImpl VD;
	
	public List<Video> getVideos(){
		return VD.listVideos();
	}
	
	public Video getVideoById(int id){
		return VD.getVideoById(id);
	}
}
