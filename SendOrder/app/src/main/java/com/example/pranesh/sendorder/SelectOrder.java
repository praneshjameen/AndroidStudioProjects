package com.example.pranesh.sendorder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.y;
import static android.R.id.empty;

import static com.example.pranesh.sendorder.R.id.eb1;
import static com.example.pranesh.sendorder.R.id.eb11;
import static com.example.pranesh.sendorder.R.id.eb12;
import static com.example.pranesh.sendorder.R.id.eb6;
import static com.example.pranesh.sendorder.R.id.eb7;
import static com.example.pranesh.sendorder.R.id.o;
import static com.example.pranesh.sendorder.R.id.ob6;
import static com.example.pranesh.sendorder.R.id.q1;
import static com.example.pranesh.sendorder.R.id.sb12;
import static com.example.pranesh.sendorder.R.id.sb6;
import static com.example.pranesh.sendorder.R.id.sb7;
import static com.example.pranesh.sendorder.R.id.sb8;
import static com.example.pranesh.sendorder.R.id.tb12;
import static com.example.pranesh.sendorder.R.id.tb6;
import static com.example.pranesh.sendorder.R.id.tb7;
import static com.example.pranesh.sendorder.R.id.w1;


public class SelectOrder extends AppCompatActivity {
Button bend,coupler,offset,longc,reducer,jet,proceed;


    String bi1,bi2,bi3,bi4,bi5,bi6,bi7,bi8,bi9,bi10,bi11,bi12;
    String bw1,bw2,bw3,bw4,bw5,bw6,bw7,bw8,bw9,bw10,bw11,bw12;
    String bq1,bq2,bq3,bq4,bq5,bq6,bq7,bq8,bq9,bq10,bq11,bq12;

    String ci1,ci2,ci3,ci4,ci5,ci6,ci7,ci8,ci9,ci10,ci11,ci12;
    String cw1,cw2,cw3,cw4,cw5,cw6,cw7,cw8,cw9,cw10,cw11,cw12;
    String cq1,cq2,cq3,cq4,cq5,cq6,cq7,cq8,cq9,cq10,cq11,cq12;

    String oi1,oi2,oi3,oi4,oi5,oi6,oi7,oi8,oi9,oi10,oi11,oi12;
    String ow1,ow2,ow3,ow4,ow5,ow6,ow7,ow8,ow9,ow10,ow11,ow12;
    String oq1,oq2,oq3,oq4,oq5,oq6,oq7,oq8,oq9,oq10,oq11,oq12;

    String li1,li2,li3,li4;
    String lw1,lw2,lw3,lw4;
    String lq1,lq2,lq3,lq4;

    String ri1,ri2,ri3,ri4,ri5,ri6;
    String rw1,rw2,rw3,rw4,rw5,rw6;
    String rq1,rq2,rq3,rq4,rq5,rq6;

    String ji1,ji2,ji3,ji4,ji5;
    String jw1,jw2,jw3,jw4,jw5;
    String jq1,jq2,jq3,jq4,jq5;

    ArrayList<String> Item,Weight,Quantity;

