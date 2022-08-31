package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class log extends AppCompatActivity {

    TextView Skip;
    EditText Name, Email, Password, ConPassword;
    Switch switch1;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        Name = findViewById(R.id.Name_ET);
        Email = findViewById(R.id.Email_ET);
        Password = findViewById(R.id.Password_ET1);
        ConPassword = findViewById(R.id.Password_ET2);
        switch1 = findViewById(R.id.switch1);
        Login = findViewById(R.id.Login_B);
        Skip = findViewById(R.id.Skip_TB);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent X = new Intent(log.this,Home.class);
                startActivity(X);

            }
        });

        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Q = new Intent(log.this,Home.class);
                startActivity(Q);

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(switch1.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}