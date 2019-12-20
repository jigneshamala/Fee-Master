package com.example.feemangement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

public class About_Us extends AppCompatActivity {
    TextView e1,e2,e3,e4,e5,e6,e7;
    ImageView im,im1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        e1=findViewById(R.id.textView10);
        e2=findViewById(R.id.textView11);
        e3=findViewById(R.id.textView12);
        e5=findViewById(R.id.textView9);
        e6=findViewById(R.id.textView13);
        e4=findViewById(R.id.icon1);
        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/fa-brands-400.ttf");
        e4.setTypeface(font);
        e4.setText("\uf26b");
        e5.setTypeface(font);
        e5.setText("\uf082");
        e6.setTypeface(font);
        e6.setText("\uf232");
        e7=findViewById(R.id.dev);
        e7.setTypeface(font);
        e7.setText("\uf17b  DEVELOPED BY JIGNESH AMALA 96890602087 ");
im=findViewById(R.id.imageView2);

im.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(About_Us.this, Web_view.class);
        i.putExtra(Web_view.WEBSITE_ADDRESS, "http://xipratechnology.com/");
        startActivity(i);
    }
});

        e1.setText("We have considerable expertise in mobile Development. Our team of experienced mobile developers has been delivering mobile solutions to our clients over the world.");
        e2.setText("Contact");
        e3.setText("9033387254");
        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=e3.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });
        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num="9689062087";
                Intent Call= new Intent(Intent.ACTION_DIAL);
                Call.setData(Uri.parse("tel:"+num));
                startActivity(Call);
            }
        });
        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Us.this, Web_view.class);
                i.putExtra(Web_view.WEBSITE_ADDRESS, "http://xipratechnology.com/");
                startActivity(i);
            }
        });
        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Us.this, Web_view.class);
                i.putExtra(Web_view.WEBSITE_ADDRESS, "https://www.facebook.com/janak.mevada?__tn__=%2Cd*F*F-R&eid=ARCJ2k9BWuYUlGy9aStLEph9pwulztFP3-hhSs1e9EjPUSmAav3bBur6RMbiZOhsf0I1oIdGvA4zstaU&tn-str=*F");
                startActivity(i);
            }
        });
        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=e3.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });
        //e3.setText("Contact");
        //e3.setText("Contact");

    }
}
