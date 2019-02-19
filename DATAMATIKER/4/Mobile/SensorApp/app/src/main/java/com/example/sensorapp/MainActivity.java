package com.example.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lw =

        SensorManager sensors = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor accSensor = sensors.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }
}
