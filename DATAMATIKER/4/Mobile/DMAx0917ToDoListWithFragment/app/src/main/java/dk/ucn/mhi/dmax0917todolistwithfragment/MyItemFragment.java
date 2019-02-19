package dk.ucn.mhi.dmax0917todolistwithfragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyItemFragment extends Fragment {

    /* Interface that we created to be able to parse a string
    through the activity from the input fragment to the list fragment */
    private NewItemListener myNewItemListener;

    public MyItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myNewItemListener = (NewItemListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_my_item, container, false);
        Button addItemButton = myView.findViewById(R.id.addItemButton);
        final EditText newItem = myView.findViewById(R.id.newItem);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myNewItem = newItem.getText().toString();
                myNewItemListener.newItemCallback(myNewItem);
                newItem.setText("");
            }
        });

        return myView;
    }

}
