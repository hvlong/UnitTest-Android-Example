package com.ast.unittestdemo.network;

import com.ast.unittestdemo.MainActivity;

import retrofit.RestAdapter;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
public class ApiService {

    public static Api getService() {
        return new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(MainActivity.API_GITHUB).build().create(Api.class);

    }
}
