package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="VL_USER")
public class User implements Serializable{

	private static final long serialVersionUID = -627439066941063887L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VL_UserSequence")
	@SequenceGenerator(allocationSize=1,name="VL_UserSequence",sequenceName="VL_USER_SEQ")
	@Column(name="U_ID")
	private int id;
	
	@Column(name="U_USERNAME")
	private String username;
	
	@Column(name="U_PASSWORD")
	private String password;
	
	@Column(name="U_FIRSTNAME")
	private String firstname;
	
	@Column(name="U_LASTNAME")
	private String lastname;
	
	@Column(name="U_EMAIL")
	private String email;
	
	@JsonIgnore 
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Video> videos;

	
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String password, String firstname, String lastname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username +  ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + "]";
	}
	
}
