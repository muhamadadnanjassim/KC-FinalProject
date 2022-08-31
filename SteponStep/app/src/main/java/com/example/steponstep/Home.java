package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Home extends AppCompatActivity {

    TextView txt_currentAccel, txt_prevAccel, txt_acceleration;
    ProgressBar prog_ShakeMeter;
    Button B1;

    //define the sensor variables
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;


    private double accelerationCurrentValue;
    private double accelerationPreviousValue;

    private int pointsPlotted = 5;
    private int graphIntervalCounter = 0;

    private Viewport viewport;

    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });


    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            accelerationCurrentValue = Math.sqrt((x * x + y * y + z * z));
            double changeInAccelleration = Math.abs(accelerationCurrentValue - accelerationPreviousValue);
            accelerationPreviousValue = accelerationCurrentValue;

            //update text
            txt_currentAccel.setText("Current = " + (int)accelerationCurrentValue);
            txt_prevAccel.setText("Prev = " + (int)accelerationPreviousValue);
            txt_acceleration.setText("Acceleration = " + (int)changeInAccelleration);

            prog_ShakeMeter.setProgress((int)changeInAccelleration);

            // change colors based on amount of shaking
            if (changeInAccelleration > 14){
                txt_acceleration.setBackgroundColor(Color.RED);
            }
            else if (changeInAccelleration > 5){
                txt_acceleration.setBackgroundColor(Color.parseColor("#fcad03"));
            }
            else if (changeInAccelleration > 2) {
                txt_acceleration.setBackgroundColor(Color.YELLOW);
            }
            else {
                txt_acceleration.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_background));
            }

            //update the graph
            pointsPlotted++;

            if (pointsPlotted > 1000){
                pointsPlotted = 1;
                series.resetData(new DataPoint[] { new DataPoint(1, 0)});
            }
            series.appendData(new DataPoint(pointsPlotted, changeInAccelleration), true,pointsPlotted);
            viewport.setMaxX(pointsPlotted);
            viewport.setMinX(pointsPlotted - 200);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_currentAccel = findViewById(R.id.txt_currentAccel);
        txt_prevAccel = findViewById(R.id.txt_prevAccel);
        txt_acceleration = findViewById(R.id.txt_accel);

        prog_ShakeMeter = findViewById(R.id.prog_ShakeMeter);

        //just a button
//        B1 = findViewById(R.id.B1);
//        B1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Main2.class));
//            }
//        });

        //initialze sensor object
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        //sample graph code
        GraphView graph = (GraphView) findViewById(R.id.graph);
        viewport = graph.getViewport();
        viewport.setScalable(true);
        viewport.setYAxisBoundsManual(true);
        graph.addSeries(series);
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

