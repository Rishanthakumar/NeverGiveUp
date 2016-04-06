package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * Created by rishanthakumarrasarathinam on 3/28/16.
 */
public class GetPosts extends AsyncTask<String,Void,String> {

    public static final String MY_JSON ="MY_JSON";

    private static final String JSON_URL = "http://nevergiveup-rishanthan.rhcloud.com/json";
    Context ctx;

    public GetPosts(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String get_url = "http://nevergiveup-rishanthan.rhcloud.com/json";
        ProgressDialog loading;


        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(get_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String json;
            while((json = bufferedReader.readLine())!= null){
                sb.append(json+"\n");
            }

            return sb.toString().trim();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("SERVER","ok");
        Intent i = new Intent(ctx.getApplicationContext(), MeActivity.class);
        i.putExtra("results", result);
        ctx.startActivity(i);
    }

}