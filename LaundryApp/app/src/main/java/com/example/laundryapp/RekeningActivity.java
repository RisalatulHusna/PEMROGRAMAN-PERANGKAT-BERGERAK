package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RekeningActivity extends AppCompatActivity {

    private TextView textViewNomorRekeningValue;
    private Button buttonKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekening);

        textViewNomorRekeningValue = findViewById(R.id.textViewNomorRekeningValue);

        String nomorRekening = "1234567890";

        textViewNomorRekeningValue.setText(nomorRekening);
        textViewNomorRekeningValue.setTextSize(36);

        buttonKembali = findViewById(R.id.buttonKembali);
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke halaman utama
                Intent intent = new Intent(RekeningActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
