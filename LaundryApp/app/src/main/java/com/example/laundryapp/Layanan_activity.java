package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Layanan_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan);

        ImageButton imageButtonPesan = findViewById(R.id.imageButtonPesan);
        imageButtonPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Layanan_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButtonHistory = findViewById(R.id.imageButtonHistory);
        imageButtonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Layanan_activity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        Button buttonHome = findViewById(R.id.home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tambahkan logika atau perintah yang diinginkan untuk button Home
                // Misalnya, intent ke HomeActivity
                Intent intent = new Intent(Layanan_activity.this,daftarHarga_activity.class);
                startActivity(intent);
                finish();
            }
        });



        Button buttonAkun = findViewById(R.id.button3);
        buttonAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tambahkan logika atau perintah yang diinginkan untuk button Akun
                // Misalnya, intent ke AkunActivity
                Intent intent = new Intent(Layanan_activity.this,Akun_activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}