package com.example.zeolite.social;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.example.zeolite.social.R.id.cap;



/**
 * Created by 1jpra on 2/25/2018.
 */

public class ImageListAdapter extends ArrayAdapter<ImageUpload> {
  private Activity context;
  private int resource;
  private List<ImageUpload> listImage;
    public ImageListAdapter(@NonNull Activity context, int resource, @NonNull List<ImageUpload> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        listImage=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(resource,null);
        TextView name=v.findViewById(R.id.name);
        TextView reg=v.findViewById(R.id.reg);

        ImageView imView=v.findViewById(R.id.im);
        TextView caption= v.findViewById(cap);
        TextView time=v.findViewById(R.id.tim);
        caption.setText(listImage.get(position).getCaption());
        time.setText(listImage.get(position).getTim());
        reg.setText(listImage.get(position).getRegNo());
        name.setText(listImage.get(position).getName());
        Glide.with(context).load(listImage.get(position).getUri()).into(imView);
        return v;

    }

 
}
