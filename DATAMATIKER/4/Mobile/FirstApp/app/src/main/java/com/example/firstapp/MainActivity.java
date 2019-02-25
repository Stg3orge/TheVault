package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TEXTVIEW_STATE_KEY = "TEXTVIEW_STATE_KEY";
    public static String MY_PREFS = "MY_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TextView textView = findViewById(R.id.bombTextView);

        SharedPreferences prefs = this.getSharedPreferences(
                MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        textView.setText("THIS IS BOMB!");

        editor.putString("bombEntryValue", textView.getText().toString());
        editor.apply();

        onSaveInstanceState(savedInstanceState);
        */

        Button sendButton = findViewById(R.id.button2);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage(v);
            }
        });
    }
    /*
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        TextView bombTextView =findViewById(R.id.bombTextView);
        saveInstanceState.putString(TEXTVIEW_STATE_KEY, bombTextView.getText().toString());
        super.onSaveInstanceState(saveInstanceState);
    }*/

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
