package cz.odhlasujto.odhlasujto;

/**
 * Created by martin on 29.11.14.
 */

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Note that here we are inheriting ListActivity class instead of Activity class *
 */
public class CreatePoll extends ListActivity {

    /**
     * Items entered by the user is stored in this ArrayList variable
     */
    ArrayList<String> list = new ArrayList<String>();

    /**
     * Declaring an ArrayAdapter to set items to ListView
     */
    ArrayAdapter<String> adapter;

    /**
     * Called when the activity is first created.
     */

    private static final String LOG = CreatePoll.class.getSimpleName(); //for printing out LOG msgs
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EditText edit2 = (EditText) findViewById(R.id.txtItem);
        edit2.setText("neco");
        Log.d(LOG, "Clicked on Aboutds");

        /** Setting a custom layout for the list activity */
        setContentView(R.layout.create_poll);

        /** Reference to the button of the layout main.xml */
        Button btn = (Button) findViewById(R.id.btnAdd);

        /** Defining the ArrayAdapter to set items to ListView */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        /** Defining a click event listener for the button "Add" */
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                Log.d(LOG, "Clicked on About");
                list.add(edit.getText().toString());
                edit.setText("");
                Log.d(LOG, "Clicked on About 2");
                adapter.notifyDataSetInvalidated();
            }
        };

        /** Setting the event listener for the add button */
        btn.setOnClickListener(listener);

        /** Setting the adapter to the ListView */
        setListAdapter(adapter);
    }
}
