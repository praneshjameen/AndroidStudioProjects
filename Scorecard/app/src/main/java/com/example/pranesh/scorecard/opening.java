package com.example.pranesh.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class opening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
    }
    public void Addplayer(View view)
    {
        Intent in=new Intent(this,AddPlayer.class);
        startActivity(in);
}

}