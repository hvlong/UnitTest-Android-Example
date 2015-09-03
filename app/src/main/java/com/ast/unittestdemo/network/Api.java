package com.ast.unittestdemo.network;

import com.ast.unittestdemo.objects.UserBO;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
public interface Api {
    @Headers({
            "X-Mashape-Key : *insert real api key*",
            "Accept: text/plain"
    })

//    @GET("/api/v1/long")
//    void getDataUser(Callback<LoginBO> response);

    @GET("/users/{user}/repos")
    void getAllDataUser(
            @Path("user") String username,
            Callback<List<UserBO>> callback
    );


}
