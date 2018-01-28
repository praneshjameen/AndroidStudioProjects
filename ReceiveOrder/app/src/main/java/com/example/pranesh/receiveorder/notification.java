package com.example.pranesh.receiveorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class notification extends AppCompatActivity {
    DatabaseReference receive1;
    ListView complist;
    List<order> comp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        complist=(ListView)findViewById(R.id.complist);
        comp1=new ArrayList<>();
        receive1= FirebaseDatabase.getInstance().getReference("order").child("orders");
    }
    public void home(View view)
    {
        Intent h=new Intent(notification.this,MainActivity.class);
        startActivity(h);
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
    protected void onStart()
    {
        super.onStart();
        receive1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                comp1.clear();
                for(DataSnapshot compa : dataSnapshot.getChildren())
                {
                    order Company=compa.getValue(order.class);

                    comp1.add(Company);
                }
                List<order> dest=reverseListOrder(comp1);
                compList compadapt=new compList(notification.this,dest);
                complist.setAdapter(compadapt);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
