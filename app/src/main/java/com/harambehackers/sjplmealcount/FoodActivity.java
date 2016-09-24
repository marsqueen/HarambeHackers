package com.harambehackers.sjplmealcount;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    ArrayList<String> foodItems;
    ArrayAdapter<String> adapter;
    HashMap<String, Integer> items;
    HashMap<String, Integer> remainingitems;
    int foodAmount;
    String foodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        foodName = "";

        ListView lv = (ListView) findViewById(R.id.listView);
        foodItems = new ArrayList<String>();
        /*foodItems.add("tacos");
        foodItems.add("hot dogs");
        foodItems.add("sriram");
        foodItems.add("harmabe");*/

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, foodItems);

        items = new HashMap<String, Integer>();
        remainingitems = new HashMap<String, Integer>();

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tview = (TextView) view;
                String name = tview.getText().toString();
                remainingitems.put(name, remainingitems.get(name) + 1);
                Toast.makeText(getApplicationContext(), name + ", has " + remainingitems.get(name), Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                getItemAmount();
                TextView tview = (TextView) (view);
                items.put(tview.getText().toString(), foodAmount);
                foodName = tview.getText().toString();


                return false;
            }
        });

    }

    public void addItem(View v){

      showProjectDialog();

    }

    private void showProjectDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Food Item");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_text = input.getText().toString();
                foodItems.add(m_text);
                remainingitems.put(m_text, 0);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void getItemAmount(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Food Item");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_text = input.getText().toString();
                Log.d("DEBUG", "Ok on dialog clicked");
                Log.d("DEBUG", m_text);
                foodAmount = Integer.parseInt(m_text);
                items.put(foodName, foodAmount);
                for (String key : items.keySet()) {
                    Log.d("DEBUG", key + " " + items.get(key));
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void foodDone(View v){
        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }

}
