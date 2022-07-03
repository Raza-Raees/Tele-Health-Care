package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email;
    private EditText pass;
    private TextView signup;
    private Button login;
    private String e;
    private String p;
    private Intent intent;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);

        mAuth=FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        signup = (TextView) findViewById(R.id.forgotpass);
        login = (Button) findViewById(R.id.loginbtn);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                e=email.getText().toString();
                p=pass.getText().toString();

                if(TextUtils.isEmpty(e))
                    email.setError("Enter Email");
                if(TextUtils.isEmpty(p))
                    pass.setError("Enter Password");

                  if(!TextUtils.isEmpty(e)&&!TextUtils.isEmpty(p)){

                    mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(SignIn.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {



                                email.getText().clear();
                                pass.getText().clear();
                                Toast.makeText(SignIn.this
                                        , "Sign-in Successful", Toast.LENGTH_LONG).show();

                                String uid = task.getResult().getUser().getUid();

                                database= FirebaseDatabase.getInstance();
                                database.getReference("Users").child(uid).child("userType").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int userType= snapshot.getValue(Integer.class);


                                         if(userType==0)
                                         {
                                             intent = new Intent(SignIn.this,DoctorDashboard.class);
                                             startActivity(intent);





                                         }

                                        if (userType==1)
                                        {
                                            intent = new Intent(SignIn.this,PatintTabs.class);
                                            startActivity(intent);


                                        }





                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {



                                    }
                                });








                            }

                            else
                                Toast.makeText(getApplicationContext(),"Username or Password is Incorrect",Toast.LENGTH_LONG).show();




                        }
                    });





                }




            }

        });




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(SignIn.this,SignUp.class);
                startActivity(i);
            }
        });




    }


    @Override
    public void onStart() {
        super.onStart();

         user = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mAuth.getInstance().signOut();
    }
}