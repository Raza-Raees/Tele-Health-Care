package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class DoctorDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Button draw;
    private TextView name;
    private TextView specialization;
    private NavigationView nv;
    private String username;
    private String email;
    private String special;
    private String uid;
    private Intent intent;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myref;

    private TextView pn1;
    private TextView pn1time;
    private TextView pn2;
    private TextView pn2time;
    private TextView pn3;
    private TextView pn3time;
    private TextView pn4;
    private TextView pn4time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_dashboard);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        draw = (Button) findViewById(R.id.drawerBtn);
        nv = (NavigationView) findViewById(R.id.nv);
        name = (TextView) findViewById(R.id.name);
        specialization = (TextView) findViewById(R.id.specialization);

        pn1 = (TextView) findViewById(R.id.pn1);
        pn1time = (TextView) findViewById(R.id.pn1time);
        pn2 = (TextView) findViewById(R.id.pn2);
        pn2time = (TextView) findViewById(R.id.pn2time);
        pn3 = (TextView) findViewById(R.id.pn3);
        pn3time = (TextView) findViewById(R.id.pn3time);
        pn4 = (TextView) findViewById(R.id.pn4);
        pn4time = (TextView) findViewById(R.id.pn4time);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();





        uid=mAuth.getCurrentUser().getUid();


       myref = database.getReference("Users").child(uid);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.child("username").getValue(String.class);
             //   Toast.makeText(DoctorDashboard.this, value, Toast.LENGTH_SHORT).show();
                name.setText(value);
                String value1 = dataSnapshot.child("special").getValue(String.class);
                specialization.setText(value1);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        name.setText(username);

        nv.setNavigationItemSelectedListener(this);


        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        pt1();
        pt2();
        pt3();
        pt4();
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawerLayout.closeDrawer(GravityCompat.START,false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        if(id==R.id.profile)
        {
            intent = new  Intent(DoctorDashboard.this,Profile.class);
            startActivity(intent);
        }

        if(id==R.id.chat)
        {
            intent = new Intent(DoctorDashboard.this,DocChat.class);
            startActivity(intent);

        }

        if(id==R.id.settings)
        {
            intent = new Intent(DoctorDashboard.this,DocSetting.class);
            startActivity(intent);
        }

        if(id==R.id.signout)
        {
            mAuth.signOut();
            finish();
            Toast.makeText(this, "Sign Out!", Toast.LENGTH_SHORT).show();
        }


        return false;
    }


    public void pt1()
    {
        final FirebaseDatabase db;
        final DatabaseReference rf;

        db = FirebaseDatabase.getInstance();



        rf = db.getReference("Patient").child("6WY1q9p4QnhKxwfz1Egj2uz99OJ3");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                pn1.setText(v);
                String t = snapshot.child("gender").getValue().toString();
                pn1time.setText(t);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }


    public void pt2()
    {
        final FirebaseDatabase db;
        final DatabaseReference rf;

        db = FirebaseDatabase.getInstance();



        rf = db.getReference("Patient").child("6vrDZjswB5PXndnc63tOpfvcOs22");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                pn2.setText(v);
                String t = snapshot.child("gender").getValue().toString();
                pn2time.setText(t);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void pt3()
    {
        final FirebaseDatabase db;
        final DatabaseReference rf;

        db = FirebaseDatabase.getInstance();



        rf = db.getReference("Patient").child("B6Da64JDS5S0NWrUwn1QGta9hCu1");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                pn3.setText(v);
                String t = snapshot.child("gender").getValue().toString();
                pn3time.setText(t);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void pt4()
    {
        final FirebaseDatabase db;
        final DatabaseReference rf;

        db = FirebaseDatabase.getInstance();



        rf = db.getReference("Patient").child("FRQQVPMUkyczx4vsOI4tIporKmq1");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                pn4.setText(v);
                String t = snapshot.child("gender").getValue().toString();
                pn4time.setText(t);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }





}