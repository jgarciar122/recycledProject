
package com.example.recyclerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PizzaFragment();
            case 1:
                return new HamburguesaFragment();
            case 2:
                return new EnsaladaFragment();
            default:
                return new PizzaFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
