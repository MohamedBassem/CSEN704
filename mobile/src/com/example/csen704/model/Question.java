package com.example.csen704.model;

import java.util.Date;

public class Question {

	private String body;
	private long courseId;
	private long creatorId;
	private String username;
	private Date createdAd;
	private long id;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}
	public Date getCreatedAd() {
		return createdAd;
	}
	public void setCreatedAd(Date createdAd) {
		this.createdAd = createdAd;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	
}
