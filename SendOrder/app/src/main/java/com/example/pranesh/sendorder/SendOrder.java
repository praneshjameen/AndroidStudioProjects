package com.example.pranesh.sendorder;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.id;
import static android.os.Build.ID;

import static com.example.pranesh.sendorder.R.id.eb4;
import static com.example.pranesh.sendorder.R.id.q1;


public class SendOrder extends AppCompatActivity {

    ArrayList<String> Item,Weight,Quantity;
    TextView it1,it2,it3,it4,it5,it6,it7,it8,it9,it10;
    TextView w1,w2,w3,w4,w5,w6,w7,w8,w9,w10;
    TextView q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,o;
    EditText company;
    String n,comp_name="",ID,day,count,SORT,k;
    Integer c;
    Button cancel,send,close;
    ImageView imageb;
    DatabaseReference databaseOrder,sendNoti,com;
    SharedPreferences preferences;
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
public void compName() {
    Noti A = new Noti();
    A.rec(comp_name);
}



    private void sendorder() {

k=databaseOrder.push().getKey();
        ID=day+" ORDER ";
        SORT=k;
        String st="sent";
        String da=new SimpleDateFormat("MMM dd, h:mm a").format(new java.util.Date());
        if(1== Item.size()) {
            order order1 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),"","","","","","","","","","","","","","","","","","","","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order1);
            com.child(SORT).setValue(order1);

        }
        if(2== Item.size()) {
            order order2 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),"","","","","","","","","","","","","","","","","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order2);
            com.child(SORT).setValue(order2);
        }
        if(3== Item.size()) {
            order order3 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),"","","","","","","","","","","","","","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order3);
            com.child(SORT).setValue(order3);
        }
        if(4==Item.size()) {
            order order4 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),"","","","","","","","","","","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order4);
            com.child(SORT).setValue(order4);
        }
        if(5==Item.size()) {
            order order5 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),Item.get(4), Weight.get(4), Quantity.get(4),"","","","","","","","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order5);
            com.child(SORT).setValue(order5);
        }
        if(6==Item.size()) {
            order order6 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),Item.get(4), Weight.get(4), Quantity.get(4),Item.get(5), Weight.get(5), Quantity.get(5),"","","","","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order6);
            com.child(SORT).setValue(order6);
        }
        if(7==Item.size()) {
            order order7 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),Item.get(4), Weight.get(4), Quantity.get(4),Item.get(5), Weight.get(5), Quantity.get(5),Item.get(6), Weight.get(6), Quantity.get(6),"","","","","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order7);
            com.child(SORT).setValue(order7);
        }
        if(8==Item.size()) {
            order order8 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),Item.get(4), Weight.get(4), Quantity.get(4),Item.get(5), Weight.get(5), Quantity.get(5),Item.get(6), Weight.get(6), Quantity.get(6),Item.get(7), Weight.get(7), Quantity.get(7),"","","","","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order8);
            com.child(SORT).setValue(order8);
        }
        if(9==Item.size()) {
            order order9 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),Item.get(4), Weight.get(4), Quantity.get(4),Item.get(5), Weight.get(5), Quantity.get(5),Item.get(6), Weight.get(6), Quantity.get(6),Item.get(7), Weight.get(7), Quantity.get(7),Item.get(8), Weight.get(8), Quantity.get(8),"","","");
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order9);
            com.child(SORT).setValue(order9);
        }
        if(10==Item.size()) {
            order order10 = new order(da,SORT,"NOT SEEN",comp_name,Item.get(0), Weight.get(0), Quantity.get(0),Item.get(1), Weight.get(1), Quantity.get(1),Item.get(2), Weight.get(2), Quantity.get(2),Item.get(3), Weight.get(3), Quantity.get(3),Item.get(4), Weight.get(4), Quantity.get(4),Item.get(5), Weight.get(5), Quantity.get(5),Item.get(6), Weight.get(6), Quantity.get(6),Item.get(7), Weight.get(7), Quantity.get(7),Item.get(8), Weight.get(8), Quantity.get(8),Item.get(9), Weight.get(9), Quantity.get(9));
            sendNoti.child("status").setValue(st);
            databaseOrder.child(SORT).setValue(order10);
            com.child(SORT).setValue(order10);
        }
        Toast.makeText(this,"Order Sent",Toast.LENGTH_SHORT).show();

        Intent no=new Intent(SendOrder.this,notification.class);
        no.putExtra("CompName",comp_name);
        startActivity(no);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);
        Item=new ArrayList<>();
        Weight=new ArrayList<>();
        Quantity=new ArrayList<>();
