package com.revature.dao;

import java.util.List;

import com.revature.domain.Video;

public interface VideoDao {
	public List<Video> listVideos();
	public Video getVideoById(int id);
	public List<Video> getVideosByTag(String tag);
	public List<Video> getVideosByName(String name);
	public List<Video> getVideosByUser(int id);
	public void saveVideo(Video v, int id);
	public List<Video> getAllVideos();
}
