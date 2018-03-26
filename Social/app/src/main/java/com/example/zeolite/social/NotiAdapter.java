package com.example.zeolite.social;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static com.example.zeolite.social.R.id.cap;

/**
 * Created by 1jpra on 3/22/2018.
 */

public class NotiAdapter extends ArrayAdapter<like> {
    private Activity context;
    private int resource1;
    private List<like> listImage;
    public NotiAdapter(@NonNull Activity context, int resource1, @NonNull List<like> objects) {
        super(context, resource1, objects);
        this.context=context;
        this.resource1=resource1;

        listImage=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource1, null);
            TextView notif=v.findViewById(R.id.notif);
            TextView timee=v.findViewById(R.id.timee);
            notif.setText(listImage.get(position).getN());
            timee.setText(listImage.get(position).getD());

            return v;
        }
}
