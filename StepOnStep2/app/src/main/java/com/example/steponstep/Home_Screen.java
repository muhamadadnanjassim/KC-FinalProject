package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Home_Screen extends AppCompatActivity {

    TextView txt_currentAccel, txt_prevAccel, txt_acceleration, txt_counter;
    ProgressBar prog_shakeMeter;

    // define the sensor variables
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    int count = 0;

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
            if (changeInAcceleration > 14) {
                txt_acceleration.setBackgroundColor(Color.RED);
            }
            else if (changeInAcceleration > 5) {
                txt_acceleration.setBackgroundColor(Color.parseColor("#fcad03"));
            }
            else if (changeInAcceleration > 2) {
                txt_acceleration.setBackgroundColor(Color.YELLOW);
            }
            else {
                txt_acceleration.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_background));
            }
            if (changeInAcceleration > 10){
                count++;
                txt_counter.setText(String.valueOf(count));
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

        txt_counter = findViewById(R.id.txt_counter);

        prog_shakeMeter = findViewById(R.id.prog_ShakeMeter);

        // Initialize sensor object
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

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