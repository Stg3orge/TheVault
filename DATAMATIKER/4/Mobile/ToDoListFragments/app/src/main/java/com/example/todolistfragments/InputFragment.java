package com.example.todolistfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class InputFragment extends Fragment {



    public InputFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        final Button button = v.findViewById(R.id.addButton);

        final EditText itemInput = v.findViewById(R.id.itemInput);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String item = itemInput.getText().toString();


                itemInput.setText("");            }
        });

        return v;
    }


}
