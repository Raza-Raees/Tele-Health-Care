package com.example.testapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class DocSetting extends AppCompatActivity {

    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Button update;
    private EditText username;
    private EditText email;
    private EditText mobile;

    private EditText confirm;
    private EditText nPass;
    private EditText specialization;
    private TextView gen;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myref;
    private String gender;
    private String name;
    private String em;
    private String mob;
    private String special;
    private String clinic;
    private String hospital;
    private String hTime;
    private String cTime;
    private String hFee;
    private String cFee;
    private String about;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_setting);

        update= (Button) findViewById(R.id.update);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.phone);
        nPass = (EditText) findViewById(R.id.nPass);
        confirm = (EditText) findViewById(R.id.confirm);
        specialization = (EditText) findViewById(R.id.specialization);
        gen = (TextView) findViewById(R.id.gn);

        String uid = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        myref = database.getReference("Users").child(uid);




    }

    @Override
    protected void onStart() {
        super.onStart();

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

                special = snapshot.child("special").getValue(String.class);
                specialization.setText(special);
                clinic = snapshot.child("clinic").getValue(String.class);
                hospital = snapshot.child("hospital").getValue(String.class);
                hTime = snapshot.child("hTime").getValue(String.class);
                cTime = snapshot.child("cTime").getValue(String.class);
                hFee = snapshot.child("hFee").getValue(String.class);
                cFee = snapshot.child("cFee").getValue(String.class);
                about = snapshot.child("about").getValue(String.class);
                location = snapshot.child("location").getValue(String.class);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        update.setOnClickListener(v -> {

            if(TextUtils.isEmpty(username.getText().toString()))
                username.setError("Field is Empty");
            if(TextUtils.isEmpty(email.getText().toString()))
                email.setError("Field is Empty");
            if(TextUtils.isEmpty(specialization.getText().toString()))
                specialization.setError("Field is Empty");
            if(TextUtils.isEmpty(mobile.getText().toString()))
                mobile.setError("Field is Empty");

            if(TextUtils.isEmpty(nPass.getText().toString())) {
                DoctorUser user = new DoctorUser(username.getText().toString(), email.getText().toString(), gender,mobile.getText().toString() ,specialization.getText().toString(),clinic,hospital,cTime,hTime,cFee,hFee,about,0,location);

                myref.setValue(user);
                Toast.makeText(DocSetting.this, "Profile Updated!", Toast.LENGTH_SHORT).show();


            }



            if(!TextUtils.isEmpty(nPass.getText().toString() ))
            {
                if (nPass.getText().toString().length()<6)
                    nPass.setError("Password length must be 6");
                if(TextUtils.isEmpty(confirm.getText().toString()))
                    confirm.setError("Field is empty");
                else if( !TextUtils.equals(nPass.getText().toString(),confirm.getText().toString()))
                    Toast.makeText(DocSetting.this, "Password doesn't match ", Toast.LENGTH_SHORT).show();
                if(nPass.getText().toString().equals(confirm.getText().toString()))
                {
                    final FirebaseUser Fuser= FirebaseAuth.getInstance().getCurrentUser();
                    assert Fuser != null;
                    Fuser.updatePassword(nPass.getText().toString()).addOnSuccessListener(unused -> {
                        nPass.getText().clear();
                        confirm.getText().clear();
                        Toast.makeText(DocSetting.this, "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                    });




                }

            }




        });


    }
}