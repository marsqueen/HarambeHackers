package com.harambehackers.sjplmealcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MealActivity extends AppCompatActivity {

    String library;
    Intent i;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        i = new Intent(this, FoodActivity.class);

        Intent intent = getIntent();
        library = intent.getStringExtra("com.harambehackers.sjplmealcount");

        Log.d("DEBUG", library);

        extras = new Bundle();
        extras.putString("library", library);


    }

    public void Breakfast(View v){
        extras.putString("meal", "Breakfast");
        i.putExtras(extras);
        startActivity(i);
    }
    public void AMSnack(View v){
        extras.putString("meal", "AM Snack");
        i.putExtras(extras);
        startActivity(i);


    }
    public void Lunch(View v){
        extras.putString("meal", "Lunch");
        i.putExtras(extras);
        startActivity(i);


    }
    public void PMSnack(View v){
        extras.putString("meal", "PM Snack");
        i.putExtras(extras);
        startActivity(i);


    }
    public void Supper(View v){
        extras.putString("meal", "Supper");
        i.putExtras(extras);
        startActivity(i);

    }


    public void buttonisClicked(String s){

        Intent i = new Intent(this, FoodActivity.class);

        Log.d("DEBUG", i.toString());

       /* Bundle extras = new Bundle();

        extras.putString("library", library);
        extras.putString("meal", s);

        Log.wtf("DEBUG", "Bless me young anasuri");
        i.putExtras(extras);*/

        startActivity(i);
    }

    public void handleButtonClicked(View v){

        String foodToPass = "";

        switch(v.getId()){

            case R.id.button3:
                //Log.wtf("DEBUG", "Bless me young anasuri");

                Toast.makeText(getApplicationContext(), "wow", Toast.LENGTH_LONG);

                foodToPass= "AM Snack";
                Intent i = new Intent(getApplicationContext(), FoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("library", library);
                extras.putString("meal", foodToPass);

                Log.wtf("DEBUG", "Bless me young anasuri");
                i.putExtras(extras);

                startActivity(i);
                break;

            case R.id.button4:
                foodToPass= "Supper";
                Intent j = new Intent(getApplicationContext(), FoodActivity.class);
                Bundle extras1 = new Bundle();
                extras1.putString("library", library);
                extras1.putString("meal", foodToPass);
                j.putExtras(extras1);

                startActivity(j);

                break;
            case R.id.button5:
                foodToPass= "Lunch";
                Intent k = new Intent(getApplicationContext(), FoodActivity.class);
                Bundle extras2 = new Bundle();
                extras2.putString("library", library);
                extras2.putString("meal", foodToPass);
                k.putExtras(extras2);

                startActivity(k);

                break;
            case R.id.button6:
                foodToPass= "PM Snack";
                Intent l = new Intent(getApplicationContext(), FoodActivity.class);
                Bundle extras3 = new Bundle();
                extras3.putString("library", library);
                extras3.putString("meal", foodToPass);
                l.putExtras(extras3);

                startActivity(l);

                break;
            case R.id.button7:
                foodToPass= "Breakfast";
                Intent m = new Intent(getApplicationContext(), FoodActivity.class);
                Bundle extras4 = new Bundle();
                extras4.putString("library", library);
                extras4.putString("meal", foodToPass);
                m.putExtras(extras4);

                startActivity(m);
                break;

        }


    }




}
