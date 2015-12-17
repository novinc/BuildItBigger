package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

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

    @SmallTest
    public void testGetJoke() {
        try {
            String joke = getJokeTask.execute((MainActivity[]) null).get();
            assertNotNull(joke);
            assertTrue(joke.length() >= 0);
        } catch (InterruptedException | ExecutionException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}