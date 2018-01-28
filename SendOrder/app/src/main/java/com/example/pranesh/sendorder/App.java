package com.example.pranesh.sendorder;

import android.app.Application;
import android.content.Intent;

/**
 * Created by PRANESH on 9/10/2017.
 */

public class App extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        startService(new Intent(this,Noti.class));
    }
}
