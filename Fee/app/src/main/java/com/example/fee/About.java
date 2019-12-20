package com.example.fee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity {
TextView contact,devcontact,whatsapp,facebook,website;
ImageView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        contact=findViewById(R.id.contactnumber);
        devcontact=findViewById(R.id.dev);

        whatsapp=findViewById(R.id.whatsapp);
        facebook=findViewById(R.id.facebook);
        website=findViewById(R.id.website);
        user=findViewById(R.id.image1);

        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/fontawesome-webfont.ttf");

        whatsapp.setTypeface(font);
        whatsapp.setText("\uf232");//
        facebook.setTypeface(font);
        facebook.setText("\uf082");
        website.setTypeface(font);
        website.setText("\uf26b");

        devcontact.setTypeface(font);



        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "contact", Toast.LENGTH_SHORT).show();
            }
        });
        devcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "dev", Toast.LENGTH_SHORT).show();
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "website", Toast.LENGTH_SHORT).show();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "facebook", Toast.LENGTH_SHORT).show();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "whatsapp", Toast.LENGTH_SHORT).show();
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "user", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
