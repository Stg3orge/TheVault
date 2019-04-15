package com.example.additemstolistanddisplay;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String DATABASE_NAME = "ToDoListDB";
    SQLiteDatabase mDatabase;

    ListView scView;
    EditText itemInput;

    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /* ----------------------------------------------------------------------- */

        itemInput = findViewById(R.id.itemInput);
        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, items);

        scView = findViewById(R.id.listView);
        scView.setAdapter(adapter);

        Button btnAddToList = findViewById(R.id.addButton);
        btnAddToList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addToList(v);
            }
        });

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        
    }

    public void addToList(View view){

        String item = itemInput.getText().toString();

        items.add(item);
        adapter.notifyDataSetChanged();
        itemInput.setText("");

    }


}
