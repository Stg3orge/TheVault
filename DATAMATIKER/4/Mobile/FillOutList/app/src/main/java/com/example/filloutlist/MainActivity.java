package com.example.filloutlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter;

        String[] colorsArray = getResources().getStringArray(R.array.colors);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, colorsArray);

        AutoCompleteTextView acColorsView = findViewById(R.id.autoCompleteColorsList);

        acColorsView.setThreshold(1);

        acColorsView.setAdapter(adapter);
    }


}
