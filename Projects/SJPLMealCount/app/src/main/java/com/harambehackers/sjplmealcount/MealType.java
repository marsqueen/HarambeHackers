package com.harambehackers.sjplmealcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MealType extends AppCompatActivity {

    String library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_type);
        Intent i = getIntent();
        library = i.getStringExtra("com.harambehackers.sjplmealcount");

    }

    public void mealButton(View v){

        String mealType="";
        switch(v.getId()){
            case R.id.button2:
                mealType = "Breakfast";
                break;
            case R.id.button3:
                mealType = "AM Snack";
                break;
            case R.id.button4:
                mealType = "Lunch";
                break;
            case R.id.button5:
                mealType = "PM Snack";
                break;
            case R.id.button6:
                mealType = "Supper";
                break;
        }
        Intent intent = new Intent(this, FoodActivity.class);
        intent.putExtra("LIBRARY", library);
        intent.putExtra("MEALTYPE", mealType);
        startActivity(intent);

    }


}
