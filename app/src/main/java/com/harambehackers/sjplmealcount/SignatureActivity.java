package com.harambehackers.sjplmealcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
    }

    public void finishProcess(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
