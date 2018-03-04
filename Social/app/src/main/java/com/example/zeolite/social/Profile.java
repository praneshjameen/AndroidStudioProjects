package com.example.zeolite.social;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Profile extends AppCompatActivity {
    private DatabaseReference ref,po;
    private List<ImageUpload> imgList,dest;
    private ListView iv;
    private ImageListAdapter2 adapter;
    private ProgressDialog progressDialog;
    private TextView proReg,proName;
    private ImageView proUpl,proLogout,proNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imgList=new ArrayList<>();
        iv=findViewById(R.id.proLi);
        proReg=findViewById(R.id.proReg);
        proName=findViewById(R.id.proName);
        proUpl=findViewById(R.id.proUpl);
        proLogout=findViewById(R.id.proLogout);
        proNews=findViewById(R.id.proNews);
        final Login a=new Login();
        proReg.setText(a.regNo());
        proName.setText(a.UsrName());
        proLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.loggedOut();
                Intent n=new Intent(Profile.this,Login.class);
                startActivity(n);

            }
        });
        proUpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent n=new Intent(Profile.this,NewsFeed.class);
                startActivity(n);

            }
        });
        proNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Profile.this,NewsfeedDisp.class);
                startActivity(i);
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait while loading your profile...");
        progressDialog.show();
        ref= FirebaseDatabase.getInstance().getReference("Login").child(a.regNo()).child("Posts");
        po= FirebaseDatabase.getInstance().getReference("Posts");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    ImageUpload img=snapshot.getValue(ImageUpload.class);
                    imgList.add(img);
                }
                dest=reverseListOrder(imgList);
                adapter=new ImageListAdapter2(Profile.this,R.layout.image_item2,dest);
                iv.setAdapter(adapter);
                registerForContextMenu(iv);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main2,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo obj=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
            {
                case R.id.del:
                    ImageUpload i=dest.get(obj.position);
                    String push=i.getPushKey();
                    ref.child(push).setValue(null);
                    po.child(push).setValue(null);

                    break;
            }
        return super.onContextItemSelected(item);
    }

    private List<ImageUpload> reverseListOrder(List<ImageUpload> orderList) {

        Iterator<ImageUpload> it = orderList.iterator();
        List<ImageUpload> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;

    }
}
