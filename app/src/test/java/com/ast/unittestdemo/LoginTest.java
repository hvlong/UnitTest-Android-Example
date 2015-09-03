package com.ast.unittestdemo;

import com.ast.unittestdemo.objects.LoginBO;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 27/08/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginTest extends BaseTest {

    private static final String sFileName = "ApiLogin.json";
    private LoginBO mLoginBO;

    @Before
    public void setUp() throws Exception {
        mLoginBO = new Gson().fromJson(readAssetsSampleFile(sFileName), LoginBO.class);
    }

    @Test
    public void shouldDisplaySuccessfullyMessageWithMeta(){
        assertEquals("successfully", mLoginBO.getMetaBO().getStatus());
        assertEquals("200", mLoginBO.getMetaBO().getCode());
    }

    @Test
    public void shouldDisplayUserInforWithUserData(){
        assertEquals("1000", mLoginBO.getDataBO().getUserBO().getId());
        assertEquals("name", mLoginBO.getDataBO().getUserBO().getName());
        assertEquals("full name", mLoginBO.getDataBO().getUserBO().getFullName());
    }
}
