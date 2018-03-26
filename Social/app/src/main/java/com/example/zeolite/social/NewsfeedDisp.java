package com.example.zeolite.social;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewsfeedDisp extends AppCompatActivity {
    private DatabaseReference ref;
    private List<ImageUpload> imgList,dest;
    private ListView iv;
    private ImageListAdapter adapter;
    private ImageView pro,Noti;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed_disp);
        imgList=new ArrayList<>();
        iv=findViewById(R.id.list);
        Noti=findViewById(R.id.Noti);
        pro=findViewById(R.id.pro);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait while loading the Newsfeed...");
        progressDialog.show();
        ref= FirebaseDatabase.getInstance().getReference("Posts");
        Noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(NewsfeedDisp.this,Notif.class);
                startActivity(i);
            }
        });
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    ImageUpload img=snapshot.getValue(ImageUpload.class);
                    imgList.add(img);
                }
                dest=reverseListOrder(imgList);
                adapter=new ImageListAdapter(NewsfeedDisp.this,R.layout.image_item,R.layout.video_item,dest);

                iv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(NewsfeedDisp.this,Profile.class);
                startActivity(i);
            }
        });
    }
    private List<ImageUpload> reverseListOrder(List<ImageUpload> orderList) {

        Iterator<ImageUpload> it = orderList.iterator();
        List<ImageUpload> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;

    }
}
