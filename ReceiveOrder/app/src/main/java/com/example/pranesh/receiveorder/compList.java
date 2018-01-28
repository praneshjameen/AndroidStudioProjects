package com.example.pranesh.receiveorder;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static com.example.pranesh.receiveorder.R.id.c;
import static com.example.pranesh.receiveorder.R.id.orderLIst;

/**
 * Created by PRANESH on 8/26/2017.
 */

public class compList extends ArrayAdapter<order> {
    private Activity context;
    private List<order> OrderList;

    public compList(Activity context, List<order> OrderList) {
        super(context, R.layout.comp, OrderList);
        this.context = context;
        this.OrderList=OrderList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View OrderView = inflater.inflate(R.layout.comp, null, true);
        TextView Name = (TextView) OrderView.findViewById(R.id.co);
        order Comp=OrderList.get(position);
        Name.setText("Order received from "+Comp.getCompn()+" at "+ Comp.getDa());
        return OrderView;
    }
}