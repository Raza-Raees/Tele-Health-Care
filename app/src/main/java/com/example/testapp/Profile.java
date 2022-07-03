package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    private TextView name;
    private EditText clinic;
    private EditText hosp;
    private EditText ctime;
    private EditText htime;
    private EditText cfees;
    private EditText hfees;
    private TextView email;
    private TextView mobile;
    private TextView specialization;
    private TextView gps;
    private EditText about;
    private String gender;
    private String username;
    private String emailadd;
    private String mob;
    private String special;
    private String cli;
    private String hos;
    private String cT;
    private String hT;
    private String cF;
    private String hF;
    private String ab;
    private String location;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private String uid;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.username);
        clinic = (EditText) findViewById(R.id.clinic);
        hosp = (EditText) findViewById(R.id.hospital);
        ctime = (EditText) findViewById(R.id.cTiming);
        htime = (EditText) findViewById(R.id.hTiming);
        cfees = (EditText) findViewById(R.id.clinicFee);
        hfees = (EditText) findViewById(R.id.hospitalFee);
        email = (TextView) findViewById(R.id.email);
        mobile = (TextView) findViewById(R.id.phone);
        about = (EditText) findViewById(R.id.about);
        specialization = (TextView) findViewById(R.id.specialization);
        gps = (TextView) findViewById(R.id.gps);




        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();




        uid=mAuth.getCurrentUser().getUid();


        myref = database.getReference("Users").child(uid);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                 username = dataSnapshot.child("username").getValue(String.class);
                 emailadd = dataSnapshot.child("email").getValue(String.class);
                 gender = dataSnapshot.child("gender").getValue(String.class);
                 mob = dataSnapshot.child("mobile").getValue(String.class);
                 special = dataSnapshot.child("special").getValue(String.class);
                 cli = dataSnapshot.child("clinic").getValue(String.class);
                 hos = dataSnapshot.child("hospital").getValue(String.class);
                 cT = dataSnapshot.child("cTime").getValue(String.class);
                 hT = dataSnapshot.child("hTime").getValue(String.class);
                 cF = dataSnapshot.child("cFee").getValue(String.class);
                 hF = dataSnapshot.child("hFee").getValue(String.class);
                 ab = dataSnapshot.child("about").getValue(String.class);
                 location =dataSnapshot.child("location").getValue(String.class);



                name.setText(username);
                email.setText(emailadd);
                mobile.setText(mob);
                specialization.setText(special);
                clinic.setText(cli);
                hosp.setText(hos);
                ctime.setText(cT);
                htime.setText(hT);
                cfees.setText(cF);
                hfees.setText(hF);
                about.setText(ab);
                gps.setText(location);





            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        submit = (Button) findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(TextUtils.isEmpty(clinic.getText()))
                    clinic.setError("Field is Empty");
                DoctorUser user = new DoctorUser(username,emailadd,
                     gender,mob,special,clinic.getText().toString(),hosp.getText().toString()
                        ,ctime.getText().toString(),htime.getText().toString(),cfees.getText().toString(),hfees.getText().toString(),about.getText().toString(),0,gps.getText().toString());

                database = FirebaseDatabase.getInstance();
                myref = database.getReference("Users");
                myref.child(uid).setValue(user);

                Toast.makeText(Profile.this,"Profile Updated!",Toast.LENGTH_SHORT).show();




            }
        });




    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    public void location(View view) {

        String strUri = "http://maps.google.com/maps?q=loc:" + 33.9508592 + "," + 71.4323065 + " ()";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Save your location Location")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things

                        gps.setText("Habib Medical Center");
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();






    }
}