package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.Locale;

public class PaymentActivity extends AppCompatActivity {

    private TextView textViewNama, textViewAlamat, textViewNoTelpon, textViewjenisLaundry, textViewJumlahKilo, textViewJumlahHarga;
    private Button buttonBayar;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);

        databaseReference = FirebaseDatabase.getInstance().getReference("payments");

        textViewNama = findViewById(R.id.textViewNamaValue);
        textViewAlamat = findViewById(R.id.textViewAlamatValue);
        textViewNoTelpon = findViewById(R.id.textViewNoTelponValue);
        textViewjenisLaundry = findViewById(R.id.textViewjenisLaundry);
        textViewJumlahKilo = findViewById(R.id.textViewJumlahKiloValue);
        textViewJumlahHarga = findViewById(R.id.textViewJumlahHarga);
        buttonBayar = findViewById(R.id.buttonBayar);

        Bundle extras = getIntent().getExtras();
        double hargaPerKilo = 0;
        int jumlahKilo = 0;
        if (extras != null) {
            String nama = extras.getString("nama");
            String alamat = extras.getString("alamat");
            String noTelpon = extras.getString("noTelpon");
            String jenisLaundry = extras.getString("jenisLaundry");
            jumlahKilo = extras.getInt("jumlahKilo");

            textViewNama.setText(nama);
            textViewAlamat.setText(alamat);
            textViewNoTelpon.setText(noTelpon);
            textViewjenisLaundry.setText(jenisLaundry);
            textViewJumlahKilo.setText(String.valueOf(jumlahKilo));

            // Menghitung total harga berdasarkan jenis laundry dan jumlah kilo
            if (jenisLaundry.equals("Cuci Kering")) {
                hargaPerKilo = 10_000; // Harga per kilo untuk cuci kering
            } else if (jenisLaundry.equals("Cuci Setrika")) {
                hargaPerKilo = 15_000; // Harga per kilo untuk cuci setrika
            } else {
                hargaPerKilo = 20_000; // Harga per kilo untuk jenis laundry lainnya
            }
            double totalHarga = hargaPerKilo * jumlahKilo;
            textViewJumlahHarga.setText(String.valueOf(totalHarga));
        }

        double totalHarga = hargaPerKilo * jumlahKilo;

        // Format total harga ke dalam format rupiah
        Locale localeID = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(localeID);
        String totalHargaFormatted = rupiahFormat.format(totalHarga);
        textViewJumlahHarga.setText(totalHargaFormatted);

        buttonBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simpan data ke Firebase
                String nama = textViewNama.getText().toString();
                String alamat = textViewAlamat.getText().toString();
                String noTelpon = textViewNoTelpon.getText().toString();
                String jenisLaundry = textViewjenisLaundry.getText().toString();
                String jumlahKilo = textViewJumlahKilo.getText().toString();
                String jumlahHarga = textViewJumlahHarga.getText().toString();

                String paymentId = databaseReference.push().getKey();
                Payment payment = new Payment(paymentId, nama, alamat, noTelpon, jenisLaundry, jumlahKilo, jumlahHarga);
                databaseReference.child(paymentId).setValue(payment);

                Toast.makeText(PaymentActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                // Pindah ke halaman daftarHarga_activity
                Intent intent = new Intent(PaymentActivity.this, daftarHarga_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
