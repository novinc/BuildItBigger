package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokeFactory;
import com.example.jokeactivity.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity implements GetJoke.JokeCallback {

    JokeFactory mJokeFactory;
    InterstitialAd mInterstitialAd;
    String mJoke;
    boolean adShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokeFactory = new JokeFactory();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                adShowing = false;
            }
        });
        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(getString(R.string.s3_test_id))
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unchecked")
    public void tellJoke(View view){
        AsyncTask<MainActivity, Void, String> task = new GetJoke().execute(this);
        new ShowAdAndJoke().execute(task);
    }


    @Override
    public void joke(String joke) {
        Log.v("joke method", "called");
        mJoke = joke;
    }

    private void hideProgressBar() {
        findViewById(R.id.progressbar).setVisibility(View.INVISIBLE);
    }

    private class ShowAdAndJoke extends AsyncTask<AsyncTask<MainActivity, Void, String>, Void, String> {

        @Override
        protected void onPreExecute() {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                adShowing = true;
            } else {
                adShowing = false;
                findViewById(R.id.progressbar).setVisibility(View.VISIBLE);
            }
        }

        @SafeVarargs
        @Override
        protected final String doInBackground(AsyncTask<MainActivity, Void, String>... params) {
            while (params[0].getStatus() == Status.RUNNING) {
                //wait
            }
            String joke = null;
            if (params[0].getStatus() == Status.FINISHED) {
                try {
                    joke = params[0].get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            while (adShowing) {
                // wait
            }
            Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE_TAG, mJoke);
            mJoke = null;
            startActivity(intent);
            return joke;
        }

        @Override
        protected void onPostExecute(String s) {
            hideProgressBar();
        }
    }
}
