package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama, editTextAlamat, editTextNoTelpon, editTextJumlahKilo;
    private Spinner spinnerLaundry;
    private Button buttonPesan;

    private List<String> daftarHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        editTextNoTelpon = findViewById(R.id.editTextNoTelpon);
        editTextJumlahKilo = findViewById(R.id.editTextJumlahKilo);

        spinnerLaundry = findViewById(R.id.spinnerJenisLaundry);
        buttonPesan = findViewById(R.id.buttonPesan);


        // Daftar Jenis Laundry
        List<String> jenisLaundry = new ArrayList<>();
        jenisLaundry.add("Cuci Biasa");
        jenisLaundry.add("Cuci Kering");
        jenisLaundry.add("Cuci Setrika");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jenisLaundry);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLaundry.setAdapter(spinnerAdapter);

        // Daftar Harga
        daftarHarga = new ArrayList<>();
        daftarHarga.add("Cuci Biasa: Rp 10.000/kilo");
        daftarHarga.add("Cuci Kering: Rp 15.000/kilo");
        daftarHarga.add("Cuci Setrika: Rp 20.000/kilo");

        // Batasi editTextNoTelpon hanya untuk angka
        editTextNoTelpon.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12),
                new InputFilter() {
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        for (int i = start; i < end; i++) {
                            if (!Character.isDigit(source.charAt(i))) {
                                return "";
                            }
                        }
                        return null;
                    }
                }
        });

        // Batasi editTextJumlahKilo hanya untuk angka
        editTextJumlahKilo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(5),
                new InputFilter() {
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        for (int i = start; i < end; i++) {
                            if (!Character.isDigit(source.charAt(i))) {
                                return "";
                            }
                        }
                        return null;
                    }
                }
        });

        buttonPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String alamat = editTextAlamat.getText().toString();
                String noTelpon = editTextNoTelpon.getText().toString();
                String jenisLaundry = spinnerLaundry.getSelectedItem().toString();
                String jumlahKiloText = editTextJumlahKilo.getText().toString();

                if (nama.isEmpty() || alamat.isEmpty() || noTelpon.isEmpty() || jumlahKiloText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Harap isi semua form", Toast.LENGTH_SHORT).show();
                    return; // Stop execution if any form is empty
                }

                int jumlahKilo = Integer.parseInt(jumlahKiloText);

                Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("alamat", alamat);
                intent.putExtra("noTelpon", noTelpon);
                intent.putExtra("jenisLaundry", jenisLaundry);
                intent.putExtra("jumlahKilo", jumlahKilo);
                startActivity(intent);
            }
        });



    }
}
