package com.example.pranesh.scorecard;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static android.R.id.edit;
import static android.widget.Toast.LENGTH_LONG;
import static com.example.pranesh.scorecard.R.id.b17;
import static com.example.pranesh.scorecard.R.id.s1;
import static com.example.pranesh.scorecard.R.id.s11;

public class Ranking extends AppCompatActivity {


    TextView rank1,rank2,rank3,rank4,rank5,rank6,rank7,rank8,rank9,rank10,rank11,rank12,rank13,rank14,rank15,rank16,rank17,rank18,rank19,rank20;
    TextView name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12,name13,name14,name15,name16,name17,name18,name19,name20;
    TextView score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12,score13,score14,score15,score16,score17,score18,score19,score20;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    String n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ArrayList<String> name;
        ArrayList<Integer> score;
        ArrayList<Integer> rank;
        rank1=(TextView)findViewById(R.id.rank1);
        rank2=(TextView)findViewById(R.id.rank2);
        rank3=(TextView)findViewById(R.id.rank3);
        rank4=(TextView)findViewById(R.id.rank4);
        rank5=(TextView)findViewById(R.id.rank5);
        rank6=(TextView)findViewById(R.id.rank6);
        rank7=(TextView)findViewById(R.id.rank7);
        rank8=(TextView)findViewById(R.id.rank8);
        rank9=(TextView)findViewById(R.id.rank9);
        rank10=(TextView)findViewById(R.id.rank10);
        rank11=(TextView)findViewById(R.id.rank11);
        rank12=(TextView)findViewById(R.id.rank12);
        rank13=(TextView)findViewById(R.id.rank13);
        rank14=(TextView)findViewById(R.id.rank14);
        rank15=(TextView)findViewById(R.id.rank15);
        rank16=(TextView)findViewById(R.id.rank16);
        rank17=(TextView)findViewById(R.id.rank17);
        rank18=(TextView)findViewById(R.id.rank18);
        rank19=(TextView)findViewById(R.id.rank19);
        rank20=(TextView)findViewById(R.id.rank20);


        name1=(TextView)findViewById(R.id.name1);
        name2=(TextView)findViewById(R.id.name2);
        name3=(TextView)findViewById(R.id.name3);
        name4=(TextView)findViewById(R.id.name4);
        name5=(TextView)findViewById(R.id.name5);
        name6=(TextView)findViewById(R.id.name6);
        name7=(TextView)findViewById(R.id.name7);
        name8=(TextView)findViewById(R.id.name8);
        name9=(TextView)findViewById(R.id.name9);
        name10=(TextView)findViewById(R.id.name10);
        name11=(TextView)findViewById(R.id.name11);
        name12=(TextView)findViewById(R.id.name12);
        name13=(TextView)findViewById(R.id.name13);
        name14=(TextView)findViewById(R.id.name14);
        name15=(TextView)findViewById(R.id.name15);
        name16=(TextView)findViewById(R.id.name16);
        name17=(TextView)findViewById(R.id.name17);
        name18=(TextView)findViewById(R.id.name18);
        name19=(TextView)findViewById(R.id.name19);
        name20=(TextView)findViewById(R.id.name20);

        score1=(TextView)findViewById(R.id.score1);
        score2=(TextView)findViewById(R.id.score2);
        score3=(TextView)findViewById(R.id.score3);
        score4=(TextView)findViewById(R.id.score4);
        score5=(TextView)findViewById(R.id.score5);
        score6=(TextView)findViewById(R.id.score6);
        score7=(TextView)findViewById(R.id.score7);
        score8=(TextView)findViewById(R.id.score8);
        score9=(TextView)findViewById(R.id.score9);
        score10=(TextView)findViewById(R.id.score10);
        score11=(TextView)findViewById(R.id.score11);
        score12=(TextView)findViewById(R.id.score12);
        score13=(TextView)findViewById(R.id.score13);
        score14=(TextView)findViewById(R.id.score14);
        score15=(TextView)findViewById(R.id.score15);
        score16=(TextView)findViewById(R.id.score16);
        score17=(TextView)findViewById(R.id.score17);
        score18=(TextView)findViewById(R.id.score18);
        score19=(TextView)findViewById(R.id.score19);
        score20=(TextView)findViewById(R.id.score20);



