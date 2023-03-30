package com.example.csci5115project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.csci5115project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        setSupportActionBar(binding.toolbar);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.search:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.log:
                    replaceFragment(new LogFragment());
                    break;
                case R.id.notifications:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}