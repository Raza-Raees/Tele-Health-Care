package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

public class DoctorSignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Intent intent;
    private FirebaseAuth mAuth;
    private Button signup;
    private EditText username;
    private EditText email;
    private RadioGroup rg;
    private EditText mobile;
    private EditText password;
    private String special;
    private EditText cPass;
    private String gender;
    private Spinner specialspin;
    private String[] ss;

    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_sign_up);

        mAuth = FirebaseAuth.getInstance();
        signup= (Button) findViewById(R.id.SignUp);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        cPass = (EditText) findViewById(R.id.confirm);
        rg = (RadioGroup) findViewById(R.id.gender);
        specialspin=(Spinner)findViewById(R.id.specialization);


//        special=(EditText)findViewById(R.id.specialization);
        ss = new String[] { "General Physician","ENT","Physiotherapist","Neurologist","Cardiologists","Gynecologists","Orthopedic"  };
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                ss);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);



        specialspin.setAdapter(ad);

        specialspin.setOnItemSelectedListener(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(TextUtils.isEmpty(username.getText()))
                    username.setError("Field is Empty");
                if(TextUtils.isEmpty(email.getText()))
                    email.setError("Field is Empty");
                if(TextUtils.isEmpty(mobile.getText()))
                    mobile.setError("Field is Empty");
                if (TextUtils.isEmpty(password.getText()))
                    password.setError("Field is Empty");
                if (TextUtils.isEmpty(cPass.getText()))
                    cPass.setError("Field is Empty");
                else if (password.getText().toString().length()>=6)
                {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnCompleteListener(DoctorSignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {


                                        if (password.getText().toString().equals(cPass.getText().toString())) {

                                            DoctorUser user = new DoctorUser(username.getText().toString(), email.getText().toString(), gender,mobile.getText().toString() ,special,"","","","","","","",0,"");

                                            String uid = mAuth.getCurrentUser().getUid();
                                            database = FirebaseDatabase.getInstance();
                                            myRef = database.getReference("Users");
                                            myRef.child(uid).setValue(user);
                                            Toast.makeText(DoctorSignUp.this, "User Created Successfully", Toast.LENGTH_LONG).show();

                                            username.getText().clear();
                                            email.getText().clear();
                                            mobile.getText().clear();
                                            password.getText().clear();
                                            cPass.getText().clear();
                                         //   special.getText().clear();
                                            rg.clearCheck();
                                        }

                                        else
                                            Toast.makeText(DoctorSignUp.this, "Password Doesn't Match", Toast.LENGTH_LONG).show();
                                    }

                                    else
                                        Toast.makeText(DoctorSignUp.this, "Failed to Create Account", Toast.LENGTH_LONG).show();


                                }
                            });

                }
                else
                    Toast.makeText(DoctorSignUp.this, "Password length is short", Toast.LENGTH_LONG).show();




            }
        });

    }



    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser= mAuth.getCurrentUser();


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.male:
                        RadioButton male = (RadioButton) findViewById(R.id.male);
                        gender= male.getText().toString();
                        //Toast.makeText(DoctorSignUp.this, gender, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.female:
                        RadioButton female = (RadioButton) findViewById(R.id.female);
                        gender = female.getText().toString();
                        //Toast.makeText(DoctorSignUp.this, gender, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });


    }

    public void alreadyHaveAccount(View view)
    {


        intent = new Intent(DoctorSignUp.this,SignIn.class);
        finish();
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        special= ss[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}