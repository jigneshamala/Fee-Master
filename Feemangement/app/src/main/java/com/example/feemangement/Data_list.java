package com.example.feemangement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Data_list extends AppCompatActivity {
    //String[] course={"MCA","BCA","MSCIT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        mydata mydb=new mydata(getApplicationContext());
        Object[] a= mydb.alldata();
        String[] a0= (String[]) a[0];
        String[] a1= (String[]) a[1];
        String[] a2= (String[]) a[2];
        String[] a3= (String[]) a[3];
        String[] a4= (String[]) a[4];
        String[] a5= (String[]) a[5];
        String[] a6= (String[]) a[6];
        String[] a7= (String[]) a[7];
        String[] a8= (String[]) a[8];
        String[] a9= (String[]) a[9];
        String[] a10= (String[]) a[10];
        String[] a11= (String[]) a[11];
        String[] a12= (String[]) a[12];
       // String[] a3= (String[]) a[3];

        ListView listView=findViewById(R.id.customlistview);
        ListAdaptor listAdaptor=new ListAdaptor(Data_list.this,a0,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        listView.setAdapter(listAdaptor);
    }

}
