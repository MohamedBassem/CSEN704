package com.example.csen704.tools;

import android.util.Log;

import com.example.csen704.model.Course;

public class CourseWrapper {
	public String name;
	public long id;

	public CourseWrapper(Course course) {
		this(course.getName(), course.getId());
		Log.v("COURSE_I---D", "" + course.getId());
	}
	
	public CourseWrapper(String courseName, long courseId) {
		super();
		this.name = courseName;
		this.id = courseId;
		
	}

	@Override
	public String toString(){
		return name;
	}
}
