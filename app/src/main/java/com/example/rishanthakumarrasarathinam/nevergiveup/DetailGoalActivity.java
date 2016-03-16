package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailGoalActivity extends AppCompatActivity {

    protected String goalTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_goal);

        goalTitle = getIntent().getStringExtra(GoalsActivity.GOAL_TITLE);
        TextView tvTitle = (TextView) findViewById(R.id.goalTitle);
        tvTitle.setText(goalTitle);

    }

}
