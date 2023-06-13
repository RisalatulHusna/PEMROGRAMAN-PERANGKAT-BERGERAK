package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class daftarHarga_activity extends AppCompatActivity {

    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_harga);

        // Mengambil email dari Intent
        String email = getIntent().getStringExtra("email");

        // Mendapatkan referensi ke TextView email
        emailTextView = findViewById(R.id.user);

        // Menetapkan email ke TextView
        if (email != null) {
            emailTextView.setText("Hai " + email);
        }

        // Intent untuk menuju halaman Layanan
        Button layananButton = findViewById(R.id.layanan);
        layananButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(daftarHarga_activity.this, Layanan_activity.class);
                startActivity(intent);
                finish();
            }
        });

        // Intent untuk menuju halaman Akun
        Button akunButton = findViewById(R.id.Akun);
        akunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(daftarHarga_activity.this, Akun_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
