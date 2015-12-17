package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.util.concurrent.ExecutionException;

/**
 * Created by novin on 12/16/15.
 */
public class GetJokeTest extends AndroidTestCase{

    GetJoke getJokeTask;

    @Override
    protected void setUp() throws Exception {
        getJokeTask = new GetJoke();
    }

    @MediumTest
    public void testGetJoke() {
        try {
            MainActivity[] activities = null;
            String joke = getJokeTask.execute(activities).get();
            assertNotNull(joke);
            assertTrue(joke.length() >= 0);
        } catch (InterruptedException | ExecutionException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}