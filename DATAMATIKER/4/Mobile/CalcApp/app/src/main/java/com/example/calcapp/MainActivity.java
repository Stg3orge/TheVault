package com.example.calcapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, buttonAdd, buttonSub, buttonEqual, buttonC, buttonMul;
    EditText numberField;
    float mValueOne, mValueTwo;
    boolean addition, mSubtract, multiplication;
    TextView textView;

    LocationManager locationManager;
    LocationListener locationListener;
    Location location;

    Criteria criteria;
    String provider;
    final static int MY_LOCATION_PERMISSION_CODE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionRequestLocation();

        numberField = findViewById(R.id.numberField);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonC = findViewById(R.id.buttonC);
        buttonMul = findViewById(R.id.buttonMul);

        textView = findViewById(R.id.locationTextView);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);
        provider = locationManager.getBestProvider(criteria, true);
        //Log.d("LOC PROV", provider );
        //textView.setText(locationManager.getBestProvider(criteria, true)); // Er Gps
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            location = locationManager.getLastKnownLocation(provider);
        }
        locationListener = new MyLocationListener(getApplicationContext(),textView);
        //textView.setText("Latitude: " + location.getLatitude() + " Altitude: " + location.getAltitude());

        locationListener.onLocationChanged(location);

        //************************************************************//
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(numberField.getText() + "7");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additionCal();
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(numberField.getText() + "");
                mSubtract = true;
                numberField.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equalsCal();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText("");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(numberField.getText() + "");
                multiplication = true;
                numberField.setText(null);
            }
        });
    }

    public void additionCal(){
        if (numberField == null) {
            numberField.setText("");
        } else {
            mValueOne = Float.parseFloat(numberField.getText() + "");
            addition = true;
            numberField.setText(null);
        }
    }

    public void equalsCal(){
        mValueTwo = Float.parseFloat(numberField.getText() + "");

        if (addition == true) {
            numberField.setText(mValueOne + mValueTwo + "");
            addition = false;
        }

        if (mSubtract == true) {
            numberField.setText(mValueOne - mValueTwo + "");
            mSubtract = false;
        }
        if(multiplication == true) {
            numberField.setText(String.valueOf(multiplicationCal(mValueOne, mValueTwo)) + "");
            multiplication = false;
        }
    }

    public float multiplicationCal(float val1, float val2){
        float res;

        res = val1 * val2;

        return res;
    }

    private void PermissionRequestLocation(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_PERMISSION_CODE);

            }
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_LOCATION_PERMISSION_CODE);

            }
        }
    }
}
