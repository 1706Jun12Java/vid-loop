package com.revature.dao;

import java.io.File;
import java.util.List;


import com.revature.domain.Video;

public interface VideoDao {
	public List<Video> listVideos();
	public Video getVideoById(int id);
	public List<Video> getVideosByTag(String tag);
	public List<Video> getVideosByName(String name);
	public List<Video> getVideosByUser(int id);
	public Video saveVideo(File file, int id, String vidName, String tag);
	public void incrementCount(int id);
}
