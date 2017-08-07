package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.CommentDaoImpl;

public class CommentService {

	@Autowired
	CommentDaoImpl cd;
	
	public void addComment(String comment, int userID, int videoID) {
		cd.addComment(comment, videoID, userID);
	}
}
