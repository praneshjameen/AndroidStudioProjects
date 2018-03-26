package com.example.zeolite.social;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static com.example.zeolite.social.R.id.cap;
import static com.example.zeolite.social.R.id.im;


/**
 * Created by 1jpra on 2/25/2018.
 */

public class ImageListAdapter extends ArrayAdapter<ImageUpload> {
  private Activity context;
  private int resource1,resource2;
  private List<ImageUpload> listImage;
    public ImageListAdapter(@NonNull Activity context, int resource1,int resource2, @NonNull List<ImageUpload> objects) {
        super(context, resource1, resource2, objects);
        this.context=context;
        this.resource1=resource1;
        this.resource2=resource2;
        listImage=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(listImage.get(position).getType()==1) {
            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource1, null);
            TextView name = v.findViewById(R.id.name);
            TextView reg = v.findViewById(R.id.reg);

            ImageView imView = v.findViewById(R.id.im);
            TextView caption = v.findViewById(cap);
            TextView time = v.findViewById(R.id.tim);
            caption.setText(listImage.get(position).getCaption());
            time.setText(listImage.get(position).getTim());
            reg.setText(listImage.get(position).getRegNo());
            name.setText(listImage.get(position).getName());
            Glide.with(context).load(listImage.get(position).getUri()).into(imView);
            TextView lik=v.findViewById(R.id.lik);
            TextView sha=v.findViewById(R.id.sha);
          final  int pos=position;
            lik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"you liked this post",Toast.LENGTH_SHORT).show();
                    Calendar c=Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String Dat = df.format(c.getTime());
                    Login a=new Login();
                    String n=a.UsrName()+" liked your Event's post";
                    like l=new like(n,Dat);
                    DatabaseReference not= FirebaseDatabase.getInstance().getReference("Login").child(listImage.get(pos).getRegNo()).child("Notifications");
                    not.push().setValue(l);
                }
            });
            sha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent share=new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    share.putExtra(Intent.EXTRA_SUBJECT,listImage.get(pos).getCaption());
                    share.putExtra(Intent.EXTRA_TEXT, listImage.get(pos).getUri());
                    context.startActivity(Intent.createChooser(share, "Share link!"));

                }
            });

            return v;
        }
        else
        {
            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource2, null);
            TextView name = v.findViewById(R.id.name);
            TextView reg = v.findViewById(R.id.reg);

            VideoView imView = v.findViewById(R.id.im);
            TextView caption = v.findViewById(cap);
            TextView time = v.findViewById(R.id.tim);
            caption.setText(listImage.get(position).getCaption());
            time.setText(listImage.get(position).getTim());
            reg.setText(listImage.get(position).getRegNo());
            name.setText(listImage.get(position).getName());
            imView.setVideoURI(Uri.parse(listImage.get(position).getUri()));
            imView.requestFocus();
            imView.start();
            imView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                }
            });
            TextView lik=v.findViewById(R.id.lik);
            TextView sha=v.findViewById(R.id.sha);
            final int pos=position;
            lik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Calendar c=Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String Dat = df.format(c.getTime());
                    Login a=new Login();
                    String n=a.UsrName()+" liked your Event's video";
                    like l=new like(n,Dat);
                    Toast.makeText(getContext(),"you liked this video",Toast.LENGTH_SHORT).show();

                    DatabaseReference not= FirebaseDatabase.getInstance().getReference("Login").child(listImage.get(pos).getRegNo()).child("Notifications");
                    not.push().setValue(l);
                }
            });
            sha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent share=new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    share.putExtra(Intent.EXTRA_SUBJECT,listImage.get(pos).getCaption());
                    share.putExtra(Intent.EXTRA_TEXT, listImage.get(pos).getUri());
                    context.startActivity(Intent.createChooser(share, "Share link!"));

                }
            });

            //Glide.with(context).load(listImage.get(position).getUri()).into(imView);
            return v;
        }
    }

 
}
