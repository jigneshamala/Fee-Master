package com.example.feemangement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Fee_Master extends AppCompatActivity {
    AutoCompleteTextView a1;
    ArrayList<String> items = new ArrayList<>();
    EditText in;
    Button save, Show, cancel;
    String date, s1, s, smob;
    mydata mydb;
    TextView showview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fee_master);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mydb = new mydata(this);
        a1 = findViewById(R.id.auto_fee);
        a1.setThreshold(1);
        in = findViewById(R.id.installment);
        save = findViewById(R.id.save);
        Show = findViewById(R.id.Show);
        cancel = findViewById(R.id.cancel);
        date = java.text.DateFormat.getDateTimeInstance().format(
                Calendar.getInstance().getTime());
        showview = findViewById(R.id.show);


        Cursor res = mydb.getdataall();
        int name = res.getColumnIndex("name");
        int college=res.getColumnIndex("college");
        final int mob = res.getColumnIndex("mob");
//        int cob=name + mob;
        if (res != null) {
            //res.moveToNext();
            while (!res.isAfterLast()) {
                items.add(res.getString(name)+" "+res.getString(college));
                items.add(res.getString(mob));
                //items.add(res.getString(name)+" "+res.getString(mob));
                res.moveToNext();
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_view, items);
        a1.setAdapter(adapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!a1.getText().toString().isEmpty() && !in.getText().toString().isEmpty()) {
                    Cursor c1 = mydb.getidfromstudent(a1.getText().toString());
                    int ID = c1.getColumnIndex("ID");
                    int mob = c1.getColumnIndex("mob");
                    if (c1 != null) {
                        //res.moveToNext();
                        while (!c1.isAfterLast()) {
                            s1 = c1.getString(ID);
                            smob = c1.getString(mob);
                            Toast.makeText(Fee_Master.this, s1 + smob, Toast.LENGTH_LONG).show();
                            c1.moveToNext();

                            mydb.insertfee(a1.getText().toString(), s1, smob, in.getText().toString(), date);
                            a1.setText("");
                            in.setText("");
                            Toast.makeText(Fee_Master.this, "insert", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(Fee_Master.this, "something went worng", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Fee_Master.this, "Fields can not be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c1 = mydb.getFeealldata(a1.getText().toString());
                int ID = c1.getColumnIndex("ID");
                int STUDENTID = c1.getColumnIndex("STUDENT_ID");
                int name = c1.getColumnIndex("name");
                int installation = c1.getColumnIndex("installtion");
                int date = c1.getColumnIndex("date");


                if (c1 != null) {
                    //res.moveToNext();
                    s = "";
                    while (!c1.isAfterLast()) {


//                        s = c1.getString(name) + " ," + c1.getString(gender) + " ," + c1.getString(college) + " ," + c1.getString(study) + " ," + c1.getString(email) + " ," + c1.getString(mob) + " ," + c1.getString(address) + " ," + c1.getString(course) + " ," + c1.getString(total) + " ," + c1.getString(adm) + " ," + c1.getString(date);
//                        t1.setText(s);
                        s1 = c1.getString(ID) + "  " + c1.getString(STUDENTID) + "  " + c1.getString(name) + "  " + c1.getString(installation) + "  " + c1.getString(date);
                        s = s1 + " \n" + s;
                        showview.setText(s);

                        // Toast.makeText(Fee_Master.this, s, Toast.LENGTH_LONG).show();
                        c1.moveToNext();
                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

