package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.revature.domain.Comment;
import com.revature.service.CommentService;

@RestController
@RequestMapping(value="/comment")
public class CommentController {

	@Autowired
	CommentService cs;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Void> createComment(@RequestParam("comment") String comment, @RequestParam("userID") int userID, @RequestParam("videoID") int videoID, UriComponentsBuilder ucBuilder){
		cs.addComment(comment, userID, videoID);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/video/{id}").buildAndExpand(videoID).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
