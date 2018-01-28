package com.example.pranesh.receiveorder;

import android.app.Activity;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.color.background_dark;
import static android.R.color.black;
import static android.R.color.white;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;


/**
 * Created by PRANESH on 7/15/2017.
 */

public class ordrerList extends ArrayAdapter<order> {

    private Activity context;
    private List<order> OrderList;
    TextView it1,it2,it3,it4,it5,it6,it7,it8,it9,it10;
    TextView w1,w2,w3,w4,w5,w6,w7,w8,w9,w10;
    TextView q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,o,c;
    Button b;
    order Order;
    DatabaseReference receive1,receiveNoti,com;


    public ordrerList(Activity context,List<order> OrderList)
    {

        super(context,R.layout.list,OrderList);
        this.context=context;
        this.OrderList=OrderList;

    }




    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View OrderView=inflater.inflate(R.layout.list,null,true);
        it1=(TextView) OrderView.findViewById(R.id.it1);
        it2=(TextView)OrderView.findViewById(R.id.it2);
        it3=(TextView) OrderView.findViewById(R.id.it3);
        it4=(TextView)OrderView.findViewById(R.id.it4);
        it5=(TextView) OrderView.findViewById(R.id.it5);
        it6=(TextView) OrderView.findViewById(R.id.it6);
        it7=(TextView) OrderView.findViewById(R.id.it7);
        it8=(TextView) OrderView.findViewById(R.id.it8);
        it9=(TextView)OrderView.findViewById(R.id.it9);
        it10=(TextView) OrderView.findViewById(R.id.it10);


        w1=(TextView) OrderView.findViewById(R.id.w1);
        w2=(TextView)OrderView.findViewById(R.id.w2);
        w3=(TextView) OrderView.findViewById(R.id.w3);
        w4=(TextView) OrderView.findViewById(R.id.w4);
        w5=(TextView) OrderView.findViewById(R.id.w5);
        w6=(TextView) OrderView.findViewById(R.id.w6);
        w7=(TextView) OrderView.findViewById(R.id.w7);
        w8=(TextView) OrderView.findViewById(R.id.w8);
        w9=(TextView) OrderView.findViewById(R.id.w9);
        w10=(TextView) OrderView.findViewById(R.id.w10);

        q1=(TextView) OrderView.findViewById(R.id.q1);
        q2=(TextView) OrderView.findViewById(R.id.q2);
        q3=(TextView) OrderView.findViewById(R.id.q3);
        q4=(TextView) OrderView.findViewById(R.id.q4);
        q5=(TextView) OrderView.findViewById(R.id.q5);
        q6=(TextView) OrderView.findViewById(R.id.q6);
        q7=(TextView) OrderView.findViewById(R.id.q7);
        q8=(TextView) OrderView.findViewById(R.id.q8);
        q9=(TextView) OrderView.findViewById(R.id.q9);
        q10=(TextView) OrderView.findViewById(R.id.q10);

        o=(TextView) OrderView.findViewById(R.id.o);

        c=(TextView) OrderView.findViewById(R.id.c);
        b=(Button) OrderView.findViewById(R.id.b);

        Order=OrderList.get(position);
        o.setText(Order.getDa());
        c.setText(Order.getCompn());
        b.setText(Order.getStatus());
        it1.setText(Order.getOrderItem1());
        w1.setText(Order.getOrderKG1());
        q1.setText(Order.getOrderQ1());
        it2.setText(Order.getOrderItem2());
        w2.setText(Order.getOrderKG2());
        q2.setText(Order.getOrderQ2());
        it3.setText(Order.getOrderItem3());
        w3.setText(Order.getOrderKG3());
        q3.setText(Order.getOrderQ3());
        it4.setText(Order.getOrderItem4());
        w4.setText(Order.getOrderKG4());
        q4.setText(Order.getOrderQ4());
        it5.setText(Order.getOrderItem5());
        w5.setText(Order.getOrderKG5());
        q5.setText(Order.getOrderQ5());
        it6.setText(Order.getOrderItem6());
        w6.setText(Order.getOrderKG6());
        q6.setText(Order.getOrderQ6());
        it7.setText(Order.getOrderItem7());
        w7.setText(Order.getOrderKG7());
        q7.setText(Order.getOrderQ7());
        it8.setText(Order.getOrderItem8());
        w8.setText(Order.getOrderKG8());
        q8.setText(Order.getOrderQ8());
        it9.setText(Order.getOrderItem9());
        w9.setText(Order.getOrderKG9());
        q9.setText(Order.getOrderQ9());
        it10.setText(Order.getOrderItem10());
        w10.setText(Order.getOrderKG10());
        q10.setText(Order.getOrderQ10());

        receive1= FirebaseDatabase.getInstance().getReference("order").child("orders").child(Order.getOrderNo()).child("status");
        com=FirebaseDatabase.getInstance().getReference("order").child("company").child(Order.getCompn()).child("orders").child(Order.getOrderNo()).child("status");
        receiveNoti=FirebaseDatabase.getInstance().getReference("order").child("company").child(Order.getCompn()).child("receiveNoti");
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String st="SEEN";
        b.setText(Order.getStatus());
        b.setTextColor(BLACK);
        b.setBackgroundColor(GRAY);
        receiveNoti.child("status").setValue(st);
        receive1.setValue("SEEN");
        com.setValue("SEEN");

    }
});


        return OrderView;

    }


}
