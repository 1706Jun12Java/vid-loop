package com.revature.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

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
	
	public Video saveVideo(File file, int id, String vidName, String tag) {
		return VD.saveVideo(file, id, vidName, tag);
	}
	
	public void incrementCount(int id) {
		VD.incrementCount(id);
	}
}
