package com.example.basicbluetoothapp;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 10;
    private static final int REQUEST_ENABLE_BT = 76;

    BluetoothAdapter bluetoothAdapter;
    //Device that I want to communicate with
    BluetoothDevice bluetoothDevice;
    // Bluetooth socket to communicate with other devices
    BluetoothSocket bluetoothSocket;
    // My bluetooth socket that listens for requests
    BluetoothServerSocket bluetoothServerSocket;

    private final BroadcastReceiver receiver;

    ArrayList<String> elements = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    ListView deviceListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionRequestBluetooth();
        PermissionRequestBluetoothAdmin();
        PermissionRequestCoarseLocation();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        }

        CheckBlueToothState();

        deviceListView = findViewById(R.id.bluetoothDeviceList);

        Button btnStartDiscovery = findViewById(R.id.btnStartDiscovery);
        btnStartDiscovery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBlueToothState();

            }
        });
    }

    public void CheckBlueToothState(){
        String toastText = "";
        // skal sættes ind der hvor vi spørger om vi kan enable bluetooth
        if (bluetoothAdapter.isEnabled()) {
            String address = bluetoothAdapter.getAddress();
            String name = bluetoothAdapter.getName();
            toastText = name + " : " + "BT Enabled";
            Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        }
        else if(!bluetoothAdapter.isEnabled()) {
            toastText = "Bluetooth is not enabled";
            Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();

            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_ENABLE_BT){
            CheckBlueToothState();
        }
    }

    private void PermissionRequestBluetooth(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BLUETOOTH)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.BLUETOOTH)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BLUETOOTH}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }
    }

    private void PermissionRequestBluetoothAdmin(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BLUETOOTH_ADMIN)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.BLUETOOTH_ADMIN)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BLUETOOTH_ADMIN}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }
    }

    private void PermissionRequestCoarseLocation(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }
    }
}
