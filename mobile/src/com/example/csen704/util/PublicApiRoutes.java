package com.example.csen704.util;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

import com.example.csen704.model.User;

public interface PublicApiRoutes {

	@POST("/sessions")
	@FormUrlEncoded
	void login(@Field("email") String email, @Field("password") String password, Callback<User> callback);

	@POST("/users")
	@FormUrlEncoded
	void register(@Field("email") String email, @Field("name") String name, @Field("password") String password, Callback<Response> callback);



}