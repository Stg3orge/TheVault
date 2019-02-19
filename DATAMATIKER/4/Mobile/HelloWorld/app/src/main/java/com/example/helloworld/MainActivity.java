package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Hey", "LOL");
        Log.w("Big Dig", "LOGMSG");
        Log.e("RADIO", "NOT WORKING");
        setContentView(R.layout.activity_main);
    }
}
