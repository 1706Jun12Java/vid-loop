package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="VL_COMMENTS")
public class Comment implements Serializable{

	private static final long serialVersionUID = -1405359540644474225L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VL_CommentSequence")
	@SequenceGenerator(allocationSize=1,name="VL_CommentSequence",sequenceName="VL_COMMENT_SEQ")
	@Column(name="C_ID")
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="C_USER_ID")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="C_VID_ID")
	private Video vid;
	
	@Column(name="C_COMMENT")
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonIgnore 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore 
	public Video getVid() {
		return vid;
	}

	public void setVid(Video vid) {
		this.vid = vid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Comment(User user, Video vid, String comment) {
		super();
		this.user = user;
		this.vid = vid;
		this.comment = comment;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user.getFirstname() + ", vid=" + vid.getId() + ", comment=" + comment + "]";
	}
	
	
}
