package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="VL_COMMENTS")
@Component(value="Comment")
public class Comment implements Serializable{

	private static final long serialVersionUID = -1405359540644474225L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VL_CommentSequence")
	@SequenceGenerator(allocationSize=1,name="VL_CommentSequence",sequenceName="VL_COMMENT_SEQ")
	@Column(name="C_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="C_USER_ID")
	private User c_user;
	
	@ManyToOne(fetch=FetchType.EAGER)
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

	public User getC_user() {
		return c_user;
	}

	public void setC_user(User c_user) {
		this.c_user = c_user;
	}

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
		this.c_user = user;
		this.vid = vid;
		this.comment = comment;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + c_user + ", vid=" + vid + ", comment=" + comment + "]";
	}
	
	
}
