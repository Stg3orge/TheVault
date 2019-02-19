package com.example.additemstolistanddisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //String[] items;

    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ----------------------------------------------------------------------- */

        //items = getResources().getStringArray(R.array.itemList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, items);

        ListView scView = findViewById(R.id.listView);
        scView.setAdapter(adapter);


    }

    public void addToList(View view){
        EditText itemInput = findViewById(R.id.itemInput);

        String item = itemInput.getText().toString();

        items.add(item);
        adapter.notifyDataSetChanged();
        itemInput.setText("");

    }


}
