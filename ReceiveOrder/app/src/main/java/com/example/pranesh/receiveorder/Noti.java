package com.example.pranesh.receiveorder;

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.id.message;
import static android.media.CamcorderProfile.get;

/**
 * Created by PRANESH on 9/9/2017.
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

        final Notification notify=new Notification.Builder(getApplicationContext()).setContentTitle("order").setContentText("You received a New Order").
                setContentTitle("GK Enterprises").setSmallIcon(R.drawable.receive).build();
        notify.defaults=notify.DEFAULT_SOUND | notify.DEFAULT_VIBRATE | notify.DEFAULT_LIGHTS;
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        Intent notificationIntent = new Intent(getApplicationContext(),ReceivedOrder.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this.getApplicationContext(), 0, notificationIntent, 0);
        notify.contentIntent = contentIntent;
        noti= FirebaseDatabase.getInstance().getReference("order").child("sendNoti");
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
