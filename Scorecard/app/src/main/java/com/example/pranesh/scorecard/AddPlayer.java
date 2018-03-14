package com.example.pranesh.scorecard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.attr.name;

public class AddPlayer extends AppCompatActivity {
    EditText p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20;
    EditText s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;
    String name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15, name16, name17, name18, name19, name20;
    String score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12, score13, score14, score15, score16, score17, score18, score19, score20;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        p1 = (EditText) findViewById(R.id.p1);
        s1 = (EditText) findViewById(R.id.s1);
        b1 = (Button) findViewById(R.id.b1);
        p2 = (EditText) findViewById(R.id.p2);
        s2 = (EditText) findViewById(R.id.s2);
        b2 = (Button) findViewById(R.id.b2);
        p3 = (EditText) findViewById(R.id.p3);
        s3 = (EditText) findViewById(R.id.s3);
        b3 = (Button) findViewById(R.id.b3);
        p4 = (EditText) findViewById(R.id.p4);
        s4 = (EditText) findViewById(R.id.s4);
        b4 = (Button) findViewById(R.id.b4);
        p5 = (EditText) findViewById(R.id.p5);
        s5 = (EditText) findViewById(R.id.s5);
        b5 = (Button) findViewById(R.id.b5);
        p6 = (EditText) findViewById(R.id.p6);
        s6 = (EditText) findViewById(R.id.s6);
        b6 = (Button) findViewById(R.id.b6);
        p7 = (EditText) findViewById(R.id.p7);
        s7 = (EditText) findViewById(R.id.s7);
        b7 = (Button) findViewById(R.id.b7);
        p8 = (EditText) findViewById(R.id.p8);
        s8 = (EditText) findViewById(R.id.s8);
        b8 = (Button) findViewById(R.id.b8);
        p9 = (EditText) findViewById(R.id.p9);
        s9 = (EditText) findViewById(R.id.s9);
        b9 = (Button) findViewById(R.id.b9);
        p10 = (EditText) findViewById(R.id.p10);
        s10 = (EditText) findViewById(R.id.s10);
        b10 = (Button) findViewById(R.id.b10);
        p11 = (EditText) findViewById(R.id.p11);
        s11 = (EditText) findViewById(R.id.s11);
        b11 = (Button) findViewById(R.id.b11);
        p12 = (EditText) findViewById(R.id.p12);
        s12 = (EditText) findViewById(R.id.s12);
        b12 = (Button) findViewById(R.id.b12);
        p13 = (EditText) findViewById(R.id.p13);
        s13 = (EditText) findViewById(R.id.s13);
        b13 = (Button) findViewById(R.id.b13);
        p14 = (EditText) findViewById(R.id.p14);
        s14 = (EditText) findViewById(R.id.s14);
        b14 = (Button) findViewById(R.id.b14);
        p15 = (EditText) findViewById(R.id.p15);
        s15 = (EditText) findViewById(R.id.s15);
        b15 = (Button) findViewById(R.id.b15);
        p16 = (EditText) findViewById(R.id.p16);
        s16 = (EditText) findViewById(R.id.s16);
        b16 = (Button) findViewById(R.id.b16);
        p17 = (EditText) findViewById(R.id.p17);
        s17 = (EditText) findViewById(R.id.s17);
        b17 = (Button) findViewById(R.id.b17);
        p18 = (EditText) findViewById(R.id.p18);
        s18 = (EditText) findViewById(R.id.s18);
        b18 = (Button) findViewById(R.id.b18);
        p19 = (EditText) findViewById(R.id.p19);
        s19 = (EditText) findViewById(R.id.s19);
        b19 = (Button) findViewById(R.id.b19);
        p20 = (EditText) findViewById(R.id.p20);
        s20 = (EditText) findViewById(R.id.s20);
        b20 = (Button) findViewById(R.id.b20);
        SharedPreferences preferences1 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences2 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences3 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences4 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences5 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences6 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences7 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences8 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences9 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences10 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences11 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences12 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences13 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences14 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences15 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences16 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences17 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences18 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences19 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences20 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences21 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences22 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences23 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences24 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences25 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences26 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences27 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences28 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences29 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences30 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences31 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences32 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences33 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences34 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences35 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences36 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences37 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences38 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences39 = getSharedPreferences("PREFS", 0);
        SharedPreferences preferences40 = getSharedPreferences("PREFS", 0);

