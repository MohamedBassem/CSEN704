package com.example.csen704.model;

import java.util.Date;

public class Announcement {

	private long id;
	private String announcementType;
	private String body;
	private Date deadline;
	private long courseId;
	private long creatorId;
	private Date createdAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAnnouncementType() {
		return announcementType;
	}
	public void setAnnouncementType(String announcementType) {
		this.announcementType = announcementType;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createAt) {
		this.createdAt = createAt;
	}
	
	public void setCreatorId(long id) {
		this.creatorId = id;
	}
	public long getCreatorId() {
		return this.creatorId;
	}
	
}
