package com.example.feemangement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main_Screen extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    mydata mydata;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mydata=new mydata(this);

        b1=findViewById(R.id.button14);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main_Screen.this, Student_Information.class);
                startActivity(i);
            }
        });
        b2=findViewById(R.id.button15);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main_Screen.this,MainActivity.class);
                startActivity(i);
            }
        });
        b3=findViewById(R.id.button16);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main_Screen.this,Fee_Master.class);
                startActivity(i);
            }
        });
        b4=findViewById(R.id.button17);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main_Screen.this, Search_Master.class);
                startActivity(i);
            }
        });
        b5=findViewById(R.id.button18);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main_Screen.this,About_Us.class);
                startActivity(i);
            }
        });
        b6=findViewById(R.id.button19);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
