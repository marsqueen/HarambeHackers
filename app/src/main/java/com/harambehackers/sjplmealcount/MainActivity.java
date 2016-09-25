package com.harambehackers.sjplmealcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btne, btnb, btnh, btna, btnj, btnt;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* btne = (Button) findViewById(R.id.buttone);
        btnb = (Button) findViewById(R.id.buttonb);
        btnh = (Button) findViewById(R.id.buttonh);
        btna = (Button) findViewById(R.id.buttona);
        btnj = (Button) findViewById(R.id.buttonj);
        btnt = (Button) findViewById(R.id.buttont); */



    }

    public void handleButtonClicked(View v){

        switch(v.getId()){
            case R.id.buttone:

                clickedLib("e");
                break;
            case R.id.buttonb:

                clickedLib("b");

                break;
            case R.id.buttonh:
                clickedLib("h");

                break;
            case R.id.buttona:
                clickedLib("a");

                break;
            case R.id.buttonj:
                clickedLib("j");

                break;
            case R.id.buttont:
                clickedLib("t");

                break;
        }

    }

    public void clickedLib(String s){

        calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println( "The date is: "+  sdf.format( date )  );

        Intent i = new Intent(this, FoodActivity.class);
        i.putExtra("com.harambehackers.sjplmealcount", s);
        startActivity(i);

    }
}
