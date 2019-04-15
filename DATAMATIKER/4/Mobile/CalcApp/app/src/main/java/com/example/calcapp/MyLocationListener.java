package com.example.calcapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyLocationListener implements LocationListener {

    Context context;
    TextView tv;

    public MyLocationListener(Context c, TextView v) {
        this.context = c;
        this.tv = v;
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(context, "SEARCHING...", Toast.LENGTH_LONG).show();
        tv.setText("Location 'altitude: " + location.getAltitude() + " latitude: " + location.getLatitude() + " longitude" + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
