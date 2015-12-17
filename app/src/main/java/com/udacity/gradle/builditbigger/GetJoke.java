package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.novin.builditbigger.jokepuller.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by novin on 12/16/15.
 */
public class GetJoke extends AsyncTask<MainActivity, Void, String> {

    private static MyApi mApiService = null;
    MainActivity mActivity;

    public interface JokeCallback {
        void joke(String joke);
    }

    @Override
    protected String doInBackground(MainActivity... params) {
        if (params != null) {
            mActivity = params[0];
        }
        if (mApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                                                        new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1162.appspot.com/_ah/api/");
            mApiService = builder.build();
        }
        try {
            return mApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if (mActivity != null) {
            mActivity.joke(s);
        }
    }
}
