package com.example.testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
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

import java.text.BreakIterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Patient_Dash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Patient_Dash extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private DrawerLayout drawerLayout;
    private Button draw;
    private TextView name;
    private NavigationView nv;
    private String uid;

    private Button suggest;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private ImageView img;
    private ImageView phar;
    private Button sug;

    private RadioButton headache;
    private RadioButton bodypain;
    private RadioButton fever;
    private RadioButton diarrhea;
    private RadioButton constipation;
    private RadioButton urination;
    private ImageView recom;


    private TextView dn1;
    private TextView dn1time;
    private TextView dn2;
    private TextView dn2time;
    private TextView dn3;
    private TextView dn3time;
    private TextView dn4;
    private TextView dn4time;
    private TextView sp1,sp2,sp3,sp4;

    private  final FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference rf = null;


    public Patient_Dash()
    {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Patient_Dash.
     */
    // TODO: Rename and change types and number of parameters
    public static Patient_Dash newInstance(String param1, String param2) {
        Patient_Dash fragment = new Patient_Dash();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_patient__dash, container, false);
        img=(ImageView) rootView.findViewById(R.id.dp);
        drawerLayout = (DrawerLayout) rootView.findViewById(R.id.drawer);
        draw = (Button) rootView.findViewById(R.id.drawerBtn);
        nv = (NavigationView) rootView.findViewById(R.id.nv);
        name = (TextView) rootView.findViewById(R.id.name);
        sug = (Button) rootView.findViewById(R.id.suggest1);
        phar=(ImageView)rootView.findViewById(R.id.pharmacy);

        headache=(RadioButton) rootView.findViewById(R.id.headache);
        bodypain=(RadioButton) rootView.findViewById(R.id.bodypain);
        fever=(RadioButton) rootView.findViewById(R.id.fever);
        diarrhea=(RadioButton) rootView.findViewById(R.id.diarrhea);
        constipation=(RadioButton) rootView.findViewById(R.id.constipation);
        urination=(RadioButton) rootView.findViewById(R.id.urination);
        recom=(ImageView) rootView.findViewById(R.id.recommendDoctor);

        dn1 = (TextView) rootView.findViewById(R.id.dn1);
        dn1time = (TextView) rootView.findViewById(R.id.dn1time);
        dn2 = (TextView) rootView.findViewById(R.id.dn2);
        dn2time = (TextView) rootView.findViewById(R.id.dn2time);
        dn3 = (TextView) rootView.findViewById(R.id.dn3);
        dn3time = (TextView) rootView.findViewById(R.id.dn3time);
        dn4 = (TextView) rootView.findViewById(R.id.dn4);
        dn4time = (TextView) rootView.findViewById(R.id.dn4time);

        sp1 = (TextView) rootView.findViewById(R.id.sp1);
        sp2 = (TextView) rootView.findViewById(R.id.sp2);
        sp3 = (TextView) rootView.findViewById(R.id.sp3);
        sp4 = (TextView) rootView.findViewById(R.id.sp4);

        return rootView;
       // return inflater.inflate(R.layout.fragment_patient__dash, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
     final FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        uid=mAuth.getCurrentUser().getUid();

        myref = database.getReference("Users").child(uid);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String value = snapshot.child("username").getValue(String.class);
           //   Toast.makeText(DoctorDashboard.this, value, Toast.LENGTH_SHORT).show();
                name.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });



        nv.setNavigationItemSelectedListener(this);

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });


        dr1();
        dr2();
        dr3();
        dr4();


        sug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if(headache.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("TAKE PANADOL")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

               //     Toast.makeText(getActivity(), "Take Panadol", Toast.LENGTH_LONG).show();

                }
                if(bodypain.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("TAKE Brufen")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                if(fever.isChecked())
                {    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("TAKE Panadol")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
                if(diarrhea.isChecked())
                {    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("TAKE Flagyl")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
                if(constipation.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("TAKE Skilax Drop (10-15 drops in 1 Glass water)")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                if(urination.isChecked())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("TAKE Cranmax Sachet (1 Sachet in 1 Glass water)" +
                                    "or Focil ultra in 1 Glass water")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }


            }
        });


        phar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getContext(),Pharmacy.class);
                startActivity(i);
            }
        });


recom.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
            Intent i = new Intent(getContext(),RecommendD.class);
            startActivity(i);
    }
});



    }

    @Override
    public void onResume() {
        super.onResume();
         drawerLayout.closeDrawer(GravityCompat.START,false);
        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();



        if(id==R.id.signout)
        {
            mAuth.signOut();
            getActivity().onBackPressed();
            Toast.makeText(getContext(), "Sign Out!", Toast.LENGTH_SHORT).show();

        }


        return false;
    }

    public void dr1()
    {





        rf = db.getReference("Doctor").child("B2nnr3tz46RcofEyyRnXKjegul62");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                dn1.setText(v);
                String t = snapshot.child("hTime").getValue().toString();
                dn1time.setText(t);
                String s = snapshot.child("special").getValue().toString();
                sp1.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void dr2()
    {




        rf = db.getReference("Doctor").child("ZwnEn04lemXUn6j7ogb9fQ1pg1J3");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                dn2.setText(v);
                String t = snapshot.child("hTime").getValue().toString();
                dn2time.setText(t);
                String s = snapshot.child("special").getValue().toString();
                sp2.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void dr3()
    {




        rf = db.getReference("Doctor").child("cRTUDgXvVNbBp48fQxjERqHKEPB3");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                dn3.setText(v);
                String t = snapshot.child("hTime").getValue().toString();
                dn3time.setText(t);
                String s = snapshot.child("special").getValue().toString();
                sp3.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void dr4()
    {



        rf = db.getReference("Doctor").child("uWK9IaUTmUVxFosa5V9GSpdSkml1");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String v = snapshot.child("username").getValue().toString();
                dn4.setText(v);
                String t = snapshot.child("hTime").getValue().toString();
                dn4time.setText(t);
                String s = snapshot.child("special").getValue().toString();
                sp4.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }







}