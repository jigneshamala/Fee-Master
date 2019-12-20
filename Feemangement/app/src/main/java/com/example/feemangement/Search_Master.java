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
import android.widget.LinearLayout;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search_Master extends AppCompatActivity {
    AutoCompleteTextView a1;
    Button search, delect, edit, show_all, delect_all, clear, back, confirm, cancel;
    mydata mydb;
    // SQLiteDatabase db;
    ArrayList<String> items = new ArrayList<>();
    EditText e1;
    String s1;
    TextView t1;


    //String[] study={"BCA","MCA","ITI","BE","DE","PGDCA","ME","M.TECH","B.TECH","OTHER"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_master);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mydb = new mydata(getApplicationContext());
        //mydb = new mydatabase(this);
        search = findViewById(R.id.search);
        delect = findViewById(R.id.delect);
        edit = findViewById(R.id.edit);
        show_all = findViewById(R.id.show_all);
        delect_all = findViewById(R.id.delect_all);
        clear = findViewById(R.id.clear);
        back = findViewById(R.id.back);
        a1 = findViewById(R.id.search_text);
        e1 = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        cancel = findViewById(R.id.cancel);
        t1=findViewById(R.id.showdata);



        Cursor res = mydb.getdataall();
        int name = res.getColumnIndex("name");
        int mob = res.getColumnIndex("mob");

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


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!a1.getText().toString().isEmpty()) {
                    //Toast.makeText(Search_Master.this, a1.getText().toString(), Toast.LENGTH_SHORT).show();
                    String[] a = mydb.serach(a1.getText().toString());
                    try {
                        if (!a[0].equals(null)) {
                            Intent i = new Intent(Search_Master.this, Update_detail.class);
                            i.putExtra("name", a[0]);
                            i.putExtra("gender", a[1]);
                            i.putExtra("college", a[2]);
                            i.putExtra("study", a[3]);
                            i.putExtra("email", a[4]);
                            i.putExtra("mob", a[5]);
                            i.putExtra("address", a[6]);
                            i.putExtra("course", a[7]);
                            i.putExtra("total", a[8]);
                            i.putExtra("adm", a[9]);
                            startActivity(i);
                        }
                    } catch (NullPointerException e) {
                        Toast.makeText(Search_Master.this, "Name not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Search_Master.this, "Enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!a1.getText().toString().isEmpty()) {
                    //Toast.makeText(Search_Master.this, a1.getText().toString(), Toast.LENGTH_SHORT).show();
                    mydb.delete(a1.getText().toString());
                    Toast.makeText(Search_Master.this, "DELECT", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Search_Master.this, "NOT DELECT", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delect_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout linearLayout = findViewById(R.id.visid);
                linearLayout.setVisibility(View.VISIBLE);
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (e1.getText().toString().equals("password")) {
                           // mydb.deleteall();
                            Toast.makeText(Search_Master.this, "correct", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Search_Master.this, "incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        linearLayout.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        show_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search_Master.this, Data_list.class);
                startActivity(i);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout linearLayout = findViewById(R.id.showvisid);
                linearLayout.setVisibility(View.VISIBLE);
                Cursor c1 = mydb.getdata(a1.getText().toString());
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
                if (c1 != null ) {
                    //res.moveToNext();

                    s1 = "";

                    while (!c1.isAfterLast()) {

                        s1 = c1.getString(name) + "  " + c1.getString(gender) + "  " + c1.getString(college) + "  " + c1.getString(study) + "  " + c1.getString(email) + "  " + c1.getString(mob) + "  " + c1.getString(address) + "  " + c1.getString(course) + "  " + c1.getString(total) + "  " + c1.getString(adm) + " " + c1.getString(date) + " \n";
                        t1.setText(s1);
                        //Toast.makeText(Search_Master.this, s1, Toast.LENGTH_SHORT).show();
                        c1.moveToNext();
                    }

                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                a1.setText("");
            }
        });

    }
}
