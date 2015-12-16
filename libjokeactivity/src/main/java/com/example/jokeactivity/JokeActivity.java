package com.example.jokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_TAG = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView jokeBox = (TextView) findViewById(R.id.joke_box);
        String joke = getIntent().getStringExtra(JOKE_TAG);
        jokeBox.setText(joke);
        Log.v(JokeActivity.class.getSimpleName(), "JOKE: " + joke);
    }

}
