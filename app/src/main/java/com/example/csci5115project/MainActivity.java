package com.example.csci5115project;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.csci5115project.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    List<Comment> commentList;
    BluetoothComment btFragment = new BluetoothComment();
    SmartphoneComment spFragment = new SmartphoneComment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btFragment.commentList = new ArrayList<>();
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

        //initializing the productlist
        commentList = new ArrayList<>();
        commentList.add(new Comment(242,22,"The Google Pixel is an example of forced obsolescence", "Jane Smith"));
        commentList.add(new Comment(222,111,"The Google Pixel is an example of forced obsolescence", "Jane Smithy"));
        commentList.add(new Comment(112,2,"The Google Pixel is an example of forced obsolescence", "Janey Smith"));
        btFragment.commentList=commentList;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    public BluetoothComment getBtFragment() {
        return btFragment;
    }
}