        n1=getIntent().getStringExtra("n1");
        n2=getIntent().getStringExtra("n2");
        n3=getIntent().getStringExtra("n3");
        n4=getIntent().getStringExtra("n4");
        n5=getIntent().getStringExtra("n5");
        n6=getIntent().getStringExtra("n6");
        n7=getIntent().getStringExtra("n7");
        n8=getIntent().getStringExtra("n8");
        n9=getIntent().getStringExtra("n9");
        n10=getIntent().getStringExtra("n10");
        n11=getIntent().getStringExtra("n11");
        n12=getIntent().getStringExtra("n12");
        n13=getIntent().getStringExtra("n13");
        n14=getIntent().getStringExtra("n14");
        n15=getIntent().getStringExtra("n15");
        n16=getIntent().getStringExtra("n16");
        n17=getIntent().getStringExtra("n17");
        n18=getIntent().getStringExtra("n18");
        n19=getIntent().getStringExtra("n19");
        n20=getIntent().getStringExtra("n20");



        s1=getIntent().getStringExtra("s1");
        s2=getIntent().getStringExtra("s2");
        s3=getIntent().getStringExtra("s3");
        s4=getIntent().getStringExtra("s4");
        s5=getIntent().getStringExtra("s5");
        s6=getIntent().getStringExtra("s6");
        s7=getIntent().getStringExtra("s7");
        s8=getIntent().getStringExtra("s8");
        s9=getIntent().getStringExtra("s9");
        s10=getIntent().getStringExtra("s10");
        s11=getIntent().getStringExtra("s11");
        s12=getIntent().getStringExtra("s12");
        s13=getIntent().getStringExtra("s13");
        s14=getIntent().getStringExtra("s14");
        s15=getIntent().getStringExtra("s15");
        s16=getIntent().getStringExtra("s16");
        s17=getIntent().getStringExtra("s17");
        s18=getIntent().getStringExtra("s18");
        s19=getIntent().getStringExtra("s19");
        s20=getIntent().getStringExtra("s20");


        Integer sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8,sc9,sc10,sc11,sc12,sc13,sc14,sc15,sc16,sc17,sc18,sc19,sc20;

        name = new ArrayList<>();
        score=new ArrayList<>();
        rank=new ArrayList<>();
        int temp;
        String tem;

        if(!n1.isEmpty()) { name.add(n1); sc1=Integer.parseInt(s1); score.add(sc1);}
        if(!n2.isEmpty()) { name.add(n2);  sc2=Integer.parseInt(s2); score.add(sc2);}
        if(!n3.isEmpty()) { name.add(n3);  sc3=Integer.parseInt(s3); score.add(sc3);}
        if(!n4.isEmpty()) { name.add(n4); sc4=Integer.parseInt(s4); score.add(sc4);}
        if(!n5.isEmpty()) { name.add(n5);  sc5=Integer.parseInt(s5); score.add(sc5);}
        if(!n6.isEmpty()) { name.add(n6); sc6=Integer.parseInt(s6); score.add(sc6);}
        if(!n7.isEmpty()) { name.add(n7); sc7=Integer.parseInt(s7); score.add(sc7);}
        if(!n8.isEmpty()) { name.add(n8); sc8=Integer.parseInt(s8); score.add(sc8);}
        if(!n9.isEmpty()) { name.add(n9);  sc9=Integer.parseInt(s9); score.add(sc9);}
        if(!n10.isEmpty()) { name.add(n10); sc10=Integer.parseInt(s10); score.add(sc10);}
        if(!n11.isEmpty()) { name.add(n11);  sc11=Integer.parseInt(s11); score.add(sc11);}
        if(!n12.isEmpty()) { name.add(n12); sc12=Integer.parseInt(s12); score.add(sc12);}
        if(!n13.isEmpty()) { name.add(n13); sc13=Integer.parseInt(s13); score.add(sc13);}
        if(!n14.isEmpty()) { name.add(n14); sc14=Integer.parseInt(s14); score.add(sc14);}
        if(!n15.isEmpty()) { name.add(n15); sc15=Integer.parseInt(s15); score.add(sc15);}
        if(!n16.isEmpty()) { name.add(n16); sc16=Integer.parseInt(s16); score.add(sc16);}
        if(!n17.isEmpty()) { name.add(n17); sc17=Integer.parseInt(s17); score.add(sc17);}
        if(!n18.isEmpty()) { name.add(n18); sc18=Integer.parseInt(s18); score.add(sc18);}
        if(!n19.isEmpty()) { name.add(n19); sc19=Integer.parseInt(s19); score.add(sc19);}
        if(!n20.isEmpty()) { name.add(n20); sc20=Integer.parseInt(s20); score.add(sc20);}

