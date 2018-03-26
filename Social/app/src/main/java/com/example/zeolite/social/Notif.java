package com.example.zeolite.social;

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

public class Notif extends AppCompatActivity {

    List<like> li,dest;
    DatabaseReference not;
    NotiAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        ImageView pro=findViewById(R.id.pro);
        ImageView proNews=findViewById(R.id.news);
        final ListView notiList=findViewById(R.id.notiList);
        li=new ArrayList<like>();
        Login a=new Login();
        dest=new ArrayList<like>();
        not= FirebaseDatabase.getInstance().getReference("Login").child(a.regNo()).child("Notifications");
        not.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    like l=snapshot.getValue(like.class);
                    li.add(l);
                }
                dest=reverseListOrder(li);
                adapt=new NotiAdapter(Notif.this,R.layout.notification,dest);

                notiList.setAdapter(adapt);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Notif.this,Profile.class);
                startActivity(i);
            }
        });

        proNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Notif.this,NewsfeedDisp.class);
                startActivity(i);
            }
        });
    }
    private List<like> reverseListOrder(List<like> orderList) {

        Iterator<like> it = orderList.iterator();
        List<like> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;

    }
}
