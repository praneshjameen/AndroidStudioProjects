package com.example.pranesh.receiveorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.pranesh.receiveorder.R.id.c;
import static com.example.pranesh.receiveorder.R.id.complist;
import static com.example.pranesh.receiveorder.R.id.orderLIst;

public class ReceivedOrder extends AppCompatActivity {

    DatabaseReference receive;
    ListView orderList;
    List<order> orderl;
    Button back,delete;
    ImageView imageb;
    String n;
    Integer num;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_received_order);
        orderList=(ListView) findViewById(R.id.orderLIst);
        back=(Button) findViewById(R.id.back);
        delete=(Button) findViewById(R.id.delete);
        imageb=(ImageView) findViewById(R.id.imageb);
        orderl=new ArrayList<>();
         preferences=getSharedPreferences("PREFS",0);
        receive= FirebaseDatabase.getInstance().getReference("order").child("orders");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ReceivedOrder.this,MainActivity.class);
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
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder del=new AlertDialog.Builder(ReceivedOrder.this);
                View vdel=getLayoutInflater().inflate(R.layout.delete,null);
                Button cancel=(Button) vdel.findViewById(R.id.cancel);
                Button dele=(Button) vdel.findViewById(R.id.dele);
                del.setView(vdel);
                final AlertDialog Abend=del.create();
                Abend.show();
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });
                dele.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        receive.setValue(null);
                        Abend.dismiss();
                    }
                });
            }
        });
    }
    private List<order> reverseListOrder(List<order> orderList) {

        Iterator<order> it = orderList.iterator();
        List<order> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;

    }

    @Override
    protected void onStart() {
        super.onStart();

        receive.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                orderl.clear();

                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    order Order = orderSnapshot.getValue(order.class);
                    orderl.add(Order);

                }

                List<order> dest=reverseListOrder(orderl);
                ordrerList adapter=new ordrerList(ReceivedOrder.this,dest);
                orderList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    public Bitmap takeScreenshot()
    {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {

        File folders = Environment.getExternalStorageDirectory();
        File folder = new File(folders.getAbsolutePath() + "/GK Enterprises/ScreenShots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String extStorageDirectory = folder.toString();


        n= preferences.getString("num","");
        if(n!="") {
            num = Integer.parseInt(n);
            num = num + 1;


            n = num.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("num", n);
            editor.commit();

        }
        else
        {
            num=1;
            n=num.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("num", n);
            editor.commit();
        }
        String today = new SimpleDateFormat("dd MMM").format(new java.util.Date());
        File file = new File(extStorageDirectory, today+" Received Order "+n+".PNG");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(this, "Screenshot Taken !", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }
}
