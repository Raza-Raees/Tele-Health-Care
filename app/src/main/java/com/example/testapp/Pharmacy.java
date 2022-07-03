package com.example.testapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pharmacy extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);


    }

    public void ordernow(View view)
    {

        Intent i = new Intent(this,OrderFrom.class);
        startActivity(i);


    }

    public void Location(View view)
    {

//        Uri gmmIntentUri = Uri.parse("geo:34.008667054199826,71.52149745140247");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        startActivity(mapIntent);



        String strUri = "http://maps.google.com/maps?q=loc:" + 34.008667054199826 + "," + 71.52149745140247 + " ()";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);



    }


}