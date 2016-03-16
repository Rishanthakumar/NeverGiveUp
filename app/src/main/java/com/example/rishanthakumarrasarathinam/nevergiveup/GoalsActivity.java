package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class GoalsActivity extends ActivityGroup {

    protected List<Goal> goal_data;
    public static final String GOAL_TITLE = "goalTitle";
    public static final int DETAIL_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        goal_data = GoalDataProvider.getData();

        ArrayAdapter<Goal> goalArrayAdapter =
                new ArrayAdapter<Goal>(this,android.R.layout.simple_list_item_1, goal_data);

        ListView listView = (ListView) findViewById(R.id.goalListView);
        listView.setAdapter(goalArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Goal goal = goal_data.get(position);
                displayDetail(goal);

            }
        });



    }

    private void displayDetail(Goal goal) {

        Intent intent = new Intent(this, DetailGoalActivity.class);
        intent.putExtra(GOAL_TITLE, goal.getTitle());

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);



        startActivityForResult(intent, DETAIL_REQUEST_CODE);

    }


}
