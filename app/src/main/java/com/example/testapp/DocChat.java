package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class DocChat extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_chat);

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.docchat) != null)
        {
            if(savedInstanceState !=null)
            {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.docchat,new chat(),null).commit();


        }



    }
}