package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class SocialLoginActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private String profileName;
    private ImageView imgView;
    public static final String PREFS_NAME = "MyPrefsFile";
    Intent meIntent;
    SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_login);
        imgView = (ImageView) findViewById(R.id.imageView_main);

        sharedPrefs = getSharedPreferences("details", MODE_PRIVATE);

        meIntent =  new Intent(SocialLoginActivity.this, MainActivity.class);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

        if(hasLoggedIn)
        {
            Intent meIntent = new Intent(SocialLoginActivity.this, MainActivity.class);
            meIntent.putExtra("profileName", profileName);
            startActivity(meIntent);
            finish();
        }
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {


            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                LoginManager.getInstance().logInWithReadPermissions(SocialLoginActivity.this,
                        Arrays.asList("email","user_friends", "user_location", "user_birthday", "user_likes", "user_photos"));

                AccessToken.getCurrentAccessToken().getPermissions();
                GraphRequest request = GraphRequest.newMeRequest(
                        AccessToken.getCurrentAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code

                                String name = object.optString("name");
                                String id = object.optString("id");
                                String link = object.optString("link");

                                String birthday = object.optString("birthday");
                                String email = object.optString("email");

//                                ProfilePictureView pictureView = (ProfilePictureView)findViewById(R.id.profile_image);
//                                pictureView.setProfileId(id);



                                Log.d("Name", name);
                                Log.d("id", id);
                                Log.d("Link", link);
                                Log.d("Birthday",birthday);
                                Log.d("Email", email);

                                SharedPreferences.Editor editor = sharedPrefs.edit();
                                editor.putString("name",name);
                                editor.putString("id",id);
//.. Do the same for other profile data
                                editor.commit();



                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,birthday,email");
                request.setParameters(parameters);
                request.executeAsync();



                viewPage();


                startActivity(meIntent);
                finish();

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); // 0 - for private mode
                SharedPreferences.Editor editor = settings.edit();

//Set "hasLoggedIn" to true
                editor.putBoolean("hasLoggedIn", true);

// Commit the edits!
                editor.commit();

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d("LOGIN", "sdsd", exception);
                Toast.makeText(SocialLoginActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
            }

        });

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


    }

    public void viewPage()
    {
        imgView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent meIntent = new Intent(SocialLoginActivity.this, MainActivity.class);
                        meIntent.putExtra("profileName", profileName);
                        startActivity(meIntent);
                        finish();
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



}
