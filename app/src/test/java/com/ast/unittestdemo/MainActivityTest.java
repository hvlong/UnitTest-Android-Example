package com.ast.unittestdemo;

import com.ast.unittestdemo.network.Api;
import com.ast.unittestdemo.objects.LoginBO;
import com.ast.unittestdemo.objects.UserBO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.util.ActivityController;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest extends BaseTest {

    private MainActivity mActivity;
    private static final String sFileName = "ApiData.json";

    private ArrayList<UserBO> mUserBOList;

    @Mock
    private Api mockApi;

    @Captor
    private ArgumentCaptor<Callback<List<UserBO>>> cb;

    @Captor
    private ArgumentCaptor<Callback<LoginBO>> callBackLogin;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mUserBOList = new Gson().fromJson(readAssetsSampleFile(sFileName), new TypeToken<ArrayList<UserBO>>() {
        }.getType());
        ActivityController<MainActivity_> controller = Robolectric.buildActivity(MainActivity_.class);
        mActivity = controller.get();
        mActivity.setApi(mockApi);
        controller.create();
    }

    @Test
    public void shouldFillAdapterWithReposFromApi() throws Exception {
        Mockito.verify(mockApi).getAllDataUser(Mockito.anyString(), cb.capture());

        List<UserBO> testRepos = new ArrayList<>();
        testRepos.add(new UserBO("1", "longhv", "Hoang Long"));
        testRepos.add(new UserBO("2", "foo", "foo test"));
        testRepos.add(new UserBO("3", "bar", "bar test"));

        cb.getValue().success(testRepos, null);
        assertEquals(mActivity.lvUser.getAdapter().getCount(), 3);
    }

    @Test
    public void shouldToastSadMessageIfNoRepos() throws Exception {
        Mockito.verify(mockApi).getAllDataUser(Mockito.anyString(), cb.capture());
        List<UserBO> testRepos = new ArrayList<>();

        cb.getValue().success(testRepos, null);
        assertTrue(ShadowToast.getTextOfLatestToast().contains("No repos :("));
        assertTrue(mActivity.lvUser.getAdapter().isEmpty());
    }

    /**
     * @throws Exception
     */
    @Test
    public void shouldToastErrorMessageIfFaiRepos() throws Exception {
        Mockito.verify(mockApi).getAllDataUser(Mockito.anyString(), cb.capture());
        cb.getValue().failure(null);

        assertTrue(ShadowToast.getTextOfLatestToast().contains("Failed"));
    }

    @Test
    public void shouldSuccessStatus() throws Exception {
        assertEquals("9061133", mUserBOList.get(0).getId());
        assertEquals("swanson/7L7W", mUserBOList.get(0).getFullName());
    }

}