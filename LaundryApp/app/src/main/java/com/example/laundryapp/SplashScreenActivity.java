package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 3000; // Durasi tampilan Splash Screen dalam milidetik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Menunda pemindahan ke MainActivity menggunakan Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Pindah ke MainActivity setelah waktu yang ditentukan
                Intent intent = new Intent(SplashScreenActivity.this, Login_Activity.class);
                startActivity(intent);
                finish(); // Menutup Splash Screen Activity agar tidak dapat kembali dengan tombol back
            }
        }, SPLASH_TIMEOUT);
    }
}
