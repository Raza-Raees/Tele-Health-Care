package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link set#newInstance} factory method to
 * create an instance of this fragment.
 */
public class set extends Fragment implements AdapterView.OnItemSelectedListener {

    private FirebaseAuth mAuth;
    private Button update;
    private EditText username;
    private EditText email;
    private EditText mobile;
    private EditText password;
    private EditText confirm;
    private EditText nPass;
    private EditText age;
    private TextView gen;
    private FirebaseDatabase database;
    private String uid;
    private DatabaseReference myref;
    private String gender;
    private String child;
    private String name;
    private String em;
    private String mob;
    private String ag;
    private Spinner marry;
    private Spinner children;
    private String marr;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String[] married;
    private String[] chldrn;

    public set() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment set.
     */
    // TODO: Rename and change types and number of parameters
    public static set newInstance(String param1, String param2) {
        set fragment = new set();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_set, container, false);
        update= (Button) rootView.findViewById(R.id.update);
        username = (EditText) rootView.findViewById(R.id.username);
        email = (EditText) rootView.findViewById(R.id.email);
        mobile = (EditText) rootView.findViewById(R.id.phone);
        password = (EditText) rootView.findViewById(R.id.password);
        nPass = (EditText) rootView.findViewById(R.id.nPass);
        confirm = (EditText) rootView.findViewById(R.id.confirm);
        age = (EditText) rootView.findViewById(R.id.age);
        marry= (Spinner) rootView.findViewById(R.id.marital);
        children= (Spinner) rootView.findViewById(R.id.children);
        gen = (TextView) rootView.findViewById(R.id.gn);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();





        married= new String[] { "Married","Unmarried"  };
        ArrayAdapter ad
                = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                married);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);



        marry.setAdapter(ad);
           marry.setOnItemSelectedListener(this);


        chldrn= new String[] { "Child","No Child" };
        ArrayAdapter aa
                = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                chldrn);

        aa.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);



        children.setAdapter(aa);
        children.setOnItemSelectedListener(this);





        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        uid=mAuth.getCurrentUser().getUid();

        myref = database.getReference("Users").child(uid);




        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                name = snapshot.child("username").getValue(String.class);
                username.setText(name);
                em = snapshot.child("email").getValue(String.class);
                email.setText(em);
                mob = snapshot.child("mobile").getValue(String.class);
                mobile.setText(mob);
                gender = snapshot.child("gender").getValue(String.class);
                gen.setText(gender);

                ag = snapshot.child("age").getValue(String.class);
                age.setText(ag);

                marr = snapshot.child("marital").getValue(String.class);



                child = snapshot.child("children").getValue(String.class);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(username.getText().toString()))
                    username.setError("Field is Empty");
                if(TextUtils.isEmpty(email.getText().toString()))
                    email.setError("Field is Empty");
                if(TextUtils.isEmpty(age.getText().toString()))
                    age.setError("Field is Empty");
                if(TextUtils.isEmpty(mobile.getText().toString()))
                    mobile.setError("Field is Empty");

                if(TextUtils.isEmpty(nPass.getText().toString())) {
                    PatientUser user = new PatientUser(username.getText().toString(), email.getText().toString(), age.getText().toString()
                            , gender, marr, child, mobile.getText().toString(), 1);
                    database = FirebaseDatabase.getInstance();
                    myref = database.getReference("Users");
                    myref.child(uid).setValue(user);

                    Toast.makeText(getContext(), "Profile Updated!", Toast.LENGTH_SHORT).show();

                }



                if(!TextUtils.isEmpty(nPass.getText().toString() ))
                {
                    if (nPass.getText().toString().length()<6)
                        nPass.setError("Password length must be 6");
                    if(TextUtils.isEmpty(confirm.getText().toString()))
                        confirm.setError("Field is empty");
                    else if( !TextUtils.equals(nPass.getText().toString(),confirm.getText().toString()))
                        Toast.makeText(getContext(), "Password doesn't match ", Toast.LENGTH_SHORT).show();
                    if(nPass.getText().toString().equals(confirm.getText().toString()))
                    {
                       final FirebaseUser Fuser= FirebaseAuth.getInstance().getCurrentUser();
                        Fuser.updatePassword(nPass.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused)
                            {
                                nPass.getText().clear();
                                confirm.getText().clear();
                                Toast.makeText(getContext(), "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                            }
                        });




                    }

                }








            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        marr = married[position];
        child = chldrn[position];



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}