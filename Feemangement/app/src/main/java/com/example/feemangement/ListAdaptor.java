package com.example.feemangement;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collections;

public class ListAdaptor extends ArrayAdapter<String> {

    Activity context;
    //    private String[] name;
//    private String[] mobilenumber;
//    private String[] gender;
//    private String[] course;
    private String[] name;
    private String[] gender;
    private String[] college;
    private String[] study;
    private String[] email;
    private String[] mob;
    private String[] address;
    private String[] course;
    private String[] total;
    private String[] adm;
    private String[] study1;
    private String[] date;




    public ListAdaptor(Activity context,String[] name, String[] gender, String[] college,String[] study, String[] email, String[] mob, String[] address, String[] course, String[] total, String[] adm , String[] date ) {
        super(context, R.layout.custom_listview, name);

        this.name = name;
        this.gender = gender;
        this.college = college;
        this.study = study;
        //this.study1 = study1;
        this.email = email;
        this.mob = mob;
        this.address = address;
        this.course = course;
        this.total = total;
        this.adm = adm;
        this.date = date;
        this.context = context;
        Log.d("listadaptor", "listadaptor");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("getview1", "getview1");
        LayoutInflater layoutInflater = context.getLayoutInflater();
//        LayoutInflater.from(convertView.getContext());
        View view = layoutInflater.inflate(R.layout.custom_listview, null, true);

        TextView namea = view.findViewById(R.id.name);
        TextView genderb = view.findViewById(R.id.gender);
        TextView collegec = view.findViewById(R.id.college);
        TextView studyd = view.findViewById(R.id.study);
        TextView emaile = view.findViewById(R.id.email);
        TextView mobf = view.findViewById(R.id.mob);
        TextView addressg = view.findViewById(R.id.address);
        TextView courseh = view.findViewById(R.id.course);
        TextView totali = view.findViewById(R.id.total);
        TextView admj = view.findViewById(R.id.ahm);
        TextView datek = view.findViewById(R.id.date);

        namea.setText("name:- "+name[position]);
        genderb.setText("gender:- "+gender[position]);
        collegec.setText("college:- "+college[position]);
        //studyd.setText(study[position]);
        studyd.setText("study:- "+study[position]);
        emaile.setText("email:- "+email[position]);
        mobf.setText("mob:- "+mob[position]);
        addressg.setText("address:- "+address[position]);
        courseh.setText("course:- "+course[position]);
        totali.setText("total:- "+total[position]);
        admj.setText("adm:- "+adm[position]);
        datek.setText("date:- "+date[position]);
        //studyd.setText(study1[position]);
        Log.d("getview", "getview");
        return view;
    }
}