        for(int i=0;i<name.size();i++)
        {
            for(int j=i+1;j<name.size();j++)
            {
                if(score.get(i)<score.get(j))
                {
                    temp=score.get(i);
                    score.set(i,score.get(j));
                    score.set(j,temp);

                    tem=name.get(i);
                    name.set(i,name.get(j));
                    name.set(j,tem);
                }
            }
        }

        for(int i=0;i<name.size();i++){
            rank.add(i+1);
        }
        if(0<name.size()) {rank1.setText(rank.get(0).toString());}
        if(1<name.size()) {rank2.setText(rank.get(1).toString());}
            if(2<name.size()) {rank3.setText(rank.get(2).toString());}
                if(3<name.size()) {rank4.setText(rank.get(3).toString());}
        if(4<name.size()) {rank5.setText(rank.get(4).toString());}
        if(5<name.size()) {rank6.setText(rank.get(5).toString());}
        if(6<name.size()) {rank7.setText(rank.get(6).toString());}
        if(7<name.size()) {rank8.setText(rank.get(7).toString());}
        if(8<name.size()) {rank9.setText(rank.get(8).toString());}
        if(9<name.size()) {rank10.setText(rank.get(9).toString());}
        if(10<name.size()) {rank11.setText(rank.get(10).toString());}
        if(11<name.size()) {rank12.setText(rank.get(11).toString());}
        if(12<name.size()) {rank13.setText(rank.get(12).toString());}
        if(13<name.size()) {rank14.setText(rank.get(13).toString());}
        if(14<name.size()) {rank15.setText(rank.get(14).toString());}
        if(15<name.size()) {rank16.setText(rank.get(15).toString());}
        if(16<name.size()) {rank17.setText(rank.get(16).toString());}
        if(17<name.size()) {rank18.setText(rank.get(17).toString());}
        if(18<name.size()) {rank19.setText(rank.get(18).toString());}
        if(19<name.size()) {rank20.setText(rank.get(19).toString());}



        if(0<name.size()){score1.setText(score.get(0).toString());}
        if(1<name.size()){score2.setText(score.get(1).toString());}
        if(2<name.size()){score3.setText(score.get(2).toString());}
        if(3<name.size()){score4.setText(score.get(3).toString());}
        if(4<name.size()){score5.setText(score.get(4).toString());}
        if(5<name.size()){score6.setText(score.get(5).toString());}
        if(6<name.size()){score7.setText(score.get(6).toString());}
        if(7<name.size()){score8.setText(score.get(7).toString());}
        if(8<name.size()){score9.setText(score.get(8).toString());}
        if(9<name.size()){score10.setText(score.get(9).toString());}
        if(10<name.size()){score11.setText(score.get(10).toString());}
        if(11<name.size()){score12.setText(score.get(11).toString());}
        if(12<name.size()){score13.setText(score.get(12).toString());}
        if(13<name.size()){score14.setText(score.get(13).toString());}
        if(14<name.size()){score15.setText(score.get(14).toString());}
        if(15<name.size()){score16.setText(score.get(15).toString());}
        if(16<name.size()){score17.setText(score.get(16).toString());}
        if(17<name.size()){score18.setText(score.get(17).toString());}
        if(18<name.size()){score19.setText(score.get(18).toString());}
        if(19<name.size()){score20.setText(score.get(19).toString());}


        if(0<name.size()){name1.setText(name.get(0));}
        if(1<name.size()){name2.setText(name.get(1));}
        if(2<name.size()){name3.setText(name.get(2));}
        if(3<name.size()){name4.setText(name.get(3));}
        if(4<name.size()){name5.setText(name.get(4));}
        if(5<name.size()){name6.setText(name.get(5));}
        if(6<name.size()){name7.setText(name.get(6));}
        if(7<name.size()){name8.setText(name.get(7));}
        if(8<name.size()){name9.setText(name.get(8));}
        if(9<name.size()){name10.setText(name.get(9));}
        if(10<name.size()){name11.setText(name.get(10));}
        if(11<name.size()){name12.setText(name.get(11));}
        if(12<name.size()){name13.setText(name.get(12));}
        if(13<name.size()){name14.setText(name.get(13));}
        if(14<name.size()){name15.setText(name.get(14));}
        if(15<name.size()){name16.setText(name.get(15));}
        if(16<name.size()){name17.setText(name.get(16));}
        if(17<name.size()){name18.setText(name.get(17));}
        if(18<name.size()){name19.setText(name.get(18));}
        if(19<name.size()){name20.setText(name.get(19));}




    }

    public void open(View view1)
    {
        Intent ind=new Intent(this,AddPlayer.class);
        startActivity(ind);
    }
}

