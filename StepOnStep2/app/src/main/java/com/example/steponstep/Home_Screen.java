package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Screen extends AppCompatActivity {

    TextView txt_currentAccel, txt_prevAccel, txt_acceleration, txt_counter,balance,web,history;
    ProgressBar prog_shakeMeter;
    ImageView shop,set,donate;
    CardView b, hrs;
    float v=0;

    // define the sensor variables
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    int count = 0;
    int point = 0;

    private double accelerationCurrentValue;
    private double accelerationPreviousValue;

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            accelerationCurrentValue = Math.sqrt( (x * x + y * y + z * z));
            double changeInAcceleration = Math.abs(accelerationCurrentValue - accelerationPreviousValue);
            accelerationPreviousValue = accelerationCurrentValue;

            //update text views
            txt_currentAccel.setText("Current = " + (int)accelerationCurrentValue);
            txt_prevAccel.setText("Prev = " + (int)accelerationPreviousValue);
            txt_acceleration.setText("Acceleration = " + (int)changeInAcceleration);

            prog_shakeMeter.setProgress((int) changeInAcceleration);

            // change colors based on amount of shaking
//            if (changeInAcceleration > 14) {
//                txt_acceleration.setBackgroundColor(Color.RED);
//            }
//            else if (changeInAcceleration > 5) {
//                txt_acceleration.setBackgroundColor(Color.parseColor("#fcad03"));
//            }
//            else if (changeInAcceleration > 2) {
//                txt_acceleration.setBackgroundColor(Color.YELLOW);
//            }
//            else {
//                txt_acceleration.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_background));
//            }
            if (changeInAcceleration > 4){
                count++;
                txt_counter.setText(String.valueOf(count));
            }
            if (count == 100){
                point++;
                balance.setText(String.valueOf(point));
                Toast.makeText(Home_Screen.this, "You earned a point!", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);


        txt_acceleration = findViewById(R.id.txt_accel);
        txt_currentAccel = findViewById(R.id.txt_currentAccel);
        txt_prevAccel = findViewById(R.id.txt_prevAccel);
        shop = findViewById(R.id.shopi);
        history = findViewById(R.id.history);
        balance = findViewById(R.id.balance2);
        web = findViewById(R.id.txt_card);
        set = findViewById(R.id.set);
        hrs = findViewById(R.id.hrs);
        b = findViewById(R.id.cardView);
        donate = findViewById(R.id.donation);

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Screen.this, Donate.class);
                startActivity(intent);
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Screen.this, settings.class);
                startActivity(intent);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Screen.this, Store.class);
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.al-jazirah.com/2015/20151001/pl9.htm")));

            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Screen.this, History.class);
                startActivity(intent);
            }
        });

        //animation
        b.setTranslationX(300);
        set.setTranslationX(-200);
        hrs.setTranslationY(800);

        b.setAlpha(v);
        set.setAlpha(v);
        hrs.setAlpha(v);

        b.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        set.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        hrs.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();

        txt_counter = findViewById(R.id.txt_counter);

        prog_shakeMeter = findViewById(R.id.prog_ShakeMeter);

        // Initialize sensor object
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    private void gotoUrl(String s) {
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }
}