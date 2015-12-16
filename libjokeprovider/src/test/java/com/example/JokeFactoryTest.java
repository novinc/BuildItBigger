package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by novin on 12/15/15.
 */
public class JokeFactoryTest {

    JokeFactory factory;

    @Before
    public void init() {
        factory = new JokeFactory();
    }

    @Test
    public void testMakeJoke() throws Exception {
        String joke = factory.makeJoke();
        assertNotNull(joke);
        assertTrue(joke.length() >= 0);
    }
}