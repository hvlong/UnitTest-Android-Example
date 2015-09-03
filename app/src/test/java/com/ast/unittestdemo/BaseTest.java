package com.ast.unittestdemo;

import org.apache.maven.artifact.ant.shaded.IOUtil;
import org.junit.Assert;
import org.robolectric.shadows.ShadowApplication;

import java.io.InputStream;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by tientun on 6/5/15.
 */

public class BaseTest {
    public String readAssetsSampleFile(String fileName) throws Exception {
        fileName = "ApiSample/" + fileName;
        ShadowApplication application = ShadowApplication.getInstance();
        Assert.assertNotNull(application);
        InputStream input;
        input = application.getAssets().open(fileName);
        Assert.assertNotNull(input);
        return IOUtil.toString(input, "UTF-8");
    }

}
