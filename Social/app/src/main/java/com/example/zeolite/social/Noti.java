package com.example.zeolite.social;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

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

        final Notification notify=new Notification.Builder(getApplicationContext()).setContentTitle("order").setContentText("New Event has been Posted").
                setContentTitle("Event Book").setSmallIcon(R.drawable.ebook).build();
        notify.defaults=notify.DEFAULT_SOUND | notify.DEFAULT_VIBRATE | notify.DEFAULT_LIGHTS;
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        Login a=new Login();
        if(a.status().equals("1"))
        {
            Intent notificationIntent = new Intent(getApplicationContext(),NewsfeedDisp.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this.getApplicationContext(), 0, notificationIntent, 0);
            notify.contentIntent = contentIntent;
        }
        else
        {
            Intent notificationIntent = new Intent(getApplicationContext(),Login.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this.getApplicationContext(), 0, notificationIntent, 0);
            notify.contentIntent = contentIntent;
        }

        noti= FirebaseDatabase.getInstance().getReference("Notification");
        noti.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notif.notify(0, notify);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return super.onStartCommand(intent,flags,startId);
    }
}