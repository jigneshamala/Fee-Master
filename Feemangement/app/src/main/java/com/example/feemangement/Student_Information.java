package com.example.feemangement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Student_Information extends AppCompatActivity {

    AutoCompleteTextView a1;
    ArrayList<String> items = new ArrayList<>();
    Button show_data, Exit;
    TextView t1, t2, t3, t4, t5, t6;
    int num1, num2;
    String s1, s,combin1,a;
    mydata mydb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mydb = new mydata(getApplicationContext());
        a1 = findViewById(R.id.auto_stud_info);
        a1.setThreshold(1);
        show_data = findViewById(R.id.show_data);
        Exit = findViewById(R.id.exit);
        t1 = findViewById(R.id.data_views);
        t2 = findViewById(R.id.total_fee);
        t3 = findViewById(R.id.admis_fee);
        t4 = findViewById(R.id.show_fee);
        t5 = findViewById(R.id.total_fee_paid);
        t6 = findViewById(R.id.remain_fee);


        Cursor res = mydb.getdataall();
        int name = res.getColumnIndex("name");
        int mob = res.getColumnIndex("mob");
//        int cob=name + mob;
        if (res != null) {
            //res.moveToNext();
            while (!res.isAfterLast()) {
                items.add(res.getString(name));
                items.add(res.getString(mob));
                //items.add(res.getString(name)+" "+res.getString(mob));
                res.moveToNext();
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_view, items);
        a1.setAdapter(adapter);


        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(Student_Information.this,Main_Screen.class);
//                startActivity(i);
                finish();
            }
        });
        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout linearLayout = findViewById(R.id.viewid);
                linearLayout.setVisibility(View.VISIBLE);

                //name Text,gender Text,college text,study text,email text,mob text,address text,course text,total text,adm text,study1 text,date DATETIME DEFAULT CURRENT_TIMESTAMP)");
                //        db.execSQL("create table myfee(ID INTEGER PRIMARY KEY AUTOINCREMENT,name Text,installtion Text,date DATETIME DEFAULT CURRENT_TIMESTAMP)")

                Cursor c1 = mydb.jointable(a1.getText().toString());
                Cursor c = mydb.getFeealldata(a1.getText().toString());
                int sum = mydb.getSumValue(a1.getText().toString());

                int name = c1.getColumnIndex("name");
                int gender = c1.getColumnIndex("gender");
                int college = c1.getColumnIndex("college");
                int study = c1.getColumnIndex("study1");
                int email = c1.getColumnIndex("email");
                int mob = c1.getColumnIndex("mob");
                int address = c1.getColumnIndex("address");
                int course = c1.getColumnIndex("course");
                int total = c1.getColumnIndex("total");
                int adm = c1.getColumnIndex("adm");
                int date = c1.getColumnIndex("date");
                int IDF = c1.getColumnIndex("ID");
                int namef = c1.getColumnIndex("name");
                int STUDENTIDF = c1.getColumnIndex("STUDENT_ID");
                int installation = c1.getColumnIndex("installtion");
                int datef = c1.getColumnIndex("date");
                int IDT = c.getColumnIndex("ID");
                int STUDENTIDT = c.getColumnIndex("STUDENT_ID");
                int nameT = c.getColumnIndex("name");
                int installationT = c.getColumnIndex("installtion");
                int dateT = c.getColumnIndex("date");

                if (c1 != null && c != null) {
                    //res.moveToNext();

                    s = "";
                    //combin1=" ";
                    a = "";
                    while (!c1.isAfterLast() && !c.isAfterLast()) {

                        s1 = c1.getString(name) + "  " + c1.getString(gender) + "  " + c1.getString(college) + "  " + c1.getString(study) + "  " + c1.getString(email) + "  " + c1.getString(mob) + "  " + c1.getString(address) + "  " + c1.getString(course) + "  " + c1.getString(total) + "  " + c1.getString(adm) + " " + c1.getString(date) + " \n";
                        a = c1.getString(IDF) + "  " + c1.getString(namef) + "  " + c1.getString(STUDENTIDF) + " " + c1.getString(installation) + "  " + c1.getString(datef);
                        t1.setText(s1 + a);

                        t2.setText("Total Fee :- " + c1.getString(total));
                        t3.setText("Admission Fee :- " + c1.getString(adm));

                        combin1 = c.getString(IDT) + "  " + c.getString(nameT) + "  " + c.getString(STUDENTIDT) + " " + c.getString(installationT) + "  " + c.getString(dateT);
                        s = combin1 + " \n" + s;//combin1+"\n" + s +
                        t4.setText(s);
                        num1=sum+c1.getInt(adm);
                        t5.setText("Total Fee paid :- "+String.valueOf(num1));
                        num2=c1.getInt(total)-num1;
                        t6.setText("Remain Fee :- "+String.valueOf(num2));
                        c.moveToNext();

                        c1.moveToLast();

                    }

                }
                a1.setText("");

            }


        });

    }
}
