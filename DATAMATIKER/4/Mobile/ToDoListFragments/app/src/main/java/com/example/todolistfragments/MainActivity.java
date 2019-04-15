package com.example.todolistfragments;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class MainActivity extends FragmentActivity implements NewItemListener{

    private ArrayList<String> items = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.inputfield, new InputFragment());
        //fragmentTransaction.replace(R.id.listfield, new ListFragment());
        //fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commit();

        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, items);

        final EditText itemInput = findViewById(R.id.itemInput);
        scView = findViewById(R.id.listView);
        scView.setAdapter(adapter);
    }

    @Override
    public void newItemCallback(String newItemString) {
        items.add(newItemString);
        adapter.notifyDataSetChanged();
    }
}
