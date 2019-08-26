package com.dita.accelometer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    TextView xCoor;
    TextView yCoor;
    TextView zCoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xCoor = (TextView) findViewById(R.id.xcoor);
        yCoor = (TextView) findViewById(R.id.ycoor);
        zCoor = (TextView) findViewById(R.id.zcoor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            xCoor.setText("X Coordinate :" + x);
            yCoor.setText("Y Coordinate :"+y);
            zCoor.setText("Z Coordinate :" + z);

            if (x >0){
                xCoor.setBackgroundColor(Color.parseColor("#ffc5a1"));
            }
            else {
                xCoor.setBackgroundColor(Color.parseColor("#FFF8A6"));
            }
            if (y>0){
                yCoor.setBackgroundColor(Color.parseColor("#b0deff"));
            }
            else {
                yCoor.setBackgroundColor(Color.parseColor("#ffd19a"));
            }
            if (z>0){
                zCoor.setBackgroundColor(Color.parseColor("#fcf9ec"));
            }
            else {
                zCoor.setBackgroundColor(Color.parseColor("#ccc1ff"));
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
