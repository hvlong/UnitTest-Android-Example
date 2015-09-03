package com.ast.unittestdemo;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.ast.unittestdemo.adapter.UserInforAdapter;
import com.ast.unittestdemo.network.Api;
import com.ast.unittestdemo.network.ApiService;
import com.ast.unittestdemo.objects.UserBO;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 27/08/2015.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById(R.id.lvUserInfor)
    protected ListView lvUser;

    private UserInforAdapter mAdapter;

//    public static final String URL_TEST = "http://minna-no-nihongo-kotoba.herokuapp.com";
    public static final String API_GITHUB= "https://api.github.com";


    private Api mApi;

    @AfterViews
    protected void init() {
        mAdapter = new UserInforAdapter(this);
        lvUser.setAdapter(mAdapter);
        getApi().getAllDataUser("swanson", new Callback<List<UserBO>>() {
            @Override
            public void success(List<UserBO> userBOList, Response response) {
                if (userBOList.isEmpty()){
                    displaySadMessage();
                }else {
                    mAdapter.updateData(userBOList);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                displayErrorMessage();
            }
        });

    }

    public Api getApi() {
        if (mApi == null) {
            mApi = ApiService.getService();
        }
        return mApi;
    }

    public void setApi(Api api) {
        mApi = api;
    }

    /**
     * show message when data empty
     */
    private void displaySadMessage() {
        Toast.makeText(MainActivity.this, "No repos :(",
                Toast.LENGTH_LONG).show();
    }

    /**
     * show message error when can't get data from server
     */
    private void displayErrorMessage() {
        Toast.makeText(MainActivity.this, "Failed to retrieve the user's repos.",
                Toast.LENGTH_LONG).show();
    }


}
