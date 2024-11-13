
package com.example.recyclerapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.recyclerapp.Fragments.FragmentEnsalada;
import com.example.recyclerapp.Fragments.FragmentHamburguesa;
import com.example.recyclerapp.Fragments.FragmentPizza;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentPizza();
            case 1:
                return new FragmentHamburguesa();
            case 2:
                return new FragmentEnsalada();
            default:
                return new FragmentPizza();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
