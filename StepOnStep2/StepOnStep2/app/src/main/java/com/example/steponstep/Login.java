package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Login extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google;
    Button LOGIN;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // id
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        fb = findViewById(R.id.fab_fb);
        google = findViewById(R.id.fab_google);
        LOGIN = findViewById(R.id.B1);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/_ylt=AwrheeeQoxhjAvMQUF9XNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1662587920/RO=10/RU=https%3a%2f%2faccounts.google.com%2fLogin/RK=2/RS=gVIMuezXLI5p9EmplsHLBC6NHKw-")));
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/_ylt=AwrFcsgpqBhj3.EQLRZXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1662589097/RO=10/RU=https%3a%2f%2fwww.facebook.com%2flogin.php/RK=2/RS=mhh9Gtlki760BPSUROAz9sSzRAQ-")));
            }
        });

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Home_Screen.class);
                startActivity(intent);
            }
        });
        // Adapter
        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("Sign in"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // animation
        fb.setTranslationY(300);
        google.setTranslationY(300);
        tabLayout.setTranslationY(800);
        LOGIN.setTranslationX(400);

        fb.setAlpha(v);
        google.setAlpha(v);
        tabLayout.setAlpha(v);
        LOGIN.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(600).start();
        LOGIN.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();

    }
}