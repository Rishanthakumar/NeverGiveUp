package com.example.rishanthakumarrasarathinam.nevergiveup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishanthakumarrasarathinam on 4/6/16.
 */
public class Posts {
    String name;
    String age;
    int photoId;

    Posts(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }


    private List<Posts> posts;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData() {
        posts = new ArrayList<>();
        posts.add(new Posts("Emma Wilson", "23 years old", R.drawable.logo));
        posts.add(new Posts("Lavery Maiss", "25 years old", R.drawable.star));
        posts.add(new Posts("Lillie Watts", "35 years old", R.drawable.profile));
    }
}