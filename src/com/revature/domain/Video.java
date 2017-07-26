package com.revature.domain;

import javax.persistence.*;

@Entity
@Table(name="VL_Videos")
public class Video {

	private int id;
	private User user;
}
