package com.ast.unittestdemo.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
public class DataBO {

    @SerializedName("user")
    private UserBO userBO;

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }
}
