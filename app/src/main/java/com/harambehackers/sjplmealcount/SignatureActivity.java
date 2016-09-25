package com.harambehackers.sjplmealcount;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kyanogen.signatureview.SignatureView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SignatureActivity extends AppCompatActivity {

    SignatureView signatureView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        signatureView = (SignatureView) findViewById(R.id.signature_view);


    }

    public void finishProcess(View v){

        Bitmap bitmap = signatureView.getSignatureBitmap();
        storeImage(bitmap);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    /*private void storeImage(Bitmap image) {

        File pictureFile = new File("/storage/4FAC-8D63/SV_Season2/signature.png");
        if (pictureFile == null) {
            Log.d("DEBUG",
                    "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d("DEBUG", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("DEBUG", "Error accessing file: " + e.getMessage());
        }
    }*/

}
