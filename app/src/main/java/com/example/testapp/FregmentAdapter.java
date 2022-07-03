package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FregmentAdapter extends FragmentStateAdapter {
    public FregmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0)
           return new Patient_Dash();
        if(position==1)
        return new chat();
        if(position==2)
            return new Schedule();

        return new set();


    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
