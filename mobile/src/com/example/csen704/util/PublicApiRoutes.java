package com.example.csen704.util;


import com.example.csen704.model.User;

import retrofit.Callback;
import retrofit.http.*;

public interface PublicApiRoutes {

	@POST("/sessions")
	@FormUrlEncoded
	void login(@Field("email") String email, @Field("password") String password, Callback<User> callback);

}