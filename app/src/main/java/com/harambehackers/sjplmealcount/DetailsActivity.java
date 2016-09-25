package com.harambehackers.sjplmealcount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {

    EditText wasteText;
    EditText commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    }

    public void nextPage(View v){

        Intent intent = getIntent();
        String library = intent.getStringExtra("com.harambehackers.sjplmealcount");

        wasteText = (EditText) findViewById(R.id.wasteFoodText);
        commentText = (EditText) findViewById(R.id.commentText);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String thedate = sdf.format( date );

        FirebaseDatabase fb = FirebaseDatabase.getInstance();
        DatabaseReference dbr = fb.getReference("test/" + thedate + "/" + library);

        dbr.child("wastedfood").setValue(wasteText.getText());
        dbr.child("commentText").setValue(commentText.getText());

        Intent i = new Intent(this, SignatureActivity.class);
        startActivity(i);
    }
}
