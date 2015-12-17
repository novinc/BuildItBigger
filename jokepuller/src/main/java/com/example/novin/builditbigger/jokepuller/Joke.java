package com.example.novin.builditbigger.jokepuller;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private String mJoke;

    public Joke() {
        this(null);
    }

    public Joke(String joke) {
        mJoke = joke;
    }

    public String getJoke() {
        return mJoke;
    }

    public void setJoke(String joke) {
        mJoke = joke;
    }
}