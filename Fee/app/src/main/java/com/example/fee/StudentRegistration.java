package com.example.fee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class StudentRegistration extends AppCompatActivity {
    Spinner s1,s;
    String[] study = {"BCA", "MCA", "ITI", "BE", "DE", "PGDCA", "ME", "M.TECH", "B.TECH", "OTHER"};
    TextView shareicon, whatsappicon, messageicon, emailicon, copyicon;
    Button save, Show, Exit, ok;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        s1 = findViewById(R.id.rStudy);
        name=findViewById(R.id.rname);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, study);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);



        save = findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showCustomDialog();
                Toast.makeText(StudentRegistration.this,name.getText().toString(), Toast.LENGTH_SHORT).show();
//                db.insert(name.getText().toString(), mn.getText().toString());
//                name.setText("");
//                mn.setText("");
//                Toast.makeText(MainActivity.this, "insert", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showCustomDialog() {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        final ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_success, viewGroup, false);
        shareicon = dialogView.findViewById(R.id.share);
        whatsappicon = dialogView.findViewById(R.id.whatsapp);
        messageicon = dialogView.findViewById(R.id.message);
        emailicon = dialogView.findViewById(R.id.email);
        copyicon = dialogView.findViewById(R.id.copy);
        Typeface Font = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        shareicon.setTypeface(Font);
        whatsappicon.setTypeface(Font);
        messageicon.setTypeface(Font);
        emailicon.setTypeface(Font);
        copyicon.setTypeface(Font);
        shareicon.setText("\uf1e0");
        whatsappicon.setText("\uf232");
        messageicon.setText("\uf27a");
        emailicon.setText("\uf0e0");
        copyicon.setText("\uf0c5");

        ok = dialogView.findViewById(R.id.successok);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        final AlertDialog alertDialog = builder.create();

        alertDialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }
}
