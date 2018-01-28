package com.example.pranesh.gksend;
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
import android.view.View.OnClickListener;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.io.File;




public class MainActivity extends AppCompatActivity {
SharedPreferences preferences;
    String num;
    ImageView im1,im2,im3;
    TextView tx1,tx2,tx3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences("PREFS",0);

        im1=(ImageView) findViewById(R.id.image1);
        im2=(ImageView) findViewById(R.id.image2);
        im3=(ImageView) findViewById(R.id.image3);

        tx1=(TextView) findViewById(R.id.tx1);
        tx2=(TextView) findViewById(R.id.tx2);
        tx3=(TextView) findViewById(R.id.tx3);

        im1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select();
            }
        });
    tx1.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            select();
        }
    });
        im2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                noti();
            }
        });
        tx2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                noti();
            }
        });

        im3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });
        tx3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });

    }


    public void select()
    {
        Intent i=new Intent(MainActivity.this, SelectOrder.class);
        startActivity(i);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void noti()
    {
        if(isNetworkAvailable())
        {
            Intent j=new Intent(MainActivity.this, notification.class);
            startActivity(j);

        }
        else{
            Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }


    }
    public void openFolder()
    {
        num=preferences.getString("orderNum","");
        if(num=="")
        {
            Toast.makeText(this,"Please select a file explorer and click always !",Toast.LENGTH_SHORT).show();
            num="1";
            SharedPreferences.Editor editor1 = preferences.edit();
            editor1.putString("orderNum", num);
            editor1.commit();
        }


        File folder=new File(Environment.getExternalStorageDirectory().getPath()
                + "/GK Enterprises/ScreenShots/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(folder.toString());
        intent.setDataAndType(uri, "*/*");
        startActivity(intent);
    }

}
