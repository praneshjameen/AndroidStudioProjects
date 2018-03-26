package com.example.zeolite.social;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



/**
 * Created by 1jpra on 3/6/2018.
 */

public class Noti extends Service {
    DatabaseReference noti;

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent,int flags,int startId)
    {

        final NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        final Notification[] notify = new Notification[1];
        final Login a=new Login();


        noti= FirebaseDatabase.getInstance().getReference("Login").child(a.regNo()).child("Notifications");
        noti.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            like l=dataSnapshot.getValue(like.class);
                    notify[0] =new Notification.Builder(getApplicationContext()).setContentTitle("Post").setContentText(l.getN()).
                            setContentTitle("Event Book").setSmallIcon(R.drawable.logo).build();
                    notify[0].defaults= notify[0].DEFAULT_SOUND | notify[0].DEFAULT_VIBRATE | notify[0].DEFAULT_LIGHTS;
                    notify[0].flags |= Notification.FLAG_AUTO_CANCEL;
                    if(a.status().equals("1"))
                    {
                        Intent notificationIntent = new Intent(getApplicationContext(),NewsfeedDisp.class);
                        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
                        notify[0].contentIntent = contentIntent;
                    }
                    else
                    {
                        Intent notificationIntent = new Intent(getApplicationContext(),Login.class);
                        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
                        notify[0].contentIntent = contentIntent;
                    }

                    notif.notify(0, notify[0]);


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return super.onStartCommand(intent,flags,startId);
    }
}