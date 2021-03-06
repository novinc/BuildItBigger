/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.novin.builditbigger.jokepuller;

import com.example.JokeFactory;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "jokepuller.builditbigger.novin.example.com",
    ownerName = "jokepuller.builditbigger.novin.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public Joke sayHi(@Named("name") String name) {
        Joke response = new Joke();
        response.setJoke("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        JokeFactory factory = new JokeFactory();
        String jokeString = factory.makeJoke();
        Joke joke = new Joke(jokeString);
        return joke;
    }

}
