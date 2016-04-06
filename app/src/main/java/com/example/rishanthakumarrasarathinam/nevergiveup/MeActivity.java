package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MeActivity extends AppCompatActivity{

    TextView txtname;
    ProfilePictureView profilePictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        txtname = (TextView) findViewById(R.id.profileName);
        SharedPreferences sharedPrefs = getSharedPreferences("details", MODE_PRIVATE);

        profilePictureView = (ProfilePictureView)findViewById(R.id.profile_image);


        String nameStr = sharedPrefs.getString("name", null);
        String idStr = sharedPrefs.getString("id", null);
        AccessToken token = AccessToken.getCurrentAccessToken();

        if (token != null) {
            if (nameStr != null) {
                txtname.setText(nameStr);

            }
            if(idStr != null) {
                profilePictureView.setProfileId(idStr);
            }
        }
    }


}
