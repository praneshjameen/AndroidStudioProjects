package com.example.pranesh.receiveorder;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Toast;



import java.io.File;


public class MainActivity extends AppCompatActivity {
String num;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences("PREFS",0);

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void select(View view)
    {
        if(isNetworkAvailable())
        {
            Intent i=new Intent(MainActivity.this,ReceivedOrder.class);
            startActivity(i);
        }
        else{
            Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }

    }
    public void noti(View view)
    {
        if(isNetworkAvailable())
        {
            Intent j=new Intent(MainActivity.this,notification.class);
            startActivity(j);

        }
        else{
            Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }

    }

}
