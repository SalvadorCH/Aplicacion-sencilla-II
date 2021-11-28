package com.example.ejerciciopractico;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CategoryAdapter extends FragmentStateAdapter {


    public CategoryAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fragmentManager, @NonNull @org.jetbrains.annotations.NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0:  return new FragmentA();
            case 1:  return new FragmentB();
            default: return new FragmentC();
        }

    }
    
    @Override
    public int getItemCount() {
        return 3;
    }
}
