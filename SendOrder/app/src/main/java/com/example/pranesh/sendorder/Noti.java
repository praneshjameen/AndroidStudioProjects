package com.example.pranesh.sendorder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by PRANESH on 9/10/2017.
 */

public class Noti extends Service {
    DatabaseReference noti;
    SharedPreferences preferences;
    String comp_name;

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void rec(String s)
    {

        comp_name=s;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("comp",comp_name);
        editor.commit();


    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId)
    {
        preferences=getSharedPreferences("PREFS",0);

        final NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        final Notification notify=new Notification.Builder(getApplicationContext()).setContentTitle("order").setContentText("Your Order has been seen").setContentTitle("GK Enterprises").setSmallIcon(R.drawable.notification).build();
        notify.defaults=notify.DEFAULT_SOUND | notify.DEFAULT_VIBRATE | notify.DEFAULT_LIGHTS;
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        Intent notificationIntent = new Intent(getApplicationContext(),notification.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this.getApplicationContext(), 0, notificationIntent, 0);
        notify.contentIntent = contentIntent;
        comp_name=preferences.getString("comp","");
        if(comp_name != "" && comp_name!=null) {
            noti = FirebaseDatabase.getInstance().getReference("order").child("company").child(comp_name).child("receiveNoti");
            noti.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    notif.notify(0, notify);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        return super.onStartCommand(intent,flags,startId);
    }

}
