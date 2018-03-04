package com.example.zeolite.social;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Login extends AppCompatActivity {
    public  static SharedPreferences preferences,preferences1,preferences2;

    DatabaseReference database,password1;
    String warning,userId;
    TextView signup;

    EditText usr,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences=getSharedPreferences("PREFS", 0);
        preferences1=getSharedPreferences("PREFS", 0);
        preferences2=getSharedPreferences("PREFS", 0);
        if(status().equals("1"))
        {
            Intent i=new Intent(Login.this,NewsfeedDisp.class);
            startActivity(i);

        }


Button log=findViewById(R.id.login);
signup=findViewById(R.id.signup);
          usr=findViewById(R.id.usr);
       pass=findViewById(R.id.pass);



        final ArrayList<String> arr=new ArrayList<>();
        database = FirebaseDatabase.getInstance().getReference("Registered Users");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    String s=snapshot.getValue(String.class);
                    arr.add(s);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Signin.class);
            startActivity(i);
            }
        });
        final ArrayList<String> arr2=new ArrayList<String>();


        log.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          userId=usr.getText().toString();
            final String password=pass.getText().toString();
            String sp="";


            if(userId.trim().equals(sp) || password.trim().equals(sp))
            {

                warning ="Fields can't be empty";
                Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
            }else if(arr.contains(userId)){


                    password1 = FirebaseDatabase.getInstance().getReference("Login").child(userId).child("Details");
                    password1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren())
                            {
                                Details det=snapshot.getValue(Details.class);
                                arr2.add(det.getPassword());


                            }
                            if(!arr2.contains(password))
                            {

                                warning="Incorrect password";
                                Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
                            }
                            else
                            {

                               DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Login").child(userId).child("Details");

                                ref.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        ArrayList<Details> d=new ArrayList<>();

                                        for(DataSnapshot snapshot:dataSnapshot.getChildren())
                                        {
                                            Details det=snapshot.getValue(Details.class);
                                            d.add(det);
                                        }
                                        for(int i=0;i<d.size();i++)
                                        {
                                            if(!d.get(i).getName().equals("") && d.get(i).getName()!=null)
                                            {loggedIn(userId,d.get(i).getName());}
                                            break;
                                        }

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }});

                                Intent i=new Intent(Login.this,NewsfeedDisp.class);
                                startActivity(i);
                            }

                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            }

           else
            {

                warning ="Not a registered User";
                Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
            }



        }
    });

        }




    public static String status()
    {

        String check = preferences.getString("status", "");
        return check;
    }
    public static String regNo()
    {
        String reg=preferences1.getString("regNo","");
        return reg;
    }
    public static String UsrName()
    {
        String name=preferences2.getString("name","");
        return name;
    }

    public static void loggedIn(String Reg,String nam)
    {
        String regNo=Reg;
        final String name=nam;

        SharedPreferences.Editor editor2 = preferences2.edit();
        editor2.putString("name", name);
        editor2.commit();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("status", "1");
        editor.commit();
        SharedPreferences.Editor editor1 = preferences1.edit();
        editor1.putString("regNo", regNo);
        editor1.commit();

    }
    public static void loggedOut()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("status", "0");
        editor.commit();
    }
}
