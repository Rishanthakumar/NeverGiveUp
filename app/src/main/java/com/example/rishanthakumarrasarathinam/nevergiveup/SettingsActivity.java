package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    ImageView logout_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logout_image = (ImageView) findViewById(R.id.imageView_logout);

        logout();

    }

    public void logout()
    {
        logout_image.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            LoginManager.getInstance().logOut();


                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
                            SharedPreferences.Editor editor = settings.edit();

//Set "hasLoggedIn" to true
                            editor.putBoolean("hasLoggedIn", false);

// Commit the edits!
                            editor.commit();


                            Intent meIntent = new Intent(SettingsActivity.this, SocialLoginActivity.class);
                            startActivity(meIntent);
                            finish();
                        } catch (Exception e)
                        {
                            Toast.makeText(SettingsActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

}