preferences=getSharedPreferences("PREFS",0);
        Intent i=getIntent();


        Item=i.getStringArrayListExtra("Item");
        Weight=i.getStringArrayListExtra("Weight");
        Quantity=i.getStringArrayListExtra("Quantity");

        databaseOrder = FirebaseDatabase.getInstance().getReference("order").child("orders");
        sendNoti=FirebaseDatabase.getInstance().getReference("order").child("sendNoti");


        it1=(TextView)findViewById(R.id.it1);
        it2=(TextView)findViewById(R.id.it2);
        it3=(TextView)findViewById(R.id.it3);
        it4=(TextView)findViewById(R.id.it4);
        it5=(TextView)findViewById(R.id.it5);
        it6=(TextView)findViewById(R.id.it6);
        it7=(TextView)findViewById(R.id.it7);
        it8=(TextView)findViewById(R.id.it8);
        it9=(TextView)findViewById(R.id.it9);
        it10=(TextView)findViewById(R.id.it10);


        w1=(TextView)findViewById(R.id.w1);
        w2=(TextView)findViewById(R.id.w2);
        w3=(TextView)findViewById(R.id.w3);
        w4=(TextView)findViewById(R.id.w4);
        w5=(TextView)findViewById(R.id.w5);
        w6=(TextView)findViewById(R.id.w6);
        w7=(TextView)findViewById(R.id.w7);
        w8=(TextView)findViewById(R.id.w8);
        w9=(TextView)findViewById(R.id.w9);
        w10=(TextView)findViewById(R.id.w10);

        q1=(TextView)findViewById(R.id.q1);
        q2=(TextView)findViewById(R.id.q2);
        q3=(TextView)findViewById(R.id.q3);
        q4=(TextView)findViewById(R.id.q4);
        q5=(TextView)findViewById(R.id.q5);
        q6=(TextView)findViewById(R.id.q6);
        q7=(TextView)findViewById(R.id.q7);
        q8=(TextView)findViewById(R.id.q8);
        q9=(TextView)findViewById(R.id.q9);
        q10=(TextView)findViewById(R.id.q10);

        company=(EditText) findViewById(R.id.company);
        close=(Button) findViewById(R.id.close);

                o=(TextView) findViewById(R.id.o);
        day=new SimpleDateFormat("MMM dd").format(new java.util.Date());
        o.setText("GK Enterprises, "+day);
        if(0<Item.size()) {
            it1.setText(Item.get(0));
            w1.setText(Weight.get(0));
            q1.setText(Quantity.get(0));
        }

        if(1<Item.size()){
            it2.setText(Item.get(1));
            w2.setText(Weight.get(1));
            q2.setText(Quantity.get(1));
        }


        if(2<Item.size())
        {
            it3.setText(Item.get(2));
            w3.setText(Weight.get(2));
            q3.setText(Quantity.get(2));

        }

        if(3<Item.size())
        {
            it4.setText(Item.get(3));
            w4.setText(Weight.get(3));
            q4.setText(Quantity.get(3));
        }


        if(4<Item.size())
        {
            it5.setText(Item.get(4));
            w5.setText(Weight.get(4));
            q5.setText(Quantity.get(4));
        }


        if(5<Item.size())
        {
            it6.setText(Item.get(5));
            w6.setText(Weight.get(5));
            q6.setText(Quantity.get(5));
        }


        if(6<Item.size()){
            it7.setText(Item.get(6));
            w7.setText(Weight.get(6));
            q7.setText(Quantity.get(6));
        }


        if(7<Item.size())
        {
            it8.setText(Item.get(7));
            w8.setText(Weight.get(7));
            q8.setText(Quantity.get(7));

        }

        if(8<Item.size())
        {
            it9.setText(Item.get(8));
            w9.setText(Weight.get(8));
            q9.setText(Quantity.get(8));
        }


        if(9<Item.size())
        {
            it10.setText(Item.get(9));
            w10.setText(Weight.get(9));
            q10.setText(Quantity.get(9));
        }


        cancel=(Button) findViewById(R.id.cancel);
        send=(Button) findViewById(R.id.send);
        imageb=(ImageView) findViewById(R.id.imageb);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkAvailable())
                {
                    comp_name=company.getText().toString();
                    if(comp_name=="" && comp_name==null)
                    {
                        Toast.makeText(SendOrder.this,"Enter Company Name",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        com=FirebaseDatabase.getInstance().getReference("order").child("company").child(comp_name).child("orders");
                        sendorder();

                    }

                }
                else{
                    Toast.makeText(SendOrder.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
                }

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SendOrder.this,SelectOrder.class);
                startActivity(i);
            }
        });
        imageb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = takeScreenshot();

                saveBitmap(bitmap);


            }
        });

close.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(close.getWindowToken(), 0);
    }
});

    }


    public Bitmap takeScreenshot()
    {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap)
    {
        if(preferences.getString("count","")=="")
        {
            c=1;
            count=c.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("count",count);
            editor.commit();
        }
        else
        {
            count=preferences.getString("count","");
            c=Integer.parseInt(count)+1;
            count=c.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("count",count);
            editor.commit();
        }

        File folders = Environment.getExternalStorageDirectory();
        File folder=new File(folders.getAbsolutePath()+"/GK Enterprises/ScreenShots");
        if(!folder.exists()) {
            folder.mkdirs();
        }

        String extStorageDirectory = folder.toString();
        String today=new SimpleDateFormat("dd").format(new java.util.Date());
        File file = new File(extStorageDirectory, count+"Sent order "+today+".PNG");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(this,"Screenshot Taken !",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }


    }

}
