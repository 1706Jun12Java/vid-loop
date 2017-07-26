package com.revature.domain;

import javax.persistence.*;

@Entity
@Table(name="VL_USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="vl_UserSequence")
	@SequenceGenerator(allocationSize=1,name="vl_UserSequence",sequenceName="VL_USER_SEQ")
	@Column(name="VL_ID")
	private int id;
	
	@Column(name="VL_USERNAME")
	private String username;
	
	@Column(name="VL_PASSWORD")
	private String password;
	
	@Column(name="VL_FIRSTNAME")
	private String firstname;
	
	@Column(name="VL_LASTNAME")
	private String lastname;
	
	@Column(name="VL_EMAIL")
	private String email;

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
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + "]";
	}
	
}
