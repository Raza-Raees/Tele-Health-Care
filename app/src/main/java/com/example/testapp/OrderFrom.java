package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.zip.Inflater;

public class OrderFrom extends AppCompatActivity {

    private EditText name,email,mob,address;
    private TextView item1,item2,item3,item4;
    private FirebaseDatabase db;
    private DatabaseReference rf;
    private FirebaseUser user;
    private Delivery dev;
    private String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_from);

        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        mob = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        View rootView = getLayoutInflater().inflate(R.layout.activity_pharmacy,null);
        item1 = rootView.findViewById(R.id.dn1);
        item2 = rootView.findViewById(R.id.dn2);
        item3 = rootView.findViewById(R.id.dn3);
        item4 = rootView.findViewById(R.id.dn4);



    }

    @Override
    protected void onStart() {
        super.onStart();



    }

    public void order(View view)
    {
        if(TextUtils.isEmpty(name.getText().toString()))
            name.setError("Enter Details");
        if(TextUtils.isEmpty(email.getText().toString()))
            email.setError("Enter Details");
        if(TextUtils.isEmpty(mob.getText().toString()))
            mob.setError("Enter Details");
        if(TextUtils.isEmpty(address.getText().toString()))
            address.setError("Enter Details");

        else {

            dev = new Delivery(name.getText().toString(),email.getText().toString(),mob.getText().toString(),address.getText().toString(),item);

            db = FirebaseDatabase.getInstance();
            rf = db.getReference("Orders");
            user = FirebaseAuth.getInstance().getCurrentUser();
            rf.child(user.getUid()).setValue(dev);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your order will reach your destination in next 40 minutes.")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
        }
    }
}

class Delivery
{

    String name,email,phone,address,item;
    public Delivery() {
    }

    public Delivery(String name, String email, String phone, String address, String item) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}