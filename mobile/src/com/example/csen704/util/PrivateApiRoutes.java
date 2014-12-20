package com.example.csen704.util;

import java.util.List;

import com.example.csen704.model.Announcement;
import com.example.csen704.model.Course;

import retrofit.Callback;
import retrofit.http.EncodedPath;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface PrivateApiRoutes {

	@POST("/courses")
	@FormUrlEncoded
	void createCourse(@Field("name") String name, @Field("course_code") String courseCode, @Field("description") String description, Callback<Object> callback);
	
	@GET("/users/{user_id}/courses")
	void getCourses(@Path("user_id") long userId, Callback<List<Course>> callback);
	
	@GET("/courses/{course_id}")
	void getCourseInfo(@Path("course_id") long courseId, Callback<Course> callback);
	
	@GET("/courses/{course_id}/announcements")
	void getCourseAnnouncements(@Path("course_id") long courseId, Callback<List<Announcement>> callback);
	
	@GET("/users/{user_id}/announcements")
	void getUserAnnoucenemnts(@Path("user_id") long userId, Callback<List<Announcement>> callback);
	
	@POST("/courses/{course_id}/announcements")
	@FormUrlEncoded
	void createCourseAnnouncement(@Path("course_id") long courseId, @Field("announcement_body") String announcementBody, Callback<Announcement> callback);
}