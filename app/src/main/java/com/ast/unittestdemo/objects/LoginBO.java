package com.ast.unittestdemo.objects;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
public class LoginBO {

    @SerializedName("meta")
    private MetaBO metaBO;

    @SerializedName("data")
    private DataBO dataBO;

    public MetaBO getMetaBO() {
        return metaBO;
    }

    public void setMetaBO(MetaBO metaBO) {
        this.metaBO = metaBO;
    }

    public DataBO getDataBO() {
        return dataBO;
    }

    public void setDataBO(DataBO dataBO) {
        this.dataBO = dataBO;
    }
}
