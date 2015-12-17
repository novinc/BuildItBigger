package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.JokeFactory;
import com.example.jokeactivity.JokeActivity;


public class MainActivity extends AppCompatActivity implements GetJoke.JokeCallback {

    JokeFactory mJokeFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokeFactory = new JokeFactory();
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

    public void tellJoke(View view){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
        new GetJoke().execute(this);
    }


    @Override
    public void joke(String joke) {
        Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_TAG, joke);
        startActivity(intent);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}