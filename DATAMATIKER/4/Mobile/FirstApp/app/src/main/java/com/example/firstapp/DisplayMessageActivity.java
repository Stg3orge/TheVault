package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TEXTVIEW_STATE_KEY = "TEXTVIEW_STATE_KEY";
    public static String MY_PREFS = "MY_PREFS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        final TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        Button setTextViewBtn = findViewById(R.id.spBtn);
        setTextViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //hdhrhdh
            }
        });

        Button saveTextViewBtn = findViewById(R.id.rpBtn);
        setTextViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveString(v.getContext(), textView.getText().toString());
            }
        });
    }

    @Override
    protected void onPause() {
        TextView tv = findViewById(R.id.textView);
        saveString(this, tv.getText().toString());
        super.onPause();
    }

    @Override
    protected void onResume() {
        TextView tv = findViewById(R.id.textView);
        tv.setText(getString(this, "messageEntryKey"));
        super.onResume();
    }

    public void saveString(Context context, String value) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPrefs.edit().putString("messageEntryKey", value).apply();
    }

    public String getString(Context context, String key) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getString(key, );
    }
}
