package com.example.csen704.util;

import java.util.List;

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
	void create_course(@Field("name") String name, @Field("course_code") String courseCode, Callback<Object> callback);
	
	@GET("/users/{user_id}/courses")
	void getCourses(@Path("user_id") long user_id, Callback<List<Course>> callback);
}