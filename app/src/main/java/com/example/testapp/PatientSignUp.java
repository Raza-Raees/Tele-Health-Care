package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PatientSignUp extends AppCompatActivity {

    private Intent intent;
    private FirebaseAuth mAuth;
    private Button signup;
    private EditText username;
    private EditText email;
    private EditText age;
    private RadioGroup gender;
    private RadioGroup marital;
    private RadioGroup children;
    private EditText mobile;
    private EditText password;
    private EditText cPass;
    private String gen;
    private String mar;
    private String chi;

    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_sign_up);

        mAuth = FirebaseAuth.getInstance();

        signup= (Button) findViewById(R.id.SignUp);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        age = (EditText) findViewById(R.id.age);
        mobile = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        cPass = (EditText) findViewById(R.id.confirm);

        gender = (RadioGroup) findViewById(R.id.gender);
        marital = (RadioGroup) findViewById(R.id.marital);
        children = (RadioGroup) findViewById(R.id.children);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(username.getText()))
                    username.setError("Field is Empty");
                if(TextUtils.isEmpty(email.getText()))
                    email.setError("Field is Empty");
                if(TextUtils.isEmpty(age.getText()))
                    age.setError("Field is Empty");
                if(TextUtils.isEmpty(mobile.getText()))
                    mobile.setError("Field is Empty");
                if (TextUtils.isEmpty(password.getText()))
                    password.setError("Field is Empty");
                if (TextUtils.isEmpty(cPass.getText()))
                    cPass.setError("Field is Empty");
                else if (password.getText().toString().length()>=6)
                {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnCompleteListener(PatientSignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {


                                        if (password.getText().toString().equals(cPass.getText().toString())) {

                                            PatientUser user = new PatientUser(username.getText().toString(),email.getText().toString(),age.getText().toString(),gen,mar,chi,mobile.getText().toString(),1);


                                            String uid = mAuth.getCurrentUser().getUid();
                                            database = FirebaseDatabase.getInstance();
                                            myRef = database.getReference("Users");
                                            myRef.child(uid).setValue(user);
                                            Toast.makeText(PatientSignUp.this, "User Created Successfully", Toast.LENGTH_LONG).show();

                                            username.getText().clear();
                                            email.getText().clear();
                                            mobile.getText().clear();
                                            password.getText().clear();
                                            cPass.getText().clear();
                                            gender.clearCheck();
                                            marital.clearCheck();
                                            children.clearCheck();
                                        }

                                        else
                                            Toast.makeText(PatientSignUp.this, "Password Doesn't Match", Toast.LENGTH_LONG).show();
                                    }

                                    else
                                        Toast.makeText(PatientSignUp.this, "Failed to Create Account", Toast.LENGTH_LONG).show();







                                }
        }); }
                else
                    Toast.makeText(PatientSignUp.this, "Password length is short", Toast.LENGTH_LONG).show();




            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();


        FirebaseUser currentUser= mAuth.getCurrentUser();

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.male:
                        RadioButton male = (RadioButton) findViewById(R.id.male);
                        gen= male.getText().toString();
                      //  Toast.makeText(PatientSignUp.this, gen, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.female:
                        RadioButton female = (RadioButton) findViewById(R.id.female);
                        gen = female.getText().toString();
                       // Toast.makeText(PatientSignUp.this, gen, Toast.LENGTH_SHORT).show();
                        break;

                }



            }
        });



        marital.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.married:
                        RadioButton married = (RadioButton) findViewById(R.id.married);
                        mar= married.getText().toString();
                       // Toast.makeText(PatientSignUp.this, mar, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.unmarried:
                        RadioButton unmarried = (RadioButton) findViewById(R.id.unmarried);
                        mar = unmarried.getText().toString();
                      //  Toast.makeText(PatientSignUp.this, mar, Toast.LENGTH_SHORT).show();
                        break;

                }



            }
        });

        children.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.child:
                        RadioButton child = (RadioButton) findViewById(R.id.child);
                        chi= child.getText().toString();
                       // Toast.makeText(PatientSignUp.this, chi, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nochild:
                        RadioButton noChild = (RadioButton) findViewById(R.id.nochild);
                        chi = noChild.getText().toString();
                      //  Toast.makeText(PatientSignUp.this, chi, Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });




    }

    public void alreadyHaveAccount(View view) {
        intent = new Intent(PatientSignUp.this,SignIn.class);
        finish();
        startActivity(intent);
    }






}