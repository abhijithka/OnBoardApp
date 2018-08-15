package com.keralastones.onboardapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView homeFeedRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFeedRecyclerView = findViewById(R.id.home_feed_recycler_view);
        List<NewsFeedObject> feedObjects = getFeedObjects();
        homeFeedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeFeedRecyclerView.setAdapter(new NewsFeedRecyclerViewAdapter(this, feedObjects));
    }

    @NonNull
    private List<NewsFeedObject> getFeedObjects() {
        NewsFeedObject feedObject1 = new NewsFeedObject("www.google.com/xx.jpg", "Kerala /Floods", "Un imaginable " +
            "flood in kerala");
        NewsFeedObject feedObject2 = new NewsFeedObject("www.google.com/yy.jpg", "Lord's test", "Un imaginable " +
            "flood in kerala");
        List<NewsFeedObject> feedObjects = new ArrayList<>();
        feedObjects.add(feedObject1);
        feedObjects.add(feedObject2);
        return feedObjects;
    }

    private void navigateToFragment(AppCompatActivity appCompatActivity, boolean addToStack, Fragment fragment,
                                    @IdRes int containerId) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (addToStack) {
            fragmentTransaction.addToBackStack(null);
        }
        try {
            fragmentTransaction
                .replace(containerId, fragment)
                .commit();
        } catch (IllegalStateException e) {
        }
    }
}
