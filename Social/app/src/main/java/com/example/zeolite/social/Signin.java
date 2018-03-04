package com.example.zeolite.social;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Signin extends AppCompatActivity {
    Login a;
    EditText usr,pass,name,repass;
    Button signin;
    TextView login;
    String reg,nam,p,rp;

    String warning;

    DatabaseReference usrDetails,regUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        usr=findViewById(R.id.usr);
        pass=findViewById(R.id.pass);
        name=findViewById(R.id.name);
        repass=findViewById(R.id.repass);

        signin=findViewById(R.id.signup);
        login=findViewById(R.id.loggin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Signin.this,Login.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reg=usr.getText().toString();
                nam=name.getText().toString();
                p=pass.getText().toString();
                rp=repass.getText().toString();
                String sp="";
                if(reg.trim().equals(sp) || nam.trim().equals(sp) || p.trim().equals(sp) || rp.trim().equals(sp))
                {
                    warning="The fiels can't be empty !";
                    Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
                }

                else if(reg.length()!=12)
                {
                    warning="Enter a Valid Registration Numbeer";
                    Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
                }
                else if(nam.length()<3)
                {
                    warning="The name can't be less than 3 characters !";
                    Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
                }
                else if(p.length()<5)
                {
                    warning="The password must atleast have 5 characters";
                    Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
                }
                else if(!p.equals(rp))
                {
                    warning="The passwords are mismatching !";
                    Toast.makeText(getApplicationContext(),warning,Toast.LENGTH_SHORT).show();
                }

               else
                {
                    Details det=new Details();
                    det.setUserId(reg);
                    det.setName(nam);
                    det.setPassword(p);
                    usrDetails=FirebaseDatabase.getInstance().getReference("Login").child(reg).child("Details");
                    usrDetails.push().setValue(det);
                    regUsers=FirebaseDatabase.getInstance().getReference("Registered Users");
                    regUsers.push().setValue(reg);
                    a=new Login();
                    a.loggedIn(reg,nam);

                    Intent i=new Intent(Signin.this,NewsfeedDisp.class);
                    startActivity(i);
                    //proceed
                }


            }

            private boolean checkReg(String regID) {
                int fl=0;
                for(int i=0;i<regID.length();i++)
                {
                    if(!Character.isDigit(regID.charAt(i)))
                    {
                        fl=1;
                        break;
                    }
                }
                if(fl==1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

        });


    }

}
