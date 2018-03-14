package com.example.zeolite.social;

import android.app.Application;
import android.content.Intent;

/**
 * Created by 1jpra on 3/6/2018.
 */

public class App extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        startService(new Intent(this,Noti.class));
    }
}