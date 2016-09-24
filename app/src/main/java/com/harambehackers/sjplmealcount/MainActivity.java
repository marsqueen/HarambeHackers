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

                clickedLib();
                break;
            case R.id.buttonb:

                clickedLib();

                break;
            case R.id.buttonh:
                clickedLib();

                break;
            case R.id.buttona:
                clickedLib();

                break;
            case R.id.buttonj:
                clickedLib();

                break;
            case R.id.buttont:
                clickedLib();

                break;
        }

    }

    public void clickedLib(){

        calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println( "The date is: "+  sdf.format( date )  );
        Toast.makeText(getApplicationContext(),  sdf.format( date ) , Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, FoodActivity.class);
        startActivity(i);

    }
}
