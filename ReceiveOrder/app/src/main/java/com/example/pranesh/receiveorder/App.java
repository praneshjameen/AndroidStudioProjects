package com.example.pranesh.receiveorder;

import android.app.Application;
import android.content.Intent;

/**
 * Created by PRANESH on 9/9/2017.
 */

public class App extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        startService(new Intent(this,Noti.class));
    }
}
