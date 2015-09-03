package com.ast.unittestdemo.objects;

import com.google.gson.annotations.Expose;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
public class MetaBO {

    @Expose
    private String status;

    @Expose
    private String code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
