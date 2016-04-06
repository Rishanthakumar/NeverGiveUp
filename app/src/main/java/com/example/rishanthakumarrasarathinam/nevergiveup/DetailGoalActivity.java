package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailGoalActivity extends AppCompatActivity {

    protected String goalTitle;
    private List<Posts> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_goal);

//        goalTitle = getIntent().getStringExtra(GoalsActivity.GOAL_TITLE);
//        TextView tvTitle = (TextView) findViewById(R.id.goalTitle);
//        tvTitle.setText(goalTitle);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);


        posts = new ArrayList<>();
        posts.add(new Posts("Lavery Maiss", "25 years old", R.drawable.star));
        posts.add(new Posts("Lillie Watts", "35 years old", R.drawable.profile));
        posts.add(new Posts("Lavery Maiss", "25 years old", R.drawable.star));
        posts.add(new Posts("Lillie Watts", "35 years old", R.drawable.profile));
        posts.add(new Posts("Lavery Maiss", "25 years old", R.drawable.star));
        posts.add(new Posts("Lillie Watts", "35 years old", R.drawable.profile));
        posts.add(new Posts("Lavery Maiss", "25 years old", R.drawable.star));
        posts.add(new Posts("Lillie Watts", "35 years old", R.drawable.profile));




        RVAdapter adapter = new RVAdapter(posts);
        rv.setAdapter(adapter);

    }


    public void getname(View view) {
        GetPosts gp = new GetPosts(this);
        gp.execute();
    }
}
