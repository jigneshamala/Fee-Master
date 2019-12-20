package com.example.feemangement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class Update_detail extends AppCompatActivity {
    Button save, Exit;
    Spinner s1;
    RadioGroup rg;
    RadioButton r1, r2;
    EditText name, college, email, mob, address, course, total_fee, adm_fee;
    mydata mydb;

    String id;
    String[] study = {"BCA", "MCA", "ITI", "BE", "DE", "PGDCA", "ME", "M.TECH", "B.TECH", "OTHER"};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_update);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mydb = new mydata(getApplicationContext());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        name = findViewById(R.id.name);
        college = findViewById(R.id.college);
        email = findViewById(R.id.email);
        mob = findViewById(R.id.mobile);
        address = findViewById(R.id.address);
        course = findViewById(R.id.course);
        total_fee = findViewById(R.id.total_fee);
        adm_fee = findViewById(R.id.adm_fee);


        s1 = findViewById(R.id.spinner);
        s1.getSelectedItemId();
        save = findViewById(R.id.Update);
        Exit = findViewById(R.id.exit);
        rg = findViewById(R.id.Rg);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, study);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);


        try {
            if (!getIntent().getStringExtra("name").isEmpty() && !getIntent().getStringExtra("gender").isEmpty() && !getIntent().getStringExtra("college").isEmpty() && !getIntent().getStringExtra("study").isEmpty() && !getIntent().getStringExtra("email").isEmpty() && !getIntent().getStringExtra("mob").isEmpty() && !getIntent().getStringExtra("address").isEmpty() && !getIntent().getStringExtra("course").isEmpty() && !getIntent().getStringExtra("total").isEmpty() && !getIntent().getStringExtra("adm").isEmpty()) {
                name.setText(getIntent().getStringExtra("name"));
                if (getIntent().getStringExtra("gender").equals("Male")) {
                    r1.setChecked(true);
                    r2.setChecked(false);
                } else if (getIntent().getStringExtra("gender").equals("Female")) {
                    r1.setChecked(false);
                    r2.setChecked(true);
                }
                college.setText(getIntent().getStringExtra("college"));
                String course1 = getIntent().getStringExtra("study");
                s1.setSelection(Integer.parseInt(course1));
                email.setText(getIntent().getStringExtra("email"));
                mob.setText(getIntent().getStringExtra("mob"));
                address.setText(getIntent().getStringExtra("address"));
                course.setText(getIntent().getStringExtra("course"));
                total_fee.setText(getIntent().getStringExtra("total"));
                adm_fee.setText(getIntent().getStringExtra("adm"));



            }
        } catch (Exception e) {
        }

        save.setOnClickListener(new View.OnClickListener() {
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
                        mydb.update(name.getText().toString(), gender, college.getText().toString(), String.valueOf(s1.getSelectedItemId()), email.getText().toString(), mob.getText().toString(), address.getText().toString(), course.getText().toString(), total_fee.getText().toString(), adm_fee.getText().toString(), s1.getSelectedItem().toString());
                      Toast.makeText(Update_detail.this, "update", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(Update_detail.this, "notupdate", Toast.LENGTH_SHORT).show();
                   }
                 }catch (Exception e) {
                    Toast.makeText(Update_detail.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
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







