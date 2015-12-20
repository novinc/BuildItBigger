package com.example;

import java.util.ArrayList;
import java.util.List;

// credit for jokes goes to https://github.com/KiaFathi/tambalAPI
public class JokeFactory {

    List<String> jokes;

    public JokeFactory() {
        jokes = new ArrayList<>();
        jokes.add("Did you hear about the guy whose whole left side was cut off? He\'s all right now.");
        jokes.add("I'm reading a book about anti-gravity. It's impossible to put down.");
        jokes.add("I wondered why the baseball was getting bigger. Then it hit me.");
        jokes.add("It's not that the man did not know how to juggle, he just didn't have the balls to do it.");
        jokes.add("I'm glad I know sign language, it's pretty handy.");
        jokes.add("My friend's bakery burned down last night. Now his business is toast.");
        jokes.add("Why did the cookie cry? It was feeling crumby.");
        jokes.add("I used to be a banker, but I lost interest.");
        jokes.add("A drum and a symbol fall off a cliff");
        jokes.add("Why do seagulls fly over the sea? Because they aren't bay-gulls!");
        jokes.add("Why did the fireman wear red, white, and blue suspenders? To hold his pants up.");
        jokes.add("Why didn't the crab share his food? Because crabs are territorial animals, that don't share anything.");
        jokes.add("Why was the javascript developer sad? Because he didn't Node how to Express himself.");
        jokes.add("What do I look like? A JOKE MACHINE!?");
        jokes.add("How did the hipster burn the roof of his mouth? He ate the pizza before it was cool.");
        jokes.add("Why is it hard to make puns for kleptomaniacs? They are always taking things literally.");
        jokes.add("Why do mermaid wear sea-shells? Because b-shells are too small.");
        jokes.add("I'm a humorless, cold hearted, machine.");
        jokes.add("Two fish in a tank. One looks to the other and says 'Can you even drive this thing???'");
        jokes.add("Two fish swim down a river, and hit a wall. One says: 'Dam!'");
        jokes.add("How did Darth Vader know what Luke was getting for Christmas? He felt his presents.");
        jokes.add("What's red and bad for your teeth? A Brick.");
        jokes.add("What's orange and sounds like a parrot? A Carrot.");
        jokes.add("What do you call a cow with no legs? Ground beef");
        jokes.add("Did you hear about the Mexican train killer?  He had locomotives");
        jokes.add("How many tickles does it take to tickle an octupus? Ten-tickles!");
    }

    public String makeJoke() {
        int rand = (int) (Math.random() * jokes.size());
        return jokes.get(rand);
    }
}
