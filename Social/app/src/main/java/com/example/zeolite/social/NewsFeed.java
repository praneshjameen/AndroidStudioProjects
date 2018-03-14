package com.example.zeolite.social;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewsFeed extends AppCompatActivity {
    StorageReference store;
    DatabaseReference data,post,not;
    ImageView image;
    EditText capt;
    Uri imageU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        store = FirebaseStorage.getInstance().getReference();


        image = findViewById(R.id.image);
        capt=findViewById(R.id.capt);

    }

    public void Browse(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image"), 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1234 && resultCode== RESULT_OK && data!=null &&data.getData()!=null)
        {
imageU=data.getData();
        try {
            Bitmap bm= MediaStore.Images.Media.getBitmap(getContentResolver(),imageU);
            image.setImageBitmap(bm);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        }

    }
    public String getUri(Uri U)
    {
        ContentResolver contentResolver =getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(U));
    }

    public void Upload(View v)
    {
        if(imageU!=null)
        {
            final Calendar c = Calendar.getInstance();
            final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            final ProgressDialog dialog=new ProgressDialog(this);
            dialog.setTitle("Uploading image");
            dialog.show();
            StorageReference ref=store.child("image/"+System.currentTimeMillis()+"."+ getUri(imageU));
            ref.putFile(imageU).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Image Uploaded",Toast.LENGTH_SHORT).show();

                     Login b=new Login();
                     String name=b.UsrName();
                     String reg=b.regNo();
                     String caption=capt.getText().toString();
                    data = FirebaseDatabase.getInstance().getReference("Login").child(reg).child("Posts");
                    String uploadId=data.push().getKey();
                    String Dat = df.format(c.getTime());
                    ImageUpload img=new ImageUpload(name,uploadId,caption,Dat,reg,taskSnapshot.getDownloadUrl().toString());
                     data.child(uploadId).setValue(img);
                    post = FirebaseDatabase.getInstance().getReference("Posts");
                     post.child(uploadId).setValue(img);
                     not=FirebaseDatabase.getInstance().getReference("Notification");
                     not.child("status").setValue("uploaded");
                    Intent i=new Intent(NewsFeed.this,Profile.class);
                    startActivity(i);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                      double progress=(100 *taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                      dialog.setMessage("Uploaded "+(int)progress+"%");
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please select an image",Toast.LENGTH_SHORT).show();
        }
    }
}