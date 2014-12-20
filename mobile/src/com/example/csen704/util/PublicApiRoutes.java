package com.example.csen704.util;


import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

import com.example.csen704.model.User;

public interface PublicApiRoutes {

	@POST("/sessions")
	@FormUrlEncoded
	void login(@Field("username") String username, @Field("fb_token") String fbToken, Callback<User> callback);

}