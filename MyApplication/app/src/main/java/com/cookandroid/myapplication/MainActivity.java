package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentHome()).commit();
                        break;
                    case R.id.item_calendar_today:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentCalendarToday()).commit();
                        break;
                    case R.id.item_notifications:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentNotification()).commit();
                        break;
                    case R.id.item_person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentPerson()).commit();
                        break;
                }

                return true;
            }
        });
    }
}