        name1 = preferences1.getString("name1", "");
        score1 = preferences2.getString("score1", "");
        p1.setText(name1);
        s1.setText(score1);
        name2 = preferences3.getString("name2", "");
        score2 = preferences4.getString("score2", "");
        p2.setText(name2);
        s2.setText(score2);
        name3 = preferences5.getString("name3", "");
        score3 = preferences6.getString("score3", "");
        p3.setText(name3);
        s3.setText(score3);
        name4 = preferences7.getString("name4", "");
        score4 = preferences8.getString("score4", "");
        p4.setText(name4);
        s4.setText(score4);
        name5 = preferences9.getString("name5", "");
        score5 = preferences10.getString("score5", "");
        p5.setText(name5);
        s5.setText(score5);
        name6 = preferences11.getString("name6", "");
        score6 = preferences12.getString("score6", "");
        p6.setText(name6);
        s6.setText(score6);
        name7 = preferences13.getString("name7", "");
        score7 = preferences14.getString("score7", "");
        p7.setText(name7);
        s7.setText(score7);
        name8 = preferences15.getString("name8", "");
        score8 = preferences16.getString("score8", "");
        p8.setText(name8);
        s8.setText(score8);
        name9 = preferences17.getString("name9", "");
        score9 = preferences18.getString("score9", "");
        p9.setText(name9);
        s9.setText(score9);
        name10 = preferences19.getString("name10", "");
        score10 = preferences20.getString("score10", "");
        p10.setText(name10);
        s10.setText(score10);
        name11 = preferences21.getString("name11", "");
        score11 = preferences22.getString("score11", "");
        p11.setText(name11);
        s11.setText(score11);
        name12 = preferences23.getString("name12", "");
        score12 = preferences24.getString("score12", "");
        p12.setText(name12);
        s12.setText(score12);
        name13 = preferences25.getString("name13", "");
        score13 = preferences26.getString("score13", "");
        p13.setText(name13);
        s13.setText(score13);
        name14 = preferences27.getString("name14", "");
        score14 = preferences28.getString("score14", "");
        p14.setText(name14);
        s14.setText(score14);
        name15 = preferences29.getString("name15", "");
        score15 = preferences30.getString("score15", "");
        p15.setText(name15);
        s15.setText(score15);
        name16 = preferences31.getString("name16", "");
        score16 = preferences32.getString("score16", "");
        p16.setText(name16);
        s16.setText(score16);
        name17 = preferences33.getString("name17", "");
        score17 = preferences34.getString("score17", "");
        p17.setText(name17);
        s17.setText(score17);
        name18 = preferences35.getString("name18", "");
        score18 = preferences36.getString("score18", "");
        p18.setText(name18);
        s18.setText(score18);
        name19 = preferences37.getString("name19", "");
        score19 = preferences38.getString("score19", "");
        p19.setText(name19);
        s19.setText(score19);
        name20 = preferences39.getString("name20", "");
        score20 = preferences40.getString("score20", "");
        p20.setText(name20);
        s20.setText(score20);





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = p1.getText().toString();
                score1 = s1.getText().toString();



                SharedPreferences preferences1 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences1.edit();
                editor.putString("name1", name1);
                editor.commit();
                SharedPreferences preferences2 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences2.edit();
                editor1.putString("score1", score1);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name2 = p2.getText().toString();
                score2 = s2.getText().toString();
                SharedPreferences preferences3 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putString("name2", name2);
                editor.commit();
                SharedPreferences preferences4 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences4.edit();
                editor1.putString("score2", score2);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name3 = p3.getText().toString();
                score3 = s3.getText().toString();
                SharedPreferences preferences5 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences5.edit();
                editor.putString("name3", name3);
                editor.commit();
                SharedPreferences preferences6 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences6.edit();
                editor1.putString("score3", score3);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name4 = p4.getText().toString();
                score4 = s4.getText().toString();
                SharedPreferences preferences7 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences7.edit();
                editor.putString("name4", name4);
                editor.commit();
                SharedPreferences preferences8 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences8.edit();
                editor1.putString("score4", score4);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name5 = p5.getText().toString();
                score5 = s5.getText().toString();
                SharedPreferences preferences9 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences9.edit();
                editor.putString("name5", name5);
                editor.commit();
                SharedPreferences preferences10 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences10.edit();
                editor1.putString("score5", score5);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name6 = p6.getText().toString();
                score6 = s6.getText().toString();
                SharedPreferences preferences11 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences11.edit();
                editor.putString("name6", name6);
                editor.commit();
                SharedPreferences preferences12 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences12.edit();
                editor1.putString("score6", score6);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name7 = p7.getText().toString();
                score7 = s7.getText().toString();
                SharedPreferences preferences13 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences13.edit();
                editor.putString("name7", name7);
                editor.commit();
                SharedPreferences preferences14 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences14.edit();
                editor1.putString("score7", score7);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name8 = p8.getText().toString();
                score8 = s8.getText().toString();
                SharedPreferences preferences15 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences15.edit();
                editor.putString("name8", name8);
                editor.commit();
                SharedPreferences preferences16 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences16.edit();
                editor1.putString("score8", score8);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name9 = p9.getText().toString();
                score9 = s9.getText().toString();
                SharedPreferences preferences17 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences17.edit();
                editor.putString("name9", name9);
                editor.commit();
                SharedPreferences preferences18 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences18.edit();
                editor1.putString("score9", score9);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name10 = p10.getText().toString();
                score10 = s10.getText().toString();
                SharedPreferences preferences19 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences19.edit();
                editor.putString("name10", name10);
                editor.commit();
                SharedPreferences preferences20 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences20.edit();
                editor1.putString("score10", score10);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name11 = p11.getText().toString();
                score11 = s11.getText().toString();
                SharedPreferences preferences21 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences21.edit();
                editor.putString("name11", name11);
                editor.commit();
                SharedPreferences preferences22 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences22.edit();
                editor1.putString("score11", score11);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name12 = p12.getText().toString();
                score12 = s12.getText().toString();
                SharedPreferences preferences23 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences23.edit();
                editor.putString("name12", name12);
                editor.commit();
                SharedPreferences preferences24 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences24.edit();
                editor1.putString("score12", score12);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name13 = p13.getText().toString();
                score13 = s13.getText().toString();
                SharedPreferences preferences25 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences25.edit();
                editor.putString("name13", name13);
                editor.commit();
                SharedPreferences preferences26 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences26.edit();
                editor1.putString("score13", score13);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name14 = p14.getText().toString();
                score14 = s14.getText().toString();
                SharedPreferences preferences27 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences27.edit();
                editor.putString("name14", name14);
                editor.commit();
                SharedPreferences preferences28 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences28.edit();
                editor1.putString("score14", score14);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name15 = p15.getText().toString();
                score15 = s15.getText().toString();
                SharedPreferences preferences29 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences29.edit();
                editor.putString("name15", name15);
                editor.commit();
                SharedPreferences preferences30 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences30.edit();
                editor1.putString("score15", score15);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name16 = p16.getText().toString();
                score16 = s16.getText().toString();
                SharedPreferences preferences31 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences31.edit();
                editor.putString("name16", name16);
                editor.commit();
                SharedPreferences preferences32 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences32.edit();
                editor1.putString("score16", score16);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name17 = p17.getText().toString();
                score17 = s17.getText().toString();
                SharedPreferences preferences33 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences33.edit();
                editor.putString("name17", name17);
                editor.commit();
                SharedPreferences preferences34 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences34.edit();
                editor1.putString("score17", score17);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name18 = p18.getText().toString();
                score18 = s18.getText().toString();
                SharedPreferences preferences35 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences35.edit();
                editor.putString("name18", name18);
                editor.commit();
                SharedPreferences preferences36 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences36.edit();
                editor1.putString("score18", score18);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name19 = p19.getText().toString();
                score19 = s19.getText().toString();
                SharedPreferences preferences37 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences37.edit();
                editor.putString("name19", name19);
                editor.commit();
                SharedPreferences preferences38 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences38.edit();
                editor1.putString("score19", score19);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name20 = p20.getText().toString();
                score20 = s20.getText().toString();
                SharedPreferences preferences39 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences39.edit();
                editor.putString("name20", name20);
                editor.commit();
                SharedPreferences preferences40 = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor1 = preferences40.edit();
                editor1.putString("score20", score20);
                editor1.commit();
                Toast.makeText(AddPlayer.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void rank(View view)
    {

        Intent i=new Intent(AddPlayer.this,Ranking.class);
        i.putExtra("n1",name1);
        i.putExtra("n2",name2);
        i.putExtra("n3",name3);
        i.putExtra("n4",name4);
        i.putExtra("n5",name5);
        i.putExtra("n6",name6);
        i.putExtra("n7",name7);
        i.putExtra("n8",name8);
        i.putExtra("n9",name9);
        i.putExtra("n10",name10);
        i.putExtra("n11",name11);
        i.putExtra("n12",name12);
        i.putExtra("n13",name13);
        i.putExtra("n14",name14);
        i.putExtra("n15",name15);
        i.putExtra("n16",name16);
        i.putExtra("n17",name17);
        i.putExtra("n18",name18);
        i.putExtra("n19",name19);
        i.putExtra("n20",name20);

        i.putExtra("s1",score1);
        i.putExtra("s2",score2);
        i.putExtra("s3",score3);
        i.putExtra("s4",score4);
        i.putExtra("s5",score5);
        i.putExtra("s6",score6);
        i.putExtra("s7",score7);
        i.putExtra("s8",score8);
        i.putExtra("s9",score9);
        i.putExtra("s10",score10);
        i.putExtra("s11",score11);
        i.putExtra("s12",score12);
        i.putExtra("s13",score13);
        i.putExtra("s14",score14);
        i.putExtra("s15",score15);
        i.putExtra("s16",score16);
        i.putExtra("s17",score17);
        i.putExtra("s18",score18);
        i.putExtra("s19",score19);
        i.putExtra("s20",score20);


        startActivity(i);

    }


}
