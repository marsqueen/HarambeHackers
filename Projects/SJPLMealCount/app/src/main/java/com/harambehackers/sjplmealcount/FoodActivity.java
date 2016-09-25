package com.harambehackers.sjplmealcount;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    ArrayList<String> foodItems;
    ArrayAdapter<String> adapter;
    HashMap<String, Integer> items;
    HashMap<String, Integer> remainingitems;
    int foodAmount;
    String foodName;
    String mealType;
    String library;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Intent intent = getIntent();
        String location = intent.getStringExtra("LIBRARY");
        mealType = intent.getStringExtra("MEALTYPE");
        switch(location){
            case "t":
                library = "Tully";
                break;
            case "b":
                library = "Latinoamerica";
                break;
            case "h":
                library = "Hillview";
                break;
            case "a":
                library = "Alum";
                break;
            case "j":
                library = "Joyce";
                break;
            case "e":
                library = "Educational";
                break;

        }


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("test");
       // myRef.setValue("hello tacos");

        foodName = "";

        ListView lv = (ListView) findViewById(R.id.listView);
        foodItems = new ArrayList<String>();
        /*foodItems.add("tacos");
        foodItems.add("hot dogs");
        foodItems.add("srirambe);
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

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String datee = sdf.format(date).toString();
        System.out.println( "The date is: "+  sdf.format( date )  );

        //currentamount = remainingitems
        //oldamount = items

        myRef.child(datee).child(library).child(mealType).child("orderedfood").setValue(items);
        myRef.child(datee).child(library).child(mealType).child("usedfood").setValue(remainingitems);

        Intent i = new Intent(this, DetailsActivity.class);
        i.putExtra("com.harambehackers.sjplmealcount", library);
        i.putExtra("MEALTYPE", mealType);
        startActivity(i);
    }

}
