package com.example.zeolite.social;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static com.example.zeolite.social.R.id.cap;

/**
 * Created by 1jpra on 3/1/2018.
 */

public class ImageListAdapter2 extends ArrayAdapter<ImageUpload> {
    private Activity context;
    private int resource1, resource2;
    private List<ImageUpload> listImage;

    public ImageListAdapter2(@NonNull Activity context, int resource1, int resource2, @NonNull List<ImageUpload> objects) {
        super(context, resource1, resource2, objects);
        this.context = context;
        this.resource1 = resource1;
        this.resource2 = resource2;
        listImage = objects;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (listImage.get(position).getType() == 1) {
            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource1, null);


            ImageView imView = v.findViewById(R.id.im);
            TextView caption = v.findViewById(cap);
            TextView time = v.findViewById(R.id.tim);
            caption.setText(listImage.get(position).getCaption());
            time.setText(listImage.get(position).getTim());


            Glide.with(context).load(listImage.get(position).getUri()).into(imView);
            return v;
        } else {
            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource2, null);


            VideoView imView = v.findViewById(R.id.im);
            TextView caption = v.findViewById(cap);
            TextView time = v.findViewById(R.id.tim);
            caption.setText(listImage.get(position).getCaption());
            time.setText(listImage.get(position).getTim());
            imView.setVideoURI(Uri.parse(listImage.get(position).getUri()));
            imView.requestFocus();
            imView.start();
            imView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                }
            });
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    return false;
                }
            });


            return v;
        }
    }
}
