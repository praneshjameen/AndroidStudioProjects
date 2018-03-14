package com.example.zeolite.post;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;


public class MainActivity extends AppCompatActivity {
TextView res;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res=findViewById(R.id.result);



    }
    public void Scann(View v){
        Intent i=new Intent(this, BarCode.class);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)
        {
            if(resultCode== CommonStatusCodes.SUCCESS){
                if(data!=null)
                {
                    Barcode ba=data.getParcelableExtra("barcode");
                    res.setText("QR value : "+ba.displayValue );
                }
                else
                {
                    res.setText("No QR found");
                }
            }
        }
        else
        {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}