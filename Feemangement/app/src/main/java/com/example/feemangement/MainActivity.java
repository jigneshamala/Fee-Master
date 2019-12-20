package com.example.feemangement;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button Save, Clear, Show, Exit;
    Spinner s1;
    RadioGroup rg;
    RadioButton r2, r1;
    EditText name, college, email, mob, address, course, total_fee, adm_fee;
    mydata mydb;
    String date;
    String[] study={"BCA","MCA","ITI","BE","DE","PGDCA","ME","M.TECH","B.TECH","OTHER"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//database file
        //mydb=new mydata(this);
        mydb = new mydata(getApplicationContext());


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rg = findViewById(R.id.Rg);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        name = findViewById(R.id.name);
        college = findViewById(R.id.college);
        email = findViewById(R.id.email);
        mob = findViewById(R.id.mobile);
        address = findViewById(R.id.address);
        course = findViewById(R.id.course);
        total_fee = findViewById(R.id.total_fee);
        adm_fee = findViewById(R.id.adm_fee);
        date = java.text.DateFormat.getDateTimeInstance().format(
                Calendar.getInstance().getTime());
        s1 = findViewById(R.id.spinner);
        //s1.getSelectedItem().toString();
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,study);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);
        Save = findViewById(R.id.Save);
        Show = findViewById(R.id.show);
        Clear = findViewById(R.id.clear);
        Exit = findViewById(R.id.exit);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //int rid = rg.getCheckedRadioButtonId();
                    //rb = findViewById(rid);
                    int radioid = rg.getCheckedRadioButtonId();
                    String gender = null;
                    if (radioid == r1.getId()) {
                        gender = "Male";
                    } else if (radioid == r2.getId()) {
                        gender = "Female";
                    }

                    if (!name.getText().toString().isEmpty() && !name.getText().toString().isEmpty() && !gender.isEmpty() && !college.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !mob.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !course.getText().toString().isEmpty() && !total_fee.getText().toString().isEmpty() && !adm_fee.getText().toString().isEmpty()) {
                        mydata mydb = new mydata(getApplicationContext());
                        mydb.insert(name.getText().toString(), gender, college.getText().toString(), String.valueOf(s1.getSelectedItemId()), email.getText().toString(), mob.getText().toString(), address.getText().toString(), course.getText().toString(), total_fee.getText().toString(), adm_fee.getText().toString(), s1.getSelectedItem().toString(), date);
                        name.setText("");
                        //r2.setText("");
                        college.setText("");
                        //s1.getSelectedItemId();
                        email.setText("");
                        mob.setText("");
                        address.setText("");
                        course.setText("");
                        total_fee.setText("");
                        adm_fee.setText("");
                        //s1.getSelectedItem();
                        // date.toString();

                        Toast.makeText(MainActivity.this, "insert", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Fields can not be empty", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // myDataBase.insert();
//                Intent i = new Intent(MainActivity.this, Show_data.class);
//                startActivity(i);
                Intent i = new Intent(MainActivity.this, Data_list.class);
                startActivity(i);

            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}