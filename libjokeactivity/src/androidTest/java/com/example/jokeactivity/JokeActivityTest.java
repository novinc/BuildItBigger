package com.example.jokeactivity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

/**
 * Created by novin on 12/15/15.
 */
public class JokeActivityTest extends ActivityInstrumentationTestCase2<JokeActivity> {
    private JokeActivity mJokeActivity;
    private TextView mJokeBox;

    public JokeActivityTest() {
        super(JokeActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent();
        intent.putExtra(JokeActivity.JOKE_TAG, "test joke");
        setActivityIntent(intent);
        mJokeActivity = getActivity();
        mJokeBox = (TextView) mJokeActivity.findViewById(R.id.joke_box);
    }

    @MediumTest
    public void testJokeBox() {
        String intentJoke = mJokeActivity.getIntent().getStringExtra(JokeActivity.JOKE_TAG);
        String boxJoke = mJokeBox.getText().toString();
        assertEquals(intentJoke, boxJoke);
    }

}
