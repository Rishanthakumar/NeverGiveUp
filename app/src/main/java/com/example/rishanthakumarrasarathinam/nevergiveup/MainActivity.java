package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    public static TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer the tab in the xml file
        tabHost = (TabHost) findViewById(android.R.id.tabhost);

        //create tabs
        TabHost.TabSpec tab1 = tabHost.newTabSpec("1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("2");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("3");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("4");



        //set the tab value and create intents to navigate
        tab1.setIndicator("Me");
        Intent intent = new Intent(MainActivity.this, MeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tab1.setContent(new Intent(intent));

        tab2.setIndicator("Goals");
        Intent intent2 = new Intent(MainActivity.this, GoalsActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tab2.setContent(new Intent(intent2));

        tab3.setIndicator("Settings");
        Intent intent3 = new Intent(MainActivity.this, SettingsActivity.class);
        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tab3.setContent(new Intent(intent3));

        tab4.setIndicator("Help!");
        Intent intent4 = new Intent(MainActivity.this, HelpActivity.class);
        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tab4.setContent(new Intent(intent4));

        //add the tabs to the tabhost
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);

        tabHost.getTabWidget().setBackgroundColor(Color.parseColor("#B7C3D0"));




    }

}
