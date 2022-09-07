package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Donate extends AppCompatActivity {

    ImageView shop,home;
    CardView d1,d2,hrs;
    float v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);


        shop = findViewById(R.id.shopi);
        home = findViewById(R.id.homei);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        hrs = findViewById(R.id.hrs);

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://insan.org.kw/")));
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://alnajat.org.kw/")));
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Donate.this, Store.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Donate.this, Home_Screen.class);
                startActivity(intent);
            }
        });

        //animation
        d1.setTranslationX(800);
        d2.setTranslationX(800);
        hrs.setTranslationY(800);

        d1.setAlpha(v);
        d2.setAlpha(v);
        hrs.setAlpha(v);

        d1.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        d2.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        hrs.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
    }
}