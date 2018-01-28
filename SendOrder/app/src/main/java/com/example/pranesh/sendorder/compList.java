package com.example.pranesh.sendorder;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PRANESH on 9/4/2017.
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
        TextView status=(TextView) OrderView.findViewById(R.id.status);
        order Comp=OrderList.get(position);
        Name.setText("Order sent from "+Comp.getCompn()+" at "+ Comp.getDa());
        status.setText(Comp.getStatus());
        return OrderView;
    }
}