    Integer n;
    String orderNum;

    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter1;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter3;
    ArrayAdapter<CharSequence> adapter4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_order);



        final SharedPreferences preferences=getSharedPreferences("PREFS",0);
        final SharedPreferences preferences1=getSharedPreferences("sharePref",MODE_PRIVATE);
        final String[] today=new String[1];
        final String[] current = new String[1];




        Item=new ArrayList<>();
        Weight=new ArrayList<>();
        Quantity=new ArrayList<>();


        bend=(Button) findViewById(R.id.bend);
        coupler=(Button)findViewById(R.id.coupler);
        offset=(Button) findViewById(R.id.offset);
        longc=(Button) findViewById(R.id.longc);
        reducer=(Button) findViewById(R.id.reducer);
        jet=(Button) findViewById(R.id.jet);

        proceed=(Button) findViewById(R.id.proceed);
        adapter=ArrayAdapter.createFromResource(SelectOrder.this,R.array.weightb,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter1=ArrayAdapter.createFromResource(SelectOrder.this,R.array.weightl,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter2=ArrayAdapter.createFromResource(SelectOrder.this,R.array.weightr,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter3=ArrayAdapter.createFromResource(SelectOrder.this,R.array.weightj1,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter4=ArrayAdapter.createFromResource(SelectOrder.this,R.array.weightj2,android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        bend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder Bbend=new AlertDialog.Builder(SelectOrder.this);
                View Vbend=getLayoutInflater().inflate(R.layout.bend,null);
                final TextView tb1=(TextView) Vbend.findViewById(R.id.tb1);
                Spinner  sb1=(Spinner) Vbend.findViewById(R.id.sb1);
                final EditText eb1=(EditText) Vbend.findViewById(R.id.eb1);
                Button ob1=(Button) Vbend.findViewById(R.id.ob1);

                final TextView tb2=(TextView) Vbend.findViewById(R.id.tb2);
                Spinner  sb2=(Spinner) Vbend.findViewById(R.id.sb2);
                final EditText eb2=(EditText) Vbend.findViewById(R.id.eb2);
                Button ob2=(Button) Vbend.findViewById(R.id.ob2);

                final TextView tb3=(TextView) Vbend.findViewById(R.id.tb3);
                Spinner  sb3=(Spinner) Vbend.findViewById(R.id.sb3);
                final EditText eb3=(EditText) Vbend.findViewById(R.id.eb3);
                Button ob3=(Button) Vbend.findViewById(R.id.ob3);

                final TextView tb4=(TextView) Vbend.findViewById(R.id.tb4);
                Spinner  sb4=(Spinner) Vbend.findViewById(R.id.sb4);
                final EditText eb4=(EditText) Vbend.findViewById(R.id.eb4);
                Button ob4=(Button) Vbend.findViewById(R.id.ob4);

                final TextView tb5=(TextView) Vbend.findViewById(R.id.tb5);
                Spinner  sb5=(Spinner) Vbend.findViewById(R.id.sb5);
                final EditText eb5=(EditText) Vbend.findViewById(R.id.eb5);
                Button ob5=(Button) Vbend.findViewById(R.id.ob5);

                final TextView tb6=(TextView) Vbend.findViewById(R.id.tb6);
                Spinner  sb6=(Spinner) Vbend.findViewById(R.id.sb6);
                final EditText eb6=(EditText) Vbend.findViewById(R.id.eb6);
                Button ob6=(Button) Vbend.findViewById(R.id.ob6);

                final TextView tb7=(TextView) Vbend.findViewById(R.id.tb7);
                Spinner  sb7=(Spinner) Vbend.findViewById(R.id.sb7);
                final EditText eb7=(EditText) Vbend.findViewById(R.id.eb7);
                Button ob7=(Button) Vbend.findViewById(R.id.ob7);

                final TextView tb8=(TextView) Vbend.findViewById(R.id.tb8);
                Spinner  sb8=(Spinner) Vbend.findViewById(R.id.sb8);
                final EditText eb8=(EditText) Vbend.findViewById(R.id.eb8);
                Button ob8=(Button) Vbend.findViewById(R.id.ob8);

                final TextView tb9=(TextView) Vbend.findViewById(R.id.tb9);
                Spinner  sb9=(Spinner) Vbend.findViewById(R.id.sb9);
                final EditText eb9=(EditText) Vbend.findViewById(R.id.eb9);
                Button ob9=(Button) Vbend.findViewById(R.id.ob9);

                final TextView tb10=(TextView) Vbend.findViewById(R.id.tb10);
                Spinner  sb10=(Spinner) Vbend.findViewById(R.id.sb10);
                final EditText eb10=(EditText) Vbend.findViewById(R.id.eb10);
                Button ob10=(Button) Vbend.findViewById(R.id.ob10);

                final TextView tb11=(TextView) Vbend.findViewById(R.id.tb11);
                Spinner  sb11=(Spinner) Vbend.findViewById(R.id.sb11);
                final EditText eb11=(EditText) Vbend.findViewById(R.id.eb11);
                Button ob11=(Button) Vbend.findViewById(R.id.ob11);

                final TextView tb12=(TextView) Vbend.findViewById(R.id.tb12);
                Spinner  sb12=(Spinner) Vbend.findViewById(R.id.sb12);
                final EditText eb12=(EditText) Vbend.findViewById(R.id.eb12);
                Button ob12=(Button) Vbend.findViewById(R.id.ob12);

                sb1.setAdapter(adapter);
                sb2.setAdapter(adapter);
                sb3.setAdapter(adapter);
                sb4.setAdapter(adapter);
                sb5.setAdapter(adapter);
                sb6.setAdapter(adapter);
                sb7.setAdapter(adapter);
                sb8.setAdapter(adapter);
                sb9.setAdapter(adapter);
                sb10.setAdapter(adapter);
                sb11.setAdapter(adapter);
                sb12.setAdapter(adapter);

                Button save1=(Button) Vbend.findViewById(R.id.save1);
                Button cancel=(Button) Vbend.findViewById(R.id.cancel);


                sb1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi1=tb1.getText().toString()+" bend";
                        bw1=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq1=eb1.getText().toString();
                        if(bq1.isEmpty())
                        {
                            bq1=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);
                        }
                        else
                        {


                                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi2=tb2.getText().toString()+" bend";
                        bw2=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq2=eb2.getText().toString();
                        if(bq2.isEmpty())
                        {
                            bq2=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi3=tb3.getText().toString()+" bend";
                        bw3=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq3=eb3.getText().toString();
                        if(bq3.isEmpty())
                        {
                            bq3=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi4=tb4.getText().toString()+" bend";
                        bw4=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq4=eb4.getText().toString();
                        if(bq4.isEmpty())
                        {
                            bq4=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi5=tb5.getText().toString()+" bend";
                        bw5=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq5=eb5.getText().toString();
                        if(bq5.isEmpty())
                        {
                            bq5=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi6=tb6.getText().toString()+" bend";
                        bw6=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq6=eb6.getText().toString();
                        if(bq6.isEmpty())
                        {
                            bq6=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi7=tb7.getText().toString()+" bend";
                        bw7=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq7=eb7.getText().toString();
                        if(bq7.isEmpty())
                        {
                            bq7=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb7.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb7.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi8=tb8.getText().toString()+" bend";
                        bw8=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq8=eb8.getText().toString();
                        if(bq8.isEmpty())
                        {
                            bq8=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb8.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb8.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi9=tb9.getText().toString()+" bend";
                        bw9=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq9=eb9.getText().toString();
                        if(bq9.isEmpty())
                        {
                            bq9=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb9.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb9.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi10=tb10.getText().toString()+" bend";
                        bw10=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq10=eb10.getText().toString();
                        if(bq10.isEmpty())
                        {
                            bq10=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb10.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb10.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi11=tb11.getText().toString()+" bend";
                        bw11=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq11=eb11.getText().toString();
                        if(bq11.isEmpty())
                        {
                            bq11=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb11.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb11.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bi12=tb12.getText().toString()+" bend";
                        bw12=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bq12=eb12.getText().toString();
                        if(bq12.isEmpty())
                        {
                            bq12=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb12.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb12.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Bbend.setView(Vbend);
                final AlertDialog Abend=Bbend.create();
                Abend.show();
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });

                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(bq1!=null)
                        {
                            Item.add(bi1);
                            Weight.add(bw1);
                            Quantity.add(bq1);
                        }
                            if(bq2!=null)
                            {
                                Item.add(bi2);
                                Weight.add(bw2);
                                Quantity.add(bq2);
                            }
                            if(bq3!=null)
                            {
                                Item.add(bi3);
                                Weight.add(bw3);
                                Quantity.add(bq3);
                            }
                            if(bq4!=null)
                            {
                                Item.add(bi4);
                                Weight.add(bw4);
                                Quantity.add(bq4);
                            }
                            if(bq5!=null)
                            {
                                Item.add(bi5);
                                Weight.add(bw5);
                                Quantity.add(bq5);
                            }
                            if(bq6!=null)
                            {
                                Item.add(bi6);
                                Weight.add(bw6);
                                Quantity.add(bq6);
                            }
                            if(bq7!=null)
                            {
                                Item.add(bi7);
                                Weight.add(bw7);
                                Quantity.add(bq7);
                            }
                            if(bq8!=null)
                            {
                                Item.add(bi8);
                                Weight.add(bw8);
                                Quantity.add(bq8);
                            }
                            if(bq9!=null)
                            {
                                Item.add(bi9);
                                Weight.add(bw9);
                                Quantity.add(bq9);
                            }
                            if(bq10!=null)
                            {
                                Item.add(bi10);
                                Weight.add(bw10);
                                Quantity.add(bq10);
                            }
                            if(bq11!=null)
                            {
                                Item.add(bi11);
                                Weight.add(bw11);
                                Quantity.add(bq11);
                            }
                            if(bq12!=null)
                            {
                                Item.add(bi12);
                                Weight.add(bw12);
                                Quantity.add(bq12);
                            }
                        if((bq1==null) & (bq2==null) & (bq3==null) & (bq4==null) & (bq5==null) & (bq6==null) & (bq7==null) & (bq8==null) & (bq9==null) & (bq10==null) & (bq11==null) & (bq12==null)){

                            Toast.makeText(SelectOrder.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SelectOrder.this,"SAVED",Toast.LENGTH_SHORT).show();
                            Abend.dismiss();
                        }



                    }
                });







            }
        });

        coupler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder Bbend=new AlertDialog.Builder(SelectOrder.this);
                View Vbend=getLayoutInflater().inflate(R.layout.coupler,null);
                final TextView tb1=(TextView) Vbend.findViewById(R.id.tb1);
                Spinner  sb1=(Spinner) Vbend.findViewById(R.id.sb1);
                final EditText eb1=(EditText) Vbend.findViewById(R.id.eb1);
                Button ob1=(Button) Vbend.findViewById(R.id.ob1);

                final TextView tb2=(TextView) Vbend.findViewById(R.id.tb2);
                Spinner  sb2=(Spinner) Vbend.findViewById(R.id.sb2);
                final EditText eb2=(EditText) Vbend.findViewById(R.id.eb2);
                Button ob2=(Button) Vbend.findViewById(R.id.ob2);

                final TextView tb3=(TextView) Vbend.findViewById(R.id.tb3);
                Spinner  sb3=(Spinner) Vbend.findViewById(R.id.sb3);
                final EditText eb3=(EditText) Vbend.findViewById(R.id.eb3);
                Button ob3=(Button) Vbend.findViewById(R.id.ob3);

                final TextView tb4=(TextView) Vbend.findViewById(R.id.tb4);
                Spinner  sb4=(Spinner) Vbend.findViewById(R.id.sb4);
                final EditText eb4=(EditText) Vbend.findViewById(R.id.eb4);
                Button ob4=(Button) Vbend.findViewById(R.id.ob4);

                final TextView tb5=(TextView) Vbend.findViewById(R.id.tb5);
                Spinner  sb5=(Spinner) Vbend.findViewById(R.id.sb5);
                final EditText eb5=(EditText) Vbend.findViewById(R.id.eb5);
                Button ob5=(Button) Vbend.findViewById(R.id.ob5);

                final TextView tb6=(TextView) Vbend.findViewById(R.id.tb6);
                Spinner  sb6=(Spinner) Vbend.findViewById(R.id.sb6);
                final EditText eb6=(EditText) Vbend.findViewById(R.id.eb6);
                Button ob6=(Button) Vbend.findViewById(R.id.ob6);

                final TextView tb7=(TextView) Vbend.findViewById(R.id.tb7);
                Spinner  sb7=(Spinner) Vbend.findViewById(R.id.sb7);
                final EditText eb7=(EditText) Vbend.findViewById(R.id.eb7);
                Button ob7=(Button) Vbend.findViewById(R.id.ob7);

                final TextView tb8=(TextView) Vbend.findViewById(R.id.tb8);
                Spinner  sb8=(Spinner) Vbend.findViewById(R.id.sb8);
                final EditText eb8=(EditText) Vbend.findViewById(R.id.eb8);
                Button ob8=(Button) Vbend.findViewById(R.id.ob8);

                final TextView tb9=(TextView) Vbend.findViewById(R.id.tb9);
                Spinner  sb9=(Spinner) Vbend.findViewById(R.id.sb9);
                final EditText eb9=(EditText) Vbend.findViewById(R.id.eb9);
                Button ob9=(Button) Vbend.findViewById(R.id.ob9);

                final TextView tb10=(TextView) Vbend.findViewById(R.id.tb10);
                Spinner  sb10=(Spinner) Vbend.findViewById(R.id.sb10);
                final EditText eb10=(EditText) Vbend.findViewById(R.id.eb10);
                Button ob10=(Button) Vbend.findViewById(R.id.ob10);

                final TextView tb11=(TextView) Vbend.findViewById(R.id.tb11);
                Spinner  sb11=(Spinner) Vbend.findViewById(R.id.sb11);
                final EditText eb11=(EditText) Vbend.findViewById(R.id.eb11);
                Button ob11=(Button) Vbend.findViewById(R.id.ob11);

                final TextView tb12=(TextView) Vbend.findViewById(R.id.tb12);
                Spinner  sb12=(Spinner) Vbend.findViewById(R.id.sb12);
                final EditText eb12=(EditText) Vbend.findViewById(R.id.eb12);
                Button ob12=(Button) Vbend.findViewById(R.id.ob12);

                sb1.setAdapter(adapter);
                sb2.setAdapter(adapter);
                sb3.setAdapter(adapter);
                sb4.setAdapter(adapter);
                sb5.setAdapter(adapter);
                sb6.setAdapter(adapter);
                sb7.setAdapter(adapter);
                sb8.setAdapter(adapter);
                sb9.setAdapter(adapter);
                sb10.setAdapter(adapter);
                sb11.setAdapter(adapter);
                sb12.setAdapter(adapter);

                Button save1=(Button) Vbend.findViewById(R.id.save1);
                Button cancel=(Button) Vbend.findViewById(R.id.cancel);


                sb1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci1=tb1.getText().toString()+" coupler";
                        cw1=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq1=eb1.getText().toString();
                        if(cq1.isEmpty())
                        {
                            cq1=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci2=tb2.getText().toString()+" coupler";
                        cw2=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq2=eb2.getText().toString();
                        if(cq2.isEmpty())
                        {
                            cq2=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci3=tb3.getText().toString()+" coupler";
                        cw3=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq3=eb3.getText().toString();
                        if(cq3.isEmpty())
                        {
                            cq3=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci4=tb4.getText().toString()+" coupler";
                        cw4=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq4=eb4.getText().toString();
                        if(cq4.isEmpty())
                        {
                            cq4=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci5=tb5.getText().toString()+" coupler";
                        cw5=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq5=eb5.getText().toString();
                        if(cq5.isEmpty())
                        {
                            cq5=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci6=tb6.getText().toString()+" coupler";
                        cw6=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq6=eb6.getText().toString();
                        if(cq6.isEmpty())
                        {
                            cq6=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci7=tb7.getText().toString()+" coupler";
                        cw7=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq7=eb7.getText().toString();
                        if(cq7.isEmpty())
                        {
                            cq7=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb7.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb7.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci8=tb8.getText().toString()+" coupler";
                        cw8=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq8=eb8.getText().toString();
                        if(cq8.isEmpty())
                        {
                            cq8=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb8.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb8.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci9=tb9.getText().toString()+" coupler";
                        cw9=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq9=eb9.getText().toString();
                        if(cq9.isEmpty())
                        {
                            cq9=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb9.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb9.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci10=tb10.getText().toString()+" coupler";
                        cw10=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq10=eb10.getText().toString();
                        if(cq10.isEmpty())
                        {
                            cq10=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb10.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb10.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci11=tb11.getText().toString()+" coupler";
                        cw11=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq11=eb11.getText().toString();
                        if(cq11.isEmpty())
                        {
                            cq11=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb11.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb11.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ci12=tb12.getText().toString()+" coupler";
                        cw12=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cq12=eb12.getText().toString();
                        if(cq12.isEmpty())
                        {
                            cq12=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb12.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb12.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Bbend.setView(Vbend);
                final AlertDialog Abend=Bbend.create();
                Abend.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });

                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            if(cq1!=null)
                            {
                                Item.add(ci1);
                                Weight.add(cw1);
                                Quantity.add(cq1);
                            }
                            if(cq2!=null)
                            {
                                Item.add(ci2);
                                Weight.add(cw2);
                                Quantity.add(cq2);
                            }
                           if(cq3!=null)
                            {
                                Item.add(ci3);
                                Weight.add(cw3);
                                Quantity.add(cq3);
                            }
                            if(cq4!=null)
                            {
                                Item.add(ci4);
                                Weight.add(cw4);
                                Quantity.add(cq4);
                            }
                            if(cq5!=null)
                            {
                                Item.add(ci5);
                                Weight.add(cw5);
                                Quantity.add(cq5);
                            }
                            if(cq6!=null)
                            {
                                Item.add(ci6);
                                Weight.add(cw6);
                                Quantity.add(cq6);
                            }
                            if(cq7!=null)
                            {
                                Item.add(ci7);
                                Weight.add(cw7);
                                Quantity.add(cq7);
                            }
                            if(cq8!=null)
                            {
                                Item.add(ci8);
                                Weight.add(cw8);
                                Quantity.add(cq8);
                            }
                            if(cq9!=null)
                            {
                                Item.add(ci9);
                                Weight.add(cw9);
                                Quantity.add(cq9);
                            }
                            if(cq10!=null)
                            {
                                Item.add(ci10);
                                Weight.add(cw10);
                                Quantity.add(cq10);
                            }
                            if(cq11!=null)
                            {
                                Item.add(ci11);
                                Weight.add(cw11);
                                Quantity.add(cq11);
                            }
                            if(cq12!=null)
                            {
                                Item.add(ci12);
                                Weight.add(cw12);
                                Quantity.add(cq12);
                            }
                        if((cq1==null) & (cq2==null) & (cq3==null) & (cq4==null) & (cq5==null) & (cq6==null) & (cq7==null) & (cq8==null) & (cq9==null) & (cq10==null) & (cq11==null) & (cq12==null)){

                            Toast.makeText(SelectOrder.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SelectOrder.this,"SAVED",Toast.LENGTH_SHORT).show();
                            Abend.dismiss();
                        }



                    }
                });







            }
        });

        offset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder Bbend=new AlertDialog.Builder(SelectOrder.this);
                View Vbend=getLayoutInflater().inflate(R.layout.offset,null);
                final TextView tb1=(TextView) Vbend.findViewById(R.id.tb1);
                Spinner  sb1=(Spinner) Vbend.findViewById(R.id.sb1);
                final EditText eb1=(EditText) Vbend.findViewById(R.id.eb1);
                Button ob1=(Button) Vbend.findViewById(R.id.ob1);

                final TextView tb2=(TextView) Vbend.findViewById(R.id.tb2);
                Spinner  sb2=(Spinner) Vbend.findViewById(R.id.sb2);
                final EditText eb2=(EditText) Vbend.findViewById(R.id.eb2);
                Button ob2=(Button) Vbend.findViewById(R.id.ob2);

                final TextView tb3=(TextView) Vbend.findViewById(R.id.tb3);
                Spinner  sb3=(Spinner) Vbend.findViewById(R.id.sb3);
                final EditText eb3=(EditText) Vbend.findViewById(R.id.eb3);
                Button ob3=(Button) Vbend.findViewById(R.id.ob3);

                final TextView tb4=(TextView) Vbend.findViewById(R.id.tb4);
                Spinner  sb4=(Spinner) Vbend.findViewById(R.id.sb4);
                final EditText eb4=(EditText) Vbend.findViewById(R.id.eb4);
                Button ob4=(Button) Vbend.findViewById(R.id.ob4);

                final TextView tb5=(TextView) Vbend.findViewById(R.id.tb5);
                Spinner  sb5=(Spinner) Vbend.findViewById(R.id.sb5);
                final EditText eb5=(EditText) Vbend.findViewById(R.id.eb5);
                Button ob5=(Button) Vbend.findViewById(R.id.ob5);

                final TextView tb6=(TextView) Vbend.findViewById(R.id.tb6);
                Spinner  sb6=(Spinner) Vbend.findViewById(R.id.sb6);
                final EditText eb6=(EditText) Vbend.findViewById(R.id.eb6);
                Button ob6=(Button) Vbend.findViewById(R.id.ob6);

                final TextView tb7=(TextView) Vbend.findViewById(R.id.tb7);
                Spinner  sb7=(Spinner) Vbend.findViewById(R.id.sb7);
                final EditText eb7=(EditText) Vbend.findViewById(R.id.eb7);
                Button ob7=(Button) Vbend.findViewById(R.id.ob7);

                final TextView tb8=(TextView) Vbend.findViewById(R.id.tb8);
                Spinner  sb8=(Spinner) Vbend.findViewById(R.id.sb8);
                final EditText eb8=(EditText) Vbend.findViewById(R.id.eb8);
                Button ob8=(Button) Vbend.findViewById(R.id.ob8);

                final TextView tb9=(TextView) Vbend.findViewById(R.id.tb9);
                Spinner  sb9=(Spinner) Vbend.findViewById(R.id.sb9);
                final EditText eb9=(EditText) Vbend.findViewById(R.id.eb9);
                Button ob9=(Button) Vbend.findViewById(R.id.ob9);

                final TextView tb10=(TextView) Vbend.findViewById(R.id.tb10);
                Spinner  sb10=(Spinner) Vbend.findViewById(R.id.sb10);
                final EditText eb10=(EditText) Vbend.findViewById(R.id.eb10);
                Button ob10=(Button) Vbend.findViewById(R.id.ob10);

                final TextView tb11=(TextView) Vbend.findViewById(R.id.tb11);
                Spinner  sb11=(Spinner) Vbend.findViewById(R.id.sb11);
                final EditText eb11=(EditText) Vbend.findViewById(R.id.eb11);
                Button ob11=(Button) Vbend.findViewById(R.id.ob11);

                final TextView tb12=(TextView) Vbend.findViewById(R.id.tb12);
                Spinner  sb12=(Spinner) Vbend.findViewById(R.id.sb12);
                final EditText eb12=(EditText) Vbend.findViewById(R.id.eb12);
                Button ob12=(Button) Vbend.findViewById(R.id.ob12);

                sb1.setAdapter(adapter);
                sb2.setAdapter(adapter);
                sb3.setAdapter(adapter);
                sb4.setAdapter(adapter);
                sb5.setAdapter(adapter);
                sb6.setAdapter(adapter);
                sb7.setAdapter(adapter);
                sb8.setAdapter(adapter);
                sb9.setAdapter(adapter);
                sb10.setAdapter(adapter);
                sb11.setAdapter(adapter);
                sb12.setAdapter(adapter);

                Button save1=(Button) Vbend.findViewById(R.id.save1);
                Button cancel=(Button) Vbend.findViewById(R.id.cancel);


                sb1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi1=tb1.getText().toString()+" offset";
                        ow1=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq1=eb1.getText().toString();
                        if(oq1.isEmpty())
                        {
                            oq1=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi2=tb2.getText().toString()+" offset";
                        ow2=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq2=eb2.getText().toString();
                        if(oq2.isEmpty())
                        {
                            oq2=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi3=tb3.getText().toString()+" offset";
                        ow3=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq3=eb3.getText().toString();
                        if(oq3.isEmpty())
                        {
                            oq3=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi4=tb4.getText().toString()+" offset";
                        ow4=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq4=eb4.getText().toString();
                        if(oq4.isEmpty())
                        {
                            oq4=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi5=tb5.getText().toString()+" offset";
                        ow5=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq5=eb5.getText().toString();
                        if(oq5.isEmpty())
                        {
                            oq5=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi6=tb6.getText().toString()+" offset";
                        ow6=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq6=eb6.getText().toString();
                        if(oq6.isEmpty())
                        {
                            oq6=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi7=tb7.getText().toString()+" offset";
                        ow7=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq7=eb7.getText().toString();
                        if(oq7.isEmpty())
                        {
                            oq7=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb7.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb7.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi8=tb8.getText().toString()+" offset";
                        ow8=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq8=eb8.getText().toString();
                        if(oq8.isEmpty())
                        {
                            oq8=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb8.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb8.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi9=tb9.getText().toString()+" offset";
                        ow9=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq9=eb9.getText().toString();
                        if(oq9.isEmpty())
                        {
                            oq9=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb9.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb9.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi10=tb10.getText().toString()+" offset";
                        ow10=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq10=eb10.getText().toString();
                        if(oq10.isEmpty())
                        {
                            oq10=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb10.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb10.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi11=tb11.getText().toString()+" offset";
                        ow11=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq11=eb11.getText().toString();
                        if(oq11.isEmpty())
                        {
                            oq11=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb11.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb11.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oi12=tb12.getText().toString()+" offset";
                        ow12=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oq12=eb12.getText().toString();
                        if(oq12.isEmpty())
                        {
                            oq12=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb12.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb12.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Bbend.setView(Vbend);
                final AlertDialog Abend=Bbend.create();
                Abend.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });

                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(oq1!=null)
                        {
                            Item.add(oi1);
                            Weight.add(ow1);
                            Quantity.add(oq1);
                        }
                        if(oq2!=null)
                        {
                            Item.add(oi2);
                            Weight.add(ow2);
                            Quantity.add(oq2);
                        }
                        if(oq3!=null)
                        {
                            Item.add(oi3);
                            Weight.add(ow3);
                            Quantity.add(oq3);
                        }
                        if(oq4!=null)
                        {
                            Item.add(oi4);
                            Weight.add(ow4);
                            Quantity.add(oq4);
                        }
                        if(oq5!=null)
                        {
                            Item.add(oi5);
                            Weight.add(ow5);
                            Quantity.add(oq5);
                        }
                        if(oq6!=null)
                        {
                            Item.add(oi6);
                            Weight.add(ow6);
                            Quantity.add(oq6);
                        }
                        if(oq7!=null)
                        {
                            Item.add(oi7);
                            Weight.add(ow7);
                            Quantity.add(oq7);
                        }
                        if(oq8!=null)
                        {
                            Item.add(oi8);
                            Weight.add(ow8);
                            Quantity.add(oq8);
                        }
                        if(oq9!=null)
                        {
                            Item.add(oi9);
                            Weight.add(ow9);
                            Quantity.add(oq9);
                        }
                        if(oq10!=null)
                        {
                            Item.add(oi10);
                            Weight.add(ow10);
                            Quantity.add(oq10);
                        }
                        if(oq11!=null)
                        {
                            Item.add(oi11);
                            Weight.add(ow11);
                            Quantity.add(oq11);
                        }
                        if(oq12!=null)
                        {
                            Item.add(oi12);
                            Weight.add(ow12);
                            Quantity.add(oq12);
                        }
                        if((oq1==null) & (oq2==null) & (oq3==null) & (oq4==null) & (oq5==null) & (oq6==null) & (oq7==null) & (oq8==null) & (oq9==null) & (oq10==null) & (oq11==null) & (oq12==null)){

                            Toast.makeText(SelectOrder.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SelectOrder.this,"SAVED",Toast.LENGTH_SHORT).show();
                            Abend.dismiss();
                        }



                    }
                });







            }
        });
        reducer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder Bbend=new AlertDialog.Builder(SelectOrder.this);
                View Vbend=getLayoutInflater().inflate(R.layout.reducer,null);
                final TextView tb1=(TextView) Vbend.findViewById(R.id.tb1);
                Spinner  sb1=(Spinner) Vbend.findViewById(R.id.sb1);
                final EditText eb1=(EditText) Vbend.findViewById(R.id.eb1);
                Button ob1=(Button) Vbend.findViewById(R.id.ob1);

                final TextView tb2=(TextView) Vbend.findViewById(R.id.tb2);
                Spinner  sb2=(Spinner) Vbend.findViewById(R.id.sb2);
                final EditText eb2=(EditText) Vbend.findViewById(R.id.eb2);
                Button ob2=(Button) Vbend.findViewById(R.id.ob2);

                final TextView tb3=(TextView) Vbend.findViewById(R.id.tb3);
                Spinner  sb3=(Spinner) Vbend.findViewById(R.id.sb3);
                final EditText eb3=(EditText) Vbend.findViewById(R.id.eb3);
                Button ob3=(Button) Vbend.findViewById(R.id.ob3);

                final TextView tb4=(TextView) Vbend.findViewById(R.id.tb4);
                Spinner  sb4=(Spinner) Vbend.findViewById(R.id.sb4);
                final EditText eb4=(EditText) Vbend.findViewById(R.id.eb4);
                Button ob4=(Button) Vbend.findViewById(R.id.ob4);

                final TextView tb5=(TextView) Vbend.findViewById(R.id.tb5);
                Spinner  sb5=(Spinner) Vbend.findViewById(R.id.sb5);
                final EditText eb5=(EditText) Vbend.findViewById(R.id.eb5);
                Button ob5=(Button) Vbend.findViewById(R.id.ob5);

                final TextView tb6=(TextView) Vbend.findViewById(R.id.tb6);
                Spinner  sb6=(Spinner) Vbend.findViewById(R.id.sb6);
                final EditText eb6=(EditText) Vbend.findViewById(R.id.eb6);
                Button ob6=(Button) Vbend.findViewById(R.id.ob6);


                sb1.setAdapter(adapter2);
                sb2.setAdapter(adapter2);
                sb3.setAdapter(adapter2);
                sb4.setAdapter(adapter2);
                sb5.setAdapter(adapter2);
                sb6.setAdapter(adapter2);


                Button save1=(Button) Vbend.findViewById(R.id.save1);
                Button cancel=(Button) Vbend.findViewById(R.id.cancel);


                sb1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ri1=tb1.getText().toString()+" reducer";
                        rw1=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rq1=eb1.getText().toString();
                        if(rq1.isEmpty())
                        {
                            rq1=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ri2=tb2.getText().toString()+" reducer";
                        rw2=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rq2=eb2.getText().toString();
                        if(rq2.isEmpty())
                        {
                            rq2=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ri3=tb3.getText().toString()+" reducer";
                        rw3=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rq3=eb3.getText().toString();
                        if(rq3.isEmpty())
                        {
                            rq3=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ri4=tb4.getText().toString()+" reducer";
                        rw4=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rq4=eb4.getText().toString();
                        if(rq4.isEmpty())
                        {
                            rq4=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ri5=tb5.getText().toString()+" reducer";
                        rw5=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rq5=eb5.getText().toString();
                        if(rq5.isEmpty())
                        {
                            rq5=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ri6=tb6.getText().toString()+" reducer";
                        rw6=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rq6=eb6.getText().toString();
                        if(rq6.isEmpty())
                        {
                            rq6=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb6.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                                Bbend.setView(Vbend);
                final AlertDialog Abend=Bbend.create();
                Abend.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });

                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(rq1!=null)
                        {
                            Item.add(ri1);
                            Weight.add(rw1);
                            Quantity.add(rq1);
                        }
                        if(rq2!=null)
                        {
                            Item.add(ri2);
                            Weight.add(rw2);
                            Quantity.add(rq2);
                        }
                        if(rq3!=null)
                        {
                            Item.add(ri3);
                            Weight.add(rw3);
                            Quantity.add(rq3);
                        }
                        if(rq4!=null)
                        {
                            Item.add(ri4);
                            Weight.add(rw4);
                            Quantity.add(rq4);
                        }
                        if(rq5!=null)
                        {
                            Item.add(ri5);
                            Weight.add(rw5);
                            Quantity.add(rq5);
                        }
                        if(rq6!=null)
                        {
                            Item.add(ri6);
                            Weight.add(rw6);
                            Quantity.add(rq6);
                        }
                        if((rq1==null) & (rq2==null) & (rq3==null) & (rq4==null) & (rq5==null) & (rq6==null)){

                            Toast.makeText(SelectOrder.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SelectOrder.this,"SAVED",Toast.LENGTH_SHORT).show();
                            Abend.dismiss();
                        }



                    }
                });
            }
        });
        jet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder Bbend=new AlertDialog.Builder(SelectOrder.this);
                View Vbend=getLayoutInflater().inflate(R.layout.jet,null);
                final TextView tb1=(TextView) Vbend.findViewById(R.id.tb1);
                Spinner  sb1=(Spinner) Vbend.findViewById(R.id.sb1);
                final EditText eb1=(EditText) Vbend.findViewById(R.id.eb1);
                Button ob1=(Button) Vbend.findViewById(R.id.ob1);

                final TextView tb2=(TextView) Vbend.findViewById(R.id.tb2);
                Spinner  sb2=(Spinner) Vbend.findViewById(R.id.sb2);
                final EditText eb2=(EditText) Vbend.findViewById(R.id.eb2);
                Button ob2=(Button) Vbend.findViewById(R.id.ob2);

                final TextView tb3=(TextView) Vbend.findViewById(R.id.tb3);
                Spinner  sb3=(Spinner) Vbend.findViewById(R.id.sb3);
                final EditText eb3=(EditText) Vbend.findViewById(R.id.eb3);
                Button ob3=(Button) Vbend.findViewById(R.id.ob3);

                final TextView tb4=(TextView) Vbend.findViewById(R.id.tb4);
                Spinner  sb4=(Spinner) Vbend.findViewById(R.id.sb4);
                final EditText eb4=(EditText) Vbend.findViewById(R.id.eb4);
                Button ob4=(Button) Vbend.findViewById(R.id.ob4);

                final TextView tb5=(TextView) Vbend.findViewById(R.id.tb5);
                Spinner  sb5=(Spinner) Vbend.findViewById(R.id.sb5);
                final EditText eb5=(EditText) Vbend.findViewById(R.id.eb5);
                Button ob5=(Button) Vbend.findViewById(R.id.ob5);




                sb1.setAdapter(adapter3);
                sb2.setAdapter(adapter3);
                sb3.setAdapter(adapter3);
                sb4.setAdapter(adapter4);
                sb5.setAdapter(adapter4);



                Button save1=(Button) Vbend.findViewById(R.id.save1);
                Button cancel=(Button) Vbend.findViewById(R.id.cancel);


                sb1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ji1=tb1.getText().toString()+" jet nipple";
                        jw1=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        jq1=eb1.getText().toString();
                        if(jq1.isEmpty())
                        {
                            jq1=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ji2=tb2.getText().toString()+" jet nipple";
                        jw2=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        jq2=eb2.getText().toString();
                        if(jq2.isEmpty())
                        {
                            jq2=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ji3=tb3.getText().toString()+" jet nipple";
                        jw3=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        jq3=eb3.getText().toString();
                        if(jq3.isEmpty())
                        {
                            jq3=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ji4=tb4.getText().toString()+" jet nipple";
                        jw4=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        jq4=eb4.getText().toString();
                        if(jq4.isEmpty())
                        {
                            jq4=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ji5=tb5.getText().toString()+" jet nipple";
                        jw5=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        jq5=eb5.getText().toString();
                        if(jq5.isEmpty())
                        {
                            jq5=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb5.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Bbend.setView(Vbend);
                final AlertDialog Abend=Bbend.create();
                Abend.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });

                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(jq1!=null)
                        {
                            Item.add(ji1);
                            Weight.add(jw1);
                            Quantity.add(jq1);
                        }
                        if(jq2!=null)
                        {
                            Item.add(ji2);
                            Weight.add(jw2);
                            Quantity.add(jq2);
                        }
                        if(jq3!=null)
                        {
                            Item.add(ji3);
                            Weight.add(jw3);
                            Quantity.add(jq3);
                        }
                        if(jq4!=null)
                        {
                            Item.add(ji4);
                            Weight.add(jw4);
                            Quantity.add(jq4);
                        }
                        if(jq5!=null)
                        {
                            Item.add(ji5);
                            Weight.add(jw5);
                            Quantity.add(jq5);
                        }

                        if((jq1==null) & (jq2==null) & (jq3==null) & (jq4==null) & (jq5==null)){

                            Toast.makeText(SelectOrder.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SelectOrder.this,"SAVED",Toast.LENGTH_SHORT).show();
                            Abend.dismiss();
                        }



                    }
                });
            }
        });
        longc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder Bbend=new AlertDialog.Builder(SelectOrder.this);
                View Vbend=getLayoutInflater().inflate(R.layout.longc,null);
                final TextView tb1=(TextView) Vbend.findViewById(R.id.tb1);
                Spinner  sb1=(Spinner) Vbend.findViewById(R.id.sb1);
                final EditText eb1=(EditText) Vbend.findViewById(R.id.eb1);
                Button ob1=(Button) Vbend.findViewById(R.id.ob1);

                final TextView tb2=(TextView) Vbend.findViewById(R.id.tb2);
                Spinner  sb2=(Spinner) Vbend.findViewById(R.id.sb2);
                final EditText eb2=(EditText) Vbend.findViewById(R.id.eb2);
                Button ob2=(Button) Vbend.findViewById(R.id.ob2);

                final TextView tb3=(TextView) Vbend.findViewById(R.id.tb3);
                Spinner  sb3=(Spinner) Vbend.findViewById(R.id.sb3);
                final EditText eb3=(EditText) Vbend.findViewById(R.id.eb3);
                Button ob3=(Button) Vbend.findViewById(R.id.ob3);

                final TextView tb4=(TextView) Vbend.findViewById(R.id.tb4);
                Spinner  sb4=(Spinner) Vbend.findViewById(R.id.sb4);
                final EditText eb4=(EditText) Vbend.findViewById(R.id.eb4);
                Button ob4=(Button) Vbend.findViewById(R.id.ob4);






                sb1.setAdapter(adapter1);
                sb2.setAdapter(adapter1);
                sb3.setAdapter(adapter1);
                sb4.setAdapter(adapter1);




                Button save1=(Button) Vbend.findViewById(R.id.save1);
                Button cancel=(Button) Vbend.findViewById(R.id.cancel);


                sb1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        li1=tb1.getText().toString()+" long coupler";
                        lw1=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lq1=eb1.getText().toString();
                        if(lq1.isEmpty())
                        {
                            lq1=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb1.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        li2=tb2.getText().toString()+" long coupler";
                        lw2=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lq2=eb2.getText().toString();
                        if(lq2.isEmpty())
                        {
                            lq2=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb2.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        li3=tb3.getText().toString()+" long coupler";
                        lw3=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lq3=eb3.getText().toString();
                        if(lq3.isEmpty())
                        {
                            lq3=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb3.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                sb4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        li4=tb4.getText().toString()+" long coupler";
                        lw4=(String) parent.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                ob4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lq4=eb4.getText().toString();
                        if(lq4.isEmpty())
                        {
                            lq4=null;
                            Toast.makeText(SelectOrder.this,"Quantity is missing!",Toast.LENGTH_SHORT).show();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);
                        }
                        else
                        {


                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(eb4.getWindowToken(), 0);


                            Toast.makeText(SelectOrder.this,"SELECTED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                Bbend.setView(Vbend);
                final AlertDialog Abend=Bbend.create();
                Abend.show();

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Abend.dismiss();
                    }
                });

                save1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(lq1!=null)
                        {
                            Item.add(li1);
                            Weight.add(lw1);
                            Quantity.add(lq1);
                        }
                        if(lq2!=null)
                        {
                            Item.add(li2);
                            Weight.add(lw2);
                            Quantity.add(lq2);
                        }
                        if(lq3!=null)
                        {
                            Item.add(li3);
                            Weight.add(lw3);
                            Quantity.add(lq3);
                        }
                        if(lq4!=null)
                        {
                            Item.add(li4);
                            Weight.add(lw4);
                            Quantity.add(lq4);
                        }


                        if((lq1==null) & (lq2==null) & (lq3==null) & (lq4==null)){

                            Toast.makeText(SelectOrder.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SelectOrder.this,"SAVED",Toast.LENGTH_SHORT).show();
                            Abend.dismiss();
                        }



                    }
                });
            }
        });




        proceed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent i=new Intent(SelectOrder.this,SendOrder.class);


        i.putStringArrayListExtra("Item",Item);
        i.putStringArrayListExtra("Weight",Weight);
        i.putStringArrayListExtra("Quantity",Quantity);
        startActivity(i);
    }
});

    }

    public void home(View view)
    {
        Intent h=new Intent(SelectOrder.this,MainActivity.class);
        startActivity(h);
    }

}
