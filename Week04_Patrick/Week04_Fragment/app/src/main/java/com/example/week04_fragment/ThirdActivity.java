package com.example.week04_fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tampilkan layout activity_second saat dibuat
        setContentView(R.layout.activity_third);

        // Menggunakan Fragment secara programmatic
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Ambil firstfragment dari activity
        Fragment firstFragment = new FirstFragment();
        fragmentTransaction.replace(R.id.third_activity_fragment_1,firstFragment);

        // Ambil secondfragment dari activity
        Fragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.third_activity_fragment_2,secondFragment);
        fragmentTransaction.commit();
    }
}
