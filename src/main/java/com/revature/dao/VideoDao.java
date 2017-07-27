package com.revature.dao;

import java.util.List;

import com.revature.domain.Video;

public interface VideoDao {

	public Video getVideosById(int id);
	public List<Video> getVideosByTag(String tag);
	public List<Video> getVideosByName(String name);
	public List<Video> getVideosByUser(int id);
	
}