package com.example.sensorexercisetwo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sManager;
    List<Sensor> allSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        allSensors = sManager.getSensorList(Sensor.TYPE_ALL);

        Button sensorsButton = (Button) findViewById(R.id.btnSensors);
        sensorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int j = 0; j < allSensors.size(); j++){
                    Log.e("mySENSORS: ", allSensors.get(j).toString());
                }
            }
        });

        Button manualButton = (Button) findViewById(R.id.btnManualSensor);
        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)!=null)
                {
                    Log.e("manual","You have Gyroscope");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
                    Log.e("manual","You have Accelerometer");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
                    Log.e("manual","You have Ambient Temperature");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT)!=null){
                    Log.e("manual","You have Heart Beat");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)!=null){
                    Log.e("manual","You have Heart Rate");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_MOTION_DETECT)!=null){
                    Log.e("manual","You have Motion Detect");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_PRESSURE)!=null){
                    Log.e("manual","You have Pressure");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)!=null){
                    Log.e("manual","You have (deprecated) Temperature");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_STATIONARY_DETECT)!=null){
                    Log.e("manual","You have Stationary Detect");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!=null){
                    Log.e("manual","You have Proximity");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_GRAVITY)!=null){
                    Log.e("manual","You have Gravity");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED)!=null){
                    Log.e("manual","You have Accelerometer Uncalibrated");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED)!=null){
                    Log.e("manual","You have Gyroscope Uncalibrated");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)!=null){
                    Log.e("manual","You have Linear Acceleration");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)!=null){
                    Log.e("manual","You have Rotation Vector");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION)!=null){
                    Log.e("manual","You have Significant Motion");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
                    Log.e("manual","You have Step Counter");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null){
                    Log.e("manual","You have Step Detector");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_LIGHT)!=null){
                    Log.e("manual","You have Light");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)!=null){
                    Log.e("manual","You have Magnetic Field");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED)!=null){
                    Log.e("manual","You have Magnetic Field Uncalibrated");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)!=null){
                    Log.e("manual","You have Orientation");
                }
                if(sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
                    Log.e("manual","You have Accelerometer");
                }
                else
                {
                    Log.d("yikes","Yikers");
                }

            }
        });

        /*
        if(sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)!=null)
        {
            Log.ERROR("You have Gyroscope");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
            Log.ERROR("You have Accelerometer");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
            Log.ERROR("You have Ambient Temperature");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_GRAVITY)!=null){
            Log.ERROR("You have Gravity");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED)!=null){
            Log.ERROR("You have Accelerometer Uncalibrated");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED)!=null){
            Log.ERROR("You have Gyroscope Uncalibrated");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)!=null){
            Log.ERROR("You have Linear Acceleration");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)!=null){
            Log.ERROR("You have Rotation Vector");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION)!=null){
            Log.ERROR("You have Significant Motion");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            Log.ERROR("You have Step Counter");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null){
            Log.ERROR("You have Step Detector");
        }
        if(true){
            Log.ERROR(sManager.getDefaultSensor(Sensor.TYPE_ALL.toString()));
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_LIGHT)!=null){
            Log.ERROR("You have Light");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)!=null){
            Log.ERROR("You have Magnetic Field");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED)!=null){
            Log.ERROR("You have Magnetic Field Uncalibrated");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)!=null){
            Log.ERROR("You have Orientation");
        }
        if(sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
            Log.ERROR("You have Accelerometer");
        }
        else
        {
            Log.d("Yikers")
        }*/

    }



}
