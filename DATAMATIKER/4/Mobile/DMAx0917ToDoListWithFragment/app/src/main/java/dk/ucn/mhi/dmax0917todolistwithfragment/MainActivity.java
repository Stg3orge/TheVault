package dk.ucn.mhi.dmax0917todolistwithfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewItemListener {
    private ArrayList<String> myTodoListModel = new ArrayList<>();
    private ArrayAdapter<String> myArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, myTodoListModel);
        FragmentManager fm = getSupportFragmentManager();
        ListFragment myToDoList = (ListFragment)fm.findFragmentById(R.id.myListFragmentXML);
        myToDoList.setListAdapter(myArrayAdapter);
    }

    @Override
    public void newItemCallback(String newItemString) {
        myTodoListModel.add(newItemString);
        myArrayAdapter.notifyDataSetChanged();
    }
}
