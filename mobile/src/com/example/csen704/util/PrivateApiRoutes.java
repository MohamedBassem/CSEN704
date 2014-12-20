package com.example.csen704.util;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import com.example.csen704.model.Announcement;
import com.example.csen704.model.Answer;
import com.example.csen704.model.Course;
import com.example.csen704.model.Question;

public interface PrivateApiRoutes {

	@POST("/courses")
	@FormUrlEncoded
	void createCourse(@Field("name") String name, @Field("course_code") String courseCode, @Field("description") String description, Callback<Object> callback);

	@POST("/courses/{id}/subscribe")
	void subscribeCourse(@Path("id") long id, Callback<Response> callback);

	@GET("/courses")
	void getAllCourses(Callback<List<Course>> callback);

	@GET("/users/{user_id}/courses")
	void getCourses(@Path("user_id") long userId, Callback<List<Course>> callback);

	@GET("/courses/{course_id}")
	void getCourseInfo(@Path("course_id") long courseId, Callback<Course> callback);

	@GET("/courses/{course_id}/announcements")
	void getCourseAnnouncements(@Path("course_id") long courseId, Callback<List<Announcement>> callback);

	@GET("/users/{user_id}/announcements")
	void getUserAnnoucenemnts(@Path("user_id") long userId, Callback<List<Announcement>> callback);


	@GET("/users/{user_id}/questions")
	void getUserQuestions(@Path("user_id") long userId, Callback<List<Question>> callback);

	@GET("/courses/{course_id}/questions")
	void getCourseQuestions(@Path("course_id") long courseId, Callback<List<Question>> callback);

	@POST("/courses/{course_id}/questions")
	@FormUrlEncoded
	void createCourseQuestion(@Path("course_id") long courseId, @Field("body") String announcementBody, Callback<Question> callback);

	@POST("/courses/{course_id}/announcements")
	@FormUrlEncoded
	void createCourseAnnouncement(@Path("course_id") long courseId, @Field("announcement_body") String announcementBody, Callback<Announcement> callback);


	@POST("/courses/{course_id}/questions/{question_id}/answers")
	@FormUrlEncoded
	void createAnswer(@Path("course_id") long courseId, @Path("question_id") long questionId, @Field("body") String body , @Field("user_id") long userId ,Callback<Answer> callback);

	@GET("/courses/{course_id}/questions/{question_id}/answers")
	void getAnswers(@Path("course_id") long courseId, @Path("question_id") long questionId, Callback<List<Answer>> callback);


	@POST("/courses/{course_id}/questions/{question_id}/rating")
	@FormUrlEncoded
	void rateQuestion(@Path("course_id") long courseId, @Path("question_id") long questionId, @Field("rating") long rating, Callback<Response> callback);

}