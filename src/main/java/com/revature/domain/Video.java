package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="VL_Videos")
@Component(value="Video")
public class Video implements Serializable {

	private static final long serialVersionUID = 6766627278874071216L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VL_VideoSequence")
	@SequenceGenerator(allocationSize=1,name="VL_VideoSequence",sequenceName="VL_VIDEO_SEQ")
	@Column(name="V_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="V_USER_ID")
	private User v_userId;
	
	@Column(name="V_LINK")
	private String link;
	
	@Column(name="V_VIDNAME")
	private String vidName;
	
	@Column(name="V_LIKES")
	private int likes;
	
	@Column(name="V_LOOPS")
	private int loopCount;
	
	@Column(name="V_TAGS")
	private String tag;
	
	@OneToMany(mappedBy="vid")
	private List<Comment> v_comment;
	
	public List<Comment> getV_comment() {
		return v_comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getV_userId() {
		return v_userId;
	}

	public void setV_userId(User v_user) {
		this.v_userId = v_user;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getVidName() {
		return vidName;
	}

	public void setVidName(String vidName) {
		this.vidName = vidName;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getLoopCount() {
		return loopCount;
	}

	public void setLoopCount(int loopCount) {
		this.loopCount = loopCount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Video(User user, String link, String vidName, int likes, int loopCount, String tag) {
		super();
		this.v_userId = user;
		this.link = link;
		this.vidName = vidName;
		this.likes = likes;
		this.loopCount = loopCount;
		this.tag = tag;
	}

	public Video() {
		super();
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", user=" + v_userId + ", link=" + link + ", vidName=" + vidName + ", likes=" + likes
				+ ", loopCount=" + loopCount + ", tag=" + tag + "]";
	}
	
}
