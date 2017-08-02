package com.revature.service;

import java.util.List;

import com.revature.domain.Video;

public interface VideoService {
	Video getVideoById(int id);
	public List<Video> getVideosByTag(String tag);
	public List<Video> getVideosByName(String name);
	public List<Video> getVideosByUser(int id);
	public void saveVideo(Video v, int id);
}
