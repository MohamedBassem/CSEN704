package com.example.csen704.tools;

import com.example.csen704.model.Course;

public class CourseWrapper {
	public String name;
	public long id;

	public CourseWrapper(Course course) {
		this.name = course.getName();
		this.id = course.getId();
	}
	
	public CourseWrapper(String courseName, int courseId) {
		super();
		this.name = courseName;
		this.id = courseId;
	}

	@Override
	public String toString(){
		return name;
	}
}
