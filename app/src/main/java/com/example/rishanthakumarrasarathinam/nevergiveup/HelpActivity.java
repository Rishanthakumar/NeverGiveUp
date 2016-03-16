package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Button btn_setback = (Button) findViewById(R.id.setBack);
        btn_setback.setBackgroundColor(Color.RED);

        Button btn_depression = (Button) findViewById(R.id.depressionButton);
        btn_depression.setBackgroundColor(Color.BLUE);

        Button btn_inspiration = (Button) findViewById(R.id.inspirationButton);
        btn_inspiration.setBackgroundColor(Color.GREEN);

        Button btn_failure = (Button) findViewById(R.id.failureButton);
        btn_failure.setBackgroundColor(Color.parseColor("#8E35EF"));


    }

}
