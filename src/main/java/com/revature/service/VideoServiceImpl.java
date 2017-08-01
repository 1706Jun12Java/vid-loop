package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.domain.Video;

@Service("videoService")
public class VideoServiceImpl implements VideoService{

	@Override
	public Video getVideoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideosByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideosByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideosByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveVideo(Video v, int id) {
		// TODO Auto-generated method stub
		
	}

}
