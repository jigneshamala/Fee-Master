package com.example.feemangement;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Show_data extends AppCompatActivity {
    TextView t1;
    String s="0";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data);
        t1 = findViewById(R.id.text_view);
        mydata mydb = new mydata(getApplicationContext());
        Cursor res = mydb.getFeedata();
        int Cloum = res.getColumnIndex("name");
        if (res != null) {
           //res.moveToNext();
            while (res.moveToNext()) {
             s=res.getString(0)+"  ,  "+res.getString(1)+"  ,  "+res.getString(2)+"  ,  "+res.getString(3)+"  ,  \n";
             //   res.moveToNext();
            }
            t1.setText(s);
        }

    }
}
