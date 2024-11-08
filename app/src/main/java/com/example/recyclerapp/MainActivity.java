package com.example.recyclerapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Inicio");

        // Configurar el TabLayout y ViewPager2
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);

        // Configurar el adaptador de ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Conectar el TabLayout con el ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Pizzas");
                    break;
                case 1:
                    tab.setText("Hamburguesas");
                    break;
                case 2:
                    tab.setText("Ensaladas");
                    break;
            }
        }).attach();

        // Configurar el BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                viewPager.setCurrentItem(0);  // Cambiar al tab de Pizzas como "Inicio"
                toolbar.setTitle("Inicio");
            }
            return true;
        });

        // Cargar PrimerFragment como fragmento inicial
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }
}
