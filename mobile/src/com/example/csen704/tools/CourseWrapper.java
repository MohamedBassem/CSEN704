package com.example.csen704.tools;

public class CourseWrapper {
	public String name;
	public int id;

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
