package com.example.travelhub;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView btv;
    ImageView hmenu;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSharedPreferences("FirstLogin",MODE_PRIVATE).edit().putBoolean("FirstUse",false).apply();

        FindViews();
        hmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home_nav) {
                    Toast.makeText(MainActivity.this, "خانه", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.settings_nav) {
                    Toast.makeText(MainActivity.this, "تنظیمات", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        VpAdapter ViewPagerAdapter = new VpAdapter(getSupportFragmentManager());
        viewPager.setAdapter(ViewPagerAdapter);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottom_nav_profile) {
                    viewPager.setCurrentItem(0);

                } else if (item.getItemId() == R.id.bottom_nav_shoping) {
                    viewPager.setCurrentItem(1);

                } else if (item.getItemId() == R.id.bottom_nav_favorite) {
                    viewPager.setCurrentItem(2);

                } else if (item.getItemId() == R.id.bottom_nav_home) {
                    viewPager.setCurrentItem(3);
                }

                return true;
            }
        });

    }

    private void FindViews() {
        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.nav_drawer);
        btv = findViewById(R.id.bottomNavigation);
        hmenu = findViewById(R.id.hmenue);
        viewPager = findViewById(R.id.ViewPagerHome);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);

        } else {
            super.onBackPressed();

        }
    }